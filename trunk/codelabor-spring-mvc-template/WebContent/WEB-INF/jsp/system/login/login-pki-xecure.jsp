<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>	

					<script language="javascript" src="<c:url value='/XecureObject/xecureweb.js'/>"></script>
					<script language="javascript">PrintObjectTag();</script>

							
					<h3><spring:message code="label.login.pki"/></h3>
					<form name="xecure">
						<input type="hidden" name="p"/>
					</form>
					<form name="loginPkiForm"
						action="<c:url value='/j_spring_security_check'/>" method="post" onsubmit="loginPkiForm.signedMessage.value = Sign_with_option(0, loginPkiForm.plainMessage.value);return XecureSubmit(this);">
						<input type="hidden" name="plainMessage" value="login"/>
						<input type="hidden" name="signedMessage"/>
						<input type="submit" value="<spring:message code='button.login.login'/>">
					</form>
					