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
		int BUTTON_COLOR_R;
		int BUTTON_COLOR_G;
		int BUTTON_COLOR_B;
		int BUTTON_COLOR_OVER_R;
		int BUTTON_COLOR_OVER_G;
		int BUTTON_COLOR_OVER_B;
		int BUTTON_COLOR_ACTIVE_R;
		int BUTTON_COLOR_ACTIVE_G;
		int BUTTON_COLOR_ACTIVE_B;
		int BUTTON_ALPHA;
	
		// checkbox
		int CHECKBOX_SIZE;
		int CHECKBOX_COLOR_R;
		int CHECKBOX_COLOR_G;
		int CHECKBOX_COLOR_B;
		//int CHECKBOX_COLOR_OVER_R;
		//int CHECKBOX_COLOR_OVER_G;
		//int CHECKBOX_COLOR_OVER_B;
		int CHECKBOX_COLOR_ACTIVE_R;
		int CHECKBOX_COLOR_ACTIVE_G;
		int CHECKBOX_COLOR_ACTIVE_B;
		int CHECKBOX_ALPHA;

		// text
		int	FONT_COLOR_R;
		int	FONT_COLOR_G;
		int	FONT_COLOR_B;
		
		/* description box
		int DESCRIPTION_TIME;
		int DESCRIPTION_ROUNDEDRECT;
		int DESCRIPTION_COLOR_BACKGROUND_R;
		int DESCRIPTION_COLOR_BACKGROUND_G;
		int DESCRIPTION_COLOR_BACKGROUND_B;
		int DESCRIPTION_ALPHA_BACKGROUND;
		int DESCRIPTION_COLOR_TEXT_R;
		int DESCRIPTION_COLOR_TEXT_G;
		int DESCRIPTION_COLOR_TEXT_B;*/
	
		// rightclick menu
		int RIGHTCLICKMENU_ROUNDEDRECT;
		int RIGHTCLICKMENU_COLOR_BACKGROUND_R;
		int RIGHTCLICKMENU_COLOR_BACKGROUND_G;
		int RIGHTCLICKMENU_COLOR_BACKGROUND_B;
		int RIGHTCLICKMENU_ALPHA_BACKGROUND;
		int RIGHTCLICKMENU_COLOR_TEXT_R;
		int RIGHTCLICKMENU_COLOR_TEXT_G;
		int RIGHTCLICKMENU_COLOR_TEXT_B;
		
};
