/**
 *  wrongPowder is developed by wrong-entertainment & powder
 *
 *
 *  Copyright 2011 Paul Vollmer
 *  paulvollmer.net
 *  vollmerpaul@yahoo.de
 * 
 *  This file is part of wrongPowder library.
 *
 *  wrongPowder is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with wrongPowder. If not, see <http://www.gnu.org/licenses/>.
 * 
 *  @author		##author##
 *  @modified	##date##
 *  @version	##version##
 */

package wrongPowder.fxg;


/**
 * @invisible
 */
public interface FxgConstants {
  
  // Library Information
  public final static String LIBRARYNAME = "wng.FXG";
  public final static String VERSION = "0.1.0";
  public final static String AUTHOR = "Paul Vollmer, http://www.wrong-entertainment.com";
  public final static String INFO = "Library: " + LIBRARYNAME + " Version: " + VERSION + " by: " + AUTHOR;
  
  
  // Formats Print
  public final static int[] DIN_A10 = { 105,  74 };
  public final static int[] DIN_A9 =  { 147,  105 };
  public final static int[] DIN_A8 =  { 210,  147 };
  public final static int[] DIN_A7 =  { 298,  210 };
  public final static int[] DIN_A6 =  { 411,  298 };
  public final static int[] DIN_A5 =  { 595,  411 };
  public final static int[] DIN_A4 =  { 842,  595 };
  public final static int[] DIN_A3 =  { 1191, 842 };
  public final static int[] DIN_A2 =  { 1684, 1191 };
  public final static int[] DIN_A1 =  { 2384, 1684 };
  public final static int[] DIN_A0 =  { 3370, 2384 };
  public final static int[] DIN_B5 =  { 729,  516 };
  public final static int[] DIN_B4 =  { 1032, 729 };
  public final static int[] US_LETTER = { 792,  612 };
  public final static int[] LEGAL =     { 1008, 612 };
  
  // Formats Video
  public final static int[] NTSC_DV =            { 654,  480 };
  public final static int[] NTSC_DV_WIDESCREEN = { 873,  480 };
  public final static int[] NTSC_D1 =            { 654,  486 };
  public final static int[] NTSC_D1_WIDESCREEN = { 873,  486 };
  public final static int[] PAL_DV =             { 788,  576 };
  public final static int[] PAL_DV_WIDESCREEN =  { 1050, 576 };
  public final static int[] HDV_HDTV_720 =       { 1280, 720 };
  public final static int[] HDV_1080 =           { 1920, 1080 };
  public final static int[] DVCPRO_HD_720 =      { 1280, 720 };
  public final static int[] DVCPRO_HD_1080 =     { 1920, 1080 };
  public final static int[] HDTV_1080 =          { 1920, 1080 };
  public final static int[] CINEON_HALF =        { 1828, 1332 };
  public final static int[] CINEON_FULL =        { 3656, 2664 };
  public final static int[] FILM_2K =            { 2048, 1556 };
  public final static int[] FILM_4K =            { 4096, 3112 };
  
  
  // FXG
  public final static String FXG_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n"+
                                          "<!-- created with Processing and the "+LIBRARYNAME+" library developed by "+AUTHOR+" -->";
  
  public final static String FXG_ADOBE_HEADER = "\" ai:appVersion=\"15.0.0.399\" ATE:version=\"1.0.0\" flm:"+
                                                "version=\"1.0.0\" d:using=\"\" xmlns=\"http://ns.adobe.com/fxg/2008\""+
                                                " xmlns:ATE=\"http://ns.adobe.com/ate/2009\" xmlns:ai=\"http:"+
                                                "//ns.adobe.com/ai/2009\" xmlns:d=\"http://ns.adobe.com/fxg/2008/dt\""+
                                                " xmlns:flm=\"http://ns.adobe.com/flame/2008\">";    
  
  
}
