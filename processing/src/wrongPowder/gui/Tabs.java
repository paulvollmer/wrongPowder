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
public class Tabs extends GuiRect {
	
	private PApplet p5;
	
	public int numTabs;
	public int activeTab = 0;
	//private PushButton[] tabButton;
	
	
	
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example gui_tabs
	 */
	public Tabs(PApplet p) {
		p5 = p;
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
		numTabs = num;
		
		/*tabButton = new PushButton[num];
		
		for(int i=0; i<num; i++) {
			tabButton[i] = new PushButton(p5);
			// Tab width calculated with layoutWidth.
			tabButton[i].init(x+i*w/num, y, w/num, h);
		}
		
		// Set first tab to activeTab.
		tabButton[activeTab].status = 0;*/
		
		super.init(x, y, w/num, h);
		
	}
	
	
	/**
	 * Draw tabs.
	 */
	public void draw() {
		for(int i=0; i<numTabs; i++) {
			//tabButton[i].draw();
			
			// Set color
			p5.noStroke();
			if(activeTab == i) {
				p5.fill(Button.colorOn);
			} else {
				p5.fill(Button.colorOff);
			}
			// Draw graphics
			p5.rect(xpos+i*width, ypos, width-2, height);
		}
		
	}
	
	
	/**
	 * Mouse pressed methode.
	 * 
	 * @param mx Pointer x position
	 * @param my Pointer y position
	 */
	public void mousePressed(int mx, int my) {
		for(int i=0; i<numTabs; i++) {
			/*if(Interaction.overRect(mx, my, tabButton[i].xpos, tabButton[i].ypos, tabButton[i].width-2, tabButton[i].height) == true) {
				activeTab = i;
				System.out.println("active tab " + activeTab);
				tabButton[activeTab].status = 0;
			} else {
				tabButton[i].status = 1;
			}*/
			
			if(Interaction.overRect(mx, my, i*width+xpos, ypos, width-2, height) == true) {
				activeTab = i;
			}
		}
	}
	
	
}