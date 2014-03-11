<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="codelaborForm" uri="http://codelabor.org/tags/form" %>
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

	<div id="global.errors.area"></div>

	<form:form commandName="personDto">
		<form:errors path="*" />
		<codelaborForm:errors path="*"/>
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
				<!-- Password Confirmation -->
				<td><spring:message code="label.passwordConfirm" /></td>
				<td><form:password path="passwordConfirm" /></td>
				<td><form:errors path="passwordConfirm" /></td>
			</tr>
			<tr>
				<!-- First Name -->
				<td><spring:message code="label.firstName" /></td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" /></td>
			</tr>
			<tr>
				<!-- Last Name -->
				<td><spring:message code="label.lastName" /></td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" /></td>
			</tr>
			<tr>
				<!-- Mobile Phone -->
				<td><spring:message code="label.mobilePhone" /><span>0X-XXX-XXXX, 01X-XXXX-XXXX</span></td>
				<td><form:input path="mobilePhone" /></td>
				<td><form:errors path="mobilePhone" /></td>
			</tr>
			<tr>
				<!-- Home Phone -->
				<td><spring:message code="label.homePhone" /><span>0X-XXX-XXXX, 0X-XXXX-XXXX, 0XX-XXX-XXXX, 0XX-XXXX-XXXX</span></td>
				<td><form:input path="homePhone" /></td>
				<td><form:errors path="homePhone" /></td>
			</tr>
			<tr>
				<!-- Email -->
				<td><spring:message code="label.email" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<!-- Email Confirmation -->
				<td><spring:message code="label.emailConfirm" /></td>
				<td><form:input path="emailConfirm" /></td>
				<td><form:errors path="emailConfirm" /></td>
			</tr>
			<tr>
				<!-- Zip Code -->
				<td><spring:message code="label.zipCode" /></td>
				<td><form:input path="zipCode" /></td>
				<td><form:errors path="zipCode" /></td>
			</tr>
			<tr>
				<!-- Birth Date -->
				<td><spring:message code="label.birthDate" /> yyyy-MM-dd</td>
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