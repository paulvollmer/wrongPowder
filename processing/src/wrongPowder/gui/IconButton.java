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


import processing.core.*;





/**
 * Gui
 * 
 * @example config_basic 
 */
public class IconButton extends Button {
	
	PApplet p5;
	PImage imageOn;
	
	
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example gui_basic
	 */
	public IconButton(PApplet p) {
		p5 = p;
	}
	
	
	
	
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public void init(PImage img, int x, int y) {
		// TODO debug this.
		super.init(x, y, img.width, img.height);
		imageOn = img;
	}
	
	
	
	
	
	/**
	 * Draw the button rectangle.
	 */
	public void draw() {
		p5.image(imageOn, xpos, ypos);
	}
	
	
	
	
	
	/**
	 * Check if mouse is clicked over button.
	 * 
	 * @param event The processing mouseEvent.
	 */
	public void mousePressed(int mx, int my) {
		System.out.println("ICON BUTTON CLICKED status ");
	}
	
	
}