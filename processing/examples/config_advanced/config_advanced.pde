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

Config config = new Config();


void setup() {
  // Load configuration File.  
  config.load("wrongPowder_configAdvanced", "config.txt");
  
  // Get the number of Property Elements.
  println(config.getSize());
  // Get a Property list.
  config.list();
  
  // Get Configuration Properties and set app.width, app.height to size()
  
  size(config.getIntProperty("app.width", 200), config.getIntProperty("app.height", 200));
  this.frame.setResizable(true);
  
  frameRate(config.getIntProperty("app.framerate", 30));
}


public void draw() {

}


// TODO: make this by exit the application.
public void keyPressed() {
  config.setProperty("app.width", width);
  config.setProperty("app.height", height);
  config.store();
  
  // Save a copy to data folder.
  config.store(dataPath("dataExample/")+"/storeConfig.txt");
}
