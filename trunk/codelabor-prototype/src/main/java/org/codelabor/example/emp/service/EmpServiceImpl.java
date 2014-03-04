package org.codelabor.example.emp.service;

import java.util.List;

import org.codelabor.example.emp.dto.EmpDto;
import org.codelabor.example.emp.dto.EmpSearchConditionDto;
import org.codelabor.example.emp.manager.EmpManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

	private final static Logger logger = LoggerFactory
			.getLogger(EmpServiceImpl.class);

	@Autowired
	private EmpManager empManager;

	@Override
	public int deleteEmp(Integer empNo) {
		logger.debug("deleteEmp");
		return empManager.deleteEmp(empNo);
	}

	@Override
	public int deleteEmpList(List<Integer> empNoList) {
		logger.debug("deleteEmpList");
		return empManager.deleteEmpList(empNoList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.emp.service.EmpService#getNumberOfRow(org.codelabor
	 * .example.emp.dto.EmpSearchConditionDto)
	 */
	@Override
	public Integer getNumberOfRow(EmpSearchConditionDto empSearchConditionDto) {
		logger.debug("getNumberOfRow");
		return empManager.getNumberOfRow(empSearchConditionDto);
	}

	@Override
	public int insertEmp(EmpDto empDto) {
		logger.debug("insertEmp");
		return empManager.insertEmp(empDto);
	}

	@Override
	public int insertEmpList(List<EmpDto> empDtoList) {
		logger.debug("insertEmpList");
		return empManager.insertEmpList(empDtoList);
	}

	@Override
	public EmpDto selectEmp(Integer empNo) {
		logger.debug("selectEmp");
		return empManager.selectEmp(empNo);
	}

	@Override
	public List<EmpDto> selectEmpList() {
		logger.debug("selectEmpList");
		return empManager.selectEmpList();
	}

	@Override
	public List<EmpDto> selectEmpListByCondition(
			EmpSearchConditionDto empSearchConditionDto) {
		logger.debug("selectEmpList");
		return empManager.selectEmpListByCondition(empSearchConditionDto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.emp.service.EmpService#
	 * selectEmpListByConditionWithPagination
	 * (org.codelabor.example.emp.dto.EmpSearchConditionDto)
	 */
	@Override
	public List<EmpDto> selectEmpListByConditionWithPagination(
			EmpSearchConditionDto empSearchConditionDto) {
		logger.debug("selectEmpListByConditionWithPagination");
		return empManager
				.selectEmpListByConditionWithPagination(empSearchConditionDto);
	}

	@Override
	public List<EmpDto> selectEmpListByDeptNo(Integer deptNo) {
		logger.debug("selectEmpListByDeptNo");
		return empManager.selectEmpListByDeptNo(deptNo);
	}

	@Override
	public int updateEmp(EmpDto empDto) {
		logger.debug("updateEmp");
		return empManager.updateEmp(empDto);
	}

}
