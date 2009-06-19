<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="org.springframework.web.servlet.support.RequestContext"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
					
					<h2><spring:message code="label.system.myAccount.locale"/></h2>
					<p></p>
					<div class="section">
						<h3>Available Locale</h3>
					</div>
					<ul>
						<li><a href="?locale=ko">ko</a></li>
						<li><a href="?locale=en">en</a></li>
					</ul>
					Current Locale: <%= (new RequestContext(request)).getLocale() %>