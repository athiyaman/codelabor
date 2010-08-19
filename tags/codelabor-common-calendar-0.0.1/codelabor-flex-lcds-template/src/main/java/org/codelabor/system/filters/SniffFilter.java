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

package org.codelabor.system.filters;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author SangJae Shin
 * 
 */
public class SniffFilter extends BaseFilterImpl {

	@Override
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(System.getProperty("line.separator"));

		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		stringBuilder.append("[server]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("-------------------------------");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("serverName").append(": ").append(serverName);
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("serverPort").append(": ").append(serverPort);
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("-------------------------------");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(System.getProperty("line.separator"));

		String remoteHost = request.getRemoteHost();
		String remoteAddr = request.getRemoteAddr();
		int remotePort = request.getRemotePort();
		stringBuilder.append("[remote]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("-------------------------------");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("remoteHost").append(": ").append(remoteHost);
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("remoteAddr").append(": ").append(remoteAddr);
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("remotePort").append(": ").append(remotePort);
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("-------------------------------");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(System.getProperty("line.separator"));

		String localName = request.getLocalName();
		String localAddr = request.getLocalAddr();
		int localPort = request.getLocalPort();
		stringBuilder.append("[local]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("-------------------------------");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("localName").append(": ").append(localName);
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("localAddr").append(": ").append(localAddr);
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("localPort").append(": ").append(localPort);
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("-------------------------------");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(System.getProperty("line.separator"));

		int contentLength = request.getContentLength();
		String contentType = request.getContentType();
		String protocol = request.getProtocol();
		String scheme = request.getScheme();
		String characterEncoding = request.getCharacterEncoding();
		Locale locale = request.getLocale();
		Enumeration<Locale> localeEnum = request.getLocales();

		stringBuilder.append("[etc]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("-------------------------------");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("contentLength").append(": ")
				.append(contentLength);
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("contentType").append(": ").append(contentType);
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("protocol").append(": ").append(protocol);
		stringBuilder.append(System.getProperty("line.separator"));

		stringBuilder.append("scheme").append(": ").append(scheme);
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("characterEncoding").append(": ").append(
				characterEncoding);
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("locale").append(": ").append(locale);

		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("-------------------------------");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(System.getProperty("line.separator"));

		// locale
		stringBuilder.append("[locale]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("-------------------------------");
		while (localeEnum.hasMoreElements()) {
			Locale localeItem = localeEnum.nextElement();
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("locale").append(": ").append(localeItem);
		}
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("-------------------------------");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(System.getProperty("line.separator"));

		// parameter
		Enumeration<String> paramEnum = request.getParameterNames();
		stringBuilder.append("[request parameter]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("-------------------------------");
		while (paramEnum.hasMoreElements()) {
			String paramName = paramEnum.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append(paramName).append(": ");
			int paramValueCount = paramValues.length;
			for (int i = 0; i < paramValueCount; i++) {
				stringBuilder.append(paramValues[i]);
				if (i < paramValueCount - 1) {
					stringBuilder.append(", ");
				}
			}
		}
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("-------------------------------");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(System.getProperty("line.separator"));

		// attribute
		Enumeration<String> attribEnum = request.getAttributeNames();
		stringBuilder.append("[request attribute]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("-------------------------------");
		while (attribEnum.hasMoreElements()) {
			String attribName = attribEnum.nextElement();
			Object attribObject = request.getAttribute(attribName);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append(attribName).append(": ").append(attribObject);
		}
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("-------------------------------");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(System.getProperty("line.separator"));

		// session
		HttpSession session = ((HttpServletRequest) request).getSession();
		if (session != null) {
			attribEnum = session.getAttributeNames();
			stringBuilder.append("[session attribute]");
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("-------------------------------");
			while (attribEnum.hasMoreElements()) {
				String attribName = attribEnum.nextElement();
				Object attribObject = session.getAttribute(attribName);
				stringBuilder.append(System.getProperty("line.separator"));
				stringBuilder.append(attribName).append(": ").append(
						attribObject);
			}
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("-------------------------------");
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append(System.getProperty("line.separator"));
		}

		if (request instanceof HttpServletRequest) {
			stringBuilder.append("[http servlet request attribute]");
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("-------------------------------");

			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			String authType = httpServletRequest.getAuthType();
			String contextPath = httpServletRequest.getContextPath();
			String method = httpServletRequest.getMethod();
			String pathInfo = httpServletRequest.getPathInfo();
			String queryString = httpServletRequest.getQueryString();
			String remoteUser = httpServletRequest.getRemoteUser();
			String requestURI = httpServletRequest.getRequestURI();
			String servletPath = httpServletRequest.getServletPath();
			boolean isRequestedSessionIdFromCookie = httpServletRequest
					.isRequestedSessionIdFromCookie();
			boolean isRequestedSessionIdFromURL = httpServletRequest
					.isRequestedSessionIdFromURL();

			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("authType").append(": ").append(authType);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("contextPath").append(": ")
					.append(contextPath);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("method").append(": ").append(method);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("pathInfo").append(": ").append(pathInfo);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("queryString").append(": ")
					.append(queryString);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("remoteUser").append(": ").append(remoteUser);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("requestURI").append(": ").append(requestURI);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("servletPath").append(": ")
					.append(servletPath);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("isRequestedSessionIdFromCookie").append(": ")
					.append(isRequestedSessionIdFromCookie);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("isRequestedSessionIdFromURL").append(": ")
					.append(isRequestedSessionIdFromURL);

			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("-------------------------------");
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append(System.getProperty("line.separator"));

		}

		if (log.isDebugEnabled()) {
			log.debug(stringBuilder.toString());
		}

		filterChain.doFilter(request, response);
	}
}
