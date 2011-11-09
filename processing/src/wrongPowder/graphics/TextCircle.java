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

package wrongPowder.graphics;

import processing.core.*;


public class TextCircle {
	
	PApplet p5;
	
	
	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 */ 
	public TextCircle(PApplet p) {
		p5 = p;
	}
	
	
	/**
	 * Draw a text circle.
	 *
	 * @param myString Text input
	 * @param x X position of the text circle
	 * @param y Y position of the text circle
	 * @param rad Radius of the text circle
	 * @param rotate Rotation of the text circle
	 * @param offset Space between each char
	 */
	public void render(String myString, float x, float y, float rad, float rotate, float offset) {
		p5.pushMatrix();
		p5.translate(x, y);
		p5.rotate(rotate);
		// draw each char from the String
		for (int i=0; i<myString.length(); i++) {
			p5.pushMatrix();
			p5.translate(0, rad);
			p5.text(myString.charAt(i), 0, 0);
			p5.popMatrix();
			p5.rotate(-p5.textWidth(myString.charAt(i)) / (rad+ offset));
		}
		p5.popMatrix();
	}
	
	public void render(String myString, float x, float y, float rad, float rotate) {
		render(myString, x, y, rad, rotate, 0);
	}
	
}
