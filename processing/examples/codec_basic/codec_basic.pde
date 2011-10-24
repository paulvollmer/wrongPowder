/**
 * codec_basic
 * by wrongPowder Library.
 *
 * Encode / decode a string.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.24
 */


import wrongPowder.util.codec.BASE64;

BASE64 base64 = new BASE64();


void setup() {
  String encoded;
 encoded = base64.encode("helloworld", "UTF-8");
  println("BASE64.encode() " + encoded);
}
