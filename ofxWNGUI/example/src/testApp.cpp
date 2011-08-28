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
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with ofxWNGUI. If not, see <http://www.gnu.org/licenses/>.
 *
 */


#include "testApp.h"


///////////////////////////////////////////////////////////////////////////////////////////////
void testApp::setup(){
	
	// we load our settings file. check if it exist.
	/*if( WNGUI_XML.loadFile("data/wngui_settings.xml") ){
		cout << "wngui_settings.xml loaded!" << endl;
	}else{
		cout << "unable to load wngui_settings.xml check data/ folder" << endl;
	}*/
	//read the colors from XML
	//if the settings file doesn't exist we assigns default values (170, 190, 240)
	//BUTTON_COLOR	= WNGUI_XML.getValue("WNGUI:BUTTON:COLOR", 0x0033BC);
	//cout << BUTTON_COLOR << endl;
	/*red	= XML.getValue("WNGUI:BUTTON:ROUNDEDRECT", 6);
	 red	= XML.getValue("WNGUI:BUTTON:ROUNDEDRECT", 6);
	 red	= XML.getValue("WNGUI:BUTTON:ROUNDEDRECT", 6);
	 red	= XML.getValue("WNGUI:BUTTON:ROUNDEDRECT", 6);
	 red	= XML.getValue("WNGUI:BUTTON:ROUNDEDRECT", 6);
	 */
	
	ofSetFrameRate(60);
	ofBackground(80);
	
	// button
	btn[0].init("TEST", 50, 50, 100, 20);
	btn[0].addListener();
	btn[0].setShortcut('a', true);
	//btn[0].setDescription("Hello World This is a Test\nsecond row\nwrong-entertainment", true);
	
	btn[1].init("WRONG", 50, 80, 100, 20);
	btn[1].addListener();
	
	btn[2].init("HELLO WORLD", 50, 110, 100, 100);
	btn[2].addListener();
	
	// checkbox 1
	checkbox[0].init(200, 50);
	checkbox[0].status = true;
	// checkbox 2
	checkbox[1].init("HELLO WORLD", 200, 65);
	checkbox[1].removeListener();
	
	// rightclick menu
	rMenu.init(0, 0, 100, 100);
	
}


///////////////////////////////////////////////////////////////////////////////////////////////
void testApp::update(){

	if(checkbox[0].status == true){
		checkbox[1].addListener();
	}else{
		checkbox[1].removeListener();
	}
	
}


///////////////////////////////////////////////////////////////////////////////////////////////
void testApp::draw(){

	/*for(int i=0; i<3; i++) {
		btn[0].display();
		btn[1].display();
		btn[2].display();
	}*/
	
	//checkbox[0].display();
	//checkbox[1].display();
	
	//rMenu.display();
	
}


///////////////////////////////////////////////////////////////////////////////////////////////
void testApp::exit() {
	
}


///////////////////////////////////////////////////////////////////////////////////////////////
void testApp::keyPressed(int key){

}


///////////////////////////////////////////////////////////////////////////////////////////////
void testApp::keyReleased(int key){

}


///////////////////////////////////////////////////////////////////////////////////////////////
void testApp::mouseMoved(int x, int y ){

}


///////////////////////////////////////////////////////////////////////////////////////////////
void testApp::mouseDragged(int x, int y, int button){

}


///////////////////////////////////////////////////////////////////////////////////////////////
void testApp::mousePressed(int x, int y, int button){

}


///////////////////////////////////////////////////////////////////////////////////////////////
void testApp::mouseReleased(int x, int y, int button){

}


///////////////////////////////////////////////////////////////////////////////////////////////
void testApp::windowResized(int w, int h){

}


///////////////////////////////////////////////////////////////////////////////////////////////
void testApp::gotMessage(ofMessage msg){

}


///////////////////////////////////////////////////////////////////////////////////////////////
void testApp::dragEvent(ofDragInfo dragInfo){ 

}
