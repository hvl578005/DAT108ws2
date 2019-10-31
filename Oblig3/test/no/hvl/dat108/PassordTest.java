package no.hvl.dat108;

import java.security.NoSuchAlgorithmException;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import javax.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;

public class PassordTest {

	PassordHash p = new PassordHash();
	Deltager d;

	@Test
	public void passordEqualHash() {

		byte[] salt = p.getSalt();
		String pass = "Katt12345";

		try {
			p.generateHashWithSalt(pass, salt);

			String passhash = p.getPasswordHashinHex();
			d.setPassordsalt(DatatypeConverter.printHexBinary(salt));
			d.setPassordhash(passhash);

			try {
				assertTrue(InnloggingUtil.validatePasswordWithSalt(pass, d));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

}
