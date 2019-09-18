package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TempServlet
 */
@WebServlet("/temperatur")
public class TempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TempServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String temp = request.getParameter("temp");
		String convert = request.getParameter("convert");
		Double svar = 0.0;
		String svaar = "";
			
		
		if (ValidatorTemp.isValidTemp(temp) && ValidatorTemp.isValidNumber(temp, convert)) {
			if (convert.contains("cels") ) {
				Double tall = Double.parseDouble(temp);
				svar = (tall*1.8)+32;
				svaar = "<p>" + temp + "&#8451; = " + svar + "&#8457;"+ "</p>";
			} else if (convert.contains("fahr")) {
				Double tall = Double.parseDouble(temp);
				svar = (tall-32) / (1.8);
				svaar = "<p>" + temp + " &#8457; = " + svar + "&#8451;"+ "</p>";
			}
		} else {
				svaar = "Ugyldig brukerinput. Temperaturen må være et tall (lik eller over "
						+ "det absolutte nullpunkt). Pass også på at du har valgt en av omregningene"
						+ " før du trykket Regn om.";
		}
		
		
		response.setContentType("text/html; charset=ISO-8859-1"); 
		PrintWriter out = response.getWriter();
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">"); 
		out.println("<title>Temperaturomregning</title>"); 
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Temperaturomregning resultat</h1>");
		out.println("<h1>" + svaar + "</h1>");
		out.println("<a href=\"/lab17/tempp.html\">En gang til</a>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
