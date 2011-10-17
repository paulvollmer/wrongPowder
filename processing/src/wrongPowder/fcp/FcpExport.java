/**
 * wng.FCP library
 *
 * (c) paul vollmer, 2010
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author	paul vollmer http://www.wrong-entertainment.com
 * @modified	2010/12/18
 * @version	0.1.0
 */

package wrongPowder.fcp;

import java.io.*;

import processing.core.*;


/**
 * @example wrongAgent
 * @author Paul Vollmer, wrong-entertainment.com
 * 
 */
public class FcpExport {

  private PApplet p5;

  File file;
  PrintWriter writer;
  
  
  public final static String LIBRARYNAME = "wng.FCP";
  public final static String VERSION = "0.1.0";
  public final static String AUTHOR = "Paul Vollmer, wrong-entertainment.com";
  public final static String INFO = "Library: " + LIBRARYNAME + " Version: " + VERSION + " by: " + AUTHOR;
  


  /**
   * a Constructor, usually called in the setup() method in your sketch to
   * initialize and start the library.
   * 
   * @example wrongAgent
   * @param theParent
   */
  public FcpExport(PApplet parent) {
    this.p5 = parent;
    // welcome console line
    System.out.println("### "+LIBRARYNAME+" library "+VERSION+"\n### "+LIBRARYNAME+" is a library from wrong-entertainment.com\n");
  }


  /**
   * return the name of the library.
   * 
   * @return String
   */
  public static String libraryname() {
    return LIBRARYNAME;
  }


  /**
   * return the version of the library.
   * 
   * @return String
   */
  public static String version() {
    return VERSION;
  }


  /**
   * return the author of the library.
   * 
   * @return String
   */
  public static String author() {
    return AUTHOR;
  }


  /**
   * return information of the library.
   * 
   * @return String
   */
  public static String info() {
    return INFO;
  }



  // CREATE FXCP
  ////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * create a FCP file.
   * 
   * @param  filename
   *         String
   * @param  width
   *         float
   * @param  height
   *         float
   */
  public void createFCP(String filename, float width, float height) {
    String path = p5.sketchPath(filename); // OR    p5.sketchPath+filename;
    if (path != null) {
      file = new File(path);
      if (!file.isAbsolute()) file = null;
    }
    if (file == null) {
      throw new RuntimeException("wngFCP Error! createFXG requires an absolute path for the location of the output file.");
    }
    
    // have to create file object here.
    if (writer == null) {
      try {
        writer = new PrintWriter(new FileWriter(file));
      }
      catch (IOException e) {
        throw new RuntimeException(e);  // java 1.4+
      }
      // write on
      writer.println("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
      writer.println("<!-- created with processing and the "+LIBRARYNAME+" library developed by "+AUTHOR+" -->");
      
      writer.println("<!DOCTYPE xmeml>");
      writer.println("<xmeml version=\"2\">");
      writer.println("<sequence id=\"" +filename+ "\">");
      writer.println("  <name>\"" +filename+ "\"</name>");
      writer.println("  <duration>389</duration>");
      writer.println("  <rate>");
      writer.println("    <ntsc>FALSE</ntsc>");
      writer.println("    <timebase>25</timebase>");
      writer.println("  </rate>");
      writer.println("  <timecode>");
      writer.println("    <rate>");
      writer.println("      <ntsc>FALSE</ntsc>");
      writer.println("      <timebase>25</timebase>");
      writer.println("    </rate>");
      writer.println("    <string>01:00:00:00</string>");
      writer.println("    <frame>90000</frame>");
      writer.println("    <source>source</source>");
      writer.println("    <displayformat>NDF</displayformat>");
      writer.println("  </timecode>");
      writer.println("  <in>-1</in>");
      writer.println("  <out>-1</out>");
      writer.println("  <media>");
      writer.println("  <video>");
      writer.println("  <format>");
      writer.println("    <samplecharacteristics>");
      writer.println("    <width>" +width+ "</width>");
      writer.println("    <height>" +height+ "</height>");
      writer.println("    <anamorphic>FALSE</anamorphic>");
      writer.println("    <pixelaspectratio>Square</pixelaspectratio>");
      writer.println("    <fielddominance>lower</fielddominance>");
      writer.println("    <rate>");
      writer.println("      <ntsc>FALSE</ntsc>");
      writer.println("      <timebase>25</timebase>");
      writer.println("    </rate>");
      writer.println("    <colordepth>24</colordepth>");
      writer.println("    <codec>");
      writer.println("      <name>Dekompressor für Animation</name>");
      writer.println("      <appspecificdata>");
      writer.println("        <appname>Final Cut Pro</appname>");
      writer.println("        <appmanufacturer>Apple Computer, Inc.</appmanufacturer>");
      writer.println("        <appversion>4.0</appversion>");
      writer.println("        <data>");
      writer.println("          <qtcodec>");
      writer.println("            <codecname>Dekompressor für Animation</codecname>");
      writer.println("            <codectypename>Animation</codectypename>");
      writer.println("            <codectypecode>rle </codectypecode>");
      writer.println("            <codecvendorcode>appl</codecvendorcode>");
      writer.println("            <spatialquality>1024</spatialquality>");
      writer.println("            <temporalquality>1024</temporalquality>");
      writer.println("            <keyframerate>0</keyframerate>");
      writer.println("            <datarate>0</datarate>");
      writer.println("          </qtcodec>");
      writer.println("        </data>");
      writer.println("      </appspecificdata>");
      writer.println("    </codec>");
      writer.println("  </samplecharacteristics>");
      writer.println("  <appspecificdata>");
      writer.println("    <appname>Final Cut Pro</appname>");
      writer.println("    <appmanufacturer>Apple Computer, Inc.</appmanufacturer>");
      writer.println("    <appversion>4.0</appversion>");
      writer.println("    <data>");
      writer.println("      <fcpimageprocessing>");
      writer.println("      <useyuv>TRUE</useyuv>");
      writer.println("      <usesuperwhite>FALSE</usesuperwhite>");
      writer.println("      <rendermode>RGB</rendermode>");
      writer.println("      </fcpimageprocessing>");
      writer.println("    </data>");
      writer.println("    </appspecificdata>");
      writer.println("    </format>");
      writer.println("    <track>");
    }
  }


  /**
   * close the FCP file writer.
   */
  public void closeFCP() {
    writer.println("    <enabled>TRUE</enabled>");
    writer.println("    <locked>FALSE</locked>");
    writer.println("    </track>");
    writer.println("    <track>");
    writer.println("      <enabled>TRUE</enabled>");
    writer.println("      <locked>FALSE</locked>");
    writer.println("    </track>");
    writer.println("    </video>");
    writer.println("    <audio>");
    writer.println("    <format>");
    writer.println("    <samplecharacteristics>");
    writer.println("    <depth>16</depth>");
    writer.println("    <samplerate>48000</samplerate>");
    writer.println("    </samplecharacteristics>");
    writer.println("    </format>");
    writer.println("    <outputs>");
    writer.println("    <group>");
    writer.println("    <index>1</index>");
    writer.println("    <numchannels>2</numchannels>");
    writer.println("    <downmix>0</downmix>");
    writer.println("    <channel>");
    writer.println("    <index>1</index>");
    writer.println("    </channel>");
    writer.println("    <channel>");
    writer.println("    <index>2</index>");
    writer.println("    </channel>");
    writer.println("    </group>");
    writer.println("    </outputs>");
    writer.println("    <in>-1</in>");
    writer.println("    <out>-1</out>");
    writer.println("    <track>");
    writer.println("    <enabled>TRUE</enabled>");
    writer.println("    <locked>FALSE</locked>");
    writer.println("    <outputchannelindex>1</outputchannelindex>");
    writer.println("    </track>");
    writer.println("    <track>");
    writer.println("    <enabled>TRUE</enabled>");
    writer.println("    <locked>FALSE</locked>");
    writer.println("    <outputchannelindex>2</outputchannelindex>");
    writer.println("    </track>");
    writer.println("    <filter>");
    writer.println("    <effect>");
    writer.println("    <name>Audio Levels</name>");
    writer.println("    <effectid>audiolevels</effectid>");
    writer.println("    <effectcategory>audiolevels</effectcategory>");
    writer.println("    <effecttype>audiolevels</effecttype>");
    writer.println("    <mediatype>audio</mediatype>");
    writer.println("    <parameter>");
    writer.println("    <name>Level</name>");
    writer.println("    <parameterid>level</parameterid>");
    writer.println("    <valuemin>0</valuemin>");
    writer.println("    <valuemax>3.98109</valuemax>");
    writer.println("    <value>1</value>");
    writer.println("    </parameter>");
    writer.println("    </effect>");
    writer.println("    </filter>");
    writer.println("    </audio>");
    writer.println("    </media>");
    writer.println("    <ismasterclip>FALSE</ismasterclip>");
    writer.println("    </sequence>");
    writer.println("    </xmeml>");
    
    writer.flush();
    writer.close();
    writer = null;
  }



  // SHAPES 2D PRIMITIVES
  ////////////////////////////////////////////////////////////////////////////////////////////////

  public void rect() {//float a, float b, float c, float d) {
    // write to FCP file
    writer.println("<generatoritem id=\"Rechteck\">");
    writer.println("  <name>Rechteck</name>");
    writer.println("    <duration>1</duration>");
    writer.println("    <rate>");
    writer.println("      <ntsc>FALSE</ntsc>");
    writer.println("      <timebase>25</timebase>");
    writer.println("    </rate>");
    writer.println("    <in>1375</in>");
    writer.println("    <out>1625</out>");
    writer.println("    <start>0</start>");
    writer.println("    <end>25</end>");
    writer.println("    <enabled>TRUE</enabled>");
    writer.println("    <effect>");
    writer.println("  <name>Rechteck</name>");
    writer.println("  <effectid>Rectangle</effectid>");
    writer.println("  <effectcategory>Formen</effectcategory>");
    writer.println("  <effecttype>generator</effecttype>");
    writer.println("  <mediatype>video</mediatype>");
    writer.println("  <parameter>");
    writer.println("    <parameterid>size</parameterid>");
    writer.println("    <name>Größe</name>");
    writer.println("    <valuemin>1</valuemin>");
    writer.println("    <valuemax>150</valuemax>");
    writer.println("    <value>50</value>");
    writer.println("  </parameter>");
    writer.println("  <parameter>");
    writer.println("    <parameterid>soft</parameterid>");
    writer.println("    <name>Weichheit</name>");
    writer.println("    <valuemin>0</valuemin>");
    writer.println("    <valuemax>100</valuemax>");
    writer.println("    <value>5</value>");
    writer.println("  </parameter>");
    writer.println("  <parameter>");
    writer.println("    <parameterid>a</parameterid>");
    writer.println("    <name>Ansicht</name>");
    writer.println("    <valuemin>0.1</valuemin>");
    writer.println("    <valuemax>10</valuemax>");
    writer.println("    <value>1.3</value>");
    writer.println("  </parameter>");
    writer.println("  <parameter>");
    writer.println("    <parameterid>col</parameterid>");
    writer.println("    <name>Farbe</name>");
    writer.println("    <value>");
    writer.println("      <alpha>255</alpha>");
    writer.println("      <red>255</red>");
    writer.println("      <green>255</green>");
    writer.println("      <blue>255</blue>");
    writer.println("    </value>");
    writer.println("  </parameter>");
    writer.println("  </effect>");
    writer.println("  <sourcetrack>");
    writer.println("    <mediatype>video</mediatype>");
    writer.println("  </sourcetrack>");
    writer.println("</generatoritem>");
    
    /*writer.println("    <enabled>TRUE</enabled>");
    writer.println("    <locked>FALSE</locked>");
    writer.println("    </track>");*/
    // draw to Processing Applet
    //p5.text(a, b, c, d);
  }
  
  
  
  
  
  public void text(String t, int start, int stop) {//float a, float b, float c, float d) {
    // write to FCP file
    writer.println("<generatoritem id=\"Text\">");
    writer.println("  <name>Text</name>");
    writer.println("  <duration>3000</duration>");
    writer.println("  <rate>");
    writer.println("    <ntsc>FALSE</ntsc>");
    writer.println("    <timebase>25</timebase>");
    writer.println("  </rate>");
    writer.println("  <in>1375</in>");
    writer.println("  <out>1625</out>");
    writer.println("  <start>" +start+"</start>");
    writer.println("  <end>" +stop+ "</end>");
    writer.println("  <enabled>TRUE</enabled>");
    writer.println("  <alphatype>black</alphatype>");
    writer.println("  <effect>");
    writer.println("    <name>Text</name>");
    writer.println("    <effectid>Text</effectid>");
    writer.println("    <effectcategory>Text</effectcategory>");
    writer.println("    <effecttype>generator</effecttype>");
    writer.println("    <mediatype>video</mediatype>");
    writer.println("    <parameter>");
    writer.println("      <parameterid>str</parameterid>");
    writer.println("      <name>Text</name>");
    writer.println("      <value>" +t+ "</value>");
    writer.println("    </parameter>");
    writer.println("    <parameter>");
    writer.println("      <parameterid>fontname</parameterid>");
    writer.println("      <name>Zeichensatz</name>");
    writer.println("      <value>Lucida Grande</value>");
    writer.println("    </parameter>");
    writer.println("    <parameter>");
    writer.println("      <parameterid>fontsize</parameterid>");
    writer.println("      <name>Größe</name>");
    writer.println("      <valuemin>0</valuemin>");
    writer.println("      <valuemax>1000</valuemax>");
    writer.println("      <value>36</value>");
    writer.println("    </parameter>");
    writer.println("    <parameter>");
    writer.println("      <parameterid>fontstyle</parameterid>");
    writer.println("      <name>Stil</name>");
    writer.println("      <valuemin>1</valuemin>");
    writer.println("      <valuemax>4</valuemax>");
    writer.println("      <valuelist>");
    writer.println("        <valueentry>");
    writer.println("          <name>Normal</name>");
    writer.println("          <value>1</value>");
    writer.println("        </valueentry>");
    writer.println("        <valueentry>");
    writer.println("          <name>Fett</name>");
    writer.println("          <value>2</value>");
    writer.println("        </valueentry>");
    writer.println("        <valueentry>");
    writer.println("          <name>Kursiv</name>");
    writer.println("          <value>3</value>");
    writer.println("        </valueentry>");
    writer.println("        <valueentry>");
    writer.println("          <name>Fett/Kursiv</name>");
    writer.println("          <value>4</value>");
    writer.println("        </valueentry>");
    writer.println("    </valuelist>");
    writer.println("    <value>1</value>");
    writer.println("  </parameter>");
    writer.println("  <parameter>");
    writer.println("    <parameterid>fontalign</parameterid>");
    writer.println("    <name>Ausrichtung</name>");
    writer.println("    <valuemin>1</valuemin>");
    writer.println("    <valuemax>3</valuemax>");
    writer.println("    <valuelist>");
    writer.println("    <valueentry>");
    writer.println("    <name>Linksbündig</name>");
    writer.println("    <value>1</value>");
    writer.println("    </valueentry>");
    writer.println("    <valueentry>");
    writer.println("    <name>Zentriert</name>");
    writer.println("    <value>2</value>");
    writer.println("    </valueentry>");
    writer.println("    <valueentry>");
    writer.println("    <name>Rechtsbündig</name>");
    writer.println("    <value>3</value>");
    writer.println("    </valueentry>");
    writer.println("    </valuelist>");
    writer.println("    <value>2</value>");
    writer.println("    </parameter>");
    writer.println("    <parameter>");
    writer.println("    <parameterid>fontcolor</parameterid>");
    writer.println("    <name>Textfarbe</name>");
    writer.println("    <value>");
    writer.println("      <alpha>255</alpha>");
    writer.println("      <red>255</red>");
    writer.println("      <green>255</green>");
    writer.println("      <blue>255</blue>");
    writer.println("    </value>");
    writer.println("    </parameter>");
    writer.println("    <parameter>");
    writer.println("    <parameterid>origin</parameterid>");
    writer.println("    <name>Ursprung</name>");
    writer.println("    <value>");
    writer.println("    <horiz>0</horiz>");
    writer.println("    <vert>0</vert>");
    writer.println("    </value>");
    writer.println("    </parameter>");
    writer.println("    <parameter>");
    writer.println("    <parameterid>fonttrack</parameterid>");
    writer.println("    <name>Laufweite</name>");
    writer.println("    <valuemin>-200</valuemin>");
    writer.println("    <valuemax>200</valuemax>");
    writer.println("    <value>1</value>");
    writer.println("    </parameter>");
    writer.println("    <parameter>");
    writer.println("    <parameterid>leading</parameterid>");
    writer.println("    <name>Zeilenabstand</name>");
    writer.println("    <valuemin>-100</valuemin>");
    writer.println("    <valuemax>100</valuemax>");
    writer.println("    <value>0</value>");
    writer.println("    </parameter>");
    writer.println("    <parameter>");
    writer.println("    <parameterid>aspect</parameterid>");
    writer.println("    <name>Seitenverhältnis</name>");
    writer.println("    <valuemin>0.1</valuemin>");
    writer.println("    <valuemax>5</valuemax>");
    writer.println("    <value>1</value>");
    writer.println("    </parameter>");
    writer.println("    <parameter>");
    writer.println("    <parameterid>autokern</parameterid>");
    writer.println("    <name>Auto-Kerning</name>");
    writer.println("    <value>TRUE</value>");
    writer.println("    </parameter>");
    writer.println("    <parameter>");
    writer.println("    <parameterid>subpixel</parameterid>");
    writer.println("    <name>Subpixel verwenden</name>");
    writer.println("    <value>TRUE</value>");
    writer.println("    </parameter>");
    writer.println("    </effect>");
    writer.println("    <sourcetrack>");
    writer.println("    <mediatype>video</mediatype>");
    writer.println("    </sourcetrack>");
    writer.println("</generatoritem>");
    
   /* writer.println("    <enabled>TRUE</enabled>");
    writer.println("    <locked>FALSE</locked>");
    writer.println("    </track>");*/
    // draw to Processing Applet
    //p5.text(a, b, c, d);
  }
  
  
}

