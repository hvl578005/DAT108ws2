package no.hvl.dat108;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Validator {
	
	public static boolean erGyldig(String passord, String korrektPassord) {
		return passord != null && passord.equals(korrektPassord);
	}
	

	public static boolean erInnlogget(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		return (session != null)
				&& (session.getAttribute("innlogget") != null);
	}

	public static void loggInnMedTimeout(HttpServletRequest request, int timeoutISekunder) {
		loggUt(request);
		HttpSession sesjon = request.getSession(true);
		sesjon.setMaxInactiveInterval(timeoutISekunder);
		sesjon.setAttribute("passord", "passord");
    	sesjon.setAttribute("handleliste", new Handleliste());
    	sesjon.setAttribute("innlogget", "ja");
	}

	public static void loggUt(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}
	
	public static String escapeHtml (String s) {
		String resultat = s;
		resultat = resultat.replaceAll("<", "&lt;");
		resultat = resultat.replaceAll(">", "&gt;");
		resultat = resultat.replaceAll("\"", "&quot;");
		resultat = resultat.replaceAll("&", "&amp;");
		resultat = resultat.replaceAll(" ", "");
		return resultat;
	}
	
}
