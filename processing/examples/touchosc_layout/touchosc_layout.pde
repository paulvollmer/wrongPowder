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
  file.load(dataPath("iPad Kopie.touchosc"));
  // and initialioze the Layout class.
  layout.init();
  
  // Number of control type.
  /*println("Batteryh: " + file.numBatteryh);
  println("Batteryv: " + file.numBatteryv);
  println("Push: " + file.numPush);
  println("xy: " + file.numXy);*/
}


void draw() {
  background(100);
  
  // Display the TouchOSC file layout.
  layout.draw();
}


void mousePressed() {
  layout.mousePressed();
}
