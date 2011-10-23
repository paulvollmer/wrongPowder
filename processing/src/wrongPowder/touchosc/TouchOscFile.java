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

package wrongPowder.touchosc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import processing.core.XML;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
import wrongPowder.util.BASE64;

public class TouchOscFile {
	
	public XML xml;
	private BASE64 base64;
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 *
	 * @param fileName
	 */
	public TouchOscFile(String fileName) {
		load(fileName);
	}
	
	public TouchOscFile() {}
	
	
	/**
	 * Load a TouchOSC file created with TouchOSC Editor.
	 *
	 * @return String FileName
	 */
	public void load(String fileName) {
		base64 = new BASE64();
		
	    try {
	    	ZipFile zf = new ZipFile(fileName);
	    	Enumeration entries = zf.entries();

	    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	    	while (entries.hasMoreElements ()) {
	    		ZipEntry ze = (ZipEntry) entries.nextElement();
	    		
	    		// create xml
	    		xml = xml.parse(inputStreamToString(zf.getInputStream(ze)));
	    		
	    		// Print out the xml file.
	    		System.out.println("\nXML File:\n" + xml);
	    		
	    		// list all children of xml
	    		System.out.println("\nlistChildren:");
	    		String[] list = xml.listChildren();
	    		for(int i=0; i<list.length; i++) {
	    			System.out.println("["+i+"] " + list[i]);
	    		}
	    		
	    		XML[] childs = xml.getChildren();
	    		//System.out.println(childs.length);
	    		
	    		// Check how many tabpages exist.
	    		int numtabpage = 0;
	    		for(int i=1; i<childs.length; i+=2) {
	    			// If a child is tabpage
	    			if(childs[i].getName() == "tabpage") {
	    				numtabpage++;
	    			}
	    		}
	    		System.out.println("\nNumber of TabPages: " + numtabpage);
	    		
	    		
	    		// Decode name String.
	            //String decoded = new String(new BASE64Decoder().decodeBuffer("cGFnZTI="),"UTF-8");
	    		String decoded = base64.decode("cGFnZTQ=", "UTF-8");
	            System.out.println(decoded);
	    		
	    	}
	    }
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	
	/**
	 * inputStreamToString
	 * 
	 * @param in
	 * @return String
	 * @throws IOException
	 */
	private String inputStreamToString(InputStream in) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		
		while ( (line = bufferedReader.readLine ()) != null) {
			stringBuilder.append(line + "\n");
		}
		
		bufferedReader.close();
		return stringBuilder.toString();
	}
	
	
	/**
	 * Get the Version of TouchOSC Editor.
	 * 
	 * @return version
	 */
	public int version() {
		return xml.getInt("version");
	}
	
	/**
	 * Get the Layout Size of the TouchOSC file.<br>
	 * 0 = iPhone/iPod Touch<br>
	 * 1 = iPad
	 * 
	 * @return mode
	 */
	public int mode() {
		return xml.getInt("mode");
	}
	
	/**
	 * Get the Layout Orientation of the TouchOSC file.<br>
	 * vertical or horizontal
	 * 
	 * @return orientation
	 */
	public String orientation() {
		return xml.getString("orientation");
	}
	
	
	/*public int numTabs() {
		
		return;
	}*/
	
	
	
}