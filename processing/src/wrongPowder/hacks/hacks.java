/**
 * wngHacks is a class of the wng.agent library.
 *
 * (c) paul vollmer, 2010
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author		paul vollmer http://www.wrong-entertainment.com
 * @modified	201011/16
 * @version		0.1.0A
 */

package wrongPowder.hacks;

import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import processing.core.PApplet;


/**
 * this class contains different Processing Hacks like
 * - noWindowBar
 * - 
 * - 
 * 
 * @example wngHacks
 * @author Paul Vollmer, wrong-entertainment.com
 * 
 */
public class hacks {

	private PApplet p5;

        private boolean NO_WINDOW_BAR = false;
        private int MOUSE_X;
        private int MOUSE_Y;


	/**
	 * wngHacks a Constructor, usually called in the setup() method in your
	 * sketch to initialize and start the library.
	 * 
	 * @example wrongHacks
	 * @param theParent
	 */
	public hacks(PApplet parent) {
		p5 = parent;
		welcome();
	}
        
        /*
	 * welcome text for processing IDE console
	 */
	protected void welcome() {
                System.out.println("### START wngHacks CLASS");
	}

	/**
	 * noWindowBar create a window without name bar
	 */
	public void noWindowBar() {
	        p5.frame.setAlwaysOnTop(true);
                // mouseEvent
                p5.registerMouseEvent(this);
                // init
                p5.frame.removeNotify();
                p5.frame.setUndecorated(true);
                p5.frame.addNotify();
                NO_WINDOW_BAR = true;
	}
        
        /*
         * registerMouseEvent function
         */
        public void mouseEvent(MouseEvent event) {
                switch (event.getID()) {
                        case MouseEvent.MOUSE_PRESSED:
                                if(NO_WINDOW_BAR == true) {
                                        MOUSE_X = event.getX();
                                        MOUSE_Y = event.getY();
                                }
                                break;
                        case MouseEvent.MOUSE_DRAGGED:
                                if(NO_WINDOW_BAR == true) {
                                        p5.frame.setLocation(MouseInfo.getPointerInfo().getLocation().x-MOUSE_X,
                                                             MouseInfo.getPointerInfo().getLocation().y-MOUSE_Y);
                                }
                                break;
                }
        }
}
