package org.codelabor.system.services;

import org.codelabor.system.dtos.SystemPropertiesDTO;
import org.springframework.test.AbstractSingleSpringContextTests;

public class SystemPropertiesServiceTest extends
		AbstractSingleSpringContextTests {

	private SystemPropertiesService systemPropertiesService;

	@Override
	protected String[] getConfigLocations() {
		return new String[] {
				"classpath:/**/applicationContext-configurableCallBack.xml",
				"classpath:/**/applicationContext-systemPropertiesService.xml" };
	}

	@Override
	public void onSetUp() throws Exception {
		systemPropertiesService = (SystemPropertiesService) applicationContext
				.getBean("systemPropertiesService");
	}

	public void testGetSystemPropertiesDTO() {
		SystemPropertiesDTO systemPropertiesDTO;
		try {
			systemPropertiesDTO = systemPropertiesService
					.getSystemPropertiesDTO();
			System.out.println(systemPropertiesDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
