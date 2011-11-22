/**
 * config_advanced
 * by wrongPowder Library.
 *
 * To load a file from a static filepath.
 * The loadStatic method not search a file
 * at the "Application Support" or "APPDATA" folder.
 *
 * @author              Paul Vollmer
 * @modified            2011.10.31
 * @processing-version  2.0a1
 */

import wrongPowder.io.Config;

// Create new configuration Object...
Config config = new Config();
// ... or create and load configuration file.
// This workflow load the Properties file at first!
//Config config = new Config("wrongPowder_configAdvanced", "config.txt");

// Set a new variable for Property to store how many clicks are counted.
int customMouseProp = 0;


void setup() {
  // If new Config() is written before, load a configuration File.  
  config.load("wrongPowder_configAdvanced", "config.txt");
  // Or load the file from a static path.
  //config.loadStatic(dataPath("configFolder/")+"configFile.txt");
  
  // For Debugging...
  // Get the number of Property Elements.
  println("Number of Property Elements: " + config.getSize());
  // Get a Property list.
  config.list();
  
  // Get Configuration Properties and set app.width, app.height to w, h variable.
  // 400 is the default value if no property exist.
  int w = config.getIntProperty("app.width", 400);
  int h = config.getIntProperty("app.height", 400);
  
  // Set size and frame resizable.
  size(w, h);
  this.frame.setResizable(true);
  
  // This get method have no default value, use value from wrongPowder.io.Config class.
  frameRate(config.getIntProperty("app.framerate"));
  
}



void draw() {
  
}



void mousePressed() {
  // Add +1 to click counter.
  customMouseProp++;
  // Update Property Element.
  config.setProperty("app.mousePressed", customMouseProp);
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
