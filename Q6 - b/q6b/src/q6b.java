import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/q6b")
public class q6b extends HttpServlet {
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
			PreparedStatement ps = con.prepareStatement("INSERT INTO EMPLOYEE VALUES(?, ?, ?, ?)");
			ps.setString(1, request.getParameter("id"));
			ps.setString(2, request.getParameter("name"));
			ps.setString(3, request.getParameter("address"));
			ps.setString(4, request.getParameter("dob"));
			ps.executeUpdate();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
			out.println("<table><tr><th>ID</th><th>Name</th><th>Address</th><th>DOB</th></tr>");
			
			while(rs.next()) {
				out.println("<tr><td>" + rs.getInt("ID") + "</td>");
				out.println("<td>" + rs.getString("NAME") + "</td>");
				out.println("<td>" + rs.getString("ADDR") + "</td>");
				out.println("<td>" + rs.getString("DOB") + "</td></tr>");
			}
			
			out.println("</table>");
		}
		catch(Exception e) {out.println(e);}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}