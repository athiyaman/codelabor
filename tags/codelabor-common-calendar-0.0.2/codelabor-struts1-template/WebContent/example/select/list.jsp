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
<title>Select Example</title>
</head>
<body>
<div id="bodyColumn">
	<div id="contentBox">
		<div class="section">
		<h2>Select Example</h2>
		<p></p>
		<div class="section">
			<h3>List</h3>
			<p></p>
			<table class="bodyTable">
				<tbody>
					<tr class="a">
						<th>empNo</th>
						<th>ename</th>
						<th>job</th>
						<th>mgr</th>
						<th>hireDate</th>
						<th>sal</th>
						<th>comm</th>
						<th>deptNo</th>
					</tr>
					<logic:present name="empDTOList">
					<logic:iterate name="empDTOList" id="empDTO">
						<tr class="b">
							<td>
							<html:link action="/example/emp?method=read" paramId="empNo"
								paramName="empDTO" paramProperty="empNo">${empDTO.empNo}</html:link>
							</td>
							<td>${empDTO.ename}</td>
							<td>${empDTO.job}</td>
							<td>${empDTO.mgr}</td>
							<td>${empDTO.hireDate}</td>
							<td>${empDTO.sal}</td>
							<td>${empDTO.comm}</td>
							<td>${empDTO.deptNo}</td>
						</tr>
					</logic:iterate>
					</logic:present>
				</tbody>
			</table>
			<hr />
			</div>
		</div>
	</div>
	<div class="clear">
		<hr />
	</div>
</div>
</body>
</html>