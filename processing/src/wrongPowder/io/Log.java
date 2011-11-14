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

import wrongPowder.calendar.CalendarUtil;


/**
 * Log
 * 
 * @example log_basic 
 */
public class Log {
	
	public static int active = 0;
	
	// Use time class for unixtime().
	private static CalendarUtil time = new CalendarUtil();
	// Logger Variable.
	private static Logger logger = Logger.getRootLogger();
	
	
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example log_basic
	 */
	public Log() {}
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example log_basic
	 * @param fileName
	 */
	public Log(String fileName) {
		init(fileName);
	}
	
	
	
	
	/**
	 * Initialize the log file.
	 * 
	 * @param path Path to save file.
	 */
	public void init(String path) {
		try {
			SimpleLayout layout = new SimpleLayout();
			ConsoleAppender consoleAppender = new ConsoleAppender(layout);
			logger.addAppender(consoleAppender);
			
			FileAppender fileAppender = new FileAppender(layout, ".."+path);
			
			logger.addAppender(fileAppender);
			// ALL | DEBUG | INFO | WARN | ERROR | FATAL | OFF:
			//logger.setLevel( Level.WARN );
			
			// Set active to 0 (log to console and file).
			//active = 0;
			
			info("LOG Initialise File.");
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	
	
	
	/**
	 * Print a Message to log file with level DEBUG.
	 * 
	 * @param s Message.
	 */
	public void debug(String s) {
		switch(active) {
			// Log message.
			case(0):
				logger.debug(message(s));
			break;
			// Do nothing.
			case(1):
				break;
			// Print Error message to console.
			default:
				System.err.println("wrongPowder ERROR! logActive not correct\nuse 0 for on, 1 for off.");
				break;
		}
		
	}
	
	
	
	
	/**
	 * Print a Message to log file with level INFO.
	 * 
	 * @param s Message.
	 */
	public static void info(String s) {
		switch(active) {
		// Log message.
		case(0):
			logger.info(message(s));
			break;
		// Do nothing.
		case(1):
			break;
		// Print Error message to console.
		default:
			System.err.println("wrongPowder ERROR! logActive not correct\nuse 0 for on, 1 for off.");
			break;
		}
	}
	
	
	
	
	/**
	 * Print a Message to log file with level WARN.
	 * 
	 * @param s Message.
	 */
	public void warn(String s) {
		switch(active) {
		// Log message.
		case(0):
			logger.warn(message(s));
			break;
		// Do nothing.
		case(1):
			break;
		// Print Error message to console.
		default:
			System.err.println("wrongPowder ERROR! logActive not correct\nuse 0 for on, 1 for off.");
			break;
		}
	}
	
	
	
	
	/**
	 * Print a Message to log file with level ERROR.
	 * 
	 * @param s Message.
	 */
	public void error(String s) {
		switch(active) {
		// Log message.
		case(0):
			logger.error(message(s));
			break;
		// Do nothing.
		case(1):
			break;
		// Print Error message to console.
		default:
			System.err.println("wrongPowder ERROR! logActive not correct\nuse 0 for on, 1 for off.");
			break;
		}
	}
	
	
	
	
	/**
	 * Print a Message to log file with level FATAL.
	 * 
	 * @param s Message.
	 */
	public void fatal(String s) {
		switch(active) {
		// Log message.
		case(0):
			logger.fatal(message(s));
			break;
		// Do nothing.
		case(1):
			break;
		// Print Error message to console.
		default:
			System.err.println("wrongPowder ERROR! logActive not correct\nuse 0 for on, 1 for off.");
			break;
		}
	}
	
	
	
	
	/**
	 * Use to create the message with timestamp.
	 * 
	 * @param msg
	 * @return [unixtime] - [msg]
	 */
	private static String message(String msg) {
		return "[" + time.timestamp("yyyy:MM:dd_HH:mm:ss:SSS") + "] " + msg;
	}
	
	
}