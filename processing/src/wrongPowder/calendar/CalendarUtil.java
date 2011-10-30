/**
 *  wrongPowder is developed by wrong-entertainment & powder
 *
 *
 *  Copyright 2011 Paul Vollmer
 *  paulvollmer.net
 *  vollmerpaul@yahoo.de
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
 *  @author		Paul Vollmer
 *  @modified	##date##
 *  @version	##version##
 */

package wrongPowder.calendar;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;


/**
 * CalendarUtil
 * http://download.oracle.com/javase/1.4.2/docs/api/java/text/SimpleDateFormat.html
 * 
 * @example calendar_basic
 */
public class CalendarUtil {

	public final String	MON = "Monday";
	public final String TUE = "Tuesday";
	public final String WED = "Wednesday";
	public final String THU = "Thursday";
	public final String FRI = "Friday";
	public final String SAT = "Saturday";
	public final String SUN = "Sunday";

	public final String JAN = "Janurary";
	public final String FEB = "February";
	public final String MAR = "March";
	public final String APR = "April";
	public final String MAY = "May";
	public final String JUN = "Juni";
	public final String JUL = "July";
	public final String AUG = "August";
	public final String SEP = "September";
	public final String OCT = "October";
	public final String NOV = "November";
	public final String DEC = "Decenber";

	public final int JAN_DAYS = 31;
	public final int FEB_DAYS = 28;
	public final int MAR_DAYS = 31;
	public final int APR_DAYS = 30;
	public final int MAY_DAYS = 31;
	public final int JUN_DAYS = 30;
	public final int JUL_DAYS = 31;
	public final int AUG_DAYS = 31;
	public final int SEP_DAYS = 30;
	public final int OCT_DAYS = 31;
	public final int NOV_DAYS = 30;
	public final int DEC_DAYS = 31;
	
	
	
	/**
	 * wngCalendar a Constructor, usually called in the setup() method in your
	 * sketch to initialize and start the class.
	 * 
	 * @example calendar_basic
	 * @param theParent
	 */
	public CalendarUtil() {
	}
	
	

	/**
	 * timestamp
	 * 
	 * @example calendar_basic
	 * @return String timestamp
	 */
	public String timestamp(String customized) {
		SimpleDateFormat sdf = new SimpleDateFormat(customized);
		String ts = sdf.format(new Date());
		return ts;
	}
	
	public String timestamp() {
		return timestamp("yyyyMMdd_HHmmss");
	}
	
	
	
	/**
	 * timezone
	 * 
	 * @example calendar_basic
	 * @return String timezone
	 */
	public String timezone() {
		SimpleDateFormat sdf = new SimpleDateFormat("zzzzz");
		String ts = sdf.format(new Date());
		return ts;
	}

	/**
	 * unixtime
	 * 
	 * @example calendar_unixtime
	 * @return int The unixtime as an integer.
	 */
	public int unixtime() {
		int[] daysToMonthbegin = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 }; // ohne Schalttag
		int unix_time;
		Calendar toDay = Calendar.getInstance();
		int y = toDay.get(Calendar.YEAR);
		int m = toDay.get(Calendar.MONTH);
		int d = toDay.get(Calendar.DAY_OF_MONTH);

		int Year = y - 1970;
		int schaltjahre = ((y - 1) - 1968) / 4 - ((y - 1) - 1900) / 100 + ((y - 1) - 1600) / 400;
		int Second = toDay.get(Calendar.SECOND);
		int Minute = toDay.get(Calendar.MINUTE);
		int Hour = toDay.get(Calendar.HOUR);
		
		unix_time = Second + 60 * Minute + 60 * 60 * Hour
				    + (daysToMonthbegin[m - 1] + d - 1) * 60 * 60 * 24
				    + (Year * 365 + schaltjahre) * 60 * 60 * 24;

		if ((m > 2) && (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)))
			unix_time += 60 * 60 * 24; // +Schalttag wenn jahr Schaltjahr ist
		return unix_time;
	}

	/**
	 * eraDesignator return a era designator
	 * 
	 * @example calendar_basic
	 * @return String 
	 */
	public String eraDesignator() {
		SimpleDateFormat sdf = new SimpleDateFormat("G");
		String ts = sdf.format(new Date());
		return ts;
	}

	/**
	 * weekInYear
	 * 
	 * @example calendar_basic
	 * @return int week in year 
	 */
	public int weekInYear() {
		SimpleDateFormat sdf = new SimpleDateFormat("w");
		String ts = sdf.format(new Date());
		int tts = Integer.parseInt(ts);
		return tts;
	}

	/**
	 * weekInMonth
	 * 
	 * @example calendar_basic
	 * @return int week in month
	 */
	public int weekInMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("W");
		String ts = sdf.format(new Date());
		int tts = Integer.parseInt(ts);
		return tts;
	}

	/**
	 * dayInYear
	 * 
	 * @example calendar_basic
	 * @return int day in year
	 */
	public int dayInYear() {
		SimpleDateFormat sdf = new SimpleDateFormat("D");
		String ts = sdf.format(new Date());
		int tts = Integer.parseInt(ts);
		return tts;
	}

	/**
	 * dayInMonth
	 * 
	 * @example calendar_basic
	 * @return int day in month
	 */
	public int dayInMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("d");
		String ts = sdf.format(new Date());
		int tts = Integer.parseInt(ts);
		return tts;
	}

	/**
	 * dayInWeek
	 * 
	 * @example calendar_basic
	 * @return String day in week
	 */
	public String dayInWeek() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEEE");
		String ts = sdf.format(new Date());
		return ts;
	}

	/**
	 * getUnixtime
	 * 
	 * @example calendar_basic
	 * @param y int Year
	 * @param m int Month
	 * @param d int Day
	 * @return int the unixtime of a date as an integer
	 */
	public int getUnixtime(int y, int m, int d) {
		String dname = "### not correct date";
		int[] daysToMonthbegin = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273,
				304, 334 }; // ohne Schalttag
		int unix_time;
		int Year = y - 1970;
		int schaltjahre = ((y - 1) - 1968) / 4 - ((y - 1) - 1900) / 100
				+ ((y - 1) - 1600) / 400;
		int Second = 1;
		int Minute = 1;
		int Hour = 1;
		unix_time = Second + 60 * Minute + 60 * 60 * Hour
				+ (daysToMonthbegin[m - 1] + d - 1) * 60 * 60 * 24
				+ (Year * 365 + schaltjahre) * 60 * 60 * 24;

		if ((m > 2) && (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)))
			unix_time += 60 * 60 * 24; /* +Schalttag wenn jahr Schaltjahr ist */
		return unix_time;
	}

	/**
	 * getUnixtime
	 * 
	 * @param y int Year
	 * @param m int Month
	 * @param d int Day
	 * @param hou int Hour
	 * @param min int Minute
	 * @param sec int Second
	 * @return int unixtime of a date as an integer
	 */
	public int getUnixtime(int y, int m, int d, int hou, int min, int sec) {
		String dname = "### not correct date";
		int[] daysToMonthbegin = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273,
				304, 334 }; // ohne Schalttag
		int unix_time;
		int Year = y - 1970;
		int schaltjahre = ((y - 1) - 1968) / 4 - ((y - 1) - 1900) / 100
				+ ((y - 1) - 1600) / 400;
		int Second = sec;
		int Minute = min;
		int Hour = hou;
		unix_time = Second + 60 * Minute + 60 * 60 * Hour
				+ (daysToMonthbegin[m - 1] + d - 1) * 60 * 60 * 24
				+ (Year * 365 + schaltjahre) * 60 * 60 * 24;

		if ((m > 2) && (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)))
			unix_time += 60 * 60 * 24; /* +Schalttag wenn jahr Schaltjahr ist */
		return unix_time;
	}

	/**
	 * getDay
	 * TODO: The name of a day as a String.
	 *
	 * @param y int Year
	 * @param m int Month
	 * @param d int Day
	 * @return String 
	 */
	public String getDay(int y, int m, int d) {
		String dname = "### not correct date";
		return dname;
	}

	/**
	 * getMonth
	 * 
	 * @param m int Month
	 * @return String The name of a month as a String
	 */
	public String getMonth(int m) {
		String sm;
		
		switch(m) {
		case 1:
			sm = JAN;
			break;
		case 2:
			sm = FEB;
			break;
		case 3:
			sm = MAR;
			break;
		case 4:
			sm = APR;
			break;
		case 5:
			sm = MAY;
			break;
		case 6:
			sm = JUN;
			break;
		case 7:
			sm = JUL;
			break;
		case 8:
			sm = AUG;
			break;
		case 9:
			sm = SEP;
			break;
		case 10:
			sm = OCT;
			break;
		case 11:
			sm = NOV;
			break;
		case 12:
			sm = DEC;
			break;
		default:
			System.err.println("### not a correct month number");
			sm = "default";
			break;
		}
		
		return sm;
	}

	/**
	 * getMonth
	 * 
	 * @param m String
	 * @return int The name of a month as a integer.
	 */
	public int getMonth(String m) {
		int im = 0;
		
		if(m == JAN) im = 1;
		if(m == FEB) im = 2;
		if(m == MAR) im = 3;
		if(m == APR) im = 4;
		if(m == MAY) im = 5;
		if(m == JUN) im = 6;
		if(m == JUL) im = 7;
		if(m == AUG) im = 8;
		if(m == SEP) im = 9;
		if(m == OCT) im = 10;
		if(m == NOV) im = 11;
		if(m == DEC) im = 12;
		
		return im;
	}

	/**
	 * getMonthDays
	 * 
	 * @param m int
	 * @return int The days number of a month as a integer.
	 */
	public int getMonthDays(int m) {
		int im;
		
		switch(m) {
		case 1:
			im = JAN_DAYS;
			break;
		case 2:
			im = FEB_DAYS;
			break;
		case 3:
			im = MAR_DAYS;
			break;
		case 4:
			im = APR_DAYS;
			break;
		case 5:
			im = MAY_DAYS;
			break;
		case 6:
			im = JUN_DAYS;
			break;
		case 7:
			im = JUL_DAYS;
			break;
		case 8:
			im = AUG_DAYS;
			break;
		case 9:
			im = SEP_DAYS;
			break;
		case 10:
			im = OCT_DAYS;
			break;
		case 11:
			im = NOV_DAYS;
			break;
		case 12:
			im = DEC_DAYS;
			break;
		default:
			System.err.println("### not a correct month number");
			im = 0;
			break;
		}
		
		return im;
	}

	/**
	 * getMonthDays
	 * 
	 * @param m String
	 * @return int The days number of a month as a integer 
	 */
	public int getMonthDays(String m) {
		int im = 0;
		
		if(m == JAN) im = JAN_DAYS;
		if(m == FEB) im = FEB_DAYS;
		if(m == MAR) im = MAR_DAYS;
		if(m == APR) im = APR_DAYS;
		if(m == MAY) im = MAY_DAYS;
		if(m == JUN) im = JUN_DAYS;
		if(m == JUL) im = JUL_DAYS;
		if(m == AUG) im = AUG_DAYS;
		if(m == SEP) im = SEP_DAYS;
		if(m == OCT) im = OCT_DAYS;
		if(m == NOV) im = NOV_DAYS;
		if(m == DEC) im = DEC_DAYS;
		
		return im;
	}
	
	
}
