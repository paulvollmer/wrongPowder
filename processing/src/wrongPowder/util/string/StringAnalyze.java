/**
 *  wrongPowder is developed by wrong-entertainment & powder
 *
 *
 *  Copyright 2011 Paul Vollmer & Tim Pulver
 *  paulvollmer.net
 *  vollmerpaul@yahoo.de
 *  timpulver.de
 *  pulver.tim@googlemail.com
 * 
 *  This file is part of wrongPowder library.
 *
 *  wrongPowder is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with wrongPowder. If not, see <http://www.gnu.org/licenses/>.
 * 
 *  @author		##author##
 *  @modified	##date##
 *  @version	##version##
 */

package wrongPowder.util.string;

import processing.core.PApplet;





/**
 * TextAnalyse class will help you analyze text input.
 * It return totalWords, totalChars, smallestWord, largestWord etc.
 * 
 * @example config_basic 
 */
public class StringAnalyze {
	
	PApplet p5;
	
	public String text                 = "No text available.";
	public String defaultDelimiters    = " ,.?!;:[]";
	public int totalWords              = -1;
	public int totalChars              = -1;
	public int smallestWord            = -1;
	public int largestWord             = -1;
	public int numUppercaseChars       = -1;
	public int numLowercaseChars       = -1;
	public int numVowel                = -1;
	public int numUppercaseVowel       = -1;
	public int numLowercaseVowel       = -1;
	public int numConsonants           = -1;
	public int numUppercaseConsonants  = -1;
	public int numLowercaseConsonants  = -1;
	
	
	
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example config_basic
	 */
	public StringAnalyze() {}
	
	
	
	
	
	/**
	 * Initailize a text array and save string to variable text.
	 *
	 * @param txt Filename
	 */
	public void init(String[] txt) {
		init(p5.join(txt, ""));
	}
	
	/**
	 * Initailize a text and save string to variable text.
	 *
	 * @param txt Filename
	 */
	public void init(String txt) {
		text                   = txt;
		totalWords             = getWords(txt);
		totalChars             = getChars(txt);
		smallestWord           = getSmallestWord(txt);
		largestWord            = getLargestWord(txt);
		numUppercaseChars      = getNumUppercase(txt);
		numLowercaseChars      = getNumLowercase(txt);
		numVowel               = getNumVowel(txt);
		numUppercaseVowel      = getNumUppercaseVowel(txt);
		numLowercaseVowel      = getNumLowercaseVowel(txt);
		numConsonants          = getNumConsonants(txt);
		numUppercaseConsonants = getNumUppercaseConsonants(txt);
		numLowercaseConsonants = getNumLowercaseConsonants(txt);
	}
	
	
	
	
	
	/**
	 * Analyze
	 */
	public void printAnalyse() {
		if(text == null) {
			System.err.println("wrongPowder.util.string.TextAnalyse No text initialized. Use init(file) before you use analyse method");
		} else {
			printAnalyse(text);
		}
	}
	
	/**
	 * Analyze
	 * 
	 * @param txt
	 */
	public void printAnalyse(String txt) {
		System.out.println("Text:                      " + txt);
		System.out.println("Total words:               " + getWords(txt));
		System.out.println("Total chars:               " + getChars(txt));
		System.out.println("Smallest word:             " + getSmallestWord(txt));
		System.out.println("Largest word:              " + getLargestWord(txt));
		System.out.println("getNumUppercase:           " + getNumUppercase(txt));
		System.out.println("getNumLowercase:           " + getNumLowercase(txt));
		System.out.println("getNumVowel:               " + getNumVowel(txt));
		System.out.println("getNumUppercaseVowel:      " + getNumUppercaseVowel(txt));
		System.out.println("getNumLowercaseVowel:      " + getNumLowercaseVowel(txt));
		System.out.println("getNumConsonants:          " + getNumConsonants(txt));
		System.out.println("getNumUppercaseConsonants: " + getNumUppercaseConsonants(txt));
		System.out.println("getNumLowercaseConsonants: " + getNumLowercaseConsonants(txt));
		
		// Get num of char ascii char 32 to 127
		for(int i=32; i<127; i++) {
			System.out.println("getNumChar " + (char)i + ":              " + getNumChar(txt, i));
		}
		
		String[] tempWords = p5.splitTokens(txt, defaultDelimiters);
		for(int i=0; i<tempWords.length; i++) {
			System.out.println("getNumSameWords " + tempWords[i] + ":          " + getNumSameWords(txt, tempWords[i]));
		}
		
		/*System.out.println("getNumChar:                " + getNumChar(txt, "B"));
		System.out.println("getNumChar ASCII:          " + getNumChar(txt, 67));
		System.out.println("getNumCharPair:            " + getNumCharPair(txt, "he"));
		System.out.println("getNumSameWords:           " + getNumSameWords(txt, "hello"));*/
	}
	
	
	
	
	
	/**
	 * Return the number of words from variable text.
	 * This method split text with default delimiters.
	 *
	 * @return int Number of words.
	 */
	public int getWords(String txt) {
		return getWords(txt, defaultDelimiters);
	}
	  
	/**
	 * Return the number of words from variable text.
	 *
	 * @param String dlimit Default delimiters string.
	 * @return int Number of words.
	 */
	public int getWords(String txt, String dlimit) {
		String[] index = p5.splitTokens(txt, dlimit);
		return index.length;
	}
	
	
	
	
	
	/**
	 * Return the total number of chars. Also include Space!
	 *
	 * @return int Number of chars.
	 */
	public int getChars(String txt) {
		return txt.length();
	}
	
	
	
	
	
	/**
	 * smallest word
	 */
	public int getSmallestWord(String txt) {
		// split text into string array
	    String[] tempText = p5.splitTokens(txt, defaultDelimiters);
	    
	    // variables to set the length of the biggest word.
	    int index = 10000;
	    int tempIndex;
	    
	    for(int i=0; i<tempText.length; i++) {
	    	//println(tempText[i].length());
	    	tempIndex = tempText[i].length();
	    	if(index > tempIndex) index = tempIndex;
	    }
	    
	    return index;
	}





	/**
	 * largest word
	 */
	public int getLargestWord(String txt) {
		// split text into string array
	    String[] tempText = p5.splitTokens(txt, defaultDelimiters);
	    
	    // variables to search smallest word
	    int index = 0;
	    int tempIndex;
	    
	    for(int i=0; i<tempText.length; i++) {
	    	//println(tempText[i].length());
	    	tempIndex = tempText[i].length();
	    	if(index < tempIndex) index = tempIndex;
	    }
	    
	    return index;
	}





	public int getNumUppercase(String txt) {
		int caps = 0;
	    for (int i=0; i<txt.length(); i++) {
	        if (Character.isUpperCase(txt.charAt(i))) {
	        	caps++;
	        }
	    }
		return caps;
	}





	public int getNumLowercase(String txt) {
		int caps = 0;
	    for (int i=0; i<txt.length(); i++) {
	        if (Character.isLowerCase(txt.charAt(i))) {
	        	caps++;
	        }
	    }
		return caps;
	}





	/**
	 * Vowel
	 * 
	 * @param txt
	 * @return
	 */
	public int getNumVowel(String txt) {
		// ascii value: A, E, I, O, U,
		//              a, e, i, o, u
		int[] asciiVowel = {65,  69,  73,  79,  85,
				            97, 101, 105, 111, 117};
		return getNumCharSet(txt, asciiVowel);
	}
	
	public int getNumUppercaseVowel(String txt) {
		// ascii value: A, E, I, O, U
		int[] asciiVowel = {65, 69, 73, 79, 85};
		return getNumCharSet(txt, asciiVowel);
	}
	
	public int getNumLowercaseVowel(String txt) {
		// ascii value: a, e, i, o, u
		int[] asciiVowel = {97, 101, 105, 111, 117};
		return getNumCharSet(txt, asciiVowel);
	}



	/**
	 * 
	 * @param txt
	 * @return
	 */
	public int getNumConsonants(String txt) {
		// ascii value: B, C, D, F, G, H, J, K, L, M, N, P, Q, R, S, T, V, X, Z, W, Y,
		//              b, c, d, f, g, h, j, k, l, m, n, p, q, r, s, t, v, w, x, y, z
		int[] asciiVowel = {/*A 65*/ 66, 67,  68,  /*E 69*/  70,  71,  72, /*I 73*/   74,  75,  76,  77,
				            78, /*O 79*/   80,  81,  82,  83,  84, /*U 85*/   86,  87,  88,  89,  90,
				            /*a 97*/ 98, 99, 100, /*e 101*/ 102, 103, 104, /*i 105*/ 106, 107, 108, 109,
				            110, /*o 111*/ 112, 113, 114, 115, 116, /*u 117*/ 118, 119, 120, 121, 122};
		return getNumCharSet(txt, asciiVowel);
	}
	
	public int getNumUppercaseConsonants(String txt) {
		// ascii value: B, C, D, F, G, H, J, K, L, M, N, P, Q, R, S, T, V, X, Z, W, Y
		int[] asciiVowel = {/*A 65*/ 66, 67,  68,  /*E 69*/  70,  71,  72, /*I 73*/   74,  75,  76,  77,
				            78, /*O 79*/   80,  81,  82,  83,  84, /*U 85*/   86,  87,  88,  89,  90};
		return getNumCharSet(txt, asciiVowel);
	}
	
	public int getNumLowercaseConsonants(String txt) {
		// ascii value: b, c, d, f, g, h, j, k, l, m, n, p, q, r, s, t, v, w, x, y, z
		int[] asciiVowel = {/*a 97*/ 98, 99, 100, /*e 101*/ 102, 103, 104, /*i 105*/ 106, 107, 108, 109,
				            110, /*o 111*/ 112, 113, 114, 115, 116, /*u 117*/ 118, 119, 120, 121, 122};
		return getNumCharSet(txt, asciiVowel);
	}





	/**
	 * Return the number of a specific char from text.
	 *
	 * @return int Number of chars. If no char found, return -1
	 */
	public int getNumChar(String txt, char c) {
		return getNumSameWords(txt, ""+c);
	 }
	
	public int getNumChar(String txt, String chars) {
		return getNumSameWords(txt, chars);
	}
	
	public int getNumChar(String txt, int ascii) {
		String temp ="";
		for(int i=0; i<txt.length(); i++) {
			char thisChar = txt.charAt(i);
		    if (thisChar == ascii) temp += thisChar;
		}
		return temp.length();
	}
	
	
	
	
	
	public int getNumCharSet(String txt, int[] ascii) {
		int temp = 0;
		for(int i=0; i<ascii.length; i++) {
			int tempNum = getNumChar(txt, ascii[i]);
			//System.out.println("get the Number of char "+(char)asciiVowel[i]+": "+tempNum);
			
			if(tempNum != 0) {
				temp += tempNum;
				//System.out.println("char "+(char)asciiVowel[i]+" num "+getNumChar(txt, asciiVowel[i]));
			}
		}
		
		return temp;
	}
	
	
	
	
	
	/**
	 * Char pair count (Bsp. ch=15)
	 */
	public int getNumCharPair(String txt, String chars) {
		return getNumSameWords(txt, chars);
	}
	  
	
	
	
	// TODO fix bug.
	/**
	 * Number of Same Words
	 */
	public int getNumSameWords(String txt, String word) {
		String[] index = p5.split(txt, word);
	    return index.length-1;
	}
	


}