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
Analyse textAnalyse = new Analyse();

String[] text;


void setup() {
  size(400, 400);
  
  // Load a text file and initialize the string array.
  text = loadStrings("example.txt");
  textAnalyse.init(text);
  println("Number of words: "+textAnalyse.totalWords);
  println("Number of chars: "+textAnalyse.totalChars);
  println("Smallest word: "+textAnalyse.smallestWord);
  println("Largest word: "+textAnalyse.largestWord);
  println("Number of upper case: "+textAnalyse.numUppercaseChars);
  
  //textAnalyse.printAnalyse();
  
  
  println("\nOr analyze a string.");
  String testText = "hello world hello abc 1 AaEeIiOoUuÄäÖöÜü";
  textAnalyse.printAnalyse(testText);
  println("getWords         = "+textAnalyse.getWords(testText));
  println("getChars         = "+textAnalyse.getChars(testText));
  println("getSmallestWord  = "+textAnalyse.getSmallestWord(testText));
  println("getLargestWord   = "+textAnalyse.getLargestWord(testText));
  println("getNumUppercase  = "+textAnalyse.getNumUppercase(testText));
  println("getNumLowercase  = "+textAnalyse.getNumLowercase(testText));
  println("getNumVowel      = "+textAnalyse.getNumVowel(testText));
  println("getNumConsonants = "+textAnalyse.getNumConsonants(testText));
  println("getNumChar       = "+textAnalyse.getNumChar(testText, 'y'));
  println("getNumCharPair   = "+textAnalyse.getNumCharPair(testText, "Aa"));
  println("getNumSameWords  = "+textAnalyse.getNumSameWords(testText, "hello"));
  
  
}
