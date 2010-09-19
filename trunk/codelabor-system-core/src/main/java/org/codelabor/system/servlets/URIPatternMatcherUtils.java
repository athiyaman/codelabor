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

package org.codelabor.system.servlets;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.codelabor.system.utils.FileUtils;
import org.codelabor.system.utils.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * URI 패턴 매처 유틸
 * 
 * @author Shin Sangjae
 * 
 */
public class URIPatternMatcherUtils {
	/**
	 * 로거
	 */
	private static Logger logger = LoggerFactory
			.getLogger(URIPatternMatcherUtils.class);

	/**
	 * Ant 스타일 패스 패턴에 매칭되는지 확인한다.
	 * 
	 * @param includePatterns
	 *            포함할 패턴
	 * @param excludePatterns
	 *            제외할 패턴
	 * @param requestURI
	 *            요청받은 URI
	 * @return 매칭 여부
	 */
	static public boolean matchByAntStylePathPattern(
			List<String> includePatterns, List<String> excludePatterns,
			String requestURI) {
		boolean isMatched = false;

		if (excludePatterns != null) {
			if (ListUtils
					.containsByAntStylePattern(excludePatterns, requestURI)) {
				// bypass
			} else {
				if (includePatterns != null) {
					if (ListUtils.containsByAntStylePattern(includePatterns,
							requestURI)) {
						isMatched = true;
					} else {
						isMatched = false;
					}
				} else {
					isMatched = true;
				}
			}
		} else {
			if (includePatterns != null) {
				if (ListUtils.containsByAntStylePattern(includePatterns,
						requestURI)) {
					isMatched = true;
				} else {
					isMatched = false;
				}
			} else {
				isMatched = true;
			}
		}
		logger.debug("isMatched: {}", isMatched);
		return isMatched;
	}

	/**
	 * URI가 패턴에 매칭되는지 확인한다.
	 * 
	 * @param includePatterns
	 *            포함할 패턴
	 * @param excludePatterns
	 *            제외할 패턴
	 * @param requestURI
	 *            요청받은 URI
	 * @return 매칭 여부
	 */
	static public boolean matchByURI(List<String> includePatterns,
			List<String> excludePatterns, String requestURI) {
		boolean isMatched = false;

		if (excludePatterns != null) {
			if (excludePatterns.contains(requestURI)) {
				// bypass
			} else {
				if (includePatterns != null) {
					if (includePatterns.contains(requestURI)) {
						isMatched = true;
					} else {
						isMatched = false;
					}
				} else {
					isMatched = true;
				}
			}
		} else {
			if (includePatterns != null) {
				if (includePatterns.contains(requestURI)) {
					isMatched = true;
				} else {
					isMatched = false;
				}
			} else {
				isMatched = true;
			}
		}
		logger.debug("isMatched: {}", isMatched);
		return isMatched;
	}

	/**
	 * 확장자 패턴에 매칭되는지 확인한다.
	 * 
	 * @param includePatterns
	 *            포함할 패턴
	 * @param excludePatterns
	 *            제외할 패턴
	 * @param requestURI
	 *            요청 받은 URI
	 * @return 매칭 여부
	 */
	static public boolean matchByExtension(List<String> includePatterns,
			List<String> excludePatterns, String requestURI) {
		boolean isMatched = false;

		String extension = FileUtils.getExtension(requestURI);
		if (!StringUtils.isBlank(extension)) {
			extension = extension.toLowerCase();
		}
		logger.debug("extension: {}", extension);

		if (excludePatterns != null) {
			if (excludePatterns.contains(extension)) {
				// bypass
			} else {
				if (includePatterns != null) {
					if (includePatterns.contains(extension)) {
						isMatched = true;
					} else {
						isMatched = false;
					}
				} else {
					isMatched = true;
				}
			}
		} else {
			if (includePatterns != null) {
				if (includePatterns.contains(extension)) {
					isMatched = true;
				} else {
					isMatched = false;
				}
			} else {
				isMatched = true;
			}
		}
		logger.debug("isMatched: {}", isMatched);
		return isMatched;
	}
}
