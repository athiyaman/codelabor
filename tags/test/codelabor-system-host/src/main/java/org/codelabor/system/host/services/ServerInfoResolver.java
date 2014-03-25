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

import java.util.Locale;

/**
 * 서버 별명 리졸버</br> 서버의 ip 주소나 host명을 입력 받아 해당 서버의 정보를 가져온다. 서버 정보을 가져오는 방법은 구현
 * 클래스에 따라 달라질 수 있다.
 * 
 * @author Shin Sangjae
 * 
 */
public interface ServerInfoResolver {
	/**
	 * 로컬 장비의 서버 별명을 가져온다.
	 * 
	 * @return 서버 별명
	 * @throws Exception
	 *             예외
	 */
	public String getServerAlias() throws Exception;

	/**
	 * 로컬 장비의 서버 별명을 가져온다.
	 * 
	 * @param locale
	 *            로케일
	 * @return 서버 별명
	 * @throws Exception
	 *             예외
	 */
	public String getServerAlias(Locale locale) throws Exception;

	/**
	 * 로컬 장비의 서버 모드를 가져온다.
	 * 
	 * @return 서버 모드
	 * @throws Exception
	 *             예외
	 */
	public String getServerMode() throws Exception;

	/**
	 * 로컬 장비의 서버 모드를 가져온다.
	 * 
	 * @param locale
	 *            로케일
	 * @return 서버 모드
	 * @throws Exception
	 *             예외
	 */
	public String getServerMode(Locale locale) throws Exception;

	/**
	 * 로컬 장비의 윈도우 이름을 가져온다.
	 * 
	 * @return 윈도우 이름
	 * @throws Exception
	 *             예외
	 */
	public String getServerWindowName() throws Exception;

	/**
	 * 로컬 장비의 윈도우 이름을 가져온다.
	 * 
	 * @param locale
	 *            로케일
	 * @return 윈도우 이름
	 * @throws Exception
	 *             예외
	 */
	public String getServerWindowName(Locale locale) throws Exception;

	/**
	 * 로컬 장비의 문서 타이틀을 가져온다.
	 * 
	 * @return 문서 타이틀
	 * @throws Exception
	 *             예외
	 */
	public String getServerDocumentTitle() throws Exception;

	/**
	 * 로컬 장비의 문서 타이틀을 가져온다.
	 * 
	 * @param locale
	 *            로케일
	 * @return 문서 타이틀
	 * @throws Exception
	 *             예외
	 */
	public String getServerDocumentTitle(Locale locale) throws Exception;
}
