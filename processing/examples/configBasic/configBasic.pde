import wrongPowder.config.*;

config conf = new config();


void setup() {
  // Load configuration File.  
  conf.load("wngMT", "config.txt");
  //config.loadStatic("/Users/wrongMacBookpro/Library/Application Support/wngMT/config.txt");
  int w = conf.getIntProperty("app.width", 200);
  int h = conf.getIntProperty("app.height", 200);

  size(w, h);
  //this.frame.setResizable(true);
  
  // Get the number of Property Elements.
  println(conf.getSize());
  
  // Get a Property list.
  conf.list();
}


public void draw() {

}


public void keyPressed() {
  conf.setProperty("app.width", width);
  conf.setProperty("app.height", height);
  conf.store();
}