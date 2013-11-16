package org.codelabor.system.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.codelabor.system.ThreadLocalObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestIDGenerationFilter implements Filter {

	Logger logger = LoggerFactory.getLogger(RequestIDGenerationFilter.class);

	public void destroy() {
		if (logger.isDebugEnabled()) {
			logger.debug("destroy");
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		StringBuilder sb = new StringBuilder();
		sb.append("requestid-");
		sb.append(System.currentTimeMillis());

		ThreadLocalObject.requestID.set(sb.toString());

		if (logger.isDebugEnabled()) {
			logger.debug("before doFilter");
			logger.debug("request id: {}", ThreadLocalObject.requestID.get());
		}

		filterChain.doFilter(request, response);

		if (logger.isDebugEnabled()) {
			logger.debug("after doFilter");
			logger.debug("request id: {}", ThreadLocalObject.requestID.get());
		}

		ThreadLocalObject.requestID.remove();

	}

	public void init(FilterConfig arg0) throws ServletException {
		if (logger.isDebugEnabled()) {
			logger.debug("init");
		}
	}

}
