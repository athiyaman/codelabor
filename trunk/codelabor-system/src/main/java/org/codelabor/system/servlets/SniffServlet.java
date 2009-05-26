package org.codelabor.system.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.codelabor.system.utils.SniffUtil;

/**
 * @author SangJae Shin
 * 
 */
public class SniffServlet implements Servlet {

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

		try {
			writer.write(SniffUtil.toHTML(request));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}
}
