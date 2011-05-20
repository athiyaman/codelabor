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

import java.util.List;

import org.codelabor.system.pattern.util.SimplePatternMatcherUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simplep ���� ��ó ���� Ŭ����<br/>
 * ���� ǥ�������� ǥ���� ���Ͽ� ���� ��ġ ���θ� Ȯ���� �� �ִ� ���� ��ó
 * 
 * @author Shin Sang-jae
 * 
 */
public class SimplePatternMatcherImpl implements PatternMatcher {

	/**
	 * �ΰ�
	 */
	private Logger logger = LoggerFactory.getLogger(SimplePatternMatcherImpl.class);
	/**
	 * ������ ���� List (String Ÿ��)
	 */
	private List<String> includesPatternList;
	/**
	 * ������ ���� List (String Ÿ��)
	 */
	private List<String> excludesPatternList;

	/**
	 * ������ ���� List�� �����´�.
	 * 
	 * @return ���� List
	 */
	public List<String> getIncludesPatternList() {
		return includesPatternList;
	}

	/**
	 * ������ ���� List�� �����Ѵ�.
	 * 
	 * @param includesPatternList
	 *            ���� List
	 */
	public void setIncludesPatternList(List<String> includesPatternList) {
		this.includesPatternList = includesPatternList;
	}

	/**
	 * ������ ���� List�� �����´�.
	 * 
	 * @return ���� List
	 */
	public List<String> getExcludesPatternList() {
		return excludesPatternList;
	}

	/**
	 * ������ ���� List�� �����Ѵ�.
	 * 
	 * @param excludesPatternList
	 *            ���� List
	 */
	public void setExcludesPatternList(List<String> excludesPatternList) {
		this.excludesPatternList = excludesPatternList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.pattern.PatternMatcher#maches(java.lang.String)
	 */
	public boolean maches(String inputString) {
		boolean isMatched = false;

		if (includesPatternList.contains(inputString)) {
			isMatched = true;
		}
		logger.debug("includesPatternList: {}, isMatched: {}", includesPatternList, isMatched);

		if (excludesPatternList.contains(inputString)) {
			isMatched = false;
		}
		logger.debug("excludesPatternList: {}, isMatched: {}", excludesPatternList, isMatched);

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
		return SimplePatternMatcherUtils.matches(pattern, inputString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.pattern.PatternMatcher#maches(java.util.List,
	 * java.lang.String)
	 */
	public boolean maches(List<String> patternList, String inputString) {
		return SimplePatternMatcherUtils.matches(includesPatternList, inputString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.pattern.PatternMatcher#maches(java.util.List,
	 * java.util.List, java.lang.String)
	 */
	public boolean maches(List<String> includesPatternList, List<String> excludesPatternList, String inputString) {
		return SimplePatternMatcherUtils.matches(includesPatternList, excludesPatternList, inputString);
	}

}
