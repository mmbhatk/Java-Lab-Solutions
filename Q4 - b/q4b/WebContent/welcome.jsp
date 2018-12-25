<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>

<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	if(username.equals("admin") && password.equals("admin"))
	{
		out.println("Welcome " + username + "!");
		HttpSession s = request.getSession();
		session.setAttribute("user", username);
	}
	else out.println("Login failed. Username or password is incorrect.");
%>

</body>
</html>