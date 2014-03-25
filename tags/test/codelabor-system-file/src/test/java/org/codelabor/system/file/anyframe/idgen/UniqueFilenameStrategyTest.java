package org.codelabor.system.file.anyframe.idgen;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UniqueFilenameStrategyTest {

	private final Logger logger = LoggerFactory
			.getLogger(UniqueFilenameStrategyTest.class);
	private UniqueFilenameStrategy uniqueFilenameStrategy;

	@Before
	public void setUp() throws Exception {
		uniqueFilenameStrategy = new UniqueFilenameStrategy();
		uniqueFilenameStrategy.setPrefix("FILE");
		uniqueFilenameStrategy.setDateAndTimePattern("yyyyMMddHHmmssSSS");
		uniqueFilenameStrategy.setCipers(3);
		uniqueFilenameStrategy.setFillChar('0');
	}

	@Test
	public void testMakeId() {
		String id = uniqueFilenameStrategy.makeId("1");
		logger.debug("id: {}", id);
	}

}
