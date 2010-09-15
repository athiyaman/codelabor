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

/**
 * 서버 모드 리졸버 기본 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class ServerModeResolverImpl implements ServerModeResolver {

	/**
	 * 호스트 정보 Map</br> IP 주소, Host명, Canonical host명이 key가 되고 서버 모드(DEVELOPMENT,
	 * STAGING, PRODUCTION)가 value가 된다.
	 */
	protected Map<String, String> hostMap;

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
		ServerMode serverMode = ServerMode.DEVELOPMENT;
		if (hostMap.containsKey(canonicalHostName)) {
			serverMode = ServerMode.valueOf(hostMap.get(canonicalHostName));
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
		ServerMode serverMode = ServerMode.DEVELOPMENT;
		if (hostMap.containsKey(hostName)) {
			serverMode = ServerMode.valueOf(hostMap.get(hostName));
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
		ServerMode serverMode = ServerMode.DEVELOPMENT;
		if (hostMap.containsKey(rowIpAddress)) {
			serverMode = ServerMode.valueOf(hostMap.get(rowIpAddress));
		}
		return serverMode;
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
