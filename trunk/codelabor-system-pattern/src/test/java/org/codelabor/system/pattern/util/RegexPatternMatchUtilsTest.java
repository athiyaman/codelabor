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
public class RegexPatternMatchUtilsTest {

	/**
	 * 로거
	 */
	private Logger logger = LoggerFactory
			.getLogger(RegexPatternMatchUtilsTest.class);
	/**
	 * 포함할 패턴 리스트
	 */
	private List<String> includesPatternList = new ArrayList<String>();
	/**
	 * 제외할 패턴 리스트
	 */
	private List<String> excludesPatternList = new ArrayList<String>();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		includesPatternList.add("[0-9]*");
		includesPatternList.add("[a-z]*");
		includesPatternList.add("가나다라");
		excludesPatternList.add("[1-4]*");
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.pattern.util.RegexPatternMatchUtils#matches(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testMachesStringString() {
		String pattern = "[a-z]*";
		String inputString = "qwerasdf";
		boolean isMatched = RegexPatternMatchUtils
				.matches(pattern, inputString);
		logger.debug("isMatched: {}", isMatched);

		assertEquals(true, isMatched);
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.pattern.util.RegexPatternMatchUtils#matches(java.util.List, java.lang.String)}
	 * .
	 */
	@Test
	public void testMachesListOfStringString() {
		String inputString = "abcd";
		boolean isMatched = RegexPatternMatchUtils.matches(includesPatternList,
				inputString);
		logger.debug("isMatched: {}", isMatched);

		assertEquals(true, isMatched);
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.pattern.util.RegexPatternMatchUtils#matches(java.util.List, java.util.List, java.lang.String)}
	 * .
	 */
	@Test
	public void testMachesListOfStringListOfStringString() {
		String inputString = "1234";
		boolean isMatched = RegexPatternMatchUtils.matches(includesPatternList,
				excludesPatternList, inputString);
		logger.debug("isMatched: {}", isMatched);

		assertEquals(false, isMatched);
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.pattern.util.RegexPatternMatchUtils#matches(java.lang.String, java.util.Map)}
	 * .
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testMachesStringMap() {
		String pattern = ".*[%'\"].*";
		Map patternMap = new HashMap();
		patternMap.put("pattern1", "%");
		patternMap.put("pattern2", "'");
		patternMap.put("pattern2", "\"");
		boolean isMatched = RegexPatternMatchUtils.matches(pattern, patternMap);
		logger.debug("isMatched: {}", isMatched);

		assertEquals(true, isMatched);
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.pattern.util.RegexPatternMatchUtils#matches(java.util.List, java.util.Map)}
	 * .
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testMachesListOfStringMap() {
		Map patternMap = new HashMap();
		patternMap.put("pattern1", "%");
		patternMap.put("pattern2", "'");
		patternMap.put("pattern2", "\"");
		boolean isMatched = RegexPatternMatchUtils.matches(includesPatternList,
				patternMap);
		logger.debug("isMatched: {}", isMatched);

		assertEquals(false, isMatched);
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.pattern.util.RegexPatternMatchUtils#matches(java.util.List, java.util.List, java.util.Map)}
	 * .
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testMachesListOfStringListOfStringMap() {
		Map patternMap = new HashMap();
		patternMap.put("pattern1", "%");
		patternMap.put("pattern2", "'");
		patternMap.put("pattern2", "\"");
		boolean isMatched = RegexPatternMatchUtils.matches(includesPatternList,
				excludesPatternList, patternMap);
		logger.debug("isMatched: {}", isMatched);

		assertEquals(false, isMatched);
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.pattern.util.RegexPatternMatchUtils#matches(java.lang.String, java.lang.Object[])}
	 * .
	 */
	@Test
	public void testMachesStringArrayOfObject() {
		String pattern = ".*[%'\"].*";
		Object[] params = new Object[] { "%", "'", "\"" };
		boolean isMatched = RegexPatternMatchUtils.matches(pattern, params);
		logger.debug("isMatched: {}", isMatched);

		assertEquals(true, isMatched);
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.pattern.util.RegexPatternMatchUtils#matches(java.util.List, java.lang.Object[])}
	 * .
	 */
	@Test
	public void testMachesListOfStringArrayOfObject() {
		Object[] params = new Object[] { "%", "'", "\"" };
		boolean isMatched = RegexPatternMatchUtils.matches(includesPatternList,
				params);
		logger.debug("isMatched: {}", isMatched);

		assertEquals(false, isMatched);
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.pattern.util.RegexPatternMatchUtils#matches(java.util.List, java.util.List, java.lang.Object[])}
	 * .
	 */
	@Test
	public void testMachesListOfStringListOfStringArrayOfObject() {
		Object[] params = new Object[] { "%", "'", "\"" };
		boolean isMatched = RegexPatternMatchUtils.matches(includesPatternList,
				excludesPatternList, params);
		logger.debug("isMatched: {}", isMatched);

		assertEquals(false, isMatched);
	}

}
