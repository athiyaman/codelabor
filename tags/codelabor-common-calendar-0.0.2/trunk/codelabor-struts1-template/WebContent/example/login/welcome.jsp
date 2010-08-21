<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="org.codelabor.system.Constants" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
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
<title><bean:message key="heading.login" bundle="example"/></title>
</head>
<body>
<div id="bodyColumn">
	<div id="contentBox">
		<div class="section">
			<h2><bean:message key="heading.welcome" bundle="example"/></h2>
			<table class="bodyTable">
				<tbody>
					<tr class="b">
						<th><bean:message key="prompt.loginInfo" bundle="example"/></th>
						<td>${sessionScope["org.codelabor.system.SESSION_LOGIN_INFO"]}</td>
					</tr>
				</tbody>
			</table>			
			<p><html:link action="/example/login?method=logout"><bean:message key="button.logout" bundle="example"/></html:link></p>
		</div>
	</div>
	<div class="clear">
		<hr />
	</div>
</div>
</body>
</html>
