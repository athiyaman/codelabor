package org.codelabor.example.managers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codelabor.example.daos.EmpDAO;
import org.codelabor.example.dtos.EmpDTO;
import org.codelabor.system.managers.BaseManagerImpl;

public class EmpManagerImpl extends BaseManagerImpl implements EmpManager {

	private EmpDAO empDAO;

	public EmpManagerImpl() {
	}

	public void setEmpDAO(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}

	public List<EmpDTO> selectEmpListByDeptNo(int deptNo) throws Exception {
		Map<String, String> searchCondition = new HashMap<String, String>();
		searchCondition.put("deptNo", String.valueOf(deptNo));
		return empDAO.selectEmp(searchCondition);
	}

	public List<EmpDTO> selectEmpList() throws Exception {
		return empDAO.selectEmp();
	}
}
