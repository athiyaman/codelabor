package org.codelabor.system.sniffer.web.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.codelabor.system.web.filters.BaseFilterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpRequestAttributeSniffingFilter extends BaseFilterImpl {
	private final Logger logger = LoggerFactory
			.getLogger(HttpRequestAttributeSniffingFilter.class);

	@Override
	public void postprocessFilterChain(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void preprocessFilterChain(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
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

	}
}
