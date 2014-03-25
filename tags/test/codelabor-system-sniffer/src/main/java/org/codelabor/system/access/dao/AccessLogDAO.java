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

package org.codelabor.system.access.dao;

import org.codelabor.system.access.dto.AccessLogDTO;

/**
 * 접근 로그 DAO 인터페이스
 * 
 * @author Shin Sangjae
 * 
 */
public interface AccessLogDAO {
	/**
	 * 접속 로그 정보를 입력한다.
	 * 
	 * @param accessLogDTO
	 *            접속 로그 DTO
	 * @return 입력 건수
	 * @throws Exception
	 *             예외
	 */
	public int insert(AccessLogDTO accessLogDTO) throws Exception;
}
