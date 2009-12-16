package anyframe.services.cache;

import java.util.HashMap;
import java.util.Map;

import org.codelabor.system.test.BaseTestCase;

import anyframe.core.cache.ICacheService;

public class CacheServiceTest extends BaseTestCase {

	protected ICacheService cacheService;

	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		cacheService = (ICacheService) applicationContext
				.getBean("cacheService");

		// prepare data
		Map<String, String> codeMap = new HashMap<String, String>();
		codeMap.put("DEPT1", "marketing");
		codeMap.put("DEPT2", "sales");
		codeMap.put("DEPT3", "development");
		cacheService.putInCache("codeMap", codeMap);
	}

	@SuppressWarnings("unchecked")
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
