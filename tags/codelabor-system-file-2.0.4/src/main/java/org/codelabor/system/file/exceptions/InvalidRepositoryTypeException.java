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
package org.codelabor.system.file.exceptions;

/**
 * 유효하지 않은 파일 업로드 방식 예외
 * 
 * @author Shin Sangjae
 * 
 */
public class InvalidRepositoryTypeException extends Exception {

	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -2103074649870584772L;

	/**
	 * 생성자
	 */
	public InvalidRepositoryTypeException() {
		super();
	}

	/**
	 * 생성자
	 * 
	 * @param message
	 *            메시지
	 * @param cause
	 *            원인
	 */
	public InvalidRepositoryTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 생성자
	 * 
	 * @param message
	 *            메시지
	 */
	public InvalidRepositoryTypeException(String message) {
		super(message);
	}

	/**
	 * 생성자
	 * 
	 * @param cause
	 *            원인
	 */
	public InvalidRepositoryTypeException(Throwable cause) {
		super(cause);
	}

}
