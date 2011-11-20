/**
 * gui_tabs
 * by wrongPowder Library.
 *
 * Load a TouchOsc file and draw the Layout.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.31
 */


import wrongPowder.gui.*;

Gui gui;

/*Panel panel;
Tabs tabs;
Checkbox checkbox;
PushButton push;
ToggleButton toggle;
IconButton iconbutton;*/


void setup() {
  size(700, 500);
  smooth();

  gui = new Gui(this);
  gui.init(createFont("Arial", 10));
  gui.loadLayout("lae.xml");
  
  
  /*panel = new Panel(this);
  tabs = new Tabs(this);
  panel.init(300, 100, 100, 180);
  // Initialize the tab class.
  tabs.init(5, 0, 0, width, 40);
  // Set the color if button is active.
  //tabs.colorOn = 0xFF00ff00;
  
  checkbox = new Checkbox(this);
  push = new PushButton(this);
  toggle = new ToggleButton(this);
  iconbutton = new IconButton(this);
  checkbox.init(300, 200);
  push.init(200, 250);//, 80, 40);
  toggle.init(200, 200, 80, 40);
  iconbutton.init(loadImage("btn_on.jpg"), loadImage("btn_off.jpg"), 200, 300);*/
}


void draw() {
  background(30);
  
  // Display the tabs.
  /*tabs.draw();
  panel.draw("Panel Test");
  
  checkbox.draw("wrong is good");
  push.draw("test");
  toggle.draw("hello world");
  iconbutton.draw();

  // Check which tab button is active
  switch(tabs.activeTab) {
    case(0):
    rect(100, 100, 100, 100);
    break;
    case(1):
    ellipse(150, 150, 100, 100);
    break;
  }*/
}


void mousePressed() {
 /* tabs.mousePressed(mouseX, mouseY);
  panel.mousePressed(mouseX, mouseY);

  checkbox.mousePressed(mouseX, mouseY);
  push.mousePressed(mouseX, mouseY);
  toggle.mousePressed(mouseX, mouseY);
  iconbutton.mousePressed(mouseX, mouseY);*/
}

void mouseReleased() {
  //push.mouseReleased(mouseX, mouseY);
}

