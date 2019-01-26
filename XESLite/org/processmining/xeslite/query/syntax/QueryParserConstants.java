/* Generated By:JJTree&JavaCC: Do not edit this line. QueryParserConstants.java */
package org.processmining.xeslite.query.syntax;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface QueryParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int AND = 5;
  /** RegularExpression Id. */
  int OR = 6;
  /** RegularExpression Id. */
  int LPAREN = 7;
  /** RegularExpression Id. */
  int RPAREN = 8;
  /** RegularExpression Id. */
  int EQUAL = 9;
  /** RegularExpression Id. */
  int CONTAINS = 10;
  /** RegularExpression Id. */
  int REGEX = 11;
  /** RegularExpression Id. */
  int NOTEQUAL = 12;
  /** RegularExpression Id. */
  int GT = 13;
  /** RegularExpression Id. */
  int LT = 14;
  /** RegularExpression Id. */
  int LTE = 15;
  /** RegularExpression Id. */
  int GTE = 16;
  /** RegularExpression Id. */
  int DOT = 17;
  /** RegularExpression Id. */
  int INTEGER_LITERAL = 18;
  /** RegularExpression Id. */
  int DECIMAL_LITERAL = 19;
  /** RegularExpression Id. */
  int HEX_LITERAL = 20;
  /** RegularExpression Id. */
  int OCTAL_LITERAL = 21;
  /** RegularExpression Id. */
  int FLOATING_POINT_LITERAL = 22;
  /** RegularExpression Id. */
  int EXPONENT = 23;
  /** RegularExpression Id. */
  int STRING_LITERAL = 24;
  /** RegularExpression Id. */
  int IDENTIFIER = 25;
  /** RegularExpression Id. */
  int LETTER = 26;
  /** RegularExpression Id. */
  int DIGIT = 27;
  /** RegularExpression Id. */
  int SPECIALCHAR = 28;
  /** RegularExpression Id. */
  int UNKNOWN = 29;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\r\"",
    "\"\\n\"",
    "\"and\"",
    "\"or\"",
    "\"(\"",
    "\")\"",
    "\"=\"",
    "\"%\"",
    "\"~\"",
    "\"!=\"",
    "\">\"",
    "\"<\"",
    "\"<=\"",
    "\">=\"",
    "\".\"",
    "<INTEGER_LITERAL>",
    "<DECIMAL_LITERAL>",
    "<HEX_LITERAL>",
    "<OCTAL_LITERAL>",
    "<FLOATING_POINT_LITERAL>",
    "<EXPONENT>",
    "<STRING_LITERAL>",
    "<IDENTIFIER>",
    "<LETTER>",
    "<DIGIT>",
    "<SPECIALCHAR>",
    "<UNKNOWN>",
  };

}