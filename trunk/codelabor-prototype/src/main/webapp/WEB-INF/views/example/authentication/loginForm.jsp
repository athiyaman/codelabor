<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<%--
author Shin Sang-Jae
--%>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="title.login" /></title>
</head>
<body>
	<h1>
		<spring:message code="heading.login.form" />
	</h1>
	<hr />

	${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

	<fieldset>
		<legend>
			<spring:message code="label.login" />
		</legend>
		<form action="${pageContext.request.contextPath}/example/authentication/login" method="post" autocomplete="off">
			<table>
				<tr>
					<th><label for="username"><spring:message
								code="label.username" /></label></th>
					<td><input type="text" id="username" name="j_username" /></td>
				</tr>
				<tr>
					<th><label for="password"><spring:message
								code="label.password" /></label></th>
					<td><input type="password" id="password" name="j_password" /></td>
				</tr>
				<tr>
					<th><label for="j_remember"><spring:message
								code="label.rememberMe" /></label></th>
					<td><input type="checkbox" id="j_remember" name="_spring_security_remember_me" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" /> <input
						type="submit" value="<spring:message code="button.submit"/>" />
						<input
						type="reset" value="<spring:message code="button.reset"/>" /></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>