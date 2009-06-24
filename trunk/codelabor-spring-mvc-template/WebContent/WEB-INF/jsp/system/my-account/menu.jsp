<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

				<h5><spring:message code="menu.system.preferences.profile"/></h5>
				<ul>
					<li class="none">
						<a href="">
							<spring:message code="menu.system.preferences.personalInfo"/>
						</a>
					</li>
					<li class="none">
						<a href="">
							<spring:message code="menu.system.preferences.changePassword"/>
						</a>
					</li>					
				</ul>
				<h5><spring:message code="menu.system.preferences.preferences"/></h5>
				<ul>
					<li class="none">
						<a href="<c:url value='/system/preperences/locale/home.do'/>">
							<spring:message code="menu.system.preferences.locale"/>
						</a>
					</li>
					<li class="none">
						<a href="<c:url value='/system/preperences/themes/home.do'/>">
							<spring:message code="menu.system.preferences.themes"/>
						</a>
					</li>
					<li class="none">
						<a href="">
							<spring:message code="menu.system.preferences.favorites"/>
						</a>
					</li>					
				</ul>													