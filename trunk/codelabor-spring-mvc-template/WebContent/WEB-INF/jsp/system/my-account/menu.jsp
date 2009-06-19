<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

				<h5><spring:message code="menu.system.myAccount.profile"/></h5>
				<ul>
					<li class="none">
						<a href="">
							<spring:message code="menu.system.myAccount.personalInfo"/>
						</a>
					</li>
					<li class="none">
						<a href="">
							<spring:message code="menu.system.myAccount.changePassword"/>
						</a>
					</li>					
				</ul>
				<h5><spring:message code="menu.system.myAccount.preferences"/></h5>
				<ul>
					<li class="none">
						<a href="<c:url value='/system/my-account/locale/home.do'/>">
							<spring:message code="menu.system.myAccount.locale"/>
						</a>
					</li>
					<li class="none">
						<a href="<c:url value='/system/my-account/themes/home.do'/>">
							<spring:message code="menu.system.myAccount.themes"/>
						</a>
					</li>
					<li class="none">
						<a href="">
							<spring:message code="menu.system.myAccount.favorites"/>
						</a>
					</li>					
				</ul>													