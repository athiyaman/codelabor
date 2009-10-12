package org.codelabor.system.security.xecure.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xecure.servlet.XecureConfig;
import xecure.servlet.XecureHttpServletRequest;
import xecure.servlet.XecureHttpServletResponse;
import xecure.servlet.XecureServlet;
import xecure.servlet.XecureServletConfigException;
import xecure.servlet.XecureServletException;

public class XecureFilter implements Filter {

	private final Log log = LogFactory.getLog(XecureFilter.class);

	public void init(FilterConfig config) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		XecureHttpServletRequest xReq = null;
		XecureHttpServletResponse xRes = null;

		String qValue = httpReq.getParameter("q");
		if (log.isDebugEnabled()) {
			log.debug("q: " + qValue);
		}
		if (qValue == null || "".equals(qValue))
			chain.doFilter(httpReq, httpRes);
		else if (Boolean.parseBoolean(httpReq.getParameter("fileEnc")))
			chain.doFilter(httpReq, httpRes);
		else {
			try {
				XecureServlet xecure = new XecureServlet(new XecureConfig(),
						httpReq, httpRes);
				xReq = xecure.request;
				xRes = xecure.response;
				chain.doFilter(xReq, xRes);
			} catch (XecureServletException e) {
				e.printStackTrace();
			} catch (XecureServletConfigException e) {
				e.printStackTrace();
			}
		}
	}
}
