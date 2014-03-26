/*
 * Licensed to the Apache Software Fimport java.util.Collection;
import java.util.List;

import org.codelabor.system.dto.LoginDTO;
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

package org.codelabor.system.login.dao;

import java.util.Collection;
import java.util.List;

import org.codelabor.system.dao.BaseDAOImpl;
import org.codelabor.system.login.dto.LoginDto;

/**
 * 로그인 DAO 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class LoginDaoImpl extends BaseDAOImpl implements LoginDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.login.dao.LoginDao#insertLogin(org.codelabor.system
	 * .login.dto.LoginDTO)
	 */
	public int insertLogin(LoginDto loginDto) throws Exception {
		String queryId = "system.insert.login";
		Object[] param = new Object[] { loginDto.getSessionId(),
				loginDto.getUserId(), loginDto.getIpAddress() };
		return this.queryService.create(queryId, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.login.dao.LoginDao#selectLogin(org.codelabor.system
	 * .login.dto.LoginDTO)
	 */
	@SuppressWarnings("unchecked")
	public LoginDto selectLogin(LoginDto loginDto) throws Exception {
		String queryId = "system.select.login";
		Object[] param = new Object[] { loginDto.getSessionId() };
		Collection<LoginDto> loginCol = queryService.find(queryId, param);
		if (loginCol == null || loginCol.size() == 0)
			return null;
		return (LoginDto) loginCol.toArray()[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.login.dao.LoginDao#selectLoginByLastLogoutUserId
	 * (org.codelabor.system.login.dto.LoginDto)
	 */
	@SuppressWarnings("unchecked")
	public LoginDto selectLoginByLastLogoutUserId(LoginDto loginDto)
			throws Exception {
		String queryId = "system.select.login.by.last.logout.user.id";
		Object[] param = new Object[] { loginDto.getUserId() };
		Collection<LoginDto> loginCol = queryService.find(queryId, param);
		if (loginCol == null || loginCol.size() == 0)
			return null;
		return (LoginDto) loginCol.toArray()[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.system.login.dao.LoginDao#selectLogin()
	 */
	@SuppressWarnings("unchecked")
	public List<LoginDto> selectLogin() throws Exception {
		String queryId = "system.select.login.list";
		Object[] params = new Object[] {};
		return (List<LoginDto>) queryService.find(queryId, params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.login.dao.LoginDao#updateLogin(org.codelabor.system
	 * .login.dto.LoginDTO)
	 */
	public int updateLogin(LoginDto loginDto) throws Exception {
		String queryId = "system.update.login";
		Object[] param = new Object[] { loginDto.getSessionId() };
		return this.queryService.create(queryId, param);
	}

}
