import wng.FCP.*;

wngFCPexport FCP = new wngFCPexport(this);

boolean record = true;
int recordFrames = 50;



void setup() {
  size(200, 200);
  frameRate(25);
  
  if(record == true) {
    // Create a new file in the sketch directory
    FCP.createFCP(sketchPath("test.xml"), width, height);
  }
}


void draw() {
  
  //FCP.rect();
  
  String s = "STRINGTEST"+frameCount;
  FCP.text(s, frameCount, frameCount+1);
  
  println(frameCount);
  
  if(frameCount >= recordFrames) {
    // close the FXG file
    FCP.closeFCP();
    exit();
  }
}
