/**
 *
 *  ofxWNGUI is a wrong-entertainment production
 *
 *
 *  Copyright 2011 wrong-entertainment
 *                 wrongentertainment@yahoo.de
 *                 http://wrong-entertainment.com
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



#include "testApp.h"



//--------------------------------------------------------------
void testApp::setup() {
	ofSetFrameRate(60);
	ofBackground(127,127,127);
	
	// button
	for(int i=0; i<3; i++) {
		button[i].init("TEST", 50, 50*i, 100, 20);
		button[i].addListener();
	}
	button[0].setShortcut('a', true);
	button[0].setDescription("Hello World This is a Test\nsecond row\nwrong-entertainment", true);
	
	// checkbox
	checkbox[0].init(200, 50);
	checkbox[0].status = true;
	
	checkbox[1].init(220, 50);
	checkbox[1].removeListener();
	
	// rightclick menu
	rMenu.init(0, 0, 100, 100);	
}


//--------------------------------------------------------------
void testApp::update() {
	if(checkbox[0].status == true){
		checkbox[1].addListener();
	}else{
		checkbox[1].removeListener();
	}
}


//--------------------------------------------------------------
void testApp::draw() {
	for(int i=0; i<3; i++) {
		button[0].display();
		button[1].display();
		button[2].display();
	}
	checkbox[0].display();
	checkbox[1].display();
	rMenu.display();
}


//--------------------------------------------------------------
void testApp::exit() {
	
}


//--------------------------------------------------------------
void testApp::keyPressed(int key) {

}


//--------------------------------------------------------------
void testApp::keyReleased(int key) {

}


//--------------------------------------------------------------
void testApp::mouseMoved(int x, int y) {

}


//--------------------------------------------------------------
void testApp::mouseDragged(int x, int y, int button){

}


//--------------------------------------------------------------
void testApp::mousePressed(int x, int y, int button){

}


//--------------------------------------------------------------
void testApp::mouseReleased(int x, int y, int button){

}


//--------------------------------------------------------------
void testApp::windowResized(int w, int h){

}
