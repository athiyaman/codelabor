package org.codelabor.example.lifecycle.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.codelabor.system.sniffer.web.util.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class LifecycleFilter
 */
public class LifecycleFilter implements Filter {

	private final static Logger logger = LoggerFactory
			.getLogger(LifecycleFilter.class);

	/**
	 * Default constructor.
	 */
	public LifecycleFilter() {
		logger.debug("constructor");
	}

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		logger.debug("destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		logger.debug("doFilter");
		String sessionId = ServletUtils.getSessionId(request);
		logger.debug("session id: {}", sessionId);
		logger.debug("before chain.doFilter()");
		chain.doFilter(request, response);
		logger.debug("after chain.doFilter()");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		logger.debug("init");
	}

}
