package org.codelabor.system.servlets;

import static org.codelabor.system.Constants.FILE_LIST_KEY;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileCleaningTracker;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.RepositoryType;
import org.codelabor.system.dtos.FileDTO;
import org.codelabor.system.listeners.FileUploadProgressListener;
import org.codelabor.system.managers.FileManager;
import org.codelabor.system.utils.RequestUtil;
import org.codelabor.system.utils.UploadUtil;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import anyframe.core.idgen.IIdGenerationService;
import anyframe.core.properties.IPropertiesService;

public class UploadServlet implements Servlet {
	private final Log log = LogFactory.getLog(UploadServlet.class);
	private ServletConfig servletConfig;
	protected String parameterName;
	protected String forwardPathUpload;
	protected String forwardPathList;
	protected String forwardPathDownload;
	protected FileCleaningTracker fileCleaningTracker;
	protected FileUploadProgressListener fileUploadProgressListener;

	enum Parameter {
		upload, download, list, read, delete
	};

	// service
	protected WebApplicationContext ctx;
	protected FileManager fileManager;
	protected IPropertiesService propertiesService;
	protected IIdGenerationService uniqueFileNameGenerationService;

	// configuration
	protected String characterEncoding;
	protected boolean isRename;
	protected int sizeThreshold;
	protected long fileSizeMax;
	protected long requestSizeMax;
	protected String realRepositoryPath;
	protected String tempRepositoryPath;
	protected RepositoryType repositoryType;

	public void init(ServletConfig config) throws ServletException {
		// set init param
		servletConfig = config;
		parameterName = config.getInitParameter("parameterName");
		forwardPathUpload = config.getInitParameter("forwardPathUpload");
		forwardPathList = config.getInitParameter("forwardPathList");
		forwardPathDownload = config.getInitParameter("forwardPathDelete");

		// set service
		ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		fileManager = (FileManager) ctx.getBean("fileManager");
		propertiesService = (IPropertiesService) ctx
				.getBean("propertiesService");
		uniqueFileNameGenerationService = (IIdGenerationService) ctx
				.getBean("uniqueFileNameGenerationService");

		// set configuration
		characterEncoding = propertiesService.getString(
				"file.default.character.encoding", "UTF-8");
		isRename = propertiesService.getBoolean("file.default.rename.flag",
				true);
		sizeThreshold = propertiesService.getInt(
				"file.default.file.size.threshold",
				DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD);
		fileSizeMax = propertiesService.getLong("file.default.file.size.max",
				1024 * 10);
		requestSizeMax = propertiesService.getLong(
				"file.default.request.size.max", 1024 * 100);
		realRepositoryPath = propertiesService.getString(
				"file.default.real.repository.path", System
						.getProperty("user.dir"));
		tempRepositoryPath = propertiesService.getString(
				"file.default.temp.repository.path", System
						.getProperty("java.io.tmpdir"));
		repositoryType = RepositoryType.valueOf(propertiesService.getString(
				"file.default.real.repository.type", RepositoryType.FILE_SYSTEM
						.toString()));

		// file listener / tracker
		fileCleaningTracker = FileCleanerCleanup.getFileCleaningTracker(config
				.getServletContext());
		fileUploadProgressListener = new FileUploadProgressListener();
	}

	protected String getUniqueFileName() throws Exception {
		return uniqueFileNameGenerationService.getNextStringId();
	}

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		String parameterValue = request.getParameter(parameterName);
		switch (Parameter.valueOf(parameterValue)) {
		case upload:
			this.upload(request, response);
			break;
		case download:
			this.download(request, response);
			break;
		case list:
			this.list(request, response);
			break;
		case delete:
			this.list(request, response);
			break;
		case read:
			this.read(request, response);
			break;
		}
	}

	protected void processParameters(Map<String, Object> paramMap)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(paramMap);
		}
	}

	protected FileDTO processUploadFile(FileItem item) throws Exception {
		if (item.getName() == null || item.getName().length() == 0)
			return null;
		// set dto
		FileDTO fileDTO = new FileDTO();
		fileDTO.setRealFileName(item.getName());
		fileDTO.setUniqueFileName(getUniqueFileName());
		fileDTO.setFileSize(item.getSize());
		fileDTO.setContentType(item.getContentType());
		fileDTO.setRepositoryPath(realRepositoryPath);
		if (log.isDebugEnabled()) {
			log.debug(fileDTO);
		}
		UploadUtil.processFile(repositoryType, item.getInputStream(), fileDTO);
		return fileDTO;
	}

	protected void dispatch(ServletRequest request, ServletResponse response,
			String path) throws ServletException, IOException {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(((HttpServletRequest) request).getContextPath());
		stringBuffer.append(path);
		log.debug("dispatch path: " + stringBuffer.toString());
		RequestDispatcher dispatcher = servletConfig.getServletContext()
				.getRequestDispatcher(stringBuffer.toString());
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void upload(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload
				.isMultipartContent((HttpServletRequest) request);

		String _repositoryType = request.getParameter("repositoryType");
		if (_repositoryType != null && _repositoryType.length() > 0) {
			repositoryType = RepositoryType.valueOf(_repositoryType);
		}

		log.debug("characterEncoding from request: "
				+ request.getCharacterEncoding());
		log.debug("characterEncoding from properties: " + characterEncoding);
		Map<String, Object> paramMap = RequestUtil.getParameterMap(request);

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
				List<FileItem> items = upload
						.parseRequest((HttpServletRequest) request);
				Iterator<FileItem> iter = items.iterator();

				while (iter.hasNext()) {
					FileItem item = iter.next();
					log.debug(item);
					FileDTO fileDTO = null;
					if (item.isFormField()) {
						paramMap.put(item.getFieldName(), item
								.getString(characterEncoding));
					} else {
						fileDTO = processUploadFile(item);
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

	protected void list(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
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

	protected void download(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

	}

	protected void delete(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

	}

	protected void read(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

	}

	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#destroy()
	 */
	public void destroy() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		return null;
	}
}
