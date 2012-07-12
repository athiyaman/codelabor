package org.codelabor.example.staticmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParentClass2 {
	static protected Logger logger = LoggerFactory.getLogger(ParentClass2.class);
	//static protected Logger logger = LoggerFactory.getLogger(getClass());

	public ParentClass2() {
		super();
		logger.debug("constructor");
	}

}
