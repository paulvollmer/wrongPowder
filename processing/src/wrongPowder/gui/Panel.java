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
 * @example gui_basic 
 */
public class Panel extends Button {
	
	PApplet p5;
	
	public int barColor = 0xFF6D6D6D;
	public int barSize = 20;
	public int backgroundColor = 0xFF3F3F3F;
	
	public String message;
	private Checkbox minimize;
	
	
	
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example gui_basic
	 */
	public Panel(PApplet p) {
		p5 = p;
		minimize = new Checkbox(p5);
	}
	
	public Panel(PApplet p, int x, int y, int w, int h) {
		p5 = p;
		minimize = new Checkbox(p5);
		init(x, y, w, h);
	}
	
	
	
	
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public void init(int x, int y, int w, int h) {
		super.init(x, y, w, h);
		minimize.init(x+5, y+5);
	}
	
	
	
	
	
	/**
	 * Draw the panel.
	 */
	public void draw() {
		drawGround();
		minimize.draw();
	}
	
	public void draw(String m) {
		drawGround();
		minimize.draw(m);
	}
	
	private void drawGround() {
		switch(minimize.status) {
		case(0):
			p5.noStroke();
			p5.fill(backgroundColor);
			p5.rect(xpos, ypos, width, height);
			
			// Draw a line to separate the panelbar.
			p5.stroke(barColor);
			p5.noFill();
			p5.line(xpos, ypos+barSize, xpos+width, ypos+barSize);
			break;
		
		case(1):
			p5.noStroke();
			p5.fill(barColor);
			p5.rect(xpos, ypos, width, barSize);
			break;
		}
	}
	
	
	
	
	
	public void mousePressed(int mx, int my) {
		minimize.mousePressed(mx, my);
	}
	
	
}