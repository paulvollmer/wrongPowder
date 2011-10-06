/**
 *
 *  wngTouchOSC is a wrong-entertainment production
 *
 *
 *  Copyright 2011 wrong-entertainment
 *                 <wrongentertainment@yahoo.de>
 *                 <http://wrong-entertainment.com>
 * 
 *  This file is part of wnglibs.
 *
 *  wngTouchOSC is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  wngTouchOSC is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with wngTouchOSC. If not, see <http://www.gnu.org/licenses/>.
 *
 */


import wnglibs.*;
/*import oscP5.*;
import netP5.*;

OscP5 osc;
OscMessage message;
NetAddress net;*/

wngTouchOSC touchosc;



/**
 * setup
 */
void setup() {
  size(400, 400);
  frameRate(30);
  
  // start oscP5, listening for incoming messages at port 1234
  //osc = new OscP5(this, 1234);
  
  // myRemoteLocation is a NetAddress. a NetAddress takes 2 parameters,
  // an ip address and a port number. myRemoteLocation is used as parameter in
  // oscP5.send() when sending osc packets to another computer, device, 
  // application. usage see below. for testing purposes the listening port
  // and the port of the remote location address are the same, hence you will
  // send messages back to this sketch.
  //net = new NetAddress("127.0.0.1", 1234);
  
  touchosc = new wngTouchOSC();
  
  /*println("ACC X: " + touchosc.accX(message));
  println("ACC Y: " + touchosc.accY(message));
  println("ACC Z: " + touchosc.accZ(message));
  */
  touchosc.selectPage("/3");
  
  touchosc.setLED("/1/ledanysolo", 0.5);
  touchosc.setLabel("/1/time", 1);
  touchosc.setButton("/1/sel-rec", 1);
  touchosc.setXYpad("/page6/xy1", 0.5, 0.5);
  touchosc.setFader("/1/volume1", 0.5);
  touchosc.setRotary("/3/pan", 0.9);
  //tOsc.setMultiToggle("/3/insertbypass", 12, 1, 0);
  int[] mt = {0,1,0,1,0,1,0,1,0,1,0,1};
  touchosc.setMultiToggle("/3/insertbypass", 12, 1, mt);
  // TODO
  //int[][] mt = new int[12][1];
  //mt[][0] = {0,1,0,1,0,1,0,1,0,1,0,1};
  //touchosc.setMultiToggle("/3/insertbypass", mt);
  //tOsc.setMultiFader("/4/gain", 6, 1);
  float[] mf = {0.9, 0.2, 0.3, 0.7, 0.5, 0.6};
  touchosc.setMultiFader("/4/gain", mf);
  
  touchosc.show("/3/pan");
  touchosc.hide("/3/pan");
  touchosc.setColor("/4/gain", "orange");
  
  //touchosc.controllerVisible("/page1/toggle86", 0);
  //touchosc.controllerColor("/page1/toggle85", "gray");
}


/**
 * draw
 */
void draw() {
  background(0);
}


/*void oscEvent(OscMessage message) {
  
}*/

