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

/**
 * 요청 속성 스니핑 필터
 * 
 * @author Shin Sangjae
 * 
 */
public class HttpRequestAttributeSniffingFilter extends BaseFilterImpl {
	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory
			.getLogger(HttpRequestAttributeSniffingFilter.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.web.filters.BaseFilterImpl#postprocessFilterChain
	 * (javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void postprocessFilterChain(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.web.filters.BaseFilterImpl#preprocessFilterChain
	 * (javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
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
