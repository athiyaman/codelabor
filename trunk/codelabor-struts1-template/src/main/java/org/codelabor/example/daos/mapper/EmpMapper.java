package org.codelabor.example.daos.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.codelabor.example.dtos.EmpDTO;

import anyframe.core.query.IResultSetMapper;

public class EmpMapper implements IResultSetMapper {

	public Object mapRow(ResultSet resultSet) throws SQLException {
		EmpDTO empDTO = new EmpDTO();
		empDTO.setEmpNo(resultSet.getInt("empno"));
		empDTO.setEname(resultSet.getString("ename"));
		empDTO.setJob(resultSet.getString("job"));
		empDTO.setMgr(resultSet.getInt("mgr"));
		empDTO.setHireDate(resultSet.getTimestamp("hiredate"));
		empDTO.setSal(resultSet.getFloat("sal"));
		empDTO.setComm(resultSet.getFloat("comm"));
		empDTO.setDeptNo(resultSet.getInt("deptno"));
		return empDTO;
	}

}
