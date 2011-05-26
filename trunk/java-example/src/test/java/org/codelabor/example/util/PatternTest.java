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
import static org.junit.Assert.assertTrue;

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
	
	@Test
	public void testReplace() {
		// sql injection pettern: or 'qwer' = 'qwer'
		String regex = "(.*)(?i)or\\s+'(.*)'\\s*=\\s*'\\2'(.*)";
		String target = "asdf OR '1'= '1' asdf";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(target);
		String resultingString = matcher.replaceAll("$1$3");
		String expectedString = "asdf  asdf";
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);
	}	
	
	@Test
	public void testReplace2() {
		// sql injection pettern: or 'qwer' = 'qwer'
		String regex = "(.*)(?i)or\\s+'(.*)'\\s*=\\s*'\\2'(.*)";
		String target = "asdf OR '1'= '1' asdf asdf OR '1'= '1' asdf";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(target);
		String resultingString = matcher.replaceAll("$1$3");
		String expectedString = "asdf  asdf asdf  asdf";
		logger.debug("resultingString: {}", resultingString);
		assertTrue(!expectedString.equals(resultingString));
	}
	
	@Test
	public void testReplace3() {
		// sql injection pettern: or 'qwer' = 'qwer'
		String regex = "(.*)(?i)or\\s+'(.*)'\\s*=\\s*'\\2'(.*)";
		String target = "asdf OR '1'= '1' asdf asdf OR '1'= '1' asdf";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = null;
		String resultingString = null;
		
		while(true) {
			matcher = pattern.matcher(target);
			if (matcher.matches()) {
				resultingString = matcher.replaceAll("$1$3");
				logger.debug("resultingString: {}", resultingString);
			} else {
				break;
			}
			target = resultingString;
		}
	
		String expectedString = "asdf  asdf asdf  asdf";
		logger.debug("resultingString: {}", resultingString);
		assertEquals(expectedString, resultingString);	
	}
	
	@Test
	public void testReplace4() {
		String regex = "(.*) \" (.*)";
		String target = "1234 \" 5678";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(target);
		String resultingString = matcher.replaceAll("$1$2");
		String expectedString = "1234  5678";
		logger.debug("resultingString: {}", resultingString);
		assertTrue(!expectedString.equals(resultingString));
	}	

}
