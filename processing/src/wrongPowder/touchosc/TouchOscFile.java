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

package wrongPowder.touchosc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import processing.core.XML;
import wrongPowder.util.codec.Base64;



public class TouchOscFile {
	
	public XML xml;
	
	private int    fileVersion     = 0;
	private int    fileMode        = 0;
	private String fileOrientation = "horizontal";
	
	public String[]   tabName;
	public String[][] controlName;
	public String[][] controlType;
	public int[][]    controlX;
	public int[][]    controlY;
	public int[][]    controlW;
	public int[][]    controlH;
	public int[][]    controlColor;

	public boolean[][] controlLocaloff;
	public float[][]   controlScalef;
	public float[][]   controlScalet;
	public boolean[][] controlBackground;
	public boolean[][] controlOutline;
	public int[][]     controlSize;
	public String[][]  controlText;

	// Create Base64 object to decode TouchOsc name of control tag.
	private Base64 base64 = new Base64();
	
	/**
	 * A Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 *
	 * @param fileName
	 */
	public TouchOscFile(String fileName) {
		load(fileName);
	}
	
	public TouchOscFile() {
	}
	
	
	/**
	 * Load a TouchOSC file created with TouchOSC Editor.
	 *
	 * @return String FileName
	 */
	public void load(String fileName) {
		// Read the TouchOsc file, unzip it and save to xml variable. 
		unzip(fileName);
		
	    // Print out the xml file.
	    //System.out.println("\nXML File:\n" + xml);
	    
	    // List all children of xml.
	    // Use for debugging...
	    /*System.out.println("\nxml-file listChildren:");
	    String[] list = xml.listChildren();
	    for(int i=0; i<list.length; i++) {
	    	System.out.println("["+i+"] " + list[i]);
	    }*/
	    
	    
	    // Set the version, mode and orientation values.
	    fileVersion     = xml.getInt("version");;
	    fileMode        = xml.getInt("mode");;
	    fileOrientation = xml.getString("orientation");;
	    
	    
	    // Tabs
	    
	    XML[] xmlChildren = xml.getChildren();
	    //System.out.println("\nxmlChildren.length: "+xmlChildren.length);

	    // Calculate the number of <tabpage> tags.
	    int tabLength = (xmlChildren.length-1)/2;
	    // Set the size of the tabs String Array.
	    tabName = new String[tabLength];
	    
	    controlName  = new String[tabLength][];
	    controlType  = new String[tabLength][];
	    controlX     = new int[tabLength][];
	    controlY     = new int[tabLength][];
	    controlW     = new int[tabLength][];
	    controlH     = new int[tabLength][];
	    controlColor = new int[tabLength][];
	    
	    controlLocaloff   = new boolean[tabLength][];
		controlScalef     = new float[tabLength][];
		controlScalet     = new float[tabLength][];
		controlBackground = new boolean[tabLength][];
		controlOutline    = new boolean[tabLength][];
		controlSize       = new int[tabLength][];
		controlText       = new String[tabLength][];
		
	    // Create a tabCounter for the tabs String Array.
	    int tabCounter = 0;
	    
	    // Check how many <tabpage> tags exist.
	    for(int i=1; i<xmlChildren.length; i+=2) {
	    	
	    	// If a <tabpage> tag exist...
	    	if(xmlChildren[i].getName() == "tabpage") {
	    		//System.out.println("AttributeCount: "+xmlChildren[i].getAttributeCount());
	    		//System.out.println("Attribute: "+xmlChildren[i].getString("name"));
	    		
	    		// get the name of the tabpage and decode it with Base64.
	    		tabName[tabCounter] = base64.decode( xmlChildren[i].getString("name"), "UTF-8");
	    		
	    		
	    		// Controls
	    		
	    		// Get the content of <tabpage> and store it to controls array.
	    		XML[] xmlControls = xmlChildren[i].getChildren();
	    		//System.out.println("controls.length: "+controls.length);
	    		
	    		// Calculate the number of <control> tags.
	    		int controlLength = (xmlControls.length-1)/2;
	    		// Set the size of the controls String Array.
	    		controlName[tabCounter]  = new String[controlLength];
	    	    controlType[tabCounter]  = new String[controlLength];
	    	    controlX[tabCounter]     = new int[controlLength];
	    	    controlY[tabCounter]     = new int[controlLength];
	    	    controlW[tabCounter]     = new int[controlLength];
	    	    controlH[tabCounter]     = new int[controlLength];
	    	    controlColor[tabCounter] = new int[controlLength];
	    	    
	    	    controlLocaloff[tabCounter]   = new boolean[controlLength];
	    		controlScalef[tabCounter]     = new float[controlLength];
	    		controlScalet[tabCounter]     = new float[controlLength];
	    		controlBackground[tabCounter] = new boolean[controlLength];
	    		controlOutline[tabCounter]    = new boolean[controlLength];
	    		controlSize[tabCounter]       = new int[controlLength];
	    		controlText[tabCounter]       = new String[controlLength];
	    	    // Create a controlCounter for the controls String Array.
	    	    int controlCounter = 0;
	    	    
	    		// Check how many <control> tags exist in <tabpage>.
   				for(int j=0; j<xmlControls.length; j++) {
   					
   					// If a <control> tag with attribute "type" exist...
   					if(xmlControls[j].getName() == "control" && xmlControls[j].hasAttribute("type")) {
   						
   						// Get the name.
	    				controlName[tabCounter][controlCounter] = base64.decode( xmlControls[j].getString("name"), "UTF-8");
	  					//System.out.println("Name: " + controlName[tabCounter][controlCounter]);
	  					
   						// Get the type.
   						controlType[tabCounter][controlCounter] = xmlControls[j].getString("type");
   						//System.out.println("Type: " + controlType[tabCounter][controlCounter]);
   						
	    				// Get the position and size.
	   					controlX[tabCounter][controlCounter] = xmlControls[j].getInt("x");
	   					controlY[tabCounter][controlCounter] = xmlControls[j].getInt("y");
	   					controlW[tabCounter][controlCounter] = xmlControls[j].getInt("w");
	   					controlH[tabCounter][controlCounter] = xmlControls[j].getInt("h");
	    				/*System.out.println("Pos/Size: x " + controlX[tabCounter][controlCounter] +
	   					                            " y " + controlY[tabCounter][controlCounter] +
	   					                            " w " + controlW[tabCounter][controlCounter] +
	   					                            " h " + controlH[tabCounter][controlCounter]);*/
	    				
	    				// Get color.
	    				String tempColor = xmlControls[j].getString("color");
	    				if(tempColor.compareTo("red") == 0)         controlColor[tabCounter][controlCounter] = wrongPowder.touchosc.TouchOscLayout.RED_ON;
	    				else if(tempColor.compareTo("green") == 0)  controlColor[tabCounter][controlCounter] = wrongPowder.touchosc.TouchOscLayout.GREEN_ON;
	    				else if(tempColor.compareTo("blue") == 0)   controlColor[tabCounter][controlCounter] = wrongPowder.touchosc.TouchOscLayout.BLUE_ON;
	    				else if(tempColor.compareTo("yellow") == 0) controlColor[tabCounter][controlCounter] = wrongPowder.touchosc.TouchOscLayout.YELLOW_ON;
	    				else if(tempColor.compareTo("purple") == 0) controlColor[tabCounter][controlCounter] = wrongPowder.touchosc.TouchOscLayout.PURPLE_ON;
	    				else if(tempColor.compareTo("gray") == 0)   controlColor[tabCounter][controlCounter] = wrongPowder.touchosc.TouchOscLayout.GRAY_ON;
	    				else if(tempColor.compareTo("orange") == 0) controlColor[tabCounter][controlCounter] = wrongPowder.touchosc.TouchOscLayout.ORANGE_ON;
	    				
	    				// Get localoff
	    				if(xmlControls[j].hasAttribute("local_off")) controlLocaloff[tabCounter][controlCounter] = Boolean.parseBoolean(xmlControls[j].getString("local_off"));
	    				else controlLocaloff[tabCounter][controlCounter] = false;
	    				
	    				// Get scalef
	    				if(xmlControls[j].hasAttribute("scalef")) controlScalef[tabCounter][controlCounter] = xmlControls[j].getFloat("scalef");
	    				else controlScalef[tabCounter][controlCounter] = 0.0f;
	    				
	    				// Get scalet
	    				if(xmlControls[j].hasAttribute("scalet")) controlScalet[tabCounter][controlCounter] = xmlControls[j].getFloat("scalet");
	    				else controlScalet[tabCounter][controlCounter] = 0.0f;
	    				
	    				// Get background
	    				if(xmlControls[j].hasAttribute("local_off")) controlBackground[tabCounter][controlCounter] = Boolean.parseBoolean(xmlControls[j].getString("background"));
	    				else controlBackground[tabCounter][controlCounter] = false;
	    				
	    				// Get outline
	    				if(xmlControls[j].hasAttribute("outline")) controlOutline[tabCounter][controlCounter] = Boolean.parseBoolean(xmlControls[j].getString("outline"));
	    				else controlOutline[tabCounter][controlCounter] = false;
	    				
	    				// Get size
	    				if(xmlControls[j].hasAttribute("size")) controlSize[tabCounter][controlCounter] = xmlControls[j].getInt("size");
	    				else controlSize[tabCounter][controlCounter] = 0;
	    				
	    				// Get text
	    				if(xmlControls[j].hasAttribute("text")) controlText[tabCounter][controlCounter] = base64.decode( xmlControls[j].getString("text"), "UTF-8");
	    				else controlText[tabCounter][controlCounter] = "not available";
	    				
	    				            
   						controlCounter++;
   						
   					}
   				}
   				
   				tabCounter++;
	    	}
	    }
	    		
	    
	    
	    
	    
   				/*
	    				// Search the different control elements.
	    				// If exist, add to ArrayList and create new TouchOscXX element.
	    				if(controlType.compareTo("batteryh") == 0) {
	    					//System.out.println("batteryh");
	    					tBatteryh = new ArrayList();
	    					tBatteryh.add(new TouchOscBatteryh(controlName, controlX, controlY, controlW, controlH, controlColor));
	    						}
	    						
	    						if(controlType.compareTo("batteryv") == 0) {
	   								//System.out.println("batteryv");
	    							tBatteryv = new ArrayList();
	    							tBatteryv.add(new TouchOscBatteryv(controlName, controlX, controlY, controlW, controlH, controlColor));
    							}
	    						
	    						if(controlType.compareTo("faderh") == 0) {
	    							//System.out.println("faderh");
	    							tFaderh = new ArrayList();
	    							tFaderh.add(new TouchOscFaderh(controlName, controlX, controlY, controlW, controlH, controlColor));
	    						}
	    						
	    						if(controlType.compareTo("faderv") == 0) {
	    							//System.out.println("faderv");
	    							tFaderv = new ArrayList();
	    							tFaderv.add(new TouchOscFaderv(controlName, controlX, controlY, controlW, controlH, controlColor));
	    						}
	    						
	    						if(controlType.compareTo("labelh") == 0) {
	    							//System.out.println("labelh");
	    							tLabelh = new ArrayList();
	    							tLabelh.add(new TouchOscLabelh(controlName, controlX, controlY, controlW, controlH, controlColor, controlText));
	    						}
	    						
	    						if(controlType.compareTo("labelv") == 0) {
	    							//System.out.println("labelv");
	    							tLabelv = new ArrayList();
	    							tLabelv.add(new TouchOscLabelv(controlName, controlX, controlY, controlW, controlH, controlColor, controlText));
	    						}
	    						
	    						if(controlType.compareTo("led") == 0) {
	    							//System.out.println("led");
	    							tLed = new ArrayList();
	    							tLed.add(new TouchOscLed(controlName, controlX, controlY, controlW, controlH, controlColor));
	    						}
	    						
	    						if(controlType.compareTo("multifaderh") == 0) {
	    							//System.out.println("multifaderh");
	    							tMultifaderh = new ArrayList();
	    							tMultifaderh.add(new TouchOscMultifaderh(controlName, controlX, controlY, controlW, controlH, controlColor));
	    						}
	    						
	    						if(controlType.compareTo("multifaderv") == 0) {
	    							//System.out.println("multifaderv");
	    							tMultifaderv = new ArrayList();
	    							tMultifaderv.add(new TouchOscMultifaderv(controlName, controlX, controlY, controlW, controlH, controlColor));
	    						}
	    						
	    						if(controlType.compareTo("multitoggle") == 0) {
	   								//System.out.println("multitoggle");
	    							tMultitoggle = new ArrayList();
	    							tMultitoggle.add(new TouchOscMultitoggle(controlName, controlX, controlY, controlW, controlH, controlColor));
    							}
	    						
	    						if(controlType.compareTo("push") == 0) {
	    							//System.out.println("push");
	    							tPush = new ArrayList();
	    							tPush.add(new TouchOscPush(controlName, controlX, controlY, controlW, controlH, controlColor));
	    						}
	    						
	    						if(controlType.compareTo("rotaryh") == 0) {
	   								//System.out.println("rotaryh");
	   								tRotaryh = new ArrayList();
	    							tRotaryh.add(new TouchOscRotaryh(controlName, controlX, controlY, controlW, controlH, controlColor));
	   							}
	    						
	    						if(controlType.compareTo("rotaryv") == 0) {
	    							//System.out.println("rotaryv");
	    							tRotaryv = new ArrayList();
	    							tRotaryv.add(new TouchOscRotaryv(controlName, controlX, controlY, controlW, controlH, controlColor));
	    						}
	    						
	    						if(controlType.compareTo("timeh") == 0) {
	   								//System.out.println("timeh");
	    							tTimeh = new ArrayList();
	    							tTimeh.add(new TouchOscTimeh(controlName, controlX, controlY, controlW, controlH, controlColor));
	   							}
	    						
	    						if(controlType.compareTo("timev") == 0) {
	    							//System.out.println("timev");
	    							tTimev = new ArrayList();
	    							tTimev.add(new TouchOscTimev(controlName, controlX, controlY, controlW, controlH, controlColor));
	    						}
	    						
	    						if(controlType.compareTo("toggle") == 0) {
	    							//System.out.println("toggle");
	    							tToggle = new ArrayList();
	    							tToggle.add(new TouchOscToggle(controlName, controlX, controlY, controlW, controlH, controlColor));
	    						}
	    						
	    						if(controlType.compareTo("xy") == 0) {
	    							//System.out.println("xy");
	    							tXy = new ArrayList();
	    							tXy.add(new TouchOscXy(controlName, controlX, controlY, controlW, controlH, controlColor));
	    						}
	   							
	    						
	    							
	    					} //else {
	    						//System.out.println("NO Control tag");
	    					//}
	    				}
	    				
	    			}
	    			
	    		}
	    		System.out.println("\nList Tabs: " + tabs);*/
	}
	
	
	// TODO Create zip/ unzip class.
	
	/**
	 * Unzip to get the XML file, parse and save it to variable.
	 * 
	 * @param fileName The TouchOsc file.
	 */
	private void unzip(String fileName) {
		try {
	    	ZipFile zf = new ZipFile(fileName);
	    	Enumeration entries = zf.entries();

	    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	    	while (entries.hasMoreElements ()) {
	    		ZipEntry ze = (ZipEntry) entries.nextElement();
	    		//System.out.println("ZE: "+ze);
	            
	    		// create xml
	    		xml = xml.parse(inputStreamToString(zf.getInputStream(ze)));
	    		
	    	}
	    }
	    catch (IOException e) {
	    		e.printStackTrace();
	    }

	}
	
	
	/**
	 * Get an inputStream and return a String.
	 * 
	 * @param in
	 * @return String
	 * @throws IOException
	 */
	private String inputStreamToString(InputStream in) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		
		while ( (line = bufferedReader.readLine ()) != null) {
			stringBuilder.append(line + "\n");
		}
		
		bufferedReader.close();
		return stringBuilder.toString();
	}
	
	
	
	
	/**
	 * Get the Version of TouchOSC Editor.
	 * 
	 * @return version
	 */
	public int version() {
		return fileVersion;
	}
	
	/**
	 * Get the Layout Size of the TouchOSC file.<br>
	 * 0 = iPhone/iPod Touch<br>
	 * 1 = iPad
	 * 
	 * @return mode
	 */
	public int mode() {
		return fileMode;
	}
	
	/**
	 * Get the Layout Orientation of the TouchOSC file.<br>
	 * vertical or horizontal
	 * 
	 * @return orientation
	 */
	public String orientation() {
		return fileOrientation;
	}
	
	
	/**
	 * Number of Tab Pages in the file.
	 * 
	 * @return Integer
	 */
	public int numTabs() {
		return tabName.length;
	}
	
	
}