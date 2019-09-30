package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hei")
public class Hei extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private String replaceAll(String s) {
    	
    	String result = s;
    	
    	result = result.replaceAll("<", "&lt;");
    	result = result.replaceAll(">", "&gt;");
    	result = result.replaceAll("\"", "&quot;");
    	result = result.replaceAll("&", "&amp;");
    
    	return result;
    }
 
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		String navn = request.getParameter("navn");
		navn = replaceAll(navn);
		String melding = "";
		
		
		String acceptLanguage = request.getHeader("Accept-Language");
		
		if (acceptLanguage.contains("no") || acceptLanguage.contains("nb")) {
			melding = "God dag";
		} else if (acceptLanguage.contains("de")) {
			melding = "Guten tag";
		} else {
			melding = "Hello"; 
		}
		
		response.setContentType("text/html; charset=ISO-8859-1"); 
		PrintWriter out = response.getWriter();
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">"); 
		out.println("<title>Heihei</title>"); 
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + melding + " " + navn + "!</h1>");
		out.println("</body>");
		out.println("</html>");
	
	}

	

}
