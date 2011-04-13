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

package org.codelabor.system.web.dto;

import java.io.Serializable;
import java.util.Locale;

/**
 * 기타 DTO
 * 
 * @author Shin Sang-jae
 * 
 */
public class EtcDTO implements Serializable {
	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -1907156113016222526L;
	/**
	 * 컨텐트 길이
	 */
	protected int contentLength;
	/**
	 * 컨텐트 타입
	 */
	protected String contentType;
	/**
	 * 프로토콜
	 */
	protected String protocol;
	/**
	 * 스키마
	 */
	protected String scheme;
	/**
	 * 캐릭터 인코딩
	 */
	protected String characterEncoding;
	/**
	 * 로케일
	 */
	protected Locale locale;

	/**
	 * 컨텐트 길이를 가져온다.
	 * 
	 * @return 컨텐트 길이
	 */
	public int getContentLength() {
		return contentLength;
	}

	/**
	 * 컨텐트 길이를 설정한다.
	 * 
	 * @param contentLength
	 *            컨텐트 길이
	 */
	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}

	/**
	 * 컨텐트 타입을 가져온다.
	 * 
	 * @return 컨텐트 타입
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * 컨텐트 타입을 설정한다.
	 * 
	 * @param contentType
	 *            컨텐트 타입
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * 프로토콜을 가져온다.
	 * 
	 * @return 프로토콜
	 */
	public String getProtocol() {
		return protocol;
	}

	/**
	 * 프로토콜을 설정한다.
	 * 
	 * @param protocol
	 *            프로토콜
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/**
	 * 스키마를 가져온다.
	 * 
	 * @return 스키마
	 */
	public String getScheme() {
		return scheme;
	}

	/**
	 * 스키마를 설정한다.
	 * 
	 * @param scheme
	 *            스키마
	 */
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	/**
	 * 캐릭터 인코딩을 가져온다.
	 * 
	 * @return 캐릭터 인코딩
	 */
	public String getCharacterEncoding() {
		return characterEncoding;
	}

	/**
	 * 캐릭터 인코딩을 설정한다.
	 * 
	 * @param characterEncoding
	 *            캐릭터 인코딩
	 */
	public void setCharacterEncoding(String characterEncoding) {
		this.characterEncoding = characterEncoding;
	}

	/**
	 * 로케일을 가져온다.
	 * 
	 * @return 로케일
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * 로케일을 설정한다.
	 * 
	 * @param locale
	 *            로케일
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
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

		retValue.append("EtcDTO ( ").append(super.toString()).append(TAB)
				.append("characterEncoding = ").append(this.characterEncoding)
				.append(TAB).append("contentLength = ").append(
						this.contentLength).append(TAB)
				.append("contentType = ").append(this.contentType).append(TAB)
				.append("locale = ").append(this.locale).append(TAB).append(
						"protocol = ").append(this.protocol).append(TAB)
				.append("scheme = ").append(this.scheme).append(TAB).append(
						" )");

		return retValue.toString();
	}
}
