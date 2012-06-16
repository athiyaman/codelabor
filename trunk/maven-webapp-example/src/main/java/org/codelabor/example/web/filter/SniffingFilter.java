package org.codelabor.example.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class SniffingFilter
 */
public class SniffingFilter implements Filter {

	private final static Logger logger = LoggerFactory
			.getLogger(SniffingFilter.class);

	/**
	 * Default constructor.
	 */
	public SniffingFilter() {
		logger.debug("constructor");
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		logger.debug("destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession();
		String sessionId = session.getId();
		logger.debug("session id: {}", sessionId);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		logger.debug("init");
	}

}
