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

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Regex 패턴 매처 유틸리티 테스트 클래스
 * 
 * @author Shin Sang-jae
 * 
 */
public class RegexPatternReplaceUtilsTest {

	/**
	 * 로거
	 */
	private Logger logger = LoggerFactory.getLogger(RegexPatternReplaceUtilsTest.class);
	/**
	 * 검색 및 치환 패턴 Map
	 */
	private Map<String, String> searchAndReplacePatternMap = new HashMap<String, String>();
	/**
	 * 제외할 패턴 List
	 */
	private List<String> excludesPatternList = new ArrayList<String>();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// or 1=1--
		searchAndReplacePatternMap.put("(.*)(?i)or\\s+(.*)\\s*=\\s*\\2\\s*--(.*)", "$1$3");

		// ' or 1=1--
		searchAndReplacePatternMap.put("(.*)'\\s+(?i)or\\s+(.*)\\s*=\\s*\\2\\s*--(.*)", "$1'$3");

		// " or 1=1--
		searchAndReplacePatternMap.put("(.*)\"\\s+(?i)or\\s+(.*)\\s*=\\s*\\2\\s*--(.*)", "$1\"$3");

		// ' or 'a'='a
		searchAndReplacePatternMap.put("(.*)'\\s+(?i)or\\s+'(.*)'\\s*=\\s*'\\2(.*)", "$1'$3");

		// " or "a"="a
		searchAndReplacePatternMap.put("(.*)\"\\s+(?i)or\\s+\"(.*)\"\\s*=\\s*\"\\2(.*)", "$1\"$3");

		// ') or ('a'='a
		searchAndReplacePatternMap.put("(.*)'\\)\\s+(?i)or\\s+\\('(.*)'\\s*=\\s*'\\2(.*)", "$1'$3");

		// ' or password like '%
		searchAndReplacePatternMap.put("(.*)'\\s+(?i)or\\s+(password)\\s+(like)\\s+'%(.*)", "$1'$4");

		// ' or 1=1--
		excludesPatternList.add("(.*)'\\s+(?i)or\\s+(.*)\\s*=\\s*\\2\\s*--(.*)");
	}

	@Test
	public void testReplaceStringStringString() {
		String searchPattern = "(.*)'\\s+(?i)or\\s+(.*)\\s*=\\s*\\2\\s*--(.*)";
		String replacePattern = "$1'$3";
		String targetString = "qwer ' or 1=1-- qwer";
		String expectedString = "qwer ' qwer";
		String resultingString = RegexPatternReplaceUtils.replace(searchPattern, replacePattern, targetString);
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);

		searchPattern = "(.*)\"\\s+(?i)or\\s+(.*)\\s*=\\s*\\2\\s*--(.*)";
		replacePattern = "$1\"$3";
		targetString = "qwer \" or 1=1-- qwer";
		expectedString = "qwer \" qwer";
		resultingString = RegexPatternReplaceUtils.replace(searchPattern, replacePattern, targetString);
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);
	}

	@Test
	public void testReplaceMapString() {
		String targetString = "' or 1=1--";
		String resultingString = RegexPatternReplaceUtils.replace(searchAndReplacePatternMap, targetString);
		String expectedString = "'";
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);
	}

	@Test
	public void testReplaceMapListString() {
		String targetString = "qwer ' or 1=1-- qwer";
		String resultingString = RegexPatternReplaceUtils.replace(searchAndReplacePatternMap, excludesPatternList, targetString);
		String expectedString = "qwer ' or 1=1-- qwer";
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);

		targetString = "qwer \" or 1=1-- qwer";
		resultingString = RegexPatternReplaceUtils.replace(searchAndReplacePatternMap, excludesPatternList, targetString);
		expectedString = "qwer \"  qwer";
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);

		targetString = "qwer or 1=1-- qwer";
		resultingString = RegexPatternReplaceUtils.replace(searchAndReplacePatternMap, excludesPatternList, targetString);
		expectedString = "qwer  qwer";
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);

		targetString = "qwer ' or 'a'='a qwer";
		resultingString = RegexPatternReplaceUtils.replace(searchAndReplacePatternMap, excludesPatternList, targetString);
		expectedString = "qwer ' qwer";
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);

		targetString = "qwer \" or \"a\"=\"a qwer";
		resultingString = RegexPatternReplaceUtils.replace(searchAndReplacePatternMap, excludesPatternList, targetString);
		expectedString = "qwer \" qwer";
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);

		targetString = "qwer ') or ('a'='a qwer";
		resultingString = RegexPatternReplaceUtils.replace(searchAndReplacePatternMap, excludesPatternList, targetString);
		expectedString = "qwer ' qwer";
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);

		targetString = "qwer ' or password like '% qwer";
		resultingString = RegexPatternReplaceUtils.replace(searchAndReplacePatternMap, excludesPatternList, targetString);
		expectedString = "qwer ' qwer";
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);

	}

	@Test
	public void testReplaceMapListString2() {
		String targetString = "qwer or 1=1-- qwer qwer or 1=1-- qwer";
		String resultingString = RegexPatternReplaceUtils.replace(searchAndReplacePatternMap, excludesPatternList, targetString);
		String expectedString = "qwer  qwer qwer  qwer";
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);
	}
}
