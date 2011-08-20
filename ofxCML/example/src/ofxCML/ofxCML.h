/**
 *
 *  ofxCML is a wrong-entertainment production
 *
 *
 *  Copyright 2011 wrong-entertainment
 *                 wrongentertainment@yahoo.de
 *                 http://wrong-entertainment.com
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
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with ofxCML.  If not, see <http://www.gnu.org/licenses/>.
 *
 */


#ifndef _OFX_CML
#define _OFX_CML

#define NUM_HARDWARE	5
#define NUM_CONTROL		100

#include "ofMain.h"
#include "ofxXmlSettings.h"


class ofxCML {
	
	public:
		// Constructor
		ofxCML();
	
		// Function
		void loadFile(string path);
		
		// Variables
		string cmlVersion;										// CML Attrinute: version=""
		string cmlUrl;											// CML Attrinute: url=""
		int	   getNumHardware;
		string getHardwareName[NUM_HARDWARE];					// HARDWARE Attribute: name=""
		string getHardwarePlatform[NUM_HARDWARE];				// HARDWARE Attribute: platform=""
		string getHardwareCompany[NUM_HARDWARE];				// HARDWARE Attribute: company=""
		string getHardwareModell[NUM_HARDWARE];					// HARDWARE Attribute: modell=""
		string getHardwareUrl[NUM_HARDWARE];					// HARDWARE Attribute: url=""
		string getInterfaceMidiIn[NUM_HARDWARE];				// INTERFACE Attribute: midi-in=""
		string getInterfaceMidiOut[NUM_HARDWARE];				// INTERFACE Attribute: midi-out=""
		string getInterfaceOscHostIn[NUM_HARDWARE];				// INTERFACE Attribute: osc-host-in=""
		string getInterfaceOscHostOut[NUM_HARDWARE];			// INTERFACE Attribute: osc-host-out=""
		string getInterfaceOscPortIn[NUM_HARDWARE];				// INTERFACE Attribute: osc-pott-in=""
		string getInterfaceOscPortOut[NUM_HARDWARE];			// INTERFACE Attribute: osc-pott-put=""
		int	   getNumControl[NUM_HARDWARE];
		string getControlName[NUM_CONTROL][NUM_HARDWARE];		// CONTROL Attribute: name=""
		string getControlMidiB0[NUM_CONTROL][NUM_HARDWARE];		// CONTROL Attribute: midi-b0=""
		string getControlMidiB1[NUM_CONTROL][NUM_HARDWARE];		// CONTROL Attribute: midi-b1name=""
		string getControlMidiB2[NUM_CONTROL][NUM_HARDWARE];		// CONTROL Attribute: midi-b2name=""
		string getControlOscPath[NUM_CONTROL][NUM_HARDWARE];	// CONTROL Attribute: osc-path=""
		string getControlOscStart[NUM_CONTROL][NUM_HARDWARE];	// CONTROL Attribute: osc-start=""
		string getControlOscStop[NUM_CONTROL][NUM_HARDWARE];	// CONTROL Attribute: osc-stop=""
	
		
		string cmlMessage;										// Load, Read and write messages to this Variable
	
	
	private:
		ofxXmlSettings XML;										// initialize XML addon
		
};

#endif
