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

import org.codelabor.system.pattern.util.RegexPatternMatcherUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 * 
 */
public class RegexPatternMatcherImpl implements PatternMatcher {

	private Logger logger = LoggerFactory.getLogger(RegexPatternMatcherImpl.class);
	private List<String> includesPatternList;
	private List<String> excludesPatternList;
	private List<Pattern> includesRegexpPatternList = new ArrayList<Pattern>();
	private List<Pattern> excludesRegexpPatternList = new ArrayList<Pattern>();

	public List<String> getIncludesPatternList() {
		return includesPatternList;
	}

	public void setIncludesPatternList(List<String> includesPatternList) {
		this.includesPatternList = includesPatternList;
		for (String includesPattern : includesPatternList) {
			includesRegexpPatternList.add(Pattern.compile(includesPattern));
		}
	}

	public List<String> getExcludesPatternList() {
		return excludesPatternList;
	}

	public void setExcludesPatternList(List<String> excludesPatternList) {
		this.excludesPatternList = excludesPatternList;
		for (String excludesPattern : excludesPatternList) {
			excludesRegexpPatternList.add(Pattern.compile(excludesPattern));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.pattern.PatternMatcher#maches(java.lang.String)
	 */
	public boolean maches(String inputString) {
		boolean isMatched = false;
		for (Pattern includesRegexpPattern : includesRegexpPatternList) {
			if (includesRegexpPattern.matcher(inputString).matches()) {
				isMatched = true;
			}
			logger.debug("includesRegexpPattern: {}, isMatched: {}", includesRegexpPattern, isMatched);
		}
		for (Pattern excludesRegexpPattern : excludesRegexpPatternList) {
			if (excludesRegexpPattern.matcher(inputString).matches()) {
				isMatched = false;
			}
			logger.debug("excludesRegexpPattern: {}, isMatched: {}", excludesRegexpPattern, isMatched);
		}
		logger.debug("isMatched: {}", isMatched);
		return isMatched;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.pattern.PatternMatcher#maches(java.lang.String,
	 * java.lang.String)
	 */
	public boolean maches(String pattern, String inputString) {
		return RegexPatternMatcherUtils.matches(pattern, inputString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.pattern.PatternMatcher#maches(java.util.List,
	 * java.lang.String)
	 */
	public boolean maches(List<String> patternList, String inputString) {
		return RegexPatternMatcherUtils.matches(includesPatternList, inputString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.pattern.PatternMatcher#maches(java.util.List,
	 * java.util.List, java.lang.String)
	 */
	public boolean maches(List<String> includesPatternList, List<String> excludesPatternList, String inputString) {
		return RegexPatternMatcherUtils.matches(includesPatternList, excludesPatternList, inputString);
	}

}
