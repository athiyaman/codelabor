<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	errorPage="/WEB-INF/views/example/error/defaultErrorPage.jsp"%>
<%@ page
	import="org.codelabor.system.web.taglib.PaginationConstants, java.util.regex.Pattern, java.util.regex.Matcher"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pg" uri="/WEB-INF/tlds/pagination.tld"%>
<%@ taglib prefix="codelaborForm" uri="http://codelabor.org/tags/form"%>
<!DOCTYPE html>
<%--
Author Sang Jae Shin
--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="title.emp.list" /></title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/example/emp/emp.js"></script>
<!--
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/default.css" />
	-->
</head>
<body>
	<h1>
		<spring:message code="heading.emp.list" />
	</h1>
	<hr />

	<!-- failure message area -->
	<div class="failureMessages">
		<ul>
			<c:forEach var="message" items="${failureMessages}">
				<li>${message}</li>
			</c:forEach>
		</ul>
	</div>

	<!-- success message area -->
	<div class="successMessages">
		<ul>
			<c:forEach var="message" items="${successMessages}">
				<li>${message}</li>
			</c:forEach>
		</ul>
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
					<td><form:input path="job" />
						<form:errors path="job" /></td>
					<th><spring:message code="label.emp.sal" /></th>
					<td><form:input path="salFrom" /> <spring:message
							code="label.from" /> ~ <form:input path="salTo" /> <spring:message
							code="label.to" /> <input type="reset"
						value="<spring:message code="button.reset" />" /> <input
						type="submit" value="<spring:message code="button.search" />" />
						<form:errors path="salFrom" /> <form:errors path="salTo" /></td>
				</tr>
			</table>
		</fieldset>
	</form:form>

	<!-- import / export area -->
	<form
		action="${pageContext.request.contextPath}/example/emp/importEmpList"
		method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>
				<spring:message code="label.importExport" />
			</legend>
			<table>
				<tr>
					<th><spring:message code="label.excelFile" /></th>
					<td><input type="file" name="file" /> <input type="submit"
						value="<spring:message code="button.import" />"
						onclick="importFileWithSearchCondition()" /></td>
					<td><c:choose>
							<c:when test="${not empty pageContext.request.queryString}">
								<a
									href="${pageContext.request.contextPath}/example/emp/exportEmpListOnCurrentPage?${pageContext.request.queryString}">
									<spring:message code="button.export.current.page" />
								</a>
							</c:when>
							<c:otherwise>
								<a
									href="${pageContext.request.contextPath}/example/emp/exportEmpListOnCurrentPage">
									<spring:message code="button.export.current.page" />
								</a>
							</c:otherwise>
						</c:choose> &nbsp; <%
 	String queryString = request.getQueryString();
 	String replacedQueryString = null;
 	if (queryString != null) {
 		StringBuilder sb = new StringBuilder();
 		sb.append(PaginationConstants.PAGE_NO_PARAM_NAME).append(
 				"=[0-9]*&");
 		sb.append(PaginationConstants.MAX_ROW_PER_PAGE_PARAM_NAME)
 				.append("=[0-9]*&?");
 		Pattern pattern = Pattern.compile(sb.toString());
 		Matcher matcher = pattern.matcher(queryString);
 		replacedQueryString = matcher.replaceAll("");
 	}
 	pageContext
 			.setAttribute("replacedQueryString", replacedQueryString);
 %> <c:choose>
							<c:when test="${not empty replacedQueryString}">
								<a
									href="${pageContext.request.contextPath}/example/emp/exportEmpList?${replacedQueryString}">
									<spring:message code="button.export.all.page" />
								</a>
							</c:when>
							<c:otherwise>
								<a
									href="${pageContext.request.contextPath}/example/emp/exportEmpList">
									<spring:message code="button.export.all.page" />
								</a>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</table>
		</fieldset>
	</form>

	<!-- list area -->
	<form:form
		action="${pageContext.request.contextPath}/example/emp/deleteEmpList"
		commandName="integerIdListDto">

		<!-- failure messages area -->
		<div class="failureMessages">
			<!--
			<form:errors path="*" />
			-->
			<codelaborForm:errors path="*" />
		</div>

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
	<pg:pagination numberOfRow="${numberOfRow}">
		<pg:firstIndex>
			<spring:message code="alternate.first" />
		</pg:firstIndex>
		&nbsp;
		<pg:previousIndex>
			<spring:message code="alternate.prev" />
		</pg:previousIndex>
		&nbsp;
		<pg:currentIndex />
		&nbsp;
		<pg:nextIndex>
			<spring:message code="alternate.next" />
		</pg:nextIndex>
		&nbsp;
		<pg:lastIndex>
			<spring:message code="alternate.last" />
		</pg:lastIndex>
	</pg:pagination>
</body>
</html>