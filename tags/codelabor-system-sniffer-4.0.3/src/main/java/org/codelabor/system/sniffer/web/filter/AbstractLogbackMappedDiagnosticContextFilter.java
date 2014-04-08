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
package org.codelabor.system.sniffer.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codelabor.system.sniffer.context.RequestContext;
import org.codelabor.system.sniffer.context.RequestContextHolder;
import org.codelabor.system.web.HeaderConstants;
import org.codelabor.system.web.RequestConstants;
import org.codelabor.system.web.ServletContainerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import com.google.common.net.HttpHeaders;

/**
 * @author Shin Sang-Jae
 *
 */
public abstract class AbstractLogbackMappedDiagnosticContextFilter extends
		AbstractRequestLoggingFilter {

	private static final Logger logger = LoggerFactory
			.getLogger(AbstractLogbackMappedDiagnosticContextFilter.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.web.filter.AbstractRequestLoggingFilter#afterRequest
	 * (javax.servlet.http.HttpServletRequest, java.lang.String)
	 */
	@Override
	protected void afterRequest(HttpServletRequest request, String message) {
		logger.debug("afterRequest");
		MDC.remove("username");
		MDC.remove("sessionId");
		MDC.remove("requestId");
		MDC.remove("servletContainerId");
		MDC.remove(RequestConstants.REMOTE_ADDR);
		MDC.remove(RequestConstants.REMOTE_HOST);
		MDC.remove(RequestConstants.REQUEST_URI);
		MDC.remove(RequestConstants.REQUEST_URL);
		MDC.remove(RequestConstants.QUERY_STRING);
		MDC.remove(HeaderConstants.USER_AGENT);
		MDC.remove(HeaderConstants.X_FORWARDED_FOR);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.web.filter.AbstractRequestLoggingFilter#beforeRequest
	 * (javax.servlet.http.HttpServletRequest, java.lang.String)
	 */
	@Override
	protected void beforeRequest(HttpServletRequest request, String message) {
		logger.debug("beforeRequest");

		String username = getUsername();

		String sessionId = null;
		HttpSession session = request.getSession();
		if (session != null) {
			sessionId = session.getId();
		}

		String requestId = null;
		RequestContext requestContext = RequestContextHolder.getContext();
		if (requestContext != null) {
			requestId = RequestContextHolder.getContext().getRequestId();
		}
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		String requestUri = request.getRequestURI();
		String requestURL = request.getRequestURL().toString();
		String queryString = request.getQueryString();
		String userAgent = request.getHeader(HttpHeaders.USER_AGENT);
		String xForwardedFor = request.getHeader(HttpHeaders.X_FORWARDED_FOR);
		String servletContainerId = System
				.getProperty(ServletContainerConstants.SERVLET_CONTAINER_ID_KEY);

		MDC.put("requestId", requestId);
		MDC.put("username", getUsername());
		MDC.put("sessionId", sessionId);
		MDC.put("servletContainerId", servletContainerId);
		MDC.put(RequestConstants.REMOTE_ADDR, remoteAddr);
		MDC.put(RequestConstants.REMOTE_HOST, remoteHost);
		MDC.put(RequestConstants.REQUEST_URI, requestUri);
		MDC.put(RequestConstants.REQUEST_URL, requestURL);
		MDC.put(RequestConstants.QUERY_STRING, queryString);
		MDC.put(HeaderConstants.USER_AGENT, userAgent);
		MDC.put(HeaderConstants.X_FORWARDED_FOR, xForwardedFor);

		logger.debug("requestId: {}", requestId);
		logger.debug("username: {}, sessionId: {}", username);
		logger.debug("sessionId: {}", sessionId);
		logger.debug("servletContainerId: {}", servletContainerId);
		logger.debug("remoteAddr: {}", remoteAddr);
		logger.debug("remoteHost: {}", remoteHost);
		logger.debug("xForwardedFor: {}", xForwardedFor);
		logger.debug("requestUri: {}", requestUri);
		logger.debug("requestURL: {}", requestURL);
		logger.debug("queryString: {}", queryString);
		logger.debug("userAgent: {}", userAgent);
		logger.debug("xForwardedFor: {}", xForwardedFor);
	}

	protected abstract String getUsername();

}
