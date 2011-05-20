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

package org.codelabor.system.service;

import org.codelabor.system.dto.SystemPropertiesDTO;



/**
 * 시스템 프로퍼티 서비스 인터페이스
 *
 * @author Shin Sang-jae
 *
 */
public interface SystemPropertiesService {
	/**
	 * 시스템 프로퍼티 DTO를 가져온다.
	 *
	 * @return 시스템 프로퍼티 DTO
	 */
	public SystemPropertiesDTO getSystemPropertiesDTO();

	/**
	 * 프로퍼티를 가져온다.
	 *
	 * @param key
	 *            프로퍼티 키
	 * @return 프로퍼티 값
	 */
	public String getProperty(String key);
}
