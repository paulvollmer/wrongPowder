/**
 * wrongPowder_p5template
 * by wrongPowder Library.
 *
 * this is a Processing template.
 It contains Properties and Log file Support.
 *
 * @author    Paul Vollmer
 * @modified  2011.11.14
 */

import wrongPowder.calendar.CalendarUtil;
import wrongPowder.io.Config;
import wrongPowder.io.Log;

CalendarUtil time = new CalendarUtil();
Config config = new Config();
Log log = new Log();



void setup() {
  // Initialize Log file.
  log.init(sketchPath("logs") + "/log" + time.timestamp() + ".txt");
  log.info("SETUP start");
  
  // If new Config() is written before, load a configuration File.  
  //config.load("wrongPowder_p5template", "config.txt");
  config.loadStatic(sketchPath("config/") + "appSettings.txt");
  log.info("SETUP config load");
  // Get a Property list.
  config.list();
  
  log.info("SETUP application runtime counter = " + config.getIntProperty("app.count"));
  
  // Get Configuration Properties and set app.width, app.height to w, h variable.
  // 400 is the default value if no property exist.
  int w = config.getIntProperty("app.width", 400);
  int h = config.getIntProperty("app.height", 400);
  size(w, h);
  log.info("SETUP set size width = " + w + ", height = " + h);
  
  // This get method have no default value, use value from wrongPowder.io.Config class.
  // If here is a Null pointer exception, add the app.framerate property
  frameRate(config.getIntProperty("app.framerate"));
}



void draw() {

}



void keyPressed() {
  // TODO: make this by exit the application.
  config.setProperty("app.width", width);
  config.setProperty("app.height", height);
  config.setProperty("app.framerate", (int)frameRate);
  config.store();
  
  // Save a copy to data folder.
  config.store(dataPath("configs/")+"config.txt");
}
