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

package org.codelabor.system.managers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.remoting.message.services.MessageAdapterService;
import org.springframework.context.MessageSource;

import anyframe.core.properties.IPropertiesService;

/**
 * @author SangJae Shin
 * 
 */
public class BaseManagerImpl {

	protected MessageSource messageSource;
	protected Log log = LogFactory.getLog(this.getClass());
	protected String loggerName = this.getClass().getName();
	protected IPropertiesService propertiesService;
	protected MessageAdapterService messageAdapterService;

	public BaseManagerImpl() {
		super();
	}

	public String getLoggerName() {
		return loggerName;
	}

	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
		this.log = LogFactory.getLog(loggerName);
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public IPropertiesService getPropertiesService() {
		return propertiesService;
	}

	public void setPropertiesService(IPropertiesService propertiesService) {
		this.propertiesService = propertiesService;
	}

	public MessageAdapterService getMessageAdapterService() {
		return messageAdapterService;
	}

	public void setMessageAdapterService(MessageAdapterService messageAdapterService) {
		this.messageAdapterService = messageAdapterService;
	}

}
