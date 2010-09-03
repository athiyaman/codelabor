<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title><bean:message key="title.login" bundle="example" /></title>
</head>
<body>
<div id="bodyColumn">
	<div id="contentBox">
		<div class="section">
		<h2>Login Example</h2>
		<div class="section">
			<h3><bean:message key="heading.login" bundle="example" /></h3>
			<p><html:errors /></p>
			<p><html:form action="/example/login?method=login"
				onsubmit="return validateLoginForm(this);">
				<table class="bodyTable">
					<tbody>
						<tr class="b">
							<th><bean:message key="prompt.id" bundle="example" /></th>
							<td><html:text property="userId" bundle="example" /></td>
						</tr>
						<tr class="b">
							<th><bean:message key="prompt.password" bundle="example" /></th>
							<td><html:password property="password" bundle="example"
								redisplay="false" /></td>
						</tr>
					</tbody>
				</table>
				<html:submit>
					<bean:message key="button.confirm" />
				</html:submit>
				<html:reset>
					<bean:message key="button.reset" />
				</html:reset>
				</html:form> <html:javascript formName="loginForm" /></p>
			</div>
		</div>
	</div>
	<div class="clear">
	<hr />
	</div>
</div>
</body>
</html>
