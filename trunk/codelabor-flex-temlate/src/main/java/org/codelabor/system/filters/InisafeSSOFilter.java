package org.codelabor.system.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.initech.eam.nls.CookieManager;
import com.initech.eam.smartenforcer.SECode;

public class InisafeSSOFilter extends BaseFilterImpl {

	private String nlsLoginUrl;
	private String nlsErrorUrl;
	private String ascpUrl;
	private String ssoDomain;
	private int reuseTime;
	private int sessionTime;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
		this.nlsLoginUrl = filterConfig.getInitParameter("nlsLoginUrl");
		this.nlsErrorUrl = filterConfig.getInitParameter("nlsErrorUrl");
		this.ascpUrl = filterConfig.getInitParameter("ascpUrl");
		this.ssoDomain = filterConfig.getInitParameter("ssoDomain");
		String reuseTimeString = filterConfig.getInitParameter("reuseTime");
		String sessionTimeString = filterConfig.getInitParameter("sessionTime");
		if (reuseTimeString != null)
			reuseTime = Integer.parseInt(reuseTimeString);
		if (sessionTimeString != null)
			reuseTime = Integer.parseInt(sessionTimeString);
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

		String userUrl = request.getParameter("UURL");
		if (userUrl == null || userUrl.length() == 0)
			userUrl = ascpUrl;

		String ssoId = CookieManager
				.getCookieValue(SECode.USER_ID, httpRequest);

		try {
			// check login
			if (ssoId == null) {
				CookieManager.addCookie(SECode.USER_URL, userUrl, ssoDomain,
						httpResponse);
				if (log.isDebugEnabled()) {
					log.debug("redirect login url");
				}
				httpResponse.sendRedirect(nlsLoginUrl);
			} else {
				// validate token
				int errorCode = CookieManager.readNexessCookie(httpRequest,
						httpResponse, ssoDomain, reuseTime, sessionTime);
				if (errorCode == 0) {
					// valid token
					if (log.isDebugEnabled()) {
						log.debug("valid token");
					}
					filterChain.doFilter(request, response);
				} else {
					// invalid token
					CookieManager.removeNexessCookie(ssoDomain, httpResponse);
					StringBuilder redirectUrl = new StringBuilder();
					redirectUrl.append(nlsErrorUrl);
					redirectUrl.append("?errorCode=").append(errorCode);
					if (log.isDebugEnabled()) {
						log.debug("redirect error url");
					}
					httpResponse.sendRedirect(redirectUrl.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
