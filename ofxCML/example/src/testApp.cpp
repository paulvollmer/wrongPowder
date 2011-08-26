/**
 *
 *  ofxCML is a wrong-entertainment production
 *
 *
 *  Copyright 2011 wrong-entertainment
 *                 <wrongentertainment@yahoo.de>
 *                 <http://wrong-entertainment.com>
 * 
 *  This file is part of ofxCml.
 *
 *  ofxCML is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  ofxCML is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with ofxCML. If not, see <http://www.gnu.org/licenses/>.
 *
 */


#include "testApp.h"


//--------------------------------------------------------------
void testApp::setup(){
	
	/* Load and Initialise the CML File. */
	cml.loadFile("cml_example.xml");
	cout << "--- " << cml.cmlMessage << endl;
	
	
	cml.listHardware();
	cml.listInterface(0);
	cml.listInterface(1);
	cml.listControl(0);
	cml.listControl(1);
	
	
	/* Add Hardware Tag */
	cml.addHardware("0x11120119", "0x11120119", "0x11120119", "0x11120119", "0x11120119");
	
	/* Change Attribute Value */
	cml.setHardwareName(1);
	
	cml.saveFile("cml_example_2.xml");
}


//--------------------------------------------------------------
void testApp::update(){

}


//--------------------------------------------------------------
void testApp::draw(){

}


//--------------------------------------------------------------
void testApp::keyPressed(int key){

}


//--------------------------------------------------------------
void testApp::keyReleased(int key){

}


//--------------------------------------------------------------
void testApp::mouseMoved(int x, int y ){

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


//--------------------------------------------------------------
void testApp::gotMessage(ofMessage msg){

}


//--------------------------------------------------------------
void testApp::dragEvent(ofDragInfo dragInfo){ 

}
