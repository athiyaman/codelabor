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

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.codelabor.system.sniffer.util.SniffingUtils;
import org.codelabor.system.web.filters.BaseFilterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 스니핑 필터
 * 
 * @author Shin Sangjae
 * 
 */
public class SniffingFilter extends BaseFilterImpl {
	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory.getLogger(SniffingFilter.class);

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
	@Override
	public void preprocessFilterChain(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
		try {
			logger.debug("request: {}", SniffingUtils.toString(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
