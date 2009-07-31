<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

					<h2><spring:message code="label.example.encryption.request.get"/></h2>
					<p></p>
					<div class="section">
						<h3><spring:message code="label.example.encryption.plain"/></h3>
						<ul>
						<li>param1=value11, param2=value2 <a href="<c:url value='/servlet/system/snifferServlet?param1=value1&param2=value2'/>" target="_blank">[test]</a></li>
						</ul>
					</div>
					<div class="section">
						<h3><spring:message code="label.example.encryption.encrypted"/></h3>
						<ul>
						<li>param1=value1, param2=value2 <a href="<c:url value='/servlet/system/snifferServlet?param1=value1&param2=value2'/>" target="_blank" onclick="return XecureLink(this);">[test]</a></li>
						</ul>
					</div>