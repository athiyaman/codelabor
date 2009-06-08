package org.codelabor.system.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.codelabor.system.utils.SniffUtil;

import xecure.servlet.XecureHttpServlet;

public class XecureSniffServlet extends XecureHttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -716194662373559921L;

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

		try {
			writer.write(this.sXecureClientObject);
			writer.write("<!---BEGIN_ENC--->");
			writer.write(SniffUtil.toHTML(request));
			writer.write("<!---END_ENC--->");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
