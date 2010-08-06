package org.codelabor.system.sniffer.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.codelabor.system.sniffer.utils.SniffingUtils;

/**
 * @author Shin Sangjae
 * 
 */
public class SniffingServlet implements Servlet {

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		try {
			writer.write(SniffingUtils.toHTML(request));
		} catch (Exception e) {
			e.printStackTrace();
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

	public void init(ServletConfig config) throws ServletException {
	}
}
