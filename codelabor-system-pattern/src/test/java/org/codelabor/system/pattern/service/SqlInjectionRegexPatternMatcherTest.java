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

import static org.junit.Assert.assertTrue;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Shin Sang-jae
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/**/applicationContext*.xml")
public class SqlInjectionRegexPatternMatcherTest {

	private Logger logger = LoggerFactory.getLogger(SqlInjectionRegexPatternMatcherTest.class);

	@Autowired
	ApplicationContext ctx;

	@Inject
	@Named("sqlInjectionRegexPatternMatcher")
	PatternMatcher regexPatternMatcher;

	@Test
	public void testMatches() {
		StringBuilder sb = new StringBuilder();
		sb.append("qwer");
		sb.append(System.getProperty("line.separator"));
		sb.append(" ' or 1=1-- ");
		sb.append(System.getProperty("line.separator"));
		sb.append("qwer");
		String inputString = sb.toString();
		boolean isMatched = regexPatternMatcher.matches(inputString);
		logger.debug("inputString: {}, isMatched: {}", inputString, isMatched);
		assertTrue(isMatched);

		sb.setLength(0);
		sb.append("qwer");
		sb.append(System.getProperty("line.separator"));
		sb.append(" \" or 1=1-- ");
		sb.append(System.getProperty("line.separator"));
		sb.append("qwer");
		inputString = sb.toString();
		isMatched = regexPatternMatcher.matches(inputString);
		logger.debug("inputString: {}, isMatched: {}", inputString, isMatched);
		assertTrue(isMatched);

		sb.setLength(0);
		sb.append("qwer");
		sb.append(System.getProperty("line.separator"));
		sb.append(" ' or 'a'='a ");
		sb.append(System.getProperty("line.separator"));
		sb.append("qwer");
		inputString = sb.toString();
		isMatched = regexPatternMatcher.matches(inputString);
		logger.debug("inputString: {}, isMatched: {}", inputString, isMatched);
		assertTrue(isMatched);

		sb.setLength(0);
		sb.append("qwer");
		sb.append(System.getProperty("line.separator"));
		sb.append(" \" or \"a\"=\"a ");
		sb.append(System.getProperty("line.separator"));
		sb.append("qwer");
		inputString = sb.toString();
		isMatched = regexPatternMatcher.matches(inputString);
		logger.debug("inputString: {}, isMatched: {}", inputString, isMatched);
		assertTrue(isMatched);

		sb.setLength(0);
		sb.append("qwer");
		sb.append(System.getProperty("line.separator"));
		sb.append(" ') or ('a'='a ");
		sb.append(System.getProperty("line.separator"));
		sb.append("qwer");
		inputString = sb.toString();
		isMatched = regexPatternMatcher.matches(inputString);
		logger.debug("inputString: {}, isMatched: {}", inputString, isMatched);
		assertTrue(isMatched);

		sb.setLength(0);
		sb.append("qwer");
		sb.append(System.getProperty("line.separator"));
		sb.append(" ' or password like '% ");
		sb.append(System.getProperty("line.separator"));
		sb.append("qwer");
		inputString = sb.toString();
		isMatched = regexPatternMatcher.matches(inputString);
		logger.debug("inputString: {}, isMatched: {}", inputString, isMatched);
		assertTrue(isMatched);

		sb.setLength(0);
		sb.append("qwer");
		sb.append(System.getProperty("line.separator"));
		sb.append("--");
		sb.append(System.getProperty("line.separator"));
		sb.append("qwer");
		inputString = sb.toString();
		isMatched = regexPatternMatcher.matches(inputString);
		logger.debug("inputString: {}, isMatched: {}", inputString, isMatched);
		assertTrue(isMatched);
	}
}
