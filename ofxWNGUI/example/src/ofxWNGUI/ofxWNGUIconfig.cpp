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


#include "ofxWNGUIconfig.h"


ofxWNGUIconfig::ofxWNGUIconfig(){
	
	// button class
	// color palette for
	BUTTON_ROUNDEDRECT    = 6;
	BUTTON_COLOR          = 0x0033BC;
	BUTTON_COLOR_OVER     = 0x0046FF;
	BUTTON_COLOR_ACTIVE   = 0x0046FF;
	
	// checkbox
	CHECKBOX_SIZE           = 10;
	CHECKBOX_COLOR          = 0x0033BC;
	//CHECKBOX_COLOR_OVER     = 0x0046FF;
	CHECKBOX_COLOR_ACTIVE   = 0x0046FF;
	CHECKBOX_COLOR_FONT     = 0xFFFFFF;
	
	// text
	FONT_COLOR		= 0xFFFFFF;
	
	/* description box
	DESCRIPTION_TIME               = 100;
	DESCRIPTION_ROUNDEDRECT        = 4;
	DESCRIPTION_COLOR_BACKGROUND   = 51;
	DESCRIPTION_ALPHA_BACKGROUND   = 100;
	DESCRIPTION_COLOR_TEXT       = 255;*/
	
	// rightclick menu
	RIGHTCLICKMENU_ROUNDEDRECT        = 6;
	RIGHTCLICKMENU_COLOR_BACKGROUND   = 0x000000;
	RIGHTCLICKMENU_ALPHA_BACKGROUND   = 190;
	RIGHTCLICKMENU_COLOR_TEXT         = 0;
	
	
	
	// old OF default is 96 - but this results in fonts looking
	// larger than in other programs. 
	ofTrueTypeFont::setGlobalDpi(72);
	// now load another font, but with extended parameters:
	// font name, size, anti-aliased, full character set
	font.loadFont("/System/Library/Fonts/LucidaGrande.ttc", 10, false, true);
	font.setLineHeight(12.0f);
	font.setLetterSpacing(1.035f);
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
 *
void ofxWNGUIconfig::displayDescription(string _description, int _descriptionX, int _descriptionY) {
	
	int wi = font.stringWidth(_description);
	int he = font.stringHeight(_description);
	// ground
	ofSetColor(DESCRIPTION_COLOR_BACKGROUND_R, DESCRIPTION_COLOR_BACKGROUND_G, DESCRIPTION_COLOR_BACKGROUND_B, DESCRIPTION_ALPHA_BACKGROUND);
	roundedRect(_descriptionX, _descriptionY, wi+2, he+7, DESCRIPTION_ROUNDEDRECT);
	// text
	ofSetColor(DESCRIPTION_COLOR_TEXT_R, DESCRIPTION_COLOR_TEXT_G, DESCRIPTION_COLOR_TEXT_B);
	font.drawString(_description, _descriptionX+1, _descriptionY+12);
	
}*/
