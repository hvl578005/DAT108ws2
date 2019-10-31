package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/leggtil")
public class LeggTilStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	StudentEAO studentEAO;

	//Jeg burde *absolutt* brukt doPost her, men da måtte jeg
	//laget en html-side med en <form> for å kjøre den.
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		Student s = new Student();
		s.setId("3456789");
		s.setNavn("Donald");
		studentEAO.leggTilStudent(s, "17hData");
		
	}

}
