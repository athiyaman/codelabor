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

import java.util.List;

import org.codelabor.example.user.dtos.RoleDTO;

/**
 * @author Sang Jae Shin
 * 
 */
public interface RoleDAO {
	public int insertRole(RoleDTO roleDTO) throws Exception;

	public int updateRole(RoleDTO roleDTO) throws Exception;

	public int deleteRole(String roleId) throws Exception;

	public int deleteRole() throws Exception;

	public RoleDTO selectRoleByRoleId(String roleId) throws Exception;

	public List<RoleDTO> selectRole() throws Exception;

	public List<RoleDTO> selectRoleByUserId(String userId) throws Exception;
}
