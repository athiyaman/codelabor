<%@page import="org.codelabor.system.web.SessionObject" %>
<html>
<body>
<h2>Session Bind</h2>
<% 
	SessionObject sessionObject = new SessionObject();
	session.setAttribute("sessionObject", sessionObject);
%>
</body>
</html>
