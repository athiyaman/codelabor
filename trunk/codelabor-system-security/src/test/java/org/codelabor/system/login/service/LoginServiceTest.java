package org.codelabor.system.login.service;

import java.util.List;

import org.codelabor.system.login.dto.LoginDto;
import org.codelabor.system.login.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.AbstractSingleSpringContextTests;

import anyframe.core.query.IQueryService;

public class LoginServiceTest extends AbstractSingleSpringContextTests {

	private LoginService loginService;
	private IQueryService queryService;
	protected Logger logger = LoggerFactory.getLogger(LoginServiceTest.class);

	@Override
	protected String[] getConfigLocations() {
		return new String[] {
				"classpath:/**/applicationContext-configurableCallBack.xml",
				"classpath:/**/applicationContext-baseService.xml",
				"classpath:/**/applicationContext-baseManager.xml",
				"classpath:/**/applicationContext-baseDAO.xml",
				"classpath:/**/applicationContext-propertiesService.xml",
				"classpath:/**/applicationContext-messageSource.xml",
				"classpath:/**/applicationContext-loginService.xml",
				"classpath:/**/applicationContext-loginManager.xml",
				"classpath:/**/applicationContext-queryService-oracle.xml",
				"classpath:/**/applicationContext-dataSourceService-oracle.xml",
				"classpath:/**/applicationContext-lobHandler.xml",
				"classpath:/**/applicationContext-nativeJdbcExtractor.xml" };
	}

	@Override
	public void onSetUp() throws Exception {
		loginService = (LoginService) applicationContext
				.getBean("loginService");
		queryService = (IQueryService) applicationContext
				.getBean("oracleQueryService");

		// clear data
		queryService.remove("system.delete.login.list", new Object[] {});

	}

	@SuppressWarnings("unchecked")
	public void testLogin() {
		// test
		LoginDto loginDto = new LoginDto();
		loginDto
				.setSessionId("zWHwgqfZALDe1dBzNLFlyO5Hduileijc775DSsWhdQwsdXINuSRkuSXK6pvqn1EI");
		loginDto.setUserId("bomber");
		loginDto.setIpAddress("127.0.0.1");
		try {
			// login test
			loginService.login(loginDto);

			// assert
			String queryId = "system.select.login";
			Object[] param = new Object[] { loginDto.getSessionId() };
			List<LoginDto> loginDTOList = (List<LoginDto>) queryService.find(
					queryId, param);
			LoginDto returnedLoginDTO = loginDTOList.get(0);
			assertNotNull(returnedLoginDTO.getLoginTimestamp());
			assertNull(returnedLoginDTO.getLogoutTimestamp());

			// logout test
			loginService.logout(loginDto);

			// assert
			queryId = "system.select.login";
			param = new Object[] { loginDto.getSessionId() };
			loginDTOList = (List<LoginDto>) queryService.find(queryId, param);
			returnedLoginDTO = loginDTOList.get(0);
			assertNotNull(returnedLoginDTO.getLogoutTimestamp());

			// select last login info test
			loginDto = loginService.selectLoginByLastLogoutUserId(loginDto);

			// assert
			assertNotNull(loginDto.getLogoutTimestamp());

			// log
			logger.debug("loginDTO {}", loginDto);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
