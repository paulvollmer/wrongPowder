/**
 *  wrongPowder is developed by wrong-entertainment & powder
 *
 *
 *  Copyright 2011 Paul Vollmer
 *  paulvollmer.net
 *  vollmerpaul@yahoo.de
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
 *  @author		Paul Vollmer
 *  @modified	##date##
 *  @version	##version##
 */

package wrongPowder.util.script;



import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

//import processing.core.*;


/**
 * AppleScript
 * 
 * @example script_basic 
 */
public class AppleScript {
    
	private ScriptEngineManager manager = new ScriptEngineManager();
    private List<ScriptEngineFactory> engines = manager.getEngineFactories();
    private ScriptEngine engine;
    
    //PApplet p5;
    
    public int logActive = 1;
    public String script;
    public String scriptLanguage = "applescript";
    
    
    
    
	
	/**
	 * Script a Constructor, usually called in the setup() method in your
	 * sketch to initialize and start the class.
	 * 
	 * @example script_basic
	 */
	public AppleScript() {}
	
	
	
	/**
	 * @see init(String language)
	 */
	public void init() {
		init("applescript");
	}
	
	
	
	
	
	/**
	 * Initialize the script engines.
	 * Search scripting engines and get a list.
	 * Set the scripting language to string variable language.
	 * 
	 * @param language The script language.
	 */
	public void init(String language) {
		addLog("Start initialize ScriptEngine & search scripting Ports");
		
		if (engines.isEmpty()) {
			addLog("No scripting engines were found");
			return;
		}
		
		addLog("The following " + engines.size() + " scripting engines were found");
		
		for (ScriptEngineFactory engine : engines) {
			addLog("Engine Name:     " + engine.getEngineName());
			addLog("       Version:  " + engine.getEngineVersion());
			addLog("       Language: " + engine.getLanguageName());
			
			List<String> extensions = engine.getExtensions();
			if (extensions.size() > 0) {
				addLog("       Engine supports the following extensions:");
				for (String e : extensions) {
					addLog("           " + e);
				}
			}
			
			List<String> shortNames = engine.getNames();
			if (shortNames.size() > 0) {
				addLog("       Engine has the following short names:");
				for (String n : engine.getNames()) {
					addLog("           " + n);
				}
			}
			
		}
		
		scriptLanguage = language;
		addLog("Set scriptLanguage to "+language);
		
	}
	
	
	
	
	/**
	 * TODO
	 * Load a script file.
	 * 
	 * @param path Filepath.
	 *
	public void load(String file) {
		addLog("#");
		String[] src;
		src = p5.loadStrings(file);
		
		System.out.println(tempSource);
		addLog("Load script file: "+file);
	}*/
	
	
	
	
	/**
	 * Set the source code of a script string.
	 * 
	 * @param src The script source code.
	 */
	public void setScript(String src) {
		script = src;
		addLog("Set Script:\n"+src);
		
		engine = manager.getEngineByExtension(scriptLanguage);
		addLog("Set ScriptEngine to "+scriptLanguage+" scriptLanguage");
	}
	
	
	
	
	/**
	 * Get the string source code as a string.
	 * 
	 * @return The script source code.
	 */
	public String getScript() {
		return script;
	}
	
	
	
	// TODO debug this.
	/**
	 * Change a Value from applescript, you need to
	 * place the methode before runScript.
	 * Else the value won't be set.
	 * 
	 * @param scriptValue The variable you want to change.
	 * @param value The new value.
	 *
	public void setVal(String scriptValue, String value) {
		engine.put(scriptValue, ""+value);
		addLog("Change "+scriptValue+" to "+value);
	}
	
	public void setVal(String scriptValue, int value) {
		setVal(scriptValue, String.valueOf(value));
	}
	
	public void setVal(String scriptValue, float value) {
		setVal(scriptValue, String.valueOf(value));
	}
	
	public void setVal(String scriptValue, boolean value) {
		setVal(scriptValue, String.valueOf(value));
	}*/
	
	
	
	
	
	/**
	 * Run the selected script.
	 */
	public void runScript() {
		try {
			engine.eval(script);
			addLog("Run Script");
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	/**
	 * If the šogActive variable = 0, it will be print messages to Log class.
	 * 
	 * @param message The message for the logger.
	 */
	private void addLog(String message) {
		if(logActive == 0) {
			wrongPowder.io.Log.info("APPLESCRIPT "+message);
		}
	}
	
	
}