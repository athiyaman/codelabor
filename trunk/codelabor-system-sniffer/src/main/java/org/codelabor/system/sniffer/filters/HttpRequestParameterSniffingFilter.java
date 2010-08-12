package org.codelabor.system.sniffer.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.codelabor.system.filters.BaseFilterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpRequestParameterSniffingFilter extends BaseFilterImpl {
	private final Logger logger = LoggerFactory
			.getLogger(HttpRequestParameterSniffingFilter.class);

	@SuppressWarnings("unchecked")
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		Enumeration<String> parameterNames = httpServletRequest
				.getParameterNames();
		String paramName = null;
		String[] paramValues = null;
		while (parameterNames.hasMoreElements()) {
			paramName = parameterNames.nextElement();
			paramValues = httpServletRequest.getParameterValues(paramName);
			logger.debug("{}: {}", paramName, Arrays.toString(paramValues));
		}
		filterChain.doFilter(request, response);
	}
}
