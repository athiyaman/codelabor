package org.codelabor.system.services;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class HttpAdapterServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	private HttpAdapterService httpAdapterService;
	protected Log log = LogFactory.getLog(this.getClass());

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

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext*.xml" };
	}
}
