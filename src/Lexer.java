/* The following code was generated by JFlex 1.6.0 */

/* JFlex example: part of Java language lexer specification */

import java_cup.runtime.*;
/**
 * This class is a simple example lexer.
 */

class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\2\1\1\1\0\2\2\22\0\1\2\1\34\1\12\1\3"+
    "\2\0\1\17\1\0\1\13\1\14\1\30\1\27\1\25\1\26\1\0"+
    "\1\4\12\6\1\24\1\23\1\35\1\32\1\33\2\0\5\7\1\5"+
    "\15\7\1\5\6\7\1\21\1\0\1\22\1\31\1\11\1\0\1\37"+
    "\1\51\1\47\1\52\1\54\1\43\1\7\1\50\1\40\2\7\1\44"+
    "\1\36\1\41\1\45\1\57\1\55\1\46\1\53\1\42\1\56\1\10"+
    "\1\60\3\7\1\15\1\20\1\16\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uff92\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\0\1\2\1\3\1\4\1\5\1\1"+
    "\1\0\1\6\1\7\1\10\1\11\2\0\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
    "\1\24\1\25\1\26\17\5\1\0\1\27\1\30\1\31"+
    "\1\32\1\33\1\34\1\35\2\5\1\36\1\37\2\5"+
    "\1\40\4\5\1\41\5\5\1\42\4\5\1\0\2\5"+
    "\1\43\5\5\1\44\1\45\5\5\1\46\3\5\1\47"+
    "\1\5\1\50\1\51\2\5\1\52\1\53\1\5\1\54"+
    "\1\55\1\56\1\57\2\5\1\60\1\61\2\5\1\62"+
    "\1\63\1\64\1\65";

  private static int [] zzUnpackAction() {
    int [] result = new int[116];
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
    "\0\0\0\61\0\142\0\223\0\304\0\365\0\304\0\304"+
    "\0\u0126\0\61\0\61\0\61\0\61\0\u0157\0\u0188\0\61"+
    "\0\61\0\61\0\u01b9\0\61\0\61\0\61\0\61\0\61"+
    "\0\u01ea\0\61\0\u021b\0\u024c\0\u027d\0\u02ae\0\u02df\0\u0310"+
    "\0\u0341\0\u0372\0\u03a3\0\u03d4\0\u0405\0\u0436\0\u0467\0\u0498"+
    "\0\u04c9\0\u04fa\0\u052b\0\u055c\0\61\0\61\0\61\0\61"+
    "\0\61\0\61\0\61\0\u058d\0\u05be\0\u05ef\0\304\0\u0620"+
    "\0\u0651\0\304\0\u0682\0\u06b3\0\u06e4\0\u0715\0\304\0\u0746"+
    "\0\u0777\0\u07a8\0\u07d9\0\u080a\0\304\0\u083b\0\u086c\0\u089d"+
    "\0\u08ce\0\u08ff\0\u0930\0\u0961\0\304\0\u0992\0\u09c3\0\u09f4"+
    "\0\u0a25\0\u0a56\0\304\0\304\0\u0a87\0\u0ab8\0\u0ae9\0\u0b1a"+
    "\0\u0b4b\0\304\0\u0b7c\0\u0bad\0\u0bde\0\304\0\u0c0f\0\304"+
    "\0\304\0\u0c40\0\u0c71\0\304\0\304\0\u0ca2\0\304\0\304"+
    "\0\304\0\304\0\u0cd3\0\u0d04\0\304\0\304\0\u0d35\0\u0d66"+
    "\0\304\0\304\0\304\0\304";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[116];
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
    "\1\0\2\2\1\3\1\4\1\5\1\6\1\7\1\10"+
    "\1\0\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\1\7\1\40\1\41\1\42\1\43\1\44\1\45\1\7"+
    "\1\46\1\47\1\50\1\51\2\7\1\52\1\53\61\0"+
    "\1\3\1\2\57\3\3\0\1\54\62\0\5\7\24\0"+
    "\23\7\6\0\1\6\52\0\12\11\1\55\46\11\17\0"+
    "\1\56\61\0\1\57\72\0\1\60\61\0\1\61\57\0"+
    "\1\62\60\0\1\63\33\0\5\7\24\0\1\7\1\64"+
    "\21\7\5\0\5\7\24\0\6\7\1\65\14\7\5\0"+
    "\5\7\24\0\3\7\1\66\1\7\1\67\15\7\5\0"+
    "\5\7\24\0\12\7\1\70\1\7\1\71\6\7\5\0"+
    "\5\7\24\0\2\7\1\72\3\7\1\73\1\74\4\7"+
    "\1\75\6\7\5\0\5\7\24\0\16\7\1\76\4\7"+
    "\5\0\5\7\24\0\14\7\1\77\6\7\5\0\5\7"+
    "\24\0\1\7\1\100\14\7\1\101\4\7\5\0\5\7"+
    "\24\0\12\7\1\102\10\7\5\0\5\7\24\0\7\7"+
    "\1\103\13\7\5\0\5\7\24\0\2\7\1\104\4\7"+
    "\1\105\13\7\5\0\5\7\24\0\16\7\1\106\4\7"+
    "\5\0\5\7\24\0\6\7\1\107\14\7\5\0\5\7"+
    "\24\0\10\7\1\110\12\7\5\0\5\7\24\0\12\7"+
    "\1\111\10\7\3\54\1\112\55\54\5\0\5\7\24\0"+
    "\2\7\1\113\20\7\5\0\5\7\24\0\2\7\1\114"+
    "\20\7\5\0\5\7\24\0\4\7\1\115\16\7\5\0"+
    "\5\7\24\0\16\7\1\116\4\7\5\0\5\7\24\0"+
    "\16\7\1\117\4\7\5\0\5\7\24\0\7\7\1\120"+
    "\13\7\5\0\5\7\24\0\10\7\1\121\12\7\5\0"+
    "\5\7\24\0\16\7\1\122\4\7\5\0\5\7\24\0"+
    "\3\7\1\123\17\7\5\0\5\7\24\0\4\7\1\124"+
    "\16\7\5\0\5\7\24\0\1\7\1\125\2\7\1\126"+
    "\16\7\5\0\5\7\24\0\1\7\1\127\21\7\5\0"+
    "\5\7\24\0\7\7\1\130\13\7\5\0\5\7\24\0"+
    "\11\7\1\131\11\7\5\0\5\7\24\0\17\7\1\132"+
    "\3\7\5\0\5\7\24\0\15\7\1\133\5\7\5\0"+
    "\5\7\24\0\2\7\1\134\20\7\5\0\5\7\24\0"+
    "\2\7\1\135\20\7\3\54\1\112\1\2\54\54\5\0"+
    "\5\7\24\0\3\7\1\136\17\7\5\0\5\7\24\0"+
    "\1\7\1\137\21\7\5\0\5\7\24\0\3\7\1\140"+
    "\17\7\5\0\5\7\24\0\5\7\1\141\15\7\5\0"+
    "\5\7\24\0\1\7\1\142\21\7\5\0\5\7\24\0"+
    "\1\7\1\143\21\7\5\0\5\7\24\0\5\7\1\144"+
    "\15\7\5\0\5\7\24\0\14\7\1\145\6\7\5\0"+
    "\5\7\24\0\20\7\1\146\2\7\5\0\5\7\24\0"+
    "\10\7\1\147\12\7\5\0\5\7\24\0\6\7\1\150"+
    "\14\7\5\0\5\7\24\0\4\7\1\151\16\7\5\0"+
    "\5\7\24\0\16\7\1\152\4\7\5\0\5\7\24\0"+
    "\3\7\1\153\17\7\5\0\5\7\24\0\6\7\1\154"+
    "\14\7\5\0\5\7\24\0\15\7\1\155\5\7\5\0"+
    "\5\7\24\0\4\7\1\156\16\7\5\0\5\7\24\0"+
    "\6\7\1\157\14\7\5\0\5\7\24\0\10\7\1\160"+
    "\12\7\5\0\5\7\24\0\4\7\1\161\16\7\5\0"+
    "\5\7\24\0\16\7\1\162\4\7\5\0\5\7\24\0"+
    "\6\7\1\163\14\7\5\0\5\7\24\0\3\7\1\164"+
    "\17\7";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3479];
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
    "\1\0\1\11\1\0\5\1\1\0\4\11\2\0\3\11"+
    "\1\1\5\11\1\1\1\11\21\1\1\0\7\11\26\1"+
    "\1\0\52\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[116];
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
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
  StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 164) {
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
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
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
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;           
    int totalRead = 0;
    while (totalRead < requested) {
      int numRead = zzReader.read(zzBuffer, zzEndRead + totalRead, requested - totalRead);
      if (numRead == -1) {
        break;
      }
      totalRead += numRead;
    }

    if (totalRead > 0) {
      zzEndRead += totalRead;
      if (totalRead == requested) { /* possibly more input available */
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      return false;
    }

    // totalRead = 0: End of stream
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
   * Internal scan buffer is resized down to its initial length, if it has grown.
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
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
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
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
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
          yycolumn += zzCharCount;
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

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
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
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
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

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 1: 
          { 
          }
        case 54: break;
        case 2: 
          { System.out.printf("/ "); return symbol(sym.TK_DIVIDE);
          }
        case 55: break;
        case 3: 
          { System.out.printf("( "); return symbol(sym.TK_BOOLEAN_CONSTANT, new Boolean("T".equals(yytext())));
          }
        case 56: break;
        case 4: 
          { System.out.printf(yytext() + " "); return symbol(sym.TK_STRING_CONSTANT, new Integer(yytext()));
          }
        case 57: break;
        case 5: 
          { System.out.printf(yytext() + " "); return symbol(sym.TK_IDENTIFIER, yytext());
          }
        case 58: break;
        case 6: 
          { System.out.printf("( "); return symbol(sym.TK_LPAREN);
          }
        case 59: break;
        case 7: 
          { System.out.printf(") "); return symbol(sym.TK_RPAREN);
          }
        case 60: break;
        case 8: 
          { System.out.printf("{ "); return symbol(sym.TK_LBRACE);
          }
        case 61: break;
        case 9: 
          { System.out.printf("} "); return symbol(sym.TK_RBRACE);
          }
        case 62: break;
        case 10: 
          { System.out.printf("[ "); return symbol(sym.TK_LBRACKET);
          }
        case 63: break;
        case 11: 
          { System.out.printf("] "); return symbol(sym.TK_RBRACKET);
          }
        case 64: break;
        case 12: 
          { System.out.printf("; "); return symbol(sym.TK_SEMI);
          }
        case 65: break;
        case 13: 
          { System.out.printf(": "); return symbol(sym.TK_COLON);
          }
        case 66: break;
        case 14: 
          { System.out.printf(", "); return symbol(sym.TK_COMMA);
          }
        case 67: break;
        case 15: 
          { System.out.printf("- "); return symbol(sym.TK_MINUS);
          }
        case 68: break;
        case 16: 
          { System.out.printf("+ "); return symbol(sym.TK_PLUS);
          }
        case 69: break;
        case 17: 
          { System.out.printf("* "); return symbol(sym.TK_TIMES);
          }
        case 70: break;
        case 18: 
          { System.out.printf("^ "); return symbol(sym.TK_POWER);
          }
        case 71: break;
        case 19: 
          { System.out.printf("= "); return symbol(sym.TK_EQUALS);
          }
        case 72: break;
        case 20: 
          { System.out.printf("> "); return symbol(sym.TK_LARGER);
          }
        case 73: break;
        case 21: 
          { System.out.printf("! "); return symbol(sym.TK_NOT);
          }
        case 74: break;
        case 22: 
          { System.out.printf("< "); return symbol(sym.TK_SMALLER);
          }
        case 75: break;
        case 23: 
          { String str = yytext();
      str = str.substring(1, str.length() - 1);
      System.out.printf(str + " ");
      return symbol(sym.TK_STRING_CONSTANT, str);
          }
        case 76: break;
        case 24: 
          { System.out.printf("&& "); return symbol(sym.TK_AND);
          }
        case 77: break;
        case 25: 
          { System.out.printf("|| "); return symbol(sym.TK_OR);
          }
        case 78: break;
        case 26: 
          { System.out.printf(":= "); return symbol(sym.TK_ASSIGNMENT);
          }
        case 79: break;
        case 27: 
          { System.out.printf("=> "); return symbol(sym.TK_IMPLICATION);
          }
        case 80: break;
        case 28: 
          { System.out.printf("!= "); return symbol(sym.TK_NOTEQUALS);
          }
        case 81: break;
        case 29: 
          { System.out.printf("<= "); return symbol(sym.TK_SEQUALS);
          }
        case 82: break;
        case 30: 
          { System.out.printf("in "); return symbol(sym.TK_IN);
          }
        case 83: break;
        case 31: 
          { System.out.printf("if "); return symbol(sym.TK_IF);
          }
        case 84: break;
        case 32: 
          { System.out.printf("fi "); return symbol(sym.TK_FI);
          }
        case 85: break;
        case 33: 
          { System.out.printf("od "); return symbol(sym.TK_OD);
          }
        case 86: break;
        case 34: 
          { System.out.printf("do "); return symbol(sym.TK_DO);
          }
        case 87: break;
        case 35: 
          { System.out.printf("int "); return symbol(sym.TK_INT);
          }
        case 88: break;
        case 36: 
          { System.out.printf("len "); return symbol(sym.TK_LEN);
          }
        case 89: break;
        case 37: 
          { System.out.printf("rat "); return symbol(sym.TK_RAT);
          }
        case 90: break;
        case 38: 
          { System.out.printf("seq "); return symbol(sym.TK_SEQUENCE);
          }
        case 91: break;
        case 39: 
          { System.out.printf("main "); return symbol(sym.TK_MAIN);
          }
        case 92: break;
        case 40: 
          { System.out.printf("then "); return symbol(sym.TK_THEN);
          }
        case 93: break;
        case 41: 
          { System.out.printf("tdef "); return symbol(sym.TK_TDEF);
          }
        case 94: break;
        case 42: 
          { System.out.printf("fdef "); return symbol(sym.TK_FDEF);
          }
        case 95: break;
        case 43: 
          { System.out.printf("read "); return symbol(sym.TK_READ);
          }
        case 96: break;
        case 44: 
          { System.out.printf("char "); return symbol(sym.TK_CHAR);
          }
        case 97: break;
        case 45: 
          { System.out.printf("bool "); return symbol(sym.TK_BOOL);
          }
        case 98: break;
        case 46: 
          { System.out.printf("dict "); return symbol(sym.TK_DICTIONARY);
          }
        case 99: break;
        case 47: 
          { System.out.printf("else "); return symbol(sym.TK_ELSE);
          }
        case 100: break;
        case 48: 
          { System.out.printf("alias "); return symbol(sym.TK_ALIAS);
          }
        case 101: break;
        case 49: 
          { System.out.printf("float "); return symbol(sym.TK_FLOAT);
          }
        case 102: break;
        case 50: 
          { System.out.printf("print "); return symbol(sym.TK_PRINT);
          }
        case 103: break;
        case 51: 
          { System.out.printf("while "); return symbol(sym.TK_WHILE);
          }
        case 104: break;
        case 52: 
          { System.out.printf("forall "); return symbol(sym.TK_FORALL);
          }
        case 105: break;
        case 53: 
          { System.out.printf("return "); return symbol(sym.TK_RETURN);
          }
        case 106: break;
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
