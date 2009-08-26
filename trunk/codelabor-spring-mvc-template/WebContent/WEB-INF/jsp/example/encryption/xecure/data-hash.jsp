<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="org.springframework.web.context.WebApplicationContext,
    org.springframework.web.context.support.WebApplicationContextUtils,
    org.codelabor.system.security.xecure.services.XecureDBService"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


					<%
					WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(application);
					XecureDBService xecureDBService = (XecureDBService) context.getBean("xecureDBService");
					String plainData = "1234abcd가나다라";
					String encryptedData = xecureDBService.hash64(plainData);
					%>
					<h2><spring:message code="label.example.encryption.data.hash"/></h2>
					<p></p>
					<div class="section">
						<h3><spring:message code="label.example.encryption.plain"/></h3>
						<p><%= plainData %></p>
					</div>
					<div class="section">
						<h3><spring:message code="label.example.encryption.encrypted"/></h3>
						<p><%= encryptedData %></p>
					</div>