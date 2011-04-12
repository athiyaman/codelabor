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

package org.codelabor.system.web.dto;

import java.io.Serializable;

/**
 * 서버 DTO
 * 
 * @author Shin Sang-jae
 * 
 */
public class ServerDTO implements Serializable {
	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -7382446064301468345L;
	/**
	 * 서버명
	 */
	protected String name;
	/**
	 * 포트
	 */
	protected int port;

	/**
	 * 서버명을 가져온다.
	 * 
	 * @return 서버명
	 */
	public String getName() {
		return name;
	}

	/**
	 * 서버명을 설정한다.
	 * 
	 * @param name
	 *            서버명
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 포트를 가져온다.
	 * 
	 * @return 포트
	 */
	public int getPort() {
		return port;
	}

	/**
	 * 포트를 설정한다.
	 * 
	 * @param port
	 *            포트
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	@Override
	public String toString() {
		final String TAB = "    ";

		StringBuilder retValue = new StringBuilder();

		retValue.append("ServerDTO ( ").append(super.toString()).append(TAB)
				.append("name = ").append(this.name).append(TAB).append(
						"port = ").append(this.port).append(TAB).append(" )");

		return retValue.toString();
	}

}
