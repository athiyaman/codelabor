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

package org.codelabor.system.exceptions;

import org.springframework.context.MessageSource;

import anyframe.common.exception.BaseException;
import anyframe.common.exception.message.Message;

/**
 * 공통 예외 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public abstract class CommonException extends BaseException {

	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -2522334283452895450L;
	/**
	 * 메시지 코드
	 */
	private String messageCode;

	/**
	 * 생성자
	 */
	public CommonException() {
		super();
	}

	/**
	 * 메시지 코드
	 * 
	 * @param messageCode
	 */
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
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
	public CommonException(MessageSource messageSource, String messageKey,
			Object[] messageParameters, String defaultMessage,
			Throwable wrappedException) {
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
	public CommonException(MessageSource messageSource, String messageKey,
			Object[] messageParameters, String defaultMessage) {
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
	public CommonException(MessageSource messageSource, String messageKey,
			Object[] messageParameters, Throwable wrappedException) {
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
	public CommonException(MessageSource messageSource, String messageKey,
			Object[] messageParameters) {
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
	public CommonException(MessageSource messageSource, String messageKey,
			String defaultMessage, Throwable wrappedException) {
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
	public CommonException(MessageSource messageSource, String messageKey,
			String defaultMessage) {
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
	public CommonException(MessageSource messageSource, String messageKey,
			Throwable wrappedException) {
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
	public CommonException(MessageSource messageSource, String messageKey) {
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
	public CommonException(String messageKey, Object[] messageParameters,
			Throwable wrappedException) {
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
	public CommonException(String messageKey, Object[] messageParameters) {
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
	public CommonException(String messageKey, Throwable wrappedException) {
		super(messageKey, wrappedException);
	}

	/**
	 * 생성자
	 * 
	 * @param messageKey
	 *            메시지 키
	 */
	public CommonException(String messageKey) {
		super(messageKey);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return super.getMessage();
	}

	/**
	 * 메시지 키를 가져온다.
	 * 
	 * @return 메시지 키
	 */
	@Override
	public String getMessageKey() {
		return super.getMessageKey();
	}

	/**
	 * 메시지 파라미터를 가져온다.
	 * 
	 * @return 메시지 파라미터 배열
	 */
	@Override
	public Object[] getMessageParameters() {
		return super.getMessageParameters();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * anyframe.common.exception.message.AnyFrameMessageSource#getMessages()
	 */
	@Override
	public Message getMessages() {
		return super.getMessages();
	}

	/**
	 * 메시지 키를 설정한다.
	 * 
	 * @param messageKey
	 *            메시지 키
	 */
	@Override
	public void setMessageKey(String messageKey) {
		super.setMessageKey(messageKey);
	}

	/**
	 * 메시지 파라미터를 설정한다.
	 * 
	 * @param param
	 *            메시지 파라미터 배열
	 */
	@Override
	public void setMessageParameters(Object[] param) {
		super.setMessageParameters(param);
	}

	/**
	 * 메시지 코드를 가져온다.
	 * 
	 * @return 메시지 코드
	 */
	public String getMessageCode() {
		return this.messageCode;
	}

}
