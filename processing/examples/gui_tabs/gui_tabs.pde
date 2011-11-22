/**
 * gui_tabs
 * by wrongPowder Library.
 *
 * Load a TouchOsc file and draw the Layout.
 *
 * @author              Paul Vollmer
 * @modified            2011.10.31
 * @processing-version  2.0a1
 */


import wrongPowder.gui.Tabs;

Tabs tabs = new Tabs(this);


void setup() {
  size(700, 500);
  smooth();
  
  // Initialize the tab class.
  tabs.init(5, 0, 0, width, 40);
  // Set the color if button is active.
  tabs.buttonColorOn = 0xFF00ff00;
}


void draw() {
  
  background(100);
  
  // Display the tabs.
  tabs.display();
  
  // Check which tab button is active
  switch(tabs.activeTab) {
    case(0):
      rect(100, 100, 100, 100);
      break;
     case(1):
       ellipse(150, 150, 100, 100);
       break;
  }
}


void mousePressed() {
  tabs.mousePressed(mouseX, mouseY);
  println("Active tab: " + tabs.activeTab);
}
