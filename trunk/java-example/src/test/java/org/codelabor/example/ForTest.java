package org.codelabor.example;

import junit.framework.TestCase;

public class ForTest extends TestCase {

	public void testFor() {
		String[] names = {"Smith", "Allen", "Ward", "Jones", "Martin", "Blake", "Clark", "King", "Turner", "James", "Ford", "Miller"};
		for (String name : names) {
			System.out.println("name: " + name);
		}
	}
}
