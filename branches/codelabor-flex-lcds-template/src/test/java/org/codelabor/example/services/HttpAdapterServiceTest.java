package org.codelabor.example.services;

import java.util.HashMap;
import java.util.Map;

import org.codelabor.system.test.BaseTestCase;
import org.codelabor.system.services.HttpAdapterService;

public class HttpAdapterServiceTest extends BaseTestCase {

	private HttpAdapterService httpAdapterService;

	@Override
	public void onSetUp() throws Exception {
		httpAdapterService = (HttpAdapterService) applicationContext
				.getBean("httpAdapterService");

	}

	public void testCall() {
		// test
		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("q", "codelabor");
		String responseBody = this.httpAdapterService.request(parameterMap);

		// assert
		assertNotNull(responseBody);
		String expectedBody = "<title>codelabor - Google Search</title>";
		assertTrue(responseBody.contains(expectedBody.subSequence(0,
				expectedBody.length())));
		// log
		if (log.isDebugEnabled()) {
			log.debug("responseBody: " + responseBody);
		}
	}
}
