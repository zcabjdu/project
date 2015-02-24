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
BooleanConstant   = "T" | "F"
RationalConstant = {IntegerConstant}_{IntegerConstant}"/"{IntegerConstant}
IntegerConstant   = [0-9]+
StringConstant    = "\"" ~"\""
FloatConstant  = [0-9]+(\.[0-9]+)
Identifier         = [a-zA-Z][a-zA-Z0-9_]*
CharConstant      =\'[ -~]\'

// Ugly but needed to deal with the shift/reduce conflict when parsing the body
HalfDeclaration    = {Identifier}{WhiteSpace}*":"[:=]?

%%

<YYINITIAL> {
  "("                            {return symbol(sym.TK_LPAREN);}
  ")"                            {return symbol(sym.TK_RPAREN);}
  "{"                            {return symbol(sym.TK_LBRACE);}
  "}"                            {return symbol(sym.TK_RBRACE);}
  "&&"                           {return symbol(sym.TK_AND);}
  "||"                           {return symbol(sym.TK_OR);}
  "["                            {return symbol(sym.TK_LBRACKET);}
  "]"                            {return symbol(sym.TK_RBRACKET);}
  ":="                           {return symbol(sym.TK_ASSIGNMENT);}
  "."                            {return symbol(sym.TK_DOT);}
  ";"                            {return symbol(sym.TK_SEMI);}
  "::"                           {return symbol(sym.TK_COLON_COLON);}
  ":"                            {return symbol(sym.TK_COLON);}
  ","                            {return symbol(sym.TK_COMMA);}
  "-"                            {return symbol(sym.TK_MINUS);}
  "+"                            {return symbol(sym.TK_PLUS);}
  "*"                            {return symbol(sym.TK_TIMES);}
  "/"                            {return symbol(sym.TK_DIVIDE);}
  "^"                            {return symbol(sym.TK_POWER);}
  "="                            {return symbol(sym.TK_EQUALS);}
  "=>"                           {return symbol(sym.TK_IMPLICATION);}
  "="                            {return symbol(sym.TK_EQUALS);}
  "!="                           {return symbol(sym.TK_NOTEQUALS);}
  "!"                            {return symbol(sym.TK_NOT);}
  "<="                           {return symbol(sym.TK_SEQUALS);}
  "<"                            {return symbol(sym.TK_SMALLER);}
  "main"                         {return symbol(sym.TK_MAIN);}
  "int"                          {return symbol(sym.TK_INT);}
  "float"                        {return symbol(sym.TK_FLOAT);}
  "rat"                          {return symbol(sym.TK_RAT);}
  "char"                         {return symbol(sym.TK_CHAR);}
  "bool"                         {return symbol(sym.TK_BOOL);}
  "dict"                         {return symbol(sym.TK_DICTIONARY);}
  "seq"                          {return symbol(sym.TK_SEQUENCE);}
  "in"                           {return symbol(sym.TK_IN);}
  "len"                          {return symbol(sym.TK_LEN);}
  "tdef"                         {return symbol(sym.TK_TDEF);}
  "fdef"                         {return symbol(sym.TK_FDEF);}
  ">"                            {return symbol(sym.TK_LARGER);}
  "alias"                        {return symbol(sym.TK_ALIAS);}
  "return"                       {return symbol(sym.TK_RETURN);}
  "read"                         {return symbol(sym.TK_READ);}
  "print"                        {return symbol(sym.TK_PRINT);}
  "if"                           {return symbol(sym.TK_IF);}
  "fi"                           {return symbol(sym.TK_FI);}
  "then"                         {return symbol(sym.TK_THEN);}
  "else"                         {return symbol(sym.TK_ELSE);}
  "while"                        {return symbol(sym.TK_WHILE);}
  "do"                           {return symbol(sym.TK_DO);}
  "od"                           {return symbol(sym.TK_OD);}
  "forall"                       {return symbol(sym.TK_FORALL);}
  "top"                          {return symbol(sym.TK_TOP);}
  {CharConstant}                 {return symbol(sym.TK_CHAR_CONSTANT, yytext().substring(1, 2));}
  {StringConstant}               
  {
      String str = yytext();
      str = str.substring(1, str.length() - 1);
      ;
      return symbol(sym.TK_STRING_CONSTANT, str);
  }

  {Comment}                      {}
  {WhiteSpace}                   {}
  {RationalConstant}             {return symbol(sym.TK_RATIONAL_CONSTANT, new String(yytext()));}
  {FloatConstant}                {return symbol(sym.TK_FLOAT_CONSTANT, new Float(yytext()));}
  {IntegerConstant}              {return symbol(sym.TK_INTEGER_CONSTANT, new Integer(yytext()));}
  {BooleanConstant}              {return symbol(sym.TK_BOOLEAN_CONSTANT, new Boolean("T".equals(yytext())));}
  {HalfDeclaration}              
  {
      String res = yytext();
      if (res.length() > 2)
      {
        if (res.substring(res.length() - 2).equals(":=") || res.substring(res.length() - 2).equals("::"))
        {
            String prefix = "";
            int idx = 0;
            while(res.charAt(idx) != ' ' && res.charAt(idx) != ':')
            {
                prefix += res.charAt(idx++);
            }
            yypushback(res.length() - idx);
            return symbol(sym.TK_IDENTIFIER, prefix);
        }
      }
      ;
      return symbol(sym.TK_HALF_DECLARATION, yytext().substring(0, yytext().length() - 1));
  }
  {Identifier}                   {return symbol(sym.TK_IDENTIFIER, yytext());}
}
[^]                    {} 
