package org.codelabor.system.sniffer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javaservice.jennifer.agent.ActiveTraceUtil;

/**
 * Servlet implementation class JenniferServlet
 */
public class JenniferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory
			.getLogger("JenniferServlet");

	/**
	 * Default constructor.
	 */
	public JenniferServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ActiveTraceUtil activeTraceUtil = new ActiveTraceUtil();
		logger.debug("activeServiceName: {}",
				activeTraceUtil.getActiveServiceName());
		logger.debug("applicationName: {}",
				activeTraceUtil.getApplicationName());
		logger.debug("GUID: {}", activeTraceUtil.getGUID());
		logger.debug("PUID: {}", activeTraceUtil.getPUID());
		logger.debug("TUID: {}", activeTraceUtil.getTUID());
		logger.debug("userId: {}", activeTraceUtil.getUserId());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
