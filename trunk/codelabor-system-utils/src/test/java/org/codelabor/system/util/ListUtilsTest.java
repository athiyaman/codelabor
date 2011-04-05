package org.codelabor.system.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListUtilsTest {
	private Logger logger = LoggerFactory.getLogger(ListUtilsTest.class);

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

}
