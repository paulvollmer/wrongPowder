/**
 *
 *  wngConfig is a wrong-entertainment production
 *
 *
 *  Copyright 2011 wrong-entertainment
 *                 <wrongentertainment@yahoo.de>
 *                 <http://wrong-entertainment.com>
 * 
 *  This file is part of wnglibs.
 *
 *  wngConfig is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  wngConfig is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with wngConfig. If not, see <http://www.gnu.org/licenses/>.
 *
 */



public class wngConfig {
  
  public Properties props = new Properties();
  public String filePath;
  
  
  
  
  wngConfig() {
  }
  
  wngConfig(String path) {
    load(path);
  }
  
  
  
  
  /**
   * load
   * Check the Platform and load a Configuration File.
   *
   * @param path
   *        The Configuration Filepath.
   */
  public void load(String path) {
    // check Platform
    // Save Filepath to Variable and check File.
    switch(platform) {
      
      // WINDOWS
      case 1:
        filePath = "/";
      break;
      
      // MACOSX
      // On MacOS we use the User Application Support Folder to search and store the files.
      // Path: /Users/NAME/Library/Application Support/APPNAME/FILENAME.SUFFIX
      case 2:
        filePath = "/Users/"+System.getProperty("user.name")+"/Library/Application Support/"+path;
        checkFile();
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
   * load
   * Check the Platform and load a Configuration File.
   *
   * @param aName
   *        The name of the Application.
   * @param fName
   *        The Configuration Filename + Suffix.
   */
  public void load(String aName, String fName) {
    load(aName+"/"+fName);
  }
  
  
  
  
  /**
   * checkFile
   * Private method to check if Configuration File exist.
   * If no file found, create a file at the directory.
   */
  private void checkFile() {
    try {
      FileInputStream in = new FileInputStream(filePath);
      props.load(in);
      println("Configuration File "+filePath+" loaded.");
      
    } catch(IOException e) {
      println("Configuration File does not exist. Create an empty File.");
      String[] newFile = new String[2];
      newFile[0] = "app.width=300";
      newFile[1] = "app.height=300";
      saveStrings(filePath, newFile);
    }
  }
  
  
  
  
  /**
   * save
   */
  public void save() {
    try {
      FileOutputStream out = new FileOutputStream(filePath);
      props.store(out, "wngConfig");
      out.close();
    } catch(IOException e) {
    
    }
  }
  
  
}
