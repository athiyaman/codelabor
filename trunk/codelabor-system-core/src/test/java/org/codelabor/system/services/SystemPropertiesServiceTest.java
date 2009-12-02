package org.codelabor.system.services;

import org.codelabor.system.dtos.SystemPropertiesDTO;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class SystemPropertiesServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	private SystemPropertiesService systemPropertiesService;

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

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext*.xml" };
	}
}
