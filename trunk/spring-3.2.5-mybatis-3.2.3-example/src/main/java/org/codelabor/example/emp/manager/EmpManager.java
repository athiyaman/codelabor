package org.codelabor.example.emp.manager;

import java.util.List;

import org.codelabor.example.emp.dto.EmpDto;

public interface EmpManager {

	public int deleteEmp(Integer empNo);

	public int insertEmp(EmpDto empDto);

	public EmpDto selectEmp(Integer empNo);

	public List<EmpDto> selectEmpList();

	public List<EmpDto> selectEmpListByDeptNo(Integer deptNo);

	public int updateEmp(EmpDto empDto);

}
