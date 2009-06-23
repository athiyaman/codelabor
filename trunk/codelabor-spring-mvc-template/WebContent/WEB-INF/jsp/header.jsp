<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
		
		<div id="banner">
			<span id="bannerLeft">codelabor-spring-mvc-template</span>
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
				<a href="<c:url value='/example/home.do'/>">example</a> |
				<a href="<c:url value='/system/administration/home.do'/>">system</a> |
				<a href="<c:url value='/system/my-account/home.do'/>">my account</a>
				<security:authorize ifAnyGranted="ROLE_ADMIN, ROLE_USER">
					 | 
					<a href="<c:url value='/j_spring_security_logout'/>">logout</a>
				</security:authorize>
			</div>
		  	<div class="clear"><hr/></div>
		</div>