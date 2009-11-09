package org.codelabor.system.remoting.http.services;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class HttpAdapterServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	protected Log log = LogFactory.getLog(this.getClass());

	@Override
	public void onSetUp() throws Exception {

	}

	public void testRequestByGetMethod() {
		try {
			HttpAdapterService httpAdapterService;
			httpAdapterService = (HttpAdapterService) applicationContext
					.getBean("httpAdapterService");

			// test
			Map<String, String> parameterMap = new HashMap<String, String>();
			parameterMap.put("q", "codelabor");
			String responseBody = httpAdapterService
					.requestByGetMethod(parameterMap);

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

	public void testRequestByPostMethod() {
		try {
			HttpAdapterService httpAdapterService;
			httpAdapterService = (HttpAdapterService) applicationContext
					.getBean("messageHandlerHttpAdapterService");

			// test
			String requestMessage = "00001611SKSFWORKFLOW001109905P0LB IUS208160000910231458554546000IUS208160000910231458554546                                0S 0000000000010.10.101.204          1          2009102314585570                                                                                                                                       IUSIUS0 WORKFLOW001                             101 0210125020816김성오              1    N                    00   20091023                                                                                                                                                                                                                                                                                                                                                                                                                                                                      2                   20816   0                                                                                                                                                                 00000        ;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ";
			String responseMessage;
			responseMessage = httpAdapterService
					.requestByPostMethod(requestMessage);

			// assert
			assertNotNull(responseMessage);
			String expectedBody = "00001611SKSFWORKFLOW001109905P0LB IUS208160000910231458554546000IUS208160000910231458554546                                0S 0000000000010.10.101.204          1          2009102314585570                                                                                                                                       IUSIUS0 WORKFLOW001                             101 0210125020816김성오              1    N                    00   20091023                                                                                                                                                                                                                                                                                                                                                                                                                                                                      2                   20816   0                                                                                                                                                                 00000        ;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ";
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
