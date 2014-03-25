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

package org.codelabor.example.user.daos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codelabor.system.daos.BaseDAOImpl;

/**
 * 사용자 역할 매핑 DAO 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class UserRoleMapDAOImpl extends BaseDAOImpl implements UserRoleMapDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.user.daos.UserRoleMapDAO#map(java.lang.String,
	 * java.lang.String)
	 */
	public int map(String userId, String roleId) throws Exception {
		String query = "example.insert.user.role.map";
		Object[] param = new Object[] { userId, roleId };
		return this.queryService.create(query, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.daos.UserRoleMapDAO#selectRoleIdList(java.
	 * lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<String> selectRoleIdList(String userId) throws Exception {
		String query = "example.select.user.role.map.list.by.user.id";
		Object[] param = new Object[] { userId };
		Collection roleIdCol = this.queryService.find(query, param);
		if (roleIdCol == null || roleIdCol.size() == 0)
			return null;
		Iterator roleIdIter = roleIdCol.iterator();
		ArrayList roleIdList = new ArrayList();
		while (roleIdIter.hasNext()) {
			roleIdList.add(((Map) roleIdIter.next()).get("roleId"));
		}
		return roleIdList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.daos.UserRoleMapDAO#selectUserIdList(java.
	 * lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<String> selectUserIdList(String roleId) throws Exception {
		String query = "example.select.user.role.map.list.by.role.id";
		Object[] param = new Object[] { roleId };
		Collection userIdCol = this.queryService.find(query, param);
		if (userIdCol == null || userIdCol.size() == 0)
			return null;
		Iterator userIdIter = userIdCol.iterator();
		ArrayList userIdList = new ArrayList();
		while (userIdIter.hasNext()) {
			userIdList.add(((Map) userIdIter.next()).get("userId"));
		}
		return userIdList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.daos.UserRoleMapDAO#unmap(java.lang.String,
	 * java.lang.String)
	 */
	public int unmap(String userId, String roleId) throws Exception {
		String query = "example.delete.user.role.map";
		Object[] param = new Object[] { userId, roleId };
		return this.queryService.remove(query, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.user.daos.UserRoleMapDAO#reset()
	 */
	public int reset() throws Exception {
		String query = "example.delete.user.role.map.list";
		Object[] param = new Object[] {};
		return this.queryService.remove(query, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.daos.UserRoleMapDAO#reset(java.lang.String)
	 */
	public int reset(String userId) throws Exception {
		String query = "example.delete.user.role.map.list.by.user.id";
		Object[] param = new Object[] { userId };
		return this.queryService.remove(query, param);
	}

}
