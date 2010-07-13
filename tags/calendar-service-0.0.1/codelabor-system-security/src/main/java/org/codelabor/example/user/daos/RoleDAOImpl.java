package org.codelabor.example.user.daos;

import java.util.Collection;
import java.util.List;

import org.codelabor.example.user.dtos.RoleDTO;
import org.codelabor.system.daos.BaseDAOImpl;

public class RoleDAOImpl extends BaseDAOImpl implements RoleDAO {

	public int insertRole(RoleDTO roleDTO) throws Exception {
		return this.queryService.create(roleDTO);
	}

	@SuppressWarnings("unchecked")
	public List<RoleDTO> selectRole() throws Exception {
		String query = "example.select.role.list";
		Object[] param = new Object[] {};
		return (List<RoleDTO>) this.queryService.find(query, param);
	}

	@SuppressWarnings("unchecked")
	public RoleDTO selectRoleByRoleId(String roleId) throws Exception {
		String query = "example.select.role";
		Object[] param = new Object[] { roleId };
		Collection roleCol = this.queryService.find(query, param);
		if (roleCol == null || roleCol.size() == 0)
			return null;
		return (RoleDTO) roleCol.toArray()[0];
	}

	public int deleteRole(String roleId) throws Exception {
		String query = "example.delete.role";
		Object[] param = new Object[] {};
		return this.queryService.remove(query, param);
	}

	public int deleteRole() throws Exception {
		String query = "example.delete.role.list";
		Object[] param = new Object[] {};
		return this.queryService.remove(query, param);
	}

	public int updateRole(RoleDTO roleDTO) throws Exception {
		return this.queryService.update(roleDTO);
	}

	@SuppressWarnings("unchecked")
	public List<RoleDTO> selectRoleByUserId(String userId) throws Exception {
		String query = "example.select.role.by.user.id";
		Object[] param = new Object[] { userId };
		return (List<RoleDTO>) this.queryService.find(query, param);
	}

}
