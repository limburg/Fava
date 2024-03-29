/* The following code was generated by JFlex 1.4.3 on 16-2-12 17:26 */

package saxion.pti.generated;

import java_cup.runtime.Symbol;

/**
 * Lexer settings
 * TODO: Debug uitzetten
 */

public class Yylex implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int STRING = 2;
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\7\1\3\1\2\1\0\1\3\1\1\16\7\4\0\1\3\1\36"+
    "\1\35\1\0\1\6\1\42\2\0\1\46\1\47\1\5\1\40\1\54"+
    "\1\41\1\0\1\4\1\10\11\11\1\0\1\55\1\44\1\37\1\45"+
    "\2\0\32\6\1\52\1\43\1\53\1\0\1\6\1\0\1\25\1\23"+
    "\1\33\1\32\1\17\1\22\1\26\1\30\1\14\2\6\1\20\1\6"+
    "\1\15\1\24\1\12\1\6\1\13\1\21\1\16\1\34\1\31\1\27"+
    "\3\6\1\50\1\0\1\51\1\0\41\7\2\0\4\6\4\0\1\6"+
    "\2\0\1\7\7\0\1\6\4\0\1\6\5\0\27\6\1\0\37\6"+
    "\1\0\u013f\6\31\0\162\6\4\0\14\6\16\0\5\6\11\0\1\6"+
    "\21\0\130\7\5\0\23\7\12\0\1\6\13\0\1\6\1\0\3\6"+
    "\1\0\1\6\1\0\24\6\1\0\54\6\1\0\46\6\1\0\5\6"+
    "\4\0\202\6\1\0\4\7\3\0\105\6\1\0\46\6\2\0\2\6"+
    "\6\0\20\6\41\0\46\6\2\0\1\6\7\0\47\6\11\0\21\7"+
    "\1\0\27\7\1\0\3\7\1\0\1\7\1\0\2\7\1\0\1\7"+
    "\13\0\33\6\5\0\3\6\15\0\4\7\14\0\6\7\13\0\32\6"+
    "\5\0\13\6\16\7\7\0\12\7\4\0\2\6\1\7\143\6\1\0"+
    "\1\6\10\7\1\0\6\7\2\6\2\7\1\0\4\7\2\6\12\7"+
    "\3\6\2\0\1\6\17\0\1\7\1\6\1\7\36\6\33\7\2\0"+
    "\3\6\60\0\46\6\13\7\1\6\u014f\0\3\7\66\6\2\0\1\7"+
    "\1\6\20\7\2\0\1\6\4\7\3\0\12\6\2\7\2\0\12\7"+
    "\21\0\3\7\1\0\10\6\2\0\2\6\2\0\26\6\1\0\7\6"+
    "\1\0\1\6\3\0\4\6\2\0\1\7\1\6\7\7\2\0\2\7"+
    "\2\0\3\7\11\0\1\7\4\0\2\6\1\0\3\6\2\7\2\0"+
    "\12\7\4\6\15\0\3\7\1\0\6\6\4\0\2\6\2\0\26\6"+
    "\1\0\7\6\1\0\2\6\1\0\2\6\1\0\2\6\2\0\1\7"+
    "\1\0\5\7\4\0\2\7\2\0\3\7\13\0\4\6\1\0\1\6"+
    "\7\0\14\7\3\6\14\0\3\7\1\0\11\6\1\0\3\6\1\0"+
    "\26\6\1\0\7\6\1\0\2\6\1\0\5\6\2\0\1\7\1\6"+
    "\10\7\1\0\3\7\1\0\3\7\2\0\1\6\17\0\2\6\2\7"+
    "\2\0\12\7\1\0\1\6\17\0\3\7\1\0\10\6\2\0\2\6"+
    "\2\0\26\6\1\0\7\6\1\0\2\6\1\0\5\6\2\0\1\7"+
    "\1\6\6\7\3\0\2\7\2\0\3\7\10\0\2\7\4\0\2\6"+
    "\1\0\3\6\4\0\12\7\1\0\1\6\20\0\1\7\1\6\1\0"+
    "\6\6\3\0\3\6\1\0\4\6\3\0\2\6\1\0\1\6\1\0"+
    "\2\6\3\0\2\6\3\0\3\6\3\0\10\6\1\0\3\6\4\0"+
    "\5\7\3\0\3\7\1\0\4\7\11\0\1\7\17\0\11\7\11\0"+
    "\1\6\7\0\3\7\1\0\10\6\1\0\3\6\1\0\27\6\1\0"+
    "\12\6\1\0\5\6\4\0\7\7\1\0\3\7\1\0\4\7\7\0"+
    "\2\7\11\0\2\6\4\0\12\7\22\0\2\7\1\0\10\6\1\0"+
    "\3\6\1\0\27\6\1\0\12\6\1\0\5\6\2\0\1\7\1\6"+
    "\7\7\1\0\3\7\1\0\4\7\7\0\2\7\7\0\1\6\1\0"+
    "\2\6\4\0\12\7\22\0\2\7\1\0\10\6\1\0\3\6\1\0"+
    "\27\6\1\0\20\6\4\0\6\7\2\0\3\7\1\0\4\7\11\0"+
    "\1\7\10\0\2\6\4\0\12\7\22\0\2\7\1\0\22\6\3\0"+
    "\30\6\1\0\11\6\1\0\1\6\2\0\7\6\3\0\1\7\4\0"+
    "\6\7\1\0\1\7\1\0\10\7\22\0\2\7\15\0\60\6\1\7"+
    "\2\6\7\7\4\0\10\6\10\7\1\0\12\7\47\0\2\6\1\0"+
    "\1\6\2\0\2\6\1\0\1\6\2\0\1\6\6\0\4\6\1\0"+
    "\7\6\1\0\3\6\1\0\1\6\1\0\1\6\2\0\2\6\1\0"+
    "\4\6\1\7\2\6\6\7\1\0\2\7\1\6\2\0\5\6\1\0"+
    "\1\6\1\0\6\7\2\0\12\7\2\0\2\6\42\0\1\6\27\0"+
    "\2\7\6\0\12\7\13\0\1\7\1\0\1\7\1\0\1\7\4\0"+
    "\2\7\10\6\1\0\42\6\6\0\24\7\1\0\2\7\4\6\4\0"+
    "\10\7\1\0\44\7\11\0\1\7\71\0\42\6\1\0\5\6\1\0"+
    "\2\6\1\0\7\7\3\0\4\7\6\0\12\7\6\0\6\6\4\7"+
    "\106\0\46\6\12\0\51\6\7\0\132\6\5\0\104\6\5\0\122\6"+
    "\6\0\7\6\1\0\77\6\1\0\1\6\1\0\4\6\2\0\7\6"+
    "\1\0\1\6\1\0\4\6\2\0\47\6\1\0\1\6\1\0\4\6"+
    "\2\0\37\6\1\0\1\6\1\0\4\6\2\0\7\6\1\0\1\6"+
    "\1\0\4\6\2\0\7\6\1\0\7\6\1\0\27\6\1\0\37\6"+
    "\1\0\1\6\1\0\4\6\2\0\7\6\1\0\47\6\1\0\23\6"+
    "\16\0\11\7\56\0\125\6\14\0\u026c\6\2\0\10\6\12\0\32\6"+
    "\5\0\113\6\3\0\3\6\17\0\15\6\1\0\4\6\3\7\13\0"+
    "\22\6\3\7\13\0\22\6\2\7\14\0\15\6\1\0\3\6\1\0"+
    "\2\7\14\0\64\6\40\7\3\0\1\6\3\0\2\6\1\7\2\0"+
    "\12\7\41\0\3\7\2\0\12\7\6\0\130\6\10\0\51\6\1\7"+
    "\126\0\35\6\3\0\14\7\4\0\14\7\12\0\12\7\36\6\2\0"+
    "\5\6\u038b\0\154\6\224\0\234\6\4\0\132\6\6\0\26\6\2\0"+
    "\6\6\2\0\46\6\2\0\6\6\2\0\10\6\1\0\1\6\1\0"+
    "\1\6\1\0\1\6\1\0\37\6\2\0\65\6\1\0\7\6\1\0"+
    "\1\6\3\0\3\6\1\0\7\6\3\0\4\6\2\0\6\6\4\0"+
    "\15\6\5\0\3\6\1\0\7\6\17\0\4\7\32\0\5\7\20\0"+
    "\2\6\23\0\1\6\13\0\4\7\6\0\6\7\1\0\1\6\15\0"+
    "\1\6\40\0\22\6\36\0\15\7\4\0\1\7\3\0\6\7\27\0"+
    "\1\6\4\0\1\6\2\0\12\6\1\0\1\6\3\0\5\6\6\0"+
    "\1\6\1\0\1\6\1\0\1\6\1\0\4\6\1\0\3\6\1\0"+
    "\7\6\3\0\3\6\5\0\5\6\26\0\44\6\u0e81\0\3\6\31\0"+
    "\11\6\6\7\1\0\5\6\2\0\5\6\4\0\126\6\2\0\2\7"+
    "\2\0\3\6\1\0\137\6\5\0\50\6\4\0\136\6\21\0\30\6"+
    "\70\0\20\6\u0200\0\u19b6\6\112\0\u51a6\6\132\0\u048d\6\u0773\0\u2ba4\6"+
    "\u215c\0\u012e\6\2\0\73\6\225\0\7\6\14\0\5\6\5\0\1\6"+
    "\1\7\12\6\1\0\15\6\1\0\5\6\1\0\1\6\1\0\2\6"+
    "\1\0\2\6\1\0\154\6\41\0\u016b\6\22\0\100\6\2\0\66\6"+
    "\50\0\15\6\3\0\20\7\20\0\4\7\17\0\2\6\30\0\3\6"+
    "\31\0\1\6\6\0\5\6\1\0\207\6\2\0\1\7\4\0\1\6"+
    "\13\0\12\7\7\0\32\6\4\0\1\6\1\0\32\6\12\0\132\6"+
    "\3\0\6\6\2\0\6\6\2\0\6\6\2\0\3\6\3\0\2\6"+
    "\3\0\2\6\22\0\3\7\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\2\2\1\3\1\4\1\5\2\6\12\5"+
    "\1\7\1\1\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\2\0\3\5\1\32\7\5"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\2\0\2\5\1\43\10\5\1\0\1\2\2\5\1\44"+
    "\1\45\5\5\1\46\1\47\3\5\1\50\1\5\1\51"+
    "\1\52\1\53\1\54\1\5\1\55";

  private static int [] zzUnpackAction() {
    int [] result = new int[98];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\56\0\134\0\212\0\134\0\270\0\134\0\346"+
    "\0\134\0\u0114\0\u0142\0\u0170\0\u019e\0\u01cc\0\u01fa\0\u0228"+
    "\0\u0256\0\u0284\0\u02b2\0\u02e0\0\134\0\u030e\0\u033c\0\134"+
    "\0\134\0\134\0\134\0\u036a\0\u0398\0\134\0\134\0\134"+
    "\0\134\0\134\0\134\0\134\0\134\0\u03c6\0\134\0\u03f4"+
    "\0\u0422\0\u0450\0\u047e\0\u04ac\0\u04da\0\346\0\u0508\0\u0536"+
    "\0\u0564\0\u0592\0\u05c0\0\u05ee\0\u061c\0\134\0\134\0\134"+
    "\0\134\0\134\0\134\0\134\0\134\0\u064a\0\u0678\0\u06a6"+
    "\0\u06d4\0\346\0\u0702\0\u0730\0\u075e\0\u078c\0\u07ba\0\u07e8"+
    "\0\u0816\0\u0844\0\u0872\0\u064a\0\u08a0\0\u08ce\0\346\0\346"+
    "\0\u08fc\0\u092a\0\u0958\0\u0986\0\u09b4\0\346\0\346\0\u09e2"+
    "\0\u0a10\0\u0a3e\0\346\0\u0a6c\0\346\0\346\0\346\0\346"+
    "\0\u0a9a\0\346";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[98];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\2\5\1\6\1\7\1\10\1\3\1\11"+
    "\1\12\1\13\1\14\1\15\1\10\1\16\1\17\1\10"+
    "\1\20\1\21\1\22\3\10\1\23\1\10\1\24\3\10"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\2\3\32\46\1\47\5\46\1\50\12\46"+
    "\60\0\1\5\57\0\1\51\1\52\56\0\27\10\31\0"+
    "\2\12\52\0\5\10\1\53\21\10\27\0\11\10\1\54"+
    "\15\10\27\0\7\10\1\55\4\10\1\56\12\10\27\0"+
    "\5\10\1\57\21\10\27\0\12\10\1\60\14\10\27\0"+
    "\10\10\1\61\16\10\27\0\17\10\1\62\7\10\27\0"+
    "\16\10\1\63\10\10\27\0\22\10\1\64\4\10\27\0"+
    "\16\10\1\65\10\10\60\0\1\66\55\0\1\67\55\0"+
    "\1\70\55\0\1\71\16\0\1\46\2\0\32\46\1\0"+
    "\5\46\1\0\12\46\13\0\1\72\1\0\1\73\1\74"+
    "\16\0\1\75\20\0\1\51\1\4\1\5\53\51\5\76"+
    "\1\77\50\76\6\0\6\10\1\100\20\10\27\0\10\10"+
    "\1\101\16\10\27\0\10\10\1\102\16\10\27\0\26\10"+
    "\1\103\27\0\13\10\1\104\13\10\27\0\5\10\1\105"+
    "\11\10\1\106\7\10\27\0\12\10\1\107\14\10\27\0"+
    "\16\10\1\110\10\10\27\0\6\10\1\111\20\10\27\0"+
    "\6\10\1\112\20\10\21\0\5\76\1\113\54\76\1\114"+
    "\1\113\50\76\6\0\7\10\1\115\17\10\27\0\26\10"+
    "\1\116\27\0\11\10\1\117\15\10\27\0\11\10\1\120"+
    "\15\10\27\0\6\10\1\121\20\10\27\0\10\10\1\122"+
    "\16\10\27\0\13\10\1\123\13\10\27\0\12\10\1\124"+
    "\14\10\27\0\12\10\1\125\14\10\27\0\24\10\1\126"+
    "\2\10\21\0\4\76\1\5\1\113\50\76\6\0\10\10"+
    "\1\127\16\10\27\0\5\10\1\130\21\10\27\0\7\10"+
    "\1\131\17\10\27\0\6\10\1\132\20\10\27\0\11\10"+
    "\1\133\15\10\27\0\11\10\1\134\15\10\27\0\11\10"+
    "\1\135\15\10\27\0\7\10\1\136\17\10\27\0\20\10"+
    "\1\137\6\10\27\0\25\10\1\140\1\10\27\0\17\10"+
    "\1\141\7\10\27\0\7\10\1\142\17\10\21\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2760];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\1\1\1\11\1\1\1\11\1\1\1\11"+
    "\13\1\1\11\2\1\4\11\2\1\10\11\1\1\1\11"+
    "\1\1\2\0\13\1\10\11\2\0\13\1\1\0\27\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[98];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  // Genereer strings met de volgende buffer.
  private StringBuffer stringBuffer = new StringBuffer();

  // Genereer een symbol zonder attached value.
  private Symbol newSymbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  
  // Genereer een symbol met attached value.
  private Symbol newSymbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Yylex(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Yylex(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 1750) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 2: 
          { /* ignore */
          }
        case 46: break;
        case 39: 
          { return newSymbol(sym.PRINT);
          }
        case 47: break;
        case 26: 
          { return newSymbol(sym.IF);
          }
        case 48: break;
        case 42: 
          { return newSymbol(sym.RETURN);
          }
        case 49: break;
        case 21: 
          { return newSymbol(sym.COMMA);
          }
        case 50: break;
        case 8: 
          { return newSymbol(sym.EQ);
          }
        case 51: break;
        case 40: 
          { return newSymbol(sym.FALSE);
          }
        case 52: break;
        case 33: 
          { stringBuffer.append('\t');
          }
        case 53: break;
        case 44: 
          { return newSymbol(sym.STATIC);
          }
        case 54: break;
        case 1: 
          { throw new Error("Illegal character: " + yytext());
          }
        case 55: break;
        case 7: 
          { stringBuffer.setLength(0); yybegin(STRING);
          }
        case 56: break;
        case 12: 
          { return newSymbol(sym.BSLASH);
          }
        case 57: break;
        case 15: 
          { return newSymbol(sym.LPAREN);
          }
        case 58: break;
        case 4: 
          { return newSymbol(sym.ASTERICK);
          }
        case 59: break;
        case 25: 
          { stringBuffer.append('\\');
          }
        case 60: break;
        case 28: 
          { return newSymbol(sym.EQEQ);
          }
        case 61: break;
        case 31: 
          { stringBuffer.append('\r');
          }
        case 62: break;
        case 22: 
          { return newSymbol(sym.SEMICOLON);
          }
        case 63: break;
        case 18: 
          { return newSymbol(sym.RBRACE);
          }
        case 64: break;
        case 35: 
          { return newSymbol(sym.SYM_INT);
          }
        case 65: break;
        case 23: 
          { stringBuffer.append( yytext() );
          }
        case 66: break;
        case 45: 
          { return newSymbol(sym.SYM_BOOLEAN);
          }
        case 67: break;
        case 6: 
          { return newSymbol(sym.STATIC_INT, Integer.parseInt(yytext()));
          }
        case 68: break;
        case 34: 
          { stringBuffer.append('\"');
          }
        case 69: break;
        case 11: 
          { return newSymbol(sym.MOD);
          }
        case 70: break;
        case 30: 
          { return newSymbol(sym.GREATEREQ);
          }
        case 71: break;
        case 3: 
          { return newSymbol(sym.FSLASH);
          }
        case 72: break;
        case 19: 
          { return newSymbol(sym.LSQPAREN);
          }
        case 73: break;
        case 27: 
          { return newSymbol(sym.NEQ);
          }
        case 74: break;
        case 32: 
          { stringBuffer.append('\n');
          }
        case 75: break;
        case 9: 
          { return newSymbol(sym.PLUS);
          }
        case 76: break;
        case 14: 
          { return newSymbol(sym.GREATER);
          }
        case 77: break;
        case 41: 
          { return newSymbol(sym.WHILE);
          }
        case 78: break;
        case 13: 
          { return newSymbol(sym.LESS);
          }
        case 79: break;
        case 24: 
          { yybegin(YYINITIAL); 
                                   return newSymbol(sym.STATIC_STRING, 
                                   stringBuffer.toString());
          }
        case 80: break;
        case 43: 
          { return newSymbol(sym.SYM_STRING);
          }
        case 81: break;
        case 36: 
          { return newSymbol(sym.TRUE);
          }
        case 82: break;
        case 16: 
          { return newSymbol(sym.RPAREN);
          }
        case 83: break;
        case 38: 
          { return newSymbol(sym.VOID);
          }
        case 84: break;
        case 5: 
          { return newSymbol(sym.IDENTIFIER, new String(yytext()));
          }
        case 85: break;
        case 37: 
          { return newSymbol(sym.ELSE);
          }
        case 86: break;
        case 20: 
          { return newSymbol(sym.RSQPAREN);
          }
        case 87: break;
        case 17: 
          { return newSymbol(sym.LBRACE);
          }
        case 88: break;
        case 29: 
          { return newSymbol(sym.LESSEQ);
          }
        case 89: break;
        case 10: 
          { return newSymbol(sym.MINUS);
          }
        case 90: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
