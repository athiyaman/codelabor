package org.codelabor.example.pmd.optimizations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AvoidInstantiatingObjectsInLoops {
	public List<String> avoidInstantiatingObjectsInLoops1() {
		final List<String> stringList = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			stringList.add(String.valueOf(i));
		}
		return stringList;
	}

	public List<Map<String, String>> avoidInstantiatingObjectsInLoops2() {
		final List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
		for (int i = 0; i < 100; i++) {
			Map<String, String> data = new HashMap<String, String>();
			data.put("key1", "value1");
			mapList.add(data);
		}
		return mapList;
	}

}
