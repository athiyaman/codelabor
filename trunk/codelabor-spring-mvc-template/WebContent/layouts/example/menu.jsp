<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Menu</title>
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
<body class="composite">
<div id="leftColumn">
<div id="navcolumn">
<h5><a>Select</a></h5>
<ul>
	<li><a href="<c:url value="/example/emp?method=list"/>" target="body">emp manager</a></li>
</ul>
<h5><a>CRUD</a></h5>
<ul>
	<li><a href="<c:url value="/example/crud?method=list"/>" target="body">crud service</a></li>
</ul>

<h5><a>Synchronized Token</a></h5>
<ul>
	<li><a href="<c:url value="/example/prepareSynchronizedToken"/>" target="body">synchnizied token</a></li>
</ul>

<h5><a>Login</a></h5>
<ul>
	<li><a href="<c:url value="/example/login?method=prepare"/>" target="body">login</a></li>
</ul>

<h5><a>Error Handling</a></h5>
<ul>
	<li><a href="<c:url value="/example/error-handling/notExistPage.jsp"/>" target="body">does not exist</a></li>
	<li><a href="<c:url value="/example/error-handling/jspError.jsp"/>" target="body">does</a></li>
	<li><a href="<c:url value="/example/error-handling/jspErrorWithDirective.jsp"/>" target="body">jsp (page directive)</a></li>
	<li><a href="<c:url value="/example/error?method=forwardErrorPage"/>" target="body">action (action error)</a></li>
	<li><a href="<c:url value="/example/error?method=throwException"/>" target="body">action (throw exception)</a></li>
	<li><a href="<c:url value="/example/error?method=rollbackMethod"/>" target="body">service (throw rollback)</a></li>
	<li><a href="<c:url value="/example/error?method=noRollbackMethod"/>" target="body">service (throw no rollback)</a></li>
</ul>

<h5><a>File</a></h5>
<ul>
	<li><a href="<c:url value="/example/uploadFile?method=list"/>" target="body">file list</a></li>
</ul>

</div>
</div>
</body>
</html>