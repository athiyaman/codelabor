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

/**
 * 서버 모드 리졸버</br> 서버의 ip 주소나 host명을 입력 받아 해당 서버의 모드 정보를 가져온다. 서버 모드는
 * 개발(DEVELOPMENT), 검증(STAGING), 운영(PRODUCTION)의 세 가지 유형이 있다.
 * 
 * @author Shin Sangjae
 * 
 */
public interface ServerModeResolver {
	/**
	 * 로컬 장비의 서버 모드를 가져온다.
	 * 
	 * @return 서버 모드
	 * @throws Exception
	 */
	public ServerMode getServerMode() throws Exception;

	/**
	 * 서버 모드를 가져온다.
	 * 
	 * @param inetAddress
	 *            InetAddress 타입의 주소
	 * @return 서버 모드
	 * @throws Exception
	 */
	public ServerMode getServerMode(InetAddress inetAddress) throws Exception;

	/**
	 * Raw IP 주소로 서버 모드를 가져온다.
	 * 
	 * @param rowIpAddress
	 *            Raw IP 주소
	 * @return 서버 모드
	 * @throws Exception
	 */
	public ServerMode getServerModeByRawIpAddress(String rowIpAddress)
			throws Exception;

	/**
	 * Host명 서버 모드를 가져온다.
	 * 
	 * @param hostName
	 *            Host명
	 * @return 서버 모드
	 * @throws Exception
	 */
	public ServerMode getServerModeByHostName(String hostName) throws Exception;

	/**
	 * 서버 모드를 가져온다.
	 * 
	 * @param canonicalHostName
	 *            Canonical host명
	 * @return 서버 모드
	 * @throws Exception
	 */
	public ServerMode getServerModeByCanonicalHostName(String canonicalHostName)
			throws Exception;

	/**
	 * 로컬 장비가 개발 모드인지 확인한다.
	 * 
	 * @return 개발 모드 여부
	 * @throws Exception
	 */
	public boolean isDevelopmentMode() throws Exception;

	/**
	 * InetAddress로 개발 모드인지 확인한다.
	 * 
	 * @param inetAddress
	 * @return 개발 모드 여부
	 * @throws Exception
	 */
	public boolean isDevelopmentMode(InetAddress inetAddress) throws Exception;

	/**
	 * Raw IP 주소로 개발 모드인지 확인한다.
	 * 
	 * @param rawIpAddress
	 * @return 개발 모드 여부
	 * @throws Exception
	 */
	public boolean isDevelopmentModeByRawIpAddress(String rawIpAddress)
			throws Exception;

	/**
	 * Host명으로 개발 모드인지 확인한다.
	 * 
	 * @param hostName
	 * @return 개발 모드 여부
	 * @throws Exception
	 */
	public boolean isDevelopmentModeByHostName(String hostName)
			throws Exception;

	/**
	 * Canonical host명으로 개발 모드인지 확인한다.
	 * 
	 * @param canonicalHostName
	 * @return 개발 모드 여부
	 * @throws Exception
	 */
	public boolean isDevelopmentModeByCanonicalHostName(String canonicalHostName)
			throws Exception;

	/**
	 * 로컬 장비가 검증 모드인지 확인한다.
	 * 
	 * @return 검증 모드 여부
	 * @throws Exception
	 */
	public boolean isStagingMode() throws Exception;

	/**
	 * InetAddress로 검증 모드인지 확인한다.
	 * 
	 * @param inetAddress
	 * @return 검증 모드 여부
	 * @throws Exception
	 */
	public boolean isStagingMode(InetAddress inetAddress) throws Exception;

	/**
	 * Raw IP 주소로 검증 모드인지 확인한다.
	 * 
	 * @param rawIpAddress
	 * @return 검증 모드 여부
	 * @throws Exception
	 */
	public boolean isStagingModeByRawIpAddress(String rawIpAddress)
			throws Exception;

	/**
	 * Host명으로 검증 모드인지 확인한다.
	 * 
	 * @param hostName
	 * @return 검증 모드 여부
	 * @throws Exception
	 */
	public boolean isStagingModeByHostName(String hostName) throws Exception;

	/**
	 * Canonical host명으로 검증 모드인지 확인한다.
	 * 
	 * @param canonicalHostName
	 * @return 검증 모드 여부
	 * @throws Exception
	 */
	public boolean isStagingModeByCanonicalHostName(String canonicalHostName)
			throws Exception;

	/**
	 * 로컬 장비가 운영 모드인지 확인한다.
	 * 
	 * @return 운영 모드 여부
	 * @throws Exception
	 */
	public boolean isProductionMode() throws Exception;

	/**
	 * InetAddress로 운영 모드인지 확인한다.
	 * 
	 * @param inetAddress
	 * @return 운영 모드 여부
	 * @throws Exception
	 */
	public boolean isProductionMode(InetAddress inetAddress) throws Exception;

	/**
	 * Raw IP 주소로 운영 모드인지 확인한다.
	 * 
	 * @param rawIpAddress
	 * @return 운영 모드 여부
	 * @throws Exception
	 */
	public boolean isProductionModeByRawIpAddress(String rawIpAddress)
			throws Exception;

	/**
	 * Host명으로 운영 모드인지 확인한다.
	 * 
	 * @param hostName
	 * @return 운영 모드 여부
	 * @throws Exception
	 */
	public boolean isProductionModeByHostName(String hostName) throws Exception;

	/**
	 * Canonical host명으로 운영 모드인지 확인한다.
	 * 
	 * @param canonicalHostName
	 * @return 운영 모드 여부
	 * @throws Exception
	 */
	public boolean isProductionModeByCanonicalHostName(String canonicalHostName)
			throws Exception;

}
