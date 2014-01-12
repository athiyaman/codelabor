<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="log" uri="http://www.slf4j.org/taglib/tld"%>
<log:error category="jsp" message="status code: ${pageContext.errorData.statusCode}" />
<log:error category="jsp" message="request uri: ${pageContext.errorData.requestURI}" />
<log:error category="jsp" message="exception class: ${requestScope['javax.servlet.error.exception_type ']}" />
<log:error category="jsp" message="exception message: ${pageContext.exception.message}" />
<log:error category="jsp" message="cause: ${pageContext.exception.cause}" />
<log:error category="jsp" message="stack trace:" />
<c:forEach var="stackTraceElement" items="${pageContext.exception.stackTrace}" varStatus="status" >
	<log:error category="jsp" message="${status.index} ${stackTraceElement}" />
</c:forEach>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Default Error Page</title>
</head>
<body>
	<h1>Default Error Page</h1>
	<hr />
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
				<td>${pageContext.exception}</td>
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
			<tr>
				<td>suppressed</td>
				<td><c:forEach var="throwable"
						items="${pageContext.exception.suppressed}">${throwable}<br />
					</c:forEach></td>
			</tr>
		</table>
	</sec:authorize>


</body>
</html>