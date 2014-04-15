<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<h1><spring:message code="heading.login.success" /></h1>
<hr/>
<a href="${pageContext.request.contextPath}/example/logout"><spring:message code="button.logout"/></a>
</body>
</html>