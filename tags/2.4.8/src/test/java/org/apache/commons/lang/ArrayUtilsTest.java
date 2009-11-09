package org.apache.commons.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddAllByteArrayByteArray() {
		byte[] array1 = new String("1234abcd").getBytes();
		byte[] array2 = new String("가나다라").getBytes();
		byte[] array3 = ArrayUtils.addAll(array1, array2);
		System.out.println(new String(array3));
	}

	@Test
	public void testSubarrayByteArrayIntInt() {
		byte[] array3 = new String("1234abcd가나다라").getBytes();
		byte[] array1 = ArrayUtils.subarray(array3, 0, 8);
		byte[] array2 = ArrayUtils.subarray(array3, 8, array3.length);
		System.out.println(new String(array1));
		System.out.println(new String(array2));
	}

}
