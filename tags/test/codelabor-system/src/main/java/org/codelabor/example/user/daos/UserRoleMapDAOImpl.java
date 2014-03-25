package org.codelabor.example.user.daos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codelabor.system.daos.BaseDAOImpl;

public class UserRoleMapDAOImpl extends BaseDAOImpl implements UserRoleMapDAO {

	public int map(String userId, String roleId) throws Exception {
		String query = "example.insert.user.role.map";
		Object[] param = new Object[] { userId, roleId };
		return this.queryService.create(query, param);
	}

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

	public int unmap(String userId, String roleId) throws Exception {
		String query = "example.delete.user.role.map";
		Object[] param = new Object[] { userId, roleId };
		return this.queryService.remove(query, param);
	}

	public int reset() throws Exception {
		String query = "example.delete.user.role.map.list";
		Object[] param = new Object[] {};
		return this.queryService.remove(query, param);
	}

	public int reset(String userId) throws Exception {
		String query = "example.delete.user.role.map.list.by.user.id";
		Object[] param = new Object[] {userId};
		return this.queryService.remove(query, param);
	}

}
