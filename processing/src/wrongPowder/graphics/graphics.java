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
 * wngShape is a class contains different shapes and grids.
 * - roundedRect
 * - polygon
 * - star
 * - wrongAgent
 * - lineGrid
 * - lineGridHorizontal
 * - lineGridVertical
 * - rectGrid
 * 
 * @example wngShape
 * @author Paul Vollmer, wrong-entertainment.com
 * 
 */
public class graphics {

	private PApplet p5;


	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the class.
	 * 
	 * @example wngShape
	 * @param theParent
	 */
	public graphics(PApplet parent) {
		p5 = parent;
		welcome();
	}
        
        /*
	 * welcome text for processing IDE console
	 */
	protected void welcome() {
		System.out.println("### START wngShape CLASS");
	}

	/**
	 * draw a rounded rect shape
	 * 
	 * @param x
	 *        float
	 * @param y
	 *        float
	 * @param w
	 *        float
	 * @param h
	 *        float
	 * @param r
	 *        float
	 */
	public void rectRounded(float x, float y, float w, float h, float r) {
		p5.beginShape();
		p5.vertex(x+r, y);
		p5.vertex(x+w-r, y);
		p5.bezierVertex(x+w-r, y, x+w, y, x+w, y+r);
		p5.vertex(x+w, y+r);
		p5.vertex(x+w, y+h-r);
		p5.bezierVertex(x+w, y+h-r, x+w, y+h, x+w-r, y+h);
		p5.vertex(x+w-r, y+h);
		p5.vertex(x+r, y+h);
		p5.bezierVertex(x+r, y+h, x, y+h, x, y+h-r);
		p5.vertex(x, y+h-r);
		p5.vertex(x, y+r);
		p5.bezierVertex(x, y+r, x, y, x+r, y);
		p5.endShape();
	}

	/**
	 * draw a polygon shape
	 * 
	 * @param x
	 *        float
	 * @param y
	 *        float
	 * @param d
	 *        float
	 * @param n
	 *        float
	 */
	public void polygon(float x, float y, float d, float n) {
		float xpos = x+d/2;
		float ypos = y+d/2;
		float radius = d/2;
		float angle = p5.TWO_PI/n;
		p5.beginShape();
		for (int i = 0; i <= n; i++) {
			float vx = p5.cos(angle * i) * radius;
			float vy = p5.sin(angle * i) * radius;
			p5.vertex(xpos+vx, ypos+vy);
		}
		p5.endShape();
	}

	/**
	 * draw a star shape
	 * 
	 * @param x
	 *        float
	 * @param y
	 *        float
	 * @param id
	 *        float
	 * @param od
	 *        float
	 * @param n
	 *        float
	 */
	public void star(float x, float y, float id, float od, float n) {
		float xpos = x+od/2;
		float ypos = y+od/2;
		float ir = id/2;
		float or = od/2;
		float nt = n*2;
		float angle = 0;
		float angleChangePerPt = p5.TWO_PI/nt;
		p5.beginShape();
		for (int i = 0; i <= nt; i++) {
			if (i % 2 == 0) {
				float vx = p5.cos(angle) * ir;
				float vy = p5.sin(angle) * ir;
				p5.vertex(xpos + vx, ypos + vy);
			} else {
				float vx = p5.cos(angle) * or;
				float vy = p5.sin(angle) * or;
				p5.vertex(xpos + vx, ypos + vy);
			}
			angle += angleChangePerPt;
		}
		p5.endShape();
	}

	/**
	 * draw a line grid
	 * 
	 * @param x
	 *        int
	 * @param y
	 *        int
	 * @param w
	 *        int
	 * @param h
	 *        int
	 * @param sh
	 *        int
	 * @param sv
	 *        int
	 */
	public void lineGrid(int x, int y, int w, int h, int sh, int sv) {
		lineGrid((float)x, (float)y, (float)w, (float)h, (float)sh, (float)sv);
	}
	
	/**
	 * draw a line grid
	 * 
	 * @param x
	 *        float
	 * @param y
	 *        float
	 * @param w
	 *        float
	 * @param h
	 *        float
	 * @param sh
	 *        float
	 * @param sv
	 *        float
	 */
	public void lineGrid(float x, float y, float w, float h, float sh, float sv) {
		for (float i = y; i < y + h; i = i + sh) {
			for (float j = x; j < x + w; j = j + sv) {
				p5.line(x, i, w + x, i);
				p5.line(j, y, j, h + y);
			}
		}
	}

	/**
	 * draw a line grid horizontal
	 * 
	 * @param x
	 *        int
	 * @param y
	 *        int
	 * @param w
	 *        int
	 * @param h
	 *        int
	 * @param s
	 *        int
	 */
	public void lineGridHorizontal(int x, int y, int w, int h, int s) {
		lineGridHorizontal((float)x, (float)y, (float)w, (float)h, (float)s);
	}
	
	/**
	 * draw a line grid horizontal
	 * 
	 * @param x
	 *        float
	 * @param y
	 *        float
	 * @param w
	 *        float
	 * @param h
	 *        float
	 * @param s
	 *        float
	 */
	public void lineGridHorizontal(float x, float y, float w, float h, float s) {
		for (float i = y; i < y + h; i = i + s) {
			p5.line(x, i, w + x, i);
		}
	}

	/**
	 * draw a line grid vertical
	 * 
	 * @param x
	 *        int
	 * @param y
	 *        int
	 * @param w
	 *        int
	 * @param h
	 *        int
	 * @param s
	 *        int
	 */
	public void lineGridVertical(int x, int y, int w, int h, int s) {
		lineGridVertical((float)x, (float)y, (float)w, (float)h, (float)s);
	}

	/**
	 * draw a line grid vertical
	 * 
	 * @param x
	 *        float
	 * @param y
	 *        float
	 * @param w
	 *        float
	 * @param h
	 *        float
	 * @param s
	 *        float
	 */
	public void lineGridVertical(float x, float y, float w, float h, float s) {
		for (float i = x; i < x + w; i = i + s) {
			p5.line(i, y, i, h + y);
		}
	}

	/**
	 * draw a rect grid
	 * 
	 * @param x
	 *        float
	 * @param y
	 *        float
	 * @param w
	 *        float
	 * @param h
	 *        float
	 * @param s
	 *        float
	 * @param sqNum_w
	 *        float
	 * @param sqNum_h
	 *        float
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
	 * draw a wrongAgent shape
	 * 
	 * @param x
	 *        float
	 * @param y
	 *        float
	 * @param s
	 *        float
	 */
	public void wrongAgent(float x, float y, float s) {
		double x1 = x + 2.25 * s;
		double x2 = x + 2.53 * s;
		double x3 = x + 2.75 * s;
		double x4 = x + 1.75 * s;
		double x5 = x + 1.91 * s;
		double x6 = x + 2.00 * s;
		double x7 = x + 1.72 * s;
		double x8 = x + 1.38 * s;
		double x9 = x + 1.03 * s;
		double x10 = x + 0.75 * s;
		double x11 = x + 0.85 * s;
		double x12 = x + 1.00 * s;
		double x13 = x + 0.50 * s;
		double x14 = x + 0.23 * s;
		double x15 = x + 0.0 * s;
		double y1 = y + 5.00 * s;
		double y2 = y + 4.00 * s;
		double y3 = y + 3.78 * s;
		double y4 = y + 3.50 * s;
		double y5 = y + 1.63 * s;
		double y6 = y + 1.35 * s;
		double y7 = y + 1.13 * s;
		double y8 = y + 1.01 * s;
		double y9 = y + 0.83 * s;
		double y10 = y + 0.63 * s;
		double y11 = y + 0.28 * s;
		double y12 = y + 0.0 * s;
		p5.beginShape();
		p5.vertex((float)x1, (float)y1);
		p5.vertex((float)x1, (float)y2);
		p5.bezierVertex((float)x2, (float)y2, (float)x3, (float)y3, (float)x3, (float)y4);
		p5.vertex((float)x3, (float)y4);
		p5.vertex((float)x3, (float)y5);
		p5.bezierVertex((float)x3, (float)y6, (float)x2, (float)y7, (float)x1, (float)y7);
		p5.vertex((float)x1, (float)y7);
		p5.vertex((float)x4, (float)y7);
		p5.bezierVertex((float)x5, (float)y8, (float)x6, (float)y9, (float)x6, (float)y10);
		p5.bezierVertex((float)x6, (float)y11, (float)x7, (float)y12, (float)x8, (float)y12);
		p5.bezierVertex((float)x9, (float)y12, (float)x10, (float)y11, (float)x10, (float)y10);
		p5.bezierVertex((float)x10, (float)y9, (float)x11, (float)y8, (float)x12, (float)y7);
		p5.vertex((float)x12, (float)y7);
		p5.vertex((float)x13, (float)y7);
		p5.bezierVertex((float)x14, (float)y7, (float)x15, (float)y6, (float)x15, (float)y5);
		p5.vertex((float)x15, (float)y5);
		p5.vertex((float)x15, (float)y4);
		p5.bezierVertex((float)x15, (float)y3, (float)x14, (float)y2, (float)x13, (float)y2);
		p5.vertex((float)x13, (float)y2);
		p5.vertex((float)x13, (float)y1);
		p5.vertex((float)x1, (float)y1);
		p5.endShape();
	}
}
