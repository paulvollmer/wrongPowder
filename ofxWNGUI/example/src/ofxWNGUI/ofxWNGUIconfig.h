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
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with ofxWNGUI.  If not, see <http://www.gnu.org/licenses/>.
 *
 */



#pragma once

#include "ofMain.h"
#include "ofEvents.h"



class ofxWNGUIconfig {
	
	public:
		ofxWNGUIconfig();
	
		bool overRect(int mx, int my, int x, int y, int w, int h);
		void roundedRect(int x, int y, int w, int h, int rnds);
		//void displayDescription(string _description, int _descriptionX, int _descriptionY);
	
		ofTrueTypeFont	font;
	
		// button
		int BUTTON_ROUNDEDRECT;
		int BUTTON_COLOR;
		int BUTTON_COLOR_OVER;
		int BUTTON_COLOR_ACTIVE;
		int BUTTON_ALPHA;
	
		// checkbox
		int CHECKBOX_SIZE;
		int CHECKBOX_COLOR;
		//int CHECKBOX_COLOR_OVER;
		int CHECKBOX_COLOR_ACTIVE;
		int CHECKBOX_COLOR_FONT;

		// text
		int	FONT_COLOR;
		
		/* description box
		int DESCRIPTION_TIME;
		int DESCRIPTION_ROUNDEDRECT;
		int DESCRIPTION_COLOR_BACKGROUND;
		int DESCRIPTION_ALPHA_BACKGROUND;
		int DESCRIPTION_COLOR_TEXT;*/
	
		// rightclick menu
		int RIGHTCLICKMENU_ROUNDEDRECT;
		int RIGHTCLICKMENU_COLOR_BACKGROUND;
		int RIGHTCLICKMENU_ALPHA_BACKGROUND;
		int RIGHTCLICKMENU_COLOR_TEXT;
		
};
