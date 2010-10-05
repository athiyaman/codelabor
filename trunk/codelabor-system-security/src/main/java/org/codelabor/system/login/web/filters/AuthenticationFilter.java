package org.codelabor.system.login.web.filters;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codelabor.system.login.dtos.LoginDTO;
import org.codelabor.system.web.SessionConstants;
import org.codelabor.system.web.filters.BaseFilterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 인증 필터
 * 
 * @author Shin Sangjae
 * 
 */
public class AuthenticationFilter extends BaseFilterImpl {

	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory
			.getLogger(AuthenticationFilter.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.web.filters.BaseFilterImpl#init(javax.servlet.
	 * FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	/**
	 * 인증 여부를 확인한다.
	 * 
	 * @param request
	 *            요청
	 * @param response
	 *            응답
	 * @return 인증 여부
	 */
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
	 * @see
	 * org.codelabor.system.web.filters.BaseFilterImpl#postprocessFilterChain
	 * (javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void postprocessFilterChain(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.web.filters.BaseFilterImpl#preprocessFilterChain
	 * (javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void preprocessFilterChain(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		if (!isAuthenticated(httpRequest, httpResponse)) {
			LoginDTO loginDTO = new LoginDTO();
			// TODO fetch user id
			loginDTO.setUserId("tester");
			loginDTO.setIpAddress(httpRequest.getRemoteAddr());
			httpRequest.getSession().setAttribute(
					SessionConstants.SESSION_LOGIN_INFO, loginDTO);

		}
	}

}
