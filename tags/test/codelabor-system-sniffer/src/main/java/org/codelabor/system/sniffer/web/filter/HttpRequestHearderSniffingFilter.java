package org.codelabor.system.sniffer.web.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.codelabor.system.web.filters.BaseFilterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 요청 헤더 스니핑 필터
 * 
 * @author Shin Sangjae
 * 
 */
public class HttpRequestHearderSniffingFilter extends BaseFilterImpl {
	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory
			.getLogger(HttpRequestHearderSniffingFilter.class);

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void preprocessFilterChain(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
		String headerName = null;
		Enumeration headerValues = null;
		while (headerNames.hasMoreElements()) {
			headerName = headerNames.nextElement();
			headerValues = httpServletRequest.getHeaders(headerName);
			logger.debug("{}: {}", headerName,
					Arrays.toString(Collections.list(headerValues).toArray()));
		}

	}
}
