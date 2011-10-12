
class wngConfig {
  
  public String[] file;
  public String filePath;
  
  
  
  
  wngConfig() {
  }
  
  
  
  
  /**
   * loadFile
   * Check the Platform and load a Configuration File.
   *
   * @param aName
   *        The name of the Application.
   * @param fName
   *        The Configuration Filename + Suffix.
   */
  public void loadFile(String aName, String fName) {
    // check Platform
    // Save Filepath to Variable and check File.
    switch(platform) {
      
      // WINDOWS
      case 1:
        filePath = "/";
      break;
      
      // MACOSX
      case 2:
        filePath = "/Users/"+System.getProperty("user.name")+"/Library/Application Support/"+aName+"/"+fName;
        checkFile(filePath);
      break;
      
      // MACOS9
      case 3:
        filePath = "/";
      break;
      
      // LINUX
      case 4:
        filePath = "/";
      break;
      
      // OTHER
      case 5:
        filePath = "/";
      break;
    
    }
    
  }
  
  
  
  
  /**
   * saveFile
   */
  public void saveFile(String path, String[] _file) {
    saveStrings(path, _file);
  }
  
  public void saveFile(String[] _file) {
    saveFile(filePath, _file);
  }
  
  
  
  
  /**
   * checkFile
   * Private method to check if configuration file exist.
   * If no file found, create a file at the directory.
   */
  private void checkFile(String path) {
    File f = new File(dataPath(filePath));
    if(!f.exists()) {
      println("Configuration File does not exist. Create an empty File.");
      file = new String[1];
      file[0] = "0x11120119";
      saveFile(filePath, file);
    } else {
      file = loadStrings(f);
      println("Configuration File "+filePath+" loaded.");
    }
  }
  
  
}
