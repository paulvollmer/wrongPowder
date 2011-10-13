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
  
  // Constructors -----------------------------------------------
  wngConfig() {}

  wngConfig(String folderName, String fileName) {
   load(folderName, pathName);
   }

  /**
   * load
   * Check the Platform and load a Configuration File.
   *
   * @param folderName
   *        Name of the folder (Use your application name)
   * @param fileName
            Name of the config file
   */
  public void load(String folderName, String fileName) {  //@Tim: changed constructor
    // check Platform and save Filepath to Variable.
    switch(platform) {

      // WINDOWS
    case 1:
      try {
        filePath = System.getenv("APPDATA") + File.separator + folderName + File.separator + fileName;
      }
      catch(Exception e) {
        println("Environment variable APPDATA could not be read");
      }
      break;

      // MACOSX
      // On MacOS we use the User Application Support Folder to search and store the files.
      // Path: /Users/NAME/Library/Application Support/APPNAME/FILENAME.SUFFIX
    case 2:
      filePath = "/Users/" + System.getProperty("user.name") + "/Library/Application Support/"
        + folderName + File.separator + fileName;
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

    checkFile();
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
  /*
  public void load(String aName, String fName) {
   load(aName, fName);
   }
   */




  /**
   * checkFile
   * Private method to check if Configuration File exists.
   * If no file is found, create a file at the directory.
   */
  private void checkFile() {
    try {
      println("checkFile(): Checking file " + filePath);
      File file = new File(filePath);
      if (file.exists()) {
        try {
          FileInputStream in = new FileInputStream(filePath);
          props.load(in);
          println("checkFile(): Config file successfully loaded.");
        }
        catch(IOException e) {
          println("checkFile(): File could not be loaded");
        }
      }
      else {  // File does not exist 
        println("checkFile(): Configuration File does not exist. Create an empty File.");
        // Create base directory
        File folder = new File(file.getParent());
        folder.mkdirs();
        // create config file
        file.createNewFile();
        // write default config data to config file
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        String[] confText = getDefaultConfigText();
        for (int i=0; i<confText.length; i++) {
          out.write(confText[i]);
          if (i < confText.length -1)  //New newline at last line
            out.newLine();  
        }
        out.close();
      }

      //saveStrings(filePath, newFile);
    }
    catch(Exception e) {
      println("Error");
    }
  }

  String[] getDefaultConfigText() {
    String[] conf = {"app.width=300", "app.height=300"};
    return conf;
  }




  /**
   * store
   */
  public void store(String path) {
    try {
      FileOutputStream out = new FileOutputStream(path);
      props.store(out, path+" savet at:");
      out.close();
    } 
    catch(IOException e) {
    }
  }

  /**
   * store
   */
  public void store() {
    store(filePath);
  }
}

