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

package org.codelabor.example.user.managers;

import java.util.List;

import org.codelabor.example.user.daos.RoleDAO;
import org.codelabor.example.user.dtos.RoleDTO;
import org.codelabor.system.managers.BaseManagerImpl;

/**
 * 역할 매너저 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class RoleManagerImpl extends BaseManagerImpl implements RoleManager {

	/**
	 * 역할 DAO
	 */
	private RoleDAO roleDAO;

	/**
	 * 역할 DAO를 가져온다.
	 * 
	 * @return 역할 DAO
	 */
	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	/**
	 * 역할 DAO를 설정한다.
	 * 
	 * @param 역할
	 *            DAO
	 */
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.managers.RoleManager#deleteRole(java.lang.
	 * String)
	 */
	public int deleteRole(String roleId) throws Exception {
		return roleDAO.deleteRole(roleId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.user.managers.RoleManager#deleteRole()
	 */
	public int deleteRole() throws Exception {
		return roleDAO.deleteRole();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.managers.RoleManager#insertRole(org.codelabor
	 * .example.user.dtos.RoleDTO)
	 */
	public int insertRole(RoleDTO roleDTO) throws Exception {
		return roleDAO.insertRole(roleDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.user.managers.RoleManager#selectRole()
	 */
	public List<RoleDTO> selectRole() throws Exception {
		return roleDAO.selectRole();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.managers.RoleManager#selectRoleByRoleId(java
	 * .lang.String)
	 */
	public RoleDTO selectRoleByRoleId(String roleId) throws Exception {
		return roleDAO.selectRoleByRoleId(roleId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.managers.RoleManager#updateRole(org.codelabor
	 * .example.user.dtos.RoleDTO)
	 */
	public int updateRole(RoleDTO roleDTO) throws Exception {
		return roleDAO.updateRole(roleDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.user.managers.RoleManager#selectRoleByUserId(java
	 * .lang.String)
	 */
	public List<RoleDTO> selectRoleByUserId(String userId) throws Exception {
		return roleDAO.selectRoleByUserId(userId);
	}

}
