package org.codelabor.example.transaction.manager;

import java.util.List;

import org.codelabor.example.transaction.dto.DeptDto;

public interface DeptManager {

	public DeptDto selectDept(Integer deptNo);

	public List<DeptDto> selectDeptList();

}
