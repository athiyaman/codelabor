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

package org.codelabor.system.web.servlets.dtos;

import java.io.Serializable;

/**
 * 리포트 DTO
 * 
 * @author Shin Sangjae
 * 
 */
public class RemoteDTO implements Serializable {
	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = 6420788348800357085L;
	/**
	 * 리모트 호스트
	 */
	protected String remoteHost;
	/**
	 * 리모트 주소
	 */
	protected String remoteAddress;
	/**
	 * 리모트 포트
	 */
	protected int remotePort;

	/**
	 * 리모트 호스트를 가져온다.
	 * 
	 * @return 리모트 호스트
	 */
	public String getRemoteHost() {
		return remoteHost;
	}

	/**
	 * 리모트 호스트를 설정한다.
	 * 
	 * @param remoteHost
	 *            리모트 호스트
	 */
	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	/**
	 * 리모트 주소를 가져온다.
	 * 
	 * @return 리모트 주소
	 */
	public String getRemoteAddress() {
		return remoteAddress;
	}

	/**
	 * 리모트 주소를 설정한다.
	 * 
	 * @param remoteAddress
	 *            리모트 주소
	 */
	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	/**
	 * 리모트 포트를 가져온다.
	 * 
	 * @return 리모트 포트
	 */
	public int getRemotePort() {
		return remotePort;
	}

	/**
	 * 리모트 포트를 설정한다.
	 * 
	 * @param remotePort
	 *            리포트 포트
	 */
	public void setRemotePort(int remotePort) {
		this.remotePort = remotePort;
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

		retValue.append("RemoteDTO ( ").append(super.toString()).append(TAB)
				.append("remoteAddress = ").append(this.remoteAddress).append(
						TAB).append("remoteHost = ").append(this.remoteHost)
				.append(TAB).append("remotePort = ").append(this.remotePort)
				.append(TAB).append(" )");

		return retValue.toString();
	}
}
