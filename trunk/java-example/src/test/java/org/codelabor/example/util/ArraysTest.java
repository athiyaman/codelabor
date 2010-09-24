package org.codelabor.example.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArraysTest extends TestCase {

	Logger logger = LoggerFactory.getLogger(ArraysTest.class);

	public void testAsList() {
		String[] stringArray = new String[] { "1234", "qwer", "가나다라" };
		List<String> stringList = Arrays.asList(stringArray);

		Iterator<String> iterator = stringList.iterator();
		while (iterator.hasNext()) {
			logger.debug("stringValue: {}", iterator.next());
		}
		Assert.assertEquals(stringArray.length, stringList.size());
	}

}
