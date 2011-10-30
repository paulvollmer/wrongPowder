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
Log lo = new Log("../Users/wrongMacBookpro/logs/log_" + time.timestamp() + ".txt");


void setup() {
  size(400, 400);
  //lo.init();
}


void draw() {

}


void mousePressed() {
  lo.debug("Mouse x:"+mouseX+" y:"+mouseY);
}


void mouseDragged() {
  lo.info("Mouse x:"+mouseX+" y:"+mouseY);
}


void mouseReleased() {
  lo.warn("Mouse x:"+mouseX+" y:"+mouseY);
}


void keyPressed() {
  lo.error("Mouse x:"+mouseX+" y:"+mouseY);
  lo.fatal("Mouse x:"+mouseX+" y:"+mouseY);
}
