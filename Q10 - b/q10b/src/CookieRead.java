import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieRead")
public class CookieRead extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String pid = request.getParameter("id");
		
		Cookie[] cookies = request.getCookies();
		if(cookies==null)out.println("Welcome!");
		else {
			for(int i = 0; i<cookies.length; i++)
				if(cookies[i].getName().equals(name) && cookies[i].getValue().equals(pid))
					out.println("Welcome back, " + name + "!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}