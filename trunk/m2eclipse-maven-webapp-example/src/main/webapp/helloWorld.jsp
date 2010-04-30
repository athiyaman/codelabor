<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Hello, World!</title>
</head>
<body>
<jsp:useBean id="helloWorldBean" class="org.codelabor.example.HelloWorldBean"></jsp:useBean>
<jsp:getProperty property="greeting" name="helloWorldBean"/>
</body>
</html>