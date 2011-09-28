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
	
	
	/**
	 * getInt
	 * get the Integer of a specific row and column.
	 *
	 * @param row
	 *        row number
	 * @param col
	 *        column number
	 * @return integer
	 */
	int wngCSV::getInt(int row, int col) {
		int temp = 0;
		istringstream buffer(data[row][col]);
		buffer >> temp;
		return temp;
	}
	
	
	/**
	 * getFloat
	 * get the Float of a specific row and column.
	 *
	 * @param row
	 *        row number
	 * @param col
	 *        column number
	 * @return float
	 */
	float wngCSV::getFloat(int row, int col) {
		float temp = 0;
		istringstream buffer(data[row][col]);
		buffer >> temp;
		return temp;
	}
	
	
	/**
	 * getString
	 * get the String of a specific row and column.
	 *
	 * @param row
	 *        row number
	 * @param col
	 *        column number
	 * @return float
	 */
	string wngCSV::getString(int row, int col) {
		string temp = data[row][col];
		return temp;
	}
	
	
	/**
	 * getBool
	 * get the Boolean of a specific row and column.
	 *
	 * @param row
	 *        row number
	 * @param col
	 *        column number
	 * @return bool
	 */
	bool wngCSV::getBool(int row, int col) {
		static const string trueString = "true";
		static const string falseString = "false";
		string lower = ofToLower(data[row][col]);
		if(lower == trueString) {
			return true;
		}
		if(lower == falseString) {
			return false;
		}
		bool temp = false;
		istringstream cur(lower);
		cur >> temp;
		return temp;
	}
	
	
	/**
	 * setInt
	 * set a specific Integer to a new value.
	 *
	 * @param row
	 *        row number
	 * @param col
	 *        column number
	 * @param what
	 *        new Integer
	 */
	void wngCSV::setInt(int row, int col, int what) {
		// TODO
		data[row][col] = what;
	}
	
	
	/**
	 * setFloat
	 * set a specific Float to a new value.
	 *
	 * @param row
	 *        row number
	 * @param col
	 *        column number
	 * @param what
	 *        new row Float
	 */
	void wngCSV::setFloat(int row, int col, float what) {
		// TODO
		data[row][col] = what;
	}
	
	
	/**
	 * setString
	 * set a specific String to a new value.
	 *
	 * @param row
	 *        row number
	 * @param col
	 *        column number
	 * @param what
	 *        new row String
	 */
	void wngCSV::setString(int row, int col, string what) {
		// TODO
		data[row][col] = what;
	}
	
	
	/**
	 * setBool
	 * set a specific Boolean to a new value.
	 *
	 * @param row
	 *        row number
	 * @param col
	 *        column number
	 * @param what
	 *        new row Boolean
	 */
	void wngCSV::setBool(int row, int col, bool what) {
		// TODO
		data[row][col] = what;
	}
	

}