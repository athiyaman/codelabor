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
package org.springframework.util;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shin Sangjae
 * 
 */
public class AntPathMatcherTest extends TestCase {
	private Logger logger = LoggerFactory.getLogger(AntPathMatcherTest.class);

	public void testMatch() {
		AntPathMatcher antPathMatcher = new AntPathMatcher();

		String pattern = "/**/*.xml*";
		String path = "/WEB-INF/web.xml";
		boolean isMatched = antPathMatcher.match(pattern, path);
		logger.debug("isMatched: {}", isMatched);
		assertTrue(isMatched);

		pattern = "org/codelabor/*/**/*Service";
		path = "org/codelabor/example/HelloWorldService";
		isMatched = antPathMatcher.match(pattern, path);
		logger.debug("isMatched: {}", isMatched);
		assertTrue(isMatched);

		pattern = "org/codelabor/*/**/*Service?";
		path = "org/codelabor/example/HelloWorldServices";
		isMatched = antPathMatcher.match(pattern, path);
		logger.debug("isMatched: {}", isMatched);
		assertTrue(isMatched);
	}

}
