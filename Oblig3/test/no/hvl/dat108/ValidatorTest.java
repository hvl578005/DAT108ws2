package no.hvl.dat108;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

	@Test
	public void GyldigFornavn() {
		assertTrue(DeltagerValidering.erGyldigFornavn("Kaia"));
		assertTrue(DeltagerValidering.erGyldigFornavn("Kate Iren"));
		assertTrue(DeltagerValidering.erGyldigFornavn("Mila-Ka"));
		assertTrue(DeltagerValidering.erGyldigFornavn("Anne-Marie"));
		assertTrue(DeltagerValidering.erGyldigFornavn("Åse"));

	}

	@Test
	public void UgyldigFornavn() {
		assertFalse(DeltagerValidering.erGyldigFornavn("A"));
		assertFalse(DeltagerValidering.erGyldigFornavn("a"));
		assertFalse(DeltagerValidering.erGyldigFornavn("lara"));
		assertFalse(DeltagerValidering.erGyldigFornavn("mina lisa"));
		assertFalse(DeltagerValidering.erGyldigFornavn("4800"));
		assertFalse(DeltagerValidering.erGyldigFornavn("48mona"));
		assertFalse(DeltagerValidering.erGyldigFornavn("Kaia Margerte Espedal Lien Hansen"));
		assertFalse(DeltagerValidering.erGyldigFornavn("Ka7a"));
		assertFalse(DeltagerValidering.erGyldigFornavn("Mania 7346"));
	}

	@Test
	public void GyldigMobil() {
		assertTrue(DeltagerValidering.erGyldigMobil("12345678"));
		assertTrue(DeltagerValidering.erGyldigMobil("46694148"));

	}

	@Test
	public void UgyldigMobil() {
		assertFalse(DeltagerValidering.erGyldigMobil("1234567"));
		assertFalse(DeltagerValidering.erGyldigMobil("1234567i"));
		assertFalse(DeltagerValidering.erGyldigMobil("abcdefgh"));
		assertFalse(DeltagerValidering.erGyldigMobil("123"));
		assertFalse(DeltagerValidering.erGyldigMobil("123 5678"));
	}

	@Test
	public void GyldigEtternavn() {
		assertTrue(DeltagerValidering.erGyldigEtternavn("Hermansen"));
		assertTrue(DeltagerValidering.erGyldigEtternavn("Nilsen"));
		assertTrue(DeltagerValidering.erGyldigEtternavn("Brimso-Bjerk"));
		assertTrue(DeltagerValidering.erGyldigEtternavn("Are"));
	}

	@Test
	public void UgyldigEtternavn() {
		assertFalse(DeltagerValidering.erGyldigEtternavn("hermansen"));
		assertFalse(DeltagerValidering.erGyldigEtternavn("nils1en"));
		assertFalse(DeltagerValidering.erGyldigEtternavn("Brimso Bjerk"));
		assertFalse(DeltagerValidering.erGyldigEtternavn("hermi j"));
	}

	@Test
	public void gyldigPassord() {
		assertTrue(DeltagerValidering.erGyldigPassord("A1234567"));
		assertTrue(DeltagerValidering.erGyldigPassord("Katt1234"));
		assertTrue(DeltagerValidering.erGyldigPassord("KattheiFamilie-9"));
	}

	@Test
	public void uGyldigPassord() {
		assertFalse(DeltagerValidering.erGyldigPassord("passo"));
		assertFalse(DeltagerValidering.erGyldigPassord("1234567"));
		assertFalse(DeltagerValidering.erGyldigPassord("hei hei"));
	}

	@Test
	public void likePassord() {
		assertTrue(DeltagerValidering.repetertPassord("A1234567", "A1234567"));
		assertTrue(DeltagerValidering.repetertPassord("Katt1234", "Katt1234"));
		assertTrue(DeltagerValidering.repetertPassord("KattheiFamilie-9", "KattheiFamilie-9"));
	}

	@Test
	public void ugyldigulikePassord() {
		assertFalse(DeltagerValidering.repetertPassord("12345678a", "12345678aA"));
		assertFalse(DeltagerValidering.repetertPassord("passo", "passo"));

	}

}
