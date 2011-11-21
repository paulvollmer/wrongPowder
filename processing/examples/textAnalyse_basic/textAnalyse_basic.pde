/**
 * textAnalyse_basic
 * by wrongPowder Library.
 *
 * Analyse a text and get totalWords, totalChars,
 * smallestWord, largestWord etc.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.31
 */


import wrongPowder.util.string.*;
Analyse textAnalyse = new Analyse();

String[] text;


void setup() {
  size(400, 400);
  
  // Load a text file and initialize the string array.
  // The init method analyse the input text and save totalWords, totalChars etc.
  text = loadStrings("example.txt");
  textAnalyse.init(text);
  // Print out an analyse list to console.
  textAnalyse.printAnalyse();
  // or get the variables...
  /*println("Number of words: "+textAnalyse.totalWords);
  println("Number of chars: "+textAnalyse.totalChars);
  println("Smallest word: "+textAnalyse.smallestWord);
  println("Largest word: "+textAnalyse.largestWord);
  println("Number of upper case: "+textAnalyse.numUppercaseChars);*/
  
  
  
  // Or analyze a string.
  String testText = "Hello Worls, this is a default text to test.";
  //textAnalyse.printAnalyse(testText);
  println("\ntestText\n"+
          "text                       = "+testText);
  println("getWords                   = "+textAnalyse.getWords(testText));
  println("getChars                   = "+textAnalyse.getChars(testText));
  println("getSmallestWord            = "+textAnalyse.getSmallestWord(testText));
  println("getLargestWord             = "+textAnalyse.getLargestWord(testText));
  println("getNumUppercase            = "+textAnalyse.getNumUppercase(testText));
  println("getNumLowercase            = "+textAnalyse.getNumLowercase(testText));
  println("getNumVowel                = "+textAnalyse.getNumVowel(testText));
  println("getNumUppercaseVowel       = "+textAnalyse.getNumUppercaseVowel(testText));
  println("getNumLowercaseVowel       = "+textAnalyse.getNumLowercaseVowel(testText));
  println("getNumConsonants           = "+textAnalyse.getNumConsonants(testText));
  println("getNumUppercaseConsonants  = "+textAnalyse.getNumUppercaseConsonants(testText));
  println("getNumLowercaseConsonants  = "+textAnalyse.getNumLowercaseConsonants(testText));
  
  println("getNumChar                 = "+textAnalyse.getNumChar(testText, "H"));
  //println("getNumChar (ASCII)         = "+textAnalyse.getNumChar(testText, 67));
  println("getNumCharPair             = "+textAnalyse.getNumCharPair(testText, "te"));
  println("getNumSameWords            = "+textAnalyse.getNumSameWords(testText, "Hello"));
  
  
}
