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
package org.codelabor.system.pattern.exception;

/**
 * 패턴 일치 예외<br/>
 * 패턴이 일치할 때 발생하는 예외
 * 
 * @author Shin Sang-jae
 * 
 */
public class PatternMatchException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6086069245337155788L;

	/**
	 * 
	 */
	public PatternMatchException() {
	}

	/**
	 * @param message
	 */
	public PatternMatchException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PatternMatchException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PatternMatchException(String message, Throwable cause) {
		super(message, cause);
	}

}
