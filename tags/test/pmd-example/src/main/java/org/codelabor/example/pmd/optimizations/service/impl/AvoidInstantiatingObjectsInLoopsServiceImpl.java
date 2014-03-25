package org.codelabor.example.pmd.optimizations.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codelabor.example.pmd.optimizations.service.AvoidInstantiatingObjectsInLoopsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AvoidInstantiatingObjectsInLoopsServiceImpl implements
		AvoidInstantiatingObjectsInLoopsService {

	Logger logger = LoggerFactory
			.getLogger(AvoidInstantiatingObjectsInLoopsServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.pmd.optimizations.service.
	 * AvoidInstantiatingObjectsInLoopsService
	 * #avoidInstantiatingObjectsInLoops1()
	 */
	public List<String> avoidInstantiatingObjectsInLoops1() {
		final List<String> stringList = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			stringList.add(String.valueOf(i));
		}
		return stringList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.pmd.optimizations.service.
	 * AvoidInstantiatingObjectsInLoopsService
	 * #avoidInstantiatingObjectsInLoops2()
	 */
	public List<Object> avoidInstantiatingObjectsInLoops2() {
		final List<Object> stringList = new ArrayList<Object>();
		for (int i = 0; i < 100; i++) {
			stringList.add(new Object());
		}
		return stringList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.pmd.optimizations.service.
	 * AvoidInstantiatingObjectsInLoopsService
	 * #avoidInstantiatingObjectsInLoops3()
	 */
	public List<Map<String, String>> avoidInstantiatingObjectsInLoops3() {
		final List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
		for (int i = 0; i < 100; i++) {
			Map<String, String> data = new HashMap<String, String>();
			data.put(String.valueOf(i), String.valueOf(i));
			mapList.add(data);
		}
		logger.debug("list: {}", mapList);
		return mapList;
	}

}
