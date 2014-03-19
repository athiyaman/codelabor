<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- Registration Form -->
<title><spring:message
		code="title.example.validation.registration" /> <system:properties key="servlet.container.id" /></title>

</head>
<body>
	<sec:authentication property="principal" var="principal" />
	principal: ${principal} <br />
	<sec:authorize access="isAuthenticated()">
		Username: <sec:authentication property="principal.username" />
	</sec:authorize>

	<!-- Registration Form -->
	<h1>
		<spring:message code="heading.example.validation.registration.form" />
	</h1>
	<hr />
	<form:form commandName="registrationFormDto">
		<form:errors path="*" cssClass="errorBox" />
		<table>
			<tr>
				<!-- Username -->
				<td><spring:message code="label.username" /></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" /></td>
			</tr>
			<tr>
				<!-- Email -->
				<td><spring:message code="label.email" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="button.save" />" onclick="" /> <input
					type="reset" value="<spring:message code="button.reset" />" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>