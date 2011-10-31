/**
 * log_basic
 * by wrongPowder Library.
 *
 * Create a Log file at sketchpath.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.31
 */


import wrongPowder.io.Log;
import wrongPowder.calendar.CalendarUtil;

CalendarUtil time = new CalendarUtil();
Log log = new Log();


void setup() {
  // Initialize Log file.
  log.init(sketchPath("logs")+"/log.txt");
  
  size(400, 400);
  // Write a line to Log file.
  log.info("Setup: Set size(400 ,400)");
}


void draw() {
}


void mousePressed() {
  // Set Log level to debug.
  log.debug("Mouse x:"+mouseX+" y:"+mouseY);
}

void mouseDragged() {
  // Set Log level to info.
  log.info("Mouse x:"+mouseX+" y:"+mouseY);
}

void mouseReleased() {
  // Set Log level to warn.
  log.warn("Mouse x:"+mouseX+" y:"+mouseY);
}

void keyPressed() {
  // Set Log level to error and fatal.
  log.error("key: " + key);
  log.fatal("keyCode: " + keyCode);
}
