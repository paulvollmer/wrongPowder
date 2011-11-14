/**
 *  wrongPowder is developed by wrong-entertainment & powder
 *
 *
 *  Copyright 2011 Paul Vollmer & Tim Pulver
 *  paulvollmer.net
 *  vollmerpaul@yahoo.de
 *  timpulver.de
 *  pulver.tim@googlemail.com
 * 
 *  This file is part of wrongPowder library.
 *
 *  wrongPowder is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with wrongPowder. If not, see <http://www.gnu.org/licenses/>.
 * 
 *  @author		##author##
 *  @modified	##date##
 *  @version	##version##
 */

package wrongPowder.io;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import wrongPowder.util.OsCheck;

/**
 * Config
 * 
 * @example config_basic 
 */
public class Config {

	public Properties props = new Properties();
	
	// filePath is the Main Path variable. It will be used
	// at load OsCheck or set at loadStatic.
	public String filePath;
	
	private OsCheck osCheck = new OsCheck();
	
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example config_basic
	 */
	public Config() {}
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * Also the constructor load a Configuration file.
	 * 
	 * @example config_basic
	 * @param folderName Name of the folder (Use your application name).
	 * @param fileName Name of the Configuration file.
	 */
	public Config(String folderName, String fileName) {
		load(folderName, fileName);
	}
	
	
	
	/**
	 * load
	 * Check the Platform and load a Configuration file.
	 *
	 * @example config_basic
	 * @param folderName Name of the folder (Use your application name).
	 * @param fileName Name of the Configuration file.
	 */
	public void load(String folderName, String fileName) {
		// WINDOWS
		if(osCheck.isWindows()) {
			try {
				filePath = System.getenv("APPDATA") + File.separator + folderName + File.separator + fileName;
				//System.out.println("win");
			}
			catch(Exception e) {
				System.err.println("Environment variable APPDATA could not be read");
			}
		}
		// MACOSX
		// On MacOS we use the User Application Support Folder to search and store the files.
		// Path: /Users/NAME/Library/Application Support/APPNAME/FILENAME.SUFFIX
		else if(osCheck.isMac()) {
			filePath = File.separator + "Users" + File.separator + System.getProperty("user.name") + File.separator
			+ "Library" + File.separator + "Application Support" + File.separator + folderName + File.separator + fileName;
			//System.out.println(" mac");
		}
		// LINUX
		else if(osCheck.isUnix()) {	
			filePath = ""; // TODO: Add Filepath
			//System.out.println("unix/linux");
		}
		// OTHER
		else {
			System.err.println("Operating System not supported");
		}
		
		checkFile(filePath);
	}
	
	
	
	/**
	 * loadStatic
	 * Load a Configuration file from a static path.
	 * 
	 * @example config_advanced
	 * @param path The Filepath.
	 */
	public void loadStatic(String path) {
		filePath = path;
		checkFile(path);
	}
	
	public void loadStatic(String path, String logPath) {
		filePath = path; 
		//String tempLogPath = ".."+logPath;
		//Log lo = new Log(".."+tempLogPath);
		//System.out.println(tempLogPath);
		checkFile(path);
	}
	
	
	
	/**
	 * checkFile
	 * Private method to check if Configuration File exists.
	 * If no file is found, create a file at the directory.
	 * 
	 * @param filePath
	 */
	private void checkFile(String path) {
		try {
			//System.out.println("checkFile(): Checking file " + path);
			File file = new File(path);
			
			if (file.exists()) {
				try {
					FileInputStream in = new FileInputStream(path);
					props.load(in);
					//System.out.println("checkFile(): Config file successfully loaded.");
					
					// Application counter
					int appCount = Integer.parseInt(props.getProperty("app.count", ""+0));
					appCount ++;
					props.setProperty("app.count", ""+appCount );
					store(path);
				}
				catch(IOException e) {
					System.err.println("checkFile(): File could not be loaded");
				}
			}
			else {  // File does not exist 
				//System.out.println("checkFile(): Configuration File does not exist. Create an default File.");
				// Create base directory
				File folder = new File(file.getParent());
				folder.mkdirs();
				// create config file
				file.createNewFile();
				// write default config data to config file
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter(path));
					String[] confText = getDefaultConfigText();
					for (int i=0; i<confText.length; i++) {
						out.write(confText[i]);
						if (i < confText.length -1)  //New newline at last line
							out.newLine();  
					}
					out.close();
				}
				catch (Exception e) {
					System.err.println("Error: " + e.getMessage());
				}
			}
		}
		catch(Exception e) {
			System.err.println("Error");
		}
	}
	
	
	
	/**
	 * getDefaultConfigText
	 * 
	 * @return default Configuration content.
	 */
	private String[] getDefaultConfigText() {
		// set Configuration text.
		String[] conf = { "app.count=1",
				          "app.width=300",
				          "app.height=300"};
		return conf;
	}
	
	
	
	/**
	 * store
	 * Method to save the Configuration File,
	 *
	 * @example config_advanced
	 * @param path The Filepath.
	 */
	public void store(String path) {
		try {
			FileOutputStream out = new FileOutputStream(path);
			props.store(out, "wrongPowder.io.Config");
			out.close();
		}
		catch(IOException e) {
			//System.err.println("\nError: " + e.getMessage());
			
			// Check the Directory. If no file exist, create one.
			checkFile(path);
		}
	}
	
	/**
	 * store
	 * Method to save the Configuration File.
	 * 
	 * @example config_basic
	 */
	public void store() {
		store(filePath);
	}
	
	
	
	/**
	 * getSize
	 * 
	 * @example config_advanced
	 * @return int How many properties contains the configuration file.
	 */
	public int getSize() {
		int s = props.size();
		return s;
	}
	
	
	
	/**
	 * Get a list of the property file.
	 * Print out to console like this:
	 * <code>-- listing properties --
	 * app.width=300
	 * app.height=300
	 * app.count=3</code>
	 *   
	 * @example config_advanced
	 */
	public void list() {
		props.list(System.out);
	}
	
	
	
	/**
	 * Get the selected property as an integer value.
	 * 
	 * @example config_basic
	 * @param key The Property key name.
	 * @param defVal The default value.
	 * @return int The Property value.
	 */
	public int getIntProperty(String key, int defVal) {
		return Integer.parseInt(props.getProperty(key, ""+defVal));
	}
	
	public int getIntProperty(String key) {
		return Integer.parseInt(props.getProperty(key));
	}
	
	
	/**
	 * Get the selected property as an float value.
	 * 
	 * @example config_basic
	 * @param key The Property key name.
	 * @param defVal The default value.
	 * @return int The Property value.
	 */
	public float getFloatProperty(String key, float defVal) {
		return Float.parseFloat(props.getProperty(key, ""+defVal));
	}
	
	public float getFloatProperty(String key) {
		return Float.parseFloat(props.getProperty(key));
	}
	
	
	/**
	 * Get the selected property as an string value.
	 * 
	 * @example config_basic
	 * @param key The Property key name.
	 * @param defVal The default value.
	 * @return int The Property value.
	 */
	public String getStringProperty(String key, String defVal) {
		return props.getProperty(key, defVal);
	}
	
	public String getStringProperty(String key) {
		return props.getProperty(key);
	}
	
	
	/**
	 * Get the selected property as an boolean value.
	 * 
	 * @example config_basic
	 * @param key The Property key name.
	 * @param defVal The default value.
	 * @return int The Property value.
	 */
	public boolean getBooleanProperty(String key, boolean defVal) {
		return Boolean.parseBoolean(props.getProperty(key, ""+defVal));
	}
	
	public boolean getBooleanProperty(String key) {
		return Boolean.parseBoolean(props.getProperty(key));
	}
	
	
	
	/**
	 * Set Integer property.
	 * If no property exist actually, it will create a new property line.
	 * 
	 * @example config_basic
	 * @param key The Property key name.
	 * @param val The value to set as an integer.
	 */
	public void setProperty(String key, int val) {
		props.setProperty(key, ""+val);
	}
	
	/**
	 * Set Float property.
	 * If no property exist actually, it will create a new property line.
	 * 
	 * @example config_basic
	 * @param key The Property key name.
	 * @param val The value to set as a float.
	 */
	public void setProperty(String key, float val) {
		props.setProperty(key, ""+val);
	}
	
	/**
	 * Set String property.
	 * If no property exist actually, it will create a new property line.
	 * 
	 * @example config_basic
	 * @param key The Property key name.
	 * @param val The value to set as a String.
	 */
	public void setProperty(String key, String val) {
		props.setProperty(key, val);
	}
	
	/**
	 * Set Boolean property.
	 * If no property exist actually, it will create a new property line.
	 * 
	 * @example config_basic
	 * @param key The Property key name.
	 * @param val The value to set as a Boolean.
	 */
	public void setProperty(String key, Boolean val) {
		props.setProperty(key, ""+val);
	}
	
}