/*
 * Licensed to the Apache Software Fimport java.util.Collection;
import java.util.List;

import org.codelabor.system.dtos.LoginDTO;
ed with
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

package org.codelabor.system.daos;

import java.util.Collection;
import java.util.List;

import org.codelabor.system.dtos.LoginDTO;

/**
 * @author SangJae Shin
 * 
 */
public class LoginDAOImpl extends BaseDAOImpl implements LoginDAO {

	public int insertLogin(LoginDTO loginDTO) throws Exception {
		String queryId = "system.insert.login";
		Object[] param = new Object[] { loginDTO.getSessionId(),
				loginDTO.getUserId(), loginDTO.getIpAddress() };
		return this.queryService.create(queryId, param);
	}

	@SuppressWarnings("unchecked")
	public LoginDTO selectLogin(LoginDTO loginDTO) throws Exception {
		String queryId = "system.select.login";
		Object[] param = new Object[] { loginDTO.getSessionId() };
		Collection<LoginDTO> loginCol = queryService.find(queryId, param);
		if (loginCol == null || loginCol.size() == 0)
			return null;
		return (LoginDTO) loginCol.toArray()[0];
	}

	@SuppressWarnings("unchecked")
	public LoginDTO selectLoginByLastLogoutUserId(LoginDTO loginDTO)
			throws Exception {
		String queryId = "system.select.login.by.last.logout.user.id";
		Object[] param = new Object[] { loginDTO.getUserId() };
		Collection<LoginDTO> loginCol = queryService.find(queryId, param);
		if (loginCol == null || loginCol.size() == 0)
			return null;
		return (LoginDTO) loginCol.toArray()[0];
	}

	@SuppressWarnings("unchecked")
	public List<LoginDTO> selectLogin() throws Exception {
		String queryId = "system.select.login.list";
		Object[] params = new Object[] {};
		return (List<LoginDTO>) queryService.find(queryId, params);
	}

	public int updateLogin(LoginDTO loginDTO) throws Exception {
		String queryId = "system.update.login";
		Object[] param = new Object[] { loginDTO.getSessionId() };
		return this.queryService.create(queryId, param);
	}

}
