<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Menu</title>
<style type="text/css" media="all">
<!--
@import
url(<html:rewrite
page=
"/css/maven-base.css"
/>);
@import
url(<html:rewrite
page=
"/css/maven-theme.css"
/>);
-->
</style>
</head>
<body class="composite">
<div id="leftColumn">
<div id="navcolumn">
<h5><a>Select</a></h5>
<ul>
	<li><html:link action="/example/emp?method=list" target="body">emp manager</html:link></li>
</ul>
<h5><a>CRUD</a></h5>
<ul>
	<li><html:link action="/example/crud?method=list" target="body">crud service</html:link></li>
</ul>

<h5><a>Synchronized Token</a></h5>
<ul>
	<li><html:link action="/example/prepareSynchronizedToken" target="body">synchnizied token</html:link></li>
</ul>

<h5><a>Login</a></h5>
<ul>
	<li><html:link action="/example/login?method=prepare" target="body">login</html:link></li>
</ul>

<h5><a>Error Handling</a></h5>
<ul>
	<li><html:link page="/example/error-handling/notExistPage.jsp"
		target="body">does not exist</html:link></li>
	<li><html:link page="/example/error-handling/jspError.jsp"
		target="body">jsp (no page directive)</html:link></li>
	<li><html:link page="/example/error-handling/jspErrorWithDirective.jsp"
		target="body">jsp (page directive)</html:link></li>
	<li><html:link action="/example/error?method=forwardErrorPage"
		target="body">action (action error)</html:link></li>
	<li><html:link action="/example/error?method=throwException"
		target="body">action (throw exception)</html:link></li>
	<li><html:link action="/example/error?method=rollbackMethod"
		target="body">service (throw rollback)</html:link></li>
	<li><html:link action="/example/error?method=noRollbackMethod"
		target="body">service (throw no rollback)</html:link></li>
</ul>

<h5><a>File</a></h5>
<ul>
	<li><html:link action="/example/uploadFile?method=list" target="body">file list</html:link></li>
</ul>

</div>
</div>
</body>
</html>