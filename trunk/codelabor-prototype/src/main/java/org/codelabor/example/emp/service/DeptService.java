package org.codelabor.example.emp.service;

import java.util.List;

import org.codelabor.example.emp.dto.DeptDto;

public interface DeptService {

	DeptDto selectDept(Integer deptNo);

	List<DeptDto> selectDeptList();

}
