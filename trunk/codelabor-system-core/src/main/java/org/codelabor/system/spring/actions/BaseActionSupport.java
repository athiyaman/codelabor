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

package org.codelabor.system.spring.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.struts.ActionSupport;

import anyframe.core.properties.IPropertiesService;

public class BaseActionSupport extends ActionSupport {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	protected IPropertiesService propertiesService;
	protected MessageSource messageSource;
	protected WebApplicationContext webApplicationContext;

	public BaseActionSupport() {
		super();
		webApplicationContext = getWebApplicationContext();
		propertiesService = (IPropertiesService) webApplicationContext
				.getBean("propertiesService");
		messageSource = (MessageSource) webApplicationContext
				.getBean("messageSource");
	}

}
