<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Resource Finder (Class, Properties)</title>
</head>
<body>
<%@
	page import="java.net.URL"%>
<%
	String resourceNameWidhExtention = null;
	String resourceNameWidhoutExtention = null;
	String resourceExtention = null;
	String convertedResourceName = null;
	URL classUrl = null;
	ClassLoader classLoader = null;
	String classUrlMessage = "Not Found.";
	String classLoaderMessage = "Not Found.";
%>
<%
	resourceNameWidhExtention = request.getParameter("resource_name");

	if (resourceNameWidhExtention != null
			&& resourceNameWidhExtention.length() > 0) {
		resourceNameWidhExtention = resourceNameWidhExtention.trim();
		int lastIndex = resourceNameWidhExtention.lastIndexOf('.');

		if (lastIndex > 0) {
			resourceNameWidhoutExtention = resourceNameWidhExtention
					.substring(0, lastIndex);
			resourceExtention = resourceNameWidhExtention
					.substring(lastIndex + 1);

			StringBuffer buffer = new StringBuffer();
			buffer.append("/");
			buffer.append(resourceNameWidhoutExtention
					.replace('.', '/'));
			buffer.append(".");
			buffer.append(resourceExtention);
			convertedResourceName = buffer.toString();
			classUrl = this.getClass().getResource(
					convertedResourceName);
			try {
				classLoader = Class.forName(
						resourceNameWidhoutExtention).getClassLoader();
			} catch (Exception e) {
				// .properties 
			}
		}

	}
	if (classUrl != null)
		classUrlMessage = classUrl.getFile();
	if (classLoader != null)
		classLoaderMessage = classLoader.toString();
%>
<div id="bodyColumn">
	<div id="contentBox">
		<div class="section">
		<h2>Resource Finder</h2>
		<form>
		<table class="bodyTable">
			<caption></caption>
			<tbody>
				<tr class="b">
					<th>legend</th>
					<td>java.lang.String.class</td>
				</tr>
				<tr class="b">
					<th>name</th>
					<td><input type="text" name="resource_name"
						value="<%=resourceNameWidhExtention%>" /> <input type="submit"
						name="submit_button" value="search" /></td>
				</tr>
				<tr class="b">
					<th>class file</th>
					<td><%=classUrlMessage%></td>
				</tr>
				<tr class="b">
					<th>class loader</th>
					<td><%=classLoaderMessage%></td>
				</tr>
			</tbody>
		</table>
		</form>
		</div>
	</div>
	<div class="clear">
		<hr />
	</div>
	<div id="footer">
		<div class="xright">CODELABOR Template / Powered by Anyframe</div>
		<div class="clear">
			<hr />
		</div>
	</div>
</div>
</body>
</html>
