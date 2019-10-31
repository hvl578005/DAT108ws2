package no.hvl.dat108;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DeltagerListeServlet")
public class DeltagerListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerEAO deltagerEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (InnloggingUtil.erInnlogget(request)) {
			// request.getSession().setAttribute("liste",
			// deltagerEAO.hentUtAlleDeltagerene());

			String mobil = (String) request.getSession().getAttribute("mobil");

			List<Deltager> liste = deltagerEAO.hentUtAlleDeltagerene();
			liste = liste.stream().sorted(Comparator.comparing(Deltager::getEtternavn))
					.sorted(Comparator.comparing(Deltager::getFornavn)).collect(Collectors.toList());

			request.getSession().setAttribute("liste", liste);
			request.getSession().setAttribute("mobil", mobil);
			request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);

		} else {

			response.sendRedirect("logginn?hacking=");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
