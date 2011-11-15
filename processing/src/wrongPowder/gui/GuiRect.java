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
 * A Class to store variables for GUI like position and size.
 */
public class GuiRect {
	
	public int xpos;
	public int ypos;
	public int width;
	public int height;
	
	
	
	
	
	/**
	 * GuiRect class can be used to store x-, y-position.
	 * 
	 * @param x X position.
	 * @param y Y position.
	 */
	public void init(int x, int y) {
		xpos = x;
		ypos = y;
	}
	
	
	
	
	
	/**
	 * GuiRect class can be used to store x-, y-position, width and height.
	 * 
	 * @param x X position.
	 * @param y Y position.
	 * @param w Width
	 * @param h Height
	 */
	public void init(int x, int y, int w, int h) {
		xpos = x;
		ypos = y;
		width = w;
		height = h;
	}
	
	
}