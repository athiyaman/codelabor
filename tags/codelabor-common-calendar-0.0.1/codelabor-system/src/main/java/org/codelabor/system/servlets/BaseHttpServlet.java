package org.codelabor.system.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class BaseHttpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8511717937606209944L;
	protected ServletConfig servletConfig;

	@Override
	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#getServletInfo()
	 */
	@Override
	public String getServletInfo() {
		return this.servletConfig.getServletContext().getServerInfo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.servletConfig = config;

	}

}
