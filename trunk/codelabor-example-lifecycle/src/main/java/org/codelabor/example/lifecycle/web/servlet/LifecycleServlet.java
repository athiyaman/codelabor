package org.codelabor.example.lifecycle.web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class LifecycleServlet
 */
public class LifecycleServlet extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 4389059095826019079L;
	private final static Logger logger = LoggerFactory
			.getLogger(LifecycleServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LifecycleServlet() {
		super();
		logger.debug("constructor");
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		logger.debug("init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		logger.debug("destroy");
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	@Override
	public ServletConfig getServletConfig() {
		logger.debug("getServletConfig");
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	@Override
	public String getServletInfo() {
		logger.debug("getServletInfo");
		return null;
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.debug("service");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doPost");
	}

}
