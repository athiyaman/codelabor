package anyframe.core.idgen;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.anyframe.idgen.IdGenService;
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
public class IdGenServiceTest {

	private Logger logger = LoggerFactory.getLogger(IdGenServiceTest.class);

	@Autowired
	private ApplicationContext context;
	private IdGenService sequenceIdGenerationService;
	private IdGenService prefixDateNumberSequenceIdGenerationService;

	@Before
	public void setUp() {
		sequenceIdGenerationService = context.getBean(
				"sequenceIdGenerationService", IdGenService.class);
		prefixDateNumberSequenceIdGenerationService = context.getBean(
				"prefixDateNumberSequenceIdGenerationService",
				IdGenService.class);
	}

	@Test
	public void testNotNull() {
		try {
			assertNotNull(sequenceIdGenerationService);
			assertNotNull(prefixDateNumberSequenceIdGenerationService);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testGetNextStringId() {
		try {
			String nextId = sequenceIdGenerationService.getNextStringId();
			logger.debug("sequenceIdGenerationService nextId: {}", nextId);

			nextId = prefixDateNumberSequenceIdGenerationService
					.getNextStringId();
			logger.debug(
					"prefixDateNumberSequenceIdGenerationService nextId: {}",
					nextId);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
