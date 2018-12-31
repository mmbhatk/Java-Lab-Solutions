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
		HttpSession s = request.getSession();
		session.setAttribute("user", username);	
		request.getRequestDispatcher("sessionTrack.jsp").forward(request, response);
	}
	else response.sendRedirect("/q4b/register.html");
%>

</body>
</html>