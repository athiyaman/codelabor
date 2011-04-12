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

package org.codelabor.system.anyframe.web.struts.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.struts.ActionSupport;

import anyframe.core.properties.IPropertiesService;

/**
 * 기본 Action Support 클래스
 * 
 * @author Shin Sang-jae
 * 
 */
public class BaseActionSupport extends ActionSupport {

	/**
	 * 로거
	 */
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 프로퍼티 서비스
	 */
	protected IPropertiesService propertiesService;
	/**
	 * 메시지 소스
	 */
	protected MessageSource messageSource;
	/**
	 * 웹 어플리케이션 컨텍스트
	 */
	protected WebApplicationContext webApplicationContext;

	/**
	 * 생성자
	 */
	public BaseActionSupport() {
		super();
		webApplicationContext = getWebApplicationContext();
		propertiesService = (IPropertiesService) webApplicationContext
				.getBean("propertiesService");
		messageSource = (MessageSource) webApplicationContext
				.getBean("messageSource");
	}

}
