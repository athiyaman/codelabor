<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
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
<title>CRUD Example 2</title>
</head>
<body>
<div id="bodyColumn">
<div id="contentBox">
<div class="section">
<h2>CRUD Example 2</h2>
<p></p>
<div class="section">
<h3>List</h3>
<p></p>
<form action="/example/crud2.do">
<input type="hidden" name="method" value="delete"/>
<table class="bodyTable">
	<tbody>
		<tr class="a">
			<th>check</th>
			<th>id</th>
			<th>field1</th>
			<th>field2</th>
		</tr>
		<logic:present name="crudMapList">
		<logic:iterate name="crudMapList" id="crudMap">
			<tr class="b">
				<td>
					<input type="checkbox" name="id" value="${crudMap.id}"/>
				</td>
				<td>
				<a href="/example/crud2.do?method=read&id=${crudMap.id}">${crudMap.id}</a>
				</td>
				<td>${crudMap.field1}</td>
				<td>${crudMap.field2}</td>
			</tr>
		</logic:iterate>
		</logic:present>
	</tbody>
</table>
<hr />
<a href="/example/crud2.do?method=prepareCreate">create</a>
<input type="reset"/>
<input type="submit" value="delete"/>
</form>
</div>
</div>
</div>
<div class="clear">
<hr />
</div>
</div>
</body>
</html>