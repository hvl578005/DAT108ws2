package no.hvl.dat108;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logginn")
public class LogginnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DeltagerEAO eao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String loginMessage = "";

		if (request.getParameter("ugyldigBrukernavn") != null) {
			loginMessage = "Ugyldig brukernavn og/eller passord.";
		} else if (request.getParameter("hacking") != null) {
			loginMessage = "Du må logge inn først!!!";
		}

		request.setAttribute("loginMessage", loginMessage);

		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");

		if (eao.finnDeltagerMedID(mobil) == null) {
			response.sendRedirect("logginn?ugyldigBrukernavn=");
		} else {

			Deltager d = eao.finnDeltagerMedID(mobil);
			try {
				if (InnloggingUtil.validatePasswordWithSalt(passord, d)) {
					InnloggingUtil.loggInn(request, d);
					response.sendRedirect("DeltagerListeServlet");
				} else {
					response.sendRedirect("logginn?ugyldigBrukernavn=");
				}

			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				response.sendRedirect("logginn");
			}

		}

	}

}
