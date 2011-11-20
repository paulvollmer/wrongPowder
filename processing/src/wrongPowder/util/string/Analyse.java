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
 * TextAnalyse class can return
 * - totalWords
 * - totalChars
 * - numSelectedChars
 * - numCharPair
 * - numSameWords
 * - smallestWord
 * - largestWord
 * - numUppercaseChars
 * - numLowercaseChars
 * 
 * @example config_basic 
 */
public class Analyse {
	
	PApplet p5;
	

	public String defaultDelimiters = " ,.?!;:[]";
	
	public String text;
	public int totalWords;
	public int totalChars;
	public int smallestWord;
	public int largestWord;
	  
	
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example config_basic
	 */
	public Analyse() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	/**
	 * Initailize a text array and save string to variable text.
	 *
	 * @param txt Filename
	 */
	public void init(String[] txt) {
		text = p5.join(txt, "");
	}
	
	/**
	 * Initailize a text and save string to variable text.
	 *
	 * @param txt Filename
	 */
	public void init(String txt) {
		text = txt;
	}
	
	
	
	
	
	/**
	 * Analyze
	 */
	public void analyse() {
		if(text == null) {
			System.out.println("no text");
			System.err.println("wrongPowder.util.string.TextAnalyse No text initialized. Use init(file) before you use analyse method");
		} else {
			analyse(text);
		}
	}
	
	/**
	 * Analyze
	 * 
	 * @param txt
	 */
	public void analyse(String txt) {
		System.out.println("Text: " + txt);
		System.out.println("Total words: " + totalWords(txt));
		System.out.println("Total chars: " + totalChars(txt));
	    /*for(int i=0; i<120; i++) {
	        println("Number of char "+": " + textAnalyse.numChar((char)i));
	    }*/
		System.out.println("Number of char pair: " + numCharPair(txt, "su"));
		System.out.println("Number of same words: " + numSameWords(txt, "Lorem"));
		System.out.println("smallestWord: " + smallestWord(txt));
	}
	
	
	
	
	public int totalWords() {
		return totalWords(text);
	}
	
	/**
	 * Return the number of words from variable text.
	 * This method split text with default delimiters.
	 *
	 * @return int Number of words.
	 */
	public int totalWords(String txt) {
		return totalWords(txt, defaultDelimiters);
	}
	  
	/**
	 * Return the number of words from variable text.
	 *
	 * @param String dlimit Default delimiters string.
	 * @return int Number of words.
	 */
	public int totalWords(String txt, String dlimit) {
		String[] index = p5.splitTokens(txt, dlimit);
		return index.length;
	}
	
	
	
	
	
	/**
	 * Return the total number of chars. Also include Space!
	 *
	 * @return int Number of chars.
	 */
	public int totalChars(String txt) {
		return text.length();
	}
	
	
	
	
	
	/**
	 * Return the number of a specific char from text.
	 *
	 * @return int Number of chars. If no char found, return -1
	 */
	public int numChar(String txt, char c) {
		// check if char exist. search the last char.
	    int index = text.lastIndexOf(c);
	    // if index = -1, no char exist.
	    if(index == -1) {
	    	System.out.println("no char found");
	    } else {
	    	// reset index to 0
	    	index = 0;
	    	// search a specific char
	    	for(int i=0; i<text.length(); i++) {
	    		if(text.charAt(i) == c) {
	    			//println(i);
	    			index++;
	    		}
	    	}
	    }
	    return index;
	 }
	  
	  
	  
	
	
	/**
	 * Char pair count (Bsp. ch=15)
	 */
	public int numCharPair(String txt, String chars) {
		return numSameWords(txt, chars);
	}
	  
	
	
	
	
	/**
	 * Number of Same Words
	 */
	public int numSameWords(String txt, String word) {
		String[] index = p5.split(txt, word);
	    return index.length-1;
	}
	  
	  
	
	
	  
	/**
	 * smallest word
	 */
	public int smallestWord(String txt) {
		// split text into string array
	    String[] tempText = p5.splitTokens(txt, defaultDelimiters);
	    
	    // variables to search smallest word
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
	 *
	public int largestWord(char[] c) {
	    return;
	}*/
	  
	
	  
	
	
	/**
	 * how many uppercase chars
	 *
	public int numUppercaseChars(char[] c) {
	    return;
	}*/
	  
	  
	
	
	
	/**
	 * how many lowercase chars
	 *
 	public int numLowercaseChars(char[] c) {
	    return;
	}*/
	  
	
	
	
	
	  // TODO:
	  // public int konsonants/vokals
	  // public int konsonants (baumhaus)


}