/**
 *  wrongPowder is developed by wrong-entertainment & powder
 *
 *
 *  Copyright 2011 Paul Vollmer
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

package wrongPowder.util;

import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import processing.core.*;


public class CaptureScreen extends PApplet {
	
	PApplet p5;
	
	private Robot robot;
	private Rectangle screen;
	private BufferedImage image;
	
	public PImage screenshot;
	
	
	
	
	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the class.
	 * 
	 * @example capture_basic
	 * @param p
	 */
	public CaptureScreen(PApplet p) {
		p5 = p;
	}
	
	
	
	
	/**
	 * 
	 * @param xpos X position of screen capture.
	 * @param ypos Y position of screen capture.
	 * @param width Screen capture width.
	 * @param height Screen capture height.
	 */
	public void cutting(int xpos, int ypos, int width, int height) {
		Robot WNGrobot = null;
		try {
		    WNGrobot = new Robot();
		} catch( Exception e1 ) {
		    e1.printStackTrace();
		}
		screen = new Rectangle(xpos, ypos, height, width);
		image = WNGrobot.createScreenCapture(screen);
		  
		screenshot = new PImage(image);
	}
	
	
}