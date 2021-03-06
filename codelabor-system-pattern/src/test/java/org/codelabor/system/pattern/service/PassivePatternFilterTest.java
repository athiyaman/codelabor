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

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;
import javax.inject.Named;

import org.codelabor.system.pattern.exception.PatternMatchException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 수동적 패턴 필터 테스트 클래스
 *
 * @author Shin Sang-jae
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/**/applicationContext*.xml")
public class PassivePatternFilterTest {

	/**
	 * 로거
	 */
	private Logger logger = LoggerFactory.getLogger(PassivePatternFilterTest.class);

	@Autowired
	ApplicationContext ctx;

	@Inject
	@Named("passivePatternFilter")
	PatternFilter passivePatternFilter;

	@Test(expected = PatternMatchException.class)
	public void testDetectString() {
		String targetString = "' or 1=1--";
		String expectedString = "' or 1=1--";
		String resultingString = passivePatternFilter.filter(targetString);
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);

		targetString = "\" or 1=1--";
		expectedString = "\"";
		resultingString = passivePatternFilter.filter(targetString);
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);

		targetString = "or 1=1--";
		expectedString = "";
		resultingString = passivePatternFilter.filter(targetString);
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);

		targetString = "' or 'a'='a";
		expectedString = "'";
		resultingString = passivePatternFilter.filter(targetString);
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);

		targetString = "\" or \"a\"=\"a";
		expectedString = "\"";
		resultingString = passivePatternFilter.filter(targetString);
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);

		targetString = "') or ('a'='a";
		expectedString = "'";
		resultingString = passivePatternFilter.filter(targetString);
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);

		targetString = "' or password like '%";
		expectedString = "'";
		resultingString = passivePatternFilter.filter(targetString);
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);
	}
}
