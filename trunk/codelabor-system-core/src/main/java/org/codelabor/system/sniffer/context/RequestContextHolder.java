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

package org.codelabor.system.sniffer.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shin Sang-Jae
 *
 */
public class RequestContextHolder {
	private static final ThreadLocal<RequestContext> contextHolder = new ThreadLocal<RequestContext>();
	private static final Logger logger = LoggerFactory
			.getLogger(RequestContextHolder.class);

	public static RequestContext getContext() {
		logger.debug("getContext");
		RequestContext requestContext = contextHolder.get();
		logger.debug("requestContext: {}", requestContext);
		return requestContext;
	}

	public static void removeContext() {
		RequestContext beforeUserContext = contextHolder.get();
		logger.debug("requestContext (before): {}", beforeUserContext);
		logger.debug("removeContext");
		contextHolder.remove();
		RequestContext afterUserContext = contextHolder.get();
		logger.debug("requestContext (after): {}", afterUserContext);
	}

	public static void setContext(RequestContext requestContext) {
		RequestContext beforeUserContext = contextHolder.get();
		logger.debug("requestContext (before): {}", beforeUserContext);
		logger.debug("setContext");
		contextHolder.set(requestContext);
		RequestContext afterUserContext = contextHolder.get();
		logger.debug("requestContext (after): {}", afterUserContext);
	}
}
