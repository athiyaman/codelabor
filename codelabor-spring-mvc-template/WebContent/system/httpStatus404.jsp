<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page errorPage="/system/error.jsp" %>
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
<title>404 Not Found</title>
</head>
<body>
<div id="bodyColumn">
<div id="contentBox">
<div class="section">
<h2>HTTP Status : 404</h2>
<p></p>
<html:errors />


<div class="section">
<h3>404 Not Found</h3>
<p></p>
<table class="bodyTable">
	<tbody>
		<tr class="b">
			<th>Description</th>
			<td>
				Check Access Log
			</td>
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