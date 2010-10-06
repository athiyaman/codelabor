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

package org.codelabor.system.web.filters;

import static org.codelabor.system.web.SessionConstants.SESSION_REQUEST_ID;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import anyframe.common.exception.BaseException;
import anyframe.core.idgen.IIdGenerationService;

/**
 * 요청 ID 생성 필터
 * 
 * @author Shin Sangjae
 * 
 */
public class RequestIdGenerationFilter extends BaseFilterImpl {
	/**
	 * 로거
	 */
	Logger logger = LoggerFactory.getLogger(RequestIdGenerationFilter.class);
	/**
	 * 아이디 제네레이션 서비스
	 */
	protected IIdGenerationService idGenerationService = null;
	/**
	 * 아이디 제네레이션 서비스명 상수
	 */
	public final String REQUEST_ID_GENERATION_SERVICE = "requestIdGenerationService";

	/**
	 * 생성자
	 */
	public RequestIdGenerationFilter() {
		super();
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);
		idGenerationService = (IIdGenerationService) ctx
				.getBean(REQUEST_ID_GENERATION_SERVICE);
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
		try {
			String requestId = idGenerationService.getNextStringId();
			((HttpServletRequest) request).getSession().setAttribute(
					SESSION_REQUEST_ID, requestId);
			logger.debug("requestId: {}", requestId);
		} catch (BaseException e) {
			e.printStackTrace();
		}
	}
}
