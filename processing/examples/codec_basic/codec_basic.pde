/**
 * codec_basic
 * by wrongPowder Library.
 *
 * Encode / decode a string.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.24
 */


import wrongPowder.util.codec.Base64;

Base64 base64 = new Base64();


void setup() {
  // Encode a text String.
  String encoded = base64.encode("hello world", "UTF-8");
  println("Base64.encode() " + encoded);
  
  // Decode backto human readable text.
  String decoded = base64.decode(encoded);
  println("Base64.decode() " + decoded);
}
