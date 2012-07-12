package org.codelabor.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.status.OnConsoleStatusListener;
import ch.qos.logback.core.status.StatusManager;

public class OnConsoleStatusListenerTest {
	Logger logger = LoggerFactory.getLogger(OnConsoleStatusListenerTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOnConsoleStatusListener() {
		LoggerContext loggerContext = (LoggerContext) LoggerFactory
				.getILoggerFactory();
		StatusManager statusManager = loggerContext.getStatusManager();
		OnConsoleStatusListener onConsoleListener = new OnConsoleStatusListener();
		statusManager.add(onConsoleListener);
	}

}