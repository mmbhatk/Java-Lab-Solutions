<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eligibility</title>
</head>
<body>
<h2>The student is: </h2>
<%
	int age = Integer.parseInt(request.getParameter("age"));
	int marks = Integer.parseInt(request.getParameter("marks"));
	
	if(age>18 && marks>=20) out.println("<h3>ELIGIBLE</h3>");
	else out.println("<h3>NOT ELIGIBLE</h3>");
	
	//out.println(request.getParameter("username"));
	
	RequestDispatcher rd = request.getRequestDispatcher("counter.jsp");
	rd.include(request, response);
%>
</body>
</html>