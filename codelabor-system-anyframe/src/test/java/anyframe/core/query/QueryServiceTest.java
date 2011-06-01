package anyframe.core.query;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import anyframe.core.query.IQueryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/**/applicationContext*.xml")
public class QueryServiceTest {

	@Autowired
	private ApplicationContext context;
	private IQueryService queryService;

	@Before
	public void setUp() {
		queryService = context.getBean("queryService", IQueryService.class);
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