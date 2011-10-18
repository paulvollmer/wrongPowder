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
//import processing.core.PApplet;


/**
 * wngCalendar is a class contains returns.
 * http://download.oracle.com/javase/1.4.2/docs/api/java/text/SimpleDateFormat.html
 * 
 * @example wngCalendar
 * @author Paul Vollmer, wrong-entertainment.com
 * 
 */
public class CalendarUtil implements CalendarConstants {

	//private PApplet p5;

	
	/**
	 * wngCalendar a Constructor, usually called in the setup() method in your
	 * sketch to initialize and start the class.
	 * 
	 * @example calendar_basic
	 * @param theParent
	 */
	public CalendarUtil() {//PApplet parent) {
		//p5 = parent;
	}
	
	

	/**
	 * timestamp return a timestamp
	 * 
	 * @example calendar_basic
	 * @return String
	 */
	public String timestamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String ts = sdf.format(new Date());
		return ts;
	}
	
	
	
	/**
	 * timezone return a timezone
	 * 
	 * @example calendar_basic
	 * @return String
	 */
	public String timezone() {
		SimpleDateFormat sdf = new SimpleDateFormat("zzzzz");
		String ts = sdf.format(new Date());
		return ts;
	}

	/**
	 * unixtime return the unixtime as an integer
	 * 
	 * @example calendar_basic
	 * @return int
	 */
	public int unixtime() {
		int[] daysToMonthbegin = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 }; // ohne Schalttag
		int unix_time;
		Calendar toDay = Calendar.getInstance();
		int y = toDay.get(Calendar.YEAR);
		int m = toDay.get(Calendar.MONTH);
		int d = toDay.get(Calendar.DAY_OF_MONTH);
		/*int y = p5.year();
		int m = p5.month();
		int d = p5.day();*/

		int Year = y - 1970;
		int schaltjahre = ((y - 1) - 1968) / 4 - ((y - 1) - 1900) / 100 + ((y - 1) - 1600) / 400;
		int Second = toDay.get(Calendar.SECOND);
		;
		int Minute = toDay.get(Calendar.MINUTE);
		;
		int Hour = toDay.get(Calendar.HOUR);
		;
		unix_time = Second + 60 * Minute + 60 * 60 * Hour
				    + (daysToMonthbegin[m - 1] + d - 1) * 60 * 60 * 24
				    + (Year * 365 + schaltjahre) * 60 * 60 * 24;

		if ((m > 2) && (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)))
			unix_time += 60 * 60 * 24; /* +Schalttag wenn jahr Schaltjahr ist */
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
	 * weekInYear return week in year
	 * 
	 * @example calendar_basic
	 * @return int
	 */
	public int weekInYear() {
		SimpleDateFormat sdf = new SimpleDateFormat("w");
		String ts = sdf.format(new Date());
		int tts = Integer.parseInt(ts);
		return tts;
	}

	/**
	 * weekInMonth return week in month
	 * 
	 * @example calendar_basic
	 * @return int
	 */
	public int weekInMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("W");
		String ts = sdf.format(new Date());
		int tts = Integer.parseInt(ts);
		return tts;
	}

	/**
	 * dayInYear return day in year
	 * 
	 * @example calendar_basic
	 * @return int
	 */
	public int dayInYear() {
		SimpleDateFormat sdf = new SimpleDateFormat("D");
		String ts = sdf.format(new Date());
		int tts = Integer.parseInt(ts);
		return tts;
	}

	/**
	 * dayInMonth return day in month
	 * 
	 * @example calendar_basic
	 * @return int
	 */
	public int dayInMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("d");
		String ts = sdf.format(new Date());
		int tts = Integer.parseInt(ts);
		return tts;
	}

	/**
	 * dayInWeek return day in week
	 * 
	 * @example calendar_basic
	 * @return String
	 */
	public String dayInWeek() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEEE");
		String ts = sdf.format(new Date());
		return ts;
	}

	/**
	 * getUnixtime return the unixtime of a date as an integer
	 * 
	 * @example calendar_basic
	 * @param y int year
	 * @param m int month
	 * @param d int day
	 * @return int unixtime
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
	 * getUnixtime return the unixtime of a date as an integer
	 * 
	 * @param y int
	 * @param m int
	 * @param d int
	 * @param hou int
	 * @param min int
	 * @param sec in
	 * @return int unixtime
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
	 * getDay return the name of a day as a String
	 *
	 * @param y int
	 * @param m int
	 * @param d int
	 * @return String
	 */
	public String getDay(int y, int m, int d) {
		String dname = "### not correct date";
		return dname;
	}

	/**
	 * getMonth return the name of a month as a String
	 * 
	 * @param m int
	 * @return String
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
	 * getMonth return the name of a month as a integer
	 * 
	 * @param m
	 *        String
	 * @return int
	 */
	public int getMonth(String m) {
		String sm = m;
		int im = 0;
		if (sm == JAN) im = 1;
		if (sm == FEB) im = 2;
		if (sm == MAR) im = 3;
		if (sm == APR) im = 4;
		if (sm == MAY) im = 5;
		if (sm == JUN) im = 6;
		if (sm == JUL) im = 7;
		if (sm == AUG) im = 8;
		if (sm == SEP) im = 9;
		if (sm == OCT) im = 10;
		if (sm == NOV) im = 11;
		if (sm == DEC) im = 12;
		return im;
	}

	/**
	 * getMonthDays return the days number of a month as a integer
	 * 
	 * @param m
	 *        int
	 * @return int
	 */
	public int getMonthDays(int m) {
		int im = m;
		int sm = 0;
		if (im == 1)sm = JAN_DAYS;
		if (im == 2)sm = FEB_DAYS;
		if (im == 3)sm = MAR_DAYS;
		if (im == 4)sm = APR_DAYS;
		if (im == 5)sm = MAY_DAYS;
		if (im == 6)sm = JUN_DAYS;
		if (im == 7)sm = JUL_DAYS;
		if (im == 8)sm = AUG_DAYS;
		if (im == 9)sm = SEP_DAYS;
		if (im == 10)sm = OCT_DAYS;
		if (im == 11)sm = NOV_DAYS;
		if (im == 12)sm = DEC_DAYS;
		return sm;
	}

	/**
	 * getMonthDays return the days number of a month as a integer
	 * 
	 * @param m
	 *        String
	 * @return int
	 */
	public int getMonthDays(String m) {
		String sm = m;
		int im = 0;
		if (sm == JAN) im = JAN_DAYS;
		if (sm == FEB) im = FEB_DAYS;
		if (sm == MAR) im = MAR_DAYS;
		if (sm == APR) im = APR_DAYS;
		if (sm == MAY) im = MAY_DAYS;
		if (sm == JUN) im = JUN_DAYS;
		if (sm == JUL) im = JUL_DAYS;
		if (sm == AUG) im = AUG_DAYS;
		if (sm == SEP) im = SEP_DAYS;
		if (sm == OCT) im = OCT_DAYS;
		if (sm == NOV) im = NOV_DAYS;
		if (sm == DEC) im = DEC_DAYS;
		return im;
	}
}
