package saxion.pti.generated;

import java_cup.runtime.Symbol;

/**
 * Lexer settings
 * TODO: Debug uitzetten
 */
%%
%public
%cup
/* %debug */
%line
%column

%{
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
%}

/**
 * Algemene input tokens
 */
lineTerminator = \r|\n|\r\n
inputCharacter = [^\r\n]
whiteSpace     = {lineTerminator} | [ \t\f]

/**
 * Commentaar uitfilteren macro
 */
comment = {inlineComment} | {lineComment} | {blockComment}
inlineComment   		  = "/*" [^*] ~"*/" | "/*" "*"+ "/"
lineComment     		  = "//" {inputCharacter}* {lineTerminator}
blockComment   			  = "/**" {blockCommentContent} "*"+ "/"
blockCommentContent       = ( [^*] | \*+ [^/*] )*

identifier	  = [:jletter:] [:jletterdigit:]*
staticInteger = 0 | [1-9][0-9]*
%state STRING
%%

/**
 * Native functies
 */
<YYINITIAL> "println" 			 { return newSymbol(sym.FUNC_PRINTLN); }

/**
 * Standaard structuur tokens
 */
<YYINITIAL> "else"               { return newSymbol(sym.ELSE); }
<YYINITIAL> "if"                 { return newSymbol(sym.IF); }
<YYINITIAL> "boolean"            { return newSymbol(sym.SYM_BOOLEAN); }
<YYINITIAL> "string"             { return newSymbol(sym.SYM_STRING); }
<YYINITIAL> "int"                { return newSymbol(sym.SYM_INT); }
<YYINITIAL> "while"              { return newSymbol(sym.WHILE); }
<YYINITIAL> "void"               { return newSymbol(sym.VOID); }
<YYINITIAL> "static"             { return newSymbol(sym.STATIC); }
<YYINITIAL> "return"             { return newSymbol(sym.RETURN); }
<YYINITIAL>  "true"				 { return newSymbol(sym.TRUE); }
<YYINITIAL> "false"				 { return newSymbol(sym.FALSE); }

<YYINITIAL> {
  /**
   * Identifiers
   */
  {identifier}                   { return newSymbol(sym.IDENTIFIER, new String(yytext())); }
 
  /**
   * Nummers
   */
  {staticInteger}            	 { return newSymbol(sym.STATIC_INT, Integer.parseInt(yytext())); }
  
  /**
   * Strings
   */
  \"                             { stringBuffer.setLength(0); yybegin(STRING); }

  /**
   * Operators 
   */
  "!="                           { return newSymbol(sym.NEQ); }
  "="                            { return newSymbol(sym.EQ); }
  "=="                           { return newSymbol(sym.EQEQ); }
  "+"                            { return newSymbol(sym.PLUS); }
  "-"                            { return newSymbol(sym.MINUS); }
  "*"                            { return newSymbol(sym.ASTERICK); }
  "%"                            { return newSymbol(sym.MOD); }
  "/"                            { return newSymbol(sym.FSLASH); }
  "\\"                           { return newSymbol(sym.BSLASH); }
  "<"                            { return newSymbol(sym.LESS); }
  "<="                           { return newSymbol(sym.LESSEQ); }
  ">"                            { return newSymbol(sym.GREATER); }
  ">="                           { return newSymbol(sym.GREATEREQ); }
  "("                            { return newSymbol(sym.LPAREN); }
  ")"                            { return newSymbol(sym.RPAREN); }
  "{"                            { return newSymbol(sym.LBRACE); }
  "}"                            { return newSymbol(sym.RBRACE); }
  "["                            { return newSymbol(sym.LSQPAREN); }
  "]"                            { return newSymbol(sym.RSQPAREN); }
  ","                            { return newSymbol(sym.COMMA); }
  ";"                            { return newSymbol(sym.SEMICOLON); }

  /**
   * Commentaar
   */
  {comment}                      { /* ignore */ }
 
  /**
   * Spaties
   */
  {whiteSpace}                   { /* ignore */ }
}

/**
 * String declaratie
 */
<STRING> {
  \"                             { yybegin(YYINITIAL); 
                                   return newSymbol(sym.STATIC_STRING, 
                                   stringBuffer.toString()); }
  [^\n\r\"\\]+                   { stringBuffer.append( yytext() ); }
  \\t                            { stringBuffer.append('\t'); }
  \\n                            { stringBuffer.append('\n'); }

  \\r                            { stringBuffer.append('\r'); }
  \\\"                           { stringBuffer.append('\"'); }
  \\                             { stringBuffer.append('\\'); }
}

/**
 * Fout terugkoppeling 
 */
.|\n                             { throw new Error("Illegal character: " + yytext()); }
                                                    