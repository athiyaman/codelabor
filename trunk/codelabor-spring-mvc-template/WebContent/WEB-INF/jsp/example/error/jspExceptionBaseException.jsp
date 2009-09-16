<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="anyframe.common.exception.BaseException"
	errorPage="/system/error/error.do"%>
<%
	try {
		int result = 1/0;
	} catch (Exception e) {
		BaseException baseException = new BaseException(e.getMessage());
		throw baseException;
	}
%>

