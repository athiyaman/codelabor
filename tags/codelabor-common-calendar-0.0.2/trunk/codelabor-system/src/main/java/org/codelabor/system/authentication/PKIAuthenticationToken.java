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
 * @author bomber
 * 
 */
public class PKIAuthenticationToken extends UsernamePasswordAuthenticationToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2235537598295015441L;
	private String subject;

	/**
	 * @param principal
	 * @param credentials
	 */
	public PKIAuthenticationToken(Object principal, Object credentials) {
		super(principal, credentials);
	}

	public PKIAuthenticationToken(String subject) {
		super(null, null);
		this.subject = subject;
	}

	/**
	 * @param principal
	 * @param credentials
	 * @param authorities
	 */
	public PKIAuthenticationToken(Object principal, Object credentials,
			List<GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
	}

	/**
	 * @param username
	 * @param password
	 * @param authorities
	 * @param subject
	 */
	public PKIAuthenticationToken(String username, String password,
			List<GrantedAuthority> authorities, String subject) {
		this(username, password, authorities);
		this.subject = subject;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append("; ");
		sb.append("Subject: ").append(this.subject).append(": ");
		return sb.toString();
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

}
