package org.codelabor.example.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/**/applicationContext*.xml")
public class HelloWorldServiceTest {
	private static final Logger logger = LoggerFactory
			.getLogger(HelloWorldServiceTest.class);

	@Before
	public void setup() {

	}

	@Test
	public void run() throws InterruptedException {
		logger.debug("run");
		Thread.sleep(10000);
	}
}
