/**
 *
 *  ofxWNGUI is a wrong-entertainment production
 *
 *
 *  Copyright 2011 wrong-entertainment
 *                 <wrongentertainment@yahoo.de>
 *                 <http://wrong-entertainment.com>
 * 
 *  This file is part of ofxWNGUI.
 *
 *  ofxWNGUI is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  ofxWNGUI is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with ofxWNGUI.  If not, see <http://www.gnu.org/licenses/>.
 *
 */


#include "ofxWNGUIcheckbox.h"


/**
 * Constuctor
 */
ofxWNGUIcheckbox::ofxWNGUIcheckbox(){
	
	//addListener();
	status = false;
	
};


/**
 * Add ofEvents for the ofxWNGUIcheckbox class.
 */
void ofxWNGUIcheckbox::addListener(){
	
	ofAddListener(ofEvents.draw, this, &ofxWNGUIcheckbox::display);
	ofAddListener(ofEvents.exit, this, &ofxWNGUIcheckbox::exit);
	ofAddListener(ofEvents.mousePressed, this, &ofxWNGUIcheckbox::onPress);
	
}


/**
 * Remove ofEvents for the ofxWNGUIcheckbox class.
 */
void ofxWNGUIcheckbox::removeListener(){
	
	ofRemoveListener(ofEvents.draw, this, &ofxWNGUIcheckbox::display);
	ofRemoveListener(ofEvents.exit, this, &ofxWNGUIcheckbox::exit);
	ofRemoveListener(ofEvents.mousePressed, this, &ofxWNGUIcheckbox::onPress);
	
}


/**
 * initialize x, y positon for the checkbox.
 */
void ofxWNGUIcheckbox::init(int _x,int _y){
	
	addListener();
	
	x = _x;
	y = _y;
	textX = _x + CHECKBOX_SIZE + 5;
	textY = _y + CHECKBOX_SIZE;
	
}


/**
 * initialize name and x, y positon for the checkbox.
 */
void ofxWNGUIcheckbox::init(string _name, int _x, int _y){
	
	name = _name;
	
	init(_x, _y);
}


/**
 * Draw the checkbox.
 */
void ofxWNGUIcheckbox::display(ofEventArgs &args){
	
	// draw the checkbox rectangle
	ofEnableAlphaBlending();
		ofFill();
		if(status == false){
			ofSetColor(CHECKBOX_COLOR_R, CHECKBOX_COLOR_G, CHECKBOX_COLOR_B, CHECKBOX_ALPHA);
		} else {
			ofSetColor(CHECKBOX_COLOR_ACTIVE_R, CHECKBOX_COLOR_ACTIVE_G, CHECKBOX_COLOR_ACTIVE_B, CHECKBOX_ALPHA);
		}
		ofRect(x, y, CHECKBOX_SIZE, CHECKBOX_SIZE);
	ofDisableAlphaBlending();
	
	// draw the text
	ofSetColor(FONT_COLOR_R, FONT_COLOR_G, FONT_COLOR_B);
	font.drawString(name, textX, textY);
	
}


/**
 * If Application exit, remove the listener.
 */
void ofxWNGUIcheckbox::exit(ofEventArgs &args){
	
	removeListener();
	
}


/**
 * Check if mouse is pressed and over the checkbox.
 */
void ofxWNGUIcheckbox::onPress(ofMouseEventArgs &args){
	
	if(overRect(args.x, args.y, x, y, CHECKBOX_SIZE, CHECKBOX_SIZE)) {
		status= !status;
	}
	
}
