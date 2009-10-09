package org.codelabor.system.file.servlets;

import static org.codelabor.system.Constants.AFFECTED_ROW_COUNT_KEY;
import static org.codelabor.system.Constants.FILE_KEY;
import static org.codelabor.system.Constants.FILE_LIST_KEY;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileCleaningTracker;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.file.listeners.FileUploadProgressListener;
import org.codelabor.system.file.managers.FileManager;
import org.codelabor.system.utils.RequestUtil;
import org.codelabor.system.utils.UploadUtil;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import anyframe.common.util.StringUtil;
import anyframe.core.idgen.IIdGenerationService;
import anyframe.core.properties.IPropertiesService;

public class FileUploadServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6060491747750865553L;
	private final Log log = LogFactory.getLog(FileUploadServlet.class);

	protected static final String contentType = "Application/octet-stream";
	protected static final String responseHeaderName = "Content-Disposition";

	protected ServletConfig servletConfig;
	protected String parameterName;
	protected String forwardPathUpload;
	protected String forwardPathDownload;
	protected String forwardPathList;
	protected String forwardPathRead;
	protected String forwardPathDelete;
	protected FileCleaningTracker fileCleaningTracker;
	protected FileUploadProgressListener fileUploadProgressListener;

	public enum Parameter {
		upload, download, list, read, delete
	};

	// service
	protected WebApplicationContext ctx;
	protected FileManager fileManager;
	protected IPropertiesService propertiesService;
	protected IIdGenerationService uniqueFileNameGenerationService;

	// configuration
	protected String characterEncoding = "UTF-8";
	protected boolean isRename = true;
	protected int sizeThreshold = DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD;
	protected long fileSizeMax = 1024 * 1024 * 10;
	protected long requestSizeMax = 1024 * 1024 * 100;
	protected String realRepositoryPath = System.getProperty("user.dir");
	protected String tempRepositoryPath = System.getProperty("java.io.tmpdir");
	protected RepositoryType repositoryType = RepositoryType.FILE_SYSTEM;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// get init param
		servletConfig = config;
		parameterName = config.getInitParameter("parameterName");
		forwardPathUpload = config.getInitParameter("forwardPathUpload");
		forwardPathDownload = config.getInitParameter("forwardPathDownload");
		forwardPathList = config.getInitParameter("forwardPathList");
		forwardPathRead = config.getInitParameter("forwardPathRead");
		forwardPathDelete = config.getInitParameter("forwardPathDelete");

		// set service
		ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		fileManager = (FileManager) ctx.getBean("fileManager");
		propertiesService = (IPropertiesService) ctx
				.getBean("propertiesService");
		uniqueFileNameGenerationService = (IIdGenerationService) ctx
				.getBean("uniqueFileNameGenerationService");

		// overwrite configuration
		characterEncoding = propertiesService.getString(
				"file.default.character.encoding", characterEncoding);
		isRename = propertiesService.getBoolean("file.default.rename.flag",
				isRename);
		sizeThreshold = propertiesService.getInt(
				"file.default.file.size.threshold", sizeThreshold);
		fileSizeMax = propertiesService.getLong("file.default.file.size.max",
				fileSizeMax);
		requestSizeMax = propertiesService.getLong(
				"file.default.request.size.max", requestSizeMax);
		realRepositoryPath = propertiesService.getString(
				"file.default.real.repository.path", realRepositoryPath);
		tempRepositoryPath = propertiesService.getString(
				"file.default.temp.repository.path", tempRepositoryPath);
		repositoryType = RepositoryType
				.valueOf(propertiesService.getString(
						"file.default.real.repository.type", repositoryType
								.toString()));

		// set file listener / tracker
		fileCleaningTracker = FileCleanerCleanup.getFileCleaningTracker(config
				.getServletContext());
		fileUploadProgressListener = new FileUploadProgressListener();
	}

	protected String getUniqueFileName() throws Exception {
		return uniqueFileNameGenerationService.getNextStringId();
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String parameterValue = request.getParameter(parameterName);
			switch (Parameter.valueOf(parameterValue)) {
			case upload:
				upload(request, response);
				break;
			case download:
				download(request, response);
				break;
			case list:
				list(request, response);
				break;
			case delete:
				delete(request, response);
				break;
			case read:
				read(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void processParameters(Map<String, Object> paramMap)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(paramMap);
		}
	}
	
	protected String stripPathInfo(String realFileNameWithPath) {
		int lastIndex = realFileNameWithPath.lastIndexOf(System.getProperty("file.separator"));
		int beginIndex = (lastIndex > 0)? lastIndex+1: 0;
		String realFileName = realFileNameWithPath.substring(beginIndex);
		
		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("realFileNameWithPath: ").append(realFileNameWithPath);
			sb.append(", realFileName: ").append(realFileName);
			log.debug(sb.toString());
		}
		return realFileName;
	}

	protected FileDTO processFile(RepositoryType repositoryType,
			FileItem fileItem) throws Exception {
		if (fileItem.getName() == null || fileItem.getName().length() == 0)
			return null;
				
		// set DTO
		FileDTO fileDTO = new FileDTO();
		fileDTO.setRealFileName(stripPathInfo(fileItem.getName()));
		fileDTO.setUniqueFileName(getUniqueFileName());
		fileDTO.setContentType(fileItem.getContentType());
		fileDTO.setRepositoryPath(realRepositoryPath);
		if (log.isDebugEnabled()) {
			log.debug(fileDTO);
		}
		UploadUtil.processFile(repositoryType, fileItem.getInputStream(),
				fileDTO);
		return fileDTO;
	}

	protected void dispatch(HttpServletRequest request,
			HttpServletResponse response, String path) throws Exception {
		if (log.isDebugEnabled()) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("dispatch path: ").append(path);
			log.debug(stringBuilder.toString());
		}
		RequestDispatcher dispatcher = servletConfig.getServletContext()
				.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void upload(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		Map<String, Object> paramMap = RequestUtil.getParameterMap(request);

		RepositoryType acceptedRepositoryType = repositoryType;
		String tempRepositoryType = (String) paramMap.get("repositoryType");
		if (StringUtil.isNotEmpty(tempRepositoryType)) {
			acceptedRepositoryType = RepositoryType.valueOf(tempRepositoryType);
		}

		if (isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(sizeThreshold);
			factory.setRepository(new File(tempRepositoryPath));
			factory.setFileCleaningTracker(fileCleaningTracker);

			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(fileSizeMax);
			upload.setSizeMax(requestSizeMax);
			upload.setHeaderEncoding(characterEncoding);
			upload.setProgressListener(fileUploadProgressListener);
			try {
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();

				while (iter.hasNext()) {
					FileItem item = iter.next();
					if (log.isDebugEnabled()) {
						log.debug(item);
					}
					FileDTO fileDTO = null;
					if (item.isFormField()) {
						paramMap.put(item.getFieldName(), item
								.getString(characterEncoding));
					} else {
						fileDTO = processFile(acceptedRepositoryType, item);
					}
					if (fileDTO != null)
						fileManager.insertFile(fileDTO);
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			paramMap = RequestUtil.getParameterMap(request);
		}
		try {
			processParameters(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dispatch(request, response, forwardPathUpload);
	}

	protected void list(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<FileDTO> fileDTOList = null;
		String repositoryType = request.getParameter("repositoryType");
		try {
			if (repositoryType == null) {
				fileDTOList = fileManager.selectFile();
			} else {
				switch (RepositoryType.valueOf(repositoryType)) {
				case DATABASE:
					fileDTOList = fileManager
							.selectFile(RepositoryType.DATABASE);
					break;
				case FILE_SYSTEM:
					fileDTOList = fileManager
							.selectFile(RepositoryType.FILE_SYSTEM);
					break;
				default:
					fileDTOList = fileManager.selectFile();
					break;
				}
			}
			request.setAttribute(FILE_LIST_KEY, fileDTOList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dispatch(request, response, forwardPathList);
	}

	protected void download(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		StringBuilder stringBuilder = null;
		String fileId = request.getParameter("fileId");

		FileDTO fileDTO;
		fileDTO = fileManager.selectFile(fileId);
		if (log.isDebugEnabled()) {
			stringBuilder = new StringBuilder();
			stringBuilder.append(fileDTO);
			log.debug(stringBuilder.toString());
		}

		String repositoryPath = fileDTO.getRepositoryPath();
		String uniqueFileName = fileDTO.getUniqueFileName();
		String realFileName = fileDTO.getRealFileName();
		InputStream inputStream = null;
		if (StringUtil.isNotEmpty(repositoryPath)) {
			// FILE_SYSTEM
			stringBuilder = new StringBuilder();
			stringBuilder.append(repositoryPath);
			if (!repositoryPath.endsWith(File.separator)) {
				stringBuilder.append(File.separator);
			}
			stringBuilder.append(uniqueFileName);
			File file = new File(stringBuilder.toString());
			inputStream = new FileInputStream(file);
		} else {
			// DATABASE
			byte[] bytes = new byte[] {};
			if (fileDTO.getFileSize() > 0) {
				bytes = fileDTO.getBytes();
			}
			inputStream = new ByteArrayInputStream(bytes);
			
		}
		response.setContentType(contentType);
		stringBuilder = new StringBuilder();
		stringBuilder.append("attachment; filename=").append(realFileName);
		response.setHeader(responseHeaderName, stringBuilder.toString());

		BufferedInputStream bufferdInputStream = new BufferedInputStream(
				inputStream);
		ServletOutputStream servletOutputStream = response.getOutputStream();
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
				servletOutputStream);
		int bytesRead;
		byte buffer[] = new byte[2048];
		while ((bytesRead = bufferdInputStream.read(buffer)) != -1) {
			bufferedOutputStream.write(buffer, 0, bytesRead);
		}
		// flush stream
		bufferedOutputStream.flush();

		// close stream
		inputStream.close();
		bufferdInputStream.close();
		servletOutputStream.close();
		bufferedOutputStream.close();
	}

	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int affectedRowCount = 0;
		String[] fileIdList = request.getParameterValues("fileId");
		try {
			affectedRowCount = fileManager.deleteFile(fileIdList);
			request.setAttribute(AFFECTED_ROW_COUNT_KEY, affectedRowCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dispatch(request, response, forwardPathDelete);
	}

	protected void read(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String fileId = request.getParameter("fileId");
		FileDTO fileDTO = fileManager.selectFile(fileId);
		request.setAttribute(FILE_KEY, fileDTO);
		dispatch(request, response, forwardPathRead);
	}

	@Override
	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#destroy()
	 */
	@Override
	public void destroy() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#getServletInfo()
	 */
	@Override
	public String getServletInfo() {
		return null;
	}
}
