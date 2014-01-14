package org.codelabor.example.transaction.service;

import java.util.List;

import org.codelabor.example.transaction.dto.DeptDto;

public interface DeptService {

	public DeptDto selectDept(Integer deptNo);

	public List<DeptDto> selectDeptList();

}
