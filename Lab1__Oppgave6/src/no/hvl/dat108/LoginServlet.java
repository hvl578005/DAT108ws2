package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brukernavn = request.getParameter("username");
		String passord = request.getParameter("password");
		StringBuffer login = request.getRequestURL();
		
		response.setContentType("text/html; charset=ISO-8859-1"); 
		PrintWriter out = response.getWriter();
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">"); 
		out.println("<title>Login result</title>"); 
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Login result</h1>");
		out.println("<p>Logged in from: " + login + "</p>"); 
		out.println("<p>Username: " + brukernavn + "</p>");
		out.println("<p>Password: " + passord + "</p>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	
	
	
	
	
	
	
	
}
