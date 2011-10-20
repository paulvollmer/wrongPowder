/**
 * configAdvanced
 * by wrongPowder Library.
 *
 * To load a file from a static filepath.
 * The loadStatic method not search a file
 * at the "Application Support" or "APPDATA" folder.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.19
 */


import wrongPowder.io.Config;

Config CONFIG = new Config();


void setup() {
  // Load configuration File.  
  CONFIG.load("wrongPowder_configAdvanced", "config.txt");
  
  // Get the number of Property Elements.
  println(CONFIG.getSize());
  // Get a Property list.
  CONFIG.list();
  
  // Get Configuration Properties and set app.width, app.height to size()
  
  size(CONFIG.getIntProperty("app.width", 200), CONFIG.getIntProperty("app.height", 200));
  this.frame.setResizable(true);
  
  frameRate(CONFIG.getIntProperty("app.framerate", 30));
}


public void draw() {

}


// TODO: make this by exit the application.
public void keyPressed() {
  CONFIG.setProperty("app.width", width);
  CONFIG.setProperty("app.height", height);
  CONFIG.store();
  
  // Save a copy to data folder.
  CONFIG.store(dataPath("dataExample/")+"/storeConfig.txt");
}
