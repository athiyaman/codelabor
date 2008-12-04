package org.codelabor.system.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.Constants;
import org.codelabor.system.dtos.LoginDTO;

import com.initech.eam.nls.CookieManager;
import com.initech.eam.smartenforcer.SECode;

/**
 * @author SangJae Shin
 * 
 */
public class InisafeSSOHttpFilter extends BaseFilterImpl {

	private String nlsLoginURL;
	private String nlsErrorURL;
	private String ascpURL;
	private String ssoDomain;
	private int reuseTime;
	private int sessionTime;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
		this.nlsLoginURL = filterConfig.getInitParameter("nlsLoginURL");
		this.nlsErrorURL = filterConfig.getInitParameter("nlsErrorURL");
		this.ascpURL = filterConfig.getInitParameter("ascpURL");
		this.ssoDomain = filterConfig.getInitParameter("ssoDomain");
		String reuseTimeString = filterConfig.getInitParameter("reuseTime");
		String sessionTimeString = filterConfig.getInitParameter("sessionTime");
		if (reuseTimeString != null)
			reuseTime = Integer.parseInt(reuseTimeString);
		if (sessionTimeString != null)
			sessionTime = Integer.parseInt(sessionTimeString);
	}

	protected void doAfterAuthentication(ServletRequest request,
			ServletResponse response) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserId(CookieManager.getCookieValue("InitechEamUID",
				httpRequest));
		loginDTO.setUserId(CookieManager.getCookieValue("InitechEamUIP",
				httpRequest));

		httpRequest.getSession().setAttribute(Constants.SESSION_LOGIN_INFO_KEY,
				loginDTO);
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

		String ssoId = CookieManager
				.getCookieValue(SECode.USER_ID, httpRequest);
		if (log.isDebugEnabled()) {
			stringBuilder = new StringBuilder();
			stringBuilder.append("sso id: ").append(ssoId);
			log.debug(stringBuilder.toString());
		}

		if (ssoId == null) {
			String userURL = request.getParameter("UURL");
			if (userURL == null || userURL.length() == 0) {
				userURL = ascpURL;
			}
			if (log.isDebugEnabled()) {
				stringBuilder = new StringBuilder();
				stringBuilder.append("userURL: ").append(userURL);
				log.debug(stringBuilder.toString());
			}
			CookieManager.addCookie(SECode.USER_URL, userURL, ssoDomain,
					httpResponse);
			httpResponse.sendRedirect(nlsLoginURL);
		} else {
			int errorCode = CookieManager.readNexessCookie(httpRequest,
					httpResponse, ssoDomain, reuseTime, sessionTime);
			if (errorCode != 0) {
				CookieManager.removeNexessCookie(ssoDomain, httpResponse);
				httpResponse.sendRedirect(nlsErrorURL + "?errorCode="
						+ ssoDomain);
			} else {
				doAfterAuthentication(httpRequest, httpResponse);
				filterChain.doFilter(request, response);
			}
		}
	}
}
