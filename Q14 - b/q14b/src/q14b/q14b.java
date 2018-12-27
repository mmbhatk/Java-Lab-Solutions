package q14b;

import java.util.*;
import java.sql.*;

public class q14b {
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "final";
		String username = "root";
		String password = "";
		
		Scanner scan = new Scanner(System.in);
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url+dbName, username, password);
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Only for the purpose of running the program multiple times
			stmt.executeUpdate("UPDATE STUDENT SET CGPA=8.5 WHERE NAME='John'");
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENT WHERE CGPA<9");
			System.out.println("\nStudents with CGPA less than 9: ");
			while(rs.next()) {
				if(rs.getDouble(3)<9) {
					System.out.println("\nStudent ID: " + rs.getInt(1));
					System.out.println("Student name: " + rs.getString(2));
					System.out.println("Student CGPA: " + rs.getDouble(3));
				}
			}
			
			System.out.println("\nUpdating John's CGPA from 8.5 to 9.4.");
			rs.first();
			
			while(rs.next()) {
				if(rs.getString(2).equals("John")) {
					//Updating in ResultSet
					rs.updateDouble(3, 9.4);
					//Updating in table
					rs.updateRow();
				}
			}
			
			System.out.println("\nJohn's details are:");
			rs.first();
			
			while(rs.next()) {
				if(rs.getString(2).equals("John")) {
					System.out.println("\nStudent ID: " + rs.getInt(1));
					System.out.println("Student name: " + rs.getString(2));
					System.out.println("Student CGPA: " + rs.getDouble(3));
				}
			}
		}
		catch(Exception e) {e.printStackTrace();};
	}
}