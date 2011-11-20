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
public class TextAnalyse {
	
	PApplet p5;
	
	public String text;
	private String defaultDelimiters = " ,.?!;:[]";
	//private String delimiters;
	  
	  
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example config_basic
	 */
	public TextAnalyse() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Initailize a text array and save string to variable text.
	 *
	 * @param txt Filename
	 */
	void init(String[] txt) {
		text = p5.join(txt, "");
	}
	
	/**
	 * Initailize a text and save string to variable text.
	 *
	 * @param txt Filename
	 */
	void init(String txt) {
		text = txt;
	}
	  
	  
	void analyse() {
		System.out.println("Text: " + text);
		System.out.println("Total words: " + totalWords());
		System.out.println("Total chars: " + totalChars());
	    /*for(int i=0; i<120; i++) {
	        println("Number of char "+": " + textAnalyse.numChar((char)i));
	    }*/
		System.out.println("Number of char pair: " + numCharPair("su"));
		System.out.println("Number of same words: " + numSameWords("Lorem"));
		System.out.println("smallestWord: " + smallestWord());
	}
	  
	/**
	 * Return the number of words from variable text.
	 * This method split text with default delimiters.
	 *
	 * @return int Number of words.
	 */
	int totalWords() {
		return totalWords(defaultDelimiters);
	}
	  
	/**
	 * Return the number of words from variable text.
	 *
	 * @param String dlimit Default delimiters string.
	 * @return int Number of words.
	 */
	int totalWords(String dlimit) {
		String[] index = p5.splitTokens(text, dlimit);
		return index.length;
	}
	  
	  
	  
	/**
	 * Return the total number of chars. Also include Space!
	 *
	 * @return int Number of chars.
	 */
	int totalChars() {
		return text.length();
	}
	  
	/**
	 * Return the number of a specific char from text.
	 *
	 * @return int Number of chars. If no char found, return -1
	 */
	int numChar(char c) {
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
	int numCharPair(String chars) {
		return numSameWords(chars);
	}
	  
	/**
	 * Number of Same Words
	 */
	int numSameWords(String word) {
		String[] index = p5.split(text, word);
	    return index.length-1;
	}
	  
	  
	  
	/**
	 * smallest word
	 */
	int smallestWord() {
		// split text into string array
	    String[] tempText = p5.splitTokens(text, defaultDelimiters);
	    
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
	int largestWord(char[] c) {
	    return;
	}*/
	  
	  
	  
	/**
	 * how many uppercase chars
	 *
	int numUppercaseChars(char[] c) {
	    return;
	  }*/
	  
	  
	  
	  /**
	   * how many lowercase chars
	   *
	  int numLowercaseChars(char[] c) {
	    return;
	  }*/
	  
	  
	  // TODO:
	  // konsonants/vokals
	  // konsonants (baumhaus)
}
