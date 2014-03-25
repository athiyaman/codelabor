package org.codelabor.example.inheritance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParentClass1 {
	protected Logger logger = LoggerFactory.getLogger(ParentClass1.class);

	public ParentClass1() {
		super();
		logger.debug("constructor");
	}

}
