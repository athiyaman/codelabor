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
package org.codelabor.system.sniffer.web.servlet.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Shin Sang-Jae
 *
 */
public class SniffingHandlerExceptionResolver implements
		HandlerExceptionResolver, Ordered {

	private static final Logger logger = LoggerFactory
			.getLogger(SniffingHandlerExceptionResolver.class);
	private int order = 0;

	public int getOrder() {
		return order;
	}

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception) {
		logger.error("uri: {}", request.getRequestURI());
		logger.error("hander: {}, exception: {}", handler, exception);
		logger.error("exception message: {}", exception.getMessage());
		return null;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
