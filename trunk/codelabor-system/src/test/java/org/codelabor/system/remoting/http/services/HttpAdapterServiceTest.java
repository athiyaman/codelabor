package org.codelabor.system.remoting.http.services;

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

	public void testRequestByMap() {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testRequestByString() {
		try {
			// test
			String requestMessage = "hello";
			String responseMessage;
			responseMessage = this.httpAdapterService.request(requestMessage);

			// assert
			assertNotNull(responseMessage);
			String expectedBody = "hello";
			assertTrue(responseMessage.contains(expectedBody.subSequence(0,
					expectedBody.length())));
			// log
			if (log.isDebugEnabled()) {
				log.debug("responseMessage: " + responseMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext*.xml" };
	}
}
