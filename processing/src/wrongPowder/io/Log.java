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

import wrongPowder.calendar.CalendarUtil;


/**
 * Config
 * 
 * @example config_basic 
 */
public class Log {
	
	// Use time class for unixtime()
	CalendarUtil time = new CalendarUtil();
	
	private static Logger logger = Logger.getRootLogger();
	
	

	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example config_basic
	 */
	public Log() {}
	
	public Log(String fileName) {
		init(fileName);
	}
	
	
	public void init(String fileName) {
		try {
			SimpleLayout layout = new SimpleLayout();
			ConsoleAppender consoleAppender = new ConsoleAppender(layout);
			logger.addAppender(consoleAppender);
			
			String path = ".."+fileName;
			FileAppender fileAppender = new FileAppender(layout, path);
			
			logger.addAppender(fileAppender);
			// ALL | DEBUG | INFO | WARN | ERROR | FATAL | OFF:
			//logger.setLevel( Level.WARN );
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		info("Log: Initialise Log File.");
	}
	
	
	/**
	 * Print a Message to log file with level DEBUG.
	 * 
	 * @param s Message.
	 */
	public void debug(String s) {
		logger.debug(message(s));
	}
	
	/**
	 * Print a Message to log file with level INFO.
	 * 
	 * @param s Message.
	 */
	public void info(String s) {
		logger.info(message(s));
	}
	
	/**
	 * Print a Message to log file with level WARN.
	 * 
	 * @param s Message.
	 */
	public void warn(String s) {
		logger.warn(message(s));
	}
	
	/**
	 * Print a Message to log file with level ERROR.
	 * 
	 * @param s Message.
	 */
	public void error(String s) {
		logger.error(message(s));
	}
	
	/**
	 * Print a Message to log file with level FATAL.
	 * 
	 * @param s Message.
	 */
	public void fatal(String s) {
		logger.fatal(message(s));
	}
	
	
	/**
	 * 
	 * @param s
	 * @return [unixtime] msg
	 */
	private String message(String msg) {
		return "[" + time.timestamp("HH:mm:ss:SSS") + "] - [" + msg + "]";
	}
	
}