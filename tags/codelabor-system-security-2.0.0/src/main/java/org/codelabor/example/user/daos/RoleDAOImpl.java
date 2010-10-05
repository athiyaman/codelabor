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

import java.util.Collection;
import java.util.List;

import org.codelabor.example.user.dtos.RoleDTO;
import org.codelabor.system.daos.BaseDAOImpl;

/**
 * 역할 DTO 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class RoleDAOImpl extends BaseDAOImpl implements RoleDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.daos.RoleDAO#insertRole(org.codelabor.example
	 * .user.dtos.RoleDTO)
	 */
	public int insertRole(RoleDTO roleDTO) throws Exception {
		return this.queryService.create(roleDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.user.daos.RoleDAO#selectRole()
	 */
	@SuppressWarnings("unchecked")
	public List<RoleDTO> selectRole() throws Exception {
		String query = "example.select.role.list";
		Object[] param = new Object[] {};
		return (List<RoleDTO>) this.queryService.find(query, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.daos.RoleDAO#selectRoleByRoleId(java.lang.
	 * String)
	 */
	@SuppressWarnings("unchecked")
	public RoleDTO selectRoleByRoleId(String roleId) throws Exception {
		String query = "example.select.role";
		Object[] param = new Object[] { roleId };
		Collection roleCol = this.queryService.find(query, param);
		if (roleCol == null || roleCol.size() == 0)
			return null;
		return (RoleDTO) roleCol.toArray()[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.user.daos.RoleDAO#deleteRole(java.lang.String)
	 */
	public int deleteRole(String roleId) throws Exception {
		String query = "example.delete.role";
		Object[] param = new Object[] {};
		return this.queryService.remove(query, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.user.daos.RoleDAO#deleteRole()
	 */
	public int deleteRole() throws Exception {
		String query = "example.delete.role.list";
		Object[] param = new Object[] {};
		return this.queryService.remove(query, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.daos.RoleDAO#updateRole(org.codelabor.example
	 * .user.dtos.RoleDTO)
	 */
	public int updateRole(RoleDTO roleDTO) throws Exception {
		return this.queryService.update(roleDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.daos.RoleDAO#selectRoleByUserId(java.lang.
	 * String)
	 */
	@SuppressWarnings("unchecked")
	public List<RoleDTO> selectRoleByUserId(String userId) throws Exception {
		String query = "example.select.role.by.user.id";
		Object[] param = new Object[] { userId };
		return (List<RoleDTO>) this.queryService.find(query, param);
	}

}
