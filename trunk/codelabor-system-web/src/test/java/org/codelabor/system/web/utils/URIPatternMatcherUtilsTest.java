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
package org.codelabor.system.web.utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.codelabor.system.web.util.URIPatternMatcherUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Shin Sang-jae
 * 
 */
public class URIPatternMatcherUtilsTest {

	private final List<String> includePatterns = new ArrayList<String>();
	private final List<String> excludePatterns = new ArrayList<String>();

	@Before
	public void onSetup() throws Exception {
		excludePatterns.add("/remoteAdapter.do");
		excludePatterns.add("/images/**");
		excludePatterns.add("/css/**");
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.web.util.URIPatternMatcherUtils#matchByAntStylePathPattern(java.util.List, java.util.List, java.lang.String)}
	 * .
	 */
	@Test
	public void testMatchByAntStylePathPattern() {
		boolean isMatched = false;
		isMatched = URIPatternMatcherUtils.matchByAntStylePathPattern(
				includePatterns, excludePatterns, "/remoteAdapter.do");
		assertEquals(false, isMatched);
		isMatched = URIPatternMatcherUtils.matchByAntStylePathPattern(
				includePatterns, excludePatterns, "/images/button.gif");
		assertEquals(false, isMatched);
		isMatched = URIPatternMatcherUtils.matchByAntStylePathPattern(
				includePatterns, excludePatterns, "/css/style.css");
		assertEquals(false, isMatched);
	}
}
