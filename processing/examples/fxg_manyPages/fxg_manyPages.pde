/**
 * fxg_manyPages
 * by wrongPowder Library.
 *
 * Saves a new page into a FXG file each loop through draw().
 * Pressing the mouse finishes writing the file and exits the program.
 * NOTE: after 100 Pages the FXG file format return an error.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.17
 */


import wrongPowder.fxg.*;
fxg FXG = new fxg(this);


void setup() {
  size(600, 600);
  frameRate(4);
  // Create a new file in the sketch directory
  FXG.beginDraw("file.fxg", width, height);
}


void draw() {
  FXG.beginPage();
  FXG.background(255); 
  FXG.stroke(0, 20);
  FXG.strokeWeight(20.0);
  FXG.line(mouseX, 0, width-mouseY, height);
  FXG.endPage();
}


void mousePressed() {
  // close the FXG file
  FXG.endDraw();
  exit();
}