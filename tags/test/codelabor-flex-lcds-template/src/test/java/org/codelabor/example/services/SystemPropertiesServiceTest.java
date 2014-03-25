package org.codelabor.example.services;

import org.codelabor.example.dtos.SystemPropertiesDTO;
import org.codelabor.system.test.BaseTestCase;
import org.junit.Test;

public class SystemPropertiesServiceTest extends BaseTestCase {

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
}
