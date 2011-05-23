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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Regex 패턴 치환 유틸리티
 * 
 * @author Shin Sang-jae
 * 
 */
public class RegexPatternReplaceUtils {
	/**
	 * 로거
	 */
	static private Logger logger = LoggerFactory.getLogger(RegexPatternReplaceUtils.class);

	/**
	 * 패턴 일치 여부를 확인한다.
	 * 
	 * @param pattern
	 *            패턴
	 * @param inputString
	 *            치환 대상 문자열
	 * @return 치환 결과 문자열
	 */
	static public String replace(String searchPattern, String replacePattern, String targetString) {
		Pattern pattern = Pattern.compile(searchPattern);
		Matcher matcher = pattern.matcher(targetString);
		String resultingString = matcher.replaceAll(replacePattern);
		logger.debug("resultingString: {}", resultingString);
		return resultingString;
	}

	/**
	 * 패턴 일치 여부를 확인한다.
	 * 
	 * @param patternList
	 *            패턴 List
	 * @param inputString
	 *            치환 대상 문자열
	 * @return 치환 결과 문자열
	 */
	// static public String replace(List<String> patternList, String
	// inputString) {
	// return replace(patternList, null, inputString);
	// }

	/**
	 * 패턴 일치 여부를 확인한다.
	 * 
	 * @param includesPatternList
	 *            포함할 패턴 List
	 * @param excludesPatternList
	 *            제외할 패턴 List
	 * @param inputString
	 *            치환 대상 문자열
	 * @return 치환 결과 문자열
	 */
	// static public String replace(List<String> includesPatternList,
	// List<String> excludesPatternList, String inputString) {
	// boolean isMatched = false;
	// if (includesPatternList != null) {
	// if (ListUtils.containsByRegexPattern(includesPatternList, inputString)) {
	// isMatched = true;
	// }
	// if (excludesPatternList != null &&
	// ListUtils.containsByRegexPattern(excludesPatternList, inputString)) {
	// isMatched = false;
	// }
	// }
	// logger.debug("isMatched: {}", isMatched);
	// return isMatched;
	// }
}
