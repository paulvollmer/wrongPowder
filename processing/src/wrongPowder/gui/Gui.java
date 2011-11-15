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


import java.awt.event.MouseEvent;
import processing.core.PApplet;





/**
 * Gui
 * 
 * @example gui_basic 
 */
public class Gui {
	
	PApplet p5;
	
	Panel panel;
	PushButton button;
	Tabs tabs;
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example config_basic
	 */
	public Gui(PApplet p) {
		p5 = p;
		p5.registerDraw(this);
		p5.registerMouseEvent(this);
		//p5.registerKeyEvent(this);
		
		panel  = new Panel(p5);
		button = new PushButton(p5);
		tabs = new Tabs(p5);
		panel.init(100, 250, 150, 200);
		button.init(0, 100, 200, 50, 20);
		tabs.init(5, 0, 0, p5.width, 40);
	}
	
	
	
	
	
	public void draw() {
		panel.draw();
		button.draw();
		tabs.draw();
	}
	
	
	
	
	
	/**
	 * Check if mouse is clicked over button.
	 * 
	 * @param event The processing mouseEvent.
	 */
	public void mouseEvent(MouseEvent event) {
		// get the x and y pos of the event
		int x = event.getX();
		int y = event.getY();
		
		switch (event.getID()) {
		case MouseEvent.MOUSE_PRESSED:
			System.out.println("MOUSE_PRESSED");
			panel.mousePressed(x, y);
			button.mousePressed(x, y);
			tabs.mousePressed(x, y);
			break;
		
		case MouseEvent.MOUSE_RELEASED:
			System.out.println("MOUSE_RELEASED");
			break;
		
		case MouseEvent.MOUSE_CLICKED:
			//System.out.println("MOUSE_CLICKED");
			break;
		
		case MouseEvent.MOUSE_DRAGGED:
			//System.out.println("MOUSE_DRAGGED");
			break;
		
		case MouseEvent.MOUSE_MOVED:
			//System.out.println("MOUSE_MOVED");
			break;
		}
		
	}
	
	
}