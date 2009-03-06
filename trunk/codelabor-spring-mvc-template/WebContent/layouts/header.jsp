<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Header</title>
<style type="text/css" media="all">
<!--
@import
url(
<c:url value="/css/maven-base.css"/>
);
@import
url(
<c:url value="/css/maven-theme.css"/>
);
-->
</style>
</head>
<body>

<div id="banner"><a id="bannerLeft" href="#">CODELABOR Struts1 Template</a> <a
	id="bannerRight" href="#">[Main]</a>
<div class="clear">
<hr />
</div>
</div>
<div id="breadcrumbs">
<div class="xright">
<a href="<c:url value="/home.do"/>" target="_top">Home</a> |
<a href="<c:url value="/admin/home.do"/>" target="_top">Admin</a> | 
<a href="<c:url value="/system/home.do"/>" target="_top">System</a> |
<a href="<c:url value="/example/home.do"/>" target="_top">Example</a>
</div>
<div class="clear">
<hr />
</div>
</div>
</body>
</html>