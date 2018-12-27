<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Counter</title>
</head>
<body>
<%
	//Initial value is null. Hence int cannot be used.
	Integer num = (Integer)application.getAttribute("hitCounter");
	
	if(num==null){
		out.println("<h2>Welcome " + request.getParameter("username") + "!</h2>");
		num = 1;
	}
	
	else{
		out.println("<h2>Welcome back, " + request.getParameter("username") + "!</h2>");
		num++;
	}
	application.setAttribute("hitCounter", num);
%>
Number of visitors who visited the page: <%=num %>
</body>
</html>