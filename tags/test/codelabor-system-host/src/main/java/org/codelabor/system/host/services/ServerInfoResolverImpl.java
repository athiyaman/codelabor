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
package org.codelabor.system.host.services;

import java.net.InetAddress;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

/**
 * 서버 별명 리졸버</br> 서버 별명을 Message Source를 통해 얻어온다.
 * 
 * @author Shin Sangjae
 * 
 */
public class ServerInfoResolverImpl implements ServerInfoResolver {
	/**
	 * 로거
	 */
	protected Logger logger = LoggerFactory
			.getLogger(ServerInfoResolverImpl.class);

	/**
	 * 메시지 소스
	 */
	protected MessageSource messageSource;

	/**
	 * 기본 값
	 */
	protected final static String defaultValue = "UNKOWN";

	/**
	 * 메시지 소스를 설정한다.
	 * 
	 * @param messageSource
	 *            메시지 소스
	 */
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerInfoResolver#getServerAlias()
	 */
	public String getServerAlias() throws Exception {
		return this.getValue("alias", Locale.getDefault());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerInfoResolver#getServerAlias(
	 * java.util.Locale)
	 */
	public String getServerAlias(Locale locale) throws Exception {
		return this.getValue("alias", locale);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerInfoResolver#getServerMode()
	 */
	public String getServerMode() throws Exception {
		return this.getValue("mode", Locale.getDefault());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerInfoResolver#getServerMode(java
	 * .util.Locale)
	 */
	public String getServerMode(Locale locale) throws Exception {
		return this.getValue("mode", locale);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerInfoResolver#getServerWindowName
	 * ()
	 */
	public String getServerWindowName() throws Exception {
		return this.getValue("window.name", Locale.getDefault());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerInfoResolver#getServerWindowName
	 * (java.util.Locale)
	 */
	public String getServerWindowName(Locale locale) throws Exception {
		return this.getValue("window.name", locale);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerInfoResolver#getServerDocumentTitle
	 * ()
	 */
	public String getServerDocumentTitle() throws Exception {
		return this.getValue("document.title", Locale.getDefault());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerInfoResolver#getServerDocumentTitle
	 * (java.util.Locale)
	 */
	public String getServerDocumentTitle(Locale locale) throws Exception {
		return this.getValue("document.title", locale);
	}

	private String getValue(String attribute, Locale locale) throws Exception {
		String key = null;
		String value = defaultValue;
		String hostName = InetAddress.getLocalHost().getHostName();
		logger.debug("hostName: {}, locale: {}", hostName, locale);
		if (StringUtils.isNotEmpty(attribute)) {
			StringBuilder sb = new StringBuilder();
			sb.append(hostName).append(".").append(attribute);
			key = sb.toString();
		} else {
			key = hostName;
		}
		value = messageSource.getMessage(key, null, defaultValue, locale);
		logger.debug("key: {}, value: {}", key, value);
		return value;
	}
}
