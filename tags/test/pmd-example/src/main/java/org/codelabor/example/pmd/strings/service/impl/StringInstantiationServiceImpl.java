package org.codelabor.example.pmd.strings.service.impl;

import org.codelabor.example.pmd.strings.service.StringInstantiationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringInstantiationServiceImpl implements
		StringInstantiationService {
	Logger logger = LoggerFactory
			.getLogger(StringInstantiationServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.pmd.strings.service.StringInstantiationService#
	 * stringInstantiation1()
	 */
	public void stringInstantiation1() {
		String data = new String("data");
		logger.debug("data: {}", data);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.pmd.strings.service.StringInstantiationService#
	 * stringInstantiation2()
	 */
	public void stringInstantiation2() {
		String data = "data";
		logger.debug("data: {}", data);
	}
}
