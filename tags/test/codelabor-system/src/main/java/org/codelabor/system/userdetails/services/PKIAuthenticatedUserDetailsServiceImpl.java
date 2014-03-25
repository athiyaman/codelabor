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
package org.codelabor.system.userdetails.services;

import org.codelabor.system.authentication.PKIAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;

/**
 * @author bomber
 * 
 */
public class PKIAuthenticatedUserDetailsServiceImpl extends
		PKIUserDetailsServiceImpl implements AuthenticationUserDetailsService {

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.springframework.security.core.userdetails.
	 * AuthenticationUserDetailsService
	 * #loadUserDetails(org.springframework.security.core.Authentication)
	 */
	public UserDetails loadUserDetails(Authentication authentication)
			throws UsernameNotFoundException {
		Assert.isInstanceOf(PKIAuthenticationToken.class, authentication,
				PKIAuthenticationToken.class + " required");
		String subject = ((PKIAuthenticationToken) authentication).getSubject();
		return super.loadUserByUsername(subject);
	}
}
