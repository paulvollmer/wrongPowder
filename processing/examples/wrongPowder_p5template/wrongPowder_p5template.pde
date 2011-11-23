/**
 * wrongPowder_p5template
 * by wrongPowder Library.
 *
 * This is a Processing template.
 * It contains Properties and Log file Support.
 *
 * @author              Paul Vollmer
 * @modified            2011.11.23
 * @processing-version  2.0a1
 */

import wrongPowder.calendar.CalendarUtil;
import wrongPowder.io.Config;
import wrongPowder.io.Log;

CalendarUtil time = new CalendarUtil();
Config config = new Config();
Log log = new Log(this);

int BACKGROUNDCOLOR;





/**
 * Processing setup
 */
void setup() {
  // Initialize Log file.
  log.init();
  log.info("LOG Inizialized");
  log.info("SETUP Start");
  
  // Load a config file from sketchpath.
  String configpath = sketchPath("config/") + "appSettings.txt";
  config.loadStatic(configpath);
  log.info("CONFIG file "+configpath+" loaded");
  // Get a Property list.
  config.list();
  
  // Get the Application runtime counter.
  log.info("CONFIG Application runtime counter: " + config.getIntProperty("app.count"));
  
  // Get Configuration Properties and set app.width, app.height to w, h variable.
  // 400 is the default value if no property exist.
  int w = config.getIntProperty("app.width", 400);
  int h = config.getIntProperty("app.height", 400);
  size(w, h);
  log.info("SETUP Set size to CONFIG width: " + w + ", height: " + h);
  
  // This get method have no default value, use value from wrongPowder.io.Config class.
  // If here is a Null pointer exception, add the app.framerate property 
  frameRate(config.getIntProperty("app.framerate"));
  log.info("SETUP Set framerate: " + (int)frameRate);
  
  this.frame.setTitle(config.getStringProperty("app.titlebarname", "wrongPowder Template"));
  
  BACKGROUNDCOLOR = config.getIntProperty("app.backgroundcolor", 30);
}





/**
 * Processing draw
 */
void draw() {
  background(BACKGROUNDCOLOR);

}





/**
 * Processing mousePressed
 */
void mousePressed() {
  log.info("MOUSEPRESSED mouse x: " + mouseX + ", y: " + mouseY);
}





/**
 * Processing mouseDragged
 */
void mouseDragged() {
  log.info("MOUSEDRAGGED mouse x: " + mouseX + ", y: " + mouseY);
}





/**
 * Processing mouseReleased
 */
void mouseReleased() {
  log.info("MOUSERELEASED mouse x: " + mouseX + ", y: " + mouseY);
}





/**
 * Processing keyPressed
 */
void keyPressed() {
  log.info("KEYPRESSED key: " + key + ", keyCode: " + keyCode);
  
  // TODO: make this by exit the application.
  config.setProperty("app.width", width);
  config.setProperty("app.height", height);
  config.store();
  
  // Save a copy to data folder.
  config.store(dataPath("configs/")+"config.txt");
}





/**
 * Processing KeyReleased
 */
void KeyReleased() {
  log.info("KEYRELEASED key: " + key + "keyCode: " + keyCode);
}

