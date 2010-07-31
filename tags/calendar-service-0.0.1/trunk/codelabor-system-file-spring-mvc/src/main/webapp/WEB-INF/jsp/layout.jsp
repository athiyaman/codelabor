<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title><tiles:getAsString name="title"/></title>
		<style type="text/css" media="screen">
	  		@import url(${pageContext.request.contextPath}<spring:theme code="stylesheet.base"/>);
	  		@import url(${pageContext.request.contextPath}<spring:theme code="stylesheet.theme"/>);
	  		@import url(${pageContext.request.contextPath}<spring:theme code="stylesheet.site"/>);
		</style>
		<style type="text/css" media="print">
			@import url(${pageContext.request.contextPath}/css/print.css);
		</style>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	</head>
	<body class="composite">
		<tiles:insertAttribute name="header"/>
		<div id="leftColumn">
			<div id="navcolumn">
				<tiles:insertAttribute name="menu"/>
			</div>
		</div>
		<div id="bodyColumn">
			<div id="contentBox">
				<div class="section">
					<tiles:insertAttribute name="body"/>
				</div>
		  	</div>
		</div>
		<div class="clear"><hr/></div>
		<div id="footer">
			<tiles:insertAttribute name="footer"/>
		</div>
	</body>
</html>
