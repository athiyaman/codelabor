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
package org.codelabor.system.security.exception;

/**
 * 인증 오류 예외
 *
 * @author "Shin Sangjae"
 *
 */
public class AuthenticationException extends RuntimeException {

	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = 924196417145549685L;

	/**
	 * 생성자
	 */
	public AuthenticationException() {
	}

	/**
	 * 생성자
	 *
	 * @param message
	 *            메시지
	 */
	public AuthenticationException(String message) {
		super(message);
	}

	/**
	 * 생성자
	 *
	 * @param cause
	 *            원인
	 */
	public AuthenticationException(Throwable cause) {
		super(cause);
	}

	/**
	 * 생성자
	 *
	 * @param message
	 *            메시지
	 * @param cause
	 *            원인
	 */
	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}

}
