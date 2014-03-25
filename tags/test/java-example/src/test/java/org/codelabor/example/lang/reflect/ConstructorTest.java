package org.codelabor.example.lang.reflect;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstructorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testNewInstance() {

		try {
			Class clazz = java.lang.String.class;
			Constructor constructor = clazz.getConstructor(new Class[] {});
			Object instance = constructor.newInstance(new Object[] {});
			assertTrue(instance instanceof String);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

}
