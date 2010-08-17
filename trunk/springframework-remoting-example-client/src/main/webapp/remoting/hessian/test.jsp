<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="org.springframework.web.context.WebApplicationContext,
    org.springframework.web.context.support.WebApplicationContextUtils,
    org.codelabor.example.services.HelloWorldService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(application);
HelloWorldService helloWorldService = (HelloWorldService) context
				.getBean("hessianHelloWorldService");
String greeting = helloWorldService.sayHello("bomber");
out.println(greeting);
%>
</body>
</html>