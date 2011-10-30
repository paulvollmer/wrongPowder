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

package wrongPowder.touchosc;


import processing.core.*;



public class Layout extends File {
	
	// TouchOsc control color variables.
	public static int RED_ON     = 0xFFFF0000;
	public static int RED_OFF    = 0xFFFF0000;
	public static int GREEN_ON   = 0xFF00FF00;
	public static int GREEN_OFF  = 0xFF00FF00;
	public static int BLUE_ON    = 0xFF00D8D7;
	public static int BLUE_OFF   = 0xFF00D8D7;
	public static int YELLOW_ON  = 0xFFFFFF00;
	public static int YELLOW_OFF = 0xFFFFFF00;
	public static int PURPLE_ON  = 0xFFDC00FF;
	public static int PURPLE_OFF = 0xFFDC00FF;
	public static int GRAY_ON    = 0xFFD6D6D6;
	public static int GRAY_OFF   = 0xFFD6D6D6;
	public static int ORANGE_OFF = 0xFFFFB700;
	public static int ORANGE_ON  = 0xFFFFB700;
	
	private int layoutWidth;
	private int layoutHeight;
	private int tabWidth;
	private int tabActive = 0;
	
	private control[] ctrl;
	
	private PApplet p;
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 */
	public Layout(PApplet p) {
		this.p = p;
	}
	
	
	public void init() {
		//System.out.println("Start init");
		
		// Check mode of the file. 0 = iPhone/iPod-Touch and 1 = iPad.
		// Check orientation, set the size and store it to layoutWidth,
		// layoutHeight variable.
		if(wrongPowder.touchosc.File.mode() == 0) {
			if(wrongPowder.touchosc.File.orientation().equals("horizontal")) {
				layoutWidth = 360;
				layoutHeight = 480;
			}
			if(wrongPowder.touchosc.File.orientation().equals("vertical")) {
				layoutWidth = 480;
				layoutHeight = 360;
			}
		}
		if(wrongPowder.touchosc.File.mode() == 1) {
			if(wrongPowder.touchosc.File.orientation().equals("horizontal")) {
				layoutWidth = 768;
				layoutHeight = 1024;
			}
			if(wrongPowder.touchosc.File.orientation().equals("vertical")) {
				layoutWidth = 1024;
				layoutHeight = 768;
			}
		}
		
		// Set the size (width) of tabs.
		// For this, read the layoutWidth and calculate the tab size.
		tabWidth = layoutWidth/wrongPowder.touchosc.File.numTabs() - 2;
		
		
		
		
		ctrl = new control[wrongPowder.touchosc.File.numControls()];
		
		int counter = 0;
		for(int i=0; i<wrongPowder.touchosc.File.numTabs(); i++) {
			for(int j=0; j<wrongPowder.touchosc.File.controlType[i].length; j++) {
				
				// Led
				//if(wrongPowder.touchosc.File.controlType[i][j].equals("led")) {
					ctrl[counter] = new control();
					
					ctrl[counter].init(wrongPowder.touchosc.File.controlName[i][j],
							wrongPowder.touchosc.File.controlType[i][j],
							wrongPowder.touchosc.File.controlX[i][j],
							wrongPowder.touchosc.File.controlY[i][j],
							wrongPowder.touchosc.File.controlW[i][j],
							wrongPowder.touchosc.File.controlH[i][j],
							wrongPowder.touchosc.File.controlColor[i][j]);
					
					counter++;
				//}
			}
		}
		
	}
	
	
	/**
	 * 
	 * @param x X Position.
	 * @param y Y Position.
	 */
	public void draw(int x, int y) {
		p.pushMatrix();
		
			p.translate(x, y);
		
			// ground
			p.noStroke();
			p.fill(0);
			p.rect(0, 0, layoutWidth, layoutHeight);
			
			// tabs
			//int tabWidth = ;
			for(int i=0; i<layoutHeight; i+=tabWidth) {
				p.stroke(0);
				// Set the Tab bar color.
				if(i == tabActive) p.fill(50);
				else p.fill(30);
				// Draw the Tab bar.
				p.rect(i+1, 0, tabWidth, 40);
			}
		
			if(wrongPowder.touchosc.File.orientation().equals("vertical")) {
				p.translate(0, layoutHeight);
				p.rotate(-p.radians(90));
			}
			
			int counter = 0;
			p.noStroke();
			for(int i=0; i<wrongPowder.touchosc.File.numTabs(); i++) {
				for(int j=0; j<wrongPowder.touchosc.File.controlType[i].length; j++) {
					
					// TODO Klassenbasierte version mit init methode im setup É
					
					// Led
					/*if(wrongPowder.touchosc.File.controlType[i][j].equals("led")) {
						//System.out.println("LED");
						p.fill(wrongPowder.touchosc.File.controlColor[i][j]);
						p.ellipse(wrongPowder.touchosc.File.controlX[i][j],
							      wrongPowder.touchosc.File.controlY[i][j],
							      wrongPowder.touchosc.File.controlW[i][j],
							      wrongPowder.touchosc.File.controlH[i][j]);
					}
					
					// Led
					if(wrongPowder.touchosc.File.controlType[i][j].equals("labelv")) {
						//System.out.println("LED");
						p.fill(wrongPowder.touchosc.File.controlColor[i][j]);
						p.ellipse(wrongPowder.touchosc.File.controlX[i][j],
							      wrongPowder.touchosc.File.controlY[i][j],
							      wrongPowder.touchosc.File.controlW[i][j],
							      wrongPowder.touchosc.File.controlH[i][j]);
					}
					
					//if(wrongPowder.touchosc.TouchOscFile.controlType[i][j].equals("led")) {
						//System.out.println("LED");
					p.fill(wrongPowder.touchosc.File.controlColor[i][j]);
					p.rect(wrongPowder.touchosc.File.controlX[i][j],
						   wrongPowder.touchosc.File.controlY[i][j],
						   wrongPowder.touchosc.File.controlW[i][j],
						   wrongPowder.touchosc.File.controlH[i][j]);
					//}*/
					
					ctrl[counter].display();
					counter++;
				}
			}
		
		p.popMatrix();
		
	}
	
	
	
	public class control {
		
		String name;
		String type;
		int x;
		int y;
		int w;
		int h;
		int color;
		
		control() {}
		
		public void init(String name, String type, int x, int y, int w, int h, int color) {
			this.name = name;
			this.type = type;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
		}
		
		public void display() {
			p.fill(color);
			p.rect(x, y, w, h);
		}
	}
	
}