<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
<title>Select Example</title>
</head>
<body>
<div id="bodyColumn">
	<div id="contentBox">
		<div class="section">
			<h2>Select Example</h2>
			<p></p>
			<div class="section">
				<h3>Detail View</h3>
				<p></p>
				<table class="bodyTable">
					<tbody>
						<tr class="b">
							<th>empNo</th>
							<td>${empDTO.empNo}</td>
						</tr>
						<tr class="b">
							<th>ename</th>
							<td>${empDTO.ename}</td>
						</tr>
						<tr class="b">
							<th>job</th>
							<td>${empDTO.job}</td>
						</tr>
						<tr class="b">
							<th>mgr</th>
							<td>${empDTO.mgr}</td>
						</tr>
						<tr class="b">
							<th>hireDate</th>
							<td>${empDTO.hireDate}</td>
						</tr>
						<tr class="b">
							<th>sal</th>
							<td>${empDTO.sal}</td>
						</tr>
						<tr class="b">
							<th>comm</th>
							<td>${empDTO.comm}</td>
						</tr>
						<tr class="b">
							<th>deptNo</th>
							<td>${empDTO.deptNo}</td>
						</tr>		
					</tbody>
				</table>
				<hr />
				<html:link action="/example/emp?method=list">list</html:link> 
			</div>
		</div>
	</div>
	<div class="clear">
		<hr />
	</div>
</div>
</body>
</html>