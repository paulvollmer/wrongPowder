/**
 * configBasic
 * by wrongPowder Library.
 *
 * Load a file the "Application Support" or "APPDATA" folder.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.17
 */


import wrongPowder.io.Config;

Config CONFIG = new Config();


void setup() {
  // Load configuration File.  
  CONFIG.load("wrongPowder_configBasic", "config.txt");
  
  // Get Configuration Properties.
  int w = CONFIG.getIntProperty("app.width", 400);
  int h = CONFIG.getIntProperty("app.height", 400);
  
  size(w, h);
  this.frame.setResizable(true);
}


void draw() {
}


// TODO: make this by exit the application.
public void keyPressed() {
  CONFIG.setProperty("app.width", width);
  CONFIG.setProperty("app.height", height);
  CONFIG.store();
}
