/**
 * script_basic
 * by wrongPowder Library.
 *
 * desc TODO
 *
 * @author    Paul Vollmer
 * @modified  2011.11.09
 */


import wrongPowder.calendar.CalendarUtil;
import wrongPowder.io.Log;
import wrongPowder.util.script.AppleScript;

CalendarUtil time = new CalendarUtil();
Log log = new Log();
AppleScript script = new AppleScript();


void setup() {
  size(400, 400);
  
  // Initialize Log file.
  log.init(sketchPath("logs")+"/log"+time.timestamp()+".txt");
  // Use to write log file set logActife == true.
  script.logActive = true;
  
  // Initialize Log file.
  script.init();
  
  script.setScript("tell application\"Safari\" \n"+
                   "end tell");
  script.runScript();
}