package org.codelabor.system.access.services;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.access.dtos.AccessLogDTO;
import org.springframework.test.AbstractSingleSpringContextTests;

import anyframe.core.query.IQueryService;

public class AccessLogServiceTest extends AbstractSingleSpringContextTests {

	private AccessLogService accessLogService;
	protected IQueryService queryService;
	protected Log log = LogFactory.getLog(this.getClass());

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:/**/applicationContext*.xml" };
	}

	@Override
	public void onSetUp() throws Exception {
		accessLogService = (AccessLogService) applicationContext
				.getBean("accessLogService");
		queryService = (IQueryService) applicationContext
				.getBean("oracleQueryService");

		// clear data
		queryService.remove("system.delete.access.log.list", new Object[] {});
	}

	@SuppressWarnings("unchecked")
	public void testAccessLog() {
		// test
		AccessLogDTO accessLogDTO1 = new AccessLogDTO();
		accessLogDTO1.setUsername("bomber");
		accessLogDTO1.setIpAddress("127.0.0.1");
		accessLogDTO1.setTarget("menu:mypage");
		accessLogDTO1.setEvent("select");
		accessLogDTO1.setTimestamp(new Timestamp(System.currentTimeMillis()));

		AccessLogDTO accessLogDTO2 = new AccessLogDTO();
		accessLogDTO2.setUsername("bomber");
		accessLogDTO2.setIpAddress("127.0.0.1");
		accessLogDTO2.setTarget("button:submit");
		accessLogDTO2.setEvent("click");
		accessLogDTO2.setTimestamp(new Timestamp(System.currentTimeMillis()));

		AccessLogDTO accessLogDTO3 = new AccessLogDTO();
		accessLogDTO3.setUsername("bomber");
		accessLogDTO3.setIpAddress("127.0.0.1");
		accessLogDTO3.setTarget("page:index.html");
		accessLogDTO3.setEvent("view");
		accessLogDTO3.setTimestamp(new Timestamp(System.currentTimeMillis()));

		AccessLogDTO accessLogDTO4 = new AccessLogDTO();
		accessLogDTO4.setUsername("bomber");
		accessLogDTO4.setIpAddress("127.0.0.1");
		accessLogDTO4.setTarget("url:http://codelabor.org");
		accessLogDTO4.setEvent("request");
		accessLogDTO4.setTimestamp(new Timestamp(System.currentTimeMillis()));

		try {

			// test
			accessLogService.accessLog(accessLogDTO1);
			accessLogService.accessLog(accessLogDTO2);
			accessLogService.accessLog(accessLogDTO3);

			// assert
			AccessLogDTO returnedAccessLogDTO1 = (AccessLogDTO) ((List) queryService
					.find(accessLogDTO1)).get(0);
			AccessLogDTO returnedAccessLogDTO2 = (AccessLogDTO) ((List) queryService
					.find(accessLogDTO2)).get(0);
			AccessLogDTO returnedAccessLogDTO3 = (AccessLogDTO) ((List) queryService
					.find(accessLogDTO3)).get(0);
			assertEquals(accessLogDTO1.getEvent(), returnedAccessLogDTO1
					.getEvent());
			assertEquals(accessLogDTO2.getEvent(), returnedAccessLogDTO2
					.getEvent());
			assertEquals(accessLogDTO3.getEvent(), returnedAccessLogDTO3
					.getEvent());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
