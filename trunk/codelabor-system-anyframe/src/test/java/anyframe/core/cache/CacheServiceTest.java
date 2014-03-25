package anyframe.core.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/**/applicationContext*.xml")
public class CacheServiceTest {

	private CacheService cacheService;
	@Autowired
	private ApplicationContext context;

	@Before
	public void setUp() {
		cacheService = context.getBean("cacheService", CacheService.class);

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
