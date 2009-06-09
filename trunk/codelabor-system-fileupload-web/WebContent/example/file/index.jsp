<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<style type="text/css" media="all">
			<!--
			@import url(<c:url value="/css/maven-base.css"/>);
			@import	url(<c:url value="/css/maven-theme.css"/>);
			-->
		</style>
		<title>File Upload Example</title>
	</head>
	<body>
		<div id="bodyColumn">
			<div id="contentBox">
				<div class="section">
					<h2>File Upload Example</h2>
					<p></p>
					<div class="section">
						<h3>Servlet</h3>
						<ul>
							<li><a href="<c:url value='/servlet/example/file/uploadFile?method=list'/>" target="_blank"><c:url value='/servlet/example/file/uploadFile?method=list'/></a></li>
						</ul>
					</div>
					<div class="section">
						<h3>Struts</h3>
						<ul>
							<li><a href="<c:url value='/example/file/uploadFile.do?method=list'/>" target="_blank"><c:url value='/example/file/uploadFile.do?method=list'/></a></li>
						</ul>
					</div>
										<div class="section">
						<h3>Spring MVC</h3>
						<ul>
							<li><a href="<c:url value='/example/file/uploadFile.form?method=list'/>" target="_blank"><c:url value='/example/file/uploadFile.form?method=list'/></a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="clear">
				<hr />
			</div>
		</div>
	</body>
</html>