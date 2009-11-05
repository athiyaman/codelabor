<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
		
		<div id="banner">
			<span id="bannerLeft"><spring:message code="label.header"/></span>
			<div class="clear"><hr/></div>
		</div>
		<div id="breadcrumbs">
	 		<div class="xleft">
	 			<c:if test="${!empty authorities}">
	 			(
	 			<c:forEach items="${authorities}" var="authority">
	 				${authority.authority}
	 			</c:forEach>
	 			)
	 			</c:if>
	 		</div>
			<div class="xright">
				<a href="<c:url value='/'/>">
					<spring:message code="menu.home"/>
				</a> |			
				<a href="<c:url value='/example/home.do'/>">
					<spring:message code="menu.example"/>
				</a> |
				<a href="<c:url value='/system/preferences/home.do'/>">
					<spring:message code="menu.system.preferences"/>
				</a>
			</div>
		  	<div class="clear"><hr/></div>
		</div>