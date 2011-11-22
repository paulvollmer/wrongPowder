/**
 * calendar_advanced
 * by wrongPowder Library.
 *
 * desc.
 *
 * @author              Paul Vollmer
 * @modified            2011.11.22
 * @processing-version  2.0a1
 */


import wrongPowder.calendar.*;

CalendarUtil cal = new CalendarUtil();


void setup() {
  size(1200, 558);
}


void draw() {
  background(0);
  
  // Set the calender row, col size
  int cWidth = 100;
  int cHeight = 18;
  
  textSize(9);
  // draw the calender
  for(int i=0; i<=11; i++) {
    for(int j=0; j<cal.getMonthDays(i+1); j++) {
      // draw ground
      fill(100);
      stroke(0);
      rect(i*cWidth, j*cHeight, cWidth, cHeight);
      // draw text
      fill(0);
      noStroke();
      text((j+1)+" "+cal.getMonth(i+1), i*cWidth+5, j*cHeight+15);
    }
  }
  
}
