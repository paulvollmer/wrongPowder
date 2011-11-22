/**
 * log_basic
 * by wrongPowder Library.
 *
 * Create a Log file at sketchpath or use
 * init(filepath) for custom file directory.
 *
 * @author    Paul Vollmer
 * @modified  2011.11.22
 */


import wrongPowder.io.Log;

Log log = new Log(this);


void setup() {
  // Initialize Log file.
  log.init();
  // or set a path
  //log.init(sketchPath("logs")+"/log.txt");
  
  size(400, 400);
  // Write a line to Log file.
  log.info("SETUP Set size(400 ,400)");
}


void draw() {
}


void mousePressed() {
  // Switch between log.active 0/1
  // if log.active == 0, stop logging to file...
  if(log.active == 0) {
    log.active = 1;
  // ... set to write.
  } else {
    log.active = 0;
  }
}


void mouseDragged() {
  // Set Log level to debug.
  log.debug("Mouse x:"+mouseX+" y:"+mouseY);
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
