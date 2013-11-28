<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- Registration Form -->
<title><spring:message code="title.example.validation.registration" /></title>
</head>
<body>
	<!-- Registration Form -->
	<h1><spring:message code="heading.example.validation.registration.form" /></h1>
	<hr />
	<form:form commandName="personDto">
		<form:errors path="*"  cssClass="errorBox" />
		<table>
			<tr>
				<!-- Username -->
				<td><spring:message code="label.username" /></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" /></td>
			</tr>
			<tr>
				<!-- Password -->
				<td><spring:message code="label.password" /></td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<!-- First Name -->
				<td><spring:message code="label.first.name" /></td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" /></td>
			</tr>
			<tr>
				<!-- Last Name -->
				<td><spring:message code="label.last.name" /></td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" /></td>
			</tr>			
			<tr>
				<!-- Phone -->
				<td><spring:message code="label.phone" /></td>
				<td><form:input path="phone" /></td>
				<td><form:errors path="phone" /></td>
			</tr>
			<tr>
				<!-- Email -->
				<td><spring:message code="label.email" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<!-- Zip Code -->
				<td><spring:message code="label.zip.code" /></td>
				<td><form:input path="zipCode" /></td>
				<td><form:errors path="zipCode" /></td>
			</tr>
			<tr>
				<!-- Birth Date -->
				<td><spring:message code="label.birth.date" /> (yyyy-MM-dd)</td>
				<td><form:input path="birthDate" /></td>
				<td><form:errors path="birthDate" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="<spring:message code="button.save" />" />
					<input type="reset" value="<spring:message code="button.reset" />" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>