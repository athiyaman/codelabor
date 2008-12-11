package org.codelabor.system.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class BaseTestCase extends AbstractDependencyInjectionSpringContextTests {

	protected Log log = LogFactory.getLog(this.getClass());

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext*.xml" };
	}

}
