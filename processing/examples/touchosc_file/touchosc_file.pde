import oscP5.*;
import netP5.*;

import wrongPowder.touchosc.File;
import wrongPowder.touchosc.Osc;
import wrongPowder.touchosc.Layout;

//OscP5 oscP5;
OscMessage message;
NetAddress net;


File file;
Osc send;
OscP5 oscP5;
Layout layout;

float r;


void setup() {
  size(1200, 800);
  smooth();
  
  oscP5 = new OscP5(this, 6000);
  net = new NetAddress("127.0.0.1",12000);
  
  // Initialize the class.
  file = new File();
  send = new Osc();//oscP5, "127.0.0.1", 6000, 9000);
  layout = new Layout(this);

  // Load a TouchOSC File.
  file.load(dataPath("Untitled 1.touchosc"));
  // and initialioze the Layout class.
  layout.init();

  // Get the version, mode and orientation of the TouchOSC file.
  println("version:     " + file.version());
  println("mode:        " + file.mode());
  println("orientation: " + file.orientation());

  // How many Tab Pages exist?
  println("numTabs(): " + file.numTabs());

  println(file.tabName);

  println("List Control Tags");
  for(int i=0; i<file.numTabs(); i++) {
    for(int j=0; j<file.controlType[i].length; j++) {
      println("[" + file.tabName[i] + "] " +
              "Name: "+file.controlName[i][j] +
              " Type: "+file.controlType[i][j] +
              " X: "+file.controlX[i][j] +
              " Y: "+file.controlY[i][j] +
              " W: "+file.controlW[i][j] +
              " H: "+file.controlH[i][j] +
              " Color: "+file.controlColor[i][j]);
    }
  }


  /*r = 0.0;
   for(int i=1; i<=8; i++) {
   println(r);
   send.setRotary(oscP5, "/2/send1"+i, r);
   send.setRotary(oscP5, "/2/send2"+i, r/2);
   send.setRotary(oscP5, "/2/send3"+i, r/3);
   send.setRotary(oscP5, "/2/pan"+i, 3/0.1);
   r+=0.1;
   }*/
}


void draw() {
  background(100);

  /*send.setRotary("/2/send1"+1, r);
   if(r>1.0) r=0.0;
   r+=0.01;
   println(r);
   */

  // Display the TouchOSC file layout.
  layout.draw(20, 20);
  
  //exit();
}


void mousePressed() {
  send.setButton(send.oscP5, "/3/input", 1);
}

 
void mouseDragged() {
  send.setFader(send.oscP5, "/1/volume1", map(mouseY, 0,height, 0.0, 1.0));
}
