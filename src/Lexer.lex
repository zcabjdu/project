/* JFlex example: part of Java language lexer specification */

import java_cup.runtime.*;
/**
 * This class is a simple example lexer.
 */
%%
%class Lexer
%unicode
%cup
%line
%column
%{
  StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
%}
NewLine        = \n
NonNewLineChar = [^\n]
WhiteSpace     = {NewLine} | [ \t\v\f\r]

Comment              = {OneLineComment} | {MultipleLinesComment}
OneLineComment       = "#" {NonNewLineChar}* {NewLine}
MultipleLinesComment = "/#" ~"#/"

/*TODO: CHAR_constant*/
BooleanConstant   = "T" | "F"
IntegerConstant   = -?[0-9]+

Identifier         = [a-zA-Z][a-zA-Z0-9_]*



/* TODO: floats, rats */
Number = {IntegerConstant}



%%

<YYINITIAL> {
  "("                            {System.out.println("("); return symbol(sym.TK_LPAREN);}
  ")"                            {System.out.println(")"); return symbol(sym.TK_RPAREN);}
  "{"                            {System.out.println("{"); return symbol(sym.TK_LBRACE);}
  "}"                            {System.out.println("}"); return symbol(sym.TK_RBRACE);}
  "["                            {System.out.println("["); return symbol(sym.TK_LBRACKET);}
  "]"                            {System.out.println("]"); return symbol(sym.TK_RBRACKET);}
  ";"                            {System.out.println(";"); return symbol(sym.TK_SEMI);}
  ":"                            {System.out.println(":"); return symbol(sym.TK_COLON);}
  ","                            {System.out.println(","); return symbol(sym.TK_COMMA);}
  "-"                            {System.out.println("-"); return symbol(sym.TK_MINUS);}
  "+"                            {System.out.println("("); return symbol(sym.TK_PLUS);}
  "*"                            {System.out.println("("); return symbol(sym.TK_TIMES);}
  "/"                            {System.out.println("("); return symbol(sym.TK_DIVIDE);}
  "^"                            {System.out.println("("); return symbol(sym.TK_POWER);}
  "="                            {System.out.println("("); return symbol(sym.TK_EQUALS);}
  ":="                           {System.out.println(":="); return sybol(sym.TK_ASSIGNMENT);}
  "=>"                           {System.out.println("("); return symbol(sym.TK_THEN);}
  "="                            {System.out.println("("); return symbol(sym.TK_EQUALS);}
  "!="                           {System.out.println("("); return symbol(sym.TK_NOTEQUALS);}
  "<="                           {System.out.println("("); return symbol(sym.TK_SEQUALS);}
  "<"                            {System.out.println("("); return symbol(sym.TK_SMALLER);}
  "int"                          {System.out.println("("); return symbol(sym.TK_INT);}
  "float"                        {System.out.println("("); return symbol(sym.TK_FLOAT);}
  "rat"                          {System.out.println("("); return symbol(sym.TK_RAT);}
  "char"                         {System.out.println("("); return symbol(sym.TK_CHAR);}
  "bool"                         {System.out.println("("); return symbol(sym.TK_BOOL);}
  "dict"                         {System.out.println("("); return symbol(sym.TK_DICTIONARY);}
  "seq"                          {System.out.println("("); return symbol(sym.TK_SEQUENCE);}
  "in"                           {System.out.println("("); return symbol(sym.TK_IN);}
  "len"                          {System.out.println("("); return symbol(sym.TK_LEN);}
  "tdef"                         {System.out.println("("); return symbol(sym.TK_TDEF);}
  "fdef"                         {System.out.println("("); return symbol(sym.TK_FDEF);}
  ">"                            {System.out.println("("); return symbol(sym.TK_LARGER);}
  "alias"                        {System.out.println("alias"); return symbol(sym.TK_ALIAS);}
  "return"                       {System.out.println("return"); return symbol(sym.TK_RETURN);}
  {Comment}                      {}
  {WhiteSpace}                   {}
  {Number}                       {System.out.println("("); return symbol(sym.TK_NUMBER, new Integer(yytext()));}
  {BooleanConstant}              {System.out.println("("); return symbol(sym.TK_BOOLEAN_CONSTANT, new Boolean("T".equals(yytext())));}
  {Identifier}                   {System.out.println("("); return symbol(sym.TK_IDENTIFIER);}
}
