import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetCookies")
public class SetCookies extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Creating six cookies.<br><br>");
		
		Cookie c1 = new Cookie("First", "1");
		Cookie c2 = new Cookie("Second", "2");
		Cookie c3 = new Cookie("Third", "3");
		Cookie c4 = new Cookie("Fourth", "4");
		Cookie c5 = new Cookie("Fifth", "5");
		Cookie c6 = new Cookie("Sixth", "6");
		
		c4.setMaxAge(3600);
		c5.setMaxAge(3600);
		c6.setMaxAge(3600);
		
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		response.addCookie(c4);
		response.addCookie(c5);
		response.addCookie(c6);
		
		out.println("Successfully created six cookies.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}