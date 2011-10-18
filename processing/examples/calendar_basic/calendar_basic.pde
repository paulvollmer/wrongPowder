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
  size(600, 600);
  
  // Get the Unixtime.
  println("### unixtime(): \t"+CAL.unixtime());
  println("### getUnixtime(): \t"+CAL.getUnixtime(2011, 10, 17));
  println("### timestamp(): \t"+CAL.timestamp());
  println("### timezone(): \t"+CAL.timezone());
  
  for(int i=1; i<=12; i++) {
    println("### getMonth(): \t"+CAL.getMonth(i));
    println("### getMonthDays(): \t"+CAL.getMonthDays(i));
    
  }
  
  println("### weekInYear(): \t"+CAL.weekInYear());
  println("### dayInYear(): \t"+CAL.dayInYear());
  
}
