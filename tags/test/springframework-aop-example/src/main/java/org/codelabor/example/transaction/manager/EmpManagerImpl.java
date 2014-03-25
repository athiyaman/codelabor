package org.codelabor.example.transaction.manager;

import java.util.List;

import org.codelabor.example.transaction.dao.EmpDao;
import org.codelabor.example.transaction.dto.EmpDto;
import org.codelabor.example.transaction.dto.EmpSearchConditionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpManagerImpl implements EmpManager {

	@Autowired
	private EmpDao empDao;
	private final static Logger logger = LoggerFactory
			.getLogger(EmpManagerImpl.class);

	@Override
	public int deleteEmp(Integer empNo) {
		logger.debug("deleteEmp");
		return empDao.deleteEmp(empNo);
	}

	@Override
	public int deleteEmpList(List<Integer> empNoList) {
		logger.debug("deleteEmpList");
		return empDao.deleteEmpList(empNoList);
	}

	@Override
	public int insertEmp(EmpDto empDto) {
		logger.debug("insertEmp");
		return empDao.insertEmp(empDto);
	}

	@Override
	public EmpDto selectEmp(Integer empNo) {
		logger.debug("selectEmp");
		return empDao.selectEmp(empNo);
	}

	@Override
	public List<EmpDto> selectEmpList() {
		logger.debug("selectEmpList");
		return empDao.selectEmpList();
	}

	@Override
	public List<EmpDto> selectEmpListByCondition(
			EmpSearchConditionDto empSearchConditionDto) {
		logger.debug("selectEmpListByCondition");
		return empDao.selectEmpListByCondition(empSearchConditionDto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.emp.manager.EmpManager#
	 * selectEmpListByConditionWithPagination
	 * (org.codelabor.example.emp.dto.EmpSearchConditionDto)
	 */
	@Override
	public List<EmpDto> selectEmpListByConditionWithPagination(
			EmpSearchConditionDto empSearchConditionDto) {
		logger.debug("selectEmpListByCondition");
		return empDao
				.selectEmpListByConditionWithPagination(empSearchConditionDto);
	}

	@Override
	public List<EmpDto> selectEmpListByDeptNo(Integer deptNo) {
		logger.debug("selectEmpListByDeptNo");
		return empDao.selectEmpListByDeptNo(deptNo);
	}

	@Override
	public int updateEmp(EmpDto empDto) {
		logger.debug("updateEmp");
		return empDao.updateEmp(empDto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.emp.manager.EmpManager#getNumberOfRow(org.codelabor
	 * .example.emp.dto.EmpSearchConditionDto)
	 */
	@Override
	public Integer getNumberOfRow(EmpSearchConditionDto empSearchConditionDto) {
		logger.debug("getNumberOfRow");
		return empDao.getNumberOfRow(empSearchConditionDto);
	}

}
