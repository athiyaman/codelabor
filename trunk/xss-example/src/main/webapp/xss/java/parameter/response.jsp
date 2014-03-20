<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/jspf/meta.jspf"%>
<title>Java</title>
<%@ include file="/WEB-INF/jspf/style.jspf"%>
</head>
<body class="composite">
	<div id="bodyColumn">
		<div id="contentBox">
			<h1>Java</h1>

			<h2>Parameter</h2>
			<h3>Query String</h3>

			<h4>EL</h4>
			<table class="bodyTable">
				<tr class="b">
					<th>name</th>
					<th>value</th>
				</tr>
				<tr class="b">
					<td>pageContext.request.queryString</td>
					<td>${pageContext.request.queryString}</td>
				</tr>
				<tr class="b">
					<td>pageContext.request.queryString (form input)</td>
					<td>
						<form>
							<input type="text" value="${pageContext.request.queryString}" />
						</form>
					</td>
				</tr>
				<tr class="b">
					<td>pageContext.request.queryString (anchor url)</td>
					<td>
						<a href="${pageContext.request.requestURI}?${pageContext.request.queryString}">link</a>
					</td>
				</tr>
			</table>

			<h4>Scriptlet</h4>
			<table class="bodyTable">
				<tr class="b">
					<th>name</th>
					<th>value</th>
				</tr>
				<tr class="b">
					<td>request.getQueryString()</td>
					<td><%=request.getQueryString()%></td>
				</tr>
				<tr class="b">
					<td>request.getQueryString() (form input)</td>
					<td>
						<form>
							<input type="text" value="<%=request.getQueryString()%>" />
						</form>
					</td>
				</tr>
				<tr class="b">
					<td>pageContext.request.queryString (anchor url)</td>
					<td>
						<a href="${pageContext.request.requestURI}?<%=request.getQueryString()%>">link</a>
					</td>
				</tr>
			</table>

			<h4>Scriptlet (URL Encoding)</h4>
			<table class="bodyTable">
				<tr class="b">
					<th>name</th>
					<th>value</th>
				</tr>
				<tr class="b">
					<td>request.getQueryString()</td>
					<td><%= URLEncoder.encode(request.getQueryString(), "UTF-8")%></td>
				</tr>
				<tr class="b">
					<td>URLEncoder.encode(request.getQueryString(), "UTF-8") (form input)</td>
					<td>
						<form>
							<input type="text" value="<%=URLEncoder.encode(request.getQueryString(), "UTF-8")%>" />
						</form>
					</td>
				</tr>
				<tr class="b">
					<td>URLEncoder.encode(request.getQueryString(), "UTF-8") (anchor url)</td>
					<td>
						<a href="${pageContext.request.requestURI}?<%=URLEncoder.encode(request.getQueryString(), "UTF-8")%>">link</a>
					</td>
				</tr>
			</table>


		</div>
	</div>
</body>
</html>