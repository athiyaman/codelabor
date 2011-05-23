package org.codelabor.example.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StringTest {

	private final Logger logger = LoggerFactory.getLogger(StringTest.class);

	@Test
	public void testSplitString() {
		// , ; " "에 대해서 구분자 사용
		String filePatternString = "jsp/test.jsp images/test.gif; css/test.css, js/test.js";
		String regexpPattern = "([ ]*[,; ][ ]*)";
		String[] filePatterns = filePatternString.split(regexpPattern);
		for (String filePattern : filePatterns) {
			System.out.println("filePattern: " + filePattern);
		}		
		assertEquals(4, filePatterns.length);

	}

	@Test
	public void testSubstring() {
		String fileName = "/qwer/qwer/qwer/test.txt";
		int index = fileName.lastIndexOf(".");
		String extension = fileName.substring(index + 1);
		assertEquals("txt", extension);
		System.out.println("extention: " + extension);
	}

	@Test
	public void testFormat() {
		int value = 1234;
		String formattedString = String.format("%010d", value);
		logger.debug("formattedString: {}", formattedString);

		formattedString = String.format("%02d", value);
		logger.debug("formattedString: {}", formattedString);
	}
	
	@Test
	public void replace() {
		String targetString = "1234qwerASDF";
		String searchPattern = "qwer";
		String replacePattern = "QWER";
		String resultingString = targetString.replace(searchPattern, replacePattern);
		logger.debug("resultingString: {}", resultingString);
		assertEquals("1234QWERASDF", resultingString);
		
		searchPattern = "zxcv";
		resultingString = targetString.replace(searchPattern, replacePattern);
		logger.debug("resultingString: {}", resultingString);
		assertEquals("1234qwerASDF", resultingString);		
	}

}
