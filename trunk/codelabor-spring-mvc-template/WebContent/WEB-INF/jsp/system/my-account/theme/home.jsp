<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}<spring:theme code="stylesheet.base"/>" type="text/css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}<spring:theme code="stylesheet.theme"/>" type="text/css"/>
		<title>Theme Example</title>
	</head>
	<body>
		<div id="bodyColumn">
			<div id="contentBox">
				<div class="section">
					<h2>Theme</h2>
					<p></p>
					<div class="section">
						<h3>Available Theme</h3>
					</div>
					<ul>
						<li><a href="?theme=theme-maven">theme-maven</a></li>
						<li><a href="?theme=theme-maven-dark">theme-maven-dark</a></li>
					</ul>
				</div>
			</div>
			<div class="clear">
				<hr />
			</div>
		</div>
	</body>
</html>