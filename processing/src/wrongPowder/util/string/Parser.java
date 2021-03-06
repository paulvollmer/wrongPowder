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
	
	
	
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example parse_basic
	 */
	public Parser() {}
	
	
	
	
	
	/**
	 * Parse a string
	 *
	 * @param scr String to parse
	 * @param keyIn The String to begin parsing.
	 * @param keyOut
	 * @param a Set the array iterator of the parsed temp string.
	 * @return Parsed string content.
	 */
	public static String getString(String src, String keyIn, String keyOut, int a) {
		System.out.println("Start String parser");	
		
		String finalParse = "Not available";
		
		String[] tempParse1 = PApplet.split(src, keyIn);
		/*System.out.println("\nKEYIN\n");
		for (int i = 0; i < tempParse1.length; i++) {
			System.out.println("["+i+"]\t"+tempParse1[i]);
		}*/
		
		String[] tempParse2 = PApplet.split(tempParse1[a], keyOut);
		/*System.out.println("\nKEYOUT\n");
		for (int i = 0; i < temp2.length; i++) {
			System.out.println("["+i+"]\t"+temp2[i]);
		}*/
		
		finalParse = tempParse2[0];
		return finalParse;
	}
	
	public static int getInt(String src, String keyIn, String keyOut, int a) {
		return Integer.parseInt(getString(src, keyIn, keyOut, a));
	}
	
	public static float getFloat(String src, String keyIn, String keyOut, int a) {
		return Float.parseFloat(getString(src, keyIn, keyOut, a));
	}
	
	
}