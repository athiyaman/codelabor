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

package org.codelabor.system.anyframe.web.listener;

import org.anyframe.util.properties.PropertiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

/**
 * @author Shin Sang-jae
 * 
 */
public class BaseListener {

	protected Logger logger = LoggerFactory.getLogger(BaseListener.class);
	protected String loggerName = this.getClass().getName();
	protected MessageSource messageSource;
	protected PropertiesService propertiesService;

	public String getLoggerName() {
		return loggerName;
	}

	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
		this.logger = LoggerFactory.getLogger(loggerName);
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public PropertiesService getPropertiesService() {
		return propertiesService;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void setPropertiesService(PropertiesService propertiesService) {
		this.propertiesService = propertiesService;
	}

}
