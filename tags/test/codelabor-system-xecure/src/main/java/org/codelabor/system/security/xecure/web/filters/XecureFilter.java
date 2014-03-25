package org.codelabor.system.security.xecure.web.filters;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xecure.servlet.XecureConfig;
import xecure.servlet.XecureHttpServletRequest;
import xecure.servlet.XecureHttpServletResponse;
import xecure.servlet.XecureServlet;
import xecure.servlet.XecureServletConfigException;
import xecure.servlet.XecureServletException;

/**
 * Xecure 필터</br> XecureWeb 웹 구간 암호화 시 자동으로 복호화를 하는 서블릿 필터
 * 
 * @author Shin Sangjae
 * 
 */
public class XecureFilter implements Filter {

	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory.getLogger(XecureFilter.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		XecureHttpServletRequest xecureHttpServletRequest = null;
		XecureHttpServletResponse xecureHttpServletResponse = null;

		String qValue = httpServletRequest.getParameter("q");
		logger.debug("q: {}", qValue);

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
				logger.error(e.getMessage());
			} catch (XecureServletConfigException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}
		}
	}
}
