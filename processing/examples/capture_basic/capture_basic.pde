/**
 * capture_basic
 * by wrongPowder Library.
 *
 * Capture your screen as image.
 *
 * @author              Paul Vollmer
 * @modified            2011.10.31
 * @processing-version  2.0a1
 */


import wrongPowder.util.CaptureScreen;

CaptureScreen capture = new CaptureScreen(this);


void setup() {
  size(400, 400);
}


void draw() {
  capture.init(mouseX, mouseY, 200, 200);
  image(capture.screenShot, 0, 0);
}
