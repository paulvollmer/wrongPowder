/**
 * wngCalendar is a class of the wng.agent library.
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

package wrongPowder.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import processing.core.PApplet;


/**
 * wngCalendar is a class contains returns.
 * http://download.oracle.com/javase/1.4.2/docs/api/java/text/SimpleDateFormat.html
 * 
 * @example wngCalendar
 * @author Paul Vollmer, wrong-entertainment.com
 * 
 */
public class CalendarUtil {

	private PApplet p5;

	public final String MON = "Monday";
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
	 * @example wngCalendar
	 * @param theParent
	 */
	public CalendarUtil(PApplet parent) {
		p5 = parent;
                //welcome();
	}

        /*
	 * welcome text for processing IDE console
	 */
	/*protected void welcome() {
		System.out.println("### START wngCalendar CLASS");
	}*/

	/**
	 * timestamp return a timestamp
	 * 
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
	 * @return int
	 */
	public int unixtime() {
		int[] daysToMonthbegin = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 }; // ohne Schalttag
		int unix_time;
		int y = p5.year();
		int m = p5.month();
		int d = p5.day();

		int Year = y - 1970;
		int schaltjahre = ((y - 1) - 1968) / 4 - ((y - 1) - 1900) / 100 + ((y - 1) - 1600) / 400;
		int Second = p5.second();
		;
		int Minute = p5.minute();
		;
		int Hour = p5.hour();
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
	 * @param y
	 *        int
	 * @param m
	 *        int
	 * @param d
	 *        int
	 * @return int
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
	 * @param y
	 *        int
	 * @param m
	 *        int
	 * @param d
	 *        int
	 * @param hou
	 *        int
	 * @param min
	 *        int
	 * @param sec
	 *        int
	 * @return int
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
	 * @param m
	 *        int
	 * @return String
	 */
	public String getDay(int y, int m, int d) {
		String dname = "### not correct date";
		return dname;
	}

	/**
	 * getMonth return the name of a month as a String
	 * 
	 * @param m
	 *        int
	 * @return String
	 */
	public String getMonth(int m) {
		int im = m;
		String sm = "### not a correct month number";
		if (im == 1) sm = JAN;
		if (im == 2) sm = FEB;
		if (im == 3) sm = MAR;
		if (im == 4) sm = APR;
		if (im == 5) sm = MAY;
		if (im == 6) sm = JUN;
		if (im == 7) sm = JUL;
		if (im == 8) sm = AUG;
		if (im == 9) sm = SEP;
		if (im == 10) sm = OCT;
		if (im == 11) sm = NOV;
		if (im == 12) sm = DEC;
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
