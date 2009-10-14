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

import org.apache.commons.lang.StringUtils;
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
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		XecureHttpServletRequest xecureHttpServletRequest = null;
		XecureHttpServletResponse xecureHttpServletResponse = null;

		String qValue = httpServletRequest.getParameter("q");
		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("q: ").append(qValue);
			log.debug(sb.toString());
		}

		if (StringUtils.isEmpty(qValue)) {
			chain.doFilter(httpServletRequest, httpServletResponse);
		} else if (Boolean.parseBoolean(httpServletRequest
				.getParameter("fileEnc"))) {
			chain.doFilter(httpServletRequest, httpServletResponse);
		} else {
			try {
				XecureServlet xecureServlet = new XecureServlet(
						new XecureConfig(), httpServletRequest,
						httpServletResponse);
				xecureHttpServletRequest = xecureServlet.request;
				xecureHttpServletResponse = xecureServlet.response;
				chain.doFilter(xecureHttpServletRequest,
						xecureHttpServletResponse);
			} catch (XecureServletException e) {
				e.printStackTrace();
			} catch (XecureServletConfigException e) {
				e.printStackTrace();
			}
		}
	}
}
