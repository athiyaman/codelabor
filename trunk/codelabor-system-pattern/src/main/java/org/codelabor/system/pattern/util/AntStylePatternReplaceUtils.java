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

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AntStyle 패턴 치환 유틸리티
 * 
 * @author Shin Sang-jae
 * 
 */
public class AntStylePatternReplaceUtils {
	/**
	 * 로거
	 */
	static private Logger logger = LoggerFactory.getLogger(AntStylePatternReplaceUtils.class);

	/**
	 * 패턴을 치환한다.<br/>
	 * 
	 * @param searchPattern
	 *            검색 패턴
	 * @param replacePattern
	 *            치환 패턴
	 * @param targetString
	 *            치환 대상 문자열
	 * @return 치환 결과 문자열
	 */
	static public String replace(String searchPattern, String replacePattern, String targetString) {
		Pattern pattern = Pattern.compile(antStyleToRegexp(searchPattern));
		Matcher matcher = pattern.matcher(targetString);
		String resultingString = matcher.replaceAll(replacePattern);
		logger.debug("resultingString: {}", resultingString);
		return resultingString;
	}

	/**
	 * 패턴을 치환한다.<br/>
	 * 
	 * @param searchAndReplacePatternMap
	 *            검색 및 치환 패턴 Map
	 * @param targetString
	 *            치환 대상 문자열
	 * @return 치환 결과 문자열
	 */
	static public String replace(Map<String, String> searchAndReplacePatternMap, String targetString) {
		return replace(searchAndReplacePatternMap, null, targetString);
	}

	/**
	 * 패턴을 치환한다.<br/>
	 * 
	 * @param searchAndReplacePatternMap
	 *            검색 및 치환 패턴 Map
	 * @param targetString
	 *            치환 대상 문자열
	 * @return 치환 결과 문자열
	 */
	static public String replace(Map<String, String> searchAndReplacePatternMap, List<String> excludesPatternList, String targetString) {
		String resultingString = targetString;
		if (searchAndReplacePatternMap != null) {
			if (excludesPatternList != null && AntStylePatternMatchUtils.matches(excludesPatternList, targetString)) {
				logger.debug("Pattern excluded.");
				// bypass
			} else {
				Set<String> keySet = searchAndReplacePatternMap.keySet();
				Iterator<String> iter = keySet.iterator();
				while (iter.hasNext()) {
					String searchPattern = iter.next();
					if (AntStylePatternMatchUtils.matches(searchPattern, targetString)) {
						String replacePattern = searchAndReplacePatternMap.get(searchPattern);
						resultingString = replace(antStyleToRegexp(searchPattern), replacePattern, targetString);
						logger.debug("searchPattern: {}, replacePattern: {}", searchPattern, replacePattern);
						logger.debug("targetString: {}, resultingString: {}", targetString, resultingString);
					}
				}
			}
		}
		return resultingString;
	}

	static public String antStyleToRegexp(String antStylePattern) {
		// a.*.**.?.b
		String regexpPattern = antStylePattern.replace(".", "\\.").replace("?", "\\w?").replace("[^*]?*[^*]?", "\\w*").replace("**", "[\\w\\.\\/]*");
		logger.debug("regexpPattern: {}", regexpPattern);
		return regexpPattern;

	}
}
