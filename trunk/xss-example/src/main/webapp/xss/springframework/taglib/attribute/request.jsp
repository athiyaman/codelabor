<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setAttribute("attrib1", "<b>value1</b>");
pageContext.forward("response.jsp");
%>
