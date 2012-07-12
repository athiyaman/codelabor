package org.codelabor.example.inheritance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParentClass3 {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public ParentClass3() {
		super();
		logger.debug("constructor");
	}

}
