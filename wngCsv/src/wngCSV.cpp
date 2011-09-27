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


#include "wngCSV.h"


namespace wng {
	
	/**
	 * A Constructor, usually called to initialize and start the class.
	 */
	wngCSV::wngCSV(){
	}


	/**
	 * loadFile
	 *
	 * @param path
	 *        Set the File Path.
	 * @param separator
	 *        Set the Separator to split CSV file.
	 * @param comments
	 *        Set the Comments sign.
	 */
	void wngCSV::loadFile(string path, string separator, string comments){
		// Declare a File Stream.
		ifstream fileIn;
	
		// Open your Text File:
		fileIn.open(path.c_str());
	
		// Check if File is open.
		if(fileIn.is_open()) {
			int lineCount = 0;
			vector<string> rows;
		
			while(fileIn != NULL) {
				string temp;		
				getline(fileIn, temp);
			
				// Skip empty lines.
				if(temp.length() == 0) {
					//cout << "Skip empty line no: " << lineCount << endl;
				}
				// Skip Comment lines.
				else if(temp == comments) {
					//cout << "Skip Comment line no: " << lineCount << endl;
				} else {
					rows.push_back(temp);
				
					// Split row into cols.
					vector<string> cols = ofSplitString(rows[lineCount], ",");
				
					// Write the string to data.
					data.push_back(cols);
				
					// Erase remaining elements.
					cols.erase(cols.begin(), cols.end());
					//cout << "cols: After erasing all elements, vector integers " << (cols.empty() ? "is" : "is not" ) << " empty" << endl;
				
					lineCount++;
				}
			}
		
			// Save the Number of Rows.
			numRows = rows.size();
		
			// Erase remaining elements.
			rows.erase(rows.begin(), rows.end());
			//cout << "rows: After erasing all elements, vector integers " << (rows.empty() ? "is" : "is not" ) << " empty" << endl;
		
			// If File cannot opening, print a message to console.
		} else {
		cout << "Error opening " << path << ".\n";
		}
	}


	void wngCSV::loadFile(string path, string separator) {
		loadFile(path, separator, "#");
	}


	void wngCSV::loadFile(string path) {
		loadFile(path, ",", "#");
	}


	/**
	 * loadFromString
	 *
	 * @param s
	 *        String Input.
	 */
	vector<string> wngCSV::getFromString(string s, string separator) {
		vector<string> cols = ofSplitString(s, separator);
		return cols;
	}
	
	
	vector<string> wngCSV::getFromString(string s) {
		getFromString(s, ",");
	}

}