package org.codelabor.system.flex.ros;

import org.codelabor.system.Constants;
import org.codelabor.system.dtos.LoginDTO;

import flex.messaging.FlexContext;

public class SessionRO {
	public LoginDTO getLoginInfo() {
		return (LoginDTO) FlexContext.getFlexSession().getAttribute(
				Constants.SESSION_LOGIN_INFO_KEY);
	}
}
