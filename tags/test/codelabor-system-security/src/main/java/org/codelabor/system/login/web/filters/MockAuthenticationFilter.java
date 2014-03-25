package org.codelabor.system.login.web.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codelabor.system.login.dtos.LoginDTO;
import org.codelabor.system.web.SessionConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 인증 필터
 * 
 * @author Shin Sangjae
 * 
 */
public class MockAuthenticationFilter extends AbstractAuthenticationFilter {

	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory
			.getLogger(MockAuthenticationFilter.class);

	/**
	 * 인증 여부를 확인한다.
	 * 
	 * @param request
	 *            요청
	 * @param response
	 *            응답
	 * @return 인증 여부
	 */
	@Override
	public boolean isAuthenticated(HttpServletRequest request,
			HttpServletResponse response) {
		boolean isAuthenticated = false;
		HttpSession session = request.getSession(false);
		if (session != null) {
			if (session.getAttribute(SessionConstants.SESSION_LOGIN_INFO) != null) {
				isAuthenticated = true;
			}
		}
		logger.debug("isAuthenticated: {}", isAuthenticated);
		return isAuthenticated;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.login.web.filters.AbstractAuthenticationFilter#
	 * forwardLoginPage(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void forwardLoginPage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserId("tester");
		loginDTO.setIpAddress(request.getRemoteAddr());
		request.getSession().setAttribute(SessionConstants.SESSION_LOGIN_INFO,
				loginDTO);

	}

}
