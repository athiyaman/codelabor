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
package org.codelabor.system.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 예외 유틸리트
 * @author Shin Sang-jae
 *
 */
public class ExceptionUtils {
	/**
	 * 로거
	 */
	private static Logger logger = LoggerFactory.getLogger(ExceptionUtils.class);

	/**
	 * 최초 발생 예외/에러를 가져온다.
	 * @param throwable 최종 발생 예외/에러 
	 * @return 최조 발생 예외/에러
	 */	
	public static Throwable getRootCause(Throwable throwable) {
		Throwable rootCause = throwable;
		while (true) {
			Throwable cause = throwable.getCause();
			if (cause == null) {
				logger.debug("cause: null");
				rootCause = throwable;
				break;
			} else {
				logger.debug("cause: {}", cause.getClass());
				throwable = cause;
			}
		}
		logger.debug("root cause: {}", rootCause.toString());
		return rootCause;
	}	
}
