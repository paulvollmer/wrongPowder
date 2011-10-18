package wrongPowder.Graphics.ShapeMosaic;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PShape;

public class ShapeMosaic {

  private boolean repetition, scale;
  private boolean debug;
  private boolean fillBg;
  private int bgColor;
  private ArrayList<Integer> usedIndexes;
  private PApplet p;
  
  public ShapeMosaic(PApplet p){
	this.p = p;
    fillBg = false;
    repetition = false;
    scale = false;
    debug = false;
    usedIndexes = new ArrayList<Integer>();
  }
  
  public void generatePdf(PShape[] shapes, int nx, int ny, String outputFilename){
    if(shapesExist(shapes) && nx >= 1 && ny >= 1 && !outputFilename.equals("")){
      // Assuming all the shapes have the same size
      p.size((int)(shapes[0].width*nx), (int)(shapes[0].height*ny), p.PDF, outputFilename);  
      if(fillBg){
        p.fill(bgColor);
        p.noStroke();
        p.rect(0, 0, p.width, p.height);
      }
      if(!repetition) generateWithoutRepetition(shapes, nx, ny);
      //else{;}  //TODO
    }
  }
  
  private void generateWithoutRepetition(PShape[] shapes, int nx, int ny){
    dbgout("generateWithoutRepetition() start");
    ArrayList<Integer> usedShapes = new ArrayList<Integer>();    
    for(int x=0; x<nx; x++){
      for(int y=0; y<ny; y++){
        int randomIndex = nextIndex(shapes.length-1);
        if(randomIndex != -1) p.shape(shapes[randomIndex], shapes[randomIndex].width*x, shapes[randomIndex].height*y);
      }
    }
  }
  
  /**
  * Will calculate a random index  between 0 and maxIndex (including)
  * If repetition() was called before, the returned index will be purely random, 
  * indexes can appear multiple times (non-exclusive). 
  * If noRepetition() was called before, every index will only be returned one time (exclusive)
  * @param maxIndex The biggest index to be calculated (including maxIndex)
  * @return The random index. If there was an error -1 is returned
  **/
  private int nextIndex(int maxIndex){
    //Allow indexes to be generated multiple times
    if(repetition) return p.floor(p.random(maxIndex+1));  
    //Repetition - Every index should be unique
    
    //If there are no unused indexes left, return -1
    else if(usedIndexes.size() > maxIndex) return -1;
    //There are unused indexes left, pick one
    else{
      int ind = -1;
      while(ind == -1 || usedIndexes.indexOf(ind) != -1){
        ind = p.floor(p.random(maxIndex+1));
      }
      dbgout("Used Indexes: " + ArrayListToString(usedIndexes));
      dbgout("Generated index: " + ind);
      if(ind != -1) usedIndexes.add(ind);
      return ind;      
    }
  }
  
  /**
  * Makes it easier to handle ArrayLists in a human-readable way
  * @param al The ArrayList to be converted to String
  * Only functional with printable datatypes! I.e. ArrayList<Integer> will work.
  * @return The Generated String, all Objects are comma separated.
  **/
  public String ArrayListToString(ArrayList al){
    String ret = "";
    if(al != null){
      for(int i=0; i<al.size(); i++){
        ret += al.get(i);
        if(i!= al.size()-1) ret += ", ";
      }
    }
    return ret;
  }
    
  private boolean shapesExist(PShape[] shapes){
    boolean ret = true;
     if(shapes == null) ret = false;
     else{
       for(int i=0; i<shapes.length; i++)
          if(shapes[i] == null) ret = false;
     }
     if(!ret){
       System.err.println("There was an error loading the shapes!");
       return false;
     }
    return true;
  }
  
  public void noScale(){scale = false;}
  
  /**
  * Will allow the images to appear multiple times on the output (non-exclusive).
  */ 
  public void repetition(){repetition = true;}
  
  /**
  * Every image will only appear one time on the output (exlusive).
  **/
  public void noRepetition(){
    repetition = false;  
  }
  
  public void dbgout(String s){if(debug) System.out.println(s);}
  
  public void debug(boolean b){debug = b;}
  
  public void background(int c){
    fillBg = true;
    bgColor = c;
  }
}
