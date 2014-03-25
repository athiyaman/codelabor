<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/jspf/meta.jspf"%>
<title>Taglig JSTL</title>
<%@ include file="/WEB-INF/jspf/style.jspf"%>
</head>
<body class="composite">
	<div id="bodyColumn">
		<div id="contentBox">
			<h1>Taglig JSTL</h1>


			<h2>Parameter</h2>
			<h3>Post</h3>
			<form action="response.jsp" method="post">
				<table class="bodyTable">
					<tr class="b">
						<th>name</th>
						<th>value</th>
					</tr>
					<tr class="b">
						<td>param1</td>
						<td><input type="text" name="param1" id="param1"
							value="<b>value1</b><script type='text/javascript'>alert('value1');</script>"></td>
					</tr>
				</table>
				<input type="submit">
			</form>

			<h3>Get</h3>
			<form action="response.jsp" method="get">
				<table class="bodyTable">
					<tr class="b">
						<th>name</th>
						<th>value</th>
					</tr>
					<tr class="b">
						<td>param1</td>
						<td><input type="text" name="param1" id="param1"
							value="<b>value1</b><script type='text/javascript'>alert('value1');</script>"></td>
					</tr>
				</table>
				<input type="submit">
			</form>
		</div>
	</div>
</body>
</html>