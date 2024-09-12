import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class CryptoManagerTestStudent {

	@Test
	public void testIsStringInBounds() {
		
		assertTrue(CryptoManager.isStringInBounds("HELLO"));
		assertTrue(CryptoManager.isStringInBounds("HE123LLO  1!+/\\"));
		assertFalse(CryptoManager.isStringInBounds("`HELLO"));
		assertFalse(CryptoManager.isStringInBounds("HELLo"));
		assertFalse(CryptoManager.isStringInBounds("HE{LL~"));
	}

	@Test 
	public void testCaesarEncryption() {
		
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("HELLoo", 3));
		assertEquals("LIPPS", CryptoManager.caesarEncryption("HELLO", 4));
		assertEquals("(SQQP", CryptoManager.caesarEncryption("H3110", 96));
		assertEquals("UUG!U!!\"RXYZU4YOU!!\"VP", CryptoManager.caesarEncryption(".. :.::;+123.M2(.::;/)", 999));
		assertEquals("(%,,/@02/&%33/2@'2).\"%2'", CryptoManager.caesarEncryption("HELLO PROFESSOR GRINBERG", 160));
		assertEquals("JTZJ'97:'98;><", CryptoManager.caesarEncryption("CMSC 203 21475", 7));
	}

	@Test
	public void testCaesarDecryption() {
		
		assertEquals(".. :.::;+123.M2(.::;/)", CryptoManager.caesarDecryption("UUG!U!!\"RXYZU4YOU!!\"VP", 999));
		assertEquals("HELLO PROFESSOR GRINBERG", CryptoManager.caesarDecryption("(%,,/@02/&%33/2@'2).\"%2'", 160));
		assertEquals("CMSC 203 21475", CryptoManager.caesarDecryption("JTZJ'97:'98;><", 7));
		assertEquals("H3110", CryptoManager.caesarDecryption("(SQQP", 96));
	}

	@Test
	public void testBellasoEncryption() {
		
		assertEquals("KR_OAOCU\\YHECBU-ZU;>5H_Z$", CryptoManager.bellasoEncryption("HELLO_PROFESSOR GRINBERG!", "CMSC203"));
		assertEquals("S_\"I7CF", CryptoManager.bellasoEncryption("CMSC203", "PROFESSOR GRINBERG"));
		assertEquals("XT[\\_/&_\"[S;;/", CryptoManager.bellasoEncryption("HELLO WORLD++ ", "POOP"));
	}

	@Test
	public void testBellasoDecryption() {
		
		assertEquals("HELLO_PROFESSOR GRINBERG!", CryptoManager.bellasoDecryption("KR_OAOCU\\YHECBU-ZU;>5H_Z$", "CMSC203"));
		assertEquals("CMSC203", CryptoManager.bellasoDecryption("S_\"I7CF", "PROFESSOR GRINBERG"));
		assertEquals("HELLO WORLD++ ", CryptoManager.bellasoDecryption("XT[\\_/&_\"[S;;/", "POOP"));
		
	}
}
