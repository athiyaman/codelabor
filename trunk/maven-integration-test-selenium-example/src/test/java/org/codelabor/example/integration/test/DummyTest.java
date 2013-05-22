package org.codelabor.example.integration.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class DummyTest {

	Logger logger = LoggerFactory.getLogger(DummyTest.class);
	Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost",
				RemoteControlConfiguration.getDefaultPort(), "*iehta",
				"http://localhost:8080");
		selenium.start();
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}

	@Test
	public void test() {
		logger.debug("integration test");
		selenium.open("/maven-integration-test-selenium-example");
		String bodyText = selenium.getBodyText();
		logger.debug("bodyText: {}", bodyText);
		assertEquals("Hello World!", bodyText);
	}
}
