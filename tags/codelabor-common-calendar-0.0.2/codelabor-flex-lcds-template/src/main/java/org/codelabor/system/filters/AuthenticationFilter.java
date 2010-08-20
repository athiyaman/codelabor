package org.codelabor.system.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codelabor.system.Constants;
import org.codelabor.system.dtos.LoginDTO;

/**
 * @author SangJae Shin
 * 
 */
public class AuthenticationFilter extends BaseFilterImpl {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("doFilter()");

		if (log.isDebugEnabled()) {
			log.debug(stringBuilder.toString());
		}

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		if (!isAuthenticated(httpRequest, httpResponse)) {
			LoginDTO loginDTO = new LoginDTO();
			// TODO fetch user id
			loginDTO.setUserId("tester");
			loginDTO.setIpAddress(httpRequest.getRemoteAddr());
			httpRequest.getSession().setAttribute(
					Constants.SESSION_LOGIN_INFO_KEY, loginDTO);

		}
		filterChain.doFilter(request, response);
	}

	public boolean isAuthenticated(HttpServletRequest request,
			HttpServletResponse response) {
		boolean isAuthenticated = false;
		HttpSession session = request.getSession(false);
		if (session != null) {
			if (session.getAttribute(Constants.SESSION_LOGIN_INFO_KEY) != null) {
				isAuthenticated = true;
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("isAuthenticated: ").append(isAuthenticated);
		if (log.isDebugEnabled()) {
			log.debug(stringBuilder.toString());
		}

		return isAuthenticated;
	}
}
