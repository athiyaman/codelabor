package org.codelabor.example.emp.service;

import java.util.List;

import org.codelabor.example.emp.dto.EmpDto;

public interface EmpService {

	public int deleteEmp(Integer empNo);

	public int insertEmp(EmpDto empDto);

	public EmpDto selectEmp(Integer empNo);

	public List<EmpDto> selectEmpList();

	public List<EmpDto> selectEmpListByDeptNo(Integer deptNo);

	public int updateEmp(EmpDto empDto);

}
