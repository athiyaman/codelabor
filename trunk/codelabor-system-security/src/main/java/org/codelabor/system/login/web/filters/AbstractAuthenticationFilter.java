package org.codelabor.system.login.web.filters;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.web.filters.BaseFilterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 인증 필터
 * 
 * @author Shin Sangjae
 * 
 */
public abstract class AbstractAuthenticationFilter extends BaseFilterImpl {

	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory
			.getLogger(AbstractAuthenticationFilter.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.web.filters.BaseFilterImpl#init(javax.servlet.
	 * FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
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

		try {
			if (!isAuthenticated(httpRequest, httpResponse)) {
				this.forwardLoginPage(httpRequest, httpResponse);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.equals(e.getMessage());
		}
	}

	public abstract boolean isAuthenticated(HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	public abstract void forwardLoginPage(HttpServletRequest request,
			HttpServletResponse response) throws Exception;

}
