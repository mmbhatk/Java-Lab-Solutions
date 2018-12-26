<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Grade</title>
</head>
<body>
<h1>Grade</h1>
<% int marks = Integer.parseInt(request.getParameter("marks")); %>
Marks: <% out.println(marks); %><br>
Grade:
<%
	if(marks>=90) out.println("A");
	else if(marks>=80) out.println("B");
	else if(marks>=70) out.println("C");
	else out.println("Fail");
%>
</body>
</html>