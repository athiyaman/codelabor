<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="title.error" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="robots" content="noindex, nofollow" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<style type="text/css">
</style>
</head>
<body>
	<h1><spring:message code="heading.error.http.status.code.404" /></h1>
	<hr />
	<p><spring:message code="errors.http.status.code.404" htmlEscape="false" /></p>
	<ul>
		<li><spring:message code="label.webmaster.phoneNumber" />: <spring:eval
				expression="@systemProperties.getProperty('webmaster.phoneNumber')" />
		</li>
		<li><spring:message code="label.webmaster.email" />: <spring:eval
				expression="@systemProperties.getProperty('webmaster.email')" /></li>
	</ul>
	<sec:authorize access="hasRole('ROLE_DEVELOPER')">
		<table>
			<tr>
				<th>attribute</th>
				<th>value</th>
			</tr>
			<tr>
				<td>statusCode</td>
				<td>${pageContext.errorData.statusCode}</td>
			</tr>
			<tr>
				<td>requestURI</td>
				<td>${pageContext.errorData.requestURI}</td>
			</tr>
			<tr>
				<td>exception</td>
				<td>${pageContext.errorData.throwable}</td>
			</tr>
			<tr>
				<td>message</td>
				<td>${pageContext.exception.message}</td>
			</tr>
			<tr>
				<td>localizedMessage</td>
				<td>${pageContext.exception.localizedMessage}</td>
			</tr>
			<tr>
				<td>cause</td>
				<td>${pageContext.exception.cause}</td>
			</tr>
			<tr>
				<td>stackTrace</td>
				<td><c:forEach var="throwable"
						items="${pageContext.exception.stackTrace}">${throwable}<br />
					</c:forEach></td>
			</tr>
		</table>
	</sec:authorize>
</body>
</html>
<log:error category="jsp"
	message="status code: ${pageContext.errorData.statusCode}" />
<log:error category="jsp"
	message="request uri: ${pageContext.errorData.requestURI}" />
<log:error category="jsp"
	message="exception class: ${pageContext.errorData.throwable}" />
<log:error category="jsp"
	message="exception message: ${pageContext.exception.message}" />
<log:error category="jsp"
	message="cause: ${pageContext.errorData.throwable.cause}" />
<log:error category="jsp" message="stack trace:" />
<c:forEach var="stackTraceElement"
	items="${pageContext.exception.stackTrace}" varStatus="status">
	<log:error category="jsp"
		message="${status.index} ${stackTraceElement}" />
</c:forEach>