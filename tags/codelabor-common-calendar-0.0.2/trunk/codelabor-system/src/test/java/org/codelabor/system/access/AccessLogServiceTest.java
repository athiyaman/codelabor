package org.codelabor.system.access;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.access.AccessLogService;
import org.codelabor.system.dtos.AccessLogDTO;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import anyframe.core.query.IQueryService;

public class AccessLogServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	private AccessLogService accessLogService;
	protected IQueryService queryService;
	protected Log log = LogFactory.getLog(this.getClass());

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
		accessLogDTO1.setUserId("bomber");
		accessLogDTO1.setIpAddress("127.0.0.1");
		accessLogDTO1.setResourceId("menu:mypage");
		accessLogDTO1.setMessage("select");
		accessLogDTO1.setTimestamp(new Timestamp(System.currentTimeMillis()));

		AccessLogDTO accessLogDTO2 = new AccessLogDTO();
		accessLogDTO2.setUserId("bomber");
		accessLogDTO2.setIpAddress("127.0.0.1");
		accessLogDTO2.setResourceId("button:submit");
		accessLogDTO2.setMessage("click");
		accessLogDTO2.setTimestamp(new Timestamp(System.currentTimeMillis()));

		AccessLogDTO accessLogDTO3 = new AccessLogDTO();
		accessLogDTO3.setUserId("bomber");
		accessLogDTO3.setIpAddress("127.0.0.1");
		accessLogDTO3.setResourceId("page:index.html");
		accessLogDTO3.setMessage("view");
		accessLogDTO3.setTimestamp(new Timestamp(System.currentTimeMillis()));

		AccessLogDTO accessLogDTO4 = new AccessLogDTO();
		accessLogDTO4.setUserId("bomber");
		accessLogDTO4.setIpAddress("127.0.0.1");
		accessLogDTO4.setResourceId("url:http://codelabor.org");
		accessLogDTO4.setMessage("request");
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
			assertEquals(accessLogDTO1.getMessage(), returnedAccessLogDTO1
					.getMessage());
			assertEquals(accessLogDTO2.getMessage(), returnedAccessLogDTO2
					.getMessage());
			assertEquals(accessLogDTO3.getMessage(), returnedAccessLogDTO3
					.getMessage());
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
