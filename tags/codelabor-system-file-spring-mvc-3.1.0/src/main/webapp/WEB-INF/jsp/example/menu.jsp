<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	errorPage="/system/error/error.do"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

				<h5><spring:message code="menu.example.upload"/></h5>
				<ul>
					<li>
  						<a href="<c:url value='/example/file/spring/mvc/list.do'/>"><spring:message code="label.example.file.spring.mvc"/></a>
					</li>
				</ul>