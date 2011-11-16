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
import processing.core.PImage;





/**
 * Gui
 * 
 * @example config_basic 
 */
public class IconButton extends Button {
	
	PApplet p5;
	
	public PImage imageOn;
	public PImage imageOff;
	
	
	
	
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
	 * Initialize method can be used to set Image on, off and
	 * x-, y-position.
	 * 
	 * @param imgOn Image for status on.
	 * @param imgOff Image for status off.
	 * @param x
	 * @param y
	 */
	public void init(PImage imgOn, PImage imgOff, int x, int y) {
		imageOn  = imgOn;
		imageOff = imgOff;
		super.init(x, y, imageOn.width, imageOn.height);
	}
	
	
	
	
	
	/**
	 * Draw the button rectangle.
	 */
	public void draw() {
		switch(status) {
		case 0:
			p5.image(imageOn, xpos, ypos);
			break;
		case 1:
			p5.image(imageOff, xpos, ypos);
			break;
		}
	}
	
	
	
	
	
	/**
	 * Check if mouse is clicked over button.
	 * 
	 * @param event The processing mouseEvent.
	 */
	public void mousePressed(int mx, int my) {
		toggle(mx, my);
	}
	
	
}