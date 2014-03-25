package org.codelabor.system.sniffer.web.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.codelabor.system.web.filters.BaseFilterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 요청 파라미터 스니핑 필터
 * 
 * @author Shin Sangjae
 * 
 */
public class HttpRequestParameterSniffingFilter extends BaseFilterImpl {
	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory
			.getLogger(HttpRequestParameterSniffingFilter.class);

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
		// TODO Auto-generated method stub

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

		Enumeration<String> parameterNames = httpServletRequest
				.getParameterNames();
		String paramName = null;
		String[] paramValues = null;
		while (parameterNames.hasMoreElements()) {
			paramName = parameterNames.nextElement();
			paramValues = httpServletRequest.getParameterValues(paramName);
			logger.debug("{}: {}", paramName, Arrays.toString(paramValues));
		}

	}
}
