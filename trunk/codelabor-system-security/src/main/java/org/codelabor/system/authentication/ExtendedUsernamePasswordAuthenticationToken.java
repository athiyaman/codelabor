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
package org.codelabor.system.authentication;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author "Sang Jae Shin"
 * 
 */
public class ExtendedUsernamePasswordAuthenticationToken extends
		UsernamePasswordAuthenticationToken {

	/**
	 *
	 */
	private static final long serialVersionUID = 3595488289686731710L;

	public Object getExtendedData() {
		return extendedData;
	}

	private Object extendedData;

	/**
	 * @param principal
	 * @param credentials
	 */
	public ExtendedUsernamePasswordAuthenticationToken(Object principal,
			Object credentials) {
		super(principal, credentials);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param principal
	 * @param credentials
	 * @param authorities
	 */
	public ExtendedUsernamePasswordAuthenticationToken(Object principal,
			Object credentials, List<GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
		// TODO Auto-generated constructor stub
	}

	public ExtendedUsernamePasswordAuthenticationToken(Object principal,
			Object credentials, Object extendedData) {
		super(principal, credentials);
		this.extendedData = extendedData;
	}

	public ExtendedUsernamePasswordAuthenticationToken(Object principal,
			Object credentials, List<GrantedAuthority> authorities,
			Object extendedData) {
		super(principal, credentials, authorities);
		this.extendedData = extendedData;
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

		retValue.append("ExtendedUsernamePasswordAuthenticationToken ( ")
				.append(super.toString()).append(TAB).append("extendedData = ")
				.append(this.extendedData).append(TAB).append(" )");

		return retValue.toString();
	}

}
