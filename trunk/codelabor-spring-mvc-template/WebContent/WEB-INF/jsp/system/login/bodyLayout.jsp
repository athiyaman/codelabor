<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>	
					
					<h2><spring:message code="label.login.home"/></h2>
					<div id="login">
						<div id="loginPKI">
							<tiles:insertAttribute name="left"/>
						</div>
							<div id="loginWebId">
						<tiles:insertAttribute name="right"/>
						</div>
					</div>