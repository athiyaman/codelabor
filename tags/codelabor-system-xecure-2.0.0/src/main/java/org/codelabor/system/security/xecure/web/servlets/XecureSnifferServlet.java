package org.codelabor.system.security.xecure.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.codelabor.system.sniffer.utils.SniffingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xecure.servlet.XecureHttpServlet;

/**
 * Xecure 스니핑 서블릿
 * 
 * @author Shin Sangjae
 * 
 */
public class XecureSnifferServlet extends XecureHttpServlet {
	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory
			.getLogger(XecureSnifferServlet.class);
	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -716194662373559921L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse)
	 */
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
			logger.error(e.getMessage());
		}
	}
}
