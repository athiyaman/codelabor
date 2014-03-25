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

package org.codelabor.system.access.manager;

import org.codelabor.system.access.dao.AccessLogDao;
import org.codelabor.system.access.dto.AccessLogDto;
import org.codelabor.system.managers.BaseManagerImpl;

/**
 * 접근 로그 매니저 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class AccessLogManagerImpl extends BaseManagerImpl implements
		AccessLogManager {

	/**
	 * 접근 로그 DAO
	 */
	private AccessLogDao accessLogDao;

	/**
	 * 접근 로그 DAO를 설정한다.
	 * 
	 * @param accessLogDao
	 *            접근 로그 DAO
	 */
	public void setAccessLogAO(AccessLogDao accessLogDao) {
		this.accessLogDao = accessLogDao;
	}

	/**
	 * 접근 로그 DAO를 설정한다.
	 * 
	 * @param accessLogDao
	 *            접근 로그 DA0
	 */
	public void setAccessLogDAO(AccessLogDao accessLogDao) {
		this.accessLogDao = accessLogDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.access.manager.AccessLogManager#accessLog(org.codelabor
	 * .system.access.dtos.AccessLogDTO)
	 */
	public void accessLog(AccessLogDto accessLogDto) throws Exception {
		this.accessLogDao.insert(accessLogDto);
	}
}
