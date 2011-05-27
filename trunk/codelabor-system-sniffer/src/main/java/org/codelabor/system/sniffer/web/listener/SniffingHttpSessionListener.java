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

package org.codelabor.system.sniffer.web.listener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 스니핑 세션 리스너</br> 세션 변화에 대한 정보를 출력한다.
 * 
 * 
 * @author Shin Sangjae
 * 
 */
public class SniffingHttpSessionListener implements
		HttpSessionListener, HttpSessionAttributeListener,
		HttpSessionActivationListener {

	private Logger logger = LoggerFactory.getLogger(SniffingHttpSessionListener.class);

	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * javax.servlet.http.HttpSessionAttributeListener#attributeAdded(javax.
	 * servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {
		HttpSession httpSession = event.getSession();
		Date creationTime = new Date(httpSession.getCreationTime());
		Date lastAccessedTime = new Date(httpSession.getLastAccessedTime());
		logger.debug("Session attribute added");
		logger.debug("  isNew: {}", httpSession.isNew());
		logger.debug("  id: {}", httpSession.getId());
		logger.debug("  creation time: {}", dateFormat.format(creationTime));
		logger.debug("  last access time: {}", dateFormat
				.format(lastAccessedTime));
		logger.debug("  max inactive interval: {} seconds", httpSession
				.getMaxInactiveInterval());
		logger.debug("  event soruce: {}", event.getSource());
		logger.debug("  event name: {}", event.getName());
		logger.debug("  event value: {}", event.getValue());
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
		Date creationTime = new Date(httpSession.getCreationTime());
		Date lastAccessedTime = new Date(httpSession.getLastAccessedTime());
		logger.debug("Session attribute removed");
		logger.debug("  id: {}", httpSession.getId());
		logger.debug("  creation time: {}", dateFormat.format(creationTime));
		logger.debug("  last access time: {}", dateFormat
				.format(lastAccessedTime));
		logger.debug("  max inactive interval: {} seconds", httpSession
				.getMaxInactiveInterval());
		logger.debug("  event soruce: {}", event.getSource());
		logger.debug("  event name: {}", event.getName());
		logger.debug("  event value: {}", event.getValue());
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
		Date creationTime = new Date(httpSession.getCreationTime());
		Date lastAccessedTime = new Date(httpSession.getLastAccessedTime());
		logger.debug("Session attribute replaced");
		logger.debug("  id: {}", httpSession.getId());
		logger.debug("  creation time: {}", dateFormat.format(creationTime));
		logger.debug("  last access time: {}", dateFormat
				.format(lastAccessedTime));
		logger.debug("  max inactive interval: {} seconds", httpSession
				.getMaxInactiveInterval());
		logger.debug("  event soruce: {}", event.getSource());
		logger.debug("  event name: {}", event.getName());
		logger.debug("  event value: {}", event.getValue());
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
		Date creationTime = new Date(httpSession.getCreationTime());
		Date lastAccessedTime = new Date(httpSession.getLastAccessedTime());
		logger.debug("Session created");
		logger.debug("  id: {}", httpSession.getId());
		logger.debug("  creation time: {}", dateFormat.format(creationTime));
		logger.debug("  last access time: {}", dateFormat
				.format(lastAccessedTime));
		logger.debug("  max inactive interval: {} seconds", httpSession
				.getMaxInactiveInterval());
		logger.debug("  event soruce: {}", event.getSource());
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
		Date creationTime = new Date(httpSession.getCreationTime());
		Date lastAccessedTime = new Date(httpSession.getLastAccessedTime());
		logger.debug("Session destroyed");
		logger.debug("  id: {}", httpSession.getId());
		logger.debug("  creation time: {}", dateFormat.format(creationTime));
		logger.debug("  last access time: {}", dateFormat
				.format(lastAccessedTime));
		logger.debug("  max inactive interval: {} seconds", httpSession
				.getMaxInactiveInterval());
		logger.debug("  event soruce: {}", event.getSource());
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
		Date creationTime = new Date(httpSession.getCreationTime());
		Date lastAccessedTime = new Date(httpSession.getLastAccessedTime());
		logger.debug("Session did activate");
		logger.debug("  id: {}", httpSession.getId());
		logger.debug("  creation time: {}", dateFormat.format(creationTime));
		logger.debug("  last access time: {}", dateFormat
				.format(lastAccessedTime));
		logger.debug("  max inactive interval: {} seconds", httpSession
				.getMaxInactiveInterval());
		logger.debug("  event soruce: {}", event.getSource());
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
		Date creationTime = new Date(httpSession.getCreationTime());
		Date lastAccessedTime = new Date(httpSession.getLastAccessedTime());
		logger.debug("Session will passivate");
		logger.debug("  id: {}", httpSession.getId());
		logger.debug("  creation time: {}", dateFormat.format(creationTime));
		logger.debug("  last access time: {}", dateFormat
				.format(lastAccessedTime));
		logger.debug("  max inactive interval: {} seconds", httpSession
				.getMaxInactiveInterval());
		logger.debug("  event soruce: {}", event.getSource());
	}
}
