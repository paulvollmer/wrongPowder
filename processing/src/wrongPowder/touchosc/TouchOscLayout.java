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



public class TouchOscLayout extends TouchOscFile {
	
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
	
	public int tabWidth;
	
	private PApplet p;
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 */
	public TouchOscLayout(PApplet p) {
		this.p = p;
	}
	
	
	public void init() {
		//System.out.println("Start init");
		
		// Check the mode.
		// 0 = iPhone/iPod Touch
		if(wrongPowder.touchosc.TouchOscFile.mode() == 0) {
			if(wrongPowder.touchosc.TouchOscFile.orientation().equals("horizontal")) {
				layoutWidth = 360;
				layoutHeight = 480;
			}
			if(wrongPowder.touchosc.TouchOscFile.orientation().equals("vertical")) {
				layoutWidth = 480;
				layoutHeight = 360;
			}
		}
		
		// 1 = iPad
		if(wrongPowder.touchosc.TouchOscFile.mode() == 1) {
			if(wrongPowder.touchosc.TouchOscFile.orientation().equals("horizontal")) {
				layoutWidth = 768;
				layoutHeight = 1024;
			}
			if(wrongPowder.touchosc.TouchOscFile.orientation().equals("vertical")) {
				layoutWidth = 1024;
				layoutHeight = 768;
			}
		}
		
		// Set the size of the tabs. For this, read
		// the layoutWidth and calculate the tab size.
		tabWidth = layoutWidth/wrongPowder.touchosc.TouchOscFile.numTabs() - 3;
		
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
				p.fill(50);
				p.rect(i+1, 0, tabWidth, 40);
			}
		
			if(wrongPowder.touchosc.TouchOscFile.orientation().equals("vertical")) {
				p.translate(0, layoutHeight);
				p.rotate(-p.radians(90));
			}
			
			p.noStroke();
			for(int i=0; i<wrongPowder.touchosc.TouchOscFile.numTabs(); i++) {
				for(int j=0; j<wrongPowder.touchosc.TouchOscFile.controlType[i].length; j++) {
					
					// Led
					if(wrongPowder.touchosc.TouchOscFile.controlType[i][j].equals("led")) {
						//System.out.println("LED");
						p.fill(wrongPowder.touchosc.TouchOscFile.controlColor[i][j]);
						p.ellipse(wrongPowder.touchosc.TouchOscFile.controlX[i][j],
							      wrongPowder.touchosc.TouchOscFile.controlY[i][j],
							      wrongPowder.touchosc.TouchOscFile.controlW[i][j],
							      wrongPowder.touchosc.TouchOscFile.controlH[i][j]);
					}
					
					//if(wrongPowder.touchosc.TouchOscFile.controlType[i][j].equals("led")) {
						//System.out.println("LED");
					p.fill(wrongPowder.touchosc.TouchOscFile.controlColor[i][j]);
					p.rect(wrongPowder.touchosc.TouchOscFile.controlX[i][j],
						   wrongPowder.touchosc.TouchOscFile.controlY[i][j],
						   wrongPowder.touchosc.TouchOscFile.controlW[i][j],
						   wrongPowder.touchosc.TouchOscFile.controlH[i][j]);
					//}
				}
			}
			
			
			
			
			// draw control elements.
			/*for(int i = tBatteryh.size()-1; i >= 0; i--) {
				TouchOscBatteryh batteryh = (TouchOscBatteryh) tBatteryh.get(i);
				batteryh.display();
			}
			for(int i = tBatteryv.size()-1; i >= 0; i--) {
				TouchOscBatteryv batteryv = (TouchOscBatteryv) tBatteryv.get(i);
				batteryv.display();
			}
			for(int i = tFaderh.size()-1; i >= 0; i--) {
				TouchOscFaderh faderh = (TouchOscFaderh) tFaderh.get(i);
				faderh.display();
			}
			for(int i = tFaderv.size()-1; i >= 0; i--) {
				TouchOscFaderv faderv = (TouchOscFaderv) tFaderv.get(i);
				faderv.display();
			}
			for(int i = tLabelh.size()-1; i >= 0; i--) {
				TouchOscLabelh labelh = (TouchOscLabelh) tLabelh.get(i);
				labelh.display();
			}
			for(int i = tLabelv.size()-1; i >= 0; i--) {
				TouchOscLabelv labelv = (TouchOscLabelv) tLabelv.get(i);
				labelv.display();
			}
			for(int i = tLed.size()-1; i >= 0; i--) {
				TouchOscLed led = (TouchOscLed) tLed.get(i);
				led.display();
			}
			for(int i = tMultifaderh.size()-1; i >= 0; i--) {
				TouchOscMultifaderh multifaderh = (TouchOscMultifaderh) tMultifaderh.get(i);
				multifaderh.display();
			}
			for(int i = tMultifaderv.size()-1; i >= 0; i--) {
				TouchOscMultifaderv multifaderv = (TouchOscMultifaderv) tMultifaderv.get(i);
				multifaderv.display();
			}
			for(int i = tMultitoggle.size()-1; i >= 0; i--) {
				TouchOscMultitoggle multitoggle = (TouchOscMultitoggle) tMultitoggle.get(i);
				multitoggle.display();
			}
			for(int i = tPush.size()-1; i >= 0; i--) {
				TouchOscPush push = (TouchOscPush) tPush.get(i);
				push.display();
			}
			for(int i = tRotaryh.size()-1; i >= 0; i--) {
				TouchOscRotaryh rotaryh = (TouchOscRotaryh) tRotaryh.get(i);
				rotaryh.display();
			}
			for(int i = tRotaryv.size()-1; i >= 0; i--) {
				TouchOscRotaryv rotaryv = (TouchOscRotaryv) tRotaryv.get(i);
				rotaryv.display();
			}
			for(int i = tTimeh.size()-1; i >= 0; i--) {
				TouchOscTimeh timeh = (TouchOscTimeh) tTimeh.get(i);
				timeh.display();
			}
			for(int i = tTimev.size()-1; i >= 0; i--) {
				TouchOscTimev timev = (TouchOscTimev) tTimev.get(i);
				timev.display();
			}
			for(int i = tToggle.size()-1; i >= 0; i--) {
				TouchOscToggle toggle = (TouchOscToggle) tToggle.get(i);
				toggle.display();
			}
			for(int i = tXy.size()-1; i >= 0; i--) {
				TouchOscXy xy = (TouchOscXy) tXy.get(i);
				xy.display();
			}*/
			
		p.popMatrix();
	}
	
	
	
	
	
	
	
	
	public class TouchOscBatteryh {
		
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		
		TouchOscBatteryh(String name, int x, int y, int w, int h, int color) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
		}
		
		private void display() {
			p.fill(color);
			p.rect(x, y, w, h);
		}
	}
	
	public class TouchOscBatteryv {
		
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		
		TouchOscBatteryv(String name, int x, int y, int w, int h, int color) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
		}
		
		private void display() {
			p.fill(color);
			p.rect(x, y, w, h);
		}
	}
	
	
	public class TouchOscFaderv {
		
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		
		TouchOscFaderv(String name, int x, int y, int w, int h, int color) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
		}
		
		private void display() {
			p.fill(color);
			p.rect(x, y, w, h);
		}
	}
	
	public class TouchOscFaderh {
		
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		
		TouchOscFaderh(String name, int x, int y, int w, int h, int color) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
		}
		
		private void display() {
			p.fill(color);
			p.rect(x, y, w, h);
		}
	}

	
	public class TouchOscLabelh {
		
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		private String text;
		
		TouchOscLabelh(String name, int x, int y, int w, int h, int color, String text) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
			this.text = text;
		}
		
		private void display() {
			p.noStroke();
			p.fill(color);
			p.rect(x, y, w, h);
			
			//p.fill(0, 255, 0);
			//p.text(text, x, y+h);
		}
	}
	
	public class TouchOscLabelv {
		
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		private String text;
		
		TouchOscLabelv(String name, int x, int y, int w, int h, int color, String text) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
			this.text = text;
		}
		
		private void display() {
			p.noStroke();
			p.fill(color);
			p.rect(x, y, w, h);
			
			//p.pushMatrix();
			//p.rotate(p.HALF_PI);
			//p.fill(0, 255, 0);
			//p.text(text, x, y);
			//p.popMatrix();
		}
	}
	
	
	public class TouchOscLed {
		
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		
		TouchOscLed(String name, int x, int y, int w, int h, int color) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
		}
		
		private void display() {
			p.fill(color);
			p.ellipse(x, y, w, h);
		}
	}
	
	
	public class TouchOscMultifaderh {
		
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		
		TouchOscMultifaderh(String name, int x, int y, int w, int h, int color) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
		}
		
		private void display() {
			p.fill(color);
			p.rect(x, y, w, h);
		}
	}
	
	public class TouchOscMultifaderv {
		
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		
		TouchOscMultifaderv(String name, int x, int y, int w, int h, int color) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
		}
		
		private void display() {
			p.fill(color);
			p.rect(x, y, w, h);
		}
	}
	
	
	public class TouchOscMultitoggle {
		
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		
		TouchOscMultitoggle(String name, int x, int y, int w, int h, int color) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
		}
		
		private void display() {
			p.fill(color);
			p.rect(x, y, w, h);
		}
	}
	
	
	public class TouchOscPush {
		
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		
		TouchOscPush(String name, int x, int y, int w, int h, int color) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
		}
		
		private void display() {
			p.fill(color);
			p.rect(x, y, w, h);
		}
	}
	
	
	public class TouchOscRotaryv {
		
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		
		TouchOscRotaryv(String name, int x, int y, int w, int h, int color) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
		}
		
		private void display() {
			p.fill(color);
			p.ellipse(x, y, w, h);
		}
	}
	
	public class TouchOscRotaryh {
		
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		
		TouchOscRotaryh(String name, int x, int y, int w, int h, int color) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
		}
		
		private void display() {
			p.fill(color);
			p.ellipse(x, y, w, h);
		}
	}
	
	
	public class TouchOscTimev {
		
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		
		TouchOscTimev(String name, int x, int y, int w, int h, int color) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
		}
		
		private void display() {
			p.fill(color);
			p.rect(x, y, w, h);
		}
	}
	
	public class TouchOscTimeh {
		
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		
		TouchOscTimeh(String name, int x, int y, int w, int h, int color) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
		}
		
		private void display() {
			p.fill(color);
			p.rect(x, y, w, h);
		}
	}
	
	
	public class TouchOscToggle {
		
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		
		TouchOscToggle(String name, int x, int y, int w, int h, int color) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
		}
		
		private void display() {
			p.fill(color);
			p.rect(x, y, w, h);
		}
	}
	
	
	public class TouchOscXy {
		
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private int color;
		
		TouchOscXy(String name, int x, int y, int w, int h, int color) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
		}
		
		private void display() {
			p.fill(color);
			p.rect(x, y, w, h);
		}
	}
	
	
	
}