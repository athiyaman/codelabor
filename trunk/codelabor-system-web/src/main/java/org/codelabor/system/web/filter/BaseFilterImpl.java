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

package org.codelabor.system.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 기본 필터 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public abstract class BaseFilterImpl implements Filter {

	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 서블릿 컨텍스트
	 */
	protected ServletContext servletContext;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		logger.debug("destroy()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("init()");
		this.servletContext = filterConfig.getServletContext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String requestURI = httpServletRequest.getRequestURI();
		logger.debug("request uri: {}", requestURI);

		this.preprocessFilterChain(request, response);
		filterChain.doFilter(request, response);
		this.postprocessFilterChain(request, response);
	}

	/**
	 * 필터 체인 전처리 메소드
	 * 
	 * @param request
	 *            요청
	 * @param response
	 *            응답
	 * @throws IOException
	 *             IO 예외
	 * @throws ServletException
	 *             Servlet 예외
	 */
	public abstract void preprocessFilterChain(ServletRequest request,
			ServletResponse response) throws IOException, ServletException;

	/**
	 * 필터 체인 후처리 메소드
	 * 
	 * @param request
	 *            요청
	 * @param response
	 *            응답
	 * @throws IOException
	 *             IO 예외
	 * @throws ServletException
	 *             Servlet 예외
	 */
	public abstract void postprocessFilterChain(ServletRequest request,
			ServletResponse response) throws IOException, ServletException;
}
