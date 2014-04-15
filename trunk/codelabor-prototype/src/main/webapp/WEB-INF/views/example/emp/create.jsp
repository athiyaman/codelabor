<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<%--
Author Sang Jae Shin
--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="title.emp.create" /></title>
</head>
<body>
<h1><spring:message code="heading.emp.create" /></h1>
<hr/>
<form:form commandName="empDto">
<!-- failure message area -->
<div class="failureMessages">
	<form:errors path="*" />
</div>
<table>
	<tr>
		<th><label for="empNo"><spring:message code="label.emp.empNo" /></label></th>
		<td><form:input path="empNo" placeholder="max 9999" /><span><form:errors path="empNo" /></span></td>
	</tr>
	<tr>
		<th><label for="ename"><spring:message code="label.emp.ename" /></label></th>
		<td><form:input path="ename" placeholder="length max 10" /><span><form:errors path="ename" /></span></td>
	</tr>
	<tr>
		<th><label for="deptNo"><spring:message code="label.emp.deptNo" /></label></th>
		<td>
			<form:select path="deptNo" items="${deptMap}" />
			<span><form:errors path="deptNo" /></span>
		</td>
	</tr>
	<tr>
		<th><label for="job"><spring:message code="label.emp.job" /></label></th>
		<td><form:input path="job" placeholder="length max 9" /><span><form:errors path="job" /></span></td>
	</tr>
	<tr>
		<th><label for="hireDate"><spring:message code="label.emp.hireDate" /></label></th>
		<td><form:input path="hireDate" placeholder="yyyy-MM-dd" /><span><form:errors path="hireDate" /></span></td>
	</tr>
	<tr>
		<th><label for="mgr"><spring:message code="label.emp.mgrName" /></label></th>
		<td>
			<form:select path="mgr" items="${mgrMap}" />
			<span><form:errors path="mgr" /></span>
		</td>
	</tr>
	<tr>
		<th><label for="comm"><spring:message code="label.emp.comm" /></label></th>
		<td><form:input path="comm" placeholder="integer 7, fraction 2" /><span><form:errors path="comm" /></span></td>
	</tr>
	<tr>
		<th><label for="sal"><spring:message code="label.emp.sal" /></label></th>
		<td><form:input path="sal" placeholder="integer 7, fraction 2" /><span><form:errors path="sal" /></span></td>
	</tr>
</table>
<hr/>
<a href="${pageContext.request.contextPath}/example/emp/listEmp"><spring:message
			code="button.list" /></a>
<input type="submit" value="<spring:message code='button.save'/>" />
<input type="reset" value="<spring:message code='button.reset'/>" />
</form:form>
</body>
</html>