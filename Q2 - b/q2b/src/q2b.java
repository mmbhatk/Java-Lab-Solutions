import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/q2b")
public class q2b extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "final";
		String username = "root";
		String password = "";
		
		Integer choice = Integer.parseInt(request.getParameter("choice"));
		String val = request.getParameter("val");
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url+dbName, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs;
			
			if(choice==1) {
				String query = "SELECT * FROM POLICESTATION WHERE AREA = '" + val + "'";
				rs = stmt.executeQuery(query);
			}
			else {
				String query = "SELECT * FROM POLICESTATION WHERE PHONE = " + val;
				rs = stmt.executeQuery(query);	
			}
			
			int present = 0;
			while(rs.next()) {
				out.println("ID: " + rs.getInt("ID"));
				out.println("Area: " + rs.getString("AREA"));
				out.println("Phone: " + rs.getString("PHONE"));
				present = 1;
			}
			
			if(present==0) out.println("Record not found.");
			con.close();
		}
		catch(Exception e) {out.println(e);}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}