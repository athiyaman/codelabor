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


			<h2>Attribute</h2>
			<h3>EL</h3>
			<table class="bodyTable">
				<tr class="b">
					<th>name</th>
					<th>value</th>
				</tr>
				<tr class="b">
					<td>attrib1</td>
					<td>${attrib1}</td>
				</tr>
				<tr class="b">
					<td>attrib1 (form input)</td>
					<td>
						<form>
							<input type="text" value="${attrib1}" />
						</form>
					</td>
				</tr>
			</table>

			<h3>c out escape</h3>
			<h4>default</h4>
			<table class="bodyTable">
				<tr class="b">
					<th>name</th>
					<th>value</th>
				</tr>
				<tr class="b">
					<td>attrib1</td>
					<td><c:out value="${attrib1}" /></td>
				</tr>
				<tr class="b">
					<td>attrib1 (form input)</td>
					<td>
						<form>
							<input type="text" value="<c:out value="${attrib1}" />" />
						</form>
					</td>
				</tr>
			</table>

			<h4>escapeXml="true"</h4>
			<table class="bodyTable">
				<tr class="b">
					<th>name</th>
					<th>value</th>
				</tr>
				<tr class="b">
					<td>attrib1</td>
					<td><c:out value="${attrib1}" escapeXml="true" /></td>
				</tr>
				<tr class="b">
					<td>attrib1 (form input)</td>
					<td>
						<form>
							<input type="text"
								value="<c:out value="${attrib1}" escapeXml="true" />" />
						</form>
					</td>
				</tr>
			</table>

			<h4>escapeXml="false"</h4>
			<table class="bodyTable">
				<tr class="b">
					<th>name</th>
					<th>value</th>
				</tr>
				<tr class="b">
					<td>attrib1</td>
					<td><c:out value="${attrib1}" escapeXml="false" /></td>
				</tr>
				<tr class="b">
					<td>attrib1 (form input)</td>
					<td>
						<form>
							<input type="text"
								value="<c:out value="${attrib1}" escapeXml="false" />" />
						</form>
					</td>
				</tr>
			</table>

			<h3>fn escapeXml</h3>
			<h4>default</h4>
			<table class="bodyTable">
				<tr class="b">
					<th>name</th>
					<th>value</th>
				</tr>
				<tr class="b">
					<td>attrib1</td>
					<td>${fn:escapeXml(attrib1)}</td>
				</tr>
				<tr class="b">
					<td>attrib1 (form input)</td>
					<td>
						<form>
							<input type="text" value="${fn:escapeXml(attrib1)}" />
						</form>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>