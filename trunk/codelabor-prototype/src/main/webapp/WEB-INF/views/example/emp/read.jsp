<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<%--
Author Sang Jae Shin
--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="title.emp.read" /></title>
</head>
<body>
	<h1>
		<spring:message code="heading.emp.read" />
	</h1>
	<hr />
	<!-- success message area -->
	<div class="successMessages">
		<c:forEach var="message" items="${messages}">
		${message}
		</c:forEach>
	</div>
	<table>
		<tr>
			<th><label for="empNo"><spring:message
						code="label.emp.empNo" /></label></th>
			<td><span id="empNo">${empDto.empNo}</span></td>
		</tr>
		<tr>
			<th><label for="ename"><spring:message
						code="label.emp.ename" /></label></th>
			<td><span id="ename">${empDto.ename}</span></td>
		</tr>
		<!--
		<tr>
			<th><label for="deptNo"><spring:message
						code="label.emp.deptNo" /></label></th>
			<td><span id="deptNo">${empDto.deptNo}</span></td>
		</tr>
		-->
		<tr>
			<th><label for="deptName"><spring:message
						code="label.emp.deptName" /></label></th>
			<td><span id="deptName">${empDto.deptName}</span></td>
		</tr>
		<tr>
			<th><label for="job"><spring:message
						code="label.emp.job" /></label></th>
			<td><span id="job">${empDto.job}</span></td>
		</tr>
		<tr>
			<th><label for="hireDate"><spring:message
						code="label.emp.hireDate" /></label></th>
			<td><span id="hireDate"><fmt:formatDate
						value="${empDto.hireDate}" pattern="yyyy-MM-dd" /></span></td>
		</tr>
		<!--
		<tr>
			<th><label for="mgr"><spring:message
						code="label.emp.mgr" /></label></th>
			<td><span id="mgr">${empDto.mgr}</span></td>
		</tr>
		-->
		<tr>
			<th><label for="mgr"><spring:message
						code="label.emp.mgrName" /></label></th>
			<td><span id="mgr">${empDto.mgrName}</span></td>
		</tr>
		<tr>
			<th><label for="comm"><spring:message
						code="label.emp.comm" /></label></th>
			<td><span id="comm"><fmt:formatNumber
						value="${empDto.comm}" pattern="#######.##" /></span></td>
		</tr>
		<tr>
			<th><label for="sal"><spring:message
						code="label.emp.sal" /></label></th>
			<td><span id="sal"><fmt:formatNumber
						value="${empDto.sal}" pattern="#######.##" /></span></td>
		</tr>
	</table>
	<hr />
	<a href="${pageContext.request.contextPath}/example/emp/listEmp"><spring:message
			code="button.list" /></a>
	<a
		href="${pageContext.request.contextPath}/example/emp/updateEmp?empNo=${empDto.empNo}"><spring:message
			code="button.update" /></a>
</body>
</html>