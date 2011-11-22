/**
 * calendar_unixtime
 * by wrongPowder Library.
 *
 * desc.
 *
 * @author              Paul Vollmer
 * @modified            2011.10.18
 * @processing-version  2.0a1
 */


import wrongPowder.calendar.*;

CalendarUtil cal = new CalendarUtil();

int unixtimeStart;


void setup() {
  size(950, 200);
  
  // Save start Unixtime to <unixtimeStart> value
  unixtimeStart = cal.unixtime();
}


void draw() {
  background(0);
  
  textSize(64);
  
  // Draw value name text
  fill(255);
  text("UNIXTIME", 20, 80);
  text("SECONDS RUN", 20, 160);
  
  // Draw value text
  fill(255, 255, 0);
  text(cal.unixtime(), 500, 80);
  // Calculate application seconds
  int secondsRun = cal.unixtime() - unixtimeStart;
  text(secondsRun, 500, 160);
}
