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

package org.codelabor.system.dtos;

import java.io.Serializable;

import org.codelabor.system.anyframe.MessageType;

/**
 * 에러 메시지 DTO
 * 
 * @author Shin Sangjae
 * 
 */
public class MessageDTO implements Serializable {
	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -7653402956922788460L;

	/**
	 * 메시지 유형
	 */
	private MessageType messageType;

	/**
	 * 메시지 키
	 */
	private String messageKey;

	/**
	 * 메시지 코드
	 */
	private String messageCode;

	/**
	 * 사용자 메시지
	 */
	private String userMessage;

	/**
	 * 조치 방법
	 */
	private String solution;

	/**
	 * 발생 원인
	 */
	private String reason;

	/**
	 * 생성자
	 */
	public MessageDTO() {
		super();
	}

	/**
	 * 사용자 메시지를 가져온다.
	 * 
	 * @return 사용자 메시지
	 */
	public String getUserMessage() {
		return userMessage;
	}

	/**
	 * 사용자 메시지를 설정한다.
	 * 
	 * @param userMessage
	 *            사용자 메시지
	 */
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	/**
	 * 메시지 코드를 가져온다.
	 * 
	 * @return 메시지 코드
	 */
	public String getMessageCode() {
		return messageCode;
	}

	/**
	 * 메시지 코드를 설정한다.
	 * 
	 * @param messageCode
	 *            메시지 코드
	 */
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	/**
	 * 메시지 유형을 가져온다.
	 * 
	 * @return 메시지 유형
	 */
	public MessageType getMessageType() {
		return messageType;
	}

	/**
	 * 메시지 유형을 설정한다.
	 * 
	 * @param messageType
	 *            메시지 유형
	 */
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	/**
	 * 발생 원인을 가져온다.
	 * 
	 * @return 발생 원인
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * 발생 원인을 설정한다.
	 * 
	 * @param reason
	 *            발생 원인
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * 해결 방법을 가져온다.
	 * 
	 * @return 해결 방법
	 */
	public String getSolution() {
		return solution;
	}

	/**
	 * 해결 방법을 설정한다.
	 * 
	 * @param solution
	 *            해결 방법
	 */
	public void setSolution(String solution) {
		this.solution = solution;
	}

	/**
	 * 메시지 키를 가져온다.
	 * 
	 * @return 메시지 키
	 */
	public String getMessageKey() {
		return messageKey;
	}

	/**
	 * 메시지 키를 설정한다.
	 * 
	 * @param messageKey
	 *            메시지 키
	 */
	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	@Override
	public String toString() {
		final String TAB = "    ";

		StringBuilder retValue = new StringBuilder();

		retValue.append("MessageDTO ( ").append(super.toString()).append(TAB)
				.append("messageType = ").append(this.messageType).append(TAB)
				.append("messageKey = ").append(this.messageKey).append(TAB)
				.append("messageCode = ").append(this.messageCode).append(TAB)
				.append("userMessage = ").append(this.userMessage).append(TAB)
				.append("solution = ").append(this.solution).append(TAB)
				.append("reason = ").append(this.reason).append(TAB).append(
						" )");

		return retValue.toString();
	}
}
