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

CalendarUtil CAL = new CalendarUtil(this);


void setup() {
  size(600, 600);
  
  // Get the Unixtime.
  println(CAL.unixtime());
}