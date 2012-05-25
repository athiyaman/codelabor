<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="org.codelabor.system.exception.UserException, javax.servlet.jsp.JspException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>User Error</title>
</head>
<body>
<h1>User Error</h1>
<hr/>
<c:if test="${not empty pageContext.exception.message}">
	${pageContext.exception.message}
</c:if>
<c:if test="${pageContext.exception.message}">
	That's an error.
</c:if>
</body>
</html>