package org.codelabor.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SomeObject2 {
	private final Log log = LogFactory.getLog(getClass());

	public SomeObject2() {
		if (log.isDebugEnabled()) {
			log.debug("constructor");
		}
	}

	public void someMethod1() {
		if (log.isDebugEnabled()) {
			log.debug("someMethod1");
		}
	}
}
