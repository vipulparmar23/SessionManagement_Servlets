
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();

		request.getRequestDispatcher("Link.html").include(request, response);

		Cookie ck[] = request.getCookies();

		if (ck != null) {
			String name = ck[0].getValue();
			if (!name.equals("") || name != null) {
				pw.println("<b>Welcome to profile</b>");
				pw.println("<br>welcome " + name);
			}
		} else {
			pw.println("Please login first");
			request.getRequestDispatcher("Login.html").include(request, response);
		}
		pw.close();
	}

}
