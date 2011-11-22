/**
 * math_epicycloidMotion
 * by wrongPowder Library.
 *
 * TODO desc.
 *
 * @author              Paul Vollmer
 * @modified            2011.11.05
 * @processing-version  2.0a1
 */

//import wrongPowder.io.Log;
import wrongPowder.math.Geometry;

Geometry math = new Geometry();

float counter = 0;

void setup() {
  size(1200, 800);
  smooth();
}

void draw() {
  background(255);
  translate(width/2, height/2);
  
  noFill();
  stroke(255, 0, 0);
  for (float i=0; i<TWO_PI; i+=0.001) {
    PVector h2 = math.epicycloid(250, 250/5, i);
    point(h2.x, h2.y);
  }
  
  fill(0);
  noStroke();
  PVector h1 = math.epicycloid(250, 250/5, counter);
  ellipse(h1.x, h1.y, 40, 40);
  counter+=0.05;
  
}
