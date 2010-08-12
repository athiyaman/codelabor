package org.codelabor.system.sniffer.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.codelabor.system.filters.BaseFilterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpRequestHearderSniffingFilter extends BaseFilterImpl {
	private final Logger logger = LoggerFactory
			.getLogger(HttpRequestHearderSniffingFilter.class);

	@SuppressWarnings("unchecked")
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
		String headerName = null;
		Enumeration headerValues = null;
		while (headerNames.hasMoreElements()) {
			headerName = headerNames.nextElement();
			headerValues = httpServletRequest.getHeaders(headerName);
			logger.debug("{}: {}", headerName, Arrays.toString(Collections
					.list(headerValues).toArray()));
		}
		filterChain.doFilter(request, response);
	}
}
