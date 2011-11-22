/**
 * config_basic
 * by wrongPowder Library.
 *
 * Load a file from the "Application Support" (mac) or
 * "APPDATA" (win) folder.
 *
 * @author              Paul Vollmer
 * @modified            2011.10.31
 * @processing-version  2.0a1
 */


import wrongPowder.io.Config;

Config config = new Config();


void setup() {
  // Load configuration File.  
  config.load("wrongPowder_configBasic", "config.txt");
  
  // Get Configuration Properties.
  int w = config.getIntProperty("app.width", 400);
  int h = config.getIntProperty("app.height", 400);
  
  // Set size and frame resizable.
  size(w, h);
  this.frame.setResizable(true);
  
  // Set a new Property variable.
  int customProp = 10;
  config.setProperty("app.custom", customProp);
}


void draw() {
}


public void keyPressed() {
  // TODO: make this by exit the application.
  config.setProperty("app.width", width);
  config.setProperty("app.height", height);
  config.store();
}
