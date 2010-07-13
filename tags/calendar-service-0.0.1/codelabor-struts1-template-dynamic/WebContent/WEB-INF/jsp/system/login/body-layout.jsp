<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>	
					
					<h2><spring:message code="label.login.home"/></h2>
					<div id="loginPKI">
						<tiles:insert attribute="login1"/>
					</div>
					<div id="loginUsernamePassword">
					<tiles:insert attribute="login2"/>
					</div>