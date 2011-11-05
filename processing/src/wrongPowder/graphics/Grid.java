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

package wrongPowder.graphics;

import processing.core.PApplet;


/**
 * Grid
 * 
 * @example graphics_basic
 */
public class Grid {

	private PApplet p5;


	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the class.
	 * 
	 * @example graphics_basic
	 * @param p
	 */
	public Grid(PApplet p) {
		p5 = p;
	}
	

	/**
	 * Draw a line grid.
	 * 
	 * @param xpos X position.
	 * @param ypos Y position.
	 * @param width Width of the grid.
	 * @param height Height of the grid.
	 * @param spacing The spacing between lines.
	 */
	public void lineGrid(float xpos, float ypos, float width, float height, float spacing) {
		float xWidth = width+xpos;
		float yHeight = height+ypos;
		
		for(float i=ypos; i<yHeight; i=i+spacing) {
			for(float j=xpos; j<xWidth; j=j+spacing) {
				p5.line(xpos, i, xWidth, i);
				p5.line(j, ypos, j, yHeight);
			}
		}
	}
	
	
	/**
	 * Draw a line grid.
	 * 
	 * @param xpos X position.
	 * @param ypos Y position.
	 * @param width Width of the grid.
	 * @param height Height of the grid.
	 * @param spacingh The spacing between horizontal lines.
	 * @param spacingv The spacing between vertical lines.
	 */
	public void lineGrid(float xpos, float ypos, float width, float height, float spacingh, float spacingv) {
		float xWidth = width+xpos;
		float yHeight = height+ypos;
		
		for(float i=ypos; i<yHeight; i=i+spacingh) {
			for(float j=xpos; j<xWidth; j=j+spacingv) {
				p5.line(xpos, i, width+xpos, i);
				p5.line(j, ypos, j, height+ypos);
			}
		}
	}
	
	
	/**
	 * Draw a line grid horizontal.
	 * 
	 * @param xpos X position.
	 * @param ypos Y position.
	 * @param width Width of the grid.
	 * @param height Height of the grid.
	 * @param spacing The spacing between horizontal lines.
	 */
	public void lineGridHorizontal(float xpos, float ypos, float width, float height, float spacing) {
		float xWidth = width+xpos;
		
		for(float i=ypos; i<ypos+height; i=i+spacing) {
			p5.line(xpos, i, xWidth, i);
		}
	}

	
	/**
	 * Draw a line grid vertical
	 * 
	 * @param xpos X position.
	 * @param ypos Y position.
	 * @param width Width of the grid.
	 * @param height Height of the grid.
	 * @param spacing The spacing between vertical lines.
	 */
	public void lineGridVertical(float xpos, float ypos, float width, float height, float spacing) {
		float yHeight = height+ypos;
		
		for (float i=xpos; i<xpos+width; i=i+spacing) {
			p5.line(i, ypos, i, yHeight);
		}
	}
	
	
	/**
	 * Draw a rect grid.
	 * 
	 * @param xpos X position.
	 * @param ypos Y position.
	 * @param width Width of the Grid.
	 * @param height Height of the Grid.
	 * @param spacing Spacing vertical.
	 * @param sqNum_w Number of rects at width.
	 * @param sqNum_h Number of rects at height
	 */
	public void rectGrid(float xpos, float ypos, float width, float height, float spacing, float sqNum_w, float sqNum_h) {
		float sqSize_w = width/sqNum_w;
		float sqSize_h = height/sqNum_h;
		float halfSize_w = sqSize_w/2;
		float halfSize_h = sqSize_h/2;
		
		for (float j=ypos+halfSize_h; j<height; j=j+sqSize_h) {
			for (float i=xpos+halfSize_w; i<width; i=i+sqSize_w) {
				p5.rect(i - halfSize_w + (spacing / 2), j - halfSize_h + (spacing / 2), sqSize_w - spacing, sqSize_h - spacing);
			}
		}
	}
	
	
}
