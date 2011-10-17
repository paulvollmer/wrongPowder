/**
 * fxg_manyFiles
 * by wrongPowder Library.
 *
 * Saves one FXG file each each frame while the mouse is pressed.
 * When the mouse is released, the FXG creation stops.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.17
 */


import wrongPowder.fxg.*;
fxg FXG = new fxg(this);

boolean saveFXG = true;


void setup() {
  size(600, 600);
  frameRate(24);
}


void draw() {
  // Create a new file in the sketch directory
  if(saveFXG == true) {
    FXG.beginDraw("test"+frameCount+".fxg", width, height);
  }
  FXG.background(255); 
  FXG.stroke(0, 20);
  FXG.strokeWeight(20.0);
  FXG.line(mouseX, 0, width-mouseY, height);
  // close the FXG file
  if(saveFXG == true) {
    FXG.endDraw();
  }
}


void mousePressed() {
  saveFXG = true;
}


void mouseReleased() {
  saveFXG = false;
}