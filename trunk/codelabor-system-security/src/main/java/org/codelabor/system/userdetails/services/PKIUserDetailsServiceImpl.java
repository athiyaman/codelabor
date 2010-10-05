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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;

import anyframe.core.query.IQueryService;
import anyframe.core.query.QueryServiceException;

/**
 * @author bomber
 * 
 */
public class PKIUserDetailsServiceImpl implements UserDetailsService {

	private IQueryService queryService = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public UserDetails loadUserByUsername(String subject)
			throws UsernameNotFoundException, DataAccessException {
		String queryId = null;
		UserDetails userDetails = null;
		try {
			// get username, password
			queryId = "system.userdetails.select.user.by.distinguishedName";
			Collection userMapCollection = queryService.find(queryId,
					new Object[] { subject });
			if (userMapCollection.size() == 0) {
				throw new UsernameNotFoundException(queryId);
			}
			Map userMap = (Map) userMapCollection.toArray()[0];
			String username = (String) userMap.get("username");
			String password = (String) userMap.get("password");
			boolean enabled = ((BigDecimal) userMap.get("enabled")).intValue() == 1 ? true
					: false;

			// get authorities
			queryId = "system.userdetails.select.authorities.by.username";
			Collection authorityCollection = queryService.find(queryId,
					new Object[] { username });
			Iterator authorityIterator = authorityCollection.iterator();
			List authorityList = new ArrayList();
			while (authorityIterator.hasNext()) {
				Map authorityMap = (Map) authorityIterator.next();
				GrantedAuthority authority = new GrantedAuthorityImpl(
						(String) authorityMap.get("authority"));
				authorityList.add(authority);
			}

			// create user details
			// userDetails = new User(username, password, enabled, true, true,
			// true, authorityList);
		} catch (QueryServiceException e) {
			e.printStackTrace();
			throw new UnkownQueryServiceException(e.getMessage());
		}
		return userDetails;
	}

	public void setQueryService(IQueryService queryService) {
		this.queryService = queryService;
	}

}
