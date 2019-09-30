package no.hvl.dat108;

import static no.hvl.dat108.urlmappings.WEBSHOP_URL;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LogginnServlet", urlPatterns = "/logginn")
public class LogginnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String passord;
	int tid;

	public void init() throws ServletException {
		passord = getServletConfig().getInitParameter("passord");
		tid = Integer.parseInt(getServletConfig().getInitParameter("tid"));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String txt = "Gi inn passord:";

		String feilkode = request.getParameter("feilkode");
		String feilmelding = "";

		if (feilkode != null) {
			if (feilkode.equals("1")) {
				txt = "Passordet du ga inn var feil. Prøv igjen:";
			} else if (feilkode.equals("2")) {
				txt = "Du må logge inn først!!!";
			} else if (feilkode.equals("3")) {
				feilmelding = "Du har blitt logget ut.";
			}
		}

		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Login</title>");
		out.println("</head>");
		out.println("<body>");

		if (feilkode != null) {
			if (feilkode.equals("3")) {
				out.println("<p style=\"color:red;\">" + feilmelding + "</p>");
			}
		}

		out.println("<form action=\"" + "logginn" + "\" method=\"post\">");
		out.println("<fieldset>");
		out.println("<p>" + txt + "<br><input type=\"password\" name=\"passord\" /></p>");
		out.println("<p><input type=\"submit\" value=\"Logg inn\" /></p>");
		out.println("</fieldset>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String password = request.getParameter("passord");
		String feilkode = request.getParameter("feilkode");

		if (!Validator.erGyldig(password, passord)) {
			response.sendRedirect("logginn?feilkode=1");

		} else {
			Validator.loggInnMedTimeout(request, tid);
			response.sendRedirect(WEBSHOP_URL);
		}
	}

}
