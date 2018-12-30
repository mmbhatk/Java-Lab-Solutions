import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCookies")
public class GetCookies extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("Reading the cookies.<br>");
		
		Cookie[] cookies = request.getCookies();
		String name = "", value = "";
		
		out.println("<table><tr><td>Key</td><td>Value</td></tr>");
		
		for(int i = 0; i<cookies.length; i++) {
			name = cookies[i].getName();
			value = cookies[i].getValue();
			out.println("<tr><td>" + name + "</td><td>" + value + "</td></tr>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}