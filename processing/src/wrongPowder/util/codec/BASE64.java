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
 * BASE64
 * 
 * @example util_basic 
 */
public class BASE64 {	
	

	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example util_basic
	 */
	public BASE64() {}
	
	
	/**
	 * Encode a string with BASE64.
	 * 
	 * @param input
	 * @param format
	 * @return The encoded string.
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public String encode(String input, String format) throws UnsupportedEncodingException {
		String encoded = new BASE64Encoder().encode(input.getBytes(format));
		return encoded;
	}
	
	public String encode(String input) throws UnsupportedEncodingException {
		String encoded = new BASE64Encoder().encode(input.getBytes("UTF-8"));
		return encoded;
	}
	
	
	/**
	 * Decode a String with BASE64.
	 * 
	 * @param input
	 * @param format
	 * @return The decoded string.
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public String decode(String input, String format) throws UnsupportedEncodingException, IOException {
		String decoded = new String(new BASE64Decoder().decodeBuffer(input),format);
		return decoded;
	}
	
	public String decode(String input) throws UnsupportedEncodingException, IOException {
		String decoded = new String(new BASE64Decoder().decodeBuffer(input),"UTF-8");
		return decoded;
	}
 	
}