package org.codelabor.system.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayUtilsTest {
	private Logger logger = LoggerFactory.getLogger(ArrayUtilsTest.class);

	@Test
	public void testToDelimetedString() {
		String[] array = new String[] {"value1", "value2", "value3", "value4"};
		String delimetedString = ArrayUtils.toDelimetedString(array, ", ");
		logger.debug("delimeted string: {}", delimetedString);
		assertEquals("value1, value2, value3, value4", delimetedString);
	}

}
