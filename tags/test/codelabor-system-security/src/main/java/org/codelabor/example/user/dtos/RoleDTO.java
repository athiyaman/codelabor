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

package org.codelabor.example.user.dtos;

/**
 * 역할 DTO
 * 
 * @author Shin Sangjae
 * 
 */
public class RoleDTO {

	/**
	 * 역할 Id
	 */
	protected String roleId = null;
	/**
	 * 상세 설명
	 */
	protected String description = null;

	/**
	 * 역할 Id를 가져온다.
	 * 
	 * @return 역할 Id
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * 역할 Id를 설정한다.
	 * 
	 * @param roleId
	 *            역할 Id
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * 상세 설명을 가져온다.
	 * 
	 * @return 상세 설명
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 상세 설명을 설정한다.
	 * 
	 * @param description
	 *            상세 설명
	 */
	public void setDescription(String description) {
		this.description = description;
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

		retValue.append("RoleDTO ( ").append(super.toString()).append(TAB)
				.append("description = ").append(this.description).append(TAB)
				.append("roleId = ").append(this.roleId).append(TAB).append(
						" )");

		return retValue.toString();
	}
}
