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
  
  // Get the Unixtime
  text("unixtime():", 50, 100);
  int ut = CAL.unixtime();
  text(ut, 180, 100);
  // Get the Unixtime from 2011.10.17
  text("getUnixtime():", 50, 120);
  int getUt = CAL.getUnixtime(2011, 10, 17);
  text(getUt, 180, 120);
  // Get the Timestamp
  text("timestamp():", 50, 140);
  String ts = CAL.timestamp();
  text(ts, 180, 140);
  // Get the Timezone
  text("timezone():", 50, 160);
  String tz = CAL.timezone();
  text(tz, 180, 160);
  
  // Get a Month Name
  text("getMonth():", 50, 200);
  String m = CAL.getMonth(1);
  text(m, 180, 200);
  // Get the Number of days
  text("getMonthDays():", 50, 220);
  int nm = CAL.getMonthDays(1);
  text(nm, 180, 220);
  
  // Get the week in year number
  text("weekInYear():", 50, 260);
  int wiy = CAL.weekInYear();
  text(wiy, 180, 260);
  // Get the day in year number
  text("dayInYear():", 50, 280);
  int diy = CAL.dayInYear();
  text(diy, 180, 280);
}
