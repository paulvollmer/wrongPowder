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

namespace wng {
	
	class wngCSV {
		public:
	
			/* Constructor */
			wngCSV();
	
	
			/* Methods */
			void	loadFile(string path, string separator, string comments);
			void	loadFile(string path, string separator);
			void	loadFile(string path);
		
			void	saveFile(string path, string separator, string comments);
			void	saveFile(string path, string separator);
			void	saveFile(string path);
			void	saveFile();
			
			void	createFile(string path);
		
			vector<string> getFromString(string s, string separator);
			vector<string> getFromString(string s);
		
			int		getInt(int row, int col);
			float	getFloat(int row, int col);
			string	getString(int row, int col);
			bool	getBool(int row, int col);
		
			void	setInt(int row, int col, int what);
			void	setFloat(int row, int col, float what);
			void	setString(int row, int col, string what);
			void	setBool(int row, int col, bool what);
		
			
			/* Variables */
			string	filePath;				// Save loaded Filepath.
			string	fileSeparator;			// Save loaded File Separator.
			string	fileComments;			// Save loaded File Comments.
			
			vector<vector<string> > data;	// Declare a Vector of strings to store Data.
			
			int		numRows;				// The number of data rows.
			int		numCols;				// Also, empty lines containing only whitespace characters
											// that follow the last non-empty row are not included.
	
	};

};
