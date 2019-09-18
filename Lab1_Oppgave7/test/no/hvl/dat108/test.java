package no.hvl.dat108;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import no.hvl.dat108.ValidatorTemp;

public class test {

	private ValidatorTemp validator = new ValidatorTemp();
	
	@Test
	public void nullStringIsInvalid() {
		assertFalse(validator.isValidTemp(null));
	}
	
	@Test
	public void emptyStringIsInvalid() {
		assertFalse(validator.isValidTemp(""));
	}
	
	@Test
	public void lettersIsInvalid() {
		assertFalse(validator.isValidTemp("heihei28"));
	}
	
	@Test
	public void numberIsInvalidFahr() {
		assertFalse(validator.isValidNumber("-1000", "fahr"));
	}
	
	@Test
	public void numberIsInvalidCels() {
		assertFalse(validator.isValidNumber("-1000", "cels"));
	}
	
	@Test
	public void celsiusIsValid() {
		assertTrue(validator.isValidNumber("20", "cels"));
	}
	
	@Test
	public void fahrenheitIsValid() {
		assertTrue(validator.isValidNumber("20", "fahr"));
	}
	
	@Test
	public void containsOnlyDigits() {
		assertTrue(validator.isValidTemp("123"));
	}
	
	@Test
	public void aFewMore() {
		assertFalse(validator.isValidTemp("27 h i"));
	}
	
	
}
