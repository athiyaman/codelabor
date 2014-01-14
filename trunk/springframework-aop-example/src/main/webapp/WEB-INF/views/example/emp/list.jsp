<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pg" uri="/WEB-INF/tlds/pagination.tld"%>
<!DOCTYPE html>
<%--
Author Sang Jae Shin
--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="title.emp.list" /></title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/example/emp/emp.js"></script>
</head>
<body>
	<h1>
		<spring:message code="heading.emp.list" />
	</h1>
	<hr />

	<!-- success message area -->
	<div class="successMessages">
		<c:forEach var="message" items="${messages}">
		${message}
	</c:forEach>
	</div>

	<!-- search condition area -->
	<form:form
		action="${pageContext.request.contextPath}/example/emp/listEmp"
		commandName="empSearchConditionDto" method="get">
		<fieldset>
			<legend>
				<spring:message code="label.searchCondition" />
			</legend>
			<table>
				<tr>
					<th><spring:message code="label.emp.job" /></th>
					<td><form:input path="job" /></td>
					<th><spring:message code="label.emp.sal" /></th>
					<td><form:input path="salFrom" /> <spring:message
							code="label.from" /> ~ <form:input path="salTo" /> <spring:message
							code="label.to" /> <input type="reset"
						value="<spring:message code="button.reset" />" /> <input
						type="submit" value="<spring:message code="button.search" />" />
					</td>
				</tr>
			</table>
		</fieldset>
	</form:form>

	<!-- list area -->
	<form:form
		action="${pageContext.request.contextPath}/example/emp/deleteEmpList"
		commandName="integerIdListDto">

		<!-- error messages area -->
		<form:errors path="*" />

		<table>
			<tr>
				<th><spring:message code="label.check" /></th>
				<th><spring:message code="label.emp.empNo" /></th>
				<th><spring:message code="label.emp.ename" /></th>
				<th><spring:message code="label.emp.deptName" /></th>
				<th><spring:message code="label.emp.job" /></th>
				<th><spring:message code="label.emp.hireDate" /></th>
				<th><spring:message code="label.emp.mgrName" /></th>
				<th><spring:message code="label.emp.comm" /></th>
				<th><spring:message code="label.emp.sal" /></th>
			</tr>
			<c:forEach var="empDto" items="${empDtoList}">
				<tr>

					<td><form:checkbox path="id" value="${empDto.empNo}" /></td>
					<td><a
						href="${pageContext.request.contextPath}/example/emp/readEmp?empNo=${empDto.empNo}">
							<c:out value="${empDto.empNo}" />
					</a></td>
					<td><a
						href="${pageContext.request.contextPath}/example/emp/readEmp?empNo=${empDto.empNo}">
							<c:out value="${empDto.ename}" />
					</a></td>
					<td><c:out value="${empDto.deptName}" /></td>
					<td><c:out value="${empDto.job}" /></td>
					<td><fmt:formatDate value="${empDto.hireDate}"
							pattern="yyyy-MM-dd" /></td>
					<td><c:out value="${empDto.mgrName}" /></td>
					<td><c:out value="${empDto.comm}" /></td>
					<td><c:out value="${empDto.sal}" /></td>
				</tr>
			</c:forEach>
		</table>
		<hr />
		<a href="${pageContext.request.contextPath}/example/emp/createEmp"><spring:message
				code="button.create" /></a>
		<input type="submit" value="<spring:message code="button.delete" />"
			onclick="deleteBySearchCondition()" />
	</form:form>

	<!--  pagination -->
	<pg:pagination cssClass="pageArea" numberOfRow="${numberOfRow}">
		<pg:firstIndex cssClass="btn_prev">
			<img src="/images/btn/btn_prev.png"
				alt="<spring:message code="alternate.first" />" />
		</pg:firstIndex>
		<pg:previousIndex cssClass="btn_prev">
			<img src="/images/btn/btn_prev.png"
				alt="<spring:message code="alternate.prev" />" />
		</pg:previousIndex>
		<pg:currentIndex />
		<pg:nextIndex cssClass="btn_next">
			<img src="/images/btn/btn_next.png"
				alt="<spring:message code="alternate.next" />" />
		</pg:nextIndex>
		<pg:lastIndex cssClass="btn_next">
			<img src="/images/btn/btn_next.png"
				alt="<spring:message code="alternate.last" />" />
		</pg:lastIndex>
	</pg:pagination>
</body>
</html>