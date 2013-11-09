<?xml version="1.0" encoding="EUC-KR" ?>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="org.springframework.web.context.WebApplicationContext,
    org.springframework.web.context.support.WebApplicationContextUtils,
    org.codelabor.edu.HelloWorld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR" />
<title>Insert title here</title>
</head>
<body>
<%
WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(application);
HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
String message = helloWorld.sayHello();
out.println(message);
%>
<hr/>
<%
HelloWorld helloWorld2 = (HelloWorld) context.getBean("helloWorld2");
String message2 = helloWorld2.sayHello();
out.println(message2);
%>
</body>
</html>