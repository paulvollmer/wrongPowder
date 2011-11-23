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
 * Parser
 * 
 * @example parse_basic 
 */
public class Parser {
	
	PApplet p5;
	
	
	
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example parse_basic
	 */
	public Parser() {//PApplet p) {
		//p5 = p;
	}
	
	
	
	
	
	/**
	 * Parse a string
	 *
	 * @param scr String to parse
	 * @param keyIn The String to begin parsing.
	 * @param keyOut
	 * @param a Set the array iterator of the parsed temp string.
	 * @return Parsed string content.
	 */
	public String parse(String src, String keyIn, String keyOut, int a) {
		System.out.println("Start searching duden.de");	
		
		String finalParse = "Not available";
		
		String[] tempParse1 = p5.split(src, keyIn);
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