<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>		
		
		<div id="banner">
			<span id="bannerLeft">codelabor-spring-mvc-template</span>
			<div class="clear"><hr/></div>
		</div>
		<div id="breadcrumbs">
	 		<div class="xleft">Last Published: XXXX-XX-XX</div>
			<div class="xright">
				<a href="<c:url value='/example/home.do'/>">example</a> |
				<a href="<c:url value='/system/administration/home.do'/>">system</a> |
				<a href="<c:url value='/system/my-account/home.do'/>">my account</a>
			</div>
		  	<div class="clear"><hr/></div>
		</div>