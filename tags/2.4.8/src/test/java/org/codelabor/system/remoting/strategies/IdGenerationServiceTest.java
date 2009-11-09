package org.codelabor.system.remoting.strategies;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import anyframe.core.idgen.IIdGenerationService;

@SuppressWarnings("deprecation")
public class IdGenerationServiceTest extends AbstractDependencyInjectionSpringContextTests {

	protected IIdGenerationService idGenerationService;

	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		idGenerationService = (IIdGenerationService) applicationContext.getBean("transactionIdGenerationService");
	}

	public void testGetNextString() {
		try {
			// test
			for (int i = 0; i < 100; i++) {
				String nextId = idGenerationService.getNextStringId();
				System.out.println(nextId);
			}
			// assert

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext*.xml" };
	}
}
