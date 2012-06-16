package org.codelabor.example.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldServlet extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = -7113851485560042291L;
	private static final Logger logger = LoggerFactory
			.getLogger(HelloWorldServlet.class);

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("Hello, World!");
		logger.debug("service");
	}

}
