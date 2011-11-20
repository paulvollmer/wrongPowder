/**
 * textAnalyse_basic
 * by wrongPowder Library.
 *
 * Use wrongPowder.util.string package to analyze text.
 *
 * @author    Paul Vollmer
 * @modified  2011.10.31
 */


//import wrongPowder.util.string.TextAnalyse;

//TextAnalyse textAnalyse = new TextAnalyse();


void setup() {
  size(400, 400);
}


void draw() {
}


void keyPressed() {
  char letter = char(key);
  println("KEY\t[ ASCII DEC: "+(int)key+
          " Unicode: "+(int)key+
          " char: "+ letter +
          " end ]");
}
