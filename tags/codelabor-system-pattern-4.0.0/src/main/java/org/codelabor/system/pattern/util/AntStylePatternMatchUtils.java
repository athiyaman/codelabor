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
package org.codelabor.system.pattern.util;

import java.util.List;

import org.codelabor.system.util.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;

/**
 * Ant Style 패턴 매처 유틸리티
 * 
 * @author Shin Sang-jae
 * 
 */
public class AntStylePatternMatchUtils {
	/**
	 * 로거
	 */
	static private Logger logger = LoggerFactory.getLogger(AntStylePatternMatchUtils.class);

	/**
	 * 패턴 일치 여부를 확인한다.
	 * 
	 * @param pattern
	 *            패턴
	 * @param inputString
	 *            확인 대상 문자열
	 * @return 패턴 일치 여부
	 */
	static public boolean matches(String pattern, String inputString) {
		AntPathMatcher antPathMatcher = new AntPathMatcher();
		return antPathMatcher.match(pattern, inputString);
	}

	/**
	 * 패턴 일치 여부를 확인한다.
	 * 
	 * @param patternList
	 *            패턴 List
	 * @param inputString
	 *            확인 대상 문자열
	 * @return 패턴 일치 여부
	 */
	static public boolean matches(List<String> patternList, String inputString) {
		return matches(patternList, null, inputString);
	}

	/**
	 * 패턴 일치 여부를 확인한다.
	 * 
	 * @param includesPatternList
	 *            포함할 패턴 List
	 * @param excludesPatternList
	 *            제외할 패턴 List
	 * @param inputString
	 *            확인 대상 문자열
	 * @return 패턴 일치 여부
	 */
	static public boolean matches(List<String> includesPatternList, List<String> excludesPatternList, String inputString) {
		boolean isMatched = false;
		if (includesPatternList != null) {
			if (excludesPatternList != null && ListUtils.containsByAntStylePattern(excludesPatternList, inputString)) {
				// bypass
			} else {
				if (ListUtils.containsByAntStylePattern(includesPatternList, inputString)) {
					isMatched = true;
				}
			}

		}
		logger.debug("isMatched: {}", isMatched);
		return isMatched;
	}
}
