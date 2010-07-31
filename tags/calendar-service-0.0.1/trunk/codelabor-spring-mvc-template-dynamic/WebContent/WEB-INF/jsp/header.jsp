<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
		
		<div id="banner">
			<span id="bannerLeft"><spring:message code="label.header"/></span>
			<div class="clear"><hr/></div>
		</div>
		<div id="breadcrumbs">
	 		<div class="xleft">
	 			<security:authentication property="name"/>
	 			<security:authentication property="authorities" var="authorities"/>
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
				<a href="<c:url value='/system/administration/home.do'/>">
					<spring:message code="menu.system.administration"/>
				</a> |
				<a href="<c:url value='/system/preferences/home.do'/>">
					<spring:message code="menu.system.preferences"/>
				</a>
				<security:authorize ifAnyGranted="ROLE_ANONYMOUS">
					 | 
					<a href="<c:url value='/system/login/home.do'/>">
						<spring:message code="menu.system.login.login"/>
					</a>
				</security:authorize>				
				<security:authorize ifNotGranted="ROLE_ANONYMOUS">
					 | 
					<a href="<c:url value='/j_spring_security_logout'/>">
						<spring:message code="menu.system.login.logout"/>
					</a>
				</security:authorize>
				
			</div>
		  	<div class="clear"><hr/></div>
		</div>