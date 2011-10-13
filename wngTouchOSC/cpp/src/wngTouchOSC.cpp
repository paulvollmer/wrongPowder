/**
 *
 *  wngTouchOSC is a wrong-entertainment production
 *
 *
 *  Copyright 2011 wrong-entertainment
 *                 <wrongentertainment@yahoo.de>
 *                 <http://wrong-entertainment.com>
 * 
 *  This file is part of wnglibs.
 *
 *  wngTouchOSC is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  wngTouchOSC is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with wngTouchOSC. If not, see <http://www.gnu.org/licenses/>.
 *
 */


#include "wngTouchOSC.h"


namespace wng {
	
	/**
	 * A Constructor, usually called to initialize and start the class.
	 */
	wngTouchOSC::wngTouchOSC(){
	}
	
	/*wngTouchOSC::wngTouchOSC(int receive, string i, int send){
		portReceive = receive;
		ip = i;
		send = portSend;
	}*/
	
	
	/**
	 * Device Accelerometer X value
	 */
	float wngTouchOSC::accX(OscMessage msg) {
		// check accelerator value and get the values
		if(msg.checkAddrPattern("/accxyz") == true) {
			// check if the typetag is the right one.
			if(msg.checkTypetag("fff")) {
				accelerometerX = msg.get(0).floatValue();
			}
		}
		return accelerometerX;
	}
	
	
}
