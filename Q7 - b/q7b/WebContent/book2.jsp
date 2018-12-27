<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "final";
	String username = "root";
	String password = "";
	
	try {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url+dbName, username, password);
		Statement stmt = con.createStatement();
		String query = "SELECT * FROM BOOK WHERE TITLE = '" + request.getParameter("title") + "'";
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
			out.println("Book number: " + rs.getInt(1) + "<br>");
			out.println("Book number: " + rs.getString(2) + "<br>");
			out.println("Book number: " + rs.getString(3) + "<br>");
			out.println("Book number: " + rs.getString(4) + "<br>");
			out.println("Book number: " + rs.getInt(5));
		}
	}
	catch(Exception e){
		out.println("Exception in book2.jsp.");
	}
%>
</body>
</html>