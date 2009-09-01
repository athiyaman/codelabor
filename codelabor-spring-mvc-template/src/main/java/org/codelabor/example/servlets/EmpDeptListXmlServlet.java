package org.codelabor.example.servlets;

import java.beans.XMLEncoder;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.codelabor.example.dtos.DeptDTO;
import org.codelabor.example.dtos.EmpDTO;

public class EmpDeptListXmlServlet implements Servlet {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		List<List> compositeData = new ArrayList<List>();

		List<EmpDTO> empList = new ArrayList<EmpDTO>();

		Calendar calendar = Calendar.getInstance();
		calendar.clear();

		EmpDTO empDTO1 = new EmpDTO();
		empDTO1.setEmpNo(7369);
		empDTO1.setEname("SMITH");
		empDTO1.setJob("CLERK");
		empDTO1.setMgr(7902);
		calendar.set(1980, 12, 17, 0, 0, 0);
		Timestamp hireDate1 = new Timestamp(calendar.getTimeInMillis());
		empDTO1.setHireDate(hireDate1);
		empDTO1.setSal(800.00f);
		empDTO1.setComm(0.00f);
		empDTO1.setDeptNo(20);
		empList.add(empDTO1);

		EmpDTO empDTO2 = new EmpDTO();
		empDTO2.setEmpNo(7499);
		empDTO2.setEname("ALLEN");
		empDTO2.setJob("SALESMAN");
		empDTO2.setMgr(7698);
		calendar.set(1981, 2, 20, 0, 0, 0);
		Timestamp hireDate2 = new Timestamp(calendar.getTimeInMillis());
		empDTO2.setHireDate(hireDate2);
		empDTO2.setSal(1600.00f);
		empDTO2.setComm(300.00f);
		empDTO2.setDeptNo(30);
		empList.add(empDTO2);

		EmpDTO empDTO3 = new EmpDTO();
		empDTO3.setEmpNo(7521);
		empDTO3.setEname("WARD");
		empDTO3.setJob("SALESMAN");
		empDTO3.setMgr(7698);
		calendar.set(1981, 2, 22, 0, 0, 0);
		Timestamp hireDate3 = new Timestamp(calendar.getTimeInMillis());
		empDTO3.setHireDate(hireDate3);
		empDTO3.setSal(1250.00f);
		empDTO3.setComm(500.00f);
		empDTO3.setDeptNo(30);
		empList.add(empDTO3);

		EmpDTO empDTO4 = new EmpDTO();
		empDTO4.setEmpNo(800);
		empDTO4.setEname("홍길동");
		empDTO4.setJob("TESTER");
		empDTO4.setMgr(7698);
		calendar.set(1981, 2, 22, 0, 0, 0);
		Timestamp hireDate4 = new Timestamp(calendar.getTimeInMillis());
		empDTO4.setHireDate(hireDate4);
		empDTO4.setSal(1250.00f);
		empDTO4.setComm(500.00f);
		empDTO4.setDeptNo(30);
		empList.add(empDTO4);

		List<DeptDTO> deptList = new ArrayList<DeptDTO>();

		DeptDTO deptDTO1 = new DeptDTO();
		deptDTO1.setDeptNo(10);
		deptDTO1.setDname("ACCOUNTING");
		deptDTO1.setLoc("NEW YORK");
		deptList.add(deptDTO1);

		DeptDTO deptDTO2 = new DeptDTO();
		deptDTO2.setDeptNo(20);
		deptDTO2.setDname("RESEARCH");
		deptDTO2.setLoc("DALLAS");
		deptList.add(deptDTO2);

		DeptDTO deptDTO3 = new DeptDTO();
		deptDTO3.setDeptNo(30);
		deptDTO3.setDname("SALES");
		deptDTO3.setLoc("CHICAGO");
		deptList.add(deptDTO3);

		DeptDTO deptDTO4 = new DeptDTO();
		deptDTO4.setDeptNo(40);
		deptDTO4.setDname("OPERATIONS");
		deptDTO4.setLoc("BOSTON");
		deptList.add(deptDTO4);

		response.setContentType("text/xml;charset=UTF-8");
		compositeData.add(empList);
		compositeData.add(deptList);
		XMLEncoder xmlEncoder = new XMLEncoder(response.getOutputStream());
		xmlEncoder.writeObject(compositeData);
		xmlEncoder.close();
	}
}
