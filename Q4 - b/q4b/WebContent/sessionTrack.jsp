<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Trace</title>
</head>
<body>
<%
	HttpSession s = request.getSession(false);
	String name = (String)s.getAttribute("user");
	out.println("Login successful.<br>");
	out.println("Welcome " + name + "!");
%>
</body>
</html>