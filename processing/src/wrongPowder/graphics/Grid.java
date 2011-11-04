/**
 * wngShape is a class of the wng.agent library.
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
 * @modified	2010/11/10
 * @version		0.1.0
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
	 * Draw a line grid
	 * 
	 * @param x X position.
	 * @param y Y position.
	 * @param w Width of the Grid.
	 * @param h Height of the Grid.
	 * @param sh Spacing horizontal.
	 * @param sv Spacing vertical.
	 */
	public void lineGrid(int x, int y, int w, int h, int sh, int sv) {
		for(int i=y; i<y+h; i=i+sh) {
			for(int j=x; j<x+w; j=j+sv) {
				p5.line(x, i, w+x, i);
				p5.line(j, y, j, h+y);
			}
		}
	}
	
	/**
	 * Draw a line grid
	 * 
	 * @param x X position.
	 * @param y Y position.
	 * @param w Width of the Grid.
	 * @param h Height of the Grid.
	 * @param sh Spacing horizontal.
	 * @param sv Spacing vertical.
	 */
	public void lineGrid(float x, float y, float w, float h, float sh, float sv) {
		for(float i=y; i<y+h; i=i+sh) {
			for(float j=x; j<x+w; j=j+sv) {
				p5.line(x, i, w+x, i);
				p5.line(j, y, j, h+y);
			}
		}
	}
	
	
	/**
	 * Draw a line grid horizontal
	 * 
	 * @param x X position.
	 * @param y Y position.
	 * @param w Width of the Grid.
	 * @param h Height of the Grid.
	 * @param s Spacing horizontal.
	 */
	public void lineGridHorizontal(int x, int y, int w, int h, int s) {
		for(int i=y; i<y+h; i=i+s) {
			p5.line(x, i, w+x, i);
		}
	}
	
	/**
	 * Draw a line grid horizontal
	 * 
	 * @param x X position.
	 * @param y Y position.
	 * @param w Width of the Grid.
	 * @param h Height of the Grid.
	 * @param s Spacing horizontal.
	 */
	public void lineGridHorizontal(float x, float y, float w, float h, float s) {
		for(float i=y; i<y+h; i=i+s) {
			p5.line(x, i, w+x, i);
		}
	}

	
	/**
	 * Draw a line grid vertical
	 * 
	 * @param x X position.
	 * @param y Y position.
	 * @param w Width of the Grid.
	 * @param h Height of the Grid.
	 * @param s Spacing vertical.
	 */
	public void lineGridVertical(int x, int y, int w, int h, int s) {
		for (int i=x; i<x+w; i=i+s) {
			p5.line(i, y, i, h+y);
		}
	}

	/**
	 * Draw a line grid vertical
	 * 
	 * @param x X position.
	 * @param y Y position.
	 * @param w Width of the Grid.
	 * @param h Height of the Grid.
	 * @param s Spacing vertical.
	 */
	public void lineGridVertical(float x, float y, float w, float h, float s) {
		for (float i=x; i<x+w; i=i+s) {
			p5.line(i, y, i, h+y);
		}
	}
	
	
	/**
	 * Draw a rect grid.
	 * 
	 * @param x X position.
	 * @param y Y position.
	 * @param w Width of the Grid.
	 * @param h Height of the Grid.
	 * @param s Spacing vertical.
	 * @param sqNum_w Number of rects at width.
	 * @param sqNum_h Number of rects at height
	 */
	public void rectGrid(float x, float y, float w, float h, float s, float sqNum_w, float sqNum_h) {
		float sqSize_w = w/sqNum_w;
		float sqSize_h = h/sqNum_h;
		float halfSize_w = sqSize_w/2;
		float halfSize_h = sqSize_h/2;
		for (float j = y+halfSize_h; j < h; j = j+sqSize_h) {
			for (float i = x+halfSize_w; i < w; i = i+sqSize_w) {
				p5.rect(i - halfSize_w + (s / 2), j - halfSize_h + (s / 2), sqSize_w - s, sqSize_h - s);
			}
		}
	}
	
	/**
	 * Draw a rect grid.
	 * 
	 * @param x X position.
	 * @param y Y position.
	 * @param w Width of the Grid.
	 * @param h Height of the Grid.
	 * @param s Spacing vertical.
	 * @param sqNum_w Number of rects at width.
	 * @param sqNum_h Number of rects at height
	 */
	public void rectGrid(int x, int y, int w, int h, int s, int sqNum_w, int sqNum_h) {
		float sqSize_w = w/sqNum_w;
		float sqSize_h = h/sqNum_h;
		float halfSize_w = sqSize_w/2;
		float halfSize_h = sqSize_h/2;
		for (float j = y+halfSize_h; j < h; j = j+sqSize_h) {
			for (float i = x+halfSize_w; i < w; i = i+sqSize_w) {
				p5.rect(i - halfSize_w + (s / 2), j - halfSize_h + (s / 2), sqSize_w - s, sqSize_h - s);
			}
		}
	}
	
}
