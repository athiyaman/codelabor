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

package org.codelabor.system.access.dtos;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 접근 로그 DTO
 * 
 * @author Shin Sangjae
 * 
 */
public class AccessLogDTO implements Serializable {

	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -8079212665085519859L;

	// 일련번호
	private int seq;

	// 사용자
	private String username;

	// 대상
	private String target;

	// 이벤트
	private String event;

	// 접속 주소
	private String ipAddress;

	// 시간
	private Timestamp timestamp;

	/**
	 * 접속 주소를 가져온다.
	 * 
	 * @return 접속 주소
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * 접속 주소를 설정한다.
	 * 
	 * @param ipAddress
	 *            접속 주소
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * 이벤트 정보를 가져온다.
	 * 
	 * @return 이벤트 정보
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * 이벤트 정보를 설정한다.
	 * 
	 * @param message
	 *            이벤트 정보
	 */
	public void setEvent(String message) {
		this.event = message;
	}

	/**
	 * 대상을 가져온다.
	 * 
	 * @return 리소스 Id
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * 대상을 지정한다.
	 * 
	 * @param resourceId
	 *            리소스 Id
	 */
	public void setTarget(String resourceId) {
		this.target = resourceId;
	}

	/**
	 * 시간을 가져온다.
	 * 
	 * @return 시간
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * 시간을 설정한다.
	 * 
	 * @param timestamp
	 *            시간
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * 사용자명을 가져온다.
	 * 
	 * @return 사용자명
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 사용자명을 설정한다.
	 * 
	 * @param username
	 *            사용자명
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 일련번호를 가져온다.
	 * 
	 * @return 일련번호
	 */
	public int getSeq() {
		return seq;
	}

	/**
	 * 일련번호를 설정한다.
	 * 
	 * @param seq
	 *            일련번호
	 */
	public void setSeq(int seq) {
		this.seq = seq;
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

		retValue.append("AccessLogDTO ( ").append(super.toString()).append(TAB)
				.append("seq = ").append(this.seq).append(TAB).append(
						"userId = ").append(this.username).append(TAB).append(
						"resource = ").append(this.target).append(TAB).append(
						"message = ").append(this.event).append(TAB).append(
						"ipAddress = ").append(this.ipAddress).append(TAB)
				.append("timestamp = ").append(this.timestamp).append(TAB)
				.append(" )");

		return retValue.toString();
	}
}
