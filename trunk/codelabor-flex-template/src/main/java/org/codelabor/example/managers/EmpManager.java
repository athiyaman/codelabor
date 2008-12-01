package org.codelabor.example.managers;

import java.util.List;

import org.codelabor.example.dtos.EmpDTO;

public interface EmpManager {
	public List<EmpDTO> selectEmpList() throws Exception;

	public List<EmpDTO> selectEmpListByDeptNo(int deptNo) throws Exception;
}
