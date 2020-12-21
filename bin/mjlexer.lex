
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}

	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }

// Keywords
"program"   { return new_symbol(sym.PROG, yytext());}
"break" 	{ return new_symbol(sym.BREAK, yytext());}
"print" 	{ return new_symbol(sym.PRINT, yytext()); }
"return" 	{ return new_symbol(sym.RETURN, yytext()); }
"void" 		{ return new_symbol(sym.VOID, yytext()); }
"class"		{ return new_symbol(sym.CLASS, yytext()); }
"else"		{ return new_symbol(sym.ELSE, yytext()); }
"const"		{ return new_symbol(sym.CONST, yytext()); }
"if"		{ return new_symbol(sym.IF, yytext()); }
"switch"		{ return new_symbol(sym.SWITCH, yytext()); }
"do"		{ return new_symbol(sym.DO, yytext()); }
"while"		{ return new_symbol(sym.WHILE, yytext()); }
"new"		{ return new_symbol(sym.NEW, yytext()); }
"read"		{ return new_symbol(sym.READ, yytext()); }
"extends"		{ return new_symbol(sym.EXTENDS, yytext()); }
"continue"		{ return new_symbol(sym.CONTINUE, yytext()); }
"case"		{ return new_symbol(sym.CASE, yytext()); }

// Operators
"+" 		{ return new_symbol(sym.PLUS, yytext()); }
"-"			{ return new_symbol(sym.MINUS, yytext()); }
"*"			{ return new_symbol(sym.MULTIPLY, yytext()); }
"/"			{ return new_symbol(sym.DIVIDE, yytext()); }
"%"			{ return new_symbol(sym.MODULO, yytext()); }
"=="		{return new_symbol(sym.EQUALS, yytext());	}
"!="		{return new_symbol(sym.NOT_EQUAL, yytext());	}
">"			{ return new_symbol(sym.LARGER_THAN, yytext()); }
">="		{ return new_symbol(sym.LARGER_EQUAL, yytext()); }
"<"			{ return new_symbol(sym.LESS_THAN, yytext()); }
"<="		{ return new_symbol(sym.LESS_EQUAL, yytext()); }
"&&"		{ return new_symbol(sym.AND, yytext()); }
"||"		{ return new_symbol(sym.OR, yytext()); }
"=" 		{ return new_symbol(sym.ASSIGN, yytext()); }
"++"		{return new_symbol(sym.INCREMENT, yytext()); }
"--"		{return new_symbol(sym.DECREMENT, yytext()); }
";"			{ return new_symbol(sym.SEMI, yytext()); }
"," 		{ return new_symbol(sym.COMMA, yytext()); }
"."			{ return new_symbol(sym.DOT, yytext()); }
"(" 		{ return new_symbol(sym.PARENTHESES_BEGIN, yytext()); }
")" 		{ return new_symbol(sym.PARENTHESES_END, yytext()); }
"{" 		{ return new_symbol(sym.BRACES_BEGIN, yytext()); }
"}"			{ return new_symbol(sym.BRACES_END, yytext()); }
"["			{ return new_symbol(sym.BRACKET_BEGIN, yytext()); }
"]"			{ return new_symbol(sym.BRACKET_END, yytext()); }
"?"			{ return new_symbol(sym.QUESTION_MARK, yytext());}
":" 		{ return new_symbol(sym.COLON, yytext()); }



"//" {yybegin(COMMENT);}
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

[0-9]+  { return new_symbol(sym.NUM_CONST, new Integer(Integer.parseInt(yytext()))); }
([a-z]|[A-Z])[a-z|A-Z|0-9|_]* 	{return new_symbol (sym.IDENT, yytext()); }
"'"[ -~]"'"		{ return new_symbol(sym.CHAR_CONST, new Character(yytext().charAt(1)));}
"true"|"false"	{ return new_symbol(sym.BOOL_CONST, new Boolean(Boolean.parseBool(yytext()))); }


. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)); }










