<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
<title>CRUD Example</title>
</head>
<body>
<div id="bodyColumn">
<div id="contentBox">
<div class="section">
<h2>CRUD Example</h2>
<p></p>
<div class="section">
<h3>Update Form</h3>
<p></p>
<html:form action="/example/crud?method=processUpdate" onsubmit="return validateCrudForm(this);">
	<table class="bodyTable">
		<tbody>
			<tr class="b">
				<th>id</th>
				<td><html:text property="id" value="${crudDTO.id}" readonly="true"/></td>
			</tr>
			<tr class="b">
				<th>field1</th>
				<td><html:text property="field1" value="${crudDTO.field1}"/></td>
			</tr>
			<tr class="b">
				<th>field2</th>
				<td><html:text property="field2" value="${crudDTO.field2}"/></td>
			</tr>
		</tbody>
	</table>
	<hr />
	<html:link action="/example/crud?method=list">list</html:link>
	<html:submit />
	<html:reset />
</html:form>
<html:javascript formName="crudForm" />
</div>
</div>
</div>
<div class="clear">
<hr />
</div>
</div>
</body>
</html>