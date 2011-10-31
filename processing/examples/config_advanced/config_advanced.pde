/**
 * configAdvanced
 * by wrongPowder Library.
 *
 * To load a file from a static filepath.
 * The loadStatic method not search a file
 * at the "Application Support" or "APPDATA" folder.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.31
 */


import wrongPowder.io.Config;

// Load configuration File.  
Config config = new Config("wrongPowder_configAdvanced", "config.txt");


void setup() {
  // Get the number of Property Elements.
  println("Number of Property Elements: " + config.getSize());
  // Get a Property list.
  config.list();
  
  // Get Configuration Properties and set app.width, app.height to size().
  // 200 is the default value if no property exist.
  size(config.getIntProperty("app.width", 200), config.getIntProperty("app.height", 200));
  this.frame.setResizable(true);
  
  // Set frameRate().
  // Here is no default value, use value from wrongPowder.io.Config class.
  frameRate(config.getIntProperty("app.framerate"));
}


public void draw() {
}


public void keyPressed() {
  // TODO: make this by exit the application.
  config.setProperty("app.width", width);
  config.setProperty("app.height", height);
  config.setProperty("app.framerate", (int)frameRate);
  config.store();
  
  // Save a copy to data folder.
  config.store(dataPath("configs/")+"config.txt");
}
