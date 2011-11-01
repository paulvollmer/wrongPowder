/**
 * gui_tabs
 * by wrongPowder Library.
 *
 * Load a TouchOsc file and draw the Layout.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.31
 */


import wrongPowder.gui.Tabs;

Tabs tabs = new Tabs(this);


void setup() {
  size(1200, 800);
  smooth();
  
  // Initialize the tab class.
  tabs.init(5, 100, 0, 200, 40);
}


void draw() {
  background(100);
  
  // Display the tabs.
  tabs.display();
}


void mousePressed() {
  tabs.mousePressed(mouseX, mouseY);
}
