package org.codelabor.example.lang;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StringTest extends TestCase {

	private final Logger logger = LoggerFactory.getLogger(StringTest.class);

	public void testSplitString() {
		// , ; " "에 대해서 구분자 사용
		String filePatternString = "jsp/test.jsp images/test.gif; css/test.css, js/test.js";
		String regexpPattern = "([ ]*[,; ][ ]*)";
		String[] filePatterns = filePatternString.split(regexpPattern);
		for (String filePattern : filePatterns) {
			System.out.println("filePattern: " + filePattern);
		}		
		Assert.assertEquals(4, filePatterns.length);

	}

	public void testSubstring() {
		String fileName = "/qwer/qwer/qwer/test.txt";
		int index = fileName.lastIndexOf(".");
		String extension = fileName.substring(index + 1);
		Assert.assertEquals("txt", extension);
		System.out.println("extention: " + extension);
	}

	public void testFormat() {
		int value = 1234;
		String formattedString = String.format("%010d", value);
		logger.debug("formattedString: {}", formattedString);

		formattedString = String.format("%02d", value);
		logger.debug("formattedString: {}", formattedString);
	}

}
