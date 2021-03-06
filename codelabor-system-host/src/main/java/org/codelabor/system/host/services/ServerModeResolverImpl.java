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
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 서버 모드 리졸버 기본 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class ServerModeResolverImpl implements ServerModeResolver {
	/**
	 * 로거
	 */
	protected Logger logger = LoggerFactory
			.getLogger(ServerModeResolverImpl.class);

	/**
	 * 호스트 정보 Map</br> IP 주소, Host명, Canonical host명이 key가 되고 서버 모드(DEVELOPMENT,
	 * STAGING, PRODUCTION)가 value가 된다.
	 */
	protected Map<String, String> hostMap;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerModeResolver#getServerMode()
	 */
	public ServerMode getServerMode() throws Exception {
		ServerMode serverMode = ServerMode.UNKNOWN;
		String hostName = InetAddress.getLocalHost().getHostName();
		logger.debug("hostName: {}", hostName);

		if (hostMap.containsKey(hostName)) {
			try {
				serverMode = ServerMode.valueOf(hostMap.get(hostName));
			} catch (IllegalArgumentException e) {
				logger.error("Invalid server mode: {}", hostMap.get(hostName));
			}
		}

		InetAddress[] inetAddressArray = InetAddress.getAllByName(hostName);
		for (InetAddress tmpInetAddress : inetAddressArray) {
			String hostAddress = tmpInetAddress.getHostAddress();
			if (hostMap.containsKey(hostAddress)) {
				try {
					serverMode = ServerMode.valueOf(hostMap.get(hostAddress));
				} catch (IllegalArgumentException e) {
					logger.error("Invalid server mode: {}", hostMap
							.get(hostAddress));
				}
			}
			logger.debug("hostAddress: {}", hostAddress);
		}
		return serverMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerModeResolver#getServerMode(java
	 * .net.InetAddress)
	 */
	public ServerMode getServerMode(InetAddress inetAddress) throws Exception {
		String ipAddress = inetAddress.getHostAddress();
		return this.getServerModeByRawIpAddress(ipAddress);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.host.services.ServerModeResolver#
	 * getServerModeByCanonicalHostName(java.lang.String)
	 */
	public ServerMode getServerModeByCanonicalHostName(String canonicalHostName)
			throws Exception {
		ServerMode serverMode = ServerMode.UNKNOWN;
		if (hostMap.containsKey(canonicalHostName)) {
			try {
				serverMode = ServerMode.valueOf(hostMap.get(canonicalHostName));
			} catch (IllegalArgumentException e) {
				logger.error("Invalid server mode: {}", hostMap
						.get(canonicalHostName));
			}
		}
		return serverMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerModeResolver#getServerModeByHostName
	 * (java.lang.String)
	 */
	public ServerMode getServerModeByHostName(String hostName) throws Exception {
		ServerMode serverMode = ServerMode.UNKNOWN;
		if (hostMap.containsKey(hostName)) {
			try {
				serverMode = ServerMode.valueOf(hostMap.get(hostName));
			} catch (IllegalArgumentException e) {
				logger.error("Invalid server mode: {}", hostMap.get(hostName));
			}
		}
		return serverMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.host.services.ServerModeResolver#
	 * getServerModeByRawIpAddress(java.lang.String)
	 */
	public ServerMode getServerModeByRawIpAddress(String rowIpAddress)
			throws Exception {
		ServerMode serverMode = ServerMode.UNKNOWN;
		if (hostMap.containsKey(rowIpAddress)) {
			try {
				serverMode = ServerMode.valueOf(hostMap.get(rowIpAddress));
			} catch (IllegalArgumentException e) {
				logger.error("Invalid server mode: {}", hostMap
						.get(rowIpAddress));
			}
		}
		return serverMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerModeResolver#isDevelopmentMode()
	 */
	public boolean isDevelopmentMode() throws Exception {
		return ServerMode.DEVELOPMENT.equals(this.getServerMode());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerModeResolver#isDevelopmentMode
	 * (java.net.InetAddress)
	 */
	public boolean isDevelopmentMode(InetAddress inetAddress) throws Exception {
		return ServerMode.DEVELOPMENT.equals(this.getServerMode(inetAddress));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.host.services.ServerModeResolver#
	 * isDevelopmentModeByCanonicalHostName(java.lang.String)
	 */
	public boolean isDevelopmentModeByCanonicalHostName(String canonicalHostName)
			throws Exception {
		return ServerMode.DEVELOPMENT.equals(this
				.getServerModeByCanonicalHostName(canonicalHostName));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.host.services.ServerModeResolver#
	 * isDevelopmentModeByHostName(java.lang.String)
	 */
	public boolean isDevelopmentModeByHostName(String hostName)
			throws Exception {
		return ServerMode.DEVELOPMENT.equals(this
				.getServerModeByHostName(hostName));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.host.services.ServerModeResolver#
	 * isDevelopmentModeByRawIpAddress(java.lang.String)
	 */
	public boolean isDevelopmentModeByRawIpAddress(String rawIpAddress)
			throws Exception {
		return ServerMode.DEVELOPMENT.equals(this
				.getServerModeByRawIpAddress(rawIpAddress));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerModeResolver#isProductionMode()
	 */
	public boolean isProductionMode() throws Exception {
		return ServerMode.PRODUCTION.equals(this.getServerMode());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerModeResolver#isProductionMode
	 * (java.net.InetAddress)
	 */
	public boolean isProductionMode(InetAddress inetAddress) throws Exception {
		return ServerMode.PRODUCTION.equals(this.getServerMode(inetAddress));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.host.services.ServerModeResolver#
	 * isProductionModeByCanonicalHostName(java.lang.String)
	 */
	public boolean isProductionModeByCanonicalHostName(String canonicalHostName)
			throws Exception {
		return ServerMode.PRODUCTION.equals(this
				.getServerModeByCanonicalHostName(canonicalHostName));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.host.services.ServerModeResolver#
	 * isProductionModeByHostName(java.lang.String)
	 */
	public boolean isProductionModeByHostName(String hostName) throws Exception {
		return ServerMode.PRODUCTION.equals(this
				.getServerModeByHostName(hostName));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.host.services.ServerModeResolver#
	 * isProductionModeByRawIpAddress(java.lang.String)
	 */
	public boolean isProductionModeByRawIpAddress(String rawIpAddress)
			throws Exception {
		return ServerMode.PRODUCTION.equals(this
				.getServerModeByRawIpAddress(rawIpAddress));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerModeResolver#isStagingMode()
	 */
	public boolean isStagingMode() throws Exception {
		return ServerMode.STAGING.equals(this.getServerMode());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerModeResolver#isStagingMode(java
	 * .net.InetAddress)
	 */
	public boolean isStagingMode(InetAddress inetAddress) throws Exception {
		return ServerMode.STAGING.equals(this.getServerMode(inetAddress));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.host.services.ServerModeResolver#
	 * isStagingModeByCanonicalHostName(java.lang.String)
	 */
	public boolean isStagingModeByCanonicalHostName(String canonicalHostName)
			throws Exception {
		return ServerMode.STAGING.equals(this
				.getServerModeByCanonicalHostName(canonicalHostName));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.host.services.ServerModeResolver#isStagingModeByHostName
	 * (java.lang.String)
	 */
	public boolean isStagingModeByHostName(String hostName) throws Exception {
		return ServerMode.STAGING
				.equals(this.getServerModeByHostName(hostName));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.host.services.ServerModeResolver#
	 * isStagingModeByRawIpAddress(java.lang.String)
	 */
	public boolean isStagingModeByRawIpAddress(String rawIpAddress)
			throws Exception {
		return ServerMode.STAGING.equals(this
				.getServerModeByRawIpAddress(rawIpAddress));
	}

	/**
	 * 호스트 정보 Map을 설정한다.
	 * 
	 * @param hostMap
	 *            호스트 정보 Map
	 */
	public void setHostMap(Map<String, String> hostMap) {
		this.hostMap = hostMap;
	}

}
