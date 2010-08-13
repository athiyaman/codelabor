package org.codelabor.system.security.xecure.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.codelabor.system.sniffer.utils.SniffingUtils;

import xecure.servlet.XecureHttpServlet;

public class XecureSnifferServlet extends XecureHttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = -716194662373559921L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

		try {
			writer.write(this.sXecureClientObject);
			writer.write("<!---BEGIN_ENC--->");
			writer.write(SniffingUtils.toHTML(request));
			writer.write("<!---END_ENC--->");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
