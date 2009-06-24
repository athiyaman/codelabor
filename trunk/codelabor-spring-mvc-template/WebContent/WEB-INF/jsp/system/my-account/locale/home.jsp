<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="org.springframework.web.servlet.support.RequestContext"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
					
					<h2><spring:message code="label.system.preferences.locale"/></h2>
					<p></p>
					<div class="section">
						<h3><spring:message code="label.system.preferences.locale.available"/></h3>
						<ul>
							<li><a href="?locale=ko">ko</a></li>
							<li><a href="?locale=en">en</a></li>
						</ul>
						<p>
						Current Locale: <%= (new RequestContext(request)).getLocale() %>
						</p>
					</div>
					