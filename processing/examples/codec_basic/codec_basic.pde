/**
 * codec_basic
 * by wrongPowder Library.
 *
 * Encode / decode a string.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.25
 */


import wrongPowder.util.codec.Base64;

Base64 base64 = new Base64();


void setup() {
  // Encode a text String.
  String encoded = base64.encode("hello world", "UTF-8");
  println("String Base64.encode() " + encoded);
  // Decode back to human readable text.
  String decoded = base64.decode(encoded);
  println("String Base64.decode() " + decoded);
  
  // Encode a Integer value to String.
  String i = base64.encode(123, "UTF-8");
  println("\nInteger Base64.encode() " + i);
  // Decode back to human readable text.
  println("Integer Base64.decode() " + base64.decode(i));
  
  String f = base64.encode(123.4567, "UTF-8");
  println("\nFloat Base64.encode() " +  f);
  println("Float Base64.decode() " + base64.decode(f));
}