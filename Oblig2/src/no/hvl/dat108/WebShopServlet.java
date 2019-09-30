package no.hvl.dat108;

import static no.hvl.dat108.urlmappings.LOGOUT_URL;
import static no.hvl.dat108.urlmappings.WEBSHOP_URL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/" + WEBSHOP_URL)
public class WebShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Handleliste handleliste;

	public void init() throws ServletException {
		handleliste = new Handleliste();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesjon = request.getSession(false);
		if (!Validator.erInnlogget(request)) {
			response.sendRedirect("logginn?feilkode=2");
		} else {
			String passord = (String) sesjon.getAttribute("passord");

			response.setContentType("text/html; charset=ISO-8859-1");

			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<title>Handleliste</title>");
			out.println("</head>");
			out.println("<body>");

			out.println("<h1>Min handleliste</h1>");
			out.println("<form action=\"" + WEBSHOP_URL + "\" method=\"post\">");
			out.println("<p><input type=\"submit\" value=\"Legg til\" name=\"leggtil\"> "
					+ "<input type=\"text\" name=\"vare\"></p></form>");
			out.println("<br>");

			for (Varer vare : handleliste.getVarer()) {
				out.println("<form action =\"" + WEBSHOP_URL + "\" method =\"post\">");
				out.print("<p><input type=\"hidden\" name =\"slett\" value=\"" + handleliste.indexOf(vare) + "\">");
				out.print("<p><input type=\"submit\" value = \"Slett\" > ");
				out.println(vare.getNavn() + "</p></form>");
			}

			out.println("</form>");
			out.println("</body>");
			out.println("</html>");

		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesjon = request.getSession(false);
		if (!Validator.erInnlogget(request)) {
			response.sendRedirect("logginn?feilkode=3");
		} else {
			String vareinput = request.getParameter("vare");
			String slettVare = request.getParameter("slett");

			// slett vare
			if (slettVare != null) {
				int sletti = Integer.parseInt(Validator.escapeHtml(slettVare));
				synchronized (handleliste) {
					handleliste.slettVare(sletti);
					response.sendRedirect(WEBSHOP_URL);
				}
			} else {

				// legg til vare
				if (vareinput != null && !vareinput.isEmpty()) {

					String vareinputNY = Validator.escapeHtml(vareinput);
					if (vareinputNY.matches("^\\S(.*)$")) {
						synchronized (handleliste) {
							Varer vare = new Varer(vareinputNY);
							handleliste.leggTil(vare);
						}
					}

				}
				response.sendRedirect(WEBSHOP_URL);
			}
		}
	}
}
