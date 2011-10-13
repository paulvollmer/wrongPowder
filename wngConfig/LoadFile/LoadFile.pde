
wngConfig config = new wngConfig(); 


void setup() {
  // Load configuration File.  
  config.load("wngMT", "config.txt");
  int w = int(config.props.getProperty("app.width", ""+200));
  int h = int(config.props.getProperty("app.height", ""+200));
  
  size(w, h);
  this.frame.setResizable(true);
  
  // Get the number of Property Elements.
  println(config.props.size());
  
  // Get a Property list.
  config.props.list(System.out);
  // Or get all Property Names.
  println("-- propertyNames --");
  for(Enumeration e = config.props.propertyNames() ; e.hasMoreElements() ;) {
    println(e.nextElement());
  }
}



void draw() {
}



void keyPressed() {
  config.props.setProperty("app.width", ""+width);
  config.props.setProperty("app.height", ""+height);
  config.store();
  
  println("###");
}
