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

package org.codelabor.system.access.service;

import org.codelabor.system.access.dto.AccessLogDTO;
import org.codelabor.system.access.manager.AccessLogManager;
import org.codelabor.system.anyframe.exceptions.CommonException;
import org.codelabor.system.anyframe.exceptions.RollbackCommonException;
import org.codelabor.system.services.BaseServiceImpl;

/**
 * 접근 로그 서비스 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class AccessLogServiceImpl extends BaseServiceImpl implements
		AccessLogService {

	/**
	 * 접근 로그 매니저
	 */
	private AccessLogManager accessLogManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.access.service.AccessLogService#accessLog(org.codelabor
	 * .system.access.dtos.AccessLogDTO)
	 */
	public void accessLog(AccessLogDTO accessLogDTO) throws Exception {
		try {
			accessLogManager.accessLog(accessLogDTO);
		} catch (Exception e) {
			String messageCode = "ERROR-ACCESS-LOG-0000";
			String messageKey = "error.access.log";
			Object[] messageParams = new Object[] {};
			CommonException commonException = new RollbackCommonException(
					messageSource, messageKey, messageParams, e);
			commonException.setMessageCode(messageCode);
			throw commonException;
		}
	}

	/**
	 * 접근 로그 매니저를 가져온다.
	 * 
	 * @return 접근 로그 매니저
	 */
	public AccessLogManager getAccessLogManager() {
		return accessLogManager;
	}

	/**
	 * 접근 로그 매니저를 설정한다.
	 * 
	 * @param accessLogManager
	 *            접근 로그 매니저
	 */
	public void setAccessLogManager(AccessLogManager accessLogManager) {
		this.accessLogManager = accessLogManager;
	}

}
