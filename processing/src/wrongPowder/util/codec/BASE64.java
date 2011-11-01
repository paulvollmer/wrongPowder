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

package wrongPowder.util.codec;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;



/**
 * Base64
 * 
 * @example codec_basic 
 */
public class Base64 {	
	

	/**
	 * A Constructor, usually called in the <code>setup()</code> method in your sketch to
	 * initialize and start the library.<br>
	 * More information about Base64 at <a href="http://en.wikipedia.org/wiki/Base64">wikipedia</a>.
	 * 
	 * @example codec_basic
	 */
	public Base64() {}
	
	
	/**
	 * Encode a String with Base64.
	 * 
	 * @example codec_basic
	 * @param input Text String.
	 * @param format Text Format like UTF-8 etc.
	 * @return The encoded String.
	 */
	public String encode(String input, String format) {
		String encoded = null;
		try {
			encoded = new BASE64Encoder().encode(input.getBytes(format));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encoded;
	}
	
	/**
	 * Encode a String with Base64 and Text Format UTF-8.
	 * 
	 * @param input Text String.
	 * @return The encoded String.
	 */
	public String encode(String input) {
		return encode(input, "UTF-8");
	}
	
	
	/**
	 * Encode a Integer with Base64.
	 * 
	 * @param input Integer value.
	 * @param format Text Format like UTF-8 etc.
	 * @return The encoded String.
	 */
	public String encode(int input, String format) {
		return encode(String.valueOf(input), format);
	}
	
	/**
	 * Encode a Integer with Base64 and Text Format UTF-8.
	 * 
	 * @param input Integer value.
	 * @return The encoded String.
	 */
	public String encode(int input) {
		return encode(String.valueOf(input), "UTF-8");
	}
	
	
	/**
	 * Encode a Float with Base64.
	 * 
	 * @param input Float value.
	 * @param format Text Format like UTF-8 etc.
	 * @return The encoded String.
	 */
	public String encode(float input, String format) {
		return encode(String.valueOf(input), format);
	}
	
	/**
	 * Encode a Float with Base64 and Text Format UTF-8.
	 * 
	 * @param input Float value.
	 * @return The encoded String.
	 */
	public String encode(float input) {
		return encode(String.valueOf(input), "UTF-8");
	}
	
	
	/**
	 * Decode a String with Base64.
	 * 
	 * @example codec_basic
	 * @param input Text String.
	 * @param format Text Format like UTF-8 etc.
	 * @return The decoded String.
	 */
	public static String decode(String input, String format){
		String decoded = null;
		try {
			decoded = new String(new BASE64Decoder().decodeBuffer(input),format);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return decoded;
	}
	
	/**
	 * Decode a String with Base64 and Text Format UTF-8.
	 * 
	 * @param input Text String.
	 * @return The decoded String.
	 */
	public static String decode(String input) {
		return decode(input, "UTF-8");
	}
 	
}