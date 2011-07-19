/**
 *
 *  ofxWNGUI is a wrong-entertainment production
 *
 *
 *  Copyright 2011 wrong-entertainment
 *                 wrongentertainment@yahoo.de
 *                 http://wrong-entertainment.com
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



#include "ofxWNGUIconfig.h"



ofxWNGUIconfig::ofxWNGUIconfig() {
	// now load another font, but with extended parameters:
	// font name, size, anti-aliased, full character set
	font.loadFont("/System/Library/Fonts/LucidaGrande.ttc", 9, true, true);
	
	// button
	BUTTON_COLOR_R        = 255;
	BUTTON_COLOR_G        = 0;
	BUTTON_COLOR_B        = 0;
	BUTTON_COLOR_OVER_R   = 255;
	BUTTON_COLOR_OVER_G   = 255;
	BUTTON_COLOR_OVER_B   = 0;
	BUTTON_COLOR_ACTIVE_R = 0;
	BUTTON_COLOR_ACTIVE_G = 255;
	BUTTON_COLOR_ACTIVE_B = 0;
	BUTTON_ALPHA          = 150;
	
	// checkbox
	CHECKBOX_SIZE           = 10;
	CHECKBOX_COLOR_R        = 255;
	CHECKBOX_COLOR_G        = 0;
	CHECKBOX_COLOR_B        = 0;
	CHECKBOX_COLOR_OVER_R   = 255;
	CHECKBOX_COLOR_OVER_G   = 255;
	CHECKBOX_COLOR_OVER_B   = 0;
	CHECKBOX_COLOR_ACTIVE_R = 0;
	CHECKBOX_COLOR_ACTIVE_G = 255;
	CHECKBOX_COLOR_ACTIVE_B = 0;
	CHECKBOX_ALPHA          = 255;
	
	// text
	TEXT_COLOR_R = 0;
	TEXT_COLOR_G = 0;
	TEXT_COLOR_B = 0;
	
	// description box
	DESCRIPTION_COLOR_BACKGROUND_R = 51;
	DESCRIPTION_COLOR_BACKGROUND_G = 51;
	DESCRIPTION_COLOR_BACKGROUND_B = 51;
	DESCRIPTION_ALPHA_BACKGROUND   = 100;
	DESCRIPTION_COLOR_TEXT_R       = 255;
	DESCRIPTION_COLOR_TEXT_G       = 255;
	DESCRIPTION_COLOR_TEXT_B       = 255;
	DESCRIPTION_TIME               = 100;
	DESCRIPTION_ROUNDEDRECT        = 4;
	
	// rightclick menu
	RIGHTCLICKMENU_COLOR_BACKGROUND_R = 0;
	RIGHTCLICKMENU_COLOR_BACKGROUND_G = 0;
	RIGHTCLICKMENU_COLOR_BACKGROUND_B = 0;
	RIGHTCLICKMENU_ALPHA_BACKGROUND   = 190;
	RIGHTCLICKMENU_COLOR_TEXT_R       = 0;
	RIGHTCLICKMENU_COLOR_TEXT_G       = 0;
	RIGHTCLICKMENU_COLOR_TEXT_B       = 0;
	RIGHTCLICKMENU_ROUNDEDRECT        = 8;
};


/**
 * Check if mouse is over a Rectangle area.
 */
bool ofxWNGUIconfig::overRect(int mx, int my, int x, int y, int w, int h) {
	if(mx > x && my > y && mx < x+w && my < y+h){
		return true;
	} else {
		return false;
	}
}


/**
 * Draw a rounded Rectangle.
 */
void ofxWNGUIconfig::roundedRect(int x, int y, int w, int h, int rnds) {
	ofBeginShape();
    ofVertex(x + rnds, y);
    ofVertex(x + w - rnds, y);
    ofBezierVertex(x + w - rnds, y, x + w, y, x + w, y + rnds);
    ofVertex(x + w, y + rnds);
    ofVertex(x + w, y + h - rnds);
    ofBezierVertex(x + w, y + h - rnds, x + w, y + h, x + w - rnds, y + h);
    ofVertex(x + w - rnds, y + h);
    ofVertex(x + rnds, y + h);        
    ofBezierVertex(x + rnds, y + h, x, y + h, x, y + h - rnds);
    ofVertex(x, y + h - rnds);
    ofVertex(x, y + rnds);
    ofBezierVertex(x, y + rnds, x, y, x + rnds, y);        
	ofEndShape();
}


/**
 * Draw a description pannel.
 */
void ofxWNGUIconfig::displayDescription(string _description, int _descriptionX, int _descriptionY) {
	int wi = font.stringWidth(_description);
	int he = font.stringHeight(_description);
	// ground
	ofSetColor(DESCRIPTION_COLOR_BACKGROUND_R, DESCRIPTION_COLOR_BACKGROUND_G, DESCRIPTION_COLOR_BACKGROUND_B, DESCRIPTION_ALPHA_BACKGROUND);
	roundedRect(_descriptionX, _descriptionY, wi+2, he+7, DESCRIPTION_ROUNDEDRECT);
	// text
	ofSetColor(DESCRIPTION_COLOR_TEXT_R, DESCRIPTION_COLOR_TEXT_G, DESCRIPTION_COLOR_TEXT_B);
	font.drawString(_description, _descriptionX+1, _descriptionY+12);
}
