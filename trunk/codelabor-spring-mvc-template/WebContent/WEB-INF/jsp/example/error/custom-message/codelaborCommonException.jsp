<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="org.codelabor.system.exceptions.CommonException,
	org.codelabor.system.exceptions.RollbackCommonException"
	errorPage="/system/error/error.do"%>
<%
	try {
		int result = 1/0;
	} catch (Exception e) {
		CommonException commonException = new RollbackCommonException(e.getMessage());
		commonException.setMessageCode("E0000");
		throw commonException;
	}
%>
