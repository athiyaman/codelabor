package org.codelabor.system.sniffer.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.codelabor.system.filters.BaseFilterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpRequestAttributeSniffingFilter extends BaseFilterImpl {
	private final Logger logger = LoggerFactory
			.getLogger(HttpRequestAttributeSniffingFilter.class);

	@SuppressWarnings("unchecked")
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		Enumeration<String> attributeNames = httpServletRequest
				.getAttributeNames();
		String attribName = null;
		Object attribValues = null;
		while (attributeNames.hasMoreElements()) {
			attribName = attributeNames.nextElement();
			attribValues = httpServletRequest.getAttribute(attribName);
			logger.debug("{}: {}", attribName, attribValues);
		}
		filterChain.doFilter(request, response);
	}
}
