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

package org.codelabor.system.servlets.dtos;

import java.io.Serializable;

/**
 * @author Sang Jae Shin
 * 
 */
public class LocalDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6420788348800357085L;
	String localName;
	String localAddress;
	int localPort;

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	public int getLocalPort() {
		return localPort;
	}

	public void setLocalPort(int localPort) {
		this.localPort = localPort;
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

		retValue.append("LocalDTO ( ").append(super.toString()).append(TAB)
				.append("localAddress = ").append(this.localAddress)
				.append(TAB).append("localName = ").append(this.localName)
				.append(TAB).append("localPort = ").append(this.localPort)
				.append(TAB).append(" )");

		return retValue.toString();
	}
}
