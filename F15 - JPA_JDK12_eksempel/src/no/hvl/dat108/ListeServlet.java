package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/liste")
public class ListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	StudentEAO studentEAO;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		String klassekode = request.getParameter("klassekode");
		
		List<Student> liste = studentEAO.hentKlasselisteFor(klassekode);
		
		response.setContentType("text/plain");
		
		PrintWriter out = response.getWriter();
		
		liste.forEach(out::println);
	}
}
