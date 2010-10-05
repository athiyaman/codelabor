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
 * 로그인 세션 리스너</br>
 * 
 * 
 * @author Shin Sangjae
 * 
 */
public class LoginHttpSessionListener extends BaseListener implements
		HttpSessionListener, HttpSessionAttributeListener,
		HttpSessionActivationListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionAttributeListener#attributeAdded(javax.
	 * servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(event.getSession()
						.getServletContext());
		LoginService loginService = (LoginService) ctx.getBean("loginService");

		logger.debug("thread: {}", Thread.currentThread());
		logger.debug("instance: {}", this.hashCode());
		logger.debug("name: {}", event.getName());
		logger.debug("value: {}", event.getValue());
		logger.debug("session id: {}", event.getSession().getId());
		logger.debug("soruce: {}", event.getSource());

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionAttributeListener#attributeRemoved(javax
	 * .servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(event.getSession()
						.getServletContext());
		LoginService loginService = (LoginService) ctx.getBean("loginService");

		logger.debug("thread: {}", Thread.currentThread());
		logger.debug("instance: {}", this.hashCode());
		logger.debug("name: {}", event.getName());
		logger.debug("value: {}", event.getValue());
		logger.debug("session id: {}", event.getSession().getId());
		logger.debug("soruce: {}", event.getSource());

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax
	 * .servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		logger.debug("name: {}", event.getName());
		logger.debug("value: {}", event.getValue());
		logger.debug("session id: {}", event.getSession().getId());
		logger.debug("soruce: {}", event.getSource());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http
	 * .HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent event) {
		logger.debug("session id: {}", event.getSession().getId());
		logger.debug("soruce: {}", event.getSource());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet
	 * .http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		logger.debug("session id: {}", event.getSession().getId());
		logger.debug("soruce: {}", event.getSource());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionActivationListener#sessionDidActivate(javax
	 * .servlet.http.HttpSessionEvent)
	 */
	public void sessionDidActivate(HttpSessionEvent event) {
		logger.debug("session id: {}", event.getSession().getId());
		logger.debug("soruce: {}", event.getSource());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionActivationListener#sessionWillPassivate
	 * (javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionWillPassivate(HttpSessionEvent event) {
		logger.debug("session id: {}", event.getSession().getId());
		logger.debug("soruce: {}", event.getSource());
	}
}
