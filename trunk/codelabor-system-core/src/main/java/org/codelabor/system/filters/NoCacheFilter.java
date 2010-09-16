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

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.servlets.HttpResponseHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 노 캐쉬 필터
 * 
 * @author Shin Sangjae
 * 
 */
public class NoCacheFilter extends BaseFilterImpl {

	/**
	 * 로거
	 */
	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(NoCacheFilter.class);

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
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		// Prevents caching at the proxy server.
		httpServletResponse.setDateHeader(HttpResponseHeader.EXPIRES, 0);

		// Set standard HTTP/1.0 no-cache header.
		httpServletResponse.setHeader(HttpResponseHeader.PRAGMA, "no-cache");

		// Set standard HTTP/1.1 no-cache headers.
		httpServletResponse.setHeader(HttpResponseHeader.CACHE_CONTROL,
				"no-cache");

		// httpServletResponse.setHeader(HttpResponseHeader.CACHE_CONTROL,
		// "no-store, no-cache, must-revalidate");

		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		// httpServletResponse.setHeader(HttpResponseHeader.CACHE_CONTROL,
		// "post-check=0, pre-check=0");
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
