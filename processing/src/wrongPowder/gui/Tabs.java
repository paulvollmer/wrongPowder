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


import processing.core.PApplet;



/**
 * Gui
 * 
 * @example config_basic 
 */
public class Tabs extends Button {
	
	private PApplet p;
	
	public int numTabs;
	public int activeTab = 0;
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example gui_tabs
	 */
	public Tabs(PApplet parent) {
		p = parent;
	}
	

	/**
	 * Set the size of tabs.
	 * For this, read the width and calculate the tab size.
	 * 
	 * @param num Number oftabs.
	 * @param x X position.
	 * @param y Y position.
	 * @param w Tab Bar width.
	 * @param h Tab Bar height.
	 */
	public void init(int num, int x, int y, int w, int h) {
		buttonX = x;
		buttonY = y;
		// Tab width calculated with layoutWidth.
		buttonWidth = w/num;
		buttonHeight = h;
		numTabs = num;
	}
	
	
	/**
	 * Display tabs.
	 */
	public void display() {
		for(int i=0; i<numTabs; i++) {
			// Set color
			p.noStroke();
			if(activeTab == i) {
				p.fill(buttonColorOn);
			} else {
				p.fill(buttonColorOff);
			}
			// Draw graphics
			p.rect(buttonX+i*buttonWidth, buttonY, buttonWidth-2, buttonHeight);
		}
		
	}
	
	
	/**
	 * Mouse pressed methode.
	 * 
	 * @param px Pointer x position
	 * @param py Pointer y position
	 */
	public void mousePressed(int px, int py) {
		for(int i=0; i<numTabs; i++) {
			if(Interaction.overRect(px, py, i*buttonWidth+buttonX, buttonY, buttonWidth-2, buttonHeight) == true) {
				activeTab = i;
			}
		}
	}
	
	
}