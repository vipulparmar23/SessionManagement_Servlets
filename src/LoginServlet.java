

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		request.getRequestDispatcher("Link.html").include(request, response);
		
		String name = request.getParameter("uname");
		String password = request.getParameter("pwd");
		
		
		if(password.equals("admin123")) {
			pw.println("You are successfully logged in");
			pw.println("Welcome "+name);
		
			Cookie cookie = new Cookie("name", name);
			response.addCookie(cookie);
			
		}else {
			pw.println("Sorry! wrong username or password");
			request.getRequestDispatcher("Login.html").include(request, response);
		}
	
		pw.close();
	}

}
