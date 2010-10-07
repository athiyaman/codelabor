/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codelabor.system.security.web.filters;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.codelabor.system.web.RequestConstants;
import org.codelabor.system.web.filters.BaseFilterImpl;
import org.codelabor.system.web.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 세션 확인 필터</br> 세션이 유효하지 않으면 정해진 페이지로 리다이렉트 시킨다.
 * 
 * @author Shin Sangjae
 * @deprecated 2.0.2부터 SessionValidationFilter로 대체
 */
@Deprecated
public class SessionIdValidationFilter extends BaseFilterImpl {

	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory
			.getLogger(SessionIdValidationFilter.class);

	/**
	 * 리다이렉트 URL</br> 세션이 유효하지 않을 때 리다이렉트될 URL
	 */
	protected String expiredURL = "/";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.filters.BaseFilterImpl#init(javax.servlet.FilterConfig
	 * )
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String tempExpiredURL = filterConfig.getInitParameter("expiredURL");
		if (StringUtils.isNotBlank(tempExpiredURL)) {
			expiredURL = tempExpiredURL;
		}
		logger.debug("expiredURL: {}", expiredURL);

		super.init(filterConfig);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.filters.BaseFilterImpl#preprocessFilterChain(javax
	 * .servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void preprocessFilterChain(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String requestURI = httpServletRequest.getRequestURI();
		String requestedSessionId = httpServletRequest.getRequestedSessionId();
		boolean isRequestedSessionIdValid = httpServletRequest
				.isRequestedSessionIdValid();

		logger.debug("requestURI: {}", requestURI);
		logger.debug("requestedSessionId: {}", requestedSessionId);
		logger
				.debug("isRequestedSessionIdValid: {}",
						isRequestedSessionIdValid);

		if (StringUtils.isNotBlank(requestedSessionId)
				&& isRequestedSessionIdValid) {
			logger.debug("session id is valid: {}", requestedSessionId);
		} else {
			logger.error("session id is invalid: {}", requestedSessionId);
			logger.error("forward to expiredURL: {}", expiredURL);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(expiredURL);
			HttpSession httpSession = httpServletRequest.getSession();
			httpSession.setAttribute(RequestConstants.REQUEST_URI, requestURI);
			httpSession.setAttribute(RequestConstants.REQUEST_ATTRIBUTE_MAP,
					RequestUtils.getAttributeMap(httpServletRequest));
			httpSession.setAttribute(RequestConstants.REQUEST_PARAMETER_MAP,
					RequestUtils.getParameterMap(httpServletRequest));
			logger.debug("current session id: {}", httpSession.getId());
			dispatcher.forward(request, response);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.filters.BaseFilterImpl#postprocessFilterChain(javax
	 * .servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void postprocessFilterChain(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
	}
}
