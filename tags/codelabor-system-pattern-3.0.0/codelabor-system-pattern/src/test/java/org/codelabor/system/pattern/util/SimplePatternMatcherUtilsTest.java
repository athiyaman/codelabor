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
 * Simple ���� ��ó ��ƿ��Ƽ �׽�Ʈ Ŭ����
 * 
 * @author Shin Sang-jae
 * 
 */
public class SimplePatternMatcherUtilsTest {

	/**
	 * �ΰ�
	 */
	private Logger logger = LoggerFactory.getLogger(SimplePatternMatcherUtilsTest.class);
	/**
	 * ������ ���� ����Ʈ
	 */
	private List<String> includesPatternList = new ArrayList<String>();
	/**
	 * ������ ���� ����Ʈ
	 */
	private List<String> excludesPatternList = new ArrayList<String>();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		includesPatternList.add("1234");
		includesPatternList.add("abcd");
		includesPatternList.add("�����ٶ�");
		excludesPatternList.add("1234");
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.pattern.util.SimplePatternMatcherUtils#matches(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testMachesStringString() {
		String pattern = "abcd";
		String inputString = "abcd";
		boolean isMatched = SimplePatternMatcherUtils.matches(pattern, inputString);
		logger.debug("isMatched: {}", isMatched);
		assertEquals(true, isMatched);
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.pattern.util.SimplePatternMatcherUtils#matches(java.util.List, java.lang.String)}
	 * .
	 */
	@Test
	public void testMachesListOfStringString() {
		String inputString = "abcd";
		boolean isMatched = SimplePatternMatcherUtils.matches(includesPatternList, inputString);
		logger.debug("isMatched: {}", isMatched);
		assertEquals(true, isMatched);
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.pattern.util.SimplePatternMatcherUtils#matches(java.util.List, java.util.List, java.lang.String)}
	 * .
	 */
	@Test
	public void testMachesListOfStringListOfStringString() {
		String inputString = "1234";
		boolean isMatched = SimplePatternMatcherUtils.matches(includesPatternList, excludesPatternList, inputString);
		logger.debug("isMatched: {}", isMatched);
		assertEquals(false, isMatched);
	}

}
