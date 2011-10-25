/**
 * config_loadStatic
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
  // Load configuration file.
  // If no file exist, create default file. 
  config.loadStatic(dataPath("dataExample/")+"configFile.txt");
  
  // Set size from configuration file values.
  size(config.getIntProperty("app.width", 200), config.getIntProperty("app.height", 200));
}
