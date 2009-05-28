package org.codelabor.system.servlets;

import java.io.IOException;
import java.util.HashMap;
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
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.RepositoryType;
import org.codelabor.system.dtos.FileDTO;
import org.codelabor.system.managers.FileManager;
import org.codelabor.system.utils.UploadUtil;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import anyframe.core.idgen.IIdGenerationService;
import anyframe.core.properties.IPropertiesService;

public class UploadServlet implements Servlet {
	private final Log log = LogFactory.getLog(UploadServlet.class);
	private ServletConfig servletConfig;

	// service
	protected WebApplicationContext ctx;
	protected FileManager fileManager;
	protected IPropertiesService propertiesService;
	protected IIdGenerationService uniqueFileNameGenerationService;

	// configuration
	protected boolean isRename;
	protected String repositoryPath;
	protected RepositoryType repositoryType;

	public void init(ServletConfig config) throws ServletException {
		servletConfig = config;
		ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());

		// set service
		fileManager = (FileManager) ctx.getBean("fileManager");
		propertiesService = (IPropertiesService) ctx
				.getBean("propertiesService");
		uniqueFileNameGenerationService = (IIdGenerationService) ctx
				.getBean("uniqueFileNameGenerationService");

		// set configuration
		isRename = propertiesService.getBoolean("file.default.rename.flag",
				true);
		repositoryPath = propertiesService.getString(
				"file.default.repository.path", System.getProperty("user.dir"));
		repositoryType = RepositoryType.valueOf(propertiesService.getString(
				"file.default.repository.type", RepositoryType.FILE_SYSTEM
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
		Map paramMap = new HashMap();
		if (isMultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> items = upload
						.parseRequest((HttpServletRequest) request);
				Iterator<FileItem> iter = items.iterator();

				while (iter.hasNext()) {
					FileItem item = iter.next();
					log.debug(item);
					if (item.isFormField()) {
						paramMap.put(item.getFieldName(), item.getString());
					} else {
						processUploadFile(item);
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

		}
		if (log.isDebugEnabled()) {
			log.debug(paramMap);
		}
	}

	protected void processUploadFile(FileItem item) throws Exception {
		// boolean isInmomory = item.isInMemory();

		// set dto
		FileDTO fileDTO = new FileDTO();
		fileDTO.setRealFileName(item.getName());
		fileDTO.setUniqueFileName(getUniqueFileName());
		fileDTO.setFileSize(item.getSize());
		fileDTO.setContentType(item.getContentType());
		fileDTO.setRepositoryPath(repositoryPath);
		if (log.isDebugEnabled()) {
			log.debug(fileDTO);
		}

		UploadUtil.processUploadFile(repositoryType, item.getInputStream(),
				fileDTO);

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
