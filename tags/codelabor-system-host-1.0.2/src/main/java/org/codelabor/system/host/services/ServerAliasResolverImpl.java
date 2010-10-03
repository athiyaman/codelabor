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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

/**
 * @author Shin Sangjae
 * 
 */
public class ServerAliasResolverImpl implements ServerAliasResolver {
	/**
	 * 로거
	 */
	protected Logger logger = LoggerFactory
			.getLogger(ServerAliasResolverImpl.class);

	/**
	 * 메시지 소스
	 */
	protected MessageSource messageSource;

	/**
	 * 기본 서버 별명
	 */
	protected final static String defaultServerAlias = "UNKOWN";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerAliasResolver#getServerAlias
	 * (java.util.Locale)
	 */
	public String getServerAlias(Locale locale) throws Exception {
		String serverAlias = defaultServerAlias;
		String hostName = InetAddress.getLocalHost().getHostName();
		logger.debug("hostName: {}, locale: {}", hostName, locale);
		serverAlias = messageSource.getMessage(hostName, null,
				defaultServerAlias, locale);

		InetAddress[] inetAddressArray = InetAddress.getAllByName(hostName);
		for (InetAddress tmpInetAddress : inetAddressArray) {
			String hostAddress = tmpInetAddress.getHostAddress();
			logger.debug("hostAddress: {}, locale: {}", hostAddress, locale);
			serverAlias = messageSource.getMessage(hostName, null,
					defaultServerAlias, locale);
		}
		return serverAlias;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerAliasResolver#getServerAlias
	 * (java.net.InetAddress, java.util.Locale)
	 */
	public String getServerAlias(InetAddress inetAddress, Locale locale)
			throws Exception {
		String ipAddress = inetAddress.getHostAddress();
		logger.debug("ipAddress: {}, locale: {}", ipAddress, locale);
		return messageSource.getMessage(ipAddress, null, defaultServerAlias,
				locale);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.host.services.ServerAliasResolver#
	 * getServerAliasByCanonicalHostName(java.lang.String, java.util.Locale)
	 */
	public String getServerAliasByCanonicalHostName(String canonicalHostName,
			Locale locale) throws Exception {
		logger.debug("canonicalHostName: {}, locale: {}", canonicalHostName,
				locale);
		return messageSource.getMessage(canonicalHostName, null,
				defaultServerAlias, locale);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.host.services.ServerAliasResolver#
	 * getServerAliasByHostName(java.lang.String, java.util.Locale)
	 */
	public String getServerAliasByHostName(String hostName, Locale locale)
			throws Exception {
		logger.debug("hostName: {}, locale: {}", hostName, locale);
		return messageSource.getMessage(hostName, null, defaultServerAlias,
				locale);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.host.services.ServerAliasResolver#
	 * getServerAliasByRawIpAddress(java.lang.String, java.util.Locale)
	 */
	public String getServerAliasByRawIpAddress(String rowIpAddress,
			Locale locale) throws Exception {
		logger.debug("rowIpAddress: {}, locale: {}", rowIpAddress, locale);
		return messageSource.getMessage(rowIpAddress, null, defaultServerAlias,
				locale);
	}

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
	 * org.codelabor.system.host.services.ServerAliasResolver#getServerAlias()
	 */
	public String getServerAlias() throws Exception {
		return this.getServerAlias(Locale.getDefault());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerAliasResolver#getServerAlias
	 * (java.net.InetAddress)
	 */
	public String getServerAlias(InetAddress inetAddress) throws Exception {
		return this.getServerAlias(inetAddress, Locale.getDefault());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.host.services.ServerAliasResolver#
	 * getServerAliasByCanonicalHostName(java.lang.String)
	 */
	public String getServerAliasByCanonicalHostName(String canonicalHostName)
			throws Exception {
		return this.getServerAliasByCanonicalHostName(canonicalHostName, Locale
				.getDefault());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.host.services.ServerAliasResolver#
	 * getServerAliasByHostName(java.lang.String)
	 */
	public String getServerAliasByHostName(String hostName) throws Exception {
		return this.getServerAliasByHostName(hostName, Locale.getDefault());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.host.services.ServerAliasResolver#
	 * getServerAliasByRawIpAddress(java.lang.String)
	 */
	public String getServerAliasByRawIpAddress(String rowIpAddress)
			throws Exception {
		return this.getServerAliasByRawIpAddress(rowIpAddress, Locale
				.getDefault());
	}

}
