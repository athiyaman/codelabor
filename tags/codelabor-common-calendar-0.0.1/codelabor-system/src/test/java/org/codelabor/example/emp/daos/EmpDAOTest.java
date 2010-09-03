package org.codelabor.example.emp.daos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codelabor.example.emp.dtos.EmpDTO;
import org.codelabor.system.dtos.AffectedRowCountDTO;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import anyframe.common.Page;

public class EmpDAOTest extends AbstractDependencyInjectionSpringContextTests {

	private EmpDAO empDAO;

	@Override
	protected void onSetUp() throws Exception {
		empDAO = (EmpDAO) applicationContext.getBean("exampleEmpEmpDao");
		// queryService = (IQueryService) applicationContext
		// .getBean("oracleQueryService");

		/*
		 * // clear data String queryId = "example.delete.emp.list"; Object[]
		 * params = new Object[] {}; queryService.remove(queryId, params);
		 * 
		 * // insert data queryId = "example.insert.emp"; Object[] param = null;
		 * Calendar calendar = Calendar.getInstance(); calendar.clear();
		 * 
		 * calendar.set(1980, 12, 17, 12, 00, 00); param = new Object[] { 7369,
		 * "SMITH", "CLERK", 7902, calendar, 800, null, 20 };
		 * queryService.create(queryId, param);
		 * 
		 * calendar.set(1981, 2, 20, 12, 00, 00); param = new Object[] { 7499,
		 * "ALLEN", "SALESMAN", 7698, calendar, 1600, 300, 30 };
		 * queryService.create(queryId, param);
		 * 
		 * calendar.set(1981, 2, 22, 12, 00, 00); param = new Object[] { 7521,
		 * "WARD", "SALESMAN", 7698, calendar, 1250, 500, 30 };
		 * queryService.create(queryId, param);
		 * 
		 * calendar.set(1981, 4, 2, 12, 00, 00); param = new Object[] { 7566,
		 * "JONES", "MANAGER", 7839, calendar, 2975, null, 20 };
		 * queryService.create(queryId, param);
		 * 
		 * calendar.set(1981, 9, 28, 12, 00, 00); param = new Object[] { 7654,
		 * "MARTIN", "SALESMAN", 7698, calendar, 1250, 1400, 30 };
		 * queryService.create(queryId, param);
		 * 
		 * calendar.set(1981, 5, 1, 12, 00, 00); param = new Object[] { 7698,
		 * "BLAKE", "MANAGER", 7839, calendar, 2850, null, 30 };
		 * queryService.create(queryId, param);
		 * 
		 * calendar.set(1981, 6, 9, 12, 00, 00); param = new Object[] { 7782,
		 * "CLARK", "MANAGER", 7839, calendar, 2450, null, 10 };
		 * queryService.create(queryId, param);
		 * 
		 * calendar.set(1987, 4, 19, 12, 00, 00); param = new Object[] { 7788,
		 * "SCOTT", "ANALYST", 7566, calendar, 3000, null, 20 };
		 * queryService.create(queryId, param);
		 * 
		 * calendar.set(1981, 11, 17, 12, 00, 00); param = new Object[] { 7839,
		 * "KING", "PRESIDENT", null, calendar, 5000, null, 10 };
		 * queryService.create(queryId, param);
		 * 
		 * calendar.set(1981, 9, 8, 12, 00, 00); param = new Object[] { 7844,
		 * "TURNER", "SALESMAN", 7698, calendar, 1500, 0, 30 };
		 * queryService.create(queryId, param);
		 * 
		 * calendar.set(1987, 5, 23, 12, 00, 00); param = new Object[] { 7876,
		 * "ADAMS", "CLERK", 7788, calendar, 1100, null, 20 };
		 * queryService.create(queryId, param);
		 * 
		 * calendar.set(1981, 12, 3, 12, 00, 00); param = new Object[] { 7900,
		 * "JAMES", "CLERK", 7698, calendar, 950, null, 30 };
		 * queryService.create(queryId, param);
		 * 
		 * calendar.set(1981, 12, 3, 12, 00, 00); param = new Object[] { 7902,
		 * "FORD", "ANALYST", 7566, calendar, 3000, null, 20 };
		 * queryService.create(queryId, param);
		 * 
		 * calendar.set(1982, 1, 23, 12, 00, 00); param = new Object[] { 7934,
		 * "MILLER", "CLERK", 7782, calendar, 1300, null, 10 };
		 * queryService.create(queryId, param);
		 */
	}

	public void testInsertEmpEmpDTO() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();

		EmpDTO empDTO = new EmpDTO();
		empDTO.setEname("BOMBER");
		empDTO.setJob("FA");
		empDTO.setMgr(7839);
		calendar.set(2001, 2, 1, 12, 00, 00);
		empDTO.setHireDate(Calendar.getInstance().getTime());
		empDTO.setSal(5000);
		empDTO.setComm(0);
		empDTO.setDeptNo(20);

		int affectedRowCount = 0;
		try {
			affectedRowCount = this.empDAO.insertEmp(empDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(1, affectedRowCount);
	}

	public void testInsertEmpListOfEmpDTO() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();

		List<EmpDTO> empDTOList = new ArrayList<EmpDTO>();

		for (int i = 0; i < 2; i++) {
			EmpDTO empDTO = new EmpDTO();
			empDTO.setEname("BOMBER");
			empDTO.setJob("FA");
			empDTO.setMgr(7839);
			calendar.set(2001, 2, 1, 12, 00, 00);
			empDTO.setHireDate(Calendar.getInstance().getTime());
			empDTO.setSal(5000);
			empDTO.setComm(0);
			empDTO.setDeptNo(20);
			empDTOList.add(empDTO);
		}

		int affectedRowCount = 0;
		try {
			affectedRowCount = this.empDAO.insertEmp(empDTOList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(2, affectedRowCount);
	}

	public void testUpdateEmpEmpDTO() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();

		EmpDTO empDTO = new EmpDTO();
		empDTO.setEmpNo(8000);
		empDTO.setEname("BOMBER *");
		empDTO.setJob("FA");
		empDTO.setMgr(7839);
		calendar.set(2001, 2, 1, 12, 00, 00);
		empDTO.setHireDate(Calendar.getInstance().getTime());
		empDTO.setSal(5000);
		empDTO.setComm(0);
		empDTO.setDeptNo(20);

		int affectedRowCount = 0;
		try {
			affectedRowCount = this.empDAO.updateEmp(empDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(1, affectedRowCount);
	}

	public void testUpdateEmpListOfEmpDTO() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();

		List<EmpDTO> empDTOList = new ArrayList<EmpDTO>();

		EmpDTO empDTO = new EmpDTO();
		empDTO.setEmpNo(8001);
		empDTO.setEname("BOMBER *");
		empDTO.setJob("FA");
		empDTO.setMgr(7839);
		calendar.set(2001, 2, 1, 12, 00, 00);
		empDTO.setHireDate(Calendar.getInstance().getTime());
		empDTO.setSal(5000);
		empDTO.setComm(0);
		empDTO.setDeptNo(20);
		empDTOList.add(empDTO);

		empDTO = new EmpDTO();
		empDTO.setEmpNo(8002);
		empDTO.setEname("BOMBER *");
		empDTO.setJob("FA");
		empDTO.setMgr(7839);
		calendar.set(2001, 2, 1, 12, 00, 00);
		empDTO.setHireDate(Calendar.getInstance().getTime());
		empDTO.setSal(5000);
		empDTO.setComm(0);
		empDTO.setDeptNo(20);
		empDTOList.add(empDTO);

		int affectedRowCount = 0;
		try {
			affectedRowCount = this.empDAO.updateEmpList(empDTOList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(2, affectedRowCount);
	}

	public void testDeleteEmpEmpDTO() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();

		EmpDTO empDTO = new EmpDTO();
		empDTO.setEmpNo(8000);

		int affectedRowCount = 0;
		try {
			affectedRowCount = this.empDAO.deleteEmp(empDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(1, affectedRowCount);
	}

	public void testDeleteEmpListOfEmpDTO() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();

		List<EmpDTO> empDTOList = new ArrayList<EmpDTO>();

		EmpDTO empDTO = new EmpDTO();

		empDTO = new EmpDTO();
		empDTO.setEmpNo(8001);
		empDTOList.add(empDTO);

		empDTO = new EmpDTO();
		empDTO.setEmpNo(8002);
		empDTOList.add(empDTO);

		int affectedRowCount = 0;
		try {
			affectedRowCount = this.empDAO.deleteEmpList(empDTOList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(2, affectedRowCount);
	}

	public void testSelectEmp() {
		List<EmpDTO> empDTOList = null;
		try {
			empDTOList = this.empDAO.selectEmpList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(14, empDTOList.size());
	}

	public void testSelectEmpMap() {
		List<EmpDTO> empDTOList = null;
		try {
			Map<String, String> searchCondition = new HashMap<String, String>();
			searchCondition.put("deptNo", "10");
			empDTOList = this.empDAO.selectEmp(searchCondition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(3, empDTOList.size());
	}

	public void testSelectEmpPage() {
		int totalCount = 1;
		try {
			Page page = this.empDAO.selectEmpListByDeptNo(10, 1, 10);
			totalCount = page.getTotalCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(3, totalCount);
	}

	public void testSaveEmp() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();

		EmpDTO empDTO = null;

		// insert
		List<EmpDTO> insertEmpDTOList = new ArrayList<EmpDTO>();

		for (int i = 0; i < 2; i++) {
			empDTO = new EmpDTO();
			empDTO.setEname("BOMBER");
			empDTO.setJob("FA");
			empDTO.setMgr(7839);
			calendar.set(2001, 2, 1, 12, 00, 00);
			empDTO.setHireDate(Calendar.getInstance().getTime());
			empDTO.setSal(5000);
			empDTO.setComm(0);
			empDTO.setDeptNo(20);
			insertEmpDTOList.add(empDTO);
		}

		// update
		List<EmpDTO> updateEmpDTOList = new ArrayList<EmpDTO>();

		empDTO = new EmpDTO();
		empDTO.setEmpNo(8003);
		empDTO.setEname("BOMBER *");
		empDTO.setJob("SA");
		empDTO.setMgr(7839);
		calendar.set(2001, 2, 1, 12, 00, 00);
		empDTO.setHireDate(Calendar.getInstance().getTime());
		empDTO.setSal(5000);
		empDTO.setComm(0);
		empDTO.setDeptNo(20);
		updateEmpDTOList.add(empDTO);

		empDTO = new EmpDTO();
		empDTO.setEmpNo(8004);
		empDTO.setEname("BOMBER *");
		empDTO.setJob("SA");
		empDTO.setMgr(7839);
		calendar.set(2001, 2, 1, 12, 00, 00);
		empDTO.setHireDate(Calendar.getInstance().getTime());
		empDTO.setSal(5000);
		empDTO.setComm(0);
		empDTO.setDeptNo(20);
		updateEmpDTOList.add(empDTO);

		// delete
		List<EmpDTO> deleteEmpDTOList = new ArrayList<EmpDTO>();

		empDTO = new EmpDTO();
		empDTO.setEmpNo(8003);
		deleteEmpDTOList.add(empDTO);

		empDTO = new EmpDTO();
		empDTO.setEmpNo(8004);
		deleteEmpDTOList.add(empDTO);

		AffectedRowCountDTO affectedRowCount = null;
		try {
			affectedRowCount = this.empDAO.saveEmp(insertEmpDTOList,
					updateEmpDTOList, deleteEmpDTOList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(2, affectedRowCount.getInsertedRowCount());
		assertEquals(2, affectedRowCount.getUpdatedRowCount());
		assertEquals(2, affectedRowCount.getDeletedRowCount());
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext*.xml" };
	}
}
