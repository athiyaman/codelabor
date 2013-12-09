package org.codelabor.example.util;

import java.util.Locale;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocaleTest {
	

	private Logger logger = LoggerFactory.getLogger(LocaleTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetAvailableLocales() {
		for (Locale locale : Locale.getAvailableLocales()) {
			logger.debug("locale: {}", locale);
		}
			
	}

	@Test
	public final void testGetISOCountries() {
		for (String country : Locale.getISOCountries()) {
			logger.debug("country: {}", country);
		}
	}

	@Test
	public final void testGetISOLanguages() {
		for (String language : Locale.getISOLanguages()) {
			logger.debug("language: {}", language);
		}
	}

}
