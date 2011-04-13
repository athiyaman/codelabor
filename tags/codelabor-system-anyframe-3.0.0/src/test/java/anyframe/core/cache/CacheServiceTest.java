package anyframe.core.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/**/applicationContext*.xml")
public class CacheServiceTest {

	@Autowired
	private ApplicationContext context;
	private ICacheService cacheService;

	@Before
	public void setUp() {
		cacheService = context.getBean("cacheService", ICacheService.class);

		// prepare data
		Map<String, String> codeMap = new HashMap<String, String>();
		codeMap.put("DEPT1", "marketing");
		codeMap.put("DEPT2", "sales");
		codeMap.put("DEPT3", "development");
		cacheService.putInCache("codeMap", codeMap);
	}

	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void testGetFromCache() {
		try {
			// test
			Map<String, String> codeMap2 = (Map) cacheService
					.getFromCache("codeMap");
			assertEquals("marketing", codeMap2.get("DEPT1"));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
