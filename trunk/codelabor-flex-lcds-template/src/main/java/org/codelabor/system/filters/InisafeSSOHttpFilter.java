package org.codelabor.system.filters;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.codelabor.system.Constants;
import org.codelabor.system.dtos.LoginDTO;

import com.initech.eam.nls.CookieManager;

/**
 * @author SangJae Shin
 * 
 */
public class InisafeSSOHttpFilter extends InisafeSSOFilter {

	@Override
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
}
