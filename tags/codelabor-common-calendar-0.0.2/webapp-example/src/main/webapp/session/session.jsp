<html>
<head>
	<meta http-equiv="refresh" content="1; url=session.jsp" >
</head>
<body>
<h2>Session</h2>
<%
long creationTime = session.getCreationTime();
long lastAccessTime = session.getLastAccessedTime();
int lifeTime = (int) ((lastAccessTime - creationTime) / 1000);
int inactiveInterval = session.getMaxInactiveInterval();
%>
<table>
	<tr>
		<th>id</th>
		<td><%= session.getId() %></td>
	</tr>
	<tr>
		<th>Creation Time</th>
		<td><%= creationTime %></td>
	</tr>
	<tr>
		<th>Last Accessed Time</th>
		<td><%= lastAccessTime %></td>
	</tr>
	<tr>
		<th>Max Inactive Interval</th>
		<td><%= inactiveInterval %> seconds</td>
	</tr>
	<tr>
		<th>Session Life Time</th>
		<td><%= lifeTime %> seconds</td>
	</tr>
	<%
	if (lifeTime > inactiveInterval) {
		session.invalidate();
	}
	%>
</table>
</body>
</html>
