package q1b;

import java.sql.*;

public class q1b {
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "final";
		String username = "root";
		String password = "";
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url+dbName, username, password);
			System.out.println("Connected to the database.");
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("DROP TABLE DEPARTMENT");
			stmt.executeUpdate("CREATE TABLE DEPARTMENT(ID INTEGER, NAME VARCHAR(25), YEAR INTEGER, HNAME VARCHAR(25), ENUM INTEGER)");
			stmt.executeUpdate("INSERT INTO DEPARTMENT VALUES(1, 'CSE', 2010, 'HCSE', 150)");
			stmt.executeUpdate("INSERT INTO DEPARTMENT VALUES(2, 'ISE', 2010, 'HISE', 140)");
			stmt.executeUpdate("INSERT INTO DEPARTMENT VALUES(3, 'ECE', 1990, 'HECE', 130)");

			ResultSet rs = stmt.executeQuery("SELECT ENUM FROM DEPARTMENT WHERE NAME = 'CSE'");
			while(rs.next()) {
				System.out.print("Number of employees in CSE department: ");
				System.out.println(rs.getInt("ENUM"));
			}
	
			System.out.println("\n\nDetails of departments established in 2010: ");
			rs = stmt.executeQuery("SELECT * FROM DEPARTMENT WHERE YEAR = 2010");
			while(rs.next()) {
				System.out.println("\nDepartment ID: " + rs.getInt("ID"));
				System.out.println("Department name: " + rs.getString("NAME"));
				System.out.println("Year established: " + rs.getString("YEAR"));
				System.out.println("Head name: " + rs.getString("HNAME"));
				System.out.println("Number of employees: " + rs.getString("ENUM"));
			}
			
			con.close();
			System.out.println("Disconnected from the database.");
		}
		catch(ClassNotFoundException e) {e.printStackTrace();}
		catch(SQLException e) {e.printStackTrace();}
		catch(Exception e) {e.printStackTrace();}
	}
}