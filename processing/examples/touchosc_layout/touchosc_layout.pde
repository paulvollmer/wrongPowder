/**
 * touchosc_layout
 * by wrongPowder Library.
 *
 * Load a TouchOsc file and draw the Layout.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.31
 */


import wrongPowder.touchosc.File;
import wrongPowder.touchosc.Layout;

File file = new File();
Layout layout = new Layout(this);


void setup() {
  size(1200, 800);
  smooth();
  
  // Load a TouchOSC File.
  file.load(dataPath("ipad.touchosc"));
  // and initialioze the Layout class.
  layout.init();

  println(file.numTabs());

  // Number of control type.
  println("Batteryh: " + file.numBatteryh);
  println("Push: " + file.numPush);
}


void draw() {
  background(100);
  
  // Display the TouchOSC file layout.
  layout.draw(20, 20);
}
