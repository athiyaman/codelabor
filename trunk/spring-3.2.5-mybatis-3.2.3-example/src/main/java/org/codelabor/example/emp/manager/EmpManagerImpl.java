package org.codelabor.example.emp.manager;

import java.util.List;

import org.codelabor.example.emp.dao.EmpDao;
import org.codelabor.example.emp.dto.EmpDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpManagerImpl implements EmpManager {

	@Autowired
	private EmpDao empDao;
	private Logger logger = LoggerFactory.getLogger(EmpManagerImpl.class);

	@Override
	public int deleteEmp(Integer empNo) {
		logger.debug("deleteEmp");
		return empDao.deleteEmp(empNo);
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
	public List<EmpDto> selectEmpListByDeptNo(Integer deptNo) {
		logger.debug("selectEmpListByDeptNo");
		return empDao.selectEmpListByDeptNo(deptNo);
	}

	@Override
	public int updateEmp(EmpDto empDto) {
		logger.debug("updateEmp");
		return empDao.updateEmp(empDto);
	}

}
