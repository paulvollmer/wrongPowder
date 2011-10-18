/**
 * calendar_basic
 * by wrongPowder Library.
 *
 * desc.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.17
 */


import wrongPowder.calendar.*;

CalendarUtil CAL = new CalendarUtil();


void setup() {
  size(400, 400);
  background(0);
  fill(255);
  
  // Get the Unixtime
  int ut = CAL.unixtime();
  text("unixtime(): "+ut, 50, 100);
  // Get the Unixtime from 2011.10.17
  int getUt = CAL.getUnixtime(2011, 10, 17);
  text("getUnixtime(): "+getUt, 50, 120);
  // Get the Timestamp
  String ts = CAL.timestamp();
  text("timestamp(): "+ts, 50, 140);
  // Get the Timezone
  String tz = CAL.timezone();
  text("timezone(): "+tz, 50, 160);
  
  // Get a Month Name
  String m = CAL.getMonth(1);
  text("getMonth(): "+m, 50, 200);
  // Get the Number of days
  int nm = CAL.getMonthDays(1);
  text("getMonthDays(): "+nm, 50, 220);
  
  // Get the week in year number
  int wiy = CAL.weekInYear();
  text("weekInYear(): "+wiy, 50, 260);
  // Get the day in year number
  int diy = CAL.dayInYear();
  text("dayInYear(): "+diy, 50, 280);
}
