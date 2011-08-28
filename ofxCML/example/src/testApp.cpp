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
	cml.addHardware("1", "Wng-Hardware", "MAC", "Wrong-Entertainment", "Wrong Controller", "http://www.wrong-entertainment.com");
	
	/* Add Software Tag. */
	cml.addSoftware();
	cml.addSoftware("2", "Wng-Software", "MAC", "Wrong-Entertainment", "Wrong Application", "http://www.wrong-entertainment.com");
	
	/* Add Message Tag. */
	cml.addMessage("3", "OSC-Cloud-Message", "MAC", "Wrong-Entertainment", "osc-cloud", "http://osc-cloud.com");
	
	
	/* Change Attribute Value. */
	cml.setHardwareName(1);
	
	
	/* Test getAttribute Method. */
	cout << "--- WNGTEST: " << cml.getId("HARDWARE", 0) << endl;
	cout << "--- WNGTEST: " << cml.getName("HARDWARE", 0) << endl;
	cout << "--- WNGTEST: " << cml.getPlatform("HARDWARE", 0) << endl;
	cout << "--- WNGTEST: " << cml.getCompany("HARDWARE", 0) << endl;
	cout << "--- WNGTEST: " << cml.getModell("HARDWARE", 0) << endl;
	cout << "--- WNGTEST: " << cml.getUrl("HARDWARE", 0) << endl;
	
	cout << "--- WNGTEST: " << cml.getId("HARDWARE:INTERFACE", 0) << endl;
	cout << "--- WNGTEST: " << cml.getName("HARDWARE:INTERFACE", 0) << endl;
	cout << "--- WNGTEST: " << cml.getMidiIn("HARDWARE:INTERFACE", 0) << endl;
	cout << "--- WNGTEST: " << cml.getMidiOut("HARDWARE:INTERFACE", 0) << endl;
	cout << "--- WNGTEST: " << cml.getOscHostIn("HARDWARE:INTERFACE", 0) << endl;
	cout << "--- WNGTEST: " << cml.getOscHostOut("HARDWARE:INTERFACE", 0) << endl;
	cout << "--- WNGTEST: " << cml.getOscPortIn("HARDWARE:INTERFACE", 0) << endl;
	cout << "--- WNGTEST: " << cml.getOscPortOut("HARDWARE:INTERFACE", 0) << endl;
	
	cout << "--- WNGTEST: " << cml.getId("HARDWARE:CONTROL", 0) << endl;
	cout << "--- WNGTEST: " << cml.getName("HARDWARE:CONTROL", 0) << endl;
	cout << "--- WNGTEST: " << cml.getMidiByte0("HARDWARE:CONTROL", 0) << endl;
	cout << "--- WNGTEST: " << cml.getMidiByte1("HARDWARE:CONTROL", 0) << endl;
	cout << "--- WNGTEST: " << cml.getMidiByte2("HARDWARE:CONTROL", 0) << endl;
	cout << "--- WNGTEST: " << cml.getOscPath("HARDWARE:CONTROL", 0) << endl;
	cout << "--- WNGTEST: " << cml.getOscStart("HARDWARE:CONTROL", 0) << endl;
	cout << "--- WNGTEST: " << cml.getOscStop("HARDWARE:CONTROL", 0) << endl;
	
	
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
