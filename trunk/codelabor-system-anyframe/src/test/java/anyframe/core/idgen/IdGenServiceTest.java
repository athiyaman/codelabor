package anyframe.core.idgen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/**/applicationContext*.xml")
public class IdGenServiceTest {

	@Autowired
	private ApplicationContext context;

	private Logger logger = LoggerFactory.getLogger(IdGenServiceTest.class);
	private IdGenService prefixDateNumberSequenceIdGenerationService;
	private IdGenService sequenceIdGenerationService;

	@Before
	public void setUp() {
		sequenceIdGenerationService = context.getBean(
				"sequenceIdGenerationService", IdGenService.class);
		prefixDateNumberSequenceIdGenerationService = context.getBean(
				"prefixDateNumberSequenceIdGenerationService",
				IdGenService.class);
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
}
