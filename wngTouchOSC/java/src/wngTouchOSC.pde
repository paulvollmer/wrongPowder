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


import oscP5.*;
import netP5.*;
  

public class wngTouchOSC {
  
  OscP5 osc;
  OscMessage message;
  NetAddress net;
  
  
  /**
   * A Constructor, usually called in the setup() method in your sketch to
   * initialize and start the library.
   *
   * @param ip
   *        The IP to receive.
   * @param send
   *        The Port to send.
   * @param receive
   *        The Port to receive.
   */
  public wngTouchOSC(String ip, int portSend, int portReceive) {
    // start oscP5, listening for incoming messages at port 1234
    osc = new OscP5(this, portSend);
    // myRemoteLocation is a NetAddress. a NetAddress takes 2 parameters,
    // an ip address and a port number. myRemoteLocation is used as parameter in
    // oscP5.send() when sending osc packets to another computer, device, 
    // application. usage see below. for testing purposes the listening port
    // and the port of the remote location address are the same, hence you will
    // send messages back to this sketch.
    net = new NetAddress(ip, portReceive);
  }
  
  
  /**
   * Device Accelerometer X value
   *
   * @return float
   */
  public float accX(OscMessage msg) {
    float accelerometerX = 0;
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
   *
   * @return float
   */
  public float accY(OscMessage msg) {
    float accelerometerY = 0;
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
   *
   * @return float
   */
  public float accZ(OscMessage msg) {
    float accelerometerZ = 0;
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
   * @return float
   */
  public float getValue(OscMessage msg, String oscName) {
    float value = 0;
    if(msg.checkAddrPattern(oscName) == true) {
      if(msg.checkTypetag("f")) {
        value = msg.get(0).floatValue();
      }
    }
    return value;
  }
  
  
  /**
   * selectPage
   * Though not configurable controls, the pages in a TouchOSC layout can be addressed
   * with OSC messages. Sending an OSC message to TouchOSC with only the page name
   * as the address will make that page the active page and display it on the device.
   * info @ http://hexler.net/docs/touchosc-controls/
   *
   * @param oscName
   *        TouchOSC will make the page named <oscName> the active page.
   */
  public void selectPage(String oscName) {
    message = new OscMessage(oscName);
    osc.send(message, net);
  }
  
  
  /**
   * setLED
   * Incoming messages are mapped to the control’s value range and
   * update the brightness of the LED display.
   * info @ http://hexler.net/docs/touchosc-controls-reference/
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
   * info @ http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlValue
   *        float value
   */
  public void setLED(String oscName, float controlValue) {
    sendMessage(oscName, controlValue);
  }
  
  
  /**
   * setLabel
   * Values of incoming messages are displayed as text. Both textual and numeric values
   * can be received and displayed.
   * info @ http://hexler.net/docs/touchosc-controls-reference/
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
   * info @ http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param lableName
   *        float value
   */
  public void setLabel(String oscName, float lableName) {
    sendMessage(oscName, lableName);
  }
  
  
  /**
   * setLabel
   * Values are displayed as text. Both textual and numeric values can be send.
   * do not use Ä, ä, Ö, ö, Ü, ü and ß
   * info @ http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param lableName
   *        String value
   */
  public void setLabel(String oscName, String lableName) {
    sendMessage(oscName, lableName);
  }
  
  
  /**
   * setButton
   * Set the control state/value of Push/Toggle Buttons.
   * info @ http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlState
   *        int
   */
  public void setButton(String oscName, int controlState) {
    sendMessage(oscName, controlState);
  }
  
  
  /**
   * setXYpad
   * Set the control x and y value of XY Pad.
   * Both x and y values use the same value range.
   * info @ http://hexler.net/docs/touchosc-controls-reference/
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
   * info @ http://hexler.net/docs/touchosc-controls-reference/
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
  }
  
  
  /**
   * setFader
   * Set the control value of Fader.
   * info @ http://hexler.net/docs/touchosc-controls-reference/
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
   * info @ http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlValue
   *        float value
   */
  public void setFader(String oscName, float controlValue) {
    sendMessage(oscName, controlValue);
  }
  
  
  /**
   * setRotary
   * Set the control value of Rotary.
   * info @ http://hexler.net/docs/touchosc-controls-reference/
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
   * info @ http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlValue
   *        float value
   */
  public void setRotary(String oscName, float controlValue) {
    sendMessage(oscName, controlValue);
  }
  
  
  /**
   * setMultiToggle
   * Set the control state/value of all Multi-Toggle element.
   * info @ http://hexler.net/docs/touchosc-controls-reference/
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
  }
  
  
  /**
   * setMultiToggle
   * Set the control state/value of each Multi-Toggle element.
   * info @ http://hexler.net/docs/touchosc-controls-reference/
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
    message = new OscMessage(oscName);
    for(int i=0; i<rows; i++) {
      for(int j=0; j<cols; j++) {
        message.add(controlState[i+j]);
      }
    }
    osc.send(message, net);
  }
  
  
  // TODO ////////////////////////////////////////////////////////////////////////////////////////
  /**
   * setMultiToggle
   * Set the control state/value of each Multi-Toggle element.
   * info @ http://hexler.net/docs/touchosc-controls-reference/
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
   * info @ http://hexler.net/docs/touchosc-controls-reference/
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
   * info @ http://hexler.net/docs/touchosc-controls-reference/
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
  }
  
  
  /**
   * setMultiFader
   * Set the control state/value of each Multi-Fader element.
   * info @ http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlValue
   *        int array for each Fader element.
   */
  public void setMultiFader(String oscName, int[] controlValue) {
    message = new OscMessage(oscName);
    for(int i=0; i<controlValue.length; i++) {
      message.add(controlValue[i]);
    }
    osc.send(message, net);
  }
  
  
  /**
   * setMultiFader
   * Set the control state/value of each Multi-Fader element.
   * info @ http://hexler.net/docs/touchosc-controls-reference/
   *
   * @param oscName
   *        OSC name of the TouchOSC control element.
   * @param controlValue
   *        float array for each Fader element.
   */
  public void setMultiFader(String oscName, float[] controlValue) {
    message = new OscMessage(oscName);
    for(int i=0; i<controlValue.length; i++) {
      message.add(controlValue[i]);
    }
    osc.send(message, net);
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
  
  
}
