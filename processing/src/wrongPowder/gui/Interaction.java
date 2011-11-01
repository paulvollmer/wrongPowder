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

package wrongPowder.gui;



//import


/**
 * Gui
 * 
 * @example config_basic 
 */
public class Interaction {
	
	//private static Logger logger = Logger.getRootLogger();
	
	

	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example config_basic
	 */
	public Interaction() {}
	
	
	
	/**
	 * boolean to set true if mouse is overRect,
	 * else it return false.
	 * @param px pointer x position
	 * @param px pointer x position
	 * @param x rect x position
	 * @param y rect y position
	 * @param w rect width
	 * @param h rect height
	 * @return status if over.
	 */
	public static boolean overRect(int px, int py, int x, int y, int w, int h) {
		System.out.println("overRect");
		if(px >= x && px <= x+w &&
		   py >= y && py <= y+h) {
			return true;
		} else {
			return false;
		}
	}
	
	
}