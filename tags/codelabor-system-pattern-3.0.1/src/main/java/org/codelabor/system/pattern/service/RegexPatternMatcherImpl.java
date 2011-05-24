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
package org.codelabor.system.pattern.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.codelabor.system.pattern.util.RegexPatternMatchUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Regex 패턴 매처 구현 클래스<br/>
 * 정규 표현식으로 표현된 패턴에 대해 일치 여부를 확인할 수 있는 패턴 매처
 * 
 * @author Shin Sang-jae
 * 
 */
public class RegexPatternMatcherImpl extends AbstractPatternMatcher {

	/**
	 * 로거
	 */
	private Logger logger = LoggerFactory.getLogger(RegexPatternMatcherImpl.class);
	/**
	 * 포함할 패턴 List (Pattern 타입)
	 */
	private List<Pattern> includesRegexPatternList = null;
	/**
	 * 제외할 패턴 List (Pattern 타입)
	 */
	private List<Pattern> excludesRegexPatternList = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.pattern.service.AbstractPatternMatcher#maches(java
	 * .lang.String)
	 */
	public boolean maches(String inputString) {
		logger.debug("includesPatternList: {}", includesPatternList);
		logger.debug("excludesPatternList: {}", excludesPatternList);
		logger.debug("inputString: {}", inputString);
		boolean isMatched = false;
		for (Pattern includesPattern : includesRegexPatternList) {
			if (includesPattern.matcher(inputString).matches()) {
				isMatched = true;
			}
			logger.debug("includesPattern: {}, isMatched: {}", includesPattern, isMatched);
		}
		for (Pattern excludesPattern : excludesRegexPatternList) {
			if (excludesPattern.matcher(inputString).matches()) {
				isMatched = false;
			}
			logger.debug("excludesPattern: {}, isMatched: {}", excludesPattern, isMatched);
		}
		logger.debug("isMatched: {}", isMatched);
		return isMatched;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.pattern.service.AbstractPatternMatcher#maches(java
	 * .lang.String, java.lang.String)
	 */
	public boolean maches(String pattern, String inputString) {
		return RegexPatternMatchUtils.matches(pattern, inputString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.pattern.service.AbstractPatternMatcher#maches(java
	 * .util.List, java.lang.String)
	 */
	public boolean maches(List<String> patternList, String inputString) {
		return RegexPatternMatchUtils.matches(patternList, inputString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.pattern.service.AbstractPatternMatcher#maches(java
	 * .util.List, java.util.List, java.lang.String)
	 */
	public boolean maches(List<String> includesPatternList, List<String> excludesPatternList, String inputString) {
		return RegexPatternMatchUtils.matches(includesPatternList, excludesPatternList, inputString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		if (includesRegexPatternList == null) {
			includesRegexPatternList = new ArrayList<Pattern>();
			for (String includesPattern : includesPatternList) {
				includesRegexPatternList.add(Pattern.compile(includesPattern));
			}
		}
		if (excludesRegexPatternList == null) {
			excludesRegexPatternList = new ArrayList<Pattern>();
			for (String excludesPattern : excludesPatternList) {
				excludesRegexPatternList.add(Pattern.compile(excludesPattern));
			}
		}
	}

}
