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


#include "ofxWNGUIbutton.h"


/**
 * Constuctor
 */
ofxWNGUIbutton::ofxWNGUIbutton() {
	
	addListener();
	
	status            = false;
	shortcutActive    = false;
	//descriptionActive = false;
	
};


/**
 * Add ofEvents for the ofxWNGUIbutton class.
 */
void ofxWNGUIbutton::addListener() {
	
	ofAddListener(ofEvents.update, this, &ofxWNGUIbutton::update);
	//ofAddListener(ofEvents.draw, this, &ofxWNGUIbutton::draw);
	ofAddListener(ofEvents.exit, this, &ofxWNGUIbutton::exit);
	ofAddListener(ofEvents.mouseMoved, this, &ofxWNGUIbutton::onMove);
	ofAddListener(ofEvents.mousePressed, this, &ofxWNGUIbutton::onPress);
	ofAddListener(ofEvents.keyPressed, this, &ofxWNGUIbutton::keyPress);
	
}


/**
 * Remove ofEvents for the ofxWNGUIbutton class.
 */
void ofxWNGUIbutton::removeListener() {
	
	ofRemoveListener(ofEvents.update, this, &ofxWNGUIbutton::update);
	//ofRemoveListener(ofEvents.draw, this, &ofxWNGUIbutton::draw);
	ofRemoveListener(ofEvents.exit, this, &ofxWNGUIbutton::exit);
	ofRemoveListener(ofEvents.mouseMoved, this, &ofxWNGUIbutton::onMove);
	ofRemoveListener(ofEvents.mousePressed, this, &ofxWNGUIbutton::onPress);
	ofRemoveListener(ofEvents.keyPressed, this, &ofxWNGUIbutton::keyPress);
	
}


/**
 * initialize x, y positon and width, height for the button.
 */
void ofxWNGUIbutton::init(string _name, int _x, int _y, int _w, int _h) {
	
	name = _name;
	x = _x;
	y = _y;
	w = _w;
	h = _h;
	
	// calculate text position
	int tw = font.stringWidth(_name);
	int th = font.stringHeight(_name);
	textX = _x + w*0.5 - (tw*0.5);
	textY = _y + h*0.5 + (th*0.5);
	
}


/**
 * update
 */
void ofxWNGUIbutton::update(ofEventArgs &args) {
	
	/*if(descriptionActive == true && descriptionDisplay == true) {
		descriptionCounter++;
	}*/
	
}


/**
 * Draw the button.
 */
void ofxWNGUIbutton::display() {//ofEventArgs &args) {
	
	ofFill();
	if(status == false) {
		ofSetHexColor(BUTTON_COLOR);
	} else {
		ofSetHexColor(BUTTON_COLOR_ACTIVE);
	}
	roundedRect(x, y, w, h, BUTTON_ROUNDEDRECT);
	
	ofSetHexColor(FONT_COLOR);
	font.drawString(name, textX, textY);
	
	// description
	/*if(descriptionCounter > DESCRIPTION_TIME) {
		displayDescription(description, descriptionX, descriptionY);
	}*/
	
}


/**
 * If Application exit, remove the listener.
 */
void ofxWNGUIbutton::exit(ofEventArgs &args) {
	
	removeListener();
	
}


/**
 * Check if mouse is moved and over the button.
 * Display description if it is active.
 */
void ofxWNGUIbutton::onMove(ofMouseEventArgs &args) {
	
	/*if(descriptionActive == true && overRect(args.x, args.y, x, y, w, h) == true) {
		descriptionDisplay = true;
		// set descriptionX, descriptionY coordiante
		if(descriptionCounter < DESCRIPTION_TIME) {
			descriptionX = args.x;
			descriptionY = args.y+20;
		}
	} else {
		descriptionCounter = 0;
		descriptionDisplay = false;
	}*/
	
}


/**
 * Check if mouse is pressed and over the button.
 */
void ofxWNGUIbutton::onPress(ofMouseEventArgs &args) {
	
	if(overRect(args.x, args.y, x, y, w, h)) {
		status = !status;
	}
	
}


/**
 * Check if shortcut is active and the key is pressed.
 */
void ofxWNGUIbutton::keyPress(ofKeyEventArgs &args) {
	
	if(shortcutActive == true && args.key == shortcut) {
		status = !status;
	}
	
}


/**
 * Set a Shortcut for the button.
 * If _active is true, activate the shortcut function.
 * The _shortcut char set up the key you will be use.
 */
void ofxWNGUIbutton::setShortcut(char _shortcut, bool _active) {
	
	shortcut = _shortcut;
	shortcutActive = _active;
	
}


/**
 * Set a description for the button.
 *
void ofxWNGUIbutton::setDescription(string _description, bool _active) {
	
	description = _description;
	descriptionActive = _active;
	
}*/
