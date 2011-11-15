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
public class Checkbox extends Button {
	
	PApplet p5;
	
	public  int size = 10;
	
	
	
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example gui_basic
	 */
	public Checkbox(PApplet p) {
		p5 = p;
	}
	
	
	
	
	
	public void init(int x, int y) {
		super.init(x, y, size, size);
	}
	
	
	
	
	
	/**
	 * Draw the checkbox.
	 */
	public void draw() {
		p5.noStroke();
		p5.fill(color);
		p5.rect(xpos, ypos, size, size);
	}
	
	/**
	 * Draw the button rectangle.
	 */
	public void draw(String message) {
		draw();
		
		p5.fill(255);
		p5.textSize(11);
		//float tWidth = p5.textWidth(message);
		p5.text(message, xpos+width+5, ypos+height);
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