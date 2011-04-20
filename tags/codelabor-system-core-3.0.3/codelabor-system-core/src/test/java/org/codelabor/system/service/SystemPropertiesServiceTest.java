package org.codelabor.system.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.codelabor.system.dto.SystemPropertiesDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/**/applicationContext*.xml")
public class SystemPropertiesServiceTest {
	private final Logger logger = LoggerFactory
			.getLogger(SystemPropertiesServiceTest.class);
	@Autowired
	private ApplicationContext context;
	private SystemPropertiesService systemPropertiesService;

	@Before
	public void setUp() {
		systemPropertiesService = context.getBean("systemPropertiesService", SystemPropertiesService.class);
	}

	@Test
	public void testNotNull() {
		try {
			assertNotNull(systemPropertiesService);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testGetSystemPropertiesDTO() {
		SystemPropertiesDTO systemPropertiesDTO;
		try {
			systemPropertiesDTO = systemPropertiesService
					.getSystemPropertiesDTO();
			logger.debug(systemPropertiesDTO.toString());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}
}
