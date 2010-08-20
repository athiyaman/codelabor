<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

					<h2><spring:message code="label.system.preferences.themes"/></h2>
					<p></p>
					<div class="section">
						<h3><spring:message code="label.system.preferences.themes.available"/></h3>
					</div>
					<ul>
						<li><a href="?theme=theme-maven">theme-maven</a></li>
						<li><a href="?theme=theme-maven-dark">theme-maven-dark</a></li>
					</ul>