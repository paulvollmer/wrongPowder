/**
 * wng.agent library
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

package wrongPowder.info;

import processing.core.PApplet;


/**
 * todo:
 set all classes to this class
 to create a main class
 * 
 * @example wrongAgent
 * @author Paul Vollmer, wrong-entertainment.com
 * 
 */
public class info {

	PApplet p5;

	public final static String LIBRARYNAME = "wng.agent";
	public final static String VERSION = "0.1.0";
	public final static String AUTHOR = "Paul Vollmer";
	public final static String INFO = "Library: " + LIBRARYNAME + " Version: " + VERSION + " by: " + AUTHOR;


	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example wrongAgent
	 * @param theParent
	 */
	public info(PApplet parent) {
		p5 = parent;
		welcome();
	}
        
        /*
	 * welcome text for processing IDE console
	 */
	protected void welcome() {
		System.out.println("### "+LIBRARYNAME+" library "+VERSION+"\n### wng.agent is a library from wrong-entertainment.com\n");
	}

	/**
	 * return the name of the library.
	 * 
	 * @return String
	 */
	public String libraryname() {
		return LIBRARYNAME;
	}

	/**
	 * return the version of the library.
	 * 
	 * @return String
	 */
	public String version() {
		return VERSION;
	}

	/**
	 * return the author of the library.
	 * 
	 * @return String
	 */
	public String author() {
		return AUTHOR;
	}

	/**
	 * return information of the library.
	 * 
	 * @return String
	 */
	public String info() {
		return INFO;
	}
}
