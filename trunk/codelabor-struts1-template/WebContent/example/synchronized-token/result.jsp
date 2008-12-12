<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="org.apache.struts.Globals" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css" media="all">
<!--
@import
url(<html:rewrite
module=
""
page
=
"/css/maven-base.css"
/>);
@import
url(<html:rewrite
module=
""
page
=
"/css/maven-theme.css"
/>);
-->
</style>
<title>Synchronized Token Example</title>
</head>
<body>
<div id="bodyColumn">
<div id="contentBox">
	<div class="section">
		<h2>Synchronized Token Example</h2>
		<div class="section">
		<h3>Result</h3>
			<table class="bodyTable">
				<tbody>
					<tr class="b">
						<td>field1</td>
						<td>${field1}</td>
					</tr>
					<tr class="b">
						<td>field2</td>
						<td>${field2}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<div class="clear">
<hr />
</div>
</div>
</body>
</html>
