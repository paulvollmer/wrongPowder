/**
 * capture_basic
 * by wrongPowder Library.
 *
 * TODO desc.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.31
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
