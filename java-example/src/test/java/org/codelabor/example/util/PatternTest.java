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

	// http://stackoverflow.com/questions/3802192/regexp-java-for-password-validation
	// http://www.mkyong.com/regular-expressions/how-to-validate-password-with-regular-expression/
	@Test
	public void testPasswordValidation() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");	// start of group
		sb.append("(?=.*[0-9])"); // a digit must occur at least one
		sb.append("(?=.*[a-z])"); // a lower case letter must occur at least once
		sb.append("(?=.*[A-Z])"); // a upper case letter must occur at least once
		sb.append("(?=.*[~`!@#$%^&*()_+\\-=\\[\\]\\{}|;':\",./<>?\\\\])"); // a special character must occur at least once
		sb.append("(?=\\S+$)"); // no whitespace allowed in the entire string
		sb.append("."); // match anything with previous condition checking
		sb.append("{5,10}"); // at least 5 to 10 characters
		sb.append(")"); // end of group
		String regex = sb.toString();
		logger.debug("regex: {}", regex);

		String input = "1qaz@WSX";
		logger.debug("input: {}", input);
		boolean isMatched = Pattern.matches(regex, input);
		logger.debug("isMatched: {}", isMatched);
		assertEquals(true, isMatched);

		input = "1qaz2WSX";
		logger.debug("input: {}", input);
		isMatched = Pattern.matches(regex, input);
		logger.debug("isMatched: {}", isMatched);
		assertEquals(false, isMatched);

		input = "1qaz2WSX\\";
		logger.debug("input: {}", input);
		isMatched = Pattern.matches(regex, input);
		logger.debug("isMatched: {}", isMatched);
		assertEquals(true, isMatched);

	}

	@Test
	public void mobilePhoneNumberValidation() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");	// start of group
		sb.append("01\\d{1}-\\d{3,4}-\\d{4}");
		sb.append(")"); // end of group
		String regex = sb.toString();
		logger.debug("regex: {}", regex);

		String input = "110-1111-1111";
		boolean isMatched = Pattern.matches(regex, input);
		logger.debug("input: {}, regex: {}, isMatched: {}", input, regex, isMatched);
		assertEquals(true, isMatched);

		input = "010-111-1111";
		isMatched = Pattern.matches(regex, input);
		logger.debug("input: {}, regex: {}, isMatched: {}", input, regex, isMatched);
		assertEquals(true, isMatched);
	}

	@Test
	public void homePhoneNumberValidation() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");	// start of group
		sb.append("\\(0\\d{1,2}\\) \\d{3,4}-\\d{4}");
		sb.append(")"); // end of group
		String regex = sb.toString();
		logger.debug("regex: {}", regex);

		String input = "(02) 1111-1111";
		boolean isMatched = Pattern.matches(regex, input);
		logger.debug("input: {}, regex: {}, isMatched: {}", input, regex, isMatched);
		assertEquals(true, isMatched);

		input = "(041) 111-1111";
		isMatched = Pattern.matches(regex, input);
		logger.debug("input: {}, regex: {}, isMatched: {}", input, regex, isMatched);
		assertEquals(true, isMatched);

		input = "(241) 111-1111";
		isMatched = Pattern.matches(regex, input);
		logger.debug("input: {}, regex: {}, isMatched: {}", input, regex, isMatched);
		assertEquals(false, isMatched);
	}

	@Test
	public void zipCodeValidation() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");	// start of group
		sb.append("\\d{3}-\\d{3}");
		sb.append(")"); // end of group
		String regex = sb.toString();
		logger.debug("regex: {}", regex);

		String input = "111-111";
		boolean isMatched = Pattern.matches(regex, input);
		logger.debug("input: {}, regex: {}, isMatched: {}", input, regex, isMatched);
		assertEquals(true, isMatched);
	}

}
