<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.RequestDispatcher" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
	int bnum = Integer.parseInt(request.getParameter("bnum"));
	String title = request.getParameter("title");
	String author = request.getParameter("author");
	String publication = request.getParameter("publication");
	int price = Integer.parseInt(request.getParameter("price"));

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "final";
	String username = "root";
	String password = "";
	
	try {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url+dbName, username, password);
		PreparedStatement ps = con.prepareStatement("INSERT INTO BOOK VALUES(?, ?, ?, ?, ?)");
		ps.setInt(1, bnum);
		ps.setString(2, title);
		ps.setString(3, author);
		ps.setString(4, publication);
		ps.setInt(5, price);
		ps.executeUpdate();
		out.print("Success!");
		
		RequestDispatcher rd = request.getRequestDispatcher("bookTitle.html");
		rd.forward(request, response);
	}
	catch(ClassNotFoundException e) {out.println("Class not found.");}
	catch(SQLException e) {out.println(e);}
	catch(Exception e){out.println("Exception in book.jsp.");
	}
%>
</body>
</html>