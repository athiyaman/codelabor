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
 * Simple 패턴 매처 유틸리티 테스트 클래스
 * 
 * @author Shin Sang-jae
 * 
 */
public class SimplePatternReplaceUtilsTest {

	/**
	 * 로거
	 */
	private Logger logger = LoggerFactory.getLogger(SimplePatternReplaceUtilsTest.class);
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
		searchAndReplacePatternMap.put("qwer", "QWER");
		searchAndReplacePatternMap.put("asdf", "ASDF");
		searchAndReplacePatternMap.put("zxcv", "ZXCV");
		excludesPatternList.add("zxcv");
	}

	@Test
	public void testReplaceStringStringString() {
		String searchPattern = "qwer";
		String replacePattern = "QWER";
		String targetString = "qwer";
		String resultingString = SimplePatternReplaceUtils.replace(searchPattern, replacePattern, targetString);
		logger.debug("resultingString: {}", resultingString);
		String expectedString = "QWER";
		assertEquals(expectedString, resultingString);
	}

	@Test
	public void testReplaceMapString() {
		String targetString = "asdf";
		String resultingString = SimplePatternReplaceUtils.replace(searchAndReplacePatternMap, targetString);
		logger.debug("resultingString: {}", resultingString);
		String expectedString = "ASDF";
		assertEquals(expectedString, resultingString);
	}

	@Test
	public void testReplaceMapListString() {
		String targetString = "zxcv";
		String resultingString = SimplePatternReplaceUtils.replace(searchAndReplacePatternMap, excludesPatternList, targetString);
		logger.debug("resultingString: {}", resultingString);
		String expectedString = "zxcv";
		assertEquals(expectedString, resultingString);
	}
}
