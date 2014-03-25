package org.codelabor.example.emp.manager;

import java.util.List;

import org.codelabor.example.emp.dto.DeptDto;

public interface DeptManager {

	DeptDto selectDept(Integer deptNo);

	List<DeptDto> selectDeptList();

}
