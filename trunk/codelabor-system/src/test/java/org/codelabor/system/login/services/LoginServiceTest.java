package org.codelabor.system.login.services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.login.dtos.LoginDTO;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import anyframe.core.query.IQueryService;

public class LoginServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	private LoginService loginService;
	private IQueryService queryService;
	protected Log log = LogFactory.getLog(this.getClass());

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
		LoginDTO loginDTO = new LoginDTO();
		loginDTO
				.setSessionId("zWHwgqfZALDe1dBzNLFlyO5Hduileijc775DSsWhdQwsdXINuSRkuSXK6pvqn1EI");
		loginDTO.setUserId("bomber");
		loginDTO.setIpAddress("127.0.0.1");
		try {
			// login test
			loginService.login(loginDTO);

			// assert
			String queryId = "system.select.login";
			Object[] param = new Object[] { loginDTO.getSessionId() };
			List<LoginDTO> loginDTOList = (List<LoginDTO>) queryService.find(
					queryId, param);
			LoginDTO returnedLoginDTO = loginDTOList.get(0);
			assertNotNull(returnedLoginDTO.getLoginTimestamp());
			assertNull(returnedLoginDTO.getLogoutTimestamp());

			// logout test
			loginService.logout(loginDTO);

			// assert
			queryId = "system.select.login";
			param = new Object[] { loginDTO.getSessionId() };
			loginDTOList = (List<LoginDTO>) queryService.find(queryId, param);
			returnedLoginDTO = loginDTOList.get(0);
			assertNotNull(returnedLoginDTO.getLogoutTimestamp());

			// select last login info test
			loginDTO = loginService.selectLoginByLastLogoutUserId(loginDTO);

			// assert
			assertNotNull(loginDTO.getLogoutTimestamp());

			// log
			if (log.isDebugEnabled()) {
				log.debug(loginDTO);
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
