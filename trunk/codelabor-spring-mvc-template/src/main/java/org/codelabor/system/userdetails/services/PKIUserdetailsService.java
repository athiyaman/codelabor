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

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import anyframe.core.query.IQueryService;
import anyframe.core.query.QueryServiceException;

/**
 * @author bomber
 * 
 */
public class PKIUserdetailsService implements AuthenticationUserDetailsService {

	private IQueryService queryService = null;

	public void setQueryService(IQueryService queryService) {
		this.queryService = queryService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.springframework.security.core.userdetails.
	 * AuthenticationUserDetailsService
	 * #loadUserDetails(org.springframework.security.core.Authentication)
	 */
	@SuppressWarnings("unchecked")
	public UserDetails loadUserDetails(Authentication token)
			throws UsernameNotFoundException {
		String queryId = "system.userdetails.select.user.by.distinguishedName";
		UserDetails userDetails = null;
		try {
			Collection mapList = queryService.find(queryId,
					new Object[] { token.getName() });
			if (mapList.size() == 0) {
				throw new UsernameNotFoundException(queryId);
			}
			Map map = (Map) mapList.toArray()[0];
			String username = (String) map.get("username");
			String password = (String) map.get("password");
			boolean enabled = ((String) map.get("enabled")).equals("1") ? true
					: false;

			userDetails = new User(username, password, enabled, true, true,
					true, AuthorityUtils.NO_AUTHORITIES);
		} catch (QueryServiceException e) {
			e.printStackTrace();
			throw new UnkownQueryServiceException(e.getMessage());
		}
		return userDetails;
	}
}
