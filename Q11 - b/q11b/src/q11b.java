import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/q11b")
public class q11b extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "final";
		String username = "root";
		String password = "";
		
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url+dbName, username, password);
			Statement stmt = con.createStatement();
			
			//Only for the purpose of showing the updation while running the program multiple times
			stmt.executeUpdate("UPDATE SUBJECTS SET SUB_ID=2, SUB_NAME='Physics' WHERE FACULTY_ID=102");
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM SUBJECTS");
			out.println("<br><h3>Records before updating the details:</h3>");
			out.println("<table><tr><td>Subject ID</td><td>Subject</td><td>Faculty ID</td></tr>");
			
			while(rs.next()) {
				out.println("<tr><td>" + rs.getInt("SUB_ID") + "</td>");
				out.println("<td>" + rs.getString("SUB_NAME") + "</td>");
				out.println("<td>" + rs.getInt("FACULTY_ID") + "</td></tr>");
			}
			
			out.println("</table>");
			out.println("<br>Updating details for faculty with faculty ID 102.");
			
			stmt.executeUpdate("UPDATE SUBJECTS SET SUB_ID=3, SUB_NAME='Chemistry' WHERE FACULTY_ID=102");
			out.println("<br><h3>Records after updating the details:</h3>");
			rs = stmt.executeQuery("SELECT * FROM SUBJECTS");
				
			out.println("<table><tr><td>Subject ID</td><td>Subject</td><td>Faculty ID</td></tr>");
			
			while(rs.next()) {
				out.println("<tr><td>" + rs.getInt("SUB_ID") + "</td>");
				out.println("<td>" + rs.getString("SUB_NAME") + "</td>");
				out.println("<td>" + rs.getInt("FACULTY_ID") + "</td></tr>");
			}	
			out.println("</table>");
		}
		catch(Exception e) {out.println(e);}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}