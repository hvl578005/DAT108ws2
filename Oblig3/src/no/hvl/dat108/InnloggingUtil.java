package no.hvl.dat108;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

public class InnloggingUtil {

	public static boolean erInnlogget(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return (session != null) && (session.getAttribute("innlogget") != null);
	}

	public static void loggInn(HttpServletRequest request, Deltager d) {
		loggUt(request);
		HttpSession sesjon = request.getSession(true);
		request.getSession().setAttribute("fornavn", d.getFornavn());
		request.getSession().setAttribute("etternavn", d.getEtternavn());
		request.getSession().setAttribute("mobil", d.getMobil());
		request.getSession().setAttribute("passordhash", d.getPassordhash());
		request.getSession().setAttribute("passordsalt", d.getPassordsalt());
		request.getSession().setAttribute("kjonn", d.getKjonn());
		sesjon.setAttribute("innlogget", "ja");
	}

	public static void loggUt(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

	public static boolean validatePasswordWithSalt(String password, Deltager d) throws NoSuchAlgorithmException {

		PassordHash p = new PassordHash("SHA-256");

		String hashedPassword = d.getPassordhash();
		String salt = d.getPassordsalt();

		byte[] saltbytes = DatatypeConverter.parseHexBinary(salt); // convert to hex format

		p.generateHashWithSalt(password, saltbytes); // call the generate method

		boolean equal = p.getPasswordHashinHex().equalsIgnoreCase(hashedPassword); // compare the hashed password and
																					// the plaintext
		// password
		return equal;

	}

}
