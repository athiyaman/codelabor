/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codelabor.system.login.web.listeners;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.codelabor.system.anyframe.utils.MessageUtils;
import org.codelabor.system.dtos.MessageDTO;
import org.codelabor.system.listeners.BaseListener;
import org.codelabor.system.login.dtos.LoginDTO;
import org.codelabor.system.login.services.LoginService;
import org.codelabor.system.web.SessionConstants;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author Shin Sangjae
 * 
 */
public class LoginHttpSessionListener extends BaseListener implements
		HttpSessionListener, HttpSessionAttributeListener,
		HttpSessionActivationListener {

	public void attributeAdded(HttpSessionBindingEvent event) {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(event.getSession()
						.getServletContext());
		LoginService loginService = (LoginService) ctx.getBean("loginService");
		StringBuilder stringBuilder = new StringBuilder();
		if (logger.isDebugEnabled()) {
			stringBuilder.append("thread: ").append(Thread.currentThread());
			stringBuilder.append(", ");
			stringBuilder.append("instance: ").append(this.hashCode());
			stringBuilder.append(", ");

			stringBuilder.append("name: ");
			stringBuilder.append(event.getName());
			stringBuilder.append(", ");
			stringBuilder.append("value: ");
			stringBuilder.append(event.getValue());
			stringBuilder.append(", ");
			stringBuilder.append("session id: ");
			stringBuilder.append(event.getSession().getId());
			stringBuilder.append(", ");
			stringBuilder.append("soruce: ");
			stringBuilder.append(event.getSource());
			logger.debug(stringBuilder.toString());
		}

		if (event.getName().equals(SessionConstants.SESSION_LOGIN_INFO)) {
			HttpSession session = event.getSession();
			LoginDTO loginDTO = (LoginDTO) session
					.getAttribute(SessionConstants.SESSION_LOGIN_INFO);
			loginDTO.setSessionId(session.getId());
			try {
				loginService.login(loginDTO);
				loginDTO = loginService.selectLogin(loginDTO);
				session.setAttribute(SessionConstants.SESSION_LOGIN_INFO,
						loginDTO);
			} catch (Exception e) {
				e.printStackTrace();
				MessageDTO messageDTO = MessageUtils.exceptionToMessageDTO(e);
				if (logger.isErrorEnabled()) {
					logger.error(messageDTO.getUserMessage(), e);
				}
			}
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(event.getSession()
						.getServletContext());
		LoginService loginService = (LoginService) ctx.getBean("loginService");
		StringBuilder stringBuilder = new StringBuilder();
		if (logger.isDebugEnabled()) {
			stringBuilder.append("thread: ").append(Thread.currentThread());
			stringBuilder.append(", ");
			stringBuilder.append("instance: ").append(this.hashCode());
			stringBuilder.append(", ");

			stringBuilder.append("name: ");
			stringBuilder.append(event.getName());
			stringBuilder.append(", ");
			stringBuilder.append("value: ");
			stringBuilder.append(event.getValue());
			stringBuilder.append(", ");
			stringBuilder.append("session id: ");
			stringBuilder.append(event.getSession().getId());
			stringBuilder.append(", ");
			stringBuilder.append("soruce: ");
			stringBuilder.append(event.getSource());
			logger.debug(stringBuilder.toString());
		}

		if (event.getName().equals(SessionConstants.SESSION_LOGIN_INFO)) {
			LoginDTO loginDTO = new LoginDTO();
			loginDTO.setSessionId(event.getSession().getId());
			try {
				loginService.logout(loginDTO);
			} catch (Exception e) {
				e.printStackTrace();
				MessageDTO messageDTO = MessageUtils.exceptionToMessageDTO(e);
				if (logger.isErrorEnabled()) {
					logger.error(messageDTO.getUserMessage(), e);
				}
			}
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		StringBuilder stringBuilder = new StringBuilder();
		if (logger.isDebugEnabled()) {
			stringBuilder.append("name: ");
			stringBuilder.append(event.getName());
			stringBuilder.append(", ");
			stringBuilder.append("value: ");
			stringBuilder.append(event.getValue());
			stringBuilder.append(", ");
			stringBuilder.append("session id: ");
			stringBuilder.append(event.getSession().getId());
			stringBuilder.append(", ");
			stringBuilder.append("soruce: ");
			stringBuilder.append(event.getSource());
			logger.debug(stringBuilder.toString());
		}
	}

	public void sessionCreated(HttpSessionEvent event) {

		StringBuilder stringBuilder = new StringBuilder();
		if (logger.isDebugEnabled()) {
			stringBuilder.append("session id: ");
			stringBuilder.append(event.getSession().getId());
			stringBuilder.append(", ");
			stringBuilder.append("soruce: ");
			stringBuilder.append(event.getSource());
			logger.debug(stringBuilder.toString());
		}
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		StringBuilder stringBuilder = new StringBuilder();
		if (logger.isDebugEnabled()) {
			stringBuilder.append("session id: ");
			stringBuilder.append(event.getSession().getId());
			stringBuilder.append(", ");
			stringBuilder.append("soruce: ");
			stringBuilder.append(event.getSource());
			logger.debug(stringBuilder.toString());
		}
	}

	public void sessionDidActivate(HttpSessionEvent event) {
		StringBuilder stringBuilder = new StringBuilder();
		if (logger.isDebugEnabled()) {
			stringBuilder.append("session id: ");
			stringBuilder.append(event.getSession().getId());
			stringBuilder.append(", ");
			stringBuilder.append("soruce: ");
			stringBuilder.append(event.getSource());
			logger.debug(stringBuilder.toString());
		}
	}

	public void sessionWillPassivate(HttpSessionEvent event) {
		StringBuilder stringBuilder = new StringBuilder();
		if (logger.isDebugEnabled()) {
			stringBuilder.append("session id: ");
			stringBuilder.append(event.getSession().getId());
			stringBuilder.append(", ");
			stringBuilder.append("soruce: ");
			stringBuilder.append(event.getSource());
			logger.debug(stringBuilder.toString());
		}
	}
}
