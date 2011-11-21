package wrongPowder.test.util.string.analyze;

import static org.junit.Assert.*;

import org.junit.Test;

import wrongPowder.util.string.Analyse;

public class TestAnalyze {

	/*@Test
	public void testAnalyse() {
		fail("Not yet implemented");
	}

	@Test
	public void testInitStringArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testInitString() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintAnalyse() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintAnalyseString() {
		fail("Not yet implemented");
	}*/
	
	
	
	
	
	@Test
	public void testGetWordsString() {
		String txt = "hallo world";
		Analyse textAnalyse = new Analyse();
		
		assertEquals("Result", 2, textAnalyse.getWords(txt, " "));
	}
	
	
	
	
	
	@Test
	public void testGetChars() {
		String txt = "hallo world";
		Analyse textAnalyse = new Analyse();
		
		assertEquals("Result", 11, textAnalyse.getChars(txt));
	}
	
	
	
	
	
	@Test
	public void testGetSmallestWord() {
		String txt = "hallo world ha";
		Analyse textAnalyse = new Analyse();
		
		assertEquals("Result", 2, textAnalyse.getSmallestWord(txt));
	}

	@Test
	public void testGetLargestWord() {
		String txt = "hallooha world ha";
		Analyse textAnalyse = new Analyse();
		
		assertEquals("Result", 8, textAnalyse.getLargestWord(txt));
	}
	
	
	
	
	
	@Test
	public void testGetNumUppercase() {
		String txt = "Hallo World";
		Analyse textAnalyse = new Analyse();
		
		assertEquals("Result", 2, textAnalyse.getNumUppercase(txt));
	}

	@Test
	public void testGetNumLowercase() {
		String txt = "hALLO wORLD";
		Analyse textAnalyse = new Analyse();
		
		assertEquals("Result", 2, textAnalyse.getNumLowercase(txt));
	}
	
	
	
	
	
	@Test
	public void testGetNumVowel() {
		String txt = "hAllO world";
		Analyse textAnalyse = new Analyse();
		
		assertEquals("Result", 3, textAnalyse.getNumVowel(txt));
	}

	@Test
	public void testGetNumUppercaseVowel() {
		String txt = "hAllO world";
		Analyse textAnalyse = new Analyse();
		
		assertEquals("Result", 2, textAnalyse.getNumUppercaseVowel(txt));
	}

	@Test
	public void testGetNumLowercaseVowel() {
		String txt = "hallo wOrld";
		Analyse textAnalyse = new Analyse();
		
		assertEquals("Result", 2, textAnalyse.getNumLowercaseVowel(txt));
	}
	
	
	
	
	
	@Test
	public void testGetNumConsonants() {
		String txt = "Hallo World";
		Analyse textAnalyse = new Analyse();
		
		assertEquals("Result", 7, textAnalyse.getNumConsonants(txt));
	}

	@Test
	public void testGetNumUppercaseConsonants() {
		String txt = "Hallo World";
		Analyse textAnalyse = new Analyse();
		
		assertEquals("Result", 2, textAnalyse.getNumUppercaseConsonants(txt));
	}

	@Test
	public void testGetNumLowercaseConsonants() {
		String txt = "hallo world";
		Analyse textAnalyse = new Analyse();
		
		assertEquals("Result", 7, textAnalyse.getNumLowercaseConsonants(txt));
	}
	
	
	
	
	// Method is checked by getNumSameWords!
	/*@Test
	public void testGetNumCharStringChar() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumCharStringString() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void testGetNumCharStringInt() {
		String txt = "hallo world";
		Analyse textAnalyse = new Analyse();

		assertEquals("Result", 1, textAnalyse.getNumChar(txt, 97));
	}
	
	
	
	
	
	@Test
	public void testGetNumCharSet() {
		String txt = "HALLO world ABC";
		Analyse textAnalyse = new Analyse();

		int[] chars = {65, 66};
		assertEquals("Result", 3, textAnalyse.getNumCharSet(txt, chars));
	}
	
	
	
	
	// Also checked by getNumSameWords!
	@Test
	public void testGetNumCharPair() {
		String txt = "hallo world hallo";
		Analyse textAnalyse = new Analyse();

		String chars = "ha";
		assertEquals("Result", 2, textAnalyse.getNumCharPair(txt, chars));
	}
	
	
	
	
	
	@Test
	public void testGetNumSameWords() {
		String txt = "hallo world hallo";
		Analyse textAnalyse = new Analyse();
		
		assertEquals("Result", 2, textAnalyse.getNumSameWords(txt, "hallo"));
	}
	
	
}
