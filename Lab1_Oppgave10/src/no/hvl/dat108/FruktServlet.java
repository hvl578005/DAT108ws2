package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/stemmehjelp")
public class FruktServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FruktServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String frukt = request.getParameter("frukt");
		int epstem = 0;
		int pastem = 0;
		int kistem = 0;
		int bastem = 0;
		
		if (frukt.contains("eple")) {
			epstem++;
		} else if (frukt.contains("pare")) {
			pastem++;
		}else if (frukt.contains("kiwi")) {
			kistem++;
		} else if (frukt.contains("banan")) {
			bastem++;
		}
		
		response.setContentType("text/html; charset=ISO-8859-1"); 
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">"); 
		out.println("<title>Favorittfrukt resultat</title>"); 
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Favorittfrukt resultat</h1>");
		out.println("<p>Eple: " + epstem + "</p>");
		out.println("<p>P&aelig;re: " + pastem + "</p>");
		out.println("<p>Kiwi: " + kistem + "</p>");
		out.println("<p>Banan: " + bastem + "</p>");
		out.println("<a href=\"/lab10/stemmehjelp.html\">En gang til</a>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
