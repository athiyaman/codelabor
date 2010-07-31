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
package org.codelabor.system.userdetails.dtos;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author "Shin Sangjae"
 * 
 */
public class GenericUserDTO extends User {

	/**
	 *
	 */
	private static final long serialVersionUID = -4975400692078046301L;
	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	/**
	 * @param username
	 * @param password
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param accountNonLocked
	 * @param authorities
	 */
	public GenericUserDTO(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, List<GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
	}

	public GenericUserDTO(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, List<GrantedAuthority> authorities,
			Map<String, Object> dataMap) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		this.dataMap = dataMap;
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

		retValue.append("GenericUserDTO ( ").append(super.toString()).append(
				TAB).append("dataMap = ").append(this.dataMap).append(TAB)
				.append(" )");

		return retValue.toString();
	}

}
