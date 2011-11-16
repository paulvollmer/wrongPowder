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





/**
 * Gui
 * 
 * @example gui_basic 
 */
public class Button extends GuiRect {
	
	public int id;
	private int colorOn  = 0xFF6D6D6D;
	private int colorOff = 0xFF3F3F3F;
	public int color = colorOn;
	// 0 = on, 1 = off
	public int status = 0;

	
	
	
	
	public void toggle(int mx, int my) {
		if(Interaction.overRect(mx, my, xpos, ypos, width, height) == true) {
			switch(status) {
			case(0):
				status = 1;
				color = colorOff;
				break;
			case(1):
				status = 0;
				color = colorOn;
				break;
			default:
				System.err.println("wrongPowder ERROR! Not correct status at Button toggle method.");
				break;
			}
			System.out.println("BUTTON TOGGLE status " + status);
		}
	}
	
	
	
	
	
	public void press(int mx, int my, int s) {
		if(Interaction.overRect(mx, my, xpos, ypos, width, height) == true) {
			status = s;
		
			switch(s) {
			case(0):
				color = colorOff;
				break;
			case(1):
				color = colorOn;
				break;
			default:
				System.err.println("wrongPowder ERROR! Not correct status at Button press method.");
				break;
			}
		}
		System.out.println("BUTTON PRESS status " + status);
	}
	
	
}