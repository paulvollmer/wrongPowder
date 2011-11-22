/**
 * math_basic
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


void setup() {
  size(500, 600);
  smooth();
  background(0);
}

void draw() {
  background(0, 120);
  
  
  noFill();
  stroke(255, 0, 0);
  strokeWeight(2);
  
  text("cycloid", 10, 40);
  for (float i=0; i<20; i+=0.05) {
    PVector h1 = math.cycloid(20, i);
    point(20+h1.x, 50+h1.y);
  }
  
  text("epicycloid", 10, 150);
  for (float i=0; i<width-200; i+=0.5) {
    PVector h1 = math.epicycloid(60, 60/3, i);
    point(120+h1.x, 250+h1.y);
  }
  
  text("epitrochoid", 250, 150);
  for (float i=0; i<width-200; i+=0.5) {
    PVector h1 = math.epitrochoid(60, 60/3, 10, i);
    point(340+h1.x, 250+h1.y);
  }
  
  text("epitrochoid", 250, 150);
  for (float i=0; i<width-200; i+=0.5) {
    PVector h1 = math.epitrochoid(60, 60/3, 10, i);
    point(340+h1.x, 250+h1.y);
  }
  
  text("hypocycloid", 10, 400); 
  for (float i = 0; i < 40; i = i+0.1) {
    PVector h1 = math.hypocycloid(60, 3, i);
    point(100+h1.x, 500+h1.y);
  }
  
  text("hypotrochoid", 250, 400); 
  for (float i = 0; i < 40; i = i+0.1) {
    PVector h1 = math.hypotrochoid(50, 30, 50, i);
    point(350+h1.x, 500+h1.y);
  }
  
  
}
