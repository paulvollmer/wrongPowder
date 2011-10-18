/**
 *  wrongPowder.fxg is developed by wrong-entertainment & powder
 *
 *
 *  Copyright 2011 Paul Vollmer
 *  paulvollmer.net
 *  vollmerpaul@yahoo.de
 * 
 *  This file is part of wrongPowder library.
 *
 *  wrongPowder.fxg is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with wrongPowder.fxg. If not, see <http://www.gnu.org/licenses/>.
 * 
 *  @author		##author##
 *  @modified	##date##
 *  @version	##version##
 */

package wrongPowder.fxg;

import java.io.*;

import processing.core.PApplet;
import processing.core.PImage;


/**
 * @example manyFXGs
 * @author Paul Vollmer, http://www.wrong-entertainment.com
 */
public class Fxg implements FxgConstants {
  
  private PApplet p5;
  
  File file;
  PrintWriter writer;
  
  
  
  // counter/name
  static int PAGE_COUNT = 1;
  static int LAYER_COUNT = 1;
  static int ID_COUNT = 1;
  static String PAGE_NAME = "Page ";
  static String LAYER_NAME = "Layer ";
  // format
  static float WIDTH;
  static float HEIGHT;

  // transform
  static boolean TRANSFORM = false; // check push/popMatrix
  static float TRANSLATE_X = 0; // translate
  static float TRANSLATE_Y = 0; // translate
  static float TRANSLATE_X_SAVER = 0; // translate for push/popMatrix
  static float TRANSLATE_Y_SAVER = 0; // translate for push/popMatrix
  static float ROTATE = 0;
  static float SCALE = 1;
  
  // fill
  static boolean FILL_SOLID_COLOR = true;
  static String  FILL_SOLID_COLOR_VALUE = "FFFFFF";
  static float   FILL_COLOR_ALPHA_VALUE = 1.0f;
  // stroke
  static boolean STROKE_SOLID_COLOR = true;
  static String STROKE_SOLID_COLOR_VALUE = "000000";
  // strokeWeight
  static float STROKE_WEIGHT_VALUE = 1;
  static String STROKE_CAPS = "none";
  static String STROKE_JOINTS = "round";
  static float STROKE_MITER = 10;
  
  // shape
  String LABLENAME = "lablename";
  static int ELLIPSEMODE = 3;
  static int RECTMODE = 0;
  // VERTEX
  static int VERTEX_COUNT = 0;
  static float VERTEX_START_X = 0;
  static float VERTEX_START_Y = 0;

  // Adobe Illustrator Blend Mode
  static String BLENDMODE = "normal";
  
  // Adobe Illustrator Filter DROP_SHADOW_FILTER
  static boolean DROP_SHADOW_FILTER_checker = false;
  static int     DROP_SHADOW_FILTER_blurX;
  static int     DROP_SHADOW_FILTER_blurY;
  static int     DROP_SHADOW_FILTER_color;
  static float   DROP_SHADOW_FILTER_alpha;
  static float   DROP_SHADOW_FILTER_angle = 45;
  static float   DROP_SHADOW_FILTER_distance = 10;
  // Adobe Illustrator Filter glowInnerFilter
  static boolean GLOW_INNER_FILTER_checker = false;
  static int     GLOW_INNER_FILTER_blurX;
  static int     GLOW_INNER_FILTER_blurY;
  static int     GLOW_INNER_FILTER_color;
  static float   GLOW_INNER_FILTER_alpha;
  // Adobe Illustrator Filter glowOuterFilter
  static boolean GLOW_OUTER_FILTER_checker = false;
  static int     GLOW_OUTER_FILTER_blurX;
  static int     GLOW_OUTER_FILTER_blurY;
  static int     GLOW_OUTER_FILTER_color;
  static float   GLOW_OUTER_FILTER_alpha;
  
  // Adobe Illustrator gradient
  static boolean LINEAR_GRADIENT_FILL = false;
  static float[] LINEAR_GRADIENT_RATIO;
  static int[]   LINEAR_GRADIENT_COLOR;
  static boolean RADIAL_GRADIENT_FILL = false;
  static float[] RADIAL_GRADIENT_RATIO;
  static int[]   RADIAL_GRADIENT_COLOR;
  
  
  
  
  
  /**
   * a Constructor, usually called in the setup() method in your sketch to
   * initialize and start the Library.
   * 
   * @example wrongAgent
   * @param theParent
   */
  public Fxg(PApplet parent) {
    this.p5 = parent;
    // welcome console line
    System.out.println("### "+LIBRARYNAME+" library "+VERSION+
                     "\n### "+LIBRARYNAME+" is a library "+AUTHOR+"\n");
  }
  
  
  /**
   * Return the Name of the Library.
   * 
   * @return String
   */
  public static String libraryname() {
    return LIBRARYNAME;
  }

  /**
   * Return the Version of the Library.
   * 
   * @return String
   */
  public static String version() {
    return VERSION;
  }

  /**
   * Return the Author of the Library.
   * 
   * @return String
   */
  public static String author() {
    return AUTHOR;
  }

  /**
   * Return Information of the Library.
   * 
   * @return String
   */
  public static String info() {
    return INFO;
  }
  
  
  
  
  
  // CREATE FXG //////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * beginDraw create a FXG File.
   * 
   * @param  filename
   *         String
   * @param  width
   *         float
   * @param  height
   *         float
   */
  public void beginDraw(String filename, float width, float height) {
    // Set Start Values
    PAGE_COUNT = 1;
    LAYER_COUNT = 1;
    ID_COUNT = 1;
    PAGE_NAME = "Page ";
    LAYER_NAME = "Layer ";
    
    String path = p5.sketchPath(filename);
    if (path != null) {
      file = new File(path);
      if (!file.isAbsolute()) file = null;
    }
    if (file == null) {
      throw new RuntimeException("### "+LIBRARYNAME+" Error! createFXG requires an absolute path for the location of the output file.");
    }
    
    // have to create file object here.
    if (writer == null) {
      try {
        writer = new PrintWriter(new FileWriter(file));
      }
      catch (IOException e) {
        throw new RuntimeException(e); // java 1.4+
      }
      
      // write
      writer.println(FXG_HEADER);
      writer.println("<Graphic version=\"2.0\" viewHeight=\""+height+"\" viewWidth=\""+width+FXG_ADOBE_HEADER);  
      writer.println("<Library/>");
      beginPage(width, height);
      
      WIDTH = width;
      HEIGHT = height;
    }
    
  }
  
  
  /**
   * endDraw close the FXG File writer.
   */
  public void endDraw() {
    // if 1 page and 1 layer
    if(PAGE_COUNT == 2 && LAYER_COUNT == 2) endPage();
    // if 1 page and more layer
    if(PAGE_COUNT == 2 && LAYER_COUNT >= 3) endLayer();
    
    writer.println("<Private/>");
    writer.println("</Graphic>");
    System.out.println("### "+LIBRARYNAME+" File writing Ready!");
    
    // finish writer
    writer.flush();
    writer.close();
    writer = null;
  }
  
  
  
  
  
  // ADOBE ILLUSTRATOR LAYER /////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////
  
  /**
   * Begin a new Layer.
   */
  public void beginLayer() {
    beginLayer(LAYER_NAME + LAYER_COUNT);
  }
  
  /**
   * Begin a new Layer.
   *
   * @param  layerName
   *         set the name of the Layer
   */
  public void beginLayer(String layerName) {
    if(LAYER_COUNT == 2) writer.println("</Group>");
    writer.println("<Group blendMode=\"normal\" ai:seqID=\""+ID_COUNT+"\" d:type=\"layer\" d:userLabel=\""+layerName+"\">");
    LAYER_NAME = "Layer ";
    
    LAYER_COUNT++;
    ID_COUNT++;
  }
  
  /**
   * End Layer.
   */
  public void endLayer() {
    writer.println("</Group>");
  }
  
  /**
   * Set the name of the Layer.
   *
   * @param  layerName
   *         set the name of the Layer
   */
  public void setLayerName(String layerName) {
    LAYER_NAME = layerName;
  }
  
  
  
  
  
  // ADOBE ILLUSTRATOR PAGE //////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////
  
  /**
   * add a new Page to the FXG File.
   * The Page name is the default name + Pagenumber
   * The width and height is the same as the previous page.
   */
  public void beginPage() {
    beginPage(PAGE_NAME+PAGE_COUNT, WIDTH, HEIGHT);
  }
  
  /**
   * add a new Page to the FXG File.
   * The Page name is the default name + Pagenumber
   *
   * @param  width
   *         set the width of Page
   * @param  height
   *         set the height of Page
   */
  public void beginPage(float width, float height) {
    beginPage(PAGE_NAME+PAGE_COUNT, width, height);
  }
  
  /**
   * add a new Page with new size to the FXG File.
   *
   * @param  pageName
   *         set the name of Page
   * @param  width
   *         set the width of Page
   * @param  height
   *         set the height of Page
   */
  public void beginPage(String pageName, float width, float height) {
    if(PAGE_COUNT < 100) {
      if(PAGE_COUNT > 2) endLayer();
      writer.println("<Group blendMode=\"layer\" ai:seqID=\""+ID_COUNT+
                        "\" d:layerType=\"page\" d:pageHeight=\""+height+
                                             "\" d:pageWidth=\""+width+
                                             "\" d:type=\"layer\" d:userLabel=\""+pageName+"\">");
      PAGE_NAME = "Page ";
      PAGE_COUNT++;
      ID_COUNT++;
      
      writer.println("<Group blendMode=\"normal\" ai:seqID=\""+ID_COUNT+"\" d:type=\"layer\" d:userLabel=\""+pageName+"\">");
      LAYER_NAME = "Layer "+LAYER_COUNT;
      LAYER_COUNT++;
      ID_COUNT++;
    } else {
      throw new RuntimeException("### "+LIBRARYNAME+"Error! Cannot draw more than 100 Pages to FXG Format.");
    }
  }
  
  /**
   * endPage
   */
  public void endPage() {
    endLayer();
    writer.println("</Group>");
  }
  
  /**
   * Set the name of the Page.
   *
   * @param  pageName
   *         set the name of the Page
   */
  public void setPageName(String pageName) {
    PAGE_NAME = pageName;
  }
  
  
  
  
  
  // BACKGROUND //////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////
  
  /**
   * Set the background to a gray or ARGB color.
   * <p>
   * For the main drawing surface, the alpha value will be ignored. However,
   * alpha can be used on PGraphics objects from createGraphics(). This is
   * the only way to set all the pixels partially transparent, for instance.
   * <p>
   * Note that background() should be called before any transformations occur,
   * because some implementations may require the current transformation matrix
   * to be identity before drawing.
   *
   * @param rgb
   *        color value in hexadecimal notation (i.e. #FFCC00 or 0xFFFFCC00)<br/>or any value of the color datatype
   */
  public void background(int rgb) {
    // P5 draw
    p5.background(rgb, 255);
    
    // FXG XML
    background(rgb, 255);
  }
  
  /**
   * See notes about alpha in background(x, y, z, a).
   */
  public void background(int rgb, float alpha) {
    // P5 draw
    p5.background(rgb, alpha);
    
    // FXG XML
    if (((rgb & 0xff000000) == 0) && (rgb <= 255)) {
      background(rgb, rgb, rgb, 255);
    } else {
      FXG_startBackground(alpha);
      String srgb = p5.hex(rgb, 6);
      FXG_endBackground(srgb);
      
      ID_COUNT++;
    }
  }
  
  /**
   * Set the background to a grayscale value, based on the
   * current colorMode.
   */
  public void background(float gray) {
    // P5 draw
    p5.background(gray, 255);
    
    // FXG XML
    background(gray, 255);
  }
  
  /**
   * See notes about alpha in background(x, y, z, a).
   *
   * @param gray
   *        specifies a value between white and black
   * @param alpha
   *        opacity of the background
   */
  public void background(float gray, float alpha) {
    // P5 draw
    p5.background(gray, gray, gray, alpha);
    
    // FXG XMLv
    background(gray, gray, gray, alpha);
  }
  
  /**
   * Set the background to an r, g, b or h, s, b value,
   * based on the current colorMode.
   */
  public void background(float x, float y, float z) {
    // P5 draw
    p5.background(x, y, z, 255);
    
    // FXG XML
    background(x, y, z, 255);
  }
  
  /**
   * The <b>background()</b> function sets the color used for the background of
   * the Processing window. The default background is light gray.
   * In the <b>draw()</b> function, the background color is used to clear the
   * display window at the beginning of each frame.
   * <br><br>An image can also be used as the background for a sketch, however
   * its width and height must be the same size as the sketch window. To resize
   * an image 'b' to the size of the sketch window, use b.resize(width, height).
   * <br><br>Images used as background will ignore the current tint() setting.
   * <br><br>It is not possible to use transparency (alpha) in background colors
   * with the main drawing surface, however they will work properly with <b>createGraphics</b>.
   *
   * =advanced
   * <p>Clear the background with a color that includes an alpha value. This can
   * only be used with objects created by createGraphics(), because the main
   * drawing surface cannot be set transparent.</p>
   * <p>It might be tempting to use this function to partially clear the screen
   * on each frame, however that's not how this function works. When calling
   * background(), the pixels will be replaced with pixels that have that level
   * of transparency. To do a semi-transparent overlay, use fill() with alpha
   * and draw a rectangle.</p>
   *
   * @webref color:setting
   *
   * @param x
   *        red or hue value (depending on the current color mode)
   * @param y
   *        green or saturation value (depending on the current color mode)
   * @param z
   *        blue or brightness value (depending on the current color mode)
   *
   * @see PGraphics#stroke(float)
   * @see PGraphics#fill(float)
   * @see PGraphics#tint(float)
   * @see PGraphics#colorMode(int)
   */
  public void background(float x, float y, float z, float a) {
    // P5 draw
    p5.background(x, y, z, a);
    
    // FXG XML
    FXG_startBackground(a);
    String sr = p5.hex((int)x, 2);
    String sg = p5.hex((int)y, 2);
    String sb = p5.hex((int)z, 2);
    FXG_endBackground(sr+sg+sb);
    
    ID_COUNT++;
  }
  
  /**
   * Takes an RGB or ARGB image and sets it as the background.
   * The width and height of the image must be the same size as the sketch.
   * Use image.resize(width, height) to make short work of such a task.
   * <P>
   * Note that even if the image is set as RGB, the high 8 bits of each pixel
   * should be set opaque (0xFF000000), because the image data will be copied
   * directly to the screen, and non-opaque background images may have strange
   * behavior. Using image.filter(OPAQUE) will handle this easily.
   * <P>
   * When using 3D, this will also clear the zbuffer (if it exists).
   */
   
   // TO DO
   
   
  public void background(PImage image) {
    System.err.println("### wngFXG Error! not work at the moment");
  }
  
  /*
   * (non-Javadoc)
   * FXG_startBackground is used to draw the background rectangle
   *
   * @param a
   *        the alpha value
   */
  private void FXG_startBackground(float a) {
    String lablename = "background";
    writer.println("<Rect x=\""+0+
                   "\" y=\""+0+
                   "\" alpha=\""+p5.map(a, 0,255, 0.0f, 1.0f)+
                   "\" width=\""+WIDTH+
                   "\" height=\""+HEIGHT+
                   "\" ai:seqID=\""+ID_COUNT+
                   "\" d:userLabel=\""+lablename+"\">");
    writer.println("<fill>");
  }
  
  /*
   * (non-Javadoc)
   * FXG_endBackground is used to fill the background rectangle
   *
   * @param c
   *        the color value
   */
  private void FXG_endBackground(String c) {
    writer.println("<SolidColor color=\"#"+c+"\"/>");
    writer.println("</fill>");
    writer.println("</Rect>");
  }
  
  
  
  
  
  // SHAPES 2D PRIMITIVES ////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////
  
  /**
   * Draws an arc in the display window.
   * Arcs are drawn along the outer edge of an ellipse defined by the
   * <b>x</b>, <b>y</b>, <b>width</b> and <b>height</b> parameters.
   * The origin or the arc's ellipse may be changed with the
   * <b>ellipseMode()</b> function.
   * The <b>start</b> and <b>stop</b> parameters specify the angles
   * at which to draw the arc.
   *
   * @webref shape:2d_primitives
   * @param a
   *        x-coordinate of the arc's ellipse
   * @param b
   *        y-coordinate of the arc's ellipse
   * @param c
   *        width of the arc's ellipse
   * @param d
   *        height of the arc's ellipse
   * @param start
   *        angle to start the arc, specified in radians
   * @param stop
   *        angle to stop the arc, specified in radians
   *
   * @see PGraphics#ellipseMode(int)
   * @see PGraphics#ellipse(float, float, float, float)
   */
  // A BIT BUGGY ////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////
  public void arc(float a, float b, float c, float d, float start, float stop) {
    // P5 draw
    p5.arc(a, b, c, d, start, stop);
    
    // FXG XML
    LABLENAME = "arc";
    
    a = a - (c / 2);
    b = b - (d / 2);
    c = c / 2;
    d = d /2;
    
    // translate
    a = a + TRANSLATE_X;
    b = b + TRANSLATE_Y;
    // scale
    if(SCALE >= 2) {
      c = c * (SCALE-1);
      d = d * (SCALE-1);
    }
    
    // shape XML
    writer.println("<Path rotation=\"" +ROTATE+
                   "\" x=\"" +a+ 
                   "\" y=\"" +b+
                   "\" blendMode=\"" +BLENDMODE+
                   "\" alpha=\"" +FILL_COLOR_ALPHA_VALUE+
                   "\" winding=\"nonZero\" ai:seqID=\"" +ID_COUNT+
                   "\" data=\"M0 " +c+ "C0 " +(c/2.23356)+ " " +(d/2.23356)+ " " +0+ " " +d+ " 0\" d:userLabel=\"" +LABLENAME+ "\">");
    FXG_fill();
    FXG_stroke();
    FXG_linearGradient();
    FXG_radialGradient();
    FXG_filter();
    
    // finish shape XML
    writer.println("</Path>");
    
    ID_COUNT++;
  }
   
  
  /**
   * Draws an ellipse (oval) in the display window. An ellipse with an equal
   * <b>width</b> and <b>height</b> is a circle. The first two parameters set
   * the location, the third sets the width, and the fourth sets the height.
   * The origin may be changed with the <b>ellipseMode()</b> function.
   *
   * @webref shape:2d_primitives
   * @param a
   *        x-coordinate of the ellipse
   * @param b
   *        y-coordinate of the ellipse
   * @param c
   *        width of the ellipse
   * @param d
   *        height of the ellipse
   *
   * @see PApplet#ellipseMode(int)
   */
  public void ellipse(float a, float b, float c, float d) {
    // P5 draw
    p5.ellipse(a, b, c, d);
    
    // FXG XML
    LABLENAME = "ellipse";
    
    // check the ellipseMode
    if(ELLIPSEMODE == 3) { // CENTER
      //System.out.println("CENTER");
      a = a-(c/2);
      b = b-(d/2);
    } else if(ELLIPSEMODE == 2) { // RADIUS
      //System.out.println("RADIUS");
      c = c*2;
      d = d*2;
      a = a-(c/2);
      b = b-(d/2);
    } else if(ELLIPSEMODE == 0) { // CORNER
      //System.out.println("CORNER");
      a = a;
      b = b;
    } else if(ELLIPSEMODE == 1) { // CORNERS
      //System.out.println("CORNERS");
    }
    
    // translate
    a = a + TRANSLATE_X;
    b = b + TRANSLATE_Y;
    // scale
    if(SCALE >= 2) {
      c = c * (SCALE-1);
      d = d * (SCALE-1);
    }
    
    // shape XML
    writer.println("<Ellipse rotation=\""+ROTATE+
                   "\" x=\""+a+
                   "\" y=\""+b+
                   "\" blendMode=\""+BLENDMODE+
                   "\" alpha=\""+FILL_COLOR_ALPHA_VALUE+
                   "\" width=\""+c+
                   "\" height=\""+d+
                   "\" ai:seqID=\""+ID_COUNT+
                   "\" d:userLabel=\""+LABLENAME+"\">");
    FXG_fill();
    FXG_stroke();
    FXG_linearGradient();
    FXG_radialGradient();
    FXG_filter();
    
    // finish shape XML
    writer.println("</Ellipse>");
    
    ID_COUNT++;
  }
  
  
  /**
   * The origin of the ellipse is modified by the <b>ellipseMode()</b>
   * function. The default configuration is <b>ellipseMode(CENTER)</b>,
   * which specifies the location of the ellipse as the center of the shape.
   * The RADIUS mode is the same, but the width and height parameters to
   * <b>ellipse()</b> specify the radius of the ellipse, rather than the
   * diameter. The CORNER mode draws the shape from the upper-left corner
   * of its bounding box. The CORNERS mode uses the four parameters to
   * <b>ellipse()</b> to set two opposing corners of the ellipse's bounding
   * box. The parameter must be written in "ALL CAPS" because Processing
   * syntax is case sensitive.
   *
   * @webref shape:attributes
   *
   * @param mode
   *        Either CENTER, RADIUS, CORNER, or CORNERS.
   *
   * @see PApplet#ellipse(float, float, float, float)
   */
  public void ellipseMode(int mode) {
    // P5 draw
    p5.ellipseMode(mode);
    
    // FXG XML
    ELLIPSEMODE = mode;
  }
  
  
  /**
   * Draws a line (a direct path between two points) to the screen.
   * The version of <b>line()</b> with four parameters draws the line in 2D.
   * To color a line, use the <b>stroke()</b> function. A line cannot be
   * filled, therefore the <b>fill()</b> method will not affect the color
   * of a line. 2D lines are drawn with a width of one pixel by default,
   * but this can be changed with the <b>strokeWeight()</b> function.
   *
   * @webref shape:2d_primitives
   * @param x1
   *        x-coordinate of the first point
   * @param y1
   *        y-coordinate of the first point
   * @param z1
   *        z-coordinate of the first point
   * @param x2
   *        x-coordinate of the second point
   *
   * @see PGraphics#strokeWeight(float)
   * @see PGraphics#strokeJoin(int)
   * @see PGraphics#strokeCap(int)
   * @see PGraphics#beginShape()
   */
  public void line(float x1, float y1, float x2, float y2) {
    // P5 draw
    p5.line(x1, y1, x2, y2);
    
    // FXG XML
    LABLENAME = "line";
    
    // translate
    x1 = x1 + TRANSLATE_X;
    y1 = y1 + TRANSLATE_Y;
    x2 = x2 + TRANSLATE_X;
    y2 = y2 + TRANSLATE_Y;
    // scale
    if(SCALE >= 2) {
      x2 = x2 * (SCALE - 1);
      y2 = y2 * (SCALE - 1);
    }
    
    // shape XML
    writer.println("<Line rotation=\""+ROTATE+
                   "\" blendMode=\""+BLENDMODE+
                   "\" alpha=\""+FILL_COLOR_ALPHA_VALUE+
                   "\" xFrom=\""+x1+
                   "\" yFrom=\""+y1+
                   "\" xTo=\""+x2+
                   "\" yTo=\""+y2+
                   "\" ai:seqID=\""+ID_COUNT+
                   "\" d:userLabel=\""+LABLENAME+ "\">");
    //writeFill();
    FXG_stroke();
    //FXGlinearGradient();
    //FXGradialGradient();
    FXG_filter();
    
    // finish shape XML
    writer.println("</Line>");
    
    ID_COUNT++;
  }
  
  public void line(float x1, float y1, float z1, float x2, float y2, float z2) {
    System.err.println("### wngFXG Error! line (P3D) not work");
  }
  
  /**
   * Draws a point, a coordinate in space at the dimension of one pixel.
   * The first parameter is the horizontal value for the point, the second
   * value is the vertical value for the point.
   *
   * @webref shape:2d_primitives
   *
   * @param x
   *        x-coordinate of the point
   * @param y
   *        y-coordinate of the point
   *
   * @see PGraphics#beginShape()
   */
  public void point(float x, float y) {
    //System.err.println("### wngFXG Error! point not work");
    rect(x, y, 1, 1);
  }
  
  
  /**
   * A quad is a quadrilateral, a four sided polygon. It is similar to
   * a rectangle, but the angles between its edges are not constrained
   * ninety degrees. The first pair of parameters (x1,y1) sets the
   * first vertex and the subsequent pairs should proceed clockwise or
   * counter-clockwise around the defined shape.
   *
   * @webref shape:2d_primitives
   *
   * @param x1
   *        x-coordinate of the first corner
   * @param y1
   *        y-coordinate of the first corner
   * @param x2
   *        x-coordinate of the second corner
   * @param y2
   *        y-coordinate of the second corner
   * @param x3
   *        x-coordinate of the third corner
   * @param y3
   *        y-coordinate of the third corner
   * @param x4
   *        x-coordinate of the fourth corner
   * @param y4
   *        y-coordinate of the fourth corner
   */
  public void quad(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
    // P5 draw
    p5.quad(x1, y1, x2, y2, x3, y3, x4, y4);
    
    // FXG XML
    LABLENAME = "quad";
    
    // translate
    x1 = x1 + TRANSLATE_X;
    y1 = y1 + TRANSLATE_Y;
    x2 = x2 + TRANSLATE_X;
    y2 = y2 + TRANSLATE_Y;
    x3 = x3 + TRANSLATE_X;
    y3 = y3 + TRANSLATE_Y;
    x4 = x4 + TRANSLATE_X;
    y4 = y4 + TRANSLATE_Y;
    // scale
    if(SCALE >= 2) {
      x2 = x2 * (SCALE - 1);
      y2 = y2 * (SCALE - 1);
      x3 = x3 * (SCALE - 1);
      y3 = y3 * (SCALE - 1);
      x4 = x4 * (SCALE - 1);
      y4 = y4 * (SCALE - 1);
    }
    
    // shape XML
    writer.println("<Path rotation=\""+ROTATE+
                   "\" x=\""+x1+
                   "\" y=\""+y1+
                   "\" blendMode=\""+BLENDMODE+
                   "\" alpha=\""+FILL_COLOR_ALPHA_VALUE+
                   "\" winding=\"nonZero\" ai:seqID=\"" +ID_COUNT+
                   "\" data=\"M0 0 "+(x2-x1)+" "+(y2-y1)+" "+(x3-x1)+" "+(y3-y1)+" "+(x4-x1)+" "+(y4-y1)+" 0 0Z\" d:userLabel=\""+LABLENAME+"\">");
    FXG_fill();
    FXG_stroke();
    FXG_linearGradient();
    FXG_radialGradient();
    FXG_filter();
    
    // finish shape XML
    writer.println("</Path>");
    
    ID_COUNT++;
  }
  
  
  /**
   * Draws a rectangle to the screen. A rectangle is a four-sided shape with
   * every angle at ninety degrees. The first two parameters set the location,
   * the third sets the width, and the fourth sets the height. The origin is
   * changed with the <b>rectMode()</b> function.
   *
   * @webref shape:2d_primitives
   *
   * @param a
   *        x-coordinate of the rectangle
   * @param b
   *        y-coordinate of the rectangle
   * @param c
   *        width of the rectangle
   * @param d
   *        height of the rectangle
   *
   * @see PGraphics#rectMode(int)
   * @see PGraphics#quad(float, float, float, float, float, float, float, float)
   */
  public void rect(float a, float b, float c, float d) {
    // P5 draw
    p5.rect(a, b, c, d);
    
    // FXG XML
    LABLENAME = "rect";  
    
    // check the ellipseMode
    if(RECTMODE == 3) { // CENTER
      System.out.println("CENTER");
      a = a-(c/2);
      b = b-(d/2);
    } else if(RECTMODE == 2) { // RADIUS
      //System.out.println("RADIUS");
      c = c*2;
      d = d*2;
      a = a-(c/2);
      b = b-(d/2);
    } else if(RECTMODE == 0) { // CORNER
      //System.out.println("CORNER");
    } else if(RECTMODE == 1) { // CORNERS
      //System.out.println("CORNERS");
    }
    
    // translate
    a = a + TRANSLATE_X;
    b = b + TRANSLATE_Y;
    // scale
    if(SCALE >= 2) {
      c = c * (SCALE - 1);
      d = d * (SCALE - 1);
    }
    
    // shape XML
    writer.println("<Rect rotation=\""+ROTATE+
                   "\" x=\""+a+
                   "\" y=\""+b+
                   "\" blendMode=\""+BLENDMODE+
                   "\" alpha=\""+FILL_COLOR_ALPHA_VALUE+
                   "\" width=\""+c+
                   "\" height=\""+d+
                   "\" ai:seqID=\""+ID_COUNT+
                   "\" d:userLabel=\""+LABLENAME+ "\">");
    FXG_fill();
    FXG_stroke();
    FXG_linearGradient();
    FXG_radialGradient();
    FXG_filter();
    
    // finish shape XML
    writer.println("</Rect>");
    
    ID_COUNT++;
  }
  
  
  /**
   * Modifies the location from which rectangles draw. The default mode is <b>rectMode(CORNER),</b>
   * which specifies the location to be the upper left corner of the shape and uses the third and
   * fourth parameters of <b>rect()</b> to specify the width and height. The syntax <b>rectMode(CORNERS)</b>
   * uses the first and second parameters of <b>rect()</b> to set the location of one corner and uses the
   * third and fourth parameters to set the opposite corner. The syntax <b>rectMode(CENTER)</b> draws
   * the image from its center point and uses the third and forth parameters of <b>rect()</b> to specify the
   * image's width and height. The syntax <b>rectMode(RADIUS)</b> draws the image from its center
   * point and uses the third and forth parameters of <b>rect()</b> to specify half of the image's width and
   * height. The parameter must be written in ALL CAPS because Processing is a case sensitive
   * language. Note: In version 125, the mode named CENTER_RADIUS was shortened to RADIUS.
   *
   * @webref shape:attributes
   *
   * @param mode
   *        Either CORNER, CORNERS, CENTER, or RADIUS
   *
   * @see PApplet#rect(float, float, float, float)
   */
  public void rectMode(int mode) {
    // P5 draw
    p5.rectMode(mode);
    
    // FXG XML
    RECTMODE = mode;
  }
  
  
  /**
   * A triangle is a plane created by connecting three points. The first two
   * arguments specify the first point, the middle two arguments specify
   * the second point, and the last two arguments specify the third point.
   *
   * @webref shape:2d_primitives
   *
   * @param x1
   *        x-coordinate of the first point
   * @param y1
   *        y-coordinate of the first point
   * @param x2
   *        x-coordinate of the second point
   * @param y2
   *        y-coordinate of the second point
   * @param x3
   *        x-coordinate of the third point
   * @param y3
   *        y-coordinate of the third point
   *
   * @see PApplet#beginShape()
   */
  public void triangle(float x1, float y1, float x2, float y2, float x3, float y3) {
    // P5 draw
    p5.triangle(x1, y1, x2, y2, x3, y3);
    
    // FXG XML
    LABLENAME = "triangle";
    
    // translate
    x1 = x1 + TRANSLATE_X;
    y1 = y1 + TRANSLATE_Y;
    x2 = x2 + TRANSLATE_X;
    y2 = y2 + TRANSLATE_Y;
    x3 = x3 + TRANSLATE_X;
    y3 = y3 + TRANSLATE_Y;
    // scale
    if(SCALE >= 2) {
      x2 = x2 * (SCALE - 1);
      y2 = y2 * (SCALE - 1);
      x3 = x3 * (SCALE - 1);
      y3 = y3 * (SCALE - 1);
    }
    
    // shape XML
    writer.println("<Path rotation=\""+ROTATE+
                   "\" x=\""+x1+
                   "\" y=\""+y1+
                   "\" blendMode=\""+BLENDMODE+
                   "\" alpha=\""+FILL_COLOR_ALPHA_VALUE+
                   "\" winding=\"nonZero\" ai:seqID=\""+ID_COUNT+
                   "\" data=\"M0 0 "+(x2-x1)+" "+(y2-y1)+" "+(x3-x1)+" "+(y3-y1)+ " 0 0Z\" d:userLabel=\""+LABLENAME+"\">");
    FXG_fill();
    FXG_stroke();
    FXG_linearGradient();
    FXG_radialGradient();
    FXG_filter();
    
    // finish shape XML
    writer.println("</Path>");
    
    ID_COUNT++;
  }
  
  
  /**
   * Draws a rounded rectangle to the screen. A rounded rectangle is a four-sided shape with
   * every angle at ninety degrees. The corners are rounded.
   * The first two parameters set the location, the third sets the width, and the fourth
   * sets the height. The origin is changed with the <b>rectMode()</b> function.
   *
   * @webref shape:2d_primitives
   *
   * @param a
   *        x-coordinate of the rectangle
   * @param b
   *        y-coordinate of the rectangle
   * @param c
   *        width of the rectangle
   * @param d
   *        height of the rectangle
   * @param r
   *        corner radians of the rectangle
   *
   * @see PGraphics#rectMode(int)
   * @see PGraphics#quad(float, float, float, float, float, float, float, float)
   */
  public void roundedRect(float a, float b, float c, float d, float r) {
    // P5 draw
    //p5.arc(a, b, c, d, start, stop);
    
    // FXG XML
    LABLENAME = "roundedRect";
    
    // shape XML
    writer.println("<Rect x=\""+a+
                      "\" y=\""+b+
              "\" blendMode=\""+BLENDMODE+
                  "\" alpha=\""+FILL_COLOR_ALPHA_VALUE+
                  "\" width=\""+c+
                 "\" height=\""+d+
                "\" radiusX=\""+r+
                "\" radiusY=\""+r+
               "\" ai:seqID=\""+ID_COUNT+
            "\" d:userLabel=\""+LABLENAME+"\">");
    
    FXG_fill();
    FXG_stroke();
    FXG_linearGradient();
    FXG_radialGradient();
    FXG_filter();
    
    // finish shape XML
    writer.println("</Rect>");
    
    ID_COUNT++;
    
    System.out.println("rrhehtwehwrehtethtehr");
  }
  
  
  
  
  
  // SHAPES 2D CURVES ////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////
  
  /**
   * Draws a Bezier curve on the screen. These curves are defined by a series
   * of anchor and control points. The first two parameters specify the first
   * anchor point and the last two parameters specify the other anchor point.
   * The middle parameters specify the control points which define the shape
   * of the curve. Bezier curves were developed by French engineer Pierre
   * Bezier. Using the 3D version of requires rendering with P3D or OPENGL
   * (see the Environment reference for more information).
   *
   * =advanced
   * Draw a cubic bezier curve. The first and last points are
   * the on-curve points. The middle two are the 'control' points,
   * or 'handles' in an application like Illustrator.
   * <P>
   * Identical to typing:
   * <PRE>beginShape();
   * vertex(x1, y1);
   * bezierVertex(x2, y2, x3, y3, x4, y4);
   * endShape();
   * </PRE>
   * In Postscript-speak, this would be:
   * <PRE>moveto(x1, y1);
   * curveto(x2, y2, x3, y3, x4, y4);</PRE>
   * If you were to try and continue that curve like so:
   * <PRE>curveto(x5, y5, x6, y6, x7, y7);</PRE>
   * This would be done in processing by adding these statements:
   * <PRE>bezierVertex(x5, y5, x6, y6, x7, y7)
   * </PRE>
   * To draw a quadratic (instead of cubic) curve,
   * use the control point twice by doubling it:
   * <PRE>bezier(x1, y1, cx, cy, cx, cy, x2, y2);</PRE>
   *
   * @webref shape:curves
   *
   * @param x1
   *        coordinates for the first anchor point
   * @param y1
   *        coordinates for the first anchor point
   * @param z1
   *        coordinates for the first anchor point
   * @param x2
   *        coordinates for the first control point
   * @param y2
   *        coordinates for the first control point
   * @param z2
   *        coordinates for the first control point
   * @param x3
   *        coordinates for the second control point
   * @param y3
   *        coordinates for the second control point
   * @param z3
   *        coordinates for the second control point
   * @param x4
   *        coordinates for the second anchor point
   * @param y4
   *        coordinates for the second anchor point
   * @param z4
   *        coordinates for the second anchor point
   *
   * @see PGraphics#bezierVertex(float, float, float, float, float, float)
   * @see PGraphics#curve(float, float, float, float, float, float, float, float, float, float, float, float)
   */
  public void bezier(float x1, float y1,
                     float x2, float y2,
                     float x3, float y3,
                     float x4, float y4) {
    /*beginShape();
    vertex(x1, y1);
    bezierVertex(x2, y2, x3, y3, x4, y4);
    endShape();*/
  }
  
  public void bezier(float x1, float y1, float z1,
                     float x2, float y2, float z2,
                     float x3, float y3, float z3,
                     float x4, float y4, float z4) {
    System.err.println("### wngFXG Error! bezier (P3D) not work");
  }
  
  
  public void bezierDetail() {
    System.err.println("### wngFXG Error! bezierDetail (P3D, OPENGL) not work");
  }
  
  
  public void curveTightness(float tightness) {
    System.err.println("### wngFXG Error! curveTightness not work");
  }
  
  
  /**
   * Draws a curved line on the screen. The first and second parameters
   * specify the beginning control point and the last two parameters specify
   * the ending control point. The middle parameters specify the start and
   * stop of the curve. Longer curves can be created by putting a series of
   * <b>curve()</b> functions together or using <b>curveVertex()</b>.
   * An additional function called <b>curveTightness()</b> provides control
   * for the visual quality of the curve. The <b>curve()</b> function is an
   * implementation of Catmull-Rom splines. Using the 3D version of requires
   * rendering with P3D or OPENGL (see the Environment reference for more
   * information).
   *
   * =advanced
   * As of revision 0070, this function no longer doubles the first
   * and last points. The curves are a bit more boring, but it's more
   * mathematically correct, and properly mirrored in curvePoint().
   * <P>
   * Identical to typing out:<PRE>
   * beginShape();
   * curveVertex(x1, y1);
   * curveVertex(x2, y2);
   * curveVertex(x3, y3);
   * curveVertex(x4, y4);
   * endShape();
   * </PRE>
   *
   * @webref shape:curves
   *
   * @param x1
   *        coordinates for the beginning control point
   * @param y1
   *        coordinates for the beginning control point
   * @param z1
   *        coordinates for the beginning control point
   * @param x2
   *        coordinates for the first point
   * @param y2
   *        coordinates for the first point
   * @param z2
   *        coordinates for the first point
   * @param x3
   *        coordinates for the second point
   * @param y3
   *        coordinates for the second point
   * @param z3
   *        coordinates for the second point
   * @param x4
   *        coordinates for the ending control point
   * @param y4
   *        coordinates for the ending control point
   * @param z4
   *        coordinates for the ending control point
   *
   * @see PGraphics#curveVertex(float, float)
   * @see PGraphics#curveTightness(float)
   * @see PGraphics#bezier(float, float, float, float, float, float, float, float, float, float, float, float)
   */
  public void curve(float x1, float y1,
                    float x2, float y2,
                    float x3, float y3,
                    float x4, float y4) {
    /*beginShape();
    curveVertex(x1, y1);
    curveVertex(x2, y2);
    curveVertex(x3, y3);
    curveVertex(x4, y4);
    endShape();*/
  }


  public void curve(float x1, float y1, float z1,
                    float x2, float y2, float z2,
                    float x3, float y3, float z3,
                    float x4, float y4, float z4) {
    System.err.println("### wngFXG Error! bezierDetail (P3D, OPENGL) not work");
  }
  
  
  public void curveDetail() {
    System.err.println("### wngFXG Error! bezierDetail (P3D, OPENGL) not work");
  }
  
  
  
  
  
  // SHAPES VERTEX ///////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////
  
  /**
   * Start a new shape of type POLYGON
   */
  public void beginShape() {
    beginShape(20); // 20 = POLYGON
  }
  
  
  /**
   * Start a new shape.
   * <P>
   * <B>Differences between beginShape() and line() and point() methods.</B>
   * <P>
   * beginShape() is intended to be more flexible at the expense of being
   * a little more complicated to use. it handles more complicated shapes
   * that can consist of many connected lines (so you get joins) or lines
   * mixed with curves.
   * <P>
   * The line() and point() command are for the far more common cases
   * (particularly for our audience) that simply need to draw a line
   * or a point on the screen.
   * <P>
   * From the code side of things, line() may or may not call beginShape()
   * to do the drawing. In the beta code, they do, but in the alpha code,
   * they did not. they might be implemented one way or the other depending
   * on tradeoffs of runtime efficiency vs. implementation efficiency &mdash
   * meaning the speed that things run at vs. the speed it takes me to write
   * the code and maintain it. for beta, the latter is most important so
   * that's how things are implemented.
   */
  public void beginShape(int kind) {
    //System.out.println("beginShape does not exsist with wngFXG");
    
    // POINTS = 2
    // LINES = 4
    // TRIANGLES = 9
    // TRIANGLE_FAN = 11
    // TRIANGLE_STRIP = 10
    // QUADS = 16
    // QUAD_STRIP = 17
    
    // TODO
    // set all kind modes
    
    // shape XML
    writer.print("<Path ");
  }
  
  
  public void bezierVertex(float x2, float y2,
                           float x3, float y3,
                           float x4, float y4) {
    System.err.println("### wngFXG Error! bezierVertex comming soon");
  }
  
  
  public void bezierVertex(float x2, float y2, float z2,
                           float x3, float y3, float z3,
                           float x4, float y4, float z4) {
    System.err.println("### wngFXG Error! bezierVertex (P3D, OPENGL) not work");
  }
  
  
  public void curveVertex(float x, float y) {
    System.err.println("### wngFXG Error! curveVertex comming soon");
  }
  
  public void curveVertex(float x, float y, float z) {
    System.err.println("### wngFXG Error! curveVertex (P3D, OPENGL) not work");
  }
  
  
  /**
   * Start a new shape.
   */
  public void endShape() {
    String lablename = "path";
    
    // shape XML
    writer.print("0 0Z \" d:userLabel=\"" +lablename+ "\">");
    
    FXG_fill();
    FXG_stroke();
    FXG_linearGradient();
    FXG_radialGradient();
    FXG_filter();
    
    // finish shape XML
    writer.println("</Path>");
    
    ID_COUNT++;
    //VERTEX_COUNT = 1;
  }
  
  
  /**
   * Start a new shape with mode.
   */
  public void endShape(int mode) {
    System.err.println("endShape does not exsist with wngFXG");
  }
  
  
  /*public void texture() {
  }*/
  
  /*public void textureMode() {
  }*/

  /**
   * vertex
   */
  public void vertex(float x, float y) {// write to FXG file
  // translate
    x = x + TRANSLATE_X;
    y = y + TRANSLATE_Y;
    
    // shape XML
    if(VERTEX_COUNT == 1) {
      // save the starting coordinate for next vertex.
      VERTEX_START_X = x;
      VERTEX_START_Y = y;
      writer.print("x=\""+x+
                "\" y=\""+y+
        "\" blendMode=\""+BLENDMODE+
            "\" alpha=\""+FILL_COLOR_ALPHA_VALUE+
            "\" winding=\"nonZero\" ai:seqID=\""+ID_COUNT+"\" data =\"M0 0 ");
    } else {
      writer.print((x-VERTEX_START_X)+ " " +(y-VERTEX_START_Y)+ " ");
    }
    
    VERTEX_COUNT++;
  }
  
  public void vertex(float x, float y, float u, float v) {
    //vertexTexture(u, v);
    vertex(x, y);
    System.err.println("### wngFXG ERROR! vertexTexture comming soon");
  }
  
  
  
  
  
  // TRANSFORM ///////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////
  
  /**
   * Push a copy of the current transformation matrix onto the stack.
   */
  public void pushMatrix() {
    // P5 draw
    p5.pushMatrix();
    
    TRANSFORM = true;
  }
  
  
  /**
   * Replace the current transformation matrix with the top of the stack.
   */
  public void popMatrix() {
    // P5 draw
    p5.popMatrix();
    
    TRANSFORM = false; 
    // set translation
    TRANSLATE_X = 0;
    TRANSLATE_Y = 0;
    // set rotate
    ROTATE = 0;
    // set scale
    SCALE = 0;
  }
  
  
  /**
   * Two dimensional rotation.
   *
   * Same as rotateZ (this is identical to a 3D rotation along the z-axis)
   * but included for clarity. It'd be weird for people drawing 2D graphics
   * to be using rotateZ. And they might kick our a-- for the confusion.
   *
   * <A HREF="http://www.xkcd.com/c184.html">Additional background</A>.
   */
  public void rotate(float angle) {
    // P5 draw
    p5.rotate(angle);
    
    ROTATE = ROTATE + p5.degrees(angle);
  }
  
  
  /**
   * Scale in all dimensions.
   */
  public void scale(float s) {
    // P5 draw
    scale(s);
    
    SCALE = SCALE + s;
  }
  
  
  /**
   * Translate in X and Y.
   */
  public void translate(float tx, float ty) {
    // P5 draw
    p5.translate(tx, ty);
    
    if(TRANSFORM == true) {
      TRANSLATE_X = TRANSLATE_X + tx;
      TRANSLATE_Y = TRANSLATE_Y + ty;
      // save translation for deleting
      TRANSLATE_X_SAVER = TRANSLATE_X;
      TRANSLATE_Y_SAVER = TRANSLATE_Y;
      System.out.println("TRANSLATE_X" + TRANSLATE_X);
      System.out.println("TRANSLATE_Y" + TRANSLATE_Y);
      System.out.println("wngFXG.FXG_x_Saver" + TRANSLATE_X_SAVER);
      System.out.println("wngFXG.FXG_y_Saver" + TRANSLATE_Y_SAVER);
      System.out.println("translate with push/popMatrix");
    }
    if(TRANSFORM == false) {
      TRANSLATE_X = TRANSLATE_X + tx;
      TRANSLATE_Y = TRANSLATE_Y + ty;
      System.out.println("translate");
    }
  }
  
  
  /**
   * Translate in X and Y.
   */
  public void translate(float tx, float ty, float tz) {
    System.out.println("### "+LIBRARYNAME+" Error! "+LIBRARYNAME+" does not work with P3D.");
  }
  
  
  public void skewX(float a) {
    System.err.println("wng.FXG --> TODO: add function");
  }
  public void skewY(float a) {
    System.err.println("wng.FXG --> TODO: add function");
  }
  
  
  
  
  
  // IMAGE ///////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////
  
  // NOT READY
  //public void image(PImage image, float x, float y) {
    //System.err.println("wngFXG ERROR!, image will be comming soon");
    /*String lablename = "image";
    System.out.println(image);
    
    // shape XML
    writer.println("<image>");
    writer.println("<BitmapImage x=\"" +x+ "\" y=\"" +y+ "\" source=\"@Embed('data/" +image+ "')\" fillMode=\"clip\" ai:seqID=\"" +wngFXG.ID_COUNT+ "\" d:userLabel=\"" +lablename+ "\"/>");
    
    // color
    //FXGfill();
    //FXGstroke();
    //FXGgradient();
    //FXGfilter();
    
    // finish shape XML
    writer.println("</image>");
    wngFXG.ID_COUNT++;*/
  //}
  
  
  
  
  
  // FILL ////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////
  
  /**
   * Set the fill to either a grayscale value or an ARGB int.
   * @param rgb color value in hexadecimal notation (i.e. #FFCC00 or 0xFFFFCC00) or any value of the color datatype
   */
  public void fill(int rgb) {
    // P5 draw
    p5.fill(rgb, 255);
    
    // FXG XML
    fill(rgb, 255);
  }
  
  
  public void fill(int rgb, float alpha) {
    // P5 draw
    p5.fill(rgb, alpha);
    
    // FXG XML
    if (((rgb & 0xff000000) == 0) && (rgb <= 255)) {
      fill(rgb, rgb, rgb, alpha);
    } else {
      FILL_SOLID_COLOR = true;
      FILL_SOLID_COLOR_VALUE = p5.hex((int) rgb, 6);
      FILL_COLOR_ALPHA_VALUE = p5.map(alpha, 0,255, 0.0f, 1.0f);
    }
  }
  
  
  /**
   * @param gray number specifying value between white and black
   */
  public void fill(float gray) {
    // P5 draw
    p5.fill(gray, 255);
    
    // FXG XML
    fill(gray, 255);
  }
  
  
  public void fill(float gray, float alpha) {
    // P5 draw
    p5.fill(gray, gray, gray, alpha);
    
    // FXG XML
    fill(gray, gray, gray, alpha);
  }
  
  
  public void fill(float x, float y, float z) {
    // P5 draw
    p5.fill(x, y, z, 255);
    
    // FXG XML
    fill(x, y, z, 255);
  }
  
  
  /**
   * Sets the color used to fill shapes. For example,
   * if you run <b>fill(204, 102, 0)</b>, all subsequent shapes
   * will be filled with orange. This color is either specified
   * in terms of the RGB or HSB color depending on
   * the current <b>colorMode()</b> (the default color space is RGB,
   * with each value in the range from 0 to 255).
   * <br><br>When using hexadecimal notation to specify a color,
   * use "#" or "0x" before the values (e.g. #CCFFAA, 0xFFCCFFAA).
   * The # syntax uses six digits to specify a color (the way colors
   * are specified in HTML and CSS). When using the hexadecimal notation
   * starting with "0x", the hexadecimal value must be specified with
   * eight characters; the first two characters define the alpha
   * component and the remainder the red, green, and blue components.
   * <br><br>The value for the parameter "gray" must be less than or
   * equal to the current maximum value as specified
   * by <b>colorMode()</b>. The default maximum value is 255.
   * <br><br>To change the color of an image (or a texture), use tint().
   *
   * @webref color:setting
   * @param x red or hue value
   * @param y green or saturation value
   * @param z blue or brightness value
   * @param alpha opacity of the fill
   *
   * @see PGraphics#noFill()
   * @see PGraphics#stroke(float)
   * @see PGraphics#tint(float)
   * @see PGraphics#background(float, float, float, float)
   * @see PGraphics#colorMode(int, float, float, float, float)
   */
  public void fill(float x, float y, float z, float a) {
    // P5 draw 
    p5.fill(x, y, z, a);
    
    // FXG XML
    FILL_SOLID_COLOR = true;
    String sr = p5.hex((int)x, 2);
    String sg = p5.hex((int)y, 2);
    String sb = p5.hex((int)z, 2);
    FILL_SOLID_COLOR_VALUE = sr+sg+sb;
    FILL_COLOR_ALPHA_VALUE = p5.map(a, 0,255, 0.0f, 1.0f);
  }
  
  
  /**
   * Disables filling geometry. If both <b>noStroke()</b> and <b>noFill()</b>
   * are called, no shapes will be drawn to the screen.
   *
   * @webref color:setting
   *
   * @see PGraphics#fill(float, float, float, float)
   *
   */
  public void noFill() {
    // P5 draw
    p5.noFill();
    
    // FXG XML
    FILL_SOLID_COLOR = false;
    FILL_SOLID_COLOR_VALUE = "FFFFFF";
    FILL_COLOR_ALPHA_VALUE = 1.0f;
  }
  
  
  /*
   * (non-Javadoc)
   * FXG_fill is used to fill the shapes
   */
  private void FXG_fill() {
    if(FILL_SOLID_COLOR == true) {
      writer.println("<fill>");
      writer.println("<SolidColor color=\"#"+FILL_SOLID_COLOR_VALUE+"\"/>");
      writer.println("</fill>");
    }
  }
  
  
  
  
  
  // STROKE CAP/JOIN/WEIGHT //////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////
  
  public void strokeWeight(float weight) {
    // P5 draw
    p5.strokeWeight(weight);
    
    // FXG XML
    STROKE_WEIGHT_VALUE = weight;
  }


  public void strokeJoin(int join) {
    // P5 draw
    p5.strokeJoin(join);
    
    // FXG XML
    if(join == 8) { // 8=MITER
      STROKE_JOINTS = "miter";
    } 
    else if(join == 32) { // 32=BEVEL
      STROKE_JOINTS = "bevel";
    } 
    else if(join == 2) { // 2=ROUND
      STROKE_JOINTS = "round";
    }
  }


  public void strokeCap(int cap) {
    // P5 draw
    p5.strokeCap(cap);
    
    // FXG XML
    if(cap == 1) { // 1=SQUARE
       STROKE_JOINTS = "project";
    } 
    else if(cap == 4) { // 4=PROJECT
       STROKE_JOINTS = "square";
    } 
    else if(cap == 2) { // 2=ROUND
       STROKE_JOINTS = "none";
    }
  }
  
  
  
  
  
  // STROKE COLOR ////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////
  
  /**
   * Set the tint to either a grayscale or ARGB value.
   * See notes attached to the fill() function.
   * @param rgb color value in hexadecimal notation
   * (i.e. #FFCC00 or 0xFFFFCC00) or any value of the color datatype
   */
  public void stroke(int rgb) {
    // P5 draw
    p5.stroke(rgb, 255);
    
    // FXG XML
    stroke(rgb, 255);
  }
  
  
  public void stroke(int rgb, float alpha) {
    // P5 draw
    p5.stroke(rgb, alpha);
    
    // FXG XML
    if (((rgb & 0xff000000) == 0) && (rgb <= 255)) {
      stroke(rgb, rgb, rgb, alpha);
    } else {
      STROKE_SOLID_COLOR = true;
      STROKE_SOLID_COLOR_VALUE = p5.hex((int) rgb, 6);
    }
  }
  
  
  /**
   * @param gray specifies a value between white and black
   */
  public void stroke(float gray) {
    // P5 draw
    p5.stroke(gray);
    
    // FXG XML
    stroke(gray, gray, gray, 255);
  }
  
  
  public void stroke(float gray, float alpha) {
    // P5 draw
    p5.stroke(gray, alpha);
    
    // FXG XML
    stroke(gray, gray, gray, alpha);
  }
  
  
  public void stroke(float x, float y, float z) {
    // P5 draw
    p5.stroke(x, y, z);
    
    // FXG XML
    stroke(x, y, z, 255);
  }
  
  
  /**
   * Sets the color used to draw lines and borders around shapes. This color
   * is either specified in terms of the RGB or HSB color depending on the
   * current <b>colorMode()</b> (the default color space is RGB, with each
   * value in the range from 0 to 255).
   * <br><br>When using hexadecimal notation to specify a color, use "#" or
   * "0x" before the values (e.g. #CCFFAA, 0xFFCCFFAA). The # syntax uses six
   * digits to specify a color (the way colors are specified in HTML and CSS).
   * When using the hexadecimal notation starting with "0x", the hexadecimal
   * value must be specified with eight characters; the first two characters
   * define the alpha component and the remainder the red, green, and blue
   * components.
   * <br><br>The value for the parameter "gray" must be less than or equal
   * to the current maximum value as specified by <b>colorMode()</b>.
   * The default maximum value is 255.
   *
   * @webref color:setting
   * @param alpha opacity of the stroke
   * @param x red or hue value (depending on the current color mode)
   * @param y green or saturation value (depending on the current color mode)
   * @param z blue or brightness value (depending on the current color mode)
   */
  public void stroke(float x, float y, float z, float a) {
    // P5 draw
    p5.stroke(x, y, z, a);
    
    // FXG XML
    STROKE_SOLID_COLOR = true;
    String sr = p5.hex((int)x, 2);
    String sg = p5.hex((int)y, 2);
    String sb = p5.hex((int)z, 2);
    STROKE_SOLID_COLOR_VALUE = sr+sg+sb;
  }
  
  
  /**
   * Disables drawing the stroke (outline). If both <b>noStroke()</b> and
   * <b>noFill()</b> are called, no shapes will be drawn to the screen.
   *
   * @webref color:setting
   *
   * @see PGraphics#stroke(float, float, float, float)
   */
  public void noStroke() {
    // P5 draw
    p5.noStroke();
    
    // FXG XML
    STROKE_SOLID_COLOR = false;
    STROKE_SOLID_COLOR_VALUE = "000000";
  }
  
  
  /*
   * (non-Javadoc)
   * FXG_stroke is used to fill the shapes stroke.
   */
  private void FXG_stroke() {
    if(STROKE_SOLID_COLOR == true) {
      writer.println("<stroke>");
      // check if strokeCaps & strokeJoints is standart
      // else write the specific string.
      if(STROKE_CAPS == "none" && STROKE_JOINTS == "round") {
        writer.println("<SolidColorStroke weight=\""+STROKE_WEIGHT_VALUE+
                       "\" miterLimit=\""+STROKE_MITER+
                       "\" color=\"#"+STROKE_SOLID_COLOR_VALUE+"\"/>");
      } else {
        writer.println("<SolidColorStroke weight=\""+STROKE_WEIGHT_VALUE+
                       "\" caps=\""+STROKE_CAPS+
                       "\" joints=\""+STROKE_JOINTS+
                       "\" miterLimit=\""+STROKE_MITER+
                       "\" color=\"#"+STROKE_SOLID_COLOR_VALUE+"\"/>");
      }
      writer.println("</stroke>");
    }
  }
  
  
  
  
  
  // ADOBE ILLUSTRATOR BLEND MODE ////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////
  
  /**
   * blendMode change the Adobe Illustrator Object Mode.
   *
   * @param b
   *        Modes: NORMAL, DARKEN, MULTIPLY, COLORBURN, LIGHTEN, SCREEN, COLORDODGE, OVERLAY, SOFTLIGHT, 
   *        HARDLIGHT, DIFFERENCE, EXCLUSION, HUE, SATURATION, COLOR or LUMINOSITY
   */
  public void blendMode(String b) {
    if(b == "NORMAL")          BLENDMODE = "normal";
    else if(b == "DARKEN")     BLENDMODE = "darken";
    else if(b == "MULTIPLY")   BLENDMODE = "multiply";
    else if(b == "COLORBURN")  BLENDMODE = "colorburn";
    else if(b == "LIGHTEN")    BLENDMODE = "lighten";
    else if(b == "SCREEN")     BLENDMODE = "screen";
    else if(b == "COLORDODGE") BLENDMODE = "colordodge";
    else if(b == "OVERLAY")    BLENDMODE = "overlay";
    else if(b == "SOFTLIGHT")  BLENDMODE = "softlight";
    else if(b == "HARDLIGHT")  BLENDMODE = "hardlight";
    else if(b == "DIFFERENCE") BLENDMODE = "difference";
    else if(b == "EXCLUSION")  BLENDMODE = "exclusion";
    else if(b == "HUE")        BLENDMODE = "hue";
    else if(b == "SATURATION") BLENDMODE = "saturation";
    else if(b == "COLOR")      BLENDMODE = "color";
    else if(b == "LUMINOSITY") BLENDMODE = "luminosity";
    
    else throw new RuntimeException("### "+LIBRARYNAME+" Error! blendMode not correct.");  
  }


  /**
   * reset the Adobe Illustrator Object Mode to Normal.
   */
  public void noBlendMode() {
    BLENDMODE = "normal";
  }
  
  
  
  
  
  // ADOBE ILLUSTRATOR FILTER DROP SHADOW ////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * dropShadowFilter create a shadow for the shape Object.
   *
   * @param blur
   *        set the blur value between 1 - 144
   * @param c
   *        set a hex value for color
   * @param a
   *        set the alpha value between 0.0 - 1.0
   * @param x
   *        translate x
   * @param y
   *        translate y
   */
  public void dropShadowFilter(int blur, int c, float a, float x, float y) {
    // check the if the blur value is correct
    if(blur >=1 && blur <= 144) {
      DROP_SHADOW_FILTER_blurX = blur*2;
      DROP_SHADOW_FILTER_blurY = blur*2;
    } else {
      throw new RuntimeException("### "+LIBRARYNAME+" Error! dropShadowFilter blur value must between 1 - 144.");
    }
    
    DROP_SHADOW_FILTER_color = c;
    
    // check the if the alpha value is correct
    if(a >= 0.0 && a <= 1.0) {
      DROP_SHADOW_FILTER_alpha = a;
    } else {
      throw new RuntimeException("### "+LIBRARYNAME+" Error! dropShadowFilter aplha value must between 0.0 - 1.0.");
    }
    
    float an = (float) Math.atan2(x, y);
    DROP_SHADOW_FILTER_angle = (float) Math.toDegrees(an);
    
    float dx = 0 - x;
    float dy = 0 - y;
    DROP_SHADOW_FILTER_distance = (float) Math.sqrt( dx*dx + dy*dy );
    
    DROP_SHADOW_FILTER_checker = true;
  }
  
  /**
   * dropShadowFilter create a shadow for the shape Object.
   *
   * @param blur
   *        set the blur value between 1 - 144
   * @param c
   *        set a hex value for color
   * @param a
   *        set the alpha value between 0.0 - 1.0
   */
  public void dropShadowFilter(int blur, int c, float a) {
    dropShadowFilter(blur, c, a, 7, 7);
  }

  /**
   * dropShadowFilter create a shadow for the shape Object.
   * color value set to #000000
   *
   * @param blur
   *        set the blur value between 1 - 144
   * @param a
   *        set the alpha value between 0.0 - 1.0
   */
  public void dropShadowFilter(int blur, float a) {
    dropShadowFilter(blur, 0x00000000, a, 7, 7);
  }

  /**
   * dropShadowFilter create a shadow for the shape Object.
   * color value set to #000000
   * alpha value set to 0.75
   *
   * @param blur
   *        set the blur value between 1 - 144
   */
  public void dropShadowFilter(int blur) {
    dropShadowFilter(blur, 0x00000000, 0.75f, 7, 7);
  }

  /**
   * dropShadowFilter create a shadow with standard value for the shape Object.
   */
  public void dropShadowFilter() {
    dropShadowFilter(5, 0x00000000, 0.75f, 7, 7);
  }


  /**
   * reset the noDropShadowFilter.
   */
  public void noDropShadowFilter() {
    DROP_SHADOW_FILTER_checker = false;
  }





  // ADOBE ILLUSTRATOR FILTER GLOW OUTER /////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * glowOuterFilter creates an outer glow for the shape Object.
   *
   * @param blur
   *        set the blur value between 1 - 144
   * @param c
   *        set a hex value for color
   * @param a
   *        set the alpha value between 0.0 - 1.0
   */
  public void glowOuterFilter(int blur, int c, float a) {
    // check the if the blur value is correct
    if(blur >=1 && blur <= 144) {
      GLOW_OUTER_FILTER_blurX = blur*2;
      GLOW_OUTER_FILTER_blurY = blur*2;
    } else {
      throw new RuntimeException("### "+LIBRARYNAME+" Error! glowOuterFilter blur value must between 1 - 144.");
    }
    
    GLOW_OUTER_FILTER_color = c;
    
    // check the if the alpha value is correct
    if(a >= 0.0 && a <= 1.0) {
      GLOW_OUTER_FILTER_alpha = a;
    } else {
      throw new RuntimeException("### "+LIBRARYNAME+" Error! glowOuterFilter aplha value must between 0.0 - 1.0.");
    }
    
    GLOW_OUTER_FILTER_checker = true;
  }
  
  
  /**
   * glowOuterFilter creates an outer glow for the shape Object.
   * alpha value set to 0.75
   *
   * @param blur
   *        set the blur value between 1 - 144
   * @param c
   *        set a hex value for color
   */
  public void glowOuterFilter(int blur, int c) {
    glowOuterFilter(blur, c, 0.75f);
  }

  /**
   * glowOuterFilter creates an outer glow for the shape Object.
   * color value set to #000000
   * alpha value set to 0.75
   *
   * @param blur
   *        set the blur value between 1 - 144
   */
  public void glowOuterFilter(int blur) {
    glowOuterFilter(blur, 0x00000000, 0.75f);
  }

  /**
   * glowOuterFilter creates an outer glow for the shape Object.
   * blur value set to 14
   * color value set to #000000
   * alpha value set to 0.75
   */
  public void glowOuterFilter() {
    glowOuterFilter(14, 0x00000000, 0.75f);
  }


  /**
   * reset the glowOuterFilter
   */
  public void noGlowOuterFilter() {
    GLOW_OUTER_FILTER_checker = false;
  }





  // ADOBE ILLUSTRATOR FILTER GLOW INNER /////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////

  /*
   * glowInnerFilter creates an outer glow for the shape Object.
   *
   * @param blur
   *        set the blur value between 1 - 144
   * @param c
   *        set a hex value for color
   * @param a
   *        set the alpha value between 0.0 - 1.0
   */
  public void glowInnerFilter(int blur, int c, float a) {
    // check the if the blur value is correct
    if(blur >=1 && blur <= 144) {
      GLOW_INNER_FILTER_blurX = blur*2;
      GLOW_INNER_FILTER_blurY = blur*2;
    } else {
      throw new RuntimeException("### "+LIBRARYNAME+" Error! glowInnerFilter blur value must between 1 - 144.");
    }
    
    GLOW_INNER_FILTER_color = c;
    
    // check the if the alpha value is correct
    if(a >= 0.0 && a <= 1.0) {
      GLOW_INNER_FILTER_alpha = a;
    } else {
      throw new RuntimeException("### "+LIBRARYNAME+" Error! glowInnerFilter aplha value must between 0.0 - 1.0.");
    }
    
    GLOW_INNER_FILTER_checker = true;
  }


  /**
   * glowInnerFilter creates an outer glow for the shape Object.
   * alpha value set to 0.75
   *
   * @param blur
   *        set the blur value between 1 - 144
   * @param c
   *        set a hex value for color
   */
  public void glowInnerFilter(int blur, int c) {
    glowInnerFilter(blur, c, 0.75f);
  }

  /**
   * glowOuterFilter creates an outer glow for the shape Object.
   * color value set to #000000
   * alpha value set to 0.75
   *
   * @param blur
   *        set the blur value between 1 - 144
   */
  public void glowInnerFilter(int blur) {
    glowInnerFilter(blur, 0x00000000, 0.75f);
  }

  /**
   * glowOuterFilter creates an outer glow for the shape Object.
   * blur value set to 14
   * color value set to #000000
   * alpha value set to 0.75
   */
  public void glowInnerFilter() {
    glowInnerFilter(14, 0x00000000, 0.75f);
  }


  /**
   * reset the glowInnerFilter
   */
  public void NoGlowInnerFilter() {
    GLOW_INNER_FILTER_checker = false;
  }
  
  
  
  
  /* (non-Javadoc)
   * FXG XML example
   * <DROP_SHADOW_FILTER blurX="10" blurY="10" quality="2" color="#FF0000" alpha="0.75" distance="21.2132"/>
   * <DROP_SHADOW_FILTER blurX="10" blurY="10" quality="2" color="#D100E2" alpha="0.75" angle="66.8014" distance="38.0789"/>
   * <GlowFilter blurX="10" blurY="10" quality="2" color="#000000" alpha="0.75"/>
   * <GlowFilter blurX="7.5" blurY="7.5" quality="2" strength="2" color="#323F90" alpha="0.75" inner="true"/>
   */
  private void FXG_filter() {
    if(DROP_SHADOW_FILTER_checker == true || GLOW_INNER_FILTER_checker == true || GLOW_OUTER_FILTER_checker == true) {
      writer.println("<filters>");
      if(DROP_SHADOW_FILTER_checker == true) {
        writer.println("<DropShadowFilter blurX=\""+DROP_SHADOW_FILTER_blurX+
                                        "\" blurY=\""+DROP_SHADOW_FILTER_blurY+"\" quality=\"2\"" +
                                          " color=\""+DROP_SHADOW_FILTER_color+
                                        "\" alpha=\""+DROP_SHADOW_FILTER_alpha+
                                        "\" angle=\""+DROP_SHADOW_FILTER_angle+
                                     "\" distance=\""+DROP_SHADOW_FILTER_distance+"\"/>");
      }
      if(GLOW_INNER_FILTER_checker == true) {
        writer.println("<GlowFilter blurX=\"" +GLOW_INNER_FILTER_blurX+
                                "\" blurY=\"" +GLOW_INNER_FILTER_blurY+ "\" quality=\"2\"" +
                                  " color=\"" +GLOW_INNER_FILTER_color+
                                "\" alpha=\"" +GLOW_INNER_FILTER_alpha+ "\"/>");
      }
      if(GLOW_OUTER_FILTER_checker == true) {
        writer.println("<GlowFilter blurX=\"" +GLOW_OUTER_FILTER_blurX+
                                "\" blurY=\"" +GLOW_OUTER_FILTER_blurY+ "\" quality=\"2\"" +
                                  " color=\"" +GLOW_OUTER_FILTER_color+
                                "\" alpha=\"" +GLOW_OUTER_FILTER_alpha+ "\" inner=\"true\"/>");
      }
      writer.println("</filters>");
    }
  }
  
  
  
  
  
  // LINEAR GRADIENT /////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * linearGradient
   * function to create linear gradient
   */
  public void linearGradient(float[] r, int[] c) {
    // P5 draw
    p5.fill(c[0]);
    
    // FXG XML
    LINEAR_GRADIENT_FILL = true;
    LINEAR_GRADIENT_RATIO = r;
    LINEAR_GRADIENT_COLOR = c;
  }


  /**
   * noLinearGradient
   */
  public void noLinearGradient() {
    //fillSolidColor = false;
    LINEAR_GRADIENT_FILL = false;
  }
  
  
  /* (non-Javadoc)
   * draw the gradient to FXG file
   */
  private void FXG_linearGradient() {
    if(LINEAR_GRADIENT_FILL == true) {
      writer.println("<fill>");
      writer.println("<LinearGradient x=\"0\" y=\"50\" scaleX=\"100\">");
      // for sequenz to write the color array. ration is the gradient position, color the color
      for(int i = 0; i < LINEAR_GRADIENT_RATIO.length; i++) {
        writer.println("<GradientEntry ratio=\""+LINEAR_GRADIENT_RATIO[i]+"\" color=\"#"+LINEAR_GRADIENT_COLOR[i]+"\"/>");
      }
      writer.println("</LinearGradient>");
      writer.println("</fill>\n");
      LINEAR_GRADIENT_FILL = false;
    }
  }
  
  
  
  
  
  // RADIAL GRADIENT /////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * radialGradient
   * function to create radial gradient
   */
  public void radialGradient(float[] r, int[] c) {
    // P5 draw
    p5.fill(c[0]);
    
    // FXG XML
    RADIAL_GRADIENT_FILL = true;
    RADIAL_GRADIENT_RATIO = r;
    RADIAL_GRADIENT_COLOR = c;
  }


  /**
   * noRadialGradient
   */
  public void noRadialGradient() {
    //fillSolidColor = false;
    RADIAL_GRADIENT_FILL = false;
  }
  
  
  /* (non-Javadoc)
   * draw the gradient to FXG file
   */
  private void FXG_radialGradient() {
    if(RADIAL_GRADIENT_FILL == true) {
      writer.println("<fill>");
      writer.println("<RadialGradient x=\"0\" y=\"50\" scaleX=\"100\">");
      // for sequenz to write the color array. ration is the gradient position, color the color
      for(int i = 0; i < RADIAL_GRADIENT_RATIO.length; i++) {
        writer.println("<GradientEntry ratio=\""+RADIAL_GRADIENT_RATIO[i]+"\" color=\"#"+RADIAL_GRADIENT_COLOR[i]+"\"/>");
      }
      writer.println("</RadialGradient>");
      writer.println("</fill>");
      RADIAL_GRADIENT_FILL = false;
    }
  }
  
  
  
  
  
}
