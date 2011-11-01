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


import java.awt.event.MouseEvent;

import processing.core.*;



public class Layout extends File {
	
	// TouchOsc control color variables.
	// TODO Enum or something?
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
	
	// The width/height of the TouchOsc file.
	// Created by readMode() & readOrientation().
	private int layoutWidth;
	private int layoutHeight;
	
	// Create Tab constructor.
	private Tab tab;
	
	// Control
	private Batteryh[] batteryh;
	private Batteryv[] batteryv;
	private Faderh[] faderh;
	private Faderv[] faderv;
	private Labelh[] labelh;
	private Labelv[] labelv;
	private Led[] led;
	private Multifaderh[] multifaderh;
	private Multifaderv[] multifaderv;
	private Multitoggle[] multitoggle;
	private Push[] push;
	private Rotaryh[] rotaryh;
	private Rotaryv[] rotaryv;
	private Timeh[] timeh;
	private Timev[] timev;
	private Toggle[] toggle;
	private Xy[] xy;
	
	
	private PApplet p;
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 */
	public Layout(PApplet p) {
		System.out.println("Start Layout class");
		this.p = p;
		p.registerDispose(this);
	}
	
	public void dispose() {
	    // anything in here will be called automatically when 
	    // the parent applet shuts down. for instance, this might
		// shut down a thread used by this library.
	}
	
	
	public void mouseEvent(MouseEvent event) {
		  int x = event.getX();
		  int y = event.getY();

		  switch (event.getID()) {
		    case MouseEvent.MOUSE_PRESSED:
		      // do something for the mouse being pressed
		      break;
		    case MouseEvent.MOUSE_RELEASED:
		      // do something for mouse released
		      break;
		    case MouseEvent.MOUSE_CLICKED:
		      // do something for mouse clicked
		      break;
		    case MouseEvent.MOUSE_DRAGGED:
		      // do something for mouse dragged
		      break;
		    case MouseEvent.MOUSE_MOVED:
		      // umm... forgot
		      break;
		  }
		}
	
	
	
	public void init() {
		System.out.println("Start init");
		
		// Check file mode.
		readMode();
		
		
		// Create tab class array.
		tab = new Tab(layoutWidth, numTabs());
		
		// Create control class array.
		batteryh = new Batteryh[numBatteryh];
		batteryv = new Batteryv[numBatteryv];
		faderh = new Faderh[numFaderh];
		faderv = new Faderv[numFaderv];
		labelh = new Labelh[numLabelh];
		labelv = new Labelv[numLabelv];
		led = new Led[numLed];
		multifaderh = new Multifaderh[numMultifaderh];
		multifaderv = new Multifaderv[numMultifaderv];
		multitoggle = new Multitoggle[numMultitoggle];
		push = new Push[numPush];
		rotaryh = new Rotaryh[numRotaryh];
		rotaryv = new Rotaryv[numRotaryv];
		timeh = new Timeh[numTimeh];
		timev = new Timev[numTimev];
		toggle = new Toggle[numToggle];
		xy = new Xy[numXy];
		
		
		int batteryhCounter = 0;
		
		for(int i=0; i<numTabs(); i++) {
			
			for(int j=0; j<numBatteryh; j++) {
				
				batteryh[batteryhCounter] = new Batteryh(controlName[i][j],
				                                         controlType[i][j],
				                                         controlX[i][j],
				                                         controlY[i][j],
			                                             controlW[i][j],
				                                         controlH[i][j],
				                                         controlColor[i][j]);
				batteryhCounter++;
			}
		}
		
	}
	
	
	/**
	 * Read the file mode.
	 * 0 = iPhone/iPod-Touch
	 * 1 = iPad.
	 * Read orientation, set the size and store it to
	 * layoutWidth, layoutHeight variable.
	 */
	private void readMode() {
        System.out.println("Read Mode: mode = " + mode());
		
        switch(mode()) {
        case(0):
        	readOrientation("horizontal", 360, 480);
			readOrientation("vertical", 480, 360);
        	break;
        case(1):
        	readOrientation("horizontal", 768, 1024);
			readOrientation("vertical", 1024, 768);
        	break;
        }
	}

	/**
	 * Read the orientation
	 * @param ori The file mode. 0 or 1.
	 * @param width 
	 * @param height 
	 */
	private void readOrientation(String ori, int width, int height) {
		// If the ori == the file orientation, set variables.
		if(wrongPowder.touchosc.File.orientation().equals(ori)) {
			System.out.println("Read Orientation: orientation = " + ori +
			         "\n                  width = " + width +
			         "\n                  height = " + height);
			
			layoutWidth = width;
			layoutHeight = height;
			System.out.println("                  layoutWidth  = " + layoutWidth +
			                 "\n                  layoutHeight = " + layoutHeight);
		} else {
			System.out.println("Read Orientation: not correct orientation.");
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
			tab.display(p.mouseX-x, p.mouseY-y);
		
			if(orientation().equals("vertical")) {
				p.translate(0, layoutHeight);
				p.rotate(-p.radians(90));
			}
			
			//int counter = 0;
			/*p.noStroke();
			for(int i=0; i<numTabs(); i++) {
				for(int j=0; j<numBatteryh; j++) {
					
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
					
					/*batteryh[j].display();
					//counter++;
				}
			}*/
		
		p.popMatrix();
		
	}
	
	
	
	
	private class Tab {
		
		public int activeTab = 0;
		
		// Tab width calculated with layoutWidth.
		private int tabWidth;
		private int tabActive = 0;
		
		/**
		 * Set the size (width) of tabs.
		 * For this, read the layoutWidth and calculate the tab size.
		 * @param w Width of Tab Bar.
		 * @param num Number oftabs.
		 */
		Tab(int w, int num) {
			tabWidth = w/num;
			System.out.println("tabWidth: " + tabWidth);
		}
		
		public void display(int px, int py) {
			for(int i=0; i<numTabs(); i++) {
				// Set color
				p.noStroke();
				//if(wrongPowder.gui.Interaction.overRect(px, py, i*tabWidth, 0, tabWidth-2, 40) == true) {
				if(activeTab == i) {
					p.fill(50);
				} else {
					p.fill(30);
				}
				// Draw graphics
				p.rect(i*tabWidth, 0, tabWidth-2, 40);
			}
			
				
		}
		
	}

	
	
	private class Control {
		
		private String name;
		private String type;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		
		Control() {}
		
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
	
	
	private class Batteryh extends Control {
		Batteryh(String name, String type, int x, int y, int w, int h, int color) {
			super.init(name, type, x, y, w, h, color);
		}
	}
	
	
	private class Batteryv extends Control {
		Batteryv(String name, String type, int x, int y, int w, int h, int color) {
			super.init(name, type, x, y, w, h, color);
		}
	}
	
	
	private class Faderh extends Control {
		Faderh(String name, String type, int x, int y, int w, int h, int color) {
			super.init(name, type, x, y, w, h, color);
		}
	}
	
	
	private class Faderv extends Control {
		Faderv(String name, String type, int x, int y, int w, int h, int color) {
			super.init(name, type, x, y, w, h, color);
		}
	}
	
	
	private class Labelh extends Control {
		Labelh(String name, String type, int x, int y, int w, int h, int color) {
			super.init(name, type, x, y, w, h, color);
		}
	}
	
	
	private class Labelv extends Control {
		Labelv(String name, String type, int x, int y, int w, int h, int color) {
			super.init(name, type, x, y, w, h, color);
		}
	}
	
	
	private class Led extends Control {
		Led(String name, String type, int x, int y, int w, int h, int color) {
			super.init(name, type, x, y, w, h, color);
		}
	}
	
	
	private class Multifaderh extends Control {
		Multifaderh(String name, String type, int x, int y, int w, int h, int color) {
			super.init(name, type, x, y, w, h, color);
		}
	}
	
	
	private class Multifaderv extends Control {
		Multifaderv(String name, String type, int x, int y, int w, int h, int color) {
			super.init(name, type, x, y, w, h, color);
		}
	}
	
	
	private class Multitoggle extends Control {
		Multitoggle(String name, String type, int x, int y, int w, int h, int color) {
			super.init(name, type, x, y, w, h, color);
		}
	}
	
	
	private class Push extends Control {
		Push(String name, String type, int x, int y, int w, int h, int color) {
			super.init(name, type, x, y, w, h, color);
		}
	}
	
	
	private class Rotaryh extends Control {
		Rotaryh(String name, String type, int x, int y, int w, int h, int color) {
			super.init(name, type, x, y, w, h, color);
		}
	}
	
	
	private class Rotaryv extends Control {
		Rotaryv(String name, String type, int x, int y, int w, int h, int color) {
			super.init(name, type, x, y, w, h, color);
		}
	}
	
	
	private class Timeh extends Control {
		Timeh(String name, String type, int x, int y, int w, int h, int color) {
			super.init(name, type, x, y, w, h, color);
		}
	}
	
	
	private class Timev extends Control {
		Timev(String name, String type, int x, int y, int w, int h, int color) {
			super.init(name, type, x, y, w, h, color);
		}
	}
	
	
	private class Toggle extends Control {
		Toggle(String name, String type, int x, int y, int w, int h, int color) {
			super.init(name, type, x, y, w, h, color);
		}
	}
	
	
	private class Xy extends Control {
		Xy(String name, String type, int x, int y, int w, int h, int color) {
			super.init(name, type, x, y, w, h, color);
		}
	}
	
}