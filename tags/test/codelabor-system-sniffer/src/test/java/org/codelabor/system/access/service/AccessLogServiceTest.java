package org.codelabor.system.access.service;

import java.sql.Timestamp;
import java.util.List;

import org.codelabor.system.access.dto.AccessLogDTO;
import org.codelabor.system.access.service.AccessLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.AbstractSingleSpringContextTests;

import anyframe.core.query.IQueryService;

/**
 * 접근 로그 서비스 테스트 케이스
 * 
 * @author Shin Sangjae
 * 
 */
public class AccessLogServiceTest extends AbstractSingleSpringContextTests {

	/**
	 * 접근 로그 서비스
	 */
	private AccessLogService accessLogService;
	/**
	 * 쿼리 서비스
	 */
	protected IQueryService queryService;
	/**
	 * 로거
	 */
	protected Logger logger = LoggerFactory
			.getLogger(AccessLogServiceTest.class);

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.test.AbstractSingleSpringContextTests#onSetUp()
	 */
	@Override
	public void onSetUp() throws Exception {
		accessLogService = (AccessLogService) applicationContext
				.getBean("accessLogService");
		queryService = (IQueryService) applicationContext
				.getBean("oracleQueryService");

		// clear data
		queryService.remove("system.delete.access.log.list", new Object[] {});
	}

	/**
	 * 접근 로그 테스트
	 */
	@SuppressWarnings({ "rawtypes" })
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
			assertEquals(accessLogDTO1.getEvent(),
					returnedAccessLogDTO1.getEvent());
			assertEquals(accessLogDTO2.getEvent(),
					returnedAccessLogDTO2.getEvent());
			assertEquals(accessLogDTO3.getEvent(),
					returnedAccessLogDTO3.getEvent());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
