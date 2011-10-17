/**
 * Multiple Frames. 
 * Saves one FXG document of many frames drawn to the screen.
 * Starts the file when the mouse is pressed and end the file
 * when the mouse is released.
 *
 *
 *
 * wng.FXG is a wrong-entertainment production:
 * http://wrong-entertainment.com/
 *
 * Copyright (c) 2010-2011 Paul Vollmer, wrongentertainment@yahoo.de
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * http://creativecommons.org/licenses/LGPL/2.1/
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
 */

import wng.FXG.*;
wngFXGexport FXG = new wngFXGexport(this);



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
