<?xml version="1.0" encoding="UTF-8" ?>
<%@ page 
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
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
<title>Error</title>
</head>
<body>
<div id="bodyColumn">
<div id="contentBox">
<div class="section">
<h2>Error</h2>
<p></p>
<html:errors />

<logic:present name="javax.servlet.jsp.jspException">
<div class="section">
<h3>System Level Error (JSP Exception)</h3>
<p></p>
<table class="bodyTable">
	<tbody>
		<tr class="b">
			<th>Class</th>
			<td>
				<bean:write name="javax.servlet.jsp.jspException" property="class" />
			</td>
		</tr>
		<tr class="b">
			<th>Message</th>
			<td>
				<bean:write name="javax.servlet.jsp.jspException"
					property="message" />
			</td>
		</tr>
		<tr class="b">
			<th>StackTrace</th>
			<td>
				<bean:define id="stackTrace" name="javax.servlet.jsp.jspException" property="stackTrace"/>
				${stackTrace[0]}
			</td>
		</tr>
	</tbody>
</table>
</div>
</logic:present>

<logic:present name="org.apache.struts.action.EXCEPTION">
<bean:define id="actionException" name="org.apache.struts.action.EXCEPTION"/>
<div class="section">
<h3>System Level Error (Action / Service Exception)</h3>
<p></p>
<table class="bodyTable">
	<tbody>
		<tr class="b">
			<th>Class</th>
			<td>
			<bean:write 
				name="org.apache.struts.action.EXCEPTION"
				property="class" />
			</td>
		</tr>
		<tr class="b">
			<th>Message</th>
			<td>
			${actionException.message}
			<logic:present name="org.codelabor.system.COMMON_EXCEPTION">
				<bean:define id="commonException" name="org.codelabor.system.COMMON_EXCEPTION"/>
				<ul>
				<li>Code: ${commonException.messageCode}</li>
				<li>Reason: ${commonException.messages.reason}</li>
				<li>Solution: ${commonException.messages.solution}</li>
				</ul>
			</logic:present>
			</td>
		</tr>
		<tr class="b">
			<th>StackTrace</th>
			<td>
				${actionException.stackTrace[0]}
			</td>
		</tr>
	</tbody>
</table>
</div>
</logic:present>

</div>
</div>
<div class="clear">
<hr />
</div>
</div>
</body>
</html>