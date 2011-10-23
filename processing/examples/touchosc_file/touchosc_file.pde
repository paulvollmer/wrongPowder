
import wrongPowder.touchosc.TouchOscFile;

TouchOscFile TOSCFILE = new TouchOscFile();
//XML xml;


void setup() {
  size(400, 400);
  
  // Import a TouchOSC File.
  TOSCFILE.load(dataPath("Untitled 1.touchosc"));
  
  //println("version:     " + TOSCFILE.version());
  //println("mode:        " + TOSCFILE.mode());
  //println("orientation: " + TOSCFILE.orientation());
  
  // list all children of xml
  /*println("\nlistChildren:");
  println(TOSCFILE.xml.listChildren());
  
  
  XML[] childs = TOSCFILE.xml.getChildren();
  println(childs.length);
  
  int numtabpage = 0;
  for(int i=1; i<childs.length; i+=2) {
    // If a child is tabpage
    if(childs[i].getName() == "tabpage") {
      numtabpage++;
    }
  }
  println("\nNumber of TabPages: "+numtabpage);*/
  
  
  
  //println(childz[1].getAttributeCount());
  
  //println("numTabs: " + TOSCFILE.xml.getParent());
  
  // Check all childz and create tabpage XML[]
  //XML[] tabpage = new XML[childz.length];
  /*int numtabpage = 0;
  for(int i=1; i<childs.length; i+=2) {

    // If a child is tabpage
    if(childs[i].getName() == "tabpage") {
      println(childs[i]);
      /*tabpage = childs[i].getChildren();
      
      // if control, create the different types of gui elements.
      if(tabpage[0].getName() == "control") {
        println("control no. < "+i+" >"  );
      }
      else {
        println("NO Control tag");
      }*/
      
      //println(tabpage);
      //numtabpage++;
      
      /*for(int j=0; j<tabpage[1].getAttributeCount(); j++) {
        println(tabpage[j].listAttributes());
        //fill();
      }*/
      
    //}
  //}
  
  
  /*for(int j=0; j<numtabpage; j++) {
    //for(int j=0; j<tabpage[i].getAttributeCount(); j++) {
      println(tabpage[j].listAttributes());
      //fill();
    //}
  }*/
  
  
  
  
  
  
  /*println(xml.getName());
  XML layout = xml.getChild(1);
  
  println(layout.getContent());
  
  println("getChildCount: "+xml.getChildCount());
  */
  //XML layout = xml.getChild(0);
  //println(layout);
  /*
  println("###\n");
  println(layout);
  */
  //println(tosc.file);
}


void draw() {
  background(100);
}
