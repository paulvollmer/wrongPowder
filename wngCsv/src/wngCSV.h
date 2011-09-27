/**
 *
 *  wngCSV is a wrong-entertainment production
 *
 *
 *  Copyright 2011 wrong-entertainment
 *                 <wrongentertainment@yahoo.de>
 *                 <http://wrong-entertainment.com>
 * 
 *  This file is part of wnglibs.
 *
 *  wngCSV is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  wngCSV is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with wngCSV. If not, see <http://www.gnu.org/licenses/>.
 *
 */


#pragma once

#include "ofMain.h"
#include <fstream>


class wngCSV {
	
	public:
		/* Constructor */
		wngCSV();
	
		/* Methods */
		void loadFile(string path, string separator, string comments);
		void loadFile(string path, string separator);
		void loadFile(string path);
	
		/* Variables */
		vector<vector<string> > data;	// Declare a Vector of strings to store Data.
		int rowCount;					// Return the number of rows.
	
};
