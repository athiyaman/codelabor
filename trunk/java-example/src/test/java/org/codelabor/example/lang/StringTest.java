package org.codelabor.example.lang;

import junit.framework.TestCase;

public class StringTest extends TestCase {

	public void testSplitString() {
		// , ; " "에 대해서 구분자 사용
		String filePatternString = "jsp/test.jsp images/test.gif; css/test.css, js/test.js";
		String regexpPattern = "([ ]*[,; ][ ]*)";
		String[] filePatterns = filePatternString.split(regexpPattern);
		for (String filePattern : filePatterns) {
			System.out.println(filePattern);
		}
	}
}
