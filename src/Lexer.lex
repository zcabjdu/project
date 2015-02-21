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
  "&&"                           {System.out.println("&&"); return symbol(sym.TK_AND);}
  "||"                           {System.out.println("||"); return symbol(sym.TK_OR);}
  "["                            {System.out.println("["); return symbol(sym.TK_LBRACKET);}
  "]"                            {System.out.println("]"); return symbol(sym.TK_RBRACKET);}
  ";"                            {System.out.println(";"); return symbol(sym.TK_SEMI);}
  ":"                            {System.out.println(":"); return symbol(sym.TK_COLON);}
  ","                            {System.out.println(","); return symbol(sym.TK_COMMA);}
  "-"                            {System.out.println("-"); return symbol(sym.TK_MINUS);}
  "+"                            {System.out.println("+"); return symbol(sym.TK_PLUS);}
  "*"                            {System.out.println("*"); return symbol(sym.TK_TIMES);}
  "/"                            {System.out.println("/"); return symbol(sym.TK_DIVIDE);}
  "^"                            {System.out.println("^"); return symbol(sym.TK_POWER);}
  "="                            {System.out.println("="); return symbol(sym.TK_EQUALS);}
  ":="                           {System.out.println(":="); return symbol(sym.TK_ASSIGNMENT);}
  "=>"                           {System.out.println("=>"); return symbol(sym.TK_IMPLICATION);}
  "="                            {System.out.println("="); return symbol(sym.TK_EQUALS);}
  "!="                           {System.out.println("!="); return symbol(sym.TK_NOTEQUALS);}
  "!"                            {System.out.println("!"); return symbol(sym.TK_NOT);}
  "<="                           {System.out.println("<="); return symbol(sym.TK_SEQUALS);}
  "<"                            {System.out.println("<"); return symbol(sym.TK_SMALLER);}
  "main"                         {System.out.println("main"); return symbol(sym.TK_MAIN);}
  "int"                          {System.out.println("int"); return symbol(sym.TK_INT);}
  "float"                        {System.out.println("float"); return symbol(sym.TK_FLOAT);}
  "rat"                          {System.out.println("rat"); return symbol(sym.TK_RAT);}
  "char"                         {System.out.println("char"); return symbol(sym.TK_CHAR);}
  "bool"                         {System.out.println("bool"); return symbol(sym.TK_BOOL);}
  "dict"                         {System.out.println("dict"); return symbol(sym.TK_DICTIONARY);}
  "seq"                          {System.out.println("seq"); return symbol(sym.TK_SEQUENCE);}
  "in"                           {System.out.println("in"); return symbol(sym.TK_IN);}
  "len"                          {System.out.println("len"); return symbol(sym.TK_LEN);}
  "tdef"                         {System.out.println("tdef"); return symbol(sym.TK_TDEF);}
  "fdef"                         {System.out.println("fdef"); return symbol(sym.TK_FDEF);}
  ">"                            {System.out.println(">"); return symbol(sym.TK_LARGER);}
  "alias"                        {System.out.println("alias"); return symbol(sym.TK_ALIAS);}
  "return"                       {System.out.println("return"); return symbol(sym.TK_RETURN);}
  "read"                         {System.out.println("read"); return symbol(sym.TK_READ);}
  "print"                        {System.out.println("print"); return symbol(sym.TK_PRINT);}
  "if"                           {System.out.println("if"); return symbol(sym.TK_IF);}
  "fi"                           {System.out.println("fi"); return symbol(sym.TK_FI);}
  "then"                         {System.out.println("then"); return symbol(sym.TK_THEN);}
  "else"                         {System.out.println("else"); return symbol(sym.TK_ELSE);}
  "while"                        {System.out.println("while"); return symbol(sym.TK_WHILE);}
  "do"                           {System.out.println("do"); return symbol(sym.TK_DO);}
  "od"                           {System.out.println("od"); return symbol(sym.TK_OD);}
  "forall"                       {System.out.println("forall"); return symbol(sym.TK_FORALL);}
  {Comment}                      {}
  {WhiteSpace}                   {}
  {Number}                       {System.out.println(yytext()); return symbol(sym.TK_NUMBER, new Integer(yytext()));}
  {BooleanConstant}              {System.out.println("("); return symbol(sym.TK_BOOLEAN_CONSTANT, new Boolean("T".equals(yytext())));}
  {Identifier}                   {System.out.println(yytext()); return symbol(sym.TK_IDENTIFIER, yytext());}
}
