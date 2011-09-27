#include "testApp.h"

//--------------------------------------------------------------
void testApp::setup(){
	// Load a CSV File.
	csv.loadFile(ofToDataPath("file.csv"));
	
	// Check how many rows exist.
	cout << "csv rows: " << csv.rowCount << endl;
	
	// Print out all rows and cols.
	for(int i=0; i<csv.rowCount; i++) {
		for(int j=0; j<csv.data[i].size(); j++) {
			cout << csv.data[i][j] << endl;
		}
	}
	
	// Print out the first value
	cout << csv.data[0].front() << endl;
	
	// Print out a specific CSV value.
	cout << csv.data[0][1] << endl;
	// or
	cout << csv.data[0].at(1) << endl;
	
	// misc...
	cout << csv.data[0].max_size() << endl;
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