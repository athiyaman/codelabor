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

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import anyframe.common.util.StringUtil;

/**
 * @author bomber
 * 
 */
public class EncodingFilter extends BaseFilterImpl {
	protected String encoding = "UTF-8";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		String requestBeforeCharacterEncoding = request.getCharacterEncoding();
		String responseBeforeCharacterEncoding = response
				.getCharacterEncoding();

		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);

		String requestAfterCharacterEncoding = request.getCharacterEncoding();
		String responseAfterCharacterEncoding = response.getCharacterEncoding();
		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("request character encoding: ");
			sb.append(requestBeforeCharacterEncoding);
			sb.append(" -> ");
			sb.append(requestAfterCharacterEncoding);
			sb.append(", ");
			sb.append("response character encoding: ");
			sb.append(responseBeforeCharacterEncoding);
			sb.append(" -> ");
			sb.append(responseAfterCharacterEncoding);
			log.debug(sb.toString());
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
		String tempEncoding = filterConfig.getInitParameter("encoding");
		if (StringUtil.isNotEmpty(tempEncoding))
			encoding = tempEncoding;
	}
}
