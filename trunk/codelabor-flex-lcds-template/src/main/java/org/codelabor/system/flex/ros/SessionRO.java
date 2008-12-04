package org.codelabor.system.flex.ros;

import org.codelabor.system.Constants;
import org.codelabor.system.dtos.LoginDTO;

import flex.messaging.FlexContext;
import flex.messaging.FlexSession;

public class SessionRO {
	public LoginDTO getLoginInfo() {
		FlexSession session = FlexContext.getFlexSession();
		LoginDTO loginDTO = null;
		if (session != null) {
			loginDTO = (LoginDTO) session
					.getAttribute(Constants.SESSION_LOGIN_INFO_KEY);
			System.out.print("loginDTO: " + loginDTO);
		}
		return loginDTO;
	}

	public String getLoginUserId() {
		String userId = null;
		LoginDTO loginDTO = this.getLoginInfo();
		if (loginDTO != null) {
			userId = loginDTO.getUserId();
		}
		return userId;
	}

	public void setAttribute(String name, Object value) {
		FlexSession session = FlexContext.getFlexSession();
		if (session != null) {
			session.setAttribute(name, value);
		}
	}

	public Object getAttribute(String name) {
		FlexSession session = FlexContext.getFlexSession();
		Object value = null;
		if (session != null) {
			value = session.getAttribute(name);
		}
		return value;
	}
}
