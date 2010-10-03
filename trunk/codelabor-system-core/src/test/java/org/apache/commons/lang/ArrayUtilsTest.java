package org.apache.commons.lang;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayUtilsTest extends TestCase {

	private final Logger logger = LoggerFactory.getLogger(ArrayUtilsTest.class);

	@Override
	public void setUp() throws Exception {
	}

	@Override
	public void tearDown() throws Exception {
	}

	public void testAddAllByteArrayByteArray() {
		byte[] array1 = new String("1234abcd").getBytes();
		byte[] array2 = new String("가나다라").getBytes();
		byte[] array3 = ArrayUtils.addAll(array1, array2);
		// System.out.println(new String(array3));
		logger.debug(new String(array3));
	}

	public void testSubarrayByteArrayIntInt() {
		byte[] array3 = new String("1234abcd가나다라").getBytes();
		byte[] array1 = ArrayUtils.subarray(array3, 0, 8);
		byte[] array2 = ArrayUtils.subarray(array3, 8, array3.length);
		// System.out.println(new String(array1));
		// System.out.println(new String(array2));
		logger.debug(new String(array1));
		logger.debug(new String(array2));
	}
}
