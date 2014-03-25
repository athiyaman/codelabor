<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Emp Example</title>
</head>
<body>
<h1>Emp List</h1>
<hr/>
<table>
<c:forEach var="empDto" items="${empDtoList}">
	<tr>
	<td><c:out value="${empDto.empNo}" /></td>
	<td><c:out value="${empDto.ename}" /></td>
	<td><c:out value="${empDto.deptNo}" /></td>
	<td><c:out value="${empDto.job}" /></td>
	<td><c:out value="${empDto.hireDate}" /></td>
	<td><c:out value="${empDto.mgr}" /></td>
	<td><c:out value="${empDto.comm}" /></td>
	<td><c:out value="${empDto.sal}" /></td>
	</tr>
</c:forEach>
</table>
</body>
</html>