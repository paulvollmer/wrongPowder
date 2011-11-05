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
 * wngShape is a class contains different shapes.
 * - roundedRect
 * - polygon
 * - star
 * - wrongAgent
 * 
 * @example graphics_basic
 * @author Paul Vollmer, wrong-entertainment.com
 * 
 */
public class Graphics {

	private PApplet p5;


	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the class.
	 * 
	 * @example graphics_basic
	 * @param p
	 */
	public Graphics(PApplet p) {
		p5 = p;
	}

	
	/**
	 * Draw a rounded rectangle.
	 * 
	 * @param xpos X position.
	 * @param ypos Y position.
	 * @param width Width of rounded rectangle.
	 * @param height Height of rounded rectangle.
	 * @param radius Radius of corners.
	 */
	public void rectRounded(float xpos, float ypos, float width, float height, float radius) {
		p5.beginShape();
			p5.vertex(xpos+radius, ypos);
			p5.vertex(xpos+width-radius, ypos);
			p5.bezierVertex(xpos+width-radius, ypos, xpos+width, ypos, xpos+width, ypos+radius);
			p5.vertex(xpos+width, ypos+radius);
			p5.vertex(xpos+width, ypos+height-radius);
			p5.bezierVertex(xpos+width, ypos+height-radius, xpos+width, ypos+height, xpos+width-radius, ypos+height);
			p5.vertex(xpos+width-radius, ypos+height);
			p5.vertex(xpos+radius, ypos+height);
			p5.bezierVertex(xpos+radius, ypos+height, xpos, ypos+height, xpos, ypos+height-radius);
			p5.vertex(xpos, ypos+height-radius);
			p5.vertex(xpos, ypos+radius);
			p5.bezierVertex(xpos, ypos+radius, xpos, ypos, xpos+radius, ypos);
		p5.endShape();
	}
	
	
	/**
	 * Draw a polygon shape.
	 * 
	 * @param xpos X position.
	 * @param ypos Y position.
	 * @param diam Diameter of polygon.
	 * @param n Number of corners.
	 */
	public void polygon(float xpos, float ypos, float diam, float n) {
		float tempX = xpos+diam/2;
		float tempY = ypos+diam/2;
		float tempRad = diam/2;
		float tempAngle = p5.TWO_PI/n;
		
		p5.beginShape();
			for (int i = 0; i <= n; i++) {
				float vx = p5.cos(tempAngle * i) * tempRad;
				float vy = p5.sin(tempAngle * i) * tempRad;
				p5.vertex(tempX+vx, tempY+vy);
			}
		p5.endShape();
	}
	
	
	/**
	 * Draw a star shape.
	 * 
	 * @param xpos X position.
	 * @param ypos Y position.
	 * @param innerDiam The inner diameter of the star.
	 * @param outerDiam The outer diameter of the star.
	 * @param n Number of corners.
	 */
	public void star(float xpos, float ypos, float innerDiam, float outerDiam, float n) {
		float tempX = xpos+outerDiam/2;
		float tempY = ypos+outerDiam/2;
		float tempIr = innerDiam/2;
		float tempOr = outerDiam/2;
		float tempN = n*2;
		float tempAngle = 0;
		float tempAngleChangePerPt = p5.TWO_PI/tempN;
		
		p5.beginShape();
			for (int i = 0; i <= tempN; i++) {
				if (i % 2 == 0) {
					float vx = p5.cos(tempAngle) * tempIr;
					float vy = p5.sin(tempAngle) * tempIr;
					p5.vertex(tempX + vx, tempY + vy);
				} else {
					float vx = p5.cos(tempAngle) * tempOr;
					float vy = p5.sin(tempAngle) * tempOr;
					p5.vertex(tempX + vx, tempY + vy);
				}
				tempAngle += tempAngleChangePerPt;
			}
		p5.endShape();
	}


	/**
	 * Draw a wrongAgent shape.
	 * 
	 * @param xpos X position.
	 * @param ypos Y position.
	 * @param size Size of the wrong agent.
	 */
	public void wrongAgent(float xpos, float ypos, float size) {
		double x1 = xpos+2.25*size;
		double x2 = xpos+2.53*size;
		double x3 = xpos+2.75*size;
		double x4 = xpos+1.75*size;
		double x5 = xpos+1.91*size;
		double x6 = xpos+2.00*size;
		double x7 = xpos+1.72*size;
		double x8 = xpos+1.38*size;
		double x9 = xpos+1.03*size;
		double x10 = xpos+0.75*size;
		double x11 = xpos+0.85*size;
		double x12 = xpos+1.00*size;
		double x13 = xpos+0.50*size;
		double x14 = xpos+0.23*size;
		double x15 = xpos+0.0*size;
		double y1 = ypos+5.00*size;
		double y2 = ypos+4.00*size;
		double y3 = ypos+3.78*size;
		double y4 = ypos+3.50*size;
		double y5 = ypos+1.63*size;
		double y6 = ypos+1.35*size;
		double y7 = ypos+1.13*size;
		double y8 = ypos+1.01*size;
		double y9 = ypos+0.83*size;
		double y10 = ypos+0.63*size;
		double y11 = ypos+0.28*size;
		double y12 = ypos+0.0*size;
		
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