package org.codelabor.system.services;

import org.codelabor.system.dtos.SystemPropertiesDTO;
import org.codelabor.system.test.BaseTestCase;

public class SystemPropertiesServiceTest extends BaseTestCase {

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
}
