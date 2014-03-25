package org.codelabor.example.report.servlets;

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

import org.codelabor.example.emp.dtos.EmpDTO;

public class EmpListXmlServlet implements Servlet {

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

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
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

		response.setContentType("text/xml;charset=UTF-8");
		XMLEncoder xmlEncoder = new XMLEncoder(response.getOutputStream());
		xmlEncoder.writeObject(empList);
		xmlEncoder.close();
	}
}
