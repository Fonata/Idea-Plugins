/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.windea.plugin.idea.stellaris.localization.psi;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.*;
import static com.windea.plugin.idea.stellaris.localization.psi.StellarisLocalizationTypes.*;


/**
 * This class is a scanner generated by
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>StellarisLocalizationLexer.flex</tt>
 */
public class StellarisLocalizationLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int WAITING_LOCALE_COLON = 2;
  public static final int WAITING_LOCALE_EOL = 4;
  public static final int WAITING_PROPERTY_KEY = 6;
  public static final int WAITING_PROPERTY_COLON = 8;
  public static final int WAITING_PROPERTY_NUMBER = 10;
  public static final int WAITING_PROPERTY_SPACE = 12;
  public static final int WAITING_PROPERTY_VALUE = 14;
  public static final int WAITING_PROPERTY_EOL = 16;
  public static final int WAITING_RICH_TEXT = 18;
  public static final int WAITING_PROPERTY_REFERENCE = 20;
  public static final int WAITING_PROPERTY_REFERENCE_PARAMETER = 22;
  public static final int WAITING_CODE = 24;
  public static final int WAITING_ICON = 26;
  public static final int WAITING_SERIAL_NUMBER = 28;
  public static final int WAITING_COLORFUL_TEXT_ID = 30;
  public static final int WAITING_COLORFUL_TEXT = 32;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7,  7,
     8,  8,  9,  9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15,
    16, 16
  };

  /**
   * Translates characters to character classes
   * Chosen bits are [9, 6, 6]
   * Total runtime size is 4256 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>12]<<6)|((ch>>6)&0x3f)]<<6)|(ch&0x3f)];
  }

  /* The ZZ_CMAP_Z table has 272 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\6\4\1\5\4\4\1\6\1\7\1\10\4\4\1\11\6\4\1\12\1\13\361\4");

  /* The ZZ_CMAP_Y table has 768 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\26\3\1\4\1\3\1\5\3\3\1\6\5\3\1\7\1\3\1\7\1\3\1\7\1\3\1\7\1\3"+
    "\1\7\1\3\1\7\1\3\1\7\1\3\1\7\1\3\1\7\1\3\1\7\1\3\1\10\1\3\1\10\1\4\4\3\1\6"+
    "\1\10\27\3\1\11\4\3\1\4\1\10\4\3\1\12\1\3\1\10\2\3\1\13\2\3\1\10\1\5\2\3\1"+
    "\13\16\3\1\14\1\15\76\3\1\11\227\3\1\4\12\3\1\10\1\6\2\3\1\16\1\3\1\10\5\3"+
    "\1\5\114\3\1\10\25\3\1\4\56\3\1\7\1\3\1\5\1\17\2\3\1\10\3\3\1\5\5\3\1\10\1"+
    "\3\1\10\5\3\1\10\1\3\1\6\1\5\6\3\1\4\15\3\1\10\67\3\1\4\3\3\1\10\61\3\1\20"+
    "\105\3\1\10\32\3");

  /* The ZZ_CMAP_A table has 1088 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\4\1\3\2\2\1\3\22\0\1\4\1\26\1\14\1\5\1\20\1\16\7\0\2\12\1\0\12\13"+
    "\1\27\6\0\32\10\1\22\1\15\1\23\1\0\1\7\1\0\15\11\1\17\3\11\1\17\10\11\1\0"+
    "\1\21\10\0\1\2\32\0\1\1\2\0\1\24\3\0\1\25\170\0\12\6\106\0\12\6\6\0\12\6\134"+
    "\0\12\6\40\0\12\6\46\0\1\1\105\0\12\6\60\0\12\6\6\0\12\6\46\0\13\1\35\0\2"+
    "\2\5\0\1\1\57\0\1\1\60\0\12\6\26\0\12\6\74\0\12\6\16\0\62\6");

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\21\0\1\1\1\2\1\3\1\4\1\1\1\5\1\6"+
    "\1\2\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\2\16\1\17\1\16\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\2\30\1\5\1\17\2\31\1\5"+
    "\1\17\1\32\1\33\1\34\1\35\1\36\1\37\1\1"+
    "\2\16\1\0\1\40\1\41\1\40\1\42\1\43";

  private static int [] zzUnpackAction() {
    int [] result = new int[67];
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
    "\0\0\0\30\0\60\0\110\0\140\0\170\0\220\0\250"+
    "\0\300\0\330\0\360\0\u0108\0\u0120\0\u0138\0\u0150\0\u0168"+
    "\0\u0180\0\u0198\0\u01b0\0\u01c8\0\u01e0\0\u01f8\0\u01f8\0\u0198"+
    "\0\u0210\0\u0228\0\u0240\0\u0198\0\u0258\0\u0198\0\u0198\0\u0270"+
    "\0\u0288\0\u02a0\0\u0198\0\u02b8\0\u0288\0\u0288\0\u0288\0\u0288"+
    "\0\u0288\0\u02d0\0\u0198\0\u0198\0\u02e8\0\u0300\0\u0300\0\u02e8"+
    "\0\u0318\0\u0330\0\u0330\0\u0318\0\u0198\0\u0348\0\u0198\0\u0198"+
    "\0\u0198\0\u0198\0\u0360\0\u0378\0\u0390\0\u01f8\0\u0288\0\u0288"+
    "\0\u0378\0\u0198\0\u0288";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[67];
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
    "\1\22\4\23\1\24\1\22\1\25\1\22\1\25\5\22"+
    "\1\25\11\22\1\26\2\27\1\26\22\22\1\30\1\22"+
    "\1\26\2\27\1\31\24\22\4\23\1\32\2\22\2\33"+
    "\5\22\1\33\11\22\1\26\2\27\1\31\22\22\1\34"+
    "\1\22\1\26\2\27\1\35\1\22\1\36\4\22\1\36"+
    "\15\22\1\26\2\27\1\35\24\22\1\26\2\27\1\26"+
    "\7\22\1\37\14\22\1\26\2\27\1\31\1\40\22\22"+
    "\1\41\2\42\1\27\1\42\7\41\1\43\1\44\1\45"+
    "\1\41\1\46\1\41\1\47\1\41\1\50\1\51\2\41"+
    "\1\22\1\26\2\27\1\26\3\22\2\52\2\22\1\43"+
    "\2\22\1\52\1\53\1\54\6\22\1\55\1\56\1\57"+
    "\1\27\1\56\7\55\1\60\3\55\1\53\7\55\1\61"+
    "\1\62\1\63\1\27\1\62\7\61\1\64\5\61\1\22"+
    "\1\65\4\61\1\22\1\26\2\27\1\26\2\22\1\66"+
    "\1\22\1\66\2\22\1\43\2\22\1\66\4\22\1\67"+
    "\4\22\1\26\2\27\1\26\3\22\1\70\3\22\1\43"+
    "\1\22\1\71\12\22\1\26\2\27\1\26\3\22\1\72"+
    "\3\22\1\43\10\22\1\73\2\22\1\41\2\42\1\27"+
    "\1\42\7\41\1\43\1\74\1\45\1\41\1\46\1\41"+
    "\1\47\1\41\1\50\1\75\2\41\31\0\4\23\23\0"+
    "\3\24\1\0\24\24\7\0\1\25\1\0\1\25\5\0"+
    "\1\25\11\0\1\76\2\27\1\76\24\0\1\76\2\27"+
    "\1\31\23\0\3\32\1\0\24\32\7\0\5\33\3\0"+
    "\1\33\11\0\1\76\2\27\1\35\23\0\3\40\1\0"+
    "\24\40\3\41\1\0\10\41\1\0\1\74\13\41\2\42"+
    "\1\27\1\42\7\41\1\0\1\74\12\41\2\77\1\41"+
    "\1\0\10\77\1\100\1\101\3\100\1\77\1\100\5\77"+
    "\7\0\5\52\3\0\1\52\10\0\3\55\1\0\14\55"+
    "\1\0\10\55\1\56\1\57\1\27\1\56\13\55\1\0"+
    "\7\55\3\61\1\0\16\61\2\0\5\61\1\62\1\63"+
    "\1\27\1\62\15\61\2\0\4\61\7\0\1\66\1\0"+
    "\1\66\5\0\1\66\36\0\1\102\1\0\3\41\1\0"+
    "\11\41\1\74\15\41\1\0\10\41\1\0\1\74\10\41"+
    "\1\103\1\41";

  private static int [] zzUnpackTrans() {
    int [] result = new int[936];
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
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\21\0\1\11\5\1\1\11\3\1\1\11\1\1\2\11"+
    "\3\1\1\11\7\1\2\11\10\1\1\11\1\1\4\11"+
    "\3\1\1\0\3\1\1\11\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[67];
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
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  int textDepth = 0;

  public int textState(){
  	if(textDepth <= 0)
  		return WAITING_RICH_TEXT;
  	else
  		return WAITING_COLORFUL_TEXT;
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public StellarisLocalizationLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /**
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
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
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
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
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
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
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
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
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return TokenType.BAD_CHARACTER;
            }
            // fall through
          case 36: break;
          case 2:
            { return WHITE_SPACE;
            }
            // fall through
          case 37: break;
          case 3:
            { return ROOT_COMMENT;
            }
            // fall through
          case 38: break;
          case 4:
            { yybegin(WAITING_LOCALE_COLON); return LOCALE_ID;
            }
            // fall through
          case 39: break;
          case 5:
            { yybegin(WAITING_PROPERTY_KEY); return WHITE_SPACE;
            }
            // fall through
          case 40: break;
          case 6:
            { yybegin(WAITING_LOCALE_EOL); return COLON;
            }
            // fall through
          case 41: break;
          case 7:
            { return COMMENT;
            }
            // fall through
          case 42: break;
          case 8:
            { yybegin(WAITING_PROPERTY_COLON); return PROPERTY_KEY_ID;
            }
            // fall through
          case 43: break;
          case 9:
            { yybegin(WAITING_PROPERTY_NUMBER); return COLON;
            }
            // fall through
          case 44: break;
          case 10:
            { yybegin(WAITING_PROPERTY_VALUE); return WHITE_SPACE;
            }
            // fall through
          case 45: break;
          case 11:
            { yybegin(WAITING_PROPERTY_SPACE); return NUMBER;
            }
            // fall through
          case 46: break;
          case 12:
            { yybegin(WAITING_RICH_TEXT); return LEFT_QUOTE;
            }
            // fall through
          case 47: break;
          case 13:
            { return END_OF_LINE_COMMENT;
            }
            // fall through
          case 48: break;
          case 14:
            { return STRING_TOKEN;
            }
            // fall through
          case 49: break;
          case 15:
            { yybegin(WAITING_PROPERTY_KEY); return RIGHT_QUOTE;
            }
            // fall through
          case 50: break;
          case 16:
            { yybegin(WAITING_SERIAL_NUMBER); return SERIAL_NUMBER_START;
            }
            // fall through
          case 51: break;
          case 17:
            { yybegin(WAITING_PROPERTY_REFERENCE); return PROPERTY_REFERENCE_START;
            }
            // fall through
          case 52: break;
          case 18:
            { yybegin(WAITING_CODE); return CODE_START;
            }
            // fall through
          case 53: break;
          case 19:
            { yybegin(WAITING_ICON); return ICON_START;
            }
            // fall through
          case 54: break;
          case 20:
            { textDepth++; yybegin(WAITING_COLORFUL_TEXT_ID); return COLORFUL_TEXT_START;
            }
            // fall through
          case 55: break;
          case 21:
            { return PROPERTY_KEY_ID;
            }
            // fall through
          case 56: break;
          case 22:
            { yybegin(textState()); return PROPERTY_REFERENCE_END;
            }
            // fall through
          case 57: break;
          case 23:
            { yybegin(WAITING_PROPERTY_REFERENCE_PARAMETER); return PROPERTY_REFERENCE_SEPARATOR;
            }
            // fall through
          case 58: break;
          case 24:
            { return PROPERTY_REFERENCE_PARAMETER;
            }
            // fall through
          case 59: break;
          case 25:
            { return CODE_TEXT;
            }
            // fall through
          case 60: break;
          case 26:
            { yybegin(textState()); return CODE_END;
            }
            // fall through
          case 61: break;
          case 27:
            { return ICON_ID;
            }
            // fall through
          case 62: break;
          case 28:
            { yybegin(textState()); return ICON_END;
            }
            // fall through
          case 63: break;
          case 29:
            { return SERIAL_NUMBER_ID;
            }
            // fall through
          case 64: break;
          case 30:
            { yybegin(textState()); return SERIAL_NUMBER_END;
            }
            // fall through
          case 65: break;
          case 31:
            { yybegin(WAITING_COLORFUL_TEXT); return COLORFUL_TEXT_ID;
            }
            // fall through
          case 66: break;
          case 32:
            { return VALID_ESCAPE_TOKEN;
            }
            // fall through
          case 67: break;
          case 33:
            { return INVALID_ESCAPE_TOKEN;
            }
            // fall through
          case 68: break;
          case 34:
            { textDepth--; yybegin(textState()); return COLORFUL_TEXT_END;
            }
            // fall through
          case 69: break;
          case 35:
            { textDepth--;  ;yybegin(textState()); return COLORFUL_TEXT_END;
            }
            // fall through
          case 70: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
