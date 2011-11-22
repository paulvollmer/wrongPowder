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

package wrongPowder.io;

import java.io.BufferedReader;

import processing.core.PApplet;
import wrongPowder.io.Log;





/**
 * Reader
 * 
 * @example reader_basic 
 */
public class Reader {
	
	PApplet p5;
	
	// Logger Variable.
	Log log = new Log();
	
	
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example log_basic
	 */
	public Reader(PApplet p) {
		p5 = p;
	}
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example reader_basic
	 * @param fileName
	 */
	public Reader(PApplet p, String fileName) {
		p5 = p;
		
		read(fileName);
	}
	
	
	
	
	/**
	 * Initialize  filae.
	 * 
	 * @param path File path.
	 */
	public String read(String path) {
		log.info("start reading");
		log.info("path "+path);
		
		String temp = "";
		
		BufferedReader reader = p5.createReader(path);
		
		try {
			String line;
			// save each line to sourcecode variable
			while ((line = reader.readLine()) != null) {
			    temp = temp+line;
			    //System.out.println(line);
			}
			
			log.init("File ready");
			
		}
		catch (Exception e) {
			//e.printStackTrace(); 
			log.init(path+" No wordtype available ");
			
		}
		
		return temp;
	}


}