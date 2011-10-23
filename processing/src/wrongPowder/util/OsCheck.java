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

package wrongPowder.util;



/**
 * Util
 * 
 * @example util_basic 
 */
public class OsCheck {	
	

	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example util_basic
	 */
	public OsCheck() {}
	
	
	/**
	 * isWin
	 * Check if the Operating System is Windows.
	 * 
	 * @return win String
	 */
	public static boolean isWindows() {
		String os = System.getProperty("os.name").toLowerCase();
	    return (os.indexOf( "win" ) >= 0); 
	}
 
	/**
	 * isMac
	 * Check if the Operating System is Mac.
	 * 
	 * @return mac String
	 */
	public static boolean isMac() {
		String os = System.getProperty("os.name").toLowerCase();
	    return (os.indexOf( "mac" ) >= 0); 
	}
 
	/**
	 * isUnix
	 * Check if the Operating System is Unix.
	 * 
	 * @return nix or nux String
	 */
	public static boolean isUnix() {
		String os = System.getProperty("os.name").toLowerCase();
	    return (os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0);
	}
	
	
}