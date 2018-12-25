import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/q3b")
public class q3b extends HttpServlet {
	
	public String initials(String name) {
		//Ignoring multiple consecutive spaces
		String[] names = name.split("\\s+");
		String initial = "";
		for(int i = 0; i<names.length; i++)
			initial+=names[i].toUpperCase().charAt(0);
		return initial;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		out.println("The initials are: " + initials(name));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}