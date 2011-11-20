/**
 * textAnalyse_basic
 * by wrongPowder Library.
 *
 * Use wrongPowder.util.string package to analyze text.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.31
 */


import wrongPowder.util.string.*;
TextAnalyse textAnalyse = new TextAnalyse();

String[] text;


void setup() {
  size(400, 400);
  
  // Load a text file and initialize the string array.
  text = loadStrings("example.txt");
  //textAnalyse.init(text);
  //textAnalyse.analyse();
  textAnalyse.analyse("hello world abc 1");
  textAnalyse.totalWords();
  
}
