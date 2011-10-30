/**
 * log_basic
 * by wrongPowder Library.
 *
 * desc.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.25
 */


import wrongPowder.io.Log;
import wrongPowder.calendar.CalendarUtil;

CalendarUtil time = new CalendarUtil();
Log lo = new Log("../Users/wrongMacBookpro/logs/log_" + time.timestamp() + ".txt");//"+time.unixtime()+".txt");

void setup() {
  size(400, 400);
  lo.init();
  //dataPath("/logs/wng.txt"));
}


void draw() {
  lo.println("framecount: "+frameCount);
}
