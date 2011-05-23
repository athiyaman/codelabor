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
import java.util.List;

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

	@Test
	public void testReplaceStringStringString() {
		String searchPattern = "(?i)or\\s+'?(.*)'?\\s*=\\s*'?\\1'?";
		String replacePattern = "";
		String targetString = "OR '1'= '1'";
		String resultingString = RegexPatternReplaceUtils.replace(searchPattern, replacePattern, targetString);
		logger.debug("resultingString: {}", resultingString);

		String expectedString = "";
		assertEquals(expectedString, resultingString);
	}

}
