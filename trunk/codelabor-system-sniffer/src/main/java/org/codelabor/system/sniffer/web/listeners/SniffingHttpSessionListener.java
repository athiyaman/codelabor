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

package org.codelabor.system.sniffer.web.listeners;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.codelabor.system.listeners.BaseListener;

/**
 * 스니핑 세션 리스너</br> 세션 변화에 대한 정보를 출력한다.
 * 
 * 
 * @author Shin Sangjae
 * 
 */
public class SniffingHttpSessionListener extends BaseListener implements
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
		HttpSession httpSession = event.getSession();
		logger.debug("session id: {}", httpSession.getId());
		logger
				.debug("session creation time: {}", httpSession
						.getCreationTime());
		logger.debug("session last access time: {}", httpSession
				.getLastAccessedTime());
		logger.debug("session max inactive interval: {}", httpSession
				.getMaxInactiveInterval());
		logger.debug("event soruce: {}", event.getSource());
		logger.debug("event name: {}", event.getName());
		logger.debug("event value: {}", event.getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionAttributeListener#attributeRemoved(javax
	 * .servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {
		HttpSession httpSession = event.getSession();
		logger.debug("session id: {}", httpSession.getId());
		logger
				.debug("session creation time: {}", httpSession
						.getCreationTime());
		logger.debug("session last access time: {}", httpSession
				.getLastAccessedTime());
		logger.debug("session max inactive interval: {}", httpSession
				.getMaxInactiveInterval());
		logger.debug("event soruce: {}", event.getSource());
		logger.debug("event name: {}", event.getName());
		logger.debug("event value: {}", event.getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax
	 * .servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		HttpSession httpSession = event.getSession();
		logger.debug("session id: {}", httpSession.getId());
		logger
				.debug("session creation time: {}", httpSession
						.getCreationTime());
		logger.debug("session last access time: {}", httpSession
				.getLastAccessedTime());
		logger.debug("session max inactive interval: {}", httpSession
				.getMaxInactiveInterval());
		logger.debug("event soruce: {}", event.getSource());
		logger.debug("event name: {}", event.getName());
		logger.debug("event value: {}", event.getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http
	 * .HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession httpSession = event.getSession();
		logger.debug("session id: {}", httpSession.getId());
		logger
				.debug("session creation time: {}", httpSession
						.getCreationTime());
		logger.debug("session last access time: {}", httpSession
				.getLastAccessedTime());
		logger.debug("session max inactive interval: {}", httpSession
				.getMaxInactiveInterval());
		logger.debug("event soruce: {}", event.getSource());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet
	 * .http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession httpSession = event.getSession();
		logger.debug("session id: {}", httpSession.getId());
		logger
				.debug("session creation time: {}", httpSession
						.getCreationTime());
		logger.debug("session last access time: {}", httpSession
				.getLastAccessedTime());
		logger.debug("session max inactive interval: {}", httpSession
				.getMaxInactiveInterval());
		logger.debug("event soruce: {}", event.getSource());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionActivationListener#sessionDidActivate(javax
	 * .servlet.http.HttpSessionEvent)
	 */
	public void sessionDidActivate(HttpSessionEvent event) {
		HttpSession httpSession = event.getSession();
		logger.debug("session id: {}", httpSession.getId());
		logger
				.debug("session creation time: {}", httpSession
						.getCreationTime());
		logger.debug("session last access time: {}", httpSession
				.getLastAccessedTime());
		logger.debug("session max inactive interval: {}", httpSession
				.getMaxInactiveInterval());
		logger.debug("event soruce: {}", event.getSource());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionActivationListener#sessionWillPassivate
	 * (javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionWillPassivate(HttpSessionEvent event) {
		HttpSession httpSession = event.getSession();
		logger.debug("session id: {}", httpSession.getId());
		logger
				.debug("session creation time: {}", httpSession
						.getCreationTime());
		logger.debug("session last access time: {}", httpSession
				.getLastAccessedTime());
		logger.debug("session max inactive interval: {}", httpSession
				.getMaxInactiveInterval());
		logger.debug("event soruce: {}", event.getSource());
	}
}
