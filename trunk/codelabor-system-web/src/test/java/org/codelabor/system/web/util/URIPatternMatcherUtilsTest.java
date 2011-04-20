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
package org.codelabor.system.web.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shin Sang-jae
 * 
 */
public class URIPatternMatcherUtilsTest {

	private Logger logger = LoggerFactory
			.getLogger(URIPatternMatcherUtilsTest.class);

	private List<String> includePatterns = null;
	private List<String> excludePatterns = null;

	@Before
	public void onSetup() throws Exception {
		includePatterns = new ArrayList<String>();
		excludePatterns = new ArrayList<String>();
	}

	@Test
	public void testMatchByAntStylePathPattern() {
		excludePatterns.add("/**/*.do");
		excludePatterns.add("/images/**");
		excludePatterns.add("/css/**");

		logger.debug("includePatterns{}, excludePatterns: {}", includePatterns,
				excludePatterns);

		boolean isMatched = false;
		String testPattern = "/test.do";
		isMatched = URIPatternMatcherUtils.matchByAntStylePathPattern(
				includePatterns, excludePatterns, testPattern);
		logger.debug("testPattern: {}", testPattern);
		assertEquals(false, isMatched);

		testPattern = "/images/test.gif";
		isMatched = URIPatternMatcherUtils.matchByAntStylePathPattern(
				includePatterns, excludePatterns, testPattern);
		logger.debug("testPattern: {}", testPattern);
		assertEquals(false, isMatched);

		testPattern = "/css/test.css";
		isMatched = URIPatternMatcherUtils.matchByAntStylePathPattern(
				includePatterns, excludePatterns, testPattern);
		logger.debug("testPattern: {}", testPattern);
		assertEquals(false, isMatched);
	}

	@Test
	public void testMatchByURI() {
		includePatterns.add("/test.do");
		includePatterns.add("/images/test.gif");
		includePatterns.add("/css/test.css");

		logger.debug("includePatterns{}, excludePatterns: {}", includePatterns,
				excludePatterns);

		boolean isMatched = false;
		String testPattern = "/test.do";
		isMatched = URIPatternMatcherUtils.matchByURI(includePatterns,
				excludePatterns, testPattern);
		logger.debug("testPattern: {}", testPattern);
		assertEquals(true, isMatched);

		testPattern = "/images/test.gif";
		isMatched = URIPatternMatcherUtils.matchByURI(includePatterns,
				excludePatterns, testPattern);
		logger.debug("testPattern: {}", testPattern);
		assertEquals(true, isMatched);

		testPattern = "/css/test.css";
		isMatched = URIPatternMatcherUtils.matchByURI(includePatterns,
				excludePatterns, testPattern);
		logger.debug("testPattern: {}", testPattern);
		assertEquals(true, isMatched);
	}

	@Test
	public void testMatchByExtension() {
		includePatterns.add("asp");
		includePatterns.add("jsp");
		includePatterns.add("php");

		logger.debug("includePatterns{}, excludePatterns: {}", includePatterns,
				excludePatterns);

		boolean isMatched = false;
		String testPattern = "http://test.test.test:8080/test/test.ASP";
		isMatched = URIPatternMatcherUtils.matchByExtension(includePatterns,
				excludePatterns, testPattern);
		logger.debug("testPattern: {}", testPattern);
		assertEquals(true, isMatched);

		testPattern = "/test/test.JSP";
		isMatched = URIPatternMatcherUtils.matchByExtension(includePatterns,
				excludePatterns, testPattern);
		logger.debug("testPattern: {}", testPattern);
		assertEquals(true, isMatched);

		testPattern = "/test/test.php";
		isMatched = URIPatternMatcherUtils.matchByExtension(includePatterns,
				excludePatterns, testPattern);
		logger.debug("testPattern: {}", testPattern);
		assertEquals(true, isMatched);
	}
}
