

/**
 * math_basic
 * by wrongPowder Library.
 *
 * TODO desc.
 *
 * @author    Paul Vollmer
 * @modified  2011.11.05
 */

//import wrongPowder.io.Log;
import wrongPowder.math.Geometry;

Geometry math = new Geometry();


void setup() {
  size(1200, 800);
  smooth();
  background(255);
}

void draw() {
  translate(width/2, height/2);
  
  noFill();
  stroke(0);
  strokeWeight(1);
  
  for(float n=1; n<7; n++) {
    for (float i=0; i<height-200; i+=0.5) {
      PVector h1 = math.epicycloid(150, 150/n, i);
      point(h1.x, h1.y);
    }
  }
  
}
