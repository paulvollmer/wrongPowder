/**
 * configAdvanced
 * by wrongPowder Library.
 *
 * To load a file from a static filepath.
 * The loadStatic method not search a file
 * at the "Application Support" or "APPDATA" folder.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.17
 */


import wrongPowder.config.*;

config conf = new config();


void setup() {
  // Load configuration File.  
  conf.load("wrongPowder_configAdvanced", "config.txt");
  
  // Get the number of Property Elements.
  println(conf.getSize());
  // Get a Property list.
  conf.list();
  
  // Get Configuration Properties.
  int w = conf.getIntProperty("app.width", 200);
  int h = conf.getIntProperty("app.height", 200);
  
  size(w, h);
  this.frame.setResizable(true);
  
  frameRate(conf.getIntProperty("app.framerate", 30));
}


public void draw() {

}


// TODO: make this by exit the application.
public void keyPressed() {
  conf.setProperty("app.width", width);
  conf.setProperty("app.height", height);
  conf.store();
  
  // Save a copy to data folder.
  conf.store(dataPath("dataExample/")+"/storeConfig.txt");
}