/**
 *
 *  ofxWNGUI is a wrong-entertainment production
 *
 *
 *  Copyright 2011 wrong-entertainment
 *                 <wrongentertainment@yahoo.de>
 *                 <http://wrong-entertainment.com>
 * 
 *  This file is part of ofxWNGUI.
 *
 *  ofxWNGUI is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  ofxWNGUI is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with ofxWNGUI. If not, see <http://www.gnu.org/licenses/>.
 *
 */


#pragma once

#include "ofxWNGUIconfig.h"


class ofxWNGUIrightclickMenu : public ofxWNGUIconfig {
	
	public:
		ofxWNGUIrightclickMenu();
	
		void addListener();
		void removeListener();
	
		void init(int _x, int _y, int _w, int _h);
		void update(ofEventArgs &args);
		void display(ofEventArgs &args);
		void exit(ofEventArgs &args);
		void onPress(ofMouseEventArgs &args);
	
		bool status;
	
	
	
	private:
		int x, y, w, h;
	
};
