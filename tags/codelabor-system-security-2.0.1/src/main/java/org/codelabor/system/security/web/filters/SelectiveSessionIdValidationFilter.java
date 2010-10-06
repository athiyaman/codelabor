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
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.codelabor.system.web.filters.SelectiveFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 선택적 세션 확인 필터
 * 
 * @author Shin Sangjae
 * 
 */
public abstract class SelectiveSessionIdValidationFilter extends
		SessionIdValidationFilter implements SelectiveFilter {
	private final Logger logger = LoggerFactory
			.getLogger(SelectiveSessionIdValidationFilter.class);

	/**
	 * 예외 패턴의 리스트
	 */
	protected List<String> excludePatterns = null;
	/**
	 * 포함 패턴의 리스트
	 */
	protected List<String> includePatterns = null;

	/**
	 * 리스트 항목의 구분자
	 */
	protected String delimeterPattern = "([ ]*[,; ][ ]*)";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.filters.BaseFilterImpl#init(javax.servlet.FilterConfig
	 * )
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
		includePatterns = this.getIncludePatterns(filterConfig);
		excludePatterns = this.getExcludePatterns(filterConfig);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.filters.SelectiveFilter#getExcludePatterns(javax
	 * .servlet.FilterConfig)
	 */
	public List<String> getExcludePatterns(FilterConfig filterConfig) {
		String tempExcludePattern = filterConfig.getInitParameter("excludes");
		List<String> excludePatterns = null;
		if (!StringUtils.isBlank(tempExcludePattern)) {
			String[] excludePatternsString = tempExcludePattern
					.split(delimeterPattern);
			if (excludePatternsString != null
					&& excludePatternsString.length > 0) {
				excludePatterns = Arrays.asList(excludePatternsString);
			}
		}
		logger.debug("excludePatterns: {}", excludePatterns);
		return excludePatterns;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.filters.SelectiveFilter#getIncludePatterns(javax
	 * .servlet.FilterConfig)
	 */
	public List<String> getIncludePatterns(FilterConfig filterConfig) {
		String tempIncludePattern = filterConfig.getInitParameter("includes");
		List<String> includePatterns = null;
		if (!StringUtils.isBlank(tempIncludePattern)) {
			String[] includePatternsString = tempIncludePattern
					.split(delimeterPattern);
			if (includePatternsString != null
					&& includePatternsString.length > 0) {
				includePatterns = Arrays.asList(includePatternsString);
			}
		}
		logger.debug("includePatterns: {}", includePatterns);
		return includePatterns;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.filters.BaseFilterImpl#doFilter(javax.servlet.
	 * ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String requestURI = httpServletRequest.getRequestURI();
		logger.debug("requestURI: {}", requestURI);

		if (this.isFilterRequired(requestURI)) {
			this.preprocessFilterChain(request, response);
		}
		filterChain.doFilter(request, response);
		if (this.isFilterRequired(requestURI)) {
			this.postprocessFilterChain(request, response);
		}
	}

}
