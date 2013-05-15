package org.codelabor.example.pmd.strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringInstantiation {
	Logger logger = LoggerFactory.getLogger(StringInstantiation.class);

	public void stringInstantiation1() {
		String data = new String("data");
		logger.debug("data: {}", data);
	}

	public void stringInstantiation2() {
		String data = "data";
		logger.debug("data: {}", data);
	}
}
