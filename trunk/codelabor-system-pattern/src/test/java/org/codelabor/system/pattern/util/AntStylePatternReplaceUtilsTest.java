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

import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Regex 패턴 매처 유틸리티 테스트 클래스
 * 
 * @author Shin Sang-jae
 * 
 */
public class AntStylePatternReplaceUtilsTest {

	/**
	 * 로거
	 */
	private Logger logger = LoggerFactory.getLogger(AntStylePatternReplaceUtilsTest.class);

	@Test
	public void testAntStyleToRegexp() {
		String antStylePattern = "org/codelabor/*/**/*Service?";
		String regexpPattern = AntStylePatternReplaceUtils.antStyleToRegexp(antStylePattern);
		logger.debug("regexpPattern: {}", regexpPattern);

		String inputString = "org/codelabor/example/HelloWorldService";
		boolean isMatched = Pattern.matches(regexpPattern, inputString);
		logger.debug("inputString: {}, isMatched: {}", inputString, isMatched);
		assertTrue(isMatched);

		inputString = "org/codelabor/example/service/HelloWorldService";
		isMatched = Pattern.matches(regexpPattern, inputString);
		logger.debug("inputString: {}, isMatched: {}", inputString, isMatched);
		assertTrue(isMatched);

		inputString = "org/codelabor/example/helloworld/service/HelloWorldService";
		isMatched = Pattern.matches(regexpPattern, inputString);
		logger.debug("inputString: {}, isMatched: {}", inputString, isMatched);
		assertTrue(isMatched);

		inputString = "org/codelabor/example/helloworld/service/HelloWorldServices";
		isMatched = Pattern.matches(regexpPattern, inputString);
		logger.debug("inputString: {}, isMatched: {}", inputString, isMatched);
		assertTrue(isMatched);
	}
}
