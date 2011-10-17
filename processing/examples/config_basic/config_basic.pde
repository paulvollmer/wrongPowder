/**
 * configBasic
 * by wrongPowder Library.
 *
 * Load a file the "Application Support" or "APPDATA" folder.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.17
 */


import wrongPowder.config.*;

config conf = new config();


void setup() {
  // Load configuration File.  
  conf.load("wrongPowder_configBasic", "config.txt");
  
  // Get Configuration Properties.
  int w = conf.getIntProperty("app.width", 400);
  int h = conf.getIntProperty("app.height", 400);
  
  size(w, h);
  this.frame.setResizable(true);
}


void draw() {
}


// TODO: make this by exit the application.
public void keyPressed() {
  conf.setProperty("app.width", width);
  conf.setProperty("app.height", height);
  conf.store();
}