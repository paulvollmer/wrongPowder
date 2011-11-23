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

import java.io.BufferedReader;
import java.io.InputStream;

import processing.core.PApplet;
import wrongPowder.io.Reader;





/**
 * DudenAnalyse class will help
 * 
 * @example config_basic 
 */
public class DudenAnalyse {
	
	PApplet p5;
	Reader reader;
	
	public String[] sourcecode;
	
	public String wordtype;
	public String frequency;
	public String worttrennung;
	public String herkunft;
	
	
	
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example config_basic
	 */
	public DudenAnalyse(PApplet p) {
		p5 = p;
		reader = new Reader(p);
	}
	
	
	
	
	
	/**
	 * Initailize a text array and save string to variable text.
	 *
	 * @param txt Filename
	 */
	public void search(String url) {
		System.out.println("Start searching duden.de");		  
	}
	
	
	public void checkWord(String word) {
		// Load the sourcecode
		String tempSourcecode = reader.load("http://www.duden.de/rechtschreibung/"+word);
		//System.out.println(tempSourcecode);
		
		wordtype = htmlParse(tempSourcecode, "wortart\">", 2, "<");
		frequency = htmlParse(tempSourcecode, "frequenzklasse_", 1, "\">");
		worttrennung = htmlParse(tempSourcecode, "Worttrennung:</dt><dd class=\"content\">", 1, "</dd>");
		herkunft = htmlParse(tempSourcecode, "Herkunft</a></h2><dl><dd class=\"content\">", 1, "</dd></dl></div>");
	}




	/**
	 * 
	 * @param content The content to parse
	 * @param keyIn The String to begin parsing.
	 * @param a Set the array iterator of the parsed temp string.
	 * @param keyOut
	 * @return Parsed string content.
	 */
	public String htmlParse(String content, String keyIn, int a, String keyOut) {
		String finalParse = "Not available";
		
		String[] tempParse1 = p5.split(content, keyIn);
		/*System.out.println("\nKEYIN\n");
		for (int i = 0; i < tempParse1.length; i++) {
			System.out.println("["+i+"]\t"+tempParse1[i]);
		}*/
		
		String[] tempParse2 = p5.split(tempParse1[a], keyOut);
		/*System.out.println("\nKEYOUT\n");
		for (int i = 0; i < temp2.length; i++) {
			System.out.println("["+i+"]\t"+temp2[i]);
		}*/
		
		finalParse = tempParse2[0];
		return finalParse;
	}
	
	

}