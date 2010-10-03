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
 * 서버 별명 리졸버</br> 서버의 ip 주소나 host명을 입력 받아 해당 서버의 모드 정보를 가져온다. 서버 별명는
 * 개발(DEVELOPMENT), 검증(STAGING), 운영(PRODUCTION)의 세 가지 유형이 있다.
 * 
 * @author Shin Sangjae
 * 
 */
public interface ServerAliasResolver {
	/**
	 * 로컬 장비의 서버 별명를 가져온다.
	 * 
	 * @return 서버 별명
	 * @throws Exception
	 */
	public String getServerAlias() throws Exception;

	/**
	 * 서버 별명를 가져온다.
	 * 
	 * @param inetAddress
	 *            InetAddress 타입의 주소
	 * @return 서버 별명
	 * @throws Exception
	 */
	public String getServerAlias(InetAddress inetAddress) throws Exception;

	/**
	 * Raw IP 주소로 서버 별명를 가져온다.
	 * 
	 * @param rowIpAddress
	 *            Raw IP 주소
	 * @return 서버 별명
	 * @throws Exception
	 */
	public String getServerAliasByRawIpAddress(String rowIpAddress)
			throws Exception;

	/**
	 * Host명 서버 별명를 가져온다.
	 * 
	 * @param hostName
	 *            Host명
	 * @return 서버 별명
	 * @throws Exception
	 */
	public String getServerAliasByHostName(String hostName) throws Exception;

	/**
	 * 서버 별명를 가져온다.
	 * 
	 * @param canonicalHostName
	 *            Canonical host명
	 * @return 서버 별명
	 * @throws Exception
	 */
	public String getServerAliasByCanonicalHostName(String canonicalHostName)
			throws Exception;

}
