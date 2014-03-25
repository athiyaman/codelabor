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
package org.codelabor.system.sniffer.web.listener;

import java.util.UUID;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.codelabor.system.sniffer.context.RequestContext;
import org.codelabor.system.sniffer.context.RequestContextHolder;
import org.codelabor.system.sniffer.context.RequestContextImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shin Sang-Jae
 *
 */
public class RequestContextGenerationListener implements ServletRequestListener {

	private static final Logger logger = LoggerFactory
			.getLogger(RequestContextGenerationListener.class);

	public void requestDestroyed(ServletRequestEvent sre) {
		logger.debug("requestDestroyed");
		logger.debug("request id: {}", RequestContextHolder.getContext()
				.getRequestId());
		RequestContextHolder.removeContext();
	}

	public void requestInitialized(ServletRequestEvent sre) {
		logger.debug("requestInitialized");
		UUID requestId = UUID.randomUUID();
		logger.info("request id: {}", requestId.toString());

		RequestContext context = RequestContextHolder.getContext();
		if (context == null) {
			context = new RequestContextImpl();
			context.setRequestId(requestId.toString());
			RequestContextHolder.setContext(context);
		}
		sre.getServletRequest().setAttribute("requestId", requestId.toString());
		logger.debug("request id: {}", RequestContextHolder.getContext()
				.getRequestId());
	}

}
