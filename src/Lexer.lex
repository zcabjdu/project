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
IntegerConstant   = [0-9]+
StringConstant    = "\"" ~"\""

Identifier         = [a-zA-Z][a-zA-Z0-9_]*

/* Ugly but needed to deal with the shift/reduce conflict when parsing the body */
HalfDeclaration    = {Identifier}{WhiteSpace}*":" | {Identifier}{WhiteSpace}*":"[:=]


/* TODO: floats, rats */
Number = {IntegerConstant}



%%

<YYINITIAL> {
  "("                            {System.out.printf("( "); return symbol(sym.TK_LPAREN);}
  ")"                            {System.out.printf(") "); return symbol(sym.TK_RPAREN);}
  "{"                            {System.out.printf("{ "); return symbol(sym.TK_LBRACE);}
  "}"                            {System.out.printf("} "); return symbol(sym.TK_RBRACE);}
  "&&"                           {System.out.printf("&& "); return symbol(sym.TK_AND);}
  "||"                           {System.out.printf("|| "); return symbol(sym.TK_OR);}
  "["                            {System.out.printf("[ "); return symbol(sym.TK_LBRACKET);}
  "]"                            {System.out.printf("] "); return symbol(sym.TK_RBRACKET);}
  ":="                           {System.out.printf(":= "); return symbol(sym.TK_ASSIGNMENT);}
  ";"                            {System.out.printf("; "); return symbol(sym.TK_SEMI);}
  "::"                            {System.out.printf(":: "); return symbol(sym.TK_COLON_COLON);}
  ":"                            {System.out.printf(": "); return symbol(sym.TK_COLON);}
  ","                            {System.out.printf(", "); return symbol(sym.TK_COMMA);}
  "-"                            {System.out.printf("- "); return symbol(sym.TK_MINUS);}
  "+"                            {System.out.printf("+ "); return symbol(sym.TK_PLUS);}
  "*"                            {System.out.printf("* "); return symbol(sym.TK_TIMES);}
  "/"                            {System.out.printf("/ "); return symbol(sym.TK_DIVIDE);}
  "^"                            {System.out.printf("^ "); return symbol(sym.TK_POWER);}
  "="                            {System.out.printf("= "); return symbol(sym.TK_EQUALS);}
  "=>"                           {System.out.printf("=> "); return symbol(sym.TK_IMPLICATION);}
  "="                            {System.out.printf("= "); return symbol(sym.TK_EQUALS);}
  "!="                           {System.out.printf("!= "); return symbol(sym.TK_NOTEQUALS);}
  "!"                            {System.out.printf("! "); return symbol(sym.TK_NOT);}
  "<="                           {System.out.printf("<= "); return symbol(sym.TK_SEQUALS);}
  "<"                            {System.out.printf("< "); return symbol(sym.TK_SMALLER);}
  "main"                         {System.out.printf("main "); return symbol(sym.TK_MAIN);}
  "int"                          {System.out.printf("int "); return symbol(sym.TK_INT);}
  "float"                        {System.out.printf("float "); return symbol(sym.TK_FLOAT);}
  "rat"                          {System.out.printf("rat "); return symbol(sym.TK_RAT);}
  "char"                         {System.out.printf("char "); return symbol(sym.TK_CHAR);}
  "bool"                         {System.out.printf("bool "); return symbol(sym.TK_BOOL);}
  "dict"                         {System.out.printf("dict "); return symbol(sym.TK_DICTIONARY);}
  "seq"                          {System.out.printf("seq "); return symbol(sym.TK_SEQUENCE);}
  "in"                           {System.out.printf("in "); return symbol(sym.TK_IN);}
  "len"                          {System.out.printf("len "); return symbol(sym.TK_LEN);}
  "tdef"                         {System.out.printf("tdef "); return symbol(sym.TK_TDEF);}
  "fdef"                         {System.out.printf("fdef "); return symbol(sym.TK_FDEF);}
  ">"                            {System.out.printf("> "); return symbol(sym.TK_LARGER);}
  "alias"                        {System.out.printf("alias "); return symbol(sym.TK_ALIAS);}
  "return"                       {System.out.printf("return "); return symbol(sym.TK_RETURN);}
  "read"                         {System.out.printf("read "); return symbol(sym.TK_READ);}
  "print"                        {System.out.printf("print "); return symbol(sym.TK_PRINT);}
  "if"                           {System.out.printf("if "); return symbol(sym.TK_IF);}
  "fi"                           {System.out.printf("fi "); return symbol(sym.TK_FI);}
  "then"                         {System.out.printf("then "); return symbol(sym.TK_THEN);}
  "else"                         {System.out.printf("else "); return symbol(sym.TK_ELSE);}
  "while"                        {System.out.printf("while "); return symbol(sym.TK_WHILE);}
  "do"                           {System.out.printf("do "); return symbol(sym.TK_DO);}
  "od"                           {System.out.printf("od "); return symbol(sym.TK_OD);}
  "forall"                       {System.out.printf("forall "); return symbol(sym.TK_FORALL);}
  {StringConstant}               
  {
      String str = yytext();
      str = str.substring(1, str.length() - 1);
      System.out.printf(str + " ");
      return symbol(sym.TK_STRING_CONSTANT, str);
  }

  {Comment}                      {}
  {WhiteSpace}                   {}
  {Number}                       {System.out.printf(yytext() + " "); return symbol(sym.TK_STRING_CONSTANT, new Integer(yytext()));}
  {BooleanConstant}              {System.out.printf(yytext() + " "); return symbol(sym.TK_BOOLEAN_CONSTANT, new Boolean("T".equals(yytext())));}
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
            System.out.printf(prefix + " ");
            return symbol(sym.TK_IDENTIFIER, prefix);
        }
      }
      System.out.printf(yytext() + " ");
      return symbol(sym.TK_HALF_DECLARATION, yytext().substring(0, yytext().length() - 1));
  }
  {Identifier}                   {System.out.printf(yytext() + " "); return symbol(sym.TK_IDENTIFIER, yytext());}
}
