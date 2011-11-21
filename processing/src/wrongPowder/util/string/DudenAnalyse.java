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

import java.io.InputStream;

import processing.core.PApplet;





/**
 * DudenAnalyse class will help
 * 
 * @example config_basic 
 */
public class DudenAnalyse {
	
	PApplet p5;
	
	public String[] sourcecode;
	
	
	
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example config_basic
	 */
	public DudenAnalyse(PApplet p) {
		p5 = p;
	}
	
	
	
	
	
	/**
	 * Initailize a text array and save string to variable text.
	 *
	 * @param txt Filename
	 */
	public void search(String url) {
		System.out.println("Start searching duden.de");		  
	}
	
	
	public void rechtschreibung(String url) {
		System.out.println("Start searching duden.de/rechtschreibung");
		
		// Load sourcecode
		sourcecode = p5.loadStrings(url);
		// Console out sourcecode
		for (int i = 0; i < sourcecode.length; i++) {
			//System.out.println("["+i+"]\n"+sourcecode[i]);
		}
		
		// Search sourcecode for 
		String wortartTemp = htmlParse(sourcecode[13], "wortart\">", "wortart\">");
		/*String[] wortartTemp = p5.split(sourcecode[13], "wortart\">");
		// Console out sourcecode
		for (int i = 0; i < wortartTemp.length; i++) {
			//System.out.println("["+i+"]\n"+wortartTemp[i]);
		}*/
		
		//String wortart = wortartTemp[2];
		System.out.println("################################### wortart: "+wortartTemp);
		
		
		
		
	}





	private String htmlParse(String content, String keyIn, String keyOut) {
		String[] temp = p5.split(content, keyIn);
		// Console out sourcecode
		for (int i = 0; i < temp.length; i++) {
			System.out.println("["+i+"]\n"+temp[i]);
		}
		
		String[] temp2 = p5.split(temp[2], "<");
		for (int i = 0; i < temp2.length; i++) {
			System.out.println("["+i+"]\n"+temp2[i]);
		}
		
		String finalParse = temp2[0];
		return finalParse;
	}
	
	

}