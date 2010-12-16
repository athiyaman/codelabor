package org.codelabor.system.file.anyframe.idgen.strategies;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UniqueFileNameStrategyTest {

	private final Logger logger = LoggerFactory
			.getLogger(UniqueFileNameStrategyTest.class);
	private UniqueFileNameStrategy uniqueFileNameStrategy;

	@Before
	public void setUp() throws Exception {
		uniqueFileNameStrategy = new UniqueFileNameStrategy();
		uniqueFileNameStrategy.setPrefix("FILE");
		uniqueFileNameStrategy.setDateAndTimePattern("yyyyMMddHHmmssSSS");
		uniqueFileNameStrategy.setCipers(3);
		uniqueFileNameStrategy.setFillChar('0');
	}

	@Test
	public void testMakeId() {
		String id = uniqueFileNameStrategy.makeId("1");
		logger.debug("id: {}", id);
	}

}
