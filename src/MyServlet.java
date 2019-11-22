import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/MyServlet", urlPatterns = { "/MyServlet" })

public class MyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public MyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter wr = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String HTMLResponse = "Username: " + username +"<br/> Password: " + password;
	
		wr.append(HTMLResponse);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		String htmlResponse = "<!DOCTYPE html> <html> <head> <title>Benvenuto</title> </head> <body>";

		if (username == null || username.trim().isEmpty()) {
			htmlResponse += "Non hai inserito l'username";

		} else if (password == null || password.trim().isEmpty()) {
			htmlResponse += "Non hai inserito la password";
			
		} else {
			htmlResponse += "Benvenuto " + username + ".\r\n <br />" + "La tua password è: " + password + ".\r\n";
		}

		htmlResponse += "</body> \r\n </html>";
		response.getWriter().append(htmlResponse);
	}

}
