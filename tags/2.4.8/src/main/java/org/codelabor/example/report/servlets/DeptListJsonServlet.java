package org.codelabor.example.report.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.sf.json.JSONArray;

import org.codelabor.example.dept.dtos.DeptDTO;

public class DeptListJsonServlet implements Servlet {

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

		response.setContentType("text/plain;charset=UTF-8");
		JSONArray jsonArray = JSONArray.fromObject(deptList);
		response.getWriter().write(jsonArray.toString());
	}
}
