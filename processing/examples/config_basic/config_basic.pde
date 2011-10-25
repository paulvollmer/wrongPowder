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

Config config = new Config();


void setup() {
  // Load configuration File.  
  config.load("wrongPowder_configBasic", "config.txt");
  
  // Get Configuration Properties.
  int w = config.getIntProperty("app.width", 400);
  int h = config.getIntProperty("app.height", 400);
  
  size(w, h);
  this.frame.setResizable(true);
}


void draw() {
}


// TODO: make this by exit the application.
public void keyPressed() {
  config.setProperty("app.width", width);
  config.setProperty("app.height", height);
  config.store();
}
