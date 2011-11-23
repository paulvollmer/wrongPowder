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

package wrongPowder;


import processing.core.PApplet;





/**
 * WrongPowder
 * 
 * @example wrongPowder
 */
public class WrongPowder {
	
	// p5 is a reference to the parent sketch
	PApplet p5;
	
	// build.properties variables
	public final static String JAVATARGETJERSION   = "##java.target.version##";
	public final static String PROJECTNAME         = "##project.name##";
	public final static String PROJECTCOMPILE      = "##project.compile##";
	public final static String AUTHORNAME          = "##author.name##";
	public final static String AUTHORURL           = "##author.url##";
	public final static String LIBRARYURL          = "##library.url##";
	public final static String LIBRARYCATEGORY     = "##library.category##";
	public final static String LIBRARYSENTENCE     = "##library.sentence##";
	public final static String VERSION             = "##library.version##";
	public final static String PRETTYVERSION       = "##library.prettyVersion##";
	public final static String SOURCEHOST          = "##source.host##";
	public final static String SOURCEURL           = "##source.url##";
	public final static String SOURCEREPO          = "##source.repository##";
	public final static String TESTEDPLATFORM      = "##tested.platform##";
	public final static String TESTEDP5VERSION     = "##tested.processingVersion##";
	
	
	
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example wrongPowder
	 */
	public WrongPowder(PApplet p) {
		p5 = p;
		
		welcome();
	}
	
	
	
	
	
	private String welcome() {
		String temp = PROJECTNAME + " Version: " + VERSION + 
		              " tested Processing Version: " + TESTEDP5VERSION;
		return temp;
	}
	
	
	
	
	
	/**
	   * Return the Name of the Library.
	   * 
	   * @return String
	   */
	  public static String libraryname() {
	    return PROJECTNAME;
	  }

	  /**
	   * Return the Version of the Library.
	   * 
	   * @return String
	   */
	  public static String version() {
	    return VERSION;
	  }

	  /**
	   * Return the Author of the Library.
	   * 
	   * @return String
	   */
	  public static String author() {
	    return AUTHORNAME;
	  }

	  /**
	   * Return Information of the Library.
	   * 
	   * @return String
	   *
	  public static String info() {
	    return INFO;
	  }*/
	
	
}