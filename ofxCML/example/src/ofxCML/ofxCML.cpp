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
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with ofxCML. If not, see <http://www.gnu.org/licenses/>.
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
 *
 * At first save the Path and load the CML File. Analyse and save Values to the Variables.
 * Set debug Values at all CML Variables like Hardware, Software, Message, Interface and
 * Control. Check the CML File, check 'version', 'url' Attribute and save the Values.
 * Read all Tags and save values to the specific 
 *
 * @param path 
 *        CML File Path
 */
void ofxCML::loadFile(string _path) {
	
	/* Save File Path to the Variable. */
	filePath = _path;
	
	/* Load the CML File. */
	if(XML.loadFile(filePath)) {
		cmlMessage = "CML File " + filePath + " loaded!\n";
	} else {
		cmlMessage = "Unable to Load CML File " + filePath + " check data/ folder\n";
	}
	
	
	
	
	/* Set Debug WNGHEX value. */
	for(int i = 0; i < NUM_HARDWARE; i++) {
		/* <HARDWARE> Tag */
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
		/* <CONTROL> Tag */
		for(int j = 0; j < NUM_CONTROL; j++) {
			getControlName[j][i]     = WNGHEX;
			getControlMidiB1[j][i]   = WNGHEX;
			getControlMidiB2[j][i]   = WNGHEX;
			getControlOscPath[j][i]  = WNGHEX;
			getControlOscStart[j][i] = WNGHEX;
			getControlOscStop[j][i]  = WNGHEX;
		}
	}
	
	
	
	
	/* Check CML File.                    */
	/* Search <CML> Tag inside a File.    */
	/* Check the Version and get the url. */
	int NUM_CML_TAGS = XML.getNumTags(TAG_CML);
	cmlMessage = cmlMessage + "Check the CML File. " + ofToString(NUM_CML_TAGS) + " CML Tag/s found at loaded File\n";
	
	/* If <CML> Tag exist, read... */
	if(NUM_CML_TAGS > 0) {
		
		
		/* Check <CML> Attributes. */
		
		/* Check the 'version' Attribute. Save Value. */
		if(XML.attributeExists(TAG_CML, "version", 0) == 1) {
			cmlVersion = XML.getAttribute(TAG_CML, ATTRIBUTE_VERSION, NOT_AVAILABLE);
			cmlMessage = cmlMessage + "CML Version: " + cmlVersion + "\n";
		}
		
		/* Check the 'url' Attribute. Save Value. */
		if(XML.attributeExists(TAG_CML, "url", 0) == 1) {
			cmlUrl = XML.getAttribute(TAG_CML, ATTRIBUTE_URL, NOT_AVAILABLE);
			cmlMessage = cmlMessage + "CML Url: " + cmlUrl + "\n";
		}
		
		
		
		
		/* Push into <CML> Tag. */
		XML.pushTag(TAG_CML, 0);
		
		
			/* Check <HARDWARE> Tag */
		
			/* Lets see how many <HARDWARE> Tags are inside the CML File. */
			getNumHardware = XML.getNumTags(TAG_HARDWARE);
			cmlMessage = cmlMessage + "Number of Hardware Tags: " + ofToString(getNumHardware) + "\n";
		
			if(getNumHardware > 0) {
				//int numHardwareAttribute = XML.getNumAttributes("HARDWARE", 0);
				//cout << "### CML --> Number of Hardware Attributes: " << numHardwareAttribute <<endl;
				
				
				/* We have only allocated a certan amount of space for our array. */
				/* So we don't want to read more than that amount of points.      */
				int totalHardwareToRead = MIN(getNumHardware, NUM_HARDWARE);
				
				/* Write the values to the correct Variable. */
				for(int i = 0; i < totalHardwareToRead; i++) {
					/* Get the <HARDWARE> Attributes. */
					getHardwareName[i]     = XML.getAttribute(TAG_HARDWARE, ATTRIBUTE_NAME,     NOT_AVAILABLE);
					getHardwarePlatform[i] = XML.getAttribute(TAG_HARDWARE, ATTRIBUTE_PLATFORM, NOT_AVAILABLE);
					getHardwareCompany[i]  = XML.getAttribute(TAG_HARDWARE, ATTRIBUTE_COMPANY,  NOT_AVAILABLE);
					getHardwareModell[i]   = XML.getAttribute(TAG_HARDWARE, ATTRIBUTE_MODELL,   NOT_AVAILABLE);
					getHardwareUrl[i]      = XML.getAttribute(TAG_HARDWARE, ATTRIBUTE_URL,      NOT_AVAILABLE);
					/* Get the >INTERFACE> Attributes. */
					getInterfaceMidiIn[i]     = XML.getAttribute("HARDWARE:INTERFACE", ATTRIBUTE_MIDI_IN,     NOT_AVAILABLE);
					getInterfaceMidiOut[i]    = XML.getAttribute("HARDWARE:INTERFACE", ATTRIBUTE_MIDI_OUT,    NOT_AVAILABLE);
					getInterfaceOscHostIn[i]  = XML.getAttribute("HARDWARE:INTERFACE", ATTRIBUTE_OSC_HOSTIN,  NOT_AVAILABLE);
					getInterfaceOscHostOut[i] = XML.getAttribute("HARDWARE:INTERFACE", ATTRIBUTE_OSC_HOSTOUT, NOT_AVAILABLE);
					getInterfaceOscPortIn[i]  = XML.getAttribute("HARDWARE:INTERFACE", ATTRIBUTE_OSC_PORTIN,  NOT_AVAILABLE);
					getInterfaceOscPortOut[i] = XML.getAttribute("HARDWARE:INTERFACE", ATTRIBUTE_OSC_PORTOUT, NOT_AVAILABLE);
					
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
					
					
					
					
					
					/* Push into <HARDWARE> Tag. */
					XML.pushTag(TAG_HARDWARE, 0);
					
					
					
					
					/* Lets see how many <CONTROL> tags are inside the XML File. */
					getNumControl[i] = XML.getNumTags(TAG_CONTROL);
					cmlMessage = cmlMessage + "Number of Control[" + ofToString(i) + "] Tags: " + ofToString(getNumControl[i]) + "\n";
					
					if(getNumControl[i] > 0) {
						
						//int numHardwareAttribute = XML.getNumAttributes("HARDWARE", 0);
						//cout << "### CML --> Number of Hardware Attributes: " << numHardwareAttribute <<endl;
						
						/* We have only allocated a certan amount of space for our array. */
						/* So we don't want to read more than that amount of points.      */
						int totalControlToRead = MIN(getNumControl[i], NUM_CONTROL);
						cmlMessage = cmlMessage + "Total Control to Read: " + ofToString(totalControlToRead) + "\n";
						
						for(int j = 0; j < totalControlToRead; j++) {
							/* Get the <CONTROL> Attributes. */
							getControlName[j][i]     = XML.getAttribute(TAG_CONTROL, ATTRIBUTE_NAME,         NOT_AVAILABLE, j);
							getControlMidiB0[j][i]   = XML.getAttribute(TAG_CONTROL, ATTRIBUTE_MIDI_BYTE0,   NOT_AVAILABLE, j);
							getControlMidiB1[j][i]   = XML.getAttribute(TAG_CONTROL, ATTRIBUTE_MIDI_BYTE1,   NOT_AVAILABLE, j);
							getControlMidiB2[j][i]   = XML.getAttribute(TAG_CONTROL, ATTRIBUTE_MIDI_BYTE2,   NOT_AVAILABLE, j);
							getControlOscPath[j][i]  = XML.getAttribute(TAG_CONTROL, ATTRIBUTE_OSC_PATH,  "/"+ofToString(NOT_AVAILABLE)+"/", j);
							getControlOscStart[j][i] = XML.getAttribute(TAG_CONTROL, ATTRIBUTE_OSC_START, "0", j);
							getControlOscStop[j][i]  = XML.getAttribute(TAG_CONTROL, ATTRIBUTE_OSC_STOP,  "1", j);
							
							cmlMessage = cmlMessage + "Control[" + ofToString(j) + "][" + ofToString(i) + "] Name: " +      ofToString(getControlName[j][i]) +
													"\nControl[" + ofToString(j) + "][" + ofToString(i) + "] Midi-b1: " +   ofToString(getControlMidiB0[j][i]) +
													"\nControl[" + ofToString(j) + "][" + ofToString(i) + "] Midi-b2: " +   ofToString(getControlMidiB1[j][i]) +
													"\nControl[" + ofToString(j) + "][" + ofToString(i) + "] Midi-b3: " +   ofToString(getControlMidiB2[j][i]) +
													"\nControl[" + ofToString(j) + "][" + ofToString(i) + "] Osc-Path: " +  ofToString(getControlOscPath[j][i]) +
													"\nControl[" + ofToString(j) + "][" + ofToString(i) + "] Osc_Start: " + ofToString(getControlOscStart[j][i]) +
													"\nControl[" + ofToString(j) + "][" + ofToString(i) + "] Osc-Stop: "  + ofToString(getControlOscStop[j][i]) + "\n";
							
						}
						
					}
						
						
					/* Pop <HARDWARE> Tag. */
					XML.popTag();
						
						
						
						
					
				}
				
			}
		
		
		/* Print the full Arrays to Console. Variable check: */
		/* - hardware             1 dimensional Array[]      */
		/* - interface            1 dimensional Array[]      */
		/* - control              2 dimensional Array[][]    */
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
				cout << "### CML --> Control[" << j << "][" << i << "] Midi-b3: "   << control_MidiB2[j][i] << endl;
				cout << "### CML --> Control[" << j << "][" << i << "] Osc-Path: "  << control_OscPath[j][i] << endl;
				cout << "### CML --> Control[" << j << "][" << i << "] Osc_Start: " << control_OscStart[j][i] << endl;
				cout << "### CML --> Control[" << j << "][" << i << "] Osc-Stop: "  << control_OscStop[j][i] << endl;
				cout << "###" << endl;
			}
		}*/
		
		
		

		
		/* Pop Main <CML> Tag. */
		XML.popTag();
		
		
	}
}



















/**
 * ofxCML listHardware
 *
 * List all available <HARDWARE> Tags. 
 */
void ofxCML::listHardware() {
	cout << "### CML HARDWARE LIST" << endl;
	
	XML.pushTag(TAG_CML, 0);
		
		/* Lets see how many <HARDWARE> Tags are inside the CML File. */
		int nHardware = XML.getNumTags(TAG_HARDWARE);
		cout << "### Number of <HARDWARE> Tags: " << ofToString(nHardware) << endl;
	
		if(nHardware > 0) {
			for(int i = 0; i < nHardware; i++) {
				cout << "### Hardware[" << ofToString(i) << "]" << endl;
				cout << "###         name:     " << ofToString(XML.getAttribute(TAG_HARDWARE, ATTRIBUTE_NAME,     NOT_AVAILABLE, i)) << endl;
				cout << "###         platform: " << ofToString(XML.getAttribute(TAG_HARDWARE, ATTRIBUTE_PLATFORM, NOT_AVAILABLE, i)) << endl;
				cout << "###         company:  " << ofToString(XML.getAttribute(TAG_HARDWARE, ATTRIBUTE_COMPANY,  NOT_AVAILABLE, i)) << endl;
				cout << "###         modell:   " << ofToString(XML.getAttribute(TAG_HARDWARE, ATTRIBUTE_MODELL,   NOT_AVAILABLE, i)) << endl;
				cout << "###         url:      " << ofToString(XML.getAttribute(TAG_HARDWARE, ATTRIBUTE_URL,      NOT_AVAILABLE, i)) << endl;
			}
		}
	
	cout << "###" << endl;
	
	XML.popTag();
}

// TODO: add listSoftware method
void ofxCML::listSoftware() {
}
// TODO: add listMessage method
void ofxCML::listMessage() {
}

/**
 * ofxCML listInterface
 *
 * List all available <INTERFACE> Tags.
 *
 * @param _which
 *        Which <HARDWARE> Tag will be selected?
 */
void ofxCML::listInterface(int _which) {
	cout << "### CML INTERFACE LIST" << endl;
	
	XML.pushTag(TAG_CML, 0);
		XML.pushTag(TAG_HARDWARE, _which);
	
			/* Lets see how many <HARDWARE> Tags are inside the CML File. */
			int nInterface = XML.getNumTags(TAG_INTERFACE);
			cout << "### Selected Hardware[" << ofToString(_which) << "]" << endl;
			cout << "### Number of <INTERFACE> Tags: " << ofToString(nInterface) << endl;
	
			if(nInterface > 0) {
				for(int i = 0; i < nInterface; i++) {
					cout << "### Interface[" << ofToString(i) << "]" << endl;
					cout << "###          name:         " << ofToString(XML.getAttribute(TAG_INTERFACE, ATTRIBUTE_NAME,        NOT_AVAILABLE, i)) << endl;
					cout << "###          midi-in:      " << ofToString(XML.getAttribute(TAG_INTERFACE, ATTRIBUTE_MIDI_IN,     NOT_AVAILABLE, i)) << endl;
					cout << "###          midi-out:     " << ofToString(XML.getAttribute(TAG_INTERFACE, ATTRIBUTE_MIDI_OUT,    NOT_AVAILABLE, i)) << endl;
					cout << "###          osc-host-in:  " << ofToString(XML.getAttribute(TAG_INTERFACE, ATTRIBUTE_OSC_HOSTIN,  NOT_AVAILABLE, i)) << endl;
					cout << "###          osc-host-out: " << ofToString(XML.getAttribute(TAG_INTERFACE, ATTRIBUTE_OSC_HOSTOUT, NOT_AVAILABLE, i)) << endl;
					cout << "###          osc-port-in:  " << ofToString(XML.getAttribute(TAG_INTERFACE, ATTRIBUTE_OSC_PORTIN,  NOT_AVAILABLE, i)) << endl;
					cout << "###          osc-port-out: " << ofToString(XML.getAttribute(TAG_INTERFACE, ATTRIBUTE_OSC_PORTOUT, NOT_AVAILABLE, i)) << endl;
				}
			}
		
		XML.popTag();
	XML.popTag();
	
	cout << "###" << endl;
}

/**
 * ofxCML listControl
 *
 * List all available <CONTROL> Tags.
 *
 * @param _which
 *        Which <HARDWARE> Tag will be selected?
 */
void ofxCML::listControl(int _which) {
	cout << "### CML CONTROL LIST" << endl;
	
	XML.pushTag(TAG_CML, 0);
		XML.pushTag(TAG_HARDWARE, _which);
	
			/* Lets see how many <HARDWARE> Tags are inside the CML File. */
			int n = XML.getNumTags(TAG_CONTROL);
			cout << "### Selected Control[" << ofToString(_which) << "]" << endl;
			cout << "### Number of <CONTROL> Tags: " << ofToString(n) << endl;
	
			if(n > 0) {
				for(int i = 0; i < n; i++) {
					cout << "### Control[" << ofToString(i) << "]" << endl;
					cout << "###        name:         " << ofToString(XML.getAttribute(TAG_CONTROL, ATTRIBUTE_NAME,        NOT_AVAILABLE, i)) << endl;
					cout << "###        midi-b0:      " << ofToString(XML.getAttribute(TAG_CONTROL, ATTRIBUTE_MIDI_BYTE0,  NOT_AVAILABLE, i)) << endl;
					cout << "###        midi-b1:      " << ofToString(XML.getAttribute(TAG_CONTROL, ATTRIBUTE_MIDI_BYTE1,  NOT_AVAILABLE, i)) << endl;
					cout << "###        midi-b2:      " << ofToString(XML.getAttribute(TAG_CONTROL, ATTRIBUTE_MIDI_BYTE2,  NOT_AVAILABLE, i)) << endl;
					cout << "###        osc-path      " << ofToString(XML.getAttribute(TAG_CONTROL, ATTRIBUTE_OSC_PATH,    NOT_AVAILABLE, i)) << endl;
					cout << "###        osc-start:    " << ofToString(XML.getAttribute(TAG_CONTROL, ATTRIBUTE_OSC_START,   NOT_AVAILABLE, i)) << endl;
					cout << "###        osc-s:op      " << ofToString(XML.getAttribute(TAG_CONTROL, ATTRIBUTE_OSC_STOP,    NOT_AVAILABLE, i)) << endl;
				}
			}
	
		XML.popTag();
	XML.popTag();
	
	cout << "###" << endl;
}





/**
 * ofxCML addHardware
 *
 * Add a <HARDWARE> Tag to the CML File.
 */
void ofxCML::addHardware(string _name, string _platform, string _company, string _modell, string _url) {
	/* Push into <CML> Tag. */
	if(XML.pushTag(TAG_CML, 0)) {
		/* Add a <HARDWARE> Tag. */
		XML.addTag(TAG_HARDWARE);
		cmlMessage = "Add <"+ofToString(TAG_HARDWARE)+"> Tag\n";
		cout << cmlMessage;
		
		/* Add Attributes to the <HARDWARE> Tag. */
		XML.addAttribute(TAG_HARDWARE, ATTRIBUTE_NAME,     _name,     1);
		XML.addAttribute(TAG_HARDWARE, ATTRIBUTE_PLATFORM, _platform, 1);
		XML.addAttribute(TAG_HARDWARE, ATTRIBUTE_COMPANY,  _company,  1);
		XML.addAttribute(TAG_HARDWARE, ATTRIBUTE_MODELL,   _modell,   1);
		XML.addAttribute(TAG_HARDWARE, ATTRIBUTE_URL,      _url,      1);
		
		/* Pop <CML> Tag. */
		XML.popTag();
	}
}

void ofxCML::addHardware() {
	addHardware(WNGHEX, WNGHEX, WNGHEX, WNGHEX, WNGHEX);
}





/**
 * ofxCML setHardwareName
 */
void ofxCML::setHardwareName(int _n) {
	//XML.setValue("CML:HARDWARE", "WNG_TEST123");
	cmlMessage = "Set Value: \n";
	cout << cmlMessage;
}





/**
 * ofxCML saveFile
 *
 * Save CML File. No data gets saved unless you use this function.
 *
 * @param path 
 *        CML File Path
 */
void ofxCML::saveFile(string _path) {
	filePath = _path;
	XML.saveFile(filePath);
	cmlMessage = "CML saved.\n";
	cout << cmlMessage;
}

void ofxCML::saveFile() {
	saveFile(filePath);
}
