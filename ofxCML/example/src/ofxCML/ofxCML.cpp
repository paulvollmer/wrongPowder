/**
 *
 *  ofxCML is a wrong-entertainment production
 *
 *
 *  Copyright 2011 wrong-entertainment
 *                 <wrongentertainment@yahoo.de>
 *                 <http://wrong-entertainment.com>
 * 
 *  This file is part of ofxCML.
 *
 *  ofxCML is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  ofxCML is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with ofxCML.  If not, see <http://www.gnu.org/licenses/>.
 *
 */


#include "ofxCML.h"


/**
 * ofxCML
 */
ofxCML::ofxCML() {
	
}



/**
 * ofxCML loadFile
 * Load CML File. Analyse and save Values to the Variables.
 *
 * @param path 
 *        CML File Path
 */
void ofxCML::loadFile(string path) {
	
	// Load the CML File.
	if(XML.loadFile(path)) {
		cmlMessage = "CML File " + path + " loaded!\n";
		//cout << cmlMessage << endl;
	} else {
		cmlMessage = "Unable to Load CML File " + path + " check data/ folder\n";
		//cout << cmlMessage << endl;
	}
	
	
	
	
	
	// Set Debug wng HEX Code
	for(int i = 0; i < NUM_HARDWARE; i++) {
		// <HARDWARE> Tag
		getHardwareName[i]         = WNGHEX;
		getHardwarePlatform[i]     = WNGHEX;
		getHardwareCompany[i]      = WNGHEX;
		getHardwareModell[i]       = WNGHEX;
		getHardwareUrl[i]          = WNGHEX;
		getInterfaceMidiIn[i]      = WNGHEX;
		getInterfaceMidiOut[i]     = WNGHEX;
		getInterfaceOscHostIn[i]   = WNGHEX;
		getInterfaceOscHostOut[i]  = WNGHEX;
		getInterfaceOscPortIn[i]   = WNGHEX;
		getInterfaceOscPortOut[i]  = WNGHEX;
		// <CONTROL> Tag
		for(int j = 0; j < NUM_CONTROL; j++) {
			getControlName[j][i]     = WNGHEX;
			getControlMidiB1[j][i]   = WNGHEX;
			getControlMidiB2[j][i]   = WNGHEX;
			getControlOscPath[j][i]  = WNGHEX;
			getControlOscStart[j][i] = WNGHEX;
			getControlOscStop[j][i]  = WNGHEX;
		}
	}
	
	
	
	
	
	// Check CML File.
	// Search <CML> Tag inside a File. Check the Version.
	int NUM_CML_TAGS = XML.getNumTags("CML");
	cmlMessage = cmlMessage + "Check the CML File. " + ofToString(NUM_CML_TAGS) + " CML Tag/s found at loaded File";
	//cout << cmlMessage << endl;
	
	// if <CML> Tag exist, read...
	if(NUM_CML_TAGS > 0) {
		
		
		// check <CML> Attributes.
		
		// check the 'version' Attribute. Save Value.
		if(XML.attributeExists("CML", "version", 0) == 1) {
			cmlVersion = XML.getAttribute("CML", "version", "NOT AVAILABLE");
			cmlMessage = cmlMessage + "CML Version: " + cmlVersion + "\n";
			//cout << cmlMessage << endl;
		}
		
		// check the 'url' Attribute. Save Value.
		if(XML.attributeExists("CML", "url", 0) == 1) {
			cmlUrl = XML.getAttribute("CML", "url", "NOT AVAILABLE");
			cmlMessage = cmlMessage + "CML Url: " + cmlUrl + "\n";
			//cout << cmlMessage << endl;
		}
		
		
		
		
		
		
		// Push into <CML> Tag.
		XML.pushTag("CML", 0); // TODO: 0 value!!!!
		
		
			// check <HARDWARE> Tag
		
			// lets see how many <HARDWARE> </HARDWARE> tags are inside the xml File.
			getNumHardware = XML.getNumTags("HARDWARE");
			cmlMessage = cmlMessage + "Number of Hardware Tags: " + ofToString(getNumHardware) + "\n";
			//cout << "### CML --> Number of Hardware Tags: " << getNumHardware << endl;
			//cout << "###################################################################" << endl;
		
			if(getNumHardware > 0) {
				//int numHardwareAttribute = XML.getNumAttributes("HARDWARE", 0);
				//cout << "### CML --> Number of Hardware Attributes: " << numHardwareAttribute <<endl;
				
				
				// we have only allocated a certan amount of space for our array
				// so we don't want to read more than that amount of points
				int totalHardwareToRead = MIN(getNumHardware, NUM_HARDWARE);
				
				// write the values to the Correct Variable.
				for(int i = 0; i < totalHardwareToRead; i++) {
					// get the <HARDWARE> Attributes.
					getHardwareName[i]     = XML.getAttribute("HARDWARE", "name",     "NOT AVAILABLE");
					getHardwarePlatform[i] = XML.getAttribute("HARDWARE", "platform", "NOT AVAILABLE");
					getHardwareCompany[i]  = XML.getAttribute("HARDWARE", "company",  "NOT AVAILABLE");
					getHardwareModell[i]   = XML.getAttribute("HARDWARE", "modell",   "NOT AVAILABLE");
					getHardwareUrl[i]      = XML.getAttribute("HARDWARE", "url",      "NOT AVAILABLE");
					// get the >INTERFACE> Attributes.
					getInterfaceMidiIn[i]     = XML.getAttribute("HARDWARE:INTERFACE", "midi-in",      "NOT AVAILABLE");
					getInterfaceMidiOut[i]    = XML.getAttribute("HARDWARE:INTERFACE", "midi-out",     "NOT AVAILABLE");
					getInterfaceOscHostIn[i]  = XML.getAttribute("HARDWARE:INTERFACE", "osc-host-in",  "NOT AVAILABLE");
					getInterfaceOscHostOut[i] = XML.getAttribute("HARDWARE:INTERFACE", "osc-host-out", "NOT AVAILABLE");
					getInterfaceOscPortIn[i]  = XML.getAttribute("HARDWARE:INTERFACE", "osc-port-in",  "NOT AVAILABLE");
					getInterfaceOscPortOut[i] = XML.getAttribute("HARDWARE:INTERFACE", "osc-port-out", "NOT AVAILABLE");
					
					cmlMessage = cmlMessage + "Hardware["  + ofToString(i) + "] name: "         + ofToString(getHardwareName[i]) +
											"\nHardware["  + ofToString(i) + "] platform: "     + ofToString(getHardwarePlatform[i]) +
											"\nHardware["  + ofToString(i) + "] company: "      + ofToString(getHardwareCompany[i]) +
											"\nHardware["  + ofToString(i) + "] modell: "       + ofToString(getHardwareModell[i]) +
											"\nHardware["  + ofToString(i) + "] url: "          + ofToString(getHardwareUrl[i]) +
											"\nInterface[" + ofToString(i) + "] midi-in: "      + ofToString(getInterfaceMidiIn[i]) +
											"\nInterface[" + ofToString(i) + "] midi-out: "     + ofToString(getInterfaceMidiOut[i]) +
											"\nInterface[" + ofToString(i) + "] osc-host-in: "  + ofToString(getInterfaceOscHostIn[i]) +
											"\nInterface[" + ofToString(i) + "] osc-host-out: " + ofToString(getInterfaceOscHostOut[i]) +
											"\nInterface[" + ofToString(i) + "] osc-port-in: "  + ofToString(getInterfaceOscPortIn[i]) +
											"\nInterface[" + ofToString(i) + "] osc-port-out: " + ofToString(getInterfaceOscPortOut[i]) + "\n";
					
					/*cout << "### CML --> Hardware[" << i << "] name: "     << getHardwareName[i] << endl;
					cout << "### CML --> Hardware[" << i << "] platform: " << getHardwarePlatform[i] << endl;
					cout << "### CML --> Hardware[" << i << "] company: "  << getHardwareCompany[i] << endl;
					cout << "### CML --> Hardware[" << i << "] modell: "   << getHardwareModell[i] << endl;
					cout << "### CML --> Hardware[" << i << "] url: "      << getHardwareUrl[i] << endl;
					cout << "### CML --> Interface[" << i << "] midi-in: "      << getInterfaceMidiIn[i] << endl;
					cout << "### CML --> Interface[" << i << "] midi-out: "     << getInterfaceMidiOut[i] << endl;
					cout << "### CML --> Interface[" << i << "] osc-host-in: "  << getInterfaceOscHostIn[i] << endl;
					cout << "### CML --> Interface[" << i << "] osc-host-out: " << getInterfaceOscHostOut[i] << endl;
					cout << "### CML --> Interface[" << i << "] osc-port-in: "  << getInterfaceOscPortIn[i] << endl;
					cout << "### CML --> Interface[" << i << "] osc-port-out: " << getInterfaceOscPortOut[i] << endl;
					cout << "###################################################################" << endl;*/
					
					
					
					
					
					// Push into <HARDWARE> Tag.
					XML.pushTag("HARDWARE", 0);
					
					
					
					
					
					
					// lets see how many <CONTROL> tags are inside the xml File.
					getNumControl[i] = XML.getNumTags("CONTROL");
					cmlMessage = cmlMessage + "Number of Control[" + ofToString(i) + "] Tags: " + ofToString(getNumControl[i]) + "\n";
					//cout << "### CML --> Number of Control[" << i << "] Tags: " << getNumControl[i] << endl;
					//cout << "###################################################################" << endl;
					
					if(getNumControl[i] > 0) {
						
						//int numHardwareAttribute = XML.getNumAttributes("HARDWARE", 0);
						//cout << "### CML --> Number of Hardware Attributes: " << numHardwareAttribute <<endl;
						
						// we have only allocated a certan amount of space for our array
						// so we don't want to read more than that amount of points
						int totalControlToRead = MIN(getNumControl[i], NUM_CONTROL);
						cmlMessage = cmlMessage + "Total Control to Read" + ofToString(totalControlToRead) + "\n";
						//cout << "### CML --> totalControlToRead" << totalControlToRead << endl;
						
						for(int j = 0; j < totalControlToRead; j++) {
							// get the <CONTROL> Attributes.
							getControlName[j][i]     = XML.getAttribute("CONTROL", "name",      "NOT AVAILABLE", j);
							getControlMidiB0[j][i]   = XML.getAttribute("CONTROL", "midi-b0",   "NOT AVAILABLE", j);
							getControlMidiB1[j][i]   = XML.getAttribute("CONTROL", "midi-b1",   "NOT AVAILABLE", j);
							getControlMidiB2[j][i]   = XML.getAttribute("CONTROL", "midi-b2",   "NOT AVAILABLE", j);
							getControlOscPath[j][i]  = XML.getAttribute("CONTROL", "osc-path",  "/not available/", j);
							getControlOscStart[j][i] = XML.getAttribute("CONTROL", "osc-start", "0", j);
							getControlOscStop[j][i]  = XML.getAttribute("CONTROL", "osc-stop",  "1", j);
							
							cmlMessage = cmlMessage + "Control[" + ofToString(j) + "][" + ofToString(i) + "] Name: " +      ofToString(getControlName[j][i]) +
													"\nControl[" + ofToString(j) + "][" + ofToString(i) + "] Midi-b1: " +   ofToString(getControlMidiB0[j][i]) +
													"\nControl[" + ofToString(j) + "][" + ofToString(i) + "] Midi-b2: " +   ofToString(getControlMidiB1[j][i]) +
													"\nControl[" + ofToString(j) + "][" + ofToString(i) + "] Midi-b3: " +   ofToString(getControlMidiB2[j][i]) +
													"\nControl[" + ofToString(j) + "][" + ofToString(i) + "] Osc-Path: " +  ofToString(getControlOscPath[j][i]) +
													"\nControl[" + ofToString(j) + "][" + ofToString(i) + "] Osc_Start: " + ofToString(getControlOscStart[j][i]) +
													"\nControl[" + ofToString(j) + "][" + ofToString(i) + "] Osc-Stop: "  + ofToString(getControlOscStop[j][i]) + "\n";
							
							/*cout << "### CML --> Control[" << j << "][" << i << "] Name: "      << getControlName[j][i] << endl;
							cout << "### CML --> Control[" << j << "][" << i << "] Midi-b1: "   << getControlMidiB0[j][i] << endl;
							cout << "### CML --> Control[" << j << "][" << i << "] Midi-b2: "   << getControlMidiB1[j][i] << endl;
							cout << "### CML --> Control[" << j << "][" << i << "] Midi-b3: "   << getControlMidiB2[j][i] << endl;
							cout << "### CML --> Control[" << j << "][" << i << "] Osc-Path: "  << getControlOscPath[j][i] << endl;
							cout << "### CML --> Control[" << j << "][" << i << "] Osc_Start: " << getControlOscStart[j][i] << endl;
							cout << "### CML --> Control[" << j << "][" << i << "] Osc-Stop: "  << getControlOscStop[j][i] << endl;
							cout << "###" << endl;*/
						}
						
					}
						
						
					// Pop <HARDWARE> Tag.
					XML.popTag();
						
						
						
						
					
				}
				
			}
		
		
		// Print the full Arrays to Console. Variable check:
		// - hardware             1 dimensional Array[]
		// - interface            1 dimensional Array[]
		// - control              2 dimensional Array[][]
		/*for(int i = 0; i < NUM_HARDWARE; i++) {
			cout << "###" << endl;
			cout << "### CML --> Hardware[" << i << "] name: "     << hardware_Name[i] << endl;
			cout << "### CML --> Hardware[" << i << "] platform: " << hardware_Platform[i] << endl;
			cout << "### CML --> Hardware[" << i << "] company: "  << hardware_Company[i] << endl;
			cout << "### CML --> Hardware[" << i << "] modell: "   << hardware_Modell[i] << endl;
			cout << "### CML --> Hardware[" << i << "] url: "      << hardware_Url[i] << endl;
			cout << "### CML --> Interface[" << i << "] midi-in: "      << interface_MidiIn[i] << endl;
			cout << "### CML --> Interface[" << i << "] midi-out: "     << interface_MidiOut[i] << endl;
			cout << "### CML --> Interface[" << i << "] osc-host-in: "  << interface_OscHostIn[i] << endl;
			cout << "### CML --> Interface[" << i << "] osc-host-out: " << interface_OscHostOut[i] << endl;
			cout << "### CML --> Interface[" << i << "] osc-port-in: "  << interface_OscPortIn[i] << endl;
			cout << "### CML --> Interface[" << i << "] osc-port-out: " << interface_OscPortOut[i] << endl;
			cout << "###" << endl;
			for(int j = 0; j < NUM_CONTROL; j++) {
				cout << "### CML --> Control[" << j << "][" << i << "] Name: "      << control_Name[j][i] << endl;
				cout << "### CML --> Control[" << j << "][" << i << "] Midi-b1: "   << control_MidiB0[j][i] << endl;
				cout << "### CML --> Control[" << j << "][" << i << "] Midi-b2: "   << control_MidiB1[j][i] << endl;
				cout << "### CML --> Control[" << j << "][" << i << "] Midi-b3: "   << control_MidiB2[j][i] << endl;				cout << "### CML --> Control[" << j << "][" << i << "] Osc-Path: "  << control_OscPath[j][i] << endl;
				cout << "### CML --> Control[" << j << "][" << i << "] Osc_Start: " << control_OscStart[j][i] << endl;
				cout << "### CML --> Control[" << j << "][" << i << "] Osc-Stop: "  << control_OscStop[j][i] << endl;
				cout << "###" << endl;
			}
		}*/
		
		
		

		
		// Pop Main CML Tag.
		XML.popTag();
		
		
		
		
	}
}



/**
 * ofxCML saveFile
 * Save CML File.
 */
void ofxCML::saveFile() {
	
}



/**
 * ofxCML saveFile
 * Save CML File.
 *
 * @param path 
 *        CML File Path
 */
void ofxCML::saveFile(string path) {
	
}
