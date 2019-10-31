package no.hvl.dat108;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/paamelding")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DeltagerEAO eao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/paameldingskjema.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Paameldingsskjema paamelding = new Paameldingsskjema(request);

		if (paamelding.valideringGyldig() && !eao.eksisterendeMobil(request.getParameter("mobil"))) {

			Deltager deltager = paamelding.lagDeltager();
			eao.leggTil(deltager);

			InnloggingUtil.loggInn(request, deltager);
			request.getSession().removeAttribute("paamelding");
			response.sendRedirect("paameldingb?fornavn=");

		} else {

			paamelding.settOppFeilMeldinger();
			request.getSession().setAttribute("paamelding", paamelding);
			response.sendRedirect("paamelding");

		}

	}

}
