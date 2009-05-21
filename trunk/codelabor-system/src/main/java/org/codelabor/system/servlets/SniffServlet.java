package org.codelabor.system.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.codelabor.system.utils.RequestUtil;

public class SniffServlet implements Servlet {

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

		try {
			writer.write("<h3>server</h3>");
			writer.write(RequestUtil.getServerDTO(request).toString());
			writer.write("<hr/>");
			writer.write("<h3>remote</h3>");
			writer.write(RequestUtil.getRemoteDTO(request).toString());
			writer.write("<hr/>");
			writer.write("<h3>local</h3>");
			writer.write(RequestUtil.getLocalDTO(request).toString());
			writer.write("<hr/>");
			writer.write("<h3>session</h3>");
			writer.write(RequestUtil.getSessionMap(request).toString());
			writer.write("<hr/>");
			writer.write("<h3>request parameters</h3>");
			writer.write(RequestUtil.getParameterMap(request).toString());
			writer.write("<hr/>");
			writer.write("<h3>request attribute</h3>");
			writer.write(RequestUtil.getRequestMap(request).toString());
			writer.write("<hr/>");
			writer.write("<h3>http servlet request attribute</h3>");
			writer.write(RequestUtil.getHttpServletRequestMap(request)
					.toString());
			writer.write("<hr/>");
			writer.write("<h3>locale</h3>");
			writer.write(RequestUtil.getLocaleList(request).toString());
			writer.write("<hr/>");
			writer.write("<h3>etc</h3>");
			writer.write(RequestUtil.getEtcDTO(request).toString());
			writer.write("<hr/>");

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
