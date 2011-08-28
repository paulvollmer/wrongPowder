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





#ifndef _OFX_CML
#define _OFX_CML

#include "ofMain.h"
#include "ofxXmlSettings.h"


/* Variables */
#define WNGHEX                  "0x11120119"    /* WNG Debug Code */

/* CML Syntax */
#define TAG_CML                 "CML"           /* Static Tag. Example: <CML></CML> */
#define TAG_HARDWARE            "HARDWARE"      /* Static Tag. Example: <HARDWARE></HARDWARE> */
#define TAG_SOFTWARE            "SOFTWARE"      /* Static Tag. Example: <SOFTWARE></SOFTWARE> */
#define TAG_MESSAGE             "MESSAGE"       /* Static Tag. Example: <MESSAGE></MESSAGE> */
#define TAG_INTERFACE           "INTERFACE"     /* Static Tag. Example: <INTERFACE></INTERFACE> */
#define TAG_CONTROL             "CONTROL"       /* Static Tag. Example: <CONTROL></CONTROL> */

#define ATTRIBUTE_VERSION       "version"       /* Static Attribute. Example: version="1.0" */
#define ATTRIBUTE_ID            "id"            /* Static Attribute. Example: id="" */
#define ATTRIBUTE_URL           "url"           /* Static Attribute. Example: url="" */
#define ATTRIBUTE_NAME          "name"          /* Static Attribute. Example: name="" */
#define ATTRIBUTE_PLATFORM      "platform"      /* Static Attribute. Example: platform="" */
#define ATTRIBUTE_COMPANY       "company"       /* Static Attribute. Example: company="" */
#define ATTRIBUTE_MODELL        "modell"        /* Static Attribute. Example: modell="" */
#define ATTRIBUTE_MIDI_IN       "midi-in"       /* Static Attribute. Example: midi-in="" */
#define ATTRIBUTE_MIDI_OUT      "midi-out"      /* Static Attribute. Example: midi-out="" */
#define ATTRIBUTE_MIDI_BYTE0    "midi-b0"       /* Static Attribute. Example: midi-b0="" */
#define ATTRIBUTE_MIDI_BYTE1    "midi-b1"       /* Static Attribute. Example: midi-b1="" */
#define ATTRIBUTE_MIDI_BYTE2    "midi-b2"       /* Static Attribute. Example: midi-b2="" */
#define ATTRIBUTE_OSC_HOSTIN    "osc-host-in"   /* Static Attribute. Example: osc-host-in="" */
#define ATTRIBUTE_OSC_HOSTOUT   "osc-host-out"  /* Static Attribute. Example: osc-host-out="" */
#define ATTRIBUTE_OSC_PORTIN    "osc-port-in"   /* Static Attribute. Example: osc-port-in="" */
#define ATTRIBUTE_OSC_PORTOUT   "osc-port-out"  /* Static Attribute. Example: osc-port-out="" */
#define ATTRIBUTE_OSC_PATH      "osc-path"      /* Static Attribute. Example: osc-path="" */
#define ATTRIBUTE_OSC_START     "osc-start"     /* Static Attribute. Example: osc-start="" */
#define ATTRIBUTE_OSC_STOP      "osc-stop"      /* Static Attribute. Example: osc-stop="" */

#define NOT_AVAILABLE           "Not Available" /* Static Attribute. */

/* ofxCML Variables */
#define NUM_HARDWARE            5               /* Total Number of readable <HARDWARE> Tags. */
#define NUM_CONTROL             100             /* Total Number of readable <CONTROL> Tags. */





class ofxCML {
	
	public:
		/* Constructor */
		ofxCML();
		ofxCML(string _path);
	
	
		/* Methods */
		void loadFile(string _path);            /* Load */
	
		void listHardware();                    /* List Hardware, Software, Interface, Control etc.*/
		void listSoftware();
		void listMessage();
		void listInterface(int _which);
		void listControl(int _which);
	
		void saveFile();                        /* Save */
		void saveFile(string _path);
	
		void setHardwareName(int _n);
	
		void addHardware();
		void addHardware(string _name, string _platform, string _company, string _modell, string _url);
	
	
	
		/* Variables */
		string filePath;                                        /* Path of the loaded CML File. */
	
		string cmlMessage;                                      /* write messages to this Variable like a Console. */
	
		string cmlVersion;                                      /* <CML> Attrinute: version="" */
		string cmlUrl;                                          /* <CML> Attrinute: url="" */
	
		int    getNumHardware;                                  /* Total Number of <HARDWARE> Tags. */
		string getHardwareName[NUM_HARDWARE];                   /* <HARDWARE> Attribute: name="" */
		string getHardwarePlatform[NUM_HARDWARE];               /* <HARDWARE> Attribute: platform="" */
		string getHardwareCompany[NUM_HARDWARE];                /* <HARDWARE> Attribute: company="" */
		string getHardwareModell[NUM_HARDWARE];                 /* <HARDWARE> Attribute: modell="" */
		string getHardwareUrl[NUM_HARDWARE];                    /* <HARDWARE> Attribute: url="" */
		string getInterfaceMidiIn[NUM_HARDWARE];                /* <INTERFACE> Attribute: midi-in="" */
		string getInterfaceMidiOut[NUM_HARDWARE];               /* <INTERFACE> Attribute: midi-out="" */
		string getInterfaceOscHostIn[NUM_HARDWARE];             /* <INTERFACE> Attribute: osc-host-in="" */
		string getInterfaceOscHostOut[NUM_HARDWARE];            /* <INTERFACE> Attribute: osc-host-out="" */
		string getInterfaceOscPortIn[NUM_HARDWARE];             /* <INTERFACE> Attribute: osc-pott-in="" */
		string getInterfaceOscPortOut[NUM_HARDWARE];            /* <INTERFACE> Attribute: osc-pott-put="" */
	
		int    getNumControl[NUM_HARDWARE];                     /* Total Number of <HARDWARE> Tags. */
		string getControlName[NUM_CONTROL][NUM_HARDWARE];       /* <CONTROL> Attribute: name="" */
		string getControlMidiB0[NUM_CONTROL][NUM_HARDWARE];     /* <CONTROL> Attribute: midi-b0="" */
		string getControlMidiB1[NUM_CONTROL][NUM_HARDWARE];     /* <CONTROL> Attribute: midi-b1="" */
		string getControlMidiB2[NUM_CONTROL][NUM_HARDWARE];     /* <CONTROL> Attribute: midi-b2="" */
		string getControlOscPath[NUM_CONTROL][NUM_HARDWARE];    /* <CONTROL> Attribute: osc-path="" */
		string getControlOscStart[NUM_CONTROL][NUM_HARDWARE];   /* <CONTROL> Attribute: osc-start="" */
		string getControlOscStop[NUM_CONTROL][NUM_HARDWARE];    /* <CONTROL> Attribute: osc-stop="" */
	
	
	
	private:
		ofxXmlSettings XML;                                     /* Initialize XML addon */
		void           XMLloadFile(string _path);
		void           XMLlist(string _tag, string _attribute[], int _numAttribute);
		
};

#endif
