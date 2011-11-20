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
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.XML;





/**
 * Gui
 * 
 * @example gui_basic 
 */
public class Gui {
	
	PApplet p5;
	PFont font;
	
	ArrayList checkboxes = new ArrayList();
	ArrayList iconbuttons = new ArrayList();
	ArrayList panels = new ArrayList();
	ArrayList pushbuttons = new ArrayList();
	ArrayList tabs = new ArrayList();
	ArrayList togglebuttons = new ArrayList();
	
	
	
	
	
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
	}
	
	
	
	public void init(PFont f) {
		font = f;
	}
	
	
	
	public void loadLayout(String file) {
		// Creaqte a new XML object
		XML xml = new XML(p5, file);
		//System.out.println(xml);
		//List file content. For debuging...
		String[] list = xml.listChildren();
		for(int i=0; i<list.length; i++) {
			System.out.println("["+i+"] " + list[i]);
		}
		
		// <interface> tag
		// Check how many interface tags exist.
		int numInterface = xml.getChildCount();
		System.out.println(numInterface);
		
		// Create a loop to read all interface tags.
		for(int i=1; i<numInterface; i+=2) {
			XML xmlInterface = xml.getChild(i);
			System.out.println(xmlInterface);
			
			// Variables to store interface attributes.
			String interfaceType;
			String interfaceName;
			int interfaceX      = 0;
			int interfaceY      = 0;
			int interfaceWidth  = 100;
			int interfaceHeight = 150;
			
			// Check attributes type, name, x, y
			if(xmlInterface.hasAttribute("type")) interfaceType   = xmlInterface.getString("type");
			if(xmlInterface.hasAttribute("name")) interfaceName   = xmlInterface.getString("name");
			if(xmlInterface.hasAttribute("x"))    interfaceX      = xmlInterface.getInt("x");
			if(xmlInterface.hasAttribute("y"))    interfaceY      = xmlInterface.getInt("y");
			if(xmlInterface.hasAttribute("w"))    interfaceWidth  = xmlInterface.getInt("w");
			if(xmlInterface.hasAttribute("h"))    interfaceHeight = xmlInterface.getInt("h");
			/*System.out.println("["+i+"] " + interfaceType);
			System.out.println("["+i+"] " + interfaceName);
			System.out.println("["+i+"] " + interfaceX);
			System.out.println("["+i+"] " + interfaceY);
			System.out.println("["+i+"] " + interfaceWidth);
			System.out.println("["+i+"] " + interfaceHeight);*/
			
			// Adding a new Panel element.
			panels.add(new Panel(p5, interfaceX, interfaceY, interfaceWidth, interfaceHeight));
			
			
			
			// Check how many control tags exist.
		    int numControl = xmlInterface.getChildCount();
		    System.out.println(numControl);
		    for(int j=1; j<numControl; j+=2) {
		        XML xmlControl = xmlInterface.getChild(j);
		        System.out.println("##### " + xmlControl);
		        
		        // Variables to store interface attributes.
				String controlType;
				String controlName = "default";
				int controlX       = 0;
				int controlY       = 0;
				int controlWidth   = 80;
				int controlHeight  = 25;
				
				// Check attributes type, name, x, y
				if(xmlControl.hasAttribute("name")) controlName = xmlControl.getString("name");
				if(xmlControl.hasAttribute("x"))    controlX = xmlControl.getInt("x");
				if(xmlControl.hasAttribute("y"))    controlY = xmlControl.getInt("y");
				if(xmlControl.hasAttribute("w"))    controlWidth = xmlControl.getInt("w");
				if(xmlControl.hasAttribute("h"))    controlHeight = xmlControl.getInt("h");
				System.out.println("["+j+"] " + controlName);
				System.out.println("["+j+"] " + controlX);
				System.out.println("["+j+"] " + controlY);
				System.out.println("["+i+"] " + controlWidth);
				System.out.println("["+i+"] " + controlHeight);
				
				if(xmlControl.hasAttribute("type")) {
					controlType = xmlControl.getString("type");
					System.out.println("["+j+"] " + controlType);
					if(controlType.equals("toggle")) togglebuttons.add(new ToggleButton(p5, controlX, controlY, controlWidth, controlHeight));
				}
		        
			}
		}
	}
	
	/*private String attributeCheck(XML xml, String attribute) {
		if(xml.hasAttribute(attribute)) {
			return xml.getString(attribute);
			//System.out.println(interfaceX);
		} else {
			return "0x11120119";
		}
	}*/
	
	
	
	public void draw() {
		/*panel.draw();
		button.draw();
		tabs.draw();*/
		
		for(int i=panels.size()-1; i>=0; i--) {
			// An ArrayList doesn't know what it is storing so we have 
		    // to cast the object coming out
		    Panel panel = (Panel) panels.get(i);
		    panel.draw();
		}
		
		for(int i=togglebuttons.size()-1; i>=0; i--) {
		    ToggleButton toggle = (ToggleButton) togglebuttons.get(i);
		    toggle.draw();
		}
		
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
			/*panel.mousePressed(x, y);
			button.mousePressed(x, y);
			tabs.mousePressed(x, y);*/
			for(int i=panels.size()-1; i>=0; i--) {
				// An ArrayList doesn't know what it is storing so we have 
			    // to cast the object coming out
			    Panel panel = (Panel) panels.get(i);
			    panel.mousePressed(x, y);
			}
			for(int i=togglebuttons.size()-1; i>=0; i--) {
			    ToggleButton toggle = (ToggleButton) togglebuttons.get(i);
			    toggle.mousePressed(x, y);
			}
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