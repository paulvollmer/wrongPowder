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


#pragma once

#include "ofMain.h"

namespace wng {
	
	class wngTouchOSC {
	public:
		
		/* Constructor */
		wngTouchOSC();
		//wngTouchOSC(int receive, string id, int send);
		
		
		/* Methods */
		float	accX();
		/*float	accY();
		float	accZ();
		getValue();
		selectPage();
		setLED();
		setLabel();
		setButton();
		setXYpad();
		setFader();
		setRotary();
		*/
		
		
		/* Variables */
		int		portReceive;
		int		portSend;
		string	ip;
		float	accelerometer[3];
		float	accelerometerX;
		float	accelerometerY;
		float	accelerometerZ;
	};
	
};
