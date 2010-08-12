package org.codelabor.example.lang;

import junit.framework.Assert;
import junit.framework.TestCase;

public class StringTest extends TestCase {

	public void testSplitString() {
		// , ; " "에 대해서 구분자 사용
		String filePatternString = "jsp/test.jsp images/test.gif; css/test.css, js/test.js";
		String regexpPattern = "([ ]*[,; ][ ]*)";
		String[] filePatterns = filePatternString.split(regexpPattern);
		Assert.assertEquals(3, filePatterns.length);
		for (String filePattern : filePatterns) {
			System.out.println(filePattern);
		}
	}

	public void testSubstring() {
		String fileName = "/qwer/qwer/qwer/test.txt";
		int index = fileName.lastIndexOf(".");
		String extension = fileName.substring(index + 1);
		Assert.assertEquals("txt", extension);
		System.out.println(extension);
	}
}
