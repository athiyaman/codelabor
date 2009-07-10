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

import org.codelabor.system.userdetails.services.PKIAuthenticatedUserDetailsServiceImpl;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author bomber
 * 
 */
public class PKIAuthenticationProvider implements AuthenticationProvider {

	private PKIAuthenticatedUserDetailsServiceImpl userDetailsService = null;

	public void setUserDetailsService(PKIAuthenticatedUserDetailsServiceImpl userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.springframework.security.authentication.AuthenticationProvider#
	 * authenticate(org.springframework.security.core.Authentication)
	 */
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		if (!supports(authentication.getClass())) {
			return null;
		}

		PKIAuthenticationToken authenticationToken = (PKIAuthenticationToken) authentication;
		String subject = authenticationToken.getSubject();

		UserDetails userDetails = userDetailsService
				.loadUserDetails(authenticationToken);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.authentication.AuthenticationProvider#supports
	 * (java.lang.Class)
	 */
	public boolean supports(Class<? extends Object> authentication) {
		return (PKIAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
