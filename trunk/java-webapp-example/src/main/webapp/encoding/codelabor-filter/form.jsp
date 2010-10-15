<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<h2>encoding: form</h2>
	<h3>get</h3>
	<form action="result.jsp" method="get">
		<table>
			<tr>
				<th>value1</th><td><input type="text" name="field1"/><input type="submit"/></td>
			</tr>
		</table>
	</form>

	<h3>post</h3>
	<form action="result.jsp" method="post">
		<table>
			<tr>
				<th>value1</th><td><input type="text" name="field1"/><input type="submit"/></td>
			</tr>
		</table>
	</form>
</body>
</html>