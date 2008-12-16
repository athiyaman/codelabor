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
<title>CRUD Example 2</title>
</head>
<body>
<div id="bodyColumn">
<div id="contentBox">
<div class="section">
<h2>CRUD Example 2</h2>
<p></p>
<div class="section">
<h3>Create Form</h3>
<p></p>
<form action="/example/crud2.do">
	<input type="hidden" name="method" value="processCreate"/>
	<table class="bodyTable">
		<tbody>
			<tr class="b">
				<th>id</th>
				<td>自動生成</td>
			</tr>
			<tr class="b">
				<th>field1</th>
				<td><input type="text" name="field1" /></td>
			</tr>
			<tr class="b">
				<th>field2</th>
				<td><input type="text" name="field2" /></td>
			</tr>
		</tbody>
	</table>
	<hr/>
	<a href="/example/crud2.do?method=list">list</a>
<input type="reset"/>
<input type="submit"/>
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