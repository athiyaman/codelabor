<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>	

					<script language="javascript" src="<c:url value='/XecureObject/xecureweb.js'/>"></script>
					<script language="javascript">PrintObjectTag();</script>
					<form name='xecure' ><input type=hidden name='p'></form>
							
					<h3><spring:message code="label.login.pki"/></h3>
					<form name="loginPkiForm"
						action="<c:url value='/system/login/xecure/login.do'/>" method="post" onsubmit="loginPkiForm.signed.value = Sign_with_option(0, loginPkiForm.plain.value);return XecureSubmit(this);">
						<input type="hidden" name="plain"/>
						<input type="hidden" name="signed"/>
						<input type="submit" value="<spring:message code='button.login.login'/>">
					</form>
					