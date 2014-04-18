<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<%--
author Shin Sang-Jae
--%>
<html>
<head>
<meta charset="UTF-8">
<title>System Home</title>
</head>
<body>
	<h1>System Home</h1>
	<hr />
	${serverTime}
	<br />
	<table>
		<tr>
			<th>Principal</th>
			<td><sec:authentication property="principal" /></td>
		</tr>
		<tr>
			<th>Authenticated Type</th>
			<td><sec:authorize access="isFullyAuthenticated()">by login-form</sec:authorize>
				<sec:authorize access="isAuthenticated()">by remember-me</sec:authorize></td>
		</tr>
	</table>
</body>
</html>