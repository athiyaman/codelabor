package anyframe.core.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/**/applicationContext*.xml")
public class QueryServiceTest {

	@Autowired
	private ApplicationContext context;
	private QueryService queryService;

	@Before
	public void setUp() {
		queryService = context.getBean("queryService", QueryService.class);
	}

	@Test
	public void testNotNull() {
		try {
			assertNotNull(queryService);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
