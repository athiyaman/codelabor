<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>	

					<script language="javascript" src="<c:url value='/XecureObject/xecureweb.js'/>"></script>
					<script language="javascript">PrintObjectTag();</script>
					
							
					<h3><spring:message code="label.login.pki"/></h3>
					<form name="pkiLoginForm"
						action="<c:url value='/system/login/xecure/login.do'/>" method="post" onsubmit="return XecureSubmit(this)">
						<input type="submit" value="<spring:message code='button.login.login'/>">
					</form>
					