package org.codelabor.example.lifecycle.web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.example.lifecycle.context.UserContextHolder;
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
		long threadId = Thread.currentThread().getId();
		logger.debug("thread id: {}", threadId);
		logger.debug("user id: {}", UserContextHolder.getContext().getUserId());
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		logger.debug("init");
		long threadId = Thread.currentThread().getId();
		logger.debug("thread id: {}", threadId);
		logger.debug("user id: {}", UserContextHolder.getContext().getUserId());
	}

	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		logger.debug("destroy");
		long threadId = Thread.currentThread().getId();
		logger.debug("thread id: {}", threadId);
		logger.debug("user id: {}", UserContextHolder.getContext().getUserId());
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	@Override
	public ServletConfig getServletConfig() {
		logger.debug("getServletConfig");
		long threadId = Thread.currentThread().getId();
		logger.debug("thread id: {}", threadId);
		logger.debug("user id: {}", UserContextHolder.getContext().getUserId());
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	@Override
	public String getServletInfo() {
		logger.debug("getServletInfo");
		long threadId = Thread.currentThread().getId();
		logger.debug("thread id: {}", threadId);
		logger.debug("user id: {}", UserContextHolder.getContext().getUserId());
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
		long threadId = Thread.currentThread().getId();
		logger.debug("thread id: {}", threadId);
		logger.debug("user id: {}", UserContextHolder.getContext().getUserId());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doGet");
		long threadId = Thread.currentThread().getId();
		logger.debug("thread id: {}", threadId);
		logger.debug("user id: {}", UserContextHolder.getContext().getUserId());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doPost");
		long threadId = Thread.currentThread().getId();
		logger.debug("thread id: {}", threadId);
		logger.debug("user id: {}", UserContextHolder.getContext().getUserId());
	}

}
