package org.codelabor.system.remoting.http.services;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class HttpAdapterServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	protected Log log = LogFactory.getLog(this.getClass());
	protected HttpAdapterService httpAdapterService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.test.AbstractSingleSpringContextTests#getConfigLocations
	 * ()
	 */
	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:/**/applicationContext*.xml" };
	}

	@Override
	public void onSetUp() throws Exception {
		httpAdapterService = (HttpAdapterService) applicationContext
				.getBean("httpAdapterService");
	}

	public void testRequestByGetMethod() {
		try {

			// test
			Map<String, String> parameterMap = new HashMap<String, String>();
			parameterMap.put("q", "codelabor");
			String responseBody = httpAdapterService
					.requestByGetMethod(parameterMap);

			if (log.isDebugEnabled()) {
				StringBuilder sb = new StringBuilder();
				sb.append("responseBody: ").append(responseBody);
				log.debug(sb.toString());
			}

			// assert
			assertNotNull(responseBody);
			String expectedBody = "<title>codelabor - Google Search</title>";
			assertTrue(responseBody.contains(expectedBody.subSequence(0,
					expectedBody.length())));
			// log
			if (log.isDebugEnabled()) {
				log.debug("responseBody: " + responseBody);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
