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


///////////////////////////////////////////////////////////////////////////////////////////////
void testApp::setup(){
	
	/* Load and Initialise the CML File. */
	cml.loadFile("cml_example.xml");
	cout << cml.cmlMessage << endl;
	
	
	/* List all available Tag/s. */
	cml.listHardware();
	cml.listSoftware();
	cml.listMessage();
	cml.listInterface(0);
	//cml.listInterface(1);
	cml.listControl(0);
	//cml.listControl(1);
	
	
	/* Add Hardware Tag. */
	cml.addHardware("Wng-Hardware", "MAC", "Wrong-Entertainment", "Wrong Controller", "http://www.wrong-entertainment.com");
	
	/* Add Software Tag. */
	cml.addSoftware();
	cml.addSoftware("Wng-Software", "MAC", "Wrong-Entertainment", "Wrong Application", "http://www.wrong-entertainment.com");
	
	/* Add Message Tag. */
	cml.addMessage("OSC-Cloud-Message", "MAC", "Wrong-Entertainment", "osc-cloud", "http://osc-cloud.com");
	
	
	/* Change Attribute Value. */
	cml.setHardwareName(1);
	
	
	/* Save CML File. */
	cml.saveFile("cml_example_2.xml");
}


///////////////////////////////////////////////////////////////////////////////////////////////
void testApp::update(){

}


///////////////////////////////////////////////////////////////////////////////////////////////
void testApp::draw(){

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
