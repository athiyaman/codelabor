package org.codelabor.example.lifecycle.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.codelabor.example.lifecycle.context.UserContext;
import org.codelabor.example.lifecycle.context.UserContextHolder;
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
		long threadId = Thread.currentThread().getId();
		logger.debug("thread id: {}", threadId);
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		logger.debug("destroy");
		long threadId = Thread.currentThread().getId();
		logger.debug("thread id: {}", threadId);
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		logger.debug("doFilter");
		long threadId = Thread.currentThread().getId();
		logger.debug("thread id: {}", threadId);
		String sessionId = ServletUtils.getSessionId(request);
		logger.debug("session id: {}", sessionId);

		// init user context
		UserContext userContext = UserContextHolder.getContext();
		if (userContext == null) {
			logger.debug("user context: {}", UserContextHolder.getContext());
			userContext = new UserContext();
			UserContextHolder.setContext(userContext);
			logger.debug("user id: {}", UserContextHolder.getContext()
					.getUserId());
		}

		// TODO: get user id from session
		String userId = "Test User";
		// TODO: set user id to user context
		logger.debug("set user id: {}", userId);
		UserContextHolder.getContext().setUserId(userId);

		logger.debug("before chain.doFilter()");
		logger.debug("user id: {}", UserContextHolder.getContext().getUserId());

		// do something
		chain.doFilter(request, response);

		logger.debug("after chain.doFilter()");
		logger.debug("user id: {}", UserContextHolder.getContext().getUserId());

		// TODO: remove user context
		logger.debug("remove user context");
		UserContextHolder.removeContext();
		logger.debug("user context: {}", UserContextHolder.getContext());
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		logger.debug("init");
		long threadId = Thread.currentThread().getId();
		logger.debug("thread id: {}", threadId);
	}

}
