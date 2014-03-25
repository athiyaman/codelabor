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
 * Array Utility
 *
 * @author Shin Sang-jae
 *
 */
public class ArrayUtils {
	/**
	 * 로거
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(ArrayUtils.class);

	/**
	 * 배열의 내용을 delimeter로 구분하여 문자열 형태로 만든다.
	 *
	 * @param array
	 *            배열
	 * @param delimeter
	 *            구분자
	 * @return List의 내용이 delimeter로 구분되어 나열된 문자열
	 */
	public static <T> String toDelimetedString(T[] array, String delimeter) {
		if (array.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (T arrayItem : array) {
			sb.append(arrayItem);
			sb.append(delimeter);
		}
		sb.delete(sb.length() - delimeter.length(), sb.length());
		logger.debug("delimeted string: {}", sb.toString());
		return sb.toString();
	}
}
