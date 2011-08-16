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


#include "ofxWNGUIrightclickMenu.h"


/**
 * Constuctor
 */
ofxWNGUIrightclickMenu::ofxWNGUIrightclickMenu(){
	
	addListener();
	
	status = false;
	
};


/**
 * Add ofEvents for the ofxWNGUIrightclickMenu class.
 */
void ofxWNGUIrightclickMenu::addListener(){
	
	ofAddListener(ofEvents.update, this, &ofxWNGUIrightclickMenu::update);
	//ofAddListener(ofEvents.draw, this, &ofxWNGUIrightclickMenu::draw);
	ofAddListener(ofEvents.exit, this, &ofxWNGUIrightclickMenu::exit);
	ofAddListener(ofEvents.mousePressed, this, &ofxWNGUIrightclickMenu::onPress);
	
}


/**
 * Remove ofEvents for the ofxWNGUIrightclickMenu class.
 */
void ofxWNGUIrightclickMenu::removeListener(){
	
	ofRemoveListener(ofEvents.update, this, &ofxWNGUIrightclickMenu::update);
	//ofRemoveListener(ofEvents.draw, this, &ofxWNGUIrightclickMenu::draw);
	ofRemoveListener(ofEvents.exit, this, &ofxWNGUIrightclickMenu::exit);
	ofRemoveListener(ofEvents.mousePressed, this, &ofxWNGUIrightclickMenu::onPress);
	
}


/**
 * initialize x, y positon for the checkbox.
 */
void ofxWNGUIrightclickMenu::init(int _x,int _y, int _w, int _h){
	
	x = _x;
	y = _y;
	w = _w;
	h = _h;
	
}


/**
 * update
 */
void ofxWNGUIrightclickMenu::update(ofEventArgs &args){
	
}


/**
 * Draw the checkbox.
 */
void ofxWNGUIrightclickMenu::display(){//ofEventArgs &args) {
	
	if(status == true) {
		ofEnableAlphaBlending();
		
		ofFill();
		ofSetHexColor(RIGHTCLICKMENU_COLOR_BACKGROUND);
	
		roundedRect(x, y, 100, 100, RIGHTCLICKMENU_ROUNDEDRECT);
		
		ofDisableAlphaBlending();
	}
	
}


/**
 * If Application exit, remove the listener.
 */
void ofxWNGUIrightclickMenu::exit(ofEventArgs &args){
	
	removeListener();
}


/**
 * Check if mouse is pressed and over the checkbox.
 */
void ofxWNGUIrightclickMenu::onPress(ofMouseEventArgs &args){
	
	if(args.button == 2 && overRect(args.x, args.y, x, y, w, h)){
		status = !status;
	}
	if(status == true && args.button == 0) {
		status = false;
	}
	
}
