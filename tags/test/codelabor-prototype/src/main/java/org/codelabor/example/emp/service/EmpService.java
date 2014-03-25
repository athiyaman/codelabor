package org.codelabor.example.emp.service;

import java.util.List;

import org.codelabor.example.emp.dto.EmpDto;
import org.codelabor.example.emp.dto.EmpSearchConditionDto;

public interface EmpService {

	int deleteEmp(Integer empNo);

	int deleteEmpList(List<Integer> empNoList);

	/**
	 * @param empSearchConditionDto
	 * @return
	 */
	Integer getNumberOfRow(EmpSearchConditionDto empSearchConditionDto);

	int insertEmp(EmpDto empDto);

	int insertEmpList(List<EmpDto> empDtoList);

	EmpDto selectEmp(Integer empNo);

	List<EmpDto> selectEmpList();

	List<EmpDto> selectEmpListByCondition(
			EmpSearchConditionDto empSearchConditionDto);

	/**
	 * @param empSearchConditionDto
	 * @return
	 */
	List<EmpDto> selectEmpListByConditionWithPagination(
			EmpSearchConditionDto empSearchConditionDto);

	List<EmpDto> selectEmpListByDeptNo(Integer deptNo);

	int updateEmp(EmpDto empDto);

}
