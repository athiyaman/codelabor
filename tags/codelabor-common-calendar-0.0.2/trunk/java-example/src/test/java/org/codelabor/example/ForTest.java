package org.codelabor.example;

import junit.framework.TestCase;

public class ForTest extends TestCase {

	@SuppressWarnings("null")
	public void testFor() {
		String[] names = null;
		for (String name : names) {
			System.out.println("name: " + name);
		}
	}
}
