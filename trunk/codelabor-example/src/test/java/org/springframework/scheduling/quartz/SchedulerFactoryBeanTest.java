package org.springframework.scheduling.quartz;

import org.codelabor.system.test.BaseTestCase;

public class SchedulerFactoryBeanTest extends BaseTestCase {

	@Override
	public void onSetUp() throws Exception {

	}

	public void testSchedule() {
		try {
			Thread.sleep(1000 * 60 * 5);
		} catch (Exception e) {
		}
	}
}
