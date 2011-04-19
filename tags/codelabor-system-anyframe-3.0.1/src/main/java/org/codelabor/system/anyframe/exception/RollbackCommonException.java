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

package org.codelabor.system.anyframe.exception;

import org.codelabor.system.exception.Rollbackable;
import org.springframework.context.MessageSource;

/**
 * 롤백을 하는 예외를 위한 공통 예외 클래스
 * 
 * @author Shin Sang-jae
 * 
 */
public class RollbackCommonException extends CommonException implements
		Rollbackable {

	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -6177604106387046530L;

	/**
	 * 생성자
	 */
	public RollbackCommonException() {
		super();

	}

	/**
	 * 생성자
	 * 
	 * @param messageSource
	 *            메시지 소스
	 * @param messageKey
	 *            메시지 키
	 * @param messageParameters
	 *            메시지 파라미터
	 * @param defaultMessage
	 *            기본 메시지
	 * @param wrappedException
	 *            예외
	 */
	public RollbackCommonException(MessageSource messageSource,
			String messageKey, Object[] messageParameters,
			String defaultMessage, Throwable wrappedException) {
		super(messageSource, messageKey, messageParameters, defaultMessage,
				wrappedException);

	}

	/**
	 * 생성자
	 * 
	 * @param messageSource
	 *            메시지 소스
	 * @param messageKey
	 *            메시지 키
	 * @param messageParameters
	 *            메시지 파라미터
	 * @param defaultMessage
	 *            기본 메시지
	 */
	public RollbackCommonException(MessageSource messageSource,
			String messageKey, Object[] messageParameters, String defaultMessage) {
		super(messageSource, messageKey, messageParameters, defaultMessage);

	}

	/**
	 * 생성자
	 * 
	 * @param messageSource
	 *            메시지 소스
	 * @param messageKey
	 *            메시지 키
	 * @param messageParameters
	 *            메시지 파라미터
	 * @param wrappedException
	 *            예외
	 */
	public RollbackCommonException(MessageSource messageSource,
			String messageKey, Object[] messageParameters,
			Throwable wrappedException) {
		super(messageSource, messageKey, messageParameters, wrappedException);

	}

	/**
	 * 생성자
	 * 
	 * @param messageSource
	 *            메시지 소스
	 * @param messageKey
	 *            메시지 키
	 * @param messageParameters
	 *            메시지 파라미터
	 */
	public RollbackCommonException(MessageSource messageSource,
			String messageKey, Object[] messageParameters) {
		super(messageSource, messageKey, messageParameters);

	}

	/**
	 * 생성자
	 * 
	 * @param messageSource
	 *            메시지 소스
	 * @param messageKey
	 *            메시지 키
	 * @param defaultMessage
	 *            기본 메시지
	 * @param wrappedException
	 *            예외
	 */
	public RollbackCommonException(MessageSource messageSource,
			String messageKey, String defaultMessage, Throwable wrappedException) {
		super(messageSource, messageKey, defaultMessage, wrappedException);

	}

	/**
	 * 생성자
	 * 
	 * @param messageSource
	 *            메시지 소스
	 * @param messageKey
	 *            메시지 키
	 * @param defaultMessage
	 *            기본 메시지
	 */
	public RollbackCommonException(MessageSource messageSource,
			String messageKey, String defaultMessage) {
		super(messageSource, messageKey, defaultMessage);

	}

	/**
	 * 생성자
	 * 
	 * @param messageSource
	 *            메시지 소스
	 * @param messageKey
	 *            메시지 키
	 * @param wrappedException
	 *            예외
	 */
	public RollbackCommonException(MessageSource messageSource,
			String messageKey, Throwable wrappedException) {
		super(messageSource, messageKey, wrappedException);

	}

	/**
	 * 생성자
	 * 
	 * @param messageSource
	 *            메시지 소스
	 * @param messageKey
	 *            메시지 키
	 */
	public RollbackCommonException(MessageSource messageSource,
			String messageKey) {
		super(messageSource, messageKey);

	}

	/**
	 * 생성자
	 * 
	 * @param messageKey
	 *            메시지 키
	 * @param messageParameters
	 *            메시지 파라미터
	 * @param wrappedException
	 *            예외
	 */
	public RollbackCommonException(String messageKey,
			Object[] messageParameters, Throwable wrappedException) {
		super(messageKey, messageParameters, wrappedException);

	}

	/**
	 * 생성자
	 * 
	 * @param messageKey
	 *            메시지 키
	 * @param messageParameters
	 *            메시지 파라미터
	 */
	public RollbackCommonException(String messageKey, Object[] messageParameters) {
		super(messageKey, messageParameters);

	}

	/**
	 * 생성자
	 * 
	 * @param messageKey
	 *            메시지 키
	 * @param wrappedException
	 *            예외
	 */
	public RollbackCommonException(String messageKey, Throwable wrappedException) {
		super(messageKey, wrappedException);

	}

	/**
	 * 생성자
	 * 
	 * @param messageKey
	 *            메시지 키
	 */
	public RollbackCommonException(String messageKey) {
		super(messageKey);

	}

}
