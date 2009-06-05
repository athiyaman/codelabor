/**
 * 
 */
package org.codelabor.system.servlets;

import static org.codelabor.system.Constants.FILE_LIST_KEY;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.RepositoryType;
import org.codelabor.system.dtos.FileDTO;
import org.codelabor.system.managers.FileManager;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author bomber
 * 
 */
public class FileListServlet implements Servlet {
	private final Log log = LogFactory.getLog(UploadServlet.class);
	private ServletConfig servletConfig;
	private String forwardPath;

	// service
	protected WebApplicationContext ctx;
	protected FileManager fileManager;

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
	 * @see javax.servlet.Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		servletConfig = config;
		forwardPath = config.getInitParameter("successPath");
		ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());

		// set service
		fileManager = (FileManager) ctx.getBean("fileManager");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#service(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse)
	 */
	public void service(ServletRequest request, ServletResponse response)
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
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(((HttpServletRequest) request).getContextPath());
		stringBuffer.append(forwardPath);
		log.debug("dispatch path: " + stringBuffer.toString());
		RequestDispatcher dispatcher = servletConfig.getServletContext()
				.getRequestDispatcher(stringBuffer.toString());
		dispatcher.forward(request, response);

	}

}
