package org.codelabor.example.services;

import org.codelabor.example.dtos.SystemPropertiesDTO;
import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class SystemPropertiesServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	private SystemPropertiesService systemPropertiesService;

	@Override
	public void onSetUp() throws Exception {
		systemPropertiesService = (SystemPropertiesService) applicationContext
				.getBean("systemPropertiesService");
	}

	@Test
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
