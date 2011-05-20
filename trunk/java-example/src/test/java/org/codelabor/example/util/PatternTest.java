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
package org.codelabor.example.util;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shin Sang-jae
 *
 */
public class PatternTest {
	private Logger logger = LoggerFactory.getLogger(PatternTest.class);
	
	@Test
	public void testMatches() {
		String regex = "[a-z]*";
		String input = "qwerasdf";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		boolean isMatched = matcher.matches();
		logger.debug("isMatched: {}", isMatched);
		
		assertEquals(true, isMatched);
	}
	
	@Test
	public void testMatches2() {
		String regex = "[a-z]*";
		String input = "qwerasdf";
		boolean isMatched = Pattern.matches(regex, input);
		logger.debug("isMatched: {}", isMatched);
		
		assertEquals(true, isMatched);
	}	

}
