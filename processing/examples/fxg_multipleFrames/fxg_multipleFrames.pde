/**
 * fxg_multipleFrames
 * by wrongPowder Library.
 *
 * Saves one FXG document of many frames drawn to the screen.
 * Starts the file when the mouse is pressed and end the file
 * when the mouse is released.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.17
 */
 

import wrongPowder.fxg.*;
fxg FXG = new fxg(this);


void setup() {
  size(600, 600);
  frameRate(24);
  FXG.background(255);
}


void draw() {
  FXG.stroke(0, 20);
  FXG.strokeWeight(20.0);
  FXG.line(mouseX, 0, width-mouseY, height);
}


void mousePressed() {
  // Create a new file in the sketch directory
  FXG.beginDraw("test"+frameCount+".fxg", width, height);
  FXG.background(255);
}


void mouseReleased() {
  // close the FXG file
  FXG.endDraw();
  FXG.background(255);
}