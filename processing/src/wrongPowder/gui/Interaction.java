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


/**
 * Gui
 * 
 * @example config_basic 
 */
public class Interaction {
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example config_basic
	 */
	public Interaction() {}
	
	
	
	/**
	 * Boolean to set true if mouse is overRect,
	 * else it return false.
	 * 
	 * @param px Pointer x position
	 * @param py Pointer x position
	 * @param x Rectangle x position
	 * @param y Rectangle y position
	 * @param w Rectangle width
	 * @param h Rectangle height
	 * @return Status if over.
	 */
	public static boolean overRect(int px, int py, int x, int y, int w, int h) {
		//System.out.println("overRect");
		if(px >= x && px <= x+w &&
		   py >= y && py <= y+h) {
			return true;
		} else {
			return false;
		}
	}
	
	
}