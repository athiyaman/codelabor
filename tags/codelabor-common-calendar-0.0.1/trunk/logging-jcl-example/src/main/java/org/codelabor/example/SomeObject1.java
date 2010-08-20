package org.codelabor.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SomeObject1 {
	private final static Log log = LogFactory.getLog(SomeObject1.class);

	public SomeObject1() {
		if (log.isDebugEnabled()) {
			log.debug("constructor");
		}
	}

	static public void someMethod1() {
		if (log.isDebugEnabled()) {
			log.debug("someMethod1");
		}
	}
}
