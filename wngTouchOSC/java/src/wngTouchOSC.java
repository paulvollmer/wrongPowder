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


package wnglibs;

import oscP5.*;
import netP5.*;


public class wngTouchOSC {
  
  OscP5 osc;
  OscMessage message;
  NetAddress net;
  
  public String ip;
  public int    portReceive;
  public int    portSend;
  //public float[] accelerometer = new float[3]; 
  public float  accelerometerX;
  public float  accelerometerY;
  public float  accelerometerZ;
  //private float page;
  private float val;
  
  
  /**
   * a Constructor, usually called in the setup() method in your sketch to
   * initialize and start the library.
   */
  public wngTouchOSC() {
    // start oscP5, listening for incoming messages at port 1234
    osc = new OscP5(this, 1234);
    
    // myRemoteLocation is a NetAddress. a NetAddress takes 2 parameters,
    // an ip address and a port number. myRemoteLocation is used as parameter in
    // oscP5.send() when sending osc packets to another computer, device, 
    // application. usage see below. for testing purposes the listening port
    // and the port of the remote location address are the same, hence you will
    // send messages back to this sketch.
    net = new NetAddress("127.0.0.1", 1234);
  }
  
  
  
  // TODO //////////////////////////////////////////////////////////////////////
  // add oscP5 function
  
  //TouchOSCp5() { }
  
  /*TouchOSC(int receive, String i, int send) {
    portReceive = receive;
    ip = i;
    portSend = send
  }*/
  
  
  
  /**
   * oscSetup
   * initialize OscP5, setting port value
   *
   * @param portReceive
   *        port Receiver value
   * @param ip
   *        IP to send
   * @param portSend
   *        port Sender value
   *
  void oscSetup(int portReceive, String ip, int portSend) {
    if(osc_active == true) {
      // start oscP5, listening for incoming messages at "port"
      osc = new OscP5(this, portReceive);
      
      // myRemoteLocation is a NetAddress. a NetAddress takes 2 parameters,
      // an ip address and a port number. myRemoteLocation is used as parameter in
      // oscP5.send() when sending osc packets to another computer, device, 
      // application. usage see below. for testing purposes the listening port
      // and the port of the remote location address are the same, hence you will
      // send messages back to this sketch.
      net = new NetAddress(ip, portSend);
    }
  }*/
  
  
  
  
  
  /**
   * Device Accelerometer X, Y, Z value array
   */
  /*public float[] acc(OscMessage message) {
    float[] accelerometer = new float[3]; 
    // check accelerator value and get the values
    if(msg.checkAddrPattern("/accxyz") == true) {
      // check if the typetag is the right one.
      if(msg.checkTypetag("fff")) {
        accelerometer[0] = msg.get(0).floatValue();
        accelerometer[1] = msg.get(1).floatValue();
        accelerometer[2] = msg.get(2).floatValue();
      }
    }
    return accelerometer;
  }*/
  
  /**
   * Device Accelerometer X value
   */
  public float accX(OscMessage msg) {
    // check accelerator value and get the values
    if(msg.checkAddrPattern("/accxyz") == true) {
      // check if the typetag is the right one.
      if(msg.checkTypetag("fff")) {
        accelerometerX = msg.get(0).floatValue();
      }
    }
    return accelerometerX;
  }
  
  /**
   * Device Accelerometer Y value
   */
  public float accY(OscMessage msg) {
    // check accelerator value and get the values
    if(msg.checkAddrPattern("/accxyz") == true) {
      // check if the typetag is the right one.
      if(msg.checkTypetag("fff")) {
        accelerometerY = msg.get(1).floatValue();
      }
    }
    return accelerometerY;
  }
  
  /**
   * Device Accelerometer Z value
   */
  public float accZ(OscMessage msg) {
    // check accelerator value and get the values
    if(msg.checkAddrPattern("/accxyz") == true) {
      // check if the typetag is the right one.
      if(msg.checkTypetag("fff")) {
        accelerometerZ = msg.get(2).floatValue();
      }
    }
    return accelerometerZ;
  }
  
  
  
  
  
  // TODO /////////////////////////////////////////////////
  /**
   * getPage
   * get the page name
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   *
  public String getPage(OscMessage msg, String oscName) {
    if(msg.checkAddrPattern(oscName) == true) {
      if(msg.checkTypetag("f")) {
        page = msg.get(0).floatValue();
      }
    }
    return page;
  }*/
  
  /**
   * getValue
   * get a float value
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   */
  public float getValue(OscMessage msg, String oscName) {
    if(msg.checkAddrPattern(oscName) == true) {
      if(msg.checkTypetag("f")) {
        val = msg.get(0).floatValue();
      }
    }
    return val;
  }
  
  
  
  
  
  
  
  
  
  
  /**
   * selectPage
   * Though not configurable controls, the pages in a TouchOSC layout can be addressed
   * with OSC messages. Sending an OSC message to TouchOSC with only the page name
   * as the address will make that page the active page and display it on the device.
   *
   * http://hexler.net/docs/touchosc-controls/
   *
   * @param oscName
   *        TouchOSC will make the page named <oscName> the active page.
   */
  public void selectPage(String oscName) {
    message = new OscMessage(oscName);
    osc.send(message, net);
    
    consoleOutput("Page: <"+oscName+"> selected");
  }
  
  
  
  
  
  /**
   * setLED
   * Incoming messages are mapped to the control’s value range and
   * update the brightness of the LED display.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlValue
   *        int value
   */
  public void setLED(String oscName, int controlValue) {
    setLED(oscName, (float)controlValue);
  }
  
  /**
   * setLED
   * Incoming messages are mapped to the control’s value range and
   * update the brightness of the LED display.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlValue
   *        float value
   */
  public void setLED(String oscName, float controlValue) {
    sendMessage(oscName, controlValue);
    
    consoleOutput("LED: "+oscName+" set to "+controlValue);
  }
  
  
  
  
  
  /**
   * setLabel
   * Values of incoming messages are displayed as text. Both textual and numeric values
   * can be received and displayed.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param lableName
   *        int value
   */
  public void setLabel(String oscName, int lableName) {
    setLabel(oscName, (float)lableName);
  }
  
  /**
   * setLabel
   * Values are displayed as text. Both textual and numeric values can be send.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param lableName
   *        float value
   */
  public void setLabel(String oscName, float lableName) {
    sendMessage(oscName, lableName);
    
    consoleOutput("Lable: "+oscName+" set to "+lableName);
  }
  
  /**
   * setLabel
   * Values are displayed as text. Both textual and numeric values can be send.
   * do not use Ä, ä, Ö, ö, Ü, ü and ß
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param lableName
   *        String value
   */
  public void setLabel(String oscName, String lableName) {
    sendMessage(oscName, lableName);
    
    consoleOutput("Lable: "+oscName+" set to "+lableName);
  }
  
  
  
  
  
  /**
   * setButton
   * Set the control state/value of Push/Toggle Buttons.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlState
   *        int
   */
  public void setButton(String oscName, int controlState) {
    sendMessage(oscName, controlState);
    
    consoleOutput("Push/Toggle: "+oscName+" set to "+controlState);
  }
  
  
  
  
  
  /**
   * setXYpad
   * Set the control x and y value of XY Pad.
   * Both x and y values use the same value range.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlX
   *        x axis integer value of the control
   * @param controlY
   *        y axis integer value of the control
   */
  public void setXYpad(String oscName, int controlX, int controlY) {
    setXYpad(oscName, (float)controlX, (float)controlY);
  }
  
  /**
   * setXYpad
   * Set the control x and y value of XY Pad.
   * Both x and y values use the same value range.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlX
   *        x axis float value of the control
   * @param controlY
   *        y axis float value of the control
   */
  public void setXYpad(String oscName, float controlX, float controlY) {
    message = new OscMessage(oscName);
    message.add(controlX);
    message.add(controlY);
    osc.send(message, net);
    
    consoleOutput("XY Pad: "+oscName+" set to X: "+controlX+", Y: "+controlY);
  }
  
  
  
  
  
  /**
   * setFader
   * Set the control value of Fader.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlValue
   *        integer value
   */
  public void setFader(String oscName, int controlValue) {
    setFader(oscName, (float)controlValue);
  }
  
  /**
   * setFader
   * Set the control value of Fader.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlValue
   *        float value
   */
  public void setFader(String oscName, float controlValue) {
    sendMessage(oscName, controlValue);
    
    consoleOutput("Fader: "+oscName+" set to "+controlValue);
  }
  
  
  
  
  
  /**
   * setRotary
   * Set the control value of Rotary.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlValue
   *        integer value
   */
  public void setRotary(String oscName, int controlValue) {
    setRotary(oscName, (float)controlValue);
  }
  
  /**
   * setRotary
   * Set the control value of Rotary.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlValue
   *        float value
   */
  public void setRotary(String oscName, float controlValue) {
    sendMessage(oscName, controlValue);
    
    consoleOutput("Rotary: "+oscName+" set to "+controlValue);
  }
  
  
  
  
  
  /**
   * setMultiToggle
   * Set the control state/value of all Multi-Toggle element.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param rows
   *        number of Multi-Toggle rows
   * @param cols
   *        number of Multi-Toggle columns
   * @param controlState
   *        int
   */
  public void setMultiToggle(String oscName, int rows, int cols, int controlState) {
    message = new OscMessage(oscName);
    for(int i=0; i<rows; i++) {
      for(int j=0; j<cols; j++) {
        message.add(controlState);
      }
    }
    osc.send(message, net);
    
    consoleOutput("Multi-Toggle "+rows+"x"+cols+": "+oscName+" set all to "+controlState);
  }
  
  /**
   * setMultiToggle
   * Set the control state/value of each Multi-Toggle element.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param rows
   *        number of Multi-Toggle rows
   * @param cols
   *        number of Multi-Toggle columns
   * @param controlState
   *        int array for each Button element.
   */
  public void setMultiToggle(String oscName, int rows, int cols, int[] controlState) {
    //print("### ["+year()+"/"+month()+"/"+day()+" "+hour()+":"+minute()+":"+second()+"] TouchOSC Multi-Toggle "+rows+"x"+cols+": "+oscName+" set to ");
    
    message = new OscMessage(oscName);
    for(int i=0; i<rows; i++) {
      for(int j=0; j<cols; j++) {
        message.add(controlState[i+j]);
        
        //print(controlState[i+j]+", ");
      }
    }
    osc.send(message, net);
    
    //println();
  }
  
  // TODO ////////////////////////////////////////////////////////////////////////////////////////
  /**
   * setMultiToggle
   * Set the control state/value of each Multi-Toggle element.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlState
   *        int array for each Button element.
   *
  public void setMultiToggle(String oscName, int[][] controlState) {
    print("### ["+year()+"/"+month()+"/"+day()+" "+hour()+":"+minute()+":"+second()+"] TouchOSC Multi-Toggle "+oscName+" set to ");
    
    myMessage = new OscMessage(oscName);
    for(int i=0; i<controlState.length; i++) {
      for(int j=0; j<controlState[0].length; j++) {
        myMessage.add(controlState[i][j]);
        
        print(controlState[i][j]+", ");
      }
    }
    osc.send(myMessage, net);
    
    println();
  }*/
  
  
  
  
  
  /**
   * setMultiFader
   * Set the control state/value of all Multi-Fader element.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param rows
   *        number of Multi-Fader
   * @param controlValue
   *        int value
   */
  public void setMultiFader(String oscName, int num, int controlValue) {
    setMultiFader(oscName, num, (float)controlValue);
  }
  
  /**
   * setMultiFader
   * Set the control state/value of all Multi-Fader element.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param rows
   *        number of Multi-Fader
   * @param controlValue
   *        float value
   */
  public void setMultiFader(String oscName, int num, float controlValue) {
    message = new OscMessage(oscName);
    for(int i=0; i<num; i++) {
      message.add(controlValue);
    }
    osc.send(message, net);
    
    consoleOutput("Multi-Toggle "+num+" : "+oscName+" set all to "+controlValue);
  }
  
  /**
   * setMultiFader
   * Set the control state/value of each Multi-Fader element.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlValue
   *        int array for each Fader element.
   */
  public void setMultiFader(String oscName, int[] controlValue) {
    //print("### ["+year()+"/"+month()+"/"+day()+" "+hour()+":"+minute()+":"+second()+"] TouchOSC Multi-Fader "+oscName+" set to ");
    
    message = new OscMessage(oscName);
    for(int i=0; i<controlValue.length; i++) {
      message.add(controlValue[i]);
      
      //print(controlValue[i]+", ");
    }
    osc.send(message, net);
    
    //println();
  }
  
  /**
   * setMultiFader
   * Set the control state/value of each Multi-Fader element.
   *
   * http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlValue
   *        float array for each Fader element.
   */
  public void setMultiFader(String oscName, float[] controlValue) {
    //print("### ["+year()+"/"+month()+"/"+day()+" "+hour()+":"+minute()+":"+second()+"] TouchOSC Multi-Fader "+oscName+" set to ");
    
    message = new OscMessage(oscName);
    for(int i=0; i<controlValue.length; i++) {
      message.add(controlValue[i]);
      
      //print(controlValue[i]+", ");
    }
    osc.send(message, net);
    
    //println();
  }
  
  
  
  
  
  
  
  /**
   * sendMessage
   * Send a Integer value to the TouchOSC control element.
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param msg
   *        int to be send.
   */
  public void sendMessage(String oscName, int msg) {
    message = new OscMessage(oscName);
    message.add(msg);
    osc.send(message, net);
  }
  
  /**
   * sendMessage
   * Send a Float value to the TouchOSC control element.
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param msg
   *        float to be send.
   */
  public void sendMessage(String oscName, float msg) {
    message = new OscMessage(oscName);
    message.add(msg);
    osc.send(message, net);
  }
  
  /**
   * sendMessage
   * Send a String value to the TouchOSC control element.
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param msg
   *        String to be send.
   */
  public void sendMessage(String oscName, String msg) {
    message = new OscMessage(oscName);
    message.add(msg);
    osc.send(message, net);
  }
  
  
  
  
  
  /**
   * vibrate
   * Triggers device vibration (iPhone only)
   * info @ http://hexler.net/docs/touchosc-controls/
   */
  public void vibrate() {
    message = new OscMessage("/vibrate");
    osc.send(message, net);
  }
  
  
  
  
  
  /**
   * visible
   * * Set TouchOSC control to be visible / invisible.
   * info @ http://hexler.net/docs/touchosc-controls/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlStatus
   *        Status of the TouchOSC control.
   *        0 set the control to be invisible
   *        1 set the control to be visible
   */
  public void visible(String oscName, int controlStatus) {
    sendMessage(oscName+"/visible", controlStatus);
  }
  
  /**
   * show
   * Set TouchOSC control to be visible.
   * info @ http://hexler.net/docs/touchosc-controls/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   */
  public void show(String oscName) {
    sendMessage(oscName+"/visible", 1);
  }
  
  /**
   * hide
   * Set TouchOSC control to be invisible.
   * info @ http://hexler.net/docs/touchosc-controls/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   */
  public void hide(String oscName) {
    sendMessage(oscName+"/visible", 0);
  }
  
  
  
  
  
  /**
   * setColor
   * Change a control’s color palette to <color>. Possible values for the color parameter
   * are all the available color settings for the Color property in the TouchOSC editor.
   * Available colors are "red", "green", "blue", "yellow", "purple", "gray" and "orange".
   * info @ http://hexler.net/docs/touchosc-controls/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlColor
   *        String of available color property.
   */
  public void setColor(String oscName, String controlColor) {
    sendMessage(oscName+"/color", controlColor);
  }
  
  
  
  /*
   * ### [year/month/day hour:minute:second] TouchOSC
   */
  private void consoleOutput(String s) {
    //println("### ["+year()+"/"+month()+"/"+day()+" "+hour()+":"+minute()+":"+second()+"] TouchOSC "+s);
  }



}
