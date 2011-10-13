#include "testApp.h"

//--------------------------------------------------------------
void testApp::setup(){
	// Load a CSV File.
	csv.loadFile(ofToDataPath("file.csv"));
	
	// Check how many rows exist.
	cout << "csv rows: " << csv.numRows << endl;
	// Check how many columnss exist.
	cout << "csv cols: " << csv.numCols << endl;
	
	// Print out all rows and cols.
	for(int i=0; i<csv.numRows; i++) {
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
	
	
	// read a CSV row as simple String.
	vector<string> dataExample = csv.getFromString("0x11120119,100,40,445,23,543,46,24,56,14,964, 12", ",");
	cout << "dataExample[0]" << dataExample[0] << endl;
	// print the hole csv data string to console.
	for(int i=0; i<dataExample.size(); i++) {
		cout << "\tdataExample[" << i << "]: " << dataExample[i] << endl;
	}
	
	// Get a specific value as int, float, string etc.
	cout << "getInt: " << csv.getInt(0, 0) << endl;
	cout << "getFloat: " << csv.getFloat(0, 1) << endl;
	cout << "getString: " << csv.getString(0, 2) << endl;
	cout << "getBool: " << csv.getBool(0, 3) << endl;

    // Get a specific value as int, float, string etc.
	csv.setInt(0, 0, 2305);
	cout << "getInt: " << csv.getInt(0, 0) << endl;
	csv.setFloat(0, 1, 23.666);
	cout << "getFloat: " << csv.getFloat(0, 1) << endl;
	csv.setString(0, 2, "helloworld");
	cout << "getString: " << csv.getString(0, 2) << endl;
	csv.setBool(0, 3, true);
	cout << "getBool: " << csv.getBool(0, 3) << endl;
	
	// Save File.
	csv.saveFile(ofToDataPath("savefile.csv"));
	
	// Create new File.
	csv.createFile(ofToDataPath("createfile.csv"));
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