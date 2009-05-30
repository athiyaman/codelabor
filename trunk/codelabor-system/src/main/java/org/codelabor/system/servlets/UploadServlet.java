package org.codelabor.system.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	private FileCleaningTracker fileCleaningTracker;
	private FileUploadProgressListener fileUploadProgressListener;

	// service
	protected WebApplicationContext ctx;
	protected FileManager fileManager;
	protected IPropertiesService propertiesService;
	protected IIdGenerationService uniqueFileNameGenerationService;

	// configuration
	protected boolean isRename;
	protected int sizeThreshold;
	protected long fileSizeMax;
	protected long requestSizeMax;
	protected String realRepositoryPath;
	protected String tempRepositoryPath;
	protected RepositoryType repositoryType;

	public void init(ServletConfig config) throws ServletException {
		servletConfig = config;
		ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		fileCleaningTracker = FileCleanerCleanup.getFileCleaningTracker(config
				.getServletContext());
		fileUploadProgressListener = new FileUploadProgressListener();

		// set service
		fileManager = (FileManager) ctx.getBean("fileManager");
		propertiesService = (IPropertiesService) ctx
				.getBean("propertiesService");
		uniqueFileNameGenerationService = (IIdGenerationService) ctx
				.getBean("uniqueFileNameGenerationService");

		// set configuration
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
	}

	protected String getUniqueFileName() throws Exception {
		return uniqueFileNameGenerationService.getNextStringId();
	}

	@SuppressWarnings("unchecked")
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload
				.isMultipartContent((HttpServletRequest) request);
		Map<String, Object> paramMap = RequestUtil.getParameterMap(request);
		if (isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(sizeThreshold);
			factory.setRepository(new File(tempRepositoryPath));
			factory.setFileCleaningTracker(fileCleaningTracker);

			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(fileSizeMax);
			upload.setSizeMax(requestSizeMax);
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
						paramMap.put(item.getFieldName(), item.getString());
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
			// paramMap = RequestUtil.getParameterMap(request);
		}
		try {
			processParameters(paramMap);
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

	protected FileDTO processUploadFile(FileItem item) throws Exception {
		if (item.getName() == null || item.getName().length() == 0)
			return null;
		// boolean isInmomory = item.isInMemory();

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

	public void destroy() {
	}

	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}

	public String getServletInfo() {
		return null;
	}
}
