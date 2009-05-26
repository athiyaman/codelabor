package org.codelabor.system.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xecure.file.XecureFileInputStream;
import xecure.servlet.XecureServlet;
import xecure.servlet.XecureServletConfigException;
import xecure.servlet.XecureServletException;

public class XecureUploadServlet extends UploadServlet {

	private final Log log = LogFactory.getLog(XecureUploadServlet.class);

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		XecureFileInputStream xecureFileInputStream;
		XecureServlet xecureServlet;
		try {
			xecureServlet = new XecureServlet((HttpServletRequest) request,
					(HttpServletResponse) response);
			xecureFileInputStream = new XecureFileInputStream(xecureServlet
					.getXecureSession(), xecureServlet.request);
			Map paramMap = xecureServlet.request.getParameterMap();
			log.debug(paramMap);

			persistFile(xecureFileInputStream);
		} catch (XecureServletException e) {
			e.printStackTrace();
		} catch (XecureServletConfigException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void persistFile(XecureFileInputStream xecureFileInputStream)
			throws Exception {
		switch (repositoryType) {
		case FILE_SYSTEM:
			String uniqueFileName = getUniqueFileName();
			if (isRename) {
				xecureFileInputStream
						.saveFileAs(repositoryPath, uniqueFileName);
				// TODO map real name and unique name
			} else {
				xecureFileInputStream.saveFileAt(repositoryPath);
			}
			break;
		case DATABASE:
			// TODO insert blob
			break;
		}
	}

	public void destroy() {
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}

}
