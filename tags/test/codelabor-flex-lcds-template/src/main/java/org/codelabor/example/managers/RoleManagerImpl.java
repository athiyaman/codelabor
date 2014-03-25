package org.codelabor.example.managers;

import java.util.List;

import org.codelabor.example.daos.RoleDAO;
import org.codelabor.example.dtos.RoleDTO;
import org.codelabor.system.managers.BaseManagerImpl;

public class RoleManagerImpl extends BaseManagerImpl implements RoleManager {

	private RoleDAO roleDAO;

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public int deleteRole(String roleId) throws Exception {
		return roleDAO.deleteRole(roleId);
	}

	public int deleteRole() throws Exception {
		return roleDAO.deleteRole();
	}

	public int insertRole(RoleDTO roleDTO) throws Exception {
		return roleDAO.insertRole(roleDTO);
	}

	public List<RoleDTO> selectRole() throws Exception {
		return roleDAO.selectRole();
	}

	public RoleDTO selectRoleByRoleId(String roleId) throws Exception {
		return roleDAO.selectRoleByRoleId(roleId);
	}

	public int updateRole(RoleDTO roleDTO) throws Exception {
		return roleDAO.updateRole(roleDTO);
	}

	public List<RoleDTO> selectRoleByUserId(String userId) throws Exception {
		return roleDAO.selectRoleByUserId(userId);
	}

}
