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
  
  // Get the version, mode and orientation of the TouchOSC file.
  println("version:     " + tOscFile.version());
  println("mode:        " + tOscFile.mode());
  println("orientation: " + tOscFile.orientation());
  
  // How many Tab Pages exist?
  println("numTabs(): " + tOscFile.numTabs());
  
  println(tOscFile.tabs);
}


void draw() {
  background(100);
  
  // Display the TouchOSC file layout.
  tOscLayout.draw(0, 0);
  
  /*for(int i=0; i<tOscFile.tabs.length; i++) {
    stroke(0);
    fill(255, 0, 0);
    rect(i*(1024/tOscFile.tabs.length), 0, 1024/tOscFile.tabs.length, 20);
  }*/
  
  //exit();
}
