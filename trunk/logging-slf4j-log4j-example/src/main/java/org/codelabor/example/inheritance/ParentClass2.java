package org.codelabor.example.inheritance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParentClass2 {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	public ParentClass2() {
		super();
		logger.debug("constructor");
	}

}
