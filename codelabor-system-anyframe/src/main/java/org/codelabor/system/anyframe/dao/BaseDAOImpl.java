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

package org.codelabor.system.anyframe.dao;

import org.anyframe.util.properties.PropertiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

/**
 * 기본 DAO 구현 클래스
 * 
 * @author Shin Sang-jae
 * 
 */
public class BaseDAOImpl {
	/**
	 * Id 제네레이션 서비스
	 */
	protected IdGenService idGenerationService;

	/**
	 * 로거
	 */
	protected Logger logger = LoggerFactory.getLogger(BaseDAOImpl.class);

	/**
	 * 로거명
	 */
	protected String loggerName = this.getClass().getName();

	/**
	 * 메시지 소스
	 */
	protected MessageSource messageSource;

	/**
	 * 프로퍼티 서비스
	 */
	protected PropertiesService propertiesService;

	/**
	 * 쿼리 서비스
	 */
	protected QueryService queryService;

	/**
	 * 생성자
	 */
	public BaseDAOImpl() {
		super();
	}

	/**
	 * Id 제네레이션 서비스를 가져온다.
	 * 
	 * @return Id 제네레이션 서비스
	 */
	public IdGenService getIdGenerationService() {
		return idGenerationService;
	}

	/**
	 * 로거명을 가져온다.
	 * 
	 * @return 로거명
	 */
	public String getLoggerName() {
		return loggerName;
	}

	/**
	 * 메시지 소스를 가져온다.
	 * 
	 * @return 메시지 소스
	 */
	public MessageSource getMessageSource() {
		return messageSource;
	}

	/**
	 * 프로퍼티 서비스를 가져온다.
	 * 
	 * @return 프로퍼티 서비스
	 */
	public PropertiesService getPropertiesService() {
		return propertiesService;
	}

	/**
	 * 쿼리 서비스를 가져온다.
	 * 
	 * @return 쿼리 서비스
	 */
	public QueryService getQueryService() {
		return queryService;
	}

	/**
	 * Id 제네레이션 서비스를 설정한다.
	 * 
	 * @param idGenerationService
	 *            Id 제네레이션 서비스
	 */
	public void setIdGenerationService(IdGenService idGenerationService) {
		this.idGenerationService = idGenerationService;
	}

	/**
	 * 로거명을 설정한다.
	 * 
	 * @param loggerName
	 *            로거명
	 */
	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
		this.logger = LoggerFactory.getLogger(loggerName);
	}

	/**
	 * 메시지 소스를 설정한다.
	 * 
	 * @param messageSource
	 *            메시지 소스
	 */
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	/**
	 * 프로퍼티 서비스를 설정한다.
	 * 
	 * @param propertiesService
	 *            프로퍼티 서비스
	 */
	public void setPropertiesService(PropertiesService propertiesService) {
		this.propertiesService = propertiesService;
	}

	/**
	 * 쿼리 서비스를 설정한다.
	 * 
	 * @param queryService
	 *            쿼리 서비스
	 */
	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

}
