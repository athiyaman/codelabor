package org.codelabor.system.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class BaseTestCase extends AbstractDependencyInjectionSpringContextTests {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:/**/applicationContext*.xml" };
	}

	public void test() {
	}

}
