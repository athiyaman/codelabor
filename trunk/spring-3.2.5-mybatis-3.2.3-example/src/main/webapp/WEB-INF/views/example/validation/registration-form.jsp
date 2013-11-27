<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Registration Form</title>
</head>
<body>
	<h1>Registration Form</h1>
	<hr />
	<form:form commandName="personDto">
		<form:errors path="*"  cssClass="errorBox" />
		<table>
			<tr>
				<td>Username</td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" /></td>
			</tr>			
			<tr>
				<td>Phone</td>
				<td><form:input path="phone" /></td>
				<td><form:errors path="phone" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td>Zip Code</td>
				<td><form:input path="zipCode" /></td>
				<td><form:errors path="zipCode" /></td>
			</tr>
			<tr>
				<td>Birth Date (yyyy-MM-dd)</td>
				<td><form:input path="birthDate" /></td>
				<td><form:errors path="birthDate" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" /><input type="reset" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>