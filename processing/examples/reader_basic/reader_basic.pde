/**
 * reader_basic
 * by wrongPowder Library.
 *
 * Different reader class methods.
 *
 * @author              Paul Vollmer
 * @modified            2011.11.22
 * @processing-version  2.0a1
 */


import wrongPowder.io.Log;
import wrongPowder.io.Reader;

Log log = new Log(this);
Reader read = new Reader(this);


void setup() {
  // Initialize Log file.
  log.init();
  log.info("LOG Initialized");
  
  size(400, 400);
  
  // load a single file from path as string
  //String sourcecode = read.load("https://bitbucket.org/sjl/dotfiles/raw/b5e60ade957d/.ackrc");
  //println("Sourcecode: "+sourcecode);
  
  String[] urls = new String[3];
  urls[0] = "https://bitbucket.org/sjl/dotfiles/raw/b5e60ade957d/.ackrc";//"http://www.incom.org/workspace/1";
  urls[1] = "http://www.incom.org/workspace/1";
  urls[2] = "http://www.incom.org/workspace/2";
  
  String[] sourcecodeArray = new String[urls.length];
  sourcecodeArray = read.load(urls);
  println(sourcecodeArray);
  
}
