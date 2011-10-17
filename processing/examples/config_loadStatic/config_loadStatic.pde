/**
 * config_loadStatic
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
  conf.loadStatic(dataPath("dataExample/")+"configFile.txt");
  
  size(conf.getIntProperty("app.width", 200), conf.getIntProperty("app.height", 200));
}
