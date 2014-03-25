package org.codelabor.example.transaction.manager;

import java.util.List;

import org.codelabor.example.transaction.dto.EmpDto;
import org.codelabor.example.transaction.dto.EmpSearchConditionDto;

public interface EmpManager {

	public int deleteEmp(Integer empNo);

	public int insertEmp(EmpDto empDto);

	public EmpDto selectEmp(Integer empNo);

	public List<EmpDto> selectEmpList();

	public List<EmpDto> selectEmpListByDeptNo(Integer deptNo);

	public int updateEmp(EmpDto empDto);

	public int deleteEmpList(List<Integer> empNoList);

	public List<EmpDto> selectEmpListByCondition(
			EmpSearchConditionDto empSearchConditionDto);

	/**
	 * @param empSearchConditionDto
	 * @return
	 */
	public Integer getNumberOfRow(EmpSearchConditionDto empSearchConditionDto);

	/**
	 * @param empSearchConditionDto
	 * @return
	 */
	public List<EmpDto> selectEmpListByConditionWithPagination(
			EmpSearchConditionDto empSearchConditionDto);

}
