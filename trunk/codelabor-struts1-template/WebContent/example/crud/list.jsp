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
<title>CRUD Example</title>
</head>
<body>
<div id="bodyColumn">
	<div id="contentBox">
		<div class="section">
		<h2>CRUD Example</h2>
		<p></p>
		<div class="section">
			<h3>List</h3>
			<p></p>
			<html:form action="/example/crud?method=delete">
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
								<html:multibox property="id" value="${crudMap.id}">
								</html:multibox>
							</td>
							<td>
							<html:link action="/example/crud?method=read" paramId="id"
								paramName="crudMap" paramProperty="id">${crudMap.id}</html:link>
							</td>
							<td>${crudMap.field1}</td>
							<td>${crudMap.field2}</td>
						</tr>
					</logic:iterate>
					</logic:present>
				</tbody>
			</table>
			<hr />
			<html:link action="/example/crud?method=prepareCreate">create</html:link>
			<html:reset />
			<html:submit>delete</html:submit>
			</html:form>
			</div>
		</div>
	</div>
	<div class="clear">
		<hr />
	</div>
</div>
</body>
</html>