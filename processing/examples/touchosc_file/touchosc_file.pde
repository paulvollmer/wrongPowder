import wrongPowder.touchosc.TouchOscFile;
import wrongPowder.touchosc.TouchOscLayout;

TouchOscFile tOscFile;
TouchOscLayout tOscLayout;


void setup() {
  size(1200, 800);
  frameRate(30);
  smooth();
  
  // Initialize the class.
  tOscFile = new TouchOscFile();
  tOscLayout = new TouchOscLayout(this);
  
  // Load a TouchOSC File.
  tOscFile.load(dataPath("Untitled 1.touchosc"));
  // and initialioze the Layout class.
  tOscLayout.init();
  
  // Get the version, mode and orientation of the TouchOSC file.
  println("version:     " + tOscFile.version());
  println("mode:        " + tOscFile.mode());
  println("orientation: " + tOscFile.orientation());
  
  // How many Tab Pages exist?
  //println("numTabs(): " + tOscFile.numTabs());
  
  //println(tOscFile.tabName);
  
  /*println("List Control Tags");
  for(int i=0; i<tOscFile.numTabs(); i++) {
    for(int j=0; j<tOscFile.controlType[i].length; j++) {
      println("[" + tOscFile.tabName[i] + "] " +
              "Name: "+tOscFile.controlName[i][j] +
              " Type: "+tOscFile.controlType[i][j] +
              " X: "+tOscFile.controlX[i][j] +
              " Y: "+tOscFile.controlY[i][j] +
              " W: "+tOscFile.controlW[i][j] +
              " H: "+tOscFile.controlH[i][j] +
              " Color: "+tOscFile.controlColor[i][j]);
    }
  }*/
}


void draw() {
  background(100);
  
  // Display the TouchOSC file layout.
  tOscLayout.draw(200, 200);
  
  /*for(int i=0; i<tOscFile.tabs.length; i++) {
    stroke(0);
    fill(255, 0, 0);
    rect(i*(1024/tOscFile.tabs.length), 0, 1024/tOscFile.tabs.length, 20);
  }*/
  
  //exit();
}
