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
	
	// Tab width calculated with layoutWidth.
	private int tabWidth;
	
	public Tabs(PApplet parent) {
		p = parent;
	}
	

	/**
	 * Set the size (width) of tabs.
	 * For this, read the layoutWidth and calculate the tab size.
	 * @param num Number oftabs.
	 * @param x X position.
	 * @param y Y position.
	 * @param w Tab Bar width.
	 * @param h Tab Bar height.
	 */
	public void init(int num, int x, int y, int w, int h) {
		buttonX = x;
		buttonY = y;
		buttonWidth = w;
		buttonHeight = h;
		numTabs = num;
		tabWidth = w/num;
		System.out.println("numTabs: " + numTabs);
		System.out.println("tabWidth: " + tabWidth);
	}
		
	public void display() {
		for(int i=0; i<numTabs; i++) {
			//System.out.println("display tab "+i);
			// Set color
			p.noStroke();
			if(activeTab == i) {
				p.fill(50);
			} else {
				p.fill(30);
			}
			// Draw graphics
			p.rect(buttonX+i*tabWidth, buttonY, tabWidth-2, buttonHeight);
		}
		
	}
		
	public void mousePressed(int px, int py) {
		//System.out.println("mousePressed tab");
		for(int i=0; i<numTabs; i++) {
			if(wrongPowder.gui.Interaction.overRect(px, py, i*tabWidth+buttonX, buttonY, tabWidth-2, buttonHeight) == true) {
				activeTab = i;
			}
		}
	}
		
}