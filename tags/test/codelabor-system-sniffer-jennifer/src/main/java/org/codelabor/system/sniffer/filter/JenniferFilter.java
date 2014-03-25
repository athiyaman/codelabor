package org.codelabor.system.sniffer.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javaservice.jennifer.agent.ActiveTraceUtil;

/**
 * Servlet Filter implementation class JenniferFilter
 */
public class JenniferFilter implements Filter {

	private static final Logger logger = LoggerFactory
			.getLogger("JenniferFilter");

	/**
	 * Default constructor.
	 */
	public JenniferFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// place your code here
		ActiveTraceUtil activeTraceUtil = new ActiveTraceUtil();
		logger.debug("activeServiceName: {}",
				activeTraceUtil.getActiveServiceName());
		logger.debug("applicationName: {}",
				activeTraceUtil.getApplicationName());
		logger.debug("GUID: {}", activeTraceUtil.getGUID());
		logger.debug("PUID: {}", activeTraceUtil.getPUID());
		logger.debug("TUID: {}", activeTraceUtil.getTUID());
		logger.debug("userId: {}", activeTraceUtil.getUserId());

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
