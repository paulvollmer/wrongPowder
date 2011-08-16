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
	
	// Set the Variables.
	x               = _x;
	y               = _y;
	textX           = _x + CHECKBOX_SIZE + 5;
	textY           = _y + CHECKBOX_SIZE;
	clickableWidth  = CHECKBOX_SIZE;
	clickableHeight = CHECKBOX_SIZE;
	
}


/**
 * initialize name and x, y positon for the checkbox.
 */
void ofxWNGUIcheckbox::init(string _name, int _x, int _y){
	
	name = _name;
	init(_x, _y);
	clickableWidth  = CHECKBOX_SIZE + 5 + font.stringWidth(_name);
	clickableHeight = CHECKBOX_SIZE;
}


/**
 * Draw the checkbox.
 */
void ofxWNGUIcheckbox::display(ofEventArgs &args){
	
	// Draw the Checkbox Rectangle,
	ofFill();
	if(status == false){
		ofSetHexColor(CHECKBOX_COLOR);
	} else {
		ofSetHexColor(CHECKBOX_COLOR_ACTIVE);
	}
	ofRect(x, y, CHECKBOX_SIZE, CHECKBOX_SIZE);
	
	// Draw the Textfield.
	ofSetHexColor(CHECKBOX_COLOR_FONT);
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
	
	if(overRect(args.x, args.y, x, y, clickableWidth, clickableWidth)) {
		status= !status;
	}
	
}
