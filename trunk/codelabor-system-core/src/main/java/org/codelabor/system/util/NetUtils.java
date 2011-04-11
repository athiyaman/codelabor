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

package org.codelabor.system.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Net 패키지 관련 유틸리티 클래스
 * 
 * @author Shin Sang-jae
 * 
 */
public class NetUtils {
	/**
	 * 로거
	 */
	static final Logger logger = LoggerFactory.getLogger(NetUtils.class);

	/**
	 * 로컬 호스트인지 확인한다.
	 * 
	 * @param inetAddress
	 *            InetAddress 주소
	 * @return 로컬 호스트 여부
	 * @throws UnknownHostException
	 *             알수없는 호스트 예외
	 */
	static public boolean isLocalhost(InetAddress inetAddress)
			throws UnknownHostException {
		boolean isLocalhost = false;
		String hostName = InetAddress.getLocalHost().getHostName();
		logger.info("hostName: {}", hostName);

		InetAddress[] inetAddressArray = InetAddress.getAllByName(hostName);
		for (InetAddress tmpInetAddress : inetAddressArray) {
			logger.info("hostAddress: {}", tmpInetAddress.getHostAddress());
			if (inetAddress.equals(tmpInetAddress)) {
				isLocalhost = true;
			}
		}
		return isLocalhost;
	}

	/**
	 * Raw IP Address로 로컬 호스트인지 확인한다.
	 * 
	 * @param rawIpAddress
	 *            Raw IP Address
	 * @return 로컬 호스트 여부
	 * @throws UnknownHostException
	 *             알수없는 호스트 예외
	 */
	static public boolean isLocalhostByRawIpAddress(String rawIpAddress)
			throws UnknownHostException {
		boolean isLocalhost = false;
		String hostName = InetAddress.getLocalHost().getHostName();
		logger.info("hostName: {}", hostName);

		InetAddress[] inetAddressArray = InetAddress.getAllByName(hostName);
		for (InetAddress tmpInetAddress : inetAddressArray) {
			logger.info("hostAddress: {}", tmpInetAddress.getHostAddress());
			if (rawIpAddress.equals(tmpInetAddress.toString())) {
				isLocalhost = true;
			}
		}
		return isLocalhost;
	}

	/**
	 * 호스트명으로 로컬 호스트인지 확인한다.
	 * 
	 * @param hostName
	 *            호스트명
	 * @return 로컬 호스트 여부
	 * @throws UnknownHostException
	 *             알수없는 호스트 예외
	 */
	static public boolean isLocalhostByHostName(String hostName)
			throws UnknownHostException {
		boolean isLocalhost = false;
		String localhostName = InetAddress.getLocalHost().getHostName();
		logger.info("hostName: {}", localhostName);

		InetAddress[] inetAddressArray = InetAddress
				.getAllByName(localhostName);
		for (InetAddress tmpInetAddress : inetAddressArray) {
			logger.info("hostAddress: {}", tmpInetAddress.getHostAddress());
			if (hostName.equals(tmpInetAddress.getHostName())) {
				isLocalhost = true;
			}
		}
		return isLocalhost;
	}

}
