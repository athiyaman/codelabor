package org.codelabor.example.pmd.optimization;

import java.util.ArrayList;
import java.util.List;

public class AvoidInstantiatingObjectsInLoops {
	public List<String> avoidInstantiatingObjectsInLoops1() {
		final List<String> stringList = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			stringList.add(String.valueOf(i));
		}
		return stringList;
	}

	public List<String> avoidInstantiatingObjectsInLoops2() {
		final List<String> stringList = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			stringList.add(new String("dummy"));
		}
		return stringList;
	}

}
