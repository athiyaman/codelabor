package org.codelabr.system.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.codelabor.system.util.ListUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListUtilsTest {
	private Logger logger = LoggerFactory.getLogger(ListUtilsTest.class);


	@Before
	public void setUp() {
	}

	@Test
	public void testToDelimetedString() {
		List<String> list = new ArrayList<String>();
		list.add("value1");
		list.add("value2");
		list.add("value3");
		list.add("value4");
		String delimetedString = ListUtils.toDelimetedString(list, ", ");
		logger.debug("delimeted string: {}", delimetedString);
		assertEquals("value1, value2, value3, value4", delimetedString);
	}

	@Test
	public void testContainsByAntStylePattern() {
		List<String> patternList = new ArrayList<String>();
		patternList.add("http://codelabor.org/**/index.html");
		String text = "http://codelabor.org/example/index.html";
		boolean isContained = ListUtils.containsByAntStylePattern(patternList, text);
		logger.debug("isContained: {}", isContained);
		assertTrue(isContained);
	}
	
	@Test
	public void testContainsByRegexpPattern() {
		List<String> patternList = new ArrayList<String>();
		patternList.add("http://codelabor.org/[a-z]*/index.html");
		String text = "http://codelabor.org/example/index.html";
		boolean isContained = ListUtils.containsByRegexpPattern(patternList, text);
		logger.debug("isContained: {}", isContained);
		assertTrue(isContained);
	}	
	
	@Test
	public void testContains() {
		List<String> patternList = new ArrayList<String>();
		patternList.add("http://codelabor.org/**/index.html");
		String text = "http://codelabor.org/**/index.html";
		boolean isContained = ListUtils.contains(patternList, text);
		logger.debug("isContained: {}", isContained);
		assertTrue(isContained);
	}	

}
