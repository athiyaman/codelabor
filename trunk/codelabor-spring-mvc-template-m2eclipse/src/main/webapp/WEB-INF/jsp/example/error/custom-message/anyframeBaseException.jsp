<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="org.springframework.context.MessageSource,
		org.springframework.web.context.support.WebApplicationContextUtils,
		anyframe.common.exception.BaseException"
	errorPage="/system/error/error.do"%>
<%
	try {
		int result = 1/0;
	} catch (Exception e) {
		MessageSource messageSource = (MessageSource) WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext()).getBean("messageSource");
		BaseException baseException = new BaseException(messageSource, "errors.example.error.divided.by.zero", new Object[] {}, e);
		throw baseException;
	}
%>

