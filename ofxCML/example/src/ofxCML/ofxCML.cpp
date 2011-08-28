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

ofxCML::ofxCML(string _path) {
	/* Main Method (Private) to Load CML File. */
	XMLloadFile(_path);	
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
	/* Main Method (Private) to Load CML File. */
	XMLloadFile(_path);
	
	
	
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










/***************************************************************
 * List
 ***************************************************************/



/**
 * ofxCML listHardware
 *
 * List all available <HARDWARE> Tags. 
 */
void ofxCML::listHardware() {
	XML.pushTag(TAG_CML, 0);
		string attr[6];
		attr[0] = ATTRIBUTE_ID;
		attr[1] = ATTRIBUTE_NAME;
		attr[2] = ATTRIBUTE_PLATFORM;
		attr[3] = ATTRIBUTE_COMPANY;
		attr[4] = ATTRIBUTE_MODELL;
		attr[5] = ATTRIBUTE_URL;
		XMLlist(TAG_HARDWARE, attr, 6);
	XML.popTag();
}

/**
 * ofxCML listSoftware
 *
 * List all available <SOFTWARE> Tags. 
 */
void ofxCML::listSoftware() {
	XML.pushTag(TAG_CML, 0);
		// TODO: Think about Software Attributes.
		string attr[6];
		attr[0] = ATTRIBUTE_ID;
		attr[1] = ATTRIBUTE_NAME;
		attr[2] = ATTRIBUTE_PLATFORM;
		attr[3] = ATTRIBUTE_COMPANY;
		attr[4] = ATTRIBUTE_MODELL;
		attr[5] = ATTRIBUTE_URL;
		XMLlist(TAG_SOFTWARE, attr, 6);
	XML.popTag();
}

/**
 * ofxCML listMessage
 *
 * List all available <MESSAGE> Tags. 
 */
void ofxCML::listMessage() {
	XML.pushTag(TAG_CML, 0);
		// TODO: Think about Message Attributes.
		string attr[6];
		attr[0] = ATTRIBUTE_ID;
		attr[1] = ATTRIBUTE_NAME;
		attr[2] = ATTRIBUTE_PLATFORM;
		attr[3] = ATTRIBUTE_COMPANY;
		attr[4] = ATTRIBUTE_MODELL;
		attr[5] = ATTRIBUTE_URL;
		XMLlist(TAG_MESSAGE, attr, 6);
	XML.popTag();
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
	cout << "### CML SELECTED HARDWARE[" << ofToString(_which) << "]" << endl;
	
	XML.pushTag(TAG_CML, 0);
		XML.pushTag(TAG_HARDWARE, _which);
			string attr[8];
			attr[0] = ATTRIBUTE_ID;
			attr[1] = ATTRIBUTE_NAME;
			attr[2] = ATTRIBUTE_MIDI_IN;
			attr[3] = ATTRIBUTE_MIDI_OUT;
			attr[4] = ATTRIBUTE_OSC_HOSTIN;
			attr[5] = ATTRIBUTE_OSC_HOSTOUT;
			attr[6] = ATTRIBUTE_OSC_PORTIN;
			attr[7] = ATTRIBUTE_OSC_PORTOUT;
			XMLlist(TAG_INTERFACE, attr, 8);
		XML.popTag();
	XML.popTag();
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
	cout << "### CML SELECTED HARDWARE[" << ofToString(_which) << "]" << endl;
	
	XML.pushTag(TAG_CML, 0);
		XML.pushTag(TAG_HARDWARE, _which);
			string attr[8];
			attr[0] = ATTRIBUTE_ID;
			attr[1] = ATTRIBUTE_NAME;
			attr[2] = ATTRIBUTE_MIDI_BYTE0;
			attr[3] = ATTRIBUTE_MIDI_BYTE1;
			attr[4] = ATTRIBUTE_MIDI_BYTE2;
			attr[5] = ATTRIBUTE_OSC_PATH;
			attr[6] = ATTRIBUTE_OSC_START;
			attr[7] = ATTRIBUTE_OSC_STOP;
			XMLlist(TAG_CONTROL, attr, 8);
		XML.popTag();
	XML.popTag();
}










/***************************************************************
 * Add Tag
 ***************************************************************/



/**
 * ofxCML getId
 *
 * @param _tag
 *        The Tag, that will be read.
 * @param _which
 *        Which Tag will be read.
 */
string ofxCML::getId(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_ID, _which);
}

string ofxCML::getUrl(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_URL, _which);
}

string ofxCML::getName(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_NAME, _which);
}

string ofxCML::getPlatform(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_PLATFORM, _which);
}

string ofxCML::getCompany(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_COMPANY, _which);
}

string ofxCML::getModell(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_MODELL, _which);
}

string ofxCML::getMidiIn(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_MIDI_IN, _which);
}

string ofxCML::getMidiOut(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_MIDI_OUT, _which);
}

string ofxCML::getMidiByte0(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_MIDI_BYTE0, _which);
}

string ofxCML::getMidiByte1(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_MIDI_BYTE1, _which);
}

string ofxCML::getMidiByte2(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_MIDI_BYTE2, _which);
}

string ofxCML::getOscHostIn(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_OSC_HOSTIN, _which);
}

string ofxCML::getOscHostOut(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_OSC_HOSTOUT, _which);
}

string ofxCML::getOscPortIn(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_OSC_PORTIN, _which);
}

string ofxCML::getOscPortOut(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_OSC_PORTOUT, _which);
}

string ofxCML::getOscPath(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_OSC_PATH, _which);
}

string ofxCML::getOscStart(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_OSC_START, _which);
}

string ofxCML::getOscStop(string _tag, int _which) {
	return XMLgetAttribute(_tag, ATTRIBUTE_OSC_STOP, _which);
}





/***************************************************************
 * Save File
 ***************************************************************/



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










/***************************************************************
 * Set Attribute
 ***************************************************************/



/**
 * ofxCML setHardwareName
 */
void ofxCML::setHardwareName(int _n) {
	//XML.setValue("CML:HARDWARE", "WNG_TEST123");
	cmlMessage = "Set Value: \n";
	cout << cmlMessage;
}










/***************************************************************
 * Add Tag
 ***************************************************************/



/**
 * ofxCML addHardware
 *
 * Add a <HARDWARE> Tag to the CML File.
 *
 * @param _id
 *        Set the Ident Number.
 * @param _name
 *        Set <HARDWARE> name attribute
 * @param _platform
 *        Set <HARDWARE> platform attribute
 * @param _company
 *        Set <HARDWARE> company attribute
 * @param _modell
 *        Set <HARDWARE> modell attribute
 * @param _url
 *        Set <HARDWARE> url attribute
 */
void ofxCML::addHardware(string _id, string _name, string _platform, string _company, string _modell, string _url) {
	/* Push into <CML> Tag. */
	if(XML.pushTag(TAG_CML, 0)) {
		
		string attr[6];
		attr[0] = ATTRIBUTE_ID;
		attr[1] = ATTRIBUTE_NAME;
		attr[2] = ATTRIBUTE_PLATFORM;
		attr[3] = ATTRIBUTE_COMPANY;
		attr[4] = ATTRIBUTE_MODELL;
		attr[5] = ATTRIBUTE_URL;
		string attrVal[6];
		attrVal[0] = _id;
		attrVal[1] = _name;
		attrVal[2] = _platform;
		attrVal[3] = _company;
		attrVal[4] = _modell;
		attrVal[5] = _url;
		XMLaddTag(TAG_HARDWARE, attr, attrVal, 6);
		
		/* Pop <CML> Tag. */
		XML.popTag();
	}
}

void ofxCML::addHardware() {
	addHardware(NOT_AVAILABLE, NOT_AVAILABLE, NOT_AVAILABLE, NOT_AVAILABLE, NOT_AVAILABLE, NOT_AVAILABLE);
}

/**
 * ofxCML addSoftware
 *
 * Add a <SOFTWARE> Tag to the CML File.
 *
 * @param _id
 *        Set the Ident Number.
 * @param _name
 *        Set <SOFTWARE> name attribute
 * @param _platform
 *        Set <SOFTWARE> platform attribute
 * @param _company
 *        Set <SOFTWARE> company attribute
 * @param _modell
 *        Set <SOFTWARE> modell attribute
 * @param _url
 *        Set <SOFTWARE> url attribute
 */
void ofxCML::addSoftware(string _id, string _name, string _platform, string _company, string _modell, string _url) {
	/* Push into <CML> Tag. */
	if(XML.pushTag(TAG_CML, 0)) {
		
		// TODO: Think about Software Attributes.
		string attr[6];
		attr[0] = ATTRIBUTE_ID;
		attr[1] = ATTRIBUTE_NAME;
		attr[2] = ATTRIBUTE_PLATFORM;
		attr[3] = ATTRIBUTE_COMPANY;
		attr[4] = ATTRIBUTE_MODELL;
		attr[5] = ATTRIBUTE_URL;
		string attrVal[6];
		attrVal[0] = _id;
		attrVal[1] = _name;
		attrVal[2] = _platform;
		attrVal[3] = _company;
		attrVal[4] = _modell;
		attrVal[5] = _url;
		XMLaddTag(TAG_SOFTWARE, attr, attrVal, 6);
		
		/* Pop <CML> Tag. */
		XML.popTag();
	}
}

void ofxCML::addSoftware() {
	addSoftware(NOT_AVAILABLE, NOT_AVAILABLE, NOT_AVAILABLE, NOT_AVAILABLE, NOT_AVAILABLE, NOT_AVAILABLE);
}

/**
 * ofxCML addMessage
 *
 * Add a <MESSAGE> Tag to the CML File.
 *
 * @param _id
 *        Set the Ident Number.
 * @param _name
 *        Set <MESSAGE> name Attribute.
 * @param _platform
 *        Set <MESSAGE> platform Attribute.
 * @param _company
 *        Set <MESSAGE> company Attribute.
 * @param _modell
 *        Set <MESSAGE> modell Attribute.
 * @param _url
 *        Set <MESSAGE> url Attribute.
 */
void ofxCML::addMessage(string _id, string _name, string _platform, string _company, string _modell, string _url) {
	/* Push into <CML> Tag. */
	if(XML.pushTag(TAG_CML, 0)) {
		
		// TODO: Think about Message Attributes.
		string attr[6];
		attr[0] = ATTRIBUTE_ID;
		attr[1] = ATTRIBUTE_NAME;
		attr[2] = ATTRIBUTE_PLATFORM;
		attr[3] = ATTRIBUTE_COMPANY;
		attr[4] = ATTRIBUTE_MODELL;
		attr[5] = ATTRIBUTE_URL;
		string attrVal[6];
		attrVal[0] = _id;
		attrVal[1] = _name;
		attrVal[2] = _platform;
		attrVal[3] = _company;
		attrVal[4] = _modell;
		attrVal[5] = _url;
		XMLaddTag(TAG_MESSAGE, attr, attrVal, 6);
		
		/* Pop <CML> Tag. */
		XML.popTag();
	}
}

void ofxCML::addMessage() {
	addMessage(NOT_AVAILABLE, NOT_AVAILABLE, NOT_AVAILABLE, NOT_AVAILABLE, NOT_AVAILABLE, NOT_AVAILABLE);
}










/***************************************************************
 * Private Methods
 ***************************************************************/



/**
 * ofxCML XMLloadFile
 *
 * -- Private Method.
 * Main Method to Load XML File. If CML File is loaded,
 * check File and Search <CML> Tag. Get the version, url and save the values.
 * 
 * @param path 
 *        CML File Path
 */
void ofxCML::XMLloadFile(string _path) {
	/* Save File Path to the Variable. */
	/* The filePath Variable will be used for default saveFile Path. */
	filePath = _path;
	
	/* Load the XML File. */
	/* Add loading status to cmlMessage. */
	if(XML.loadFile(filePath)) {
		cmlMessage = "### CML FILE '" + filePath + "' LOADED!\n";
	} else {
		cmlMessage = "### CML UNABLE TO LOAD " + filePath + ". CHECK DATA/ FOLDER!\n";
	}
	
	/* Check CML File. */
	/* Search <CML> Tag inside a File. */
	/* Check the Version and get the url. */
	int NUM_CML_TAGS = XML.getNumTags(TAG_CML);
	cmlMessage = cmlMessage + "### CML CHECK THE FILE. \n" +
	                          "###\t\t Number of <CML> Tags: " + ofToString(NUM_CML_TAGS) + "\n";
	
	/* If <CML> Tag exist, read... */
	if(NUM_CML_TAGS > 0) {
		/* Check <CML> Attributes. */
		/* Check the 'version' Attribute. Save Value. */
		if(XML.attributeExists(TAG_CML, "version", 0) == 1) {
			cmlVersion = XML.getAttribute(TAG_CML, ATTRIBUTE_VERSION, NOT_AVAILABLE);
			cmlMessage = cmlMessage + "###\t\t\tversion: " + cmlVersion + "\n";
		}
		/* Check the 'url' Attribute. Save Value. */
		if(XML.attributeExists(TAG_CML, "url", 0) == 1) {
			cmlUrl = XML.getAttribute(TAG_CML, ATTRIBUTE_URL, NOT_AVAILABLE);
			cmlMessage = cmlMessage + "###\t\t\turl: " + cmlUrl + "\n";
		}
	}
	
	cout << "###" << endl;
}





/**
 * ofxCML XMLlist
 *
 * -- Private Method.
 * List all available <_tag> Tags and the specific Attributes.
 * Print out to Console.
 *
 * @param _tag
 *        Tag/s to List.
 * @param _attribute
 *        Attribute/s to List.
 * @param _numAttribute
 *        Number of attribute/s.
 */
void ofxCML::XMLlist(string _tag, string _attribute[], int _numAttribute) {
	cout << "### CML " << _tag << " LIST" << endl;
	
	/* Lets see how many <_tag> Tags are inside the CML File. */
	int num = XML.getNumTags(_tag);
	
	/* If one or more Tags exist. */
	if(num > 0) {
		cout << "###\t\t Number of <" << _tag << "> Tags: " << ofToString(num) << endl;
		
		/* List all Tags... */
		for(int i = 0; i < num; i++) {
			cout << "###\t\t " << _tag << "[" << ofToString(i) << "]" << endl;
			
			/* ...and all Attributes from the Tag. if one value is not available, set to NOT_AVAILABLE. */
			for(int j = 0; j < _numAttribute; j++) {
				cout << "###\t\t\t" << _attribute[j] << ": " << ofToString(XML.getAttribute(_tag, _attribute[j], NOT_AVAILABLE, i)) << endl;
			}
			
		}
	} else {
		cout << "###\t\t <" << _tag << "> Tag not Available!" << endl;
	}
	
	cout << "###" << endl;
}





/**
 * ofxCML XMLgetAttribute
 *
 * -- Private Method.
 */
string ofxCML::XMLgetAttribute(string _tag, string _attribute, int _which) {
	string name;
	
	XML.pushTag(TAG_CML, 0);
		name = XML.getAttribute(_tag, _attribute, NOT_AVAILABLE, _which);
	XML.popTag();
	
	return name;
}





/**
 * ofxCML XMLaddTag
 *
 * -- Private Method.
 * Add a Tag and specific Attributes to the CML File.
 *
 * @param _tag
 *        Tag/s to Add.
 * @param _attribute
 *        Name of the Attribute.
 * @param _attributeVal
 *        Value of the Attribute.
 * @param _numAttribute
 *        Number of Attributes to add.
 */
void ofxCML::XMLaddTag(string _tag, string _attribute[], string _attributeVal[], int _numAttribute) {
	/* Lets see how many <_tag> Tags are inside the CML File. */
	int num = XML.getNumTags(_tag);
	//cout << "###\t\t Number of <" << _tag << "> Tags: " << ofToString(num) << endl;
	
	/* Add a <_tag> Tag. */
	XML.addTag(_tag);
	cmlMessage = "### CML ADD <" + _tag + "> TAG\n";
	//cout << cmlMessage;
		
	/* Add Attributes to the <_tag> Tag. */
	for(int i=0; i < _numAttribute; i++) {
		XML.addAttribute(_tag, _attribute[i], _attributeVal[i], num);
	}
}