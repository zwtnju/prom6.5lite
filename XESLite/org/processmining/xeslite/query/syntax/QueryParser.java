/* QueryParser.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. QueryParser.java */
package org.processmining.xeslite.query.syntax;

import java.io.StringReader;

public class QueryParser/*@bgen(jjtree)*/implements QueryParserTreeConstants, QueryParserConstants {/*@bgen(jjtree)*/
  protected JJTQueryParserState jjtree = new JJTQueryParserState();
    public QueryParser(String s) {
        this(new StringReader(s));
    }

  final public QueryRoot parse() throws ParseException {/*@bgen(jjtree) Root */
  QueryRoot jjtn000 = new QueryRoot(JJTROOT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      orExpression();
      jj_consume_token(0);
jjtree.closeNodeScope(jjtn000, true);
                           jjtc000 = false;
{if ("" != null) return jjtn000;}
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public void orExpression() throws ParseException {
    andExpression();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case OR:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
QueryBinaryLogicalExpression jjtn001 = new QueryBinaryLogicalExpression(JJTBINARYLOGICALEXPRESSION);
                  boolean jjtc001 = true;
                  jjtree.openNodeScope(jjtn001);
      try {
        jjtn001.op = jj_consume_token(OR).image;
        andExpression();
      } catch (Throwable jjte001) {
if (jjtc001) {
                    jjtree.clearNodeScope(jjtn001);
                    jjtc001 = false;
                  } else {
                    jjtree.popNode();
                  }
                  if (jjte001 instanceof RuntimeException) {
                    {if (true) throw (RuntimeException)jjte001;}
                  }
                  if (jjte001 instanceof ParseException) {
                    {if (true) throw (ParseException)jjte001;}
                  }
                  {if (true) throw (Error)jjte001;}
      } finally {
if (jjtc001) {
                    jjtree.closeNodeScope(jjtn001,  2);
                  }
      }
    }
  }

  final public void andExpression() throws ParseException {
    term();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case AND:{
        ;
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
QueryBinaryLogicalExpression jjtn001 = new QueryBinaryLogicalExpression(JJTBINARYLOGICALEXPRESSION);
                  boolean jjtc001 = true;
                  jjtree.openNodeScope(jjtn001);
      try {
        jjtn001.op = jj_consume_token(AND).image;
        term();
      } catch (Throwable jjte001) {
if (jjtc001) {
                    jjtree.clearNodeScope(jjtn001);
                    jjtc001 = false;
                  } else {
                    jjtree.popNode();
                  }
                  if (jjte001 instanceof RuntimeException) {
                    {if (true) throw (RuntimeException)jjte001;}
                  }
                  if (jjte001 instanceof ParseException) {
                    {if (true) throw (ParseException)jjte001;}
                  }
                  {if (true) throw (Error)jjte001;}
      } finally {
if (jjtc001) {
                    jjtree.closeNodeScope(jjtn001,  2);
                  }
      }
    }
  }

  final public void term() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case STRING_LITERAL:
    case IDENTIFIER:{
      simpleExpression();
      break;
      }
    case LPAREN:{
      jj_consume_token(LPAREN);
      orExpression();
      jj_consume_token(RPAREN);
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void simpleExpression() throws ParseException {/*@bgen(jjtree) SimpleExpression */
  QuerySimpleExpression jjtn000 = new QuerySimpleExpression(JJTSIMPLEEXPRESSION);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      if (jj_2_1(2)) {
        eventName();
        jj_consume_token(DOT);
      } else {
        ;
      }
      attributeName();
      jjtn000.op = op();
      value();
    } catch (Throwable jjte000) {
if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  final public void eventName() throws ParseException {/*@bgen(jjtree) Atom */
        QueryAtom jjtn000 = new QueryAtom(JJTATOM);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);Token val;
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IDENTIFIER:{
        val = jj_consume_token(IDENTIFIER);
jjtree.closeNodeScope(jjtn000, true);
                          jjtc000 = false;
jjtn000.val = val.image;
        break;
        }
      case STRING_LITERAL:{
        val = jj_consume_token(STRING_LITERAL);
jjtree.closeNodeScope(jjtn000, true);
                          jjtc000 = false;
jjtn000.val = val.image.substring(1, val.image.length() - 1);
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  final public void attributeName() throws ParseException {/*@bgen(jjtree) Atom */
        QueryAtom jjtn000 = new QueryAtom(JJTATOM);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);Token val;
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IDENTIFIER:{
        val = jj_consume_token(IDENTIFIER);
jjtree.closeNodeScope(jjtn000, true);
                          jjtc000 = false;
jjtn000.val = val.image;
        break;
        }
      case STRING_LITERAL:{
        val = jj_consume_token(STRING_LITERAL);
jjtree.closeNodeScope(jjtn000, true);
                          jjtc000 = false;
jjtn000.val = val.image.substring(1, val.image.length() - 1);
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  final public void value() throws ParseException {/*@bgen(jjtree) Atom */
        QueryAtom jjtn000 = new QueryAtom(JJTATOM);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);Token val;
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case IDENTIFIER:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IDENTIFIER:{
          val = jj_consume_token(IDENTIFIER);
          break;
          }
        case INTEGER_LITERAL:{
          val = jj_consume_token(INTEGER_LITERAL);
          break;
          }
        case FLOATING_POINT_LITERAL:{
          val = jj_consume_token(FLOATING_POINT_LITERAL);
          break;
          }
        default:
          jj_la1[5] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
jjtree.closeNodeScope(jjtn000, true);
                          jjtc000 = false;
jjtn000.val = val.image;
        break;
        }
      case STRING_LITERAL:{
        val = jj_consume_token(STRING_LITERAL);
jjtree.closeNodeScope(jjtn000, true);
                          jjtc000 = false;
jjtn000.val = val.image.substring(1, val.image.length() - 1);
        break;
        }
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  final public String op() throws ParseException {Token op;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case EQUAL:{
      op = jj_consume_token(EQUAL);
      break;
      }
    case CONTAINS:{
      op = jj_consume_token(CONTAINS);
      break;
      }
    case REGEX:{
      op = jj_consume_token(REGEX);
      break;
      }
    case NOTEQUAL:{
      op = jj_consume_token(NOTEQUAL);
      break;
      }
    case GT:{
      op = jj_consume_token(GT);
      break;
      }
    case LT:{
      op = jj_consume_token(LT);
      break;
      }
    case LTE:{
      op = jj_consume_token(LTE);
      break;
      }
    case GTE:{
      op = jj_consume_token(GTE);
      break;
      }
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return op.image;}
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_3R_3()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_4()) {
    jj_scanpos = xsp;
    if (jj_3R_5()) return true;
    }
    return false;
  }

  private boolean jj_3_1()
 {
    if (jj_3R_3()) return true;
    if (jj_scan_token(DOT)) return true;
    return false;
  }

  private boolean jj_3R_4()
 {
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  private boolean jj_3R_5()
 {
    if (jj_scan_token(STRING_LITERAL)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public QueryParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[8];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x40,0x20,0x3000080,0x3000000,0x3000000,0x2440000,0x3440000,0x1fe00,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public QueryParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public QueryParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new QueryParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public QueryParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new QueryParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public QueryParser(QueryParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(QueryParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  @SuppressWarnings("serial")
  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[30];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 8; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 30; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
