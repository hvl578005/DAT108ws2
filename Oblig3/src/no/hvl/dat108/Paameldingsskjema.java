package no.hvl.dat108;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

public class Paameldingsskjema {

	private String fornavn;
	private String fornavnFeil;
	private String etternavn;
	private String etternavnFeil;
	private String mobil;
	private String mobilFeil;
	private String passord;
	private String passordFeil;
	private String passordr;
	private String passordrf;
	private String passordsalt;
	private String kjonn;
	private String kjonnFeil;
	private String mann;
	private String kvinne;

	public Paameldingsskjema(HttpServletRequest request) {
		this.fornavn = request.getParameter("fornavn");
		this.etternavn = request.getParameter("etternavn");
		this.mobil = request.getParameter("mobil");
		this.passord = request.getParameter("passord");
		this.passordr = request.getParameter("rpassord");
		this.kjonn = request.getParameter("kjonn");
	}

	public boolean valideringGyldig() {

		return DeltagerValidering.erGyldigFornavn(fornavn) && DeltagerValidering.erGyldigEtternavn(etternavn)
				&& DeltagerValidering.erGyldigMobil(mobil) && DeltagerValidering.erGyldigPassord(passord)
				&& DeltagerValidering.repetertPassord(passord, passordr) && kjonnGyldig();

	}

	public Deltager lagDeltager() {

		// ---------------HASHING---------------------------//

		PassordHash passordh = new PassordHash("SHA-256");
		byte[] passords = passordh.getSalt();

		try {
			passordh.generateHashWithSalt(passord, passords);
			System.out.println("hashet");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		passordsalt = (DatatypeConverter.printHexBinary(passords));
		passord = passordh.getPasswordHashinHex();

		// --------------HASHING FERDIG------------------------//

		return new Deltager(fornavn, etternavn, mobil, passord, passordsalt, kjonn);
	}

	public void checker() {
		if (kjonn != null) {
			if (kjonn.equals("kvinne")) {
				kvinne = "checked";
			} else {
				mann = "checked";
			}
		}
	}

	private boolean kjonnGyldig() {
		if (kjonn != null) {
			checker();
			return true;
		} else {
			return false;
		}
	}

	public void settOppFeilMeldinger() {

		if (!DeltagerValidering.erGyldigFornavn(fornavn)) {
			fornavn = "";
			fornavnFeil = "Ugyldig fornavn";
		}

		if (!DeltagerValidering.erGyldigEtternavn(etternavn)) {
			etternavn = "";
			etternavnFeil = "Ugyldig etternavn";
		}

		if (!DeltagerValidering.erGyldigMobil(mobil)) {
			mobil = "";
			mobilFeil = "Ugyldig mobilnr";
		}

		if (!DeltagerValidering.erGyldigPassord(passord)) {
			passord = "";
			passordFeil = "Ugyldig passord";
		}

		if (!DeltagerValidering.repetertPassord(passord, passordr)) {
			passordr = "";
			passordrf = "Ikke like passord";
		}

		if (!kjonnGyldig()) {
			kjonn = "";
			kjonnFeil = "Velg en av kjønnene";
		}

	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getFornavnFeil() {
		return fornavnFeil;
	}

	public void setFornavnFeil(String fornavnFeil) {
		this.fornavnFeil = fornavnFeil;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getEtternavnFeil() {
		return etternavnFeil;
	}

	public void setEtternavnFeil(String etternavnFeil) {
		this.etternavnFeil = etternavnFeil;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getMobilFeil() {
		return mobilFeil;
	}

	public void setMobilFeil(String mobilFeil) {
		this.mobilFeil = mobilFeil;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getPassordFeil() {
		return passordFeil;
	}

	public void setPassordFeil(String passordFeil) {
		this.passordFeil = passordFeil;
	}

	public String getPassordr() {
		return passordr;
	}

	public void setPassordr(String passordr) {
		this.passordr = passordr;
	}

	public String getPassordrf() {
		return passordrf;
	}

	public void setPassordrf(String passordrf) {
		this.passordrf = passordrf;
	}

	public String getKjonn() {

		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	public String getKjonnFeil() {
		return kjonnFeil;
	}

	public void setKjonnFeil(String kjonnFeil) {
		this.kjonnFeil = kjonnFeil;
	}

	public String getMann() {
		return mann;
	}

	public void setMann(String mann) {
		this.mann = mann;
	}

	public String getKvinne() {
		return kvinne;
	}

	public void setKvinne(String kvinne) {
		this.kvinne = kvinne;
	}

}
