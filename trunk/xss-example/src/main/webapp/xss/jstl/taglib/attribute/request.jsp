<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Request</title>
</head>
<body>
	<h1>Request</h1>
	<hr/>
	
	<h2>Parameter</h2>
	<h3>Post</h3>
	<form action="response.jsp" method="post">
		<table>
			<tr>
				<td>name</td><td>value</td>
			</tr>
			<tr>
				<td>param1</td>
				<td><input type="text" name="param1" id="param1" value="<b>value1</b>"></td>
			</tr>
		</table>
		<input type="submit">
	</form>

	<h3>Get</h3>
	<form action="response.jsp" method="get">
		<table>
			<tr>
				<td>name</td><td>value</td>
			</tr>
			<tr>
				<td>param1</td>
				<td><input type="text" name="param1" id="param1" value="<b>value1</b>"></td>
			</tr>
		</table>
		<input type="submit">
	</form>	

</body>
</html>