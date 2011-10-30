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

package wrongPowder.io;



import org.apache.log4j.*;
import org.apache.log4j.lf5.util.LogMonitorAdapter;


/**
 * Config
 * 
 * @example config_basic 
 */
public class Log {

	private String fileName;
	private static Logger logger = Logger.getRootLogger();
	
	

	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example config_basic
	 */
	public Log() {}
	
	public Log(String fileName) {
		this.fileName = fileName;
		init();
	}
	
	public void init() {
		try {
			SimpleLayout layout = new SimpleLayout();
				ConsoleAppender consoleAppender = new ConsoleAppender(layout);
				logger.addAppender( consoleAppender );
				FileAppender fileAppender = new FileAppender(layout, fileName);
				logger.addAppender(fileAppender);
				// ALL | DEBUG | INFO | WARN | ERROR | FATAL | OFF:
				//logger.setLevel( Level.WARN );
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		logger.debug("Meine Debug-Meldung");
		logger.info("Meine Info-Meldung");
		logger.warn("Meine Warn-Meldung");
		logger.error("Meine Error-Meldung");
		logger.fatal("Meine Fatal-Meldung");
	}
	
	
	public void println(String s) {
		logger.info(s);
	}
	
	
	
}