/**
 * graphics_basic
 * by wrongPowder Library.
 *
 * TODO desc.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.31
 */


import wrongPowder.graphics.Graphics;
import wrongPowder.graphics.Grid;

Graphics graphics = new Graphics(this);
Grid grid = new Grid(this);


void setup() {
  size(600, 600);
  smooth();
}


void draw() {
  background(255);
  
  stroke(255, 0, 0);
  noFill();
  // Line grids
  grid.lineGrid(0, 0, 200, 200, 10, 10);
  grid.lineGridHorizontal(200, 0, 200, 200, 10);
  grid.lineGridVertical(400, 0, 200, 200, 10);
  
  noStroke();
  fill(255, 0, 0);
  grid.rectGrid(0, 200, 600, 200, 10, 30, 10);
  
  graphics.rectRounded(10, 410, 180, 180, 10);
  graphics.polygon(210, 410, 180, 5);
}
