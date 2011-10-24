
import wrongPowder.touchosc.TouchOscFile;

TouchOscFile TOSCFILE = new TouchOscFile();
//XML xml;


void setup() {
  size(400, 400);
  
  TOSCFILE.load(dataPath("Untitled 1.touchosc"));
  
  println("version:     " + TOSCFILE.version());
  println("mode:        " + TOSCFILE.mode());
  println("orientation: " + TOSCFILE.orientation());
  
  println("numTabs: "+TOSCFILE.xml.getParent());
  
  
  //println(childz[1].getAttributeCount());
  
  // Check all childz and create tabpage XML[]
  XML[] tabpage;
  int numtabpage = 0;
  for(int i=1; i<childz.length; i+=2) {

    // If a child is tabpage
    if(childz[i].getName() == "tabpage") {
      println(childz[i]);
      tabpage = childz[i].getChildren();
      
      // if control, create the different types of gui elements.
      if(tabpage[0].getName() == "control") {
        println("control no. < "+i+" >"  );
      }
      else {
        println("NO Control tag");
      }
      
      println(tabpage);
      numtabpage++;
      
      /*for(int j=0; j<tabpage[1].getAttributeCount(); j++) {
        println(tabpage[j].listAttributes());
        //fill();
      }*/
      
    }
  }
  
  println("\nNumber of TabPages: "+numtabpage);
  
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
