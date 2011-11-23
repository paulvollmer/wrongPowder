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
import wrongPowder.util.string.Parser;





/**
 * DudenAnalyse class will help
 * 
 * @example config_basic 
 */
public class DudenAnalyse {
	
	PApplet p5;
	Reader reader;
	Parser parse = new Parser();
	
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
		
		wordtype = parse.parse(tempSourcecode, "wortart\">", "<", 2);
		frequency = parse.parse(tempSourcecode, "frequenzklasse_", "\">", 1);
		worttrennung = parse.parse(tempSourcecode, "Worttrennung:</dt><dd class=\"content\">", "</dd>", 1);
		herkunft = parse.parse(tempSourcecode, "Herkunft</a></h2><dl><dd class=\"content\">", "</dd></dl></div>", 1);
	}
	

}