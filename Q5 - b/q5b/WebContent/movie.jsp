<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
%>
Name: <% out.println(name); %><br>
Age: <% out.println(age); %><br>
Price: Rs.
<%
	if(age>62) out.println("50");
	else if(age<10) out.println("10");
	else out.println("80");
%>
</body>
</html>