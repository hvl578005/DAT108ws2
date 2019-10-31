package no.hvl.dat108;

public class DeltagerValidering {

	public static boolean erGyldigFornavn(String fornavn) {

		if (fornavn == null) {
			return false;
		}

		return fornavn.matches("^[A-ZÆØÅ][a-zæøåA-ZÆØÅ -]{2,20}$");
	}

	public static boolean erGyldigMobil(String mobil) {

		return mobil.matches("^[0-9]{8}$");
	}

	public static boolean erGyldigEtternavn(String etternavn) {

		if (etternavn == null) {
			return false;
		}

		return etternavn.matches("^[A-ZÆØÅ][a-zæøåA-ZÆØÅ-]*{2,20}$");
	}

	public static boolean erGyldigPassord(String passord) {

		if (passord == null) {
			return false;
		}

		return passord.matches("^[a-zA-Z0-9_-]{8,20}+$");

	}

	public static boolean repetertPassord(String passord, String repetert) {

		if (passord == null) {
			return false;
		}

		return passord.equals(repetert) && erGyldigPassord(repetert);

	}

}
