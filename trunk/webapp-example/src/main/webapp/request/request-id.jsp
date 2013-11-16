<%@page import="org.codelabor.system.ThreadLocalObject" %>
<html>
<body>
<h2>Request ID</h2>
<table>
	<tr>
		<th>id</th>
		<td><%= ThreadLocalObject.requestID.get() %></td>
	</tr>
</table>
</body>
</html>
