<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="org.springframework.context.MessageSource,
		org.springframework.web.context.support.WebApplicationContextUtils,
		org.codelabor.system.exceptions.CommonException,
		org.codelabor.system.exceptions.RollbackCommonException"
	errorPage="/system/error/error.do"%>
<%
	try {
		int result = 1/0;
	} catch (Exception e) {
		MessageSource messageSource = (MessageSource) WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext()).getBean("messageSource");
		CommonException commonException = new RollbackCommonException(messageSource, "errors.example.error.divided.by.zero", new Object[] {}, e);
		commonException.setMessageCode("E0000");
		throw commonException;
	}
%>
