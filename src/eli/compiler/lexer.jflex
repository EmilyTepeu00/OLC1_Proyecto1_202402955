// --- ANALIZADOR LEXICO ---
// Reglas para convertir el codigo fuente en tokens para utilizarlos en el analizador sintactico (CUP)

package eli.compiler;

import java_cup.runtime.*;

%%

// DIRECTIVAS DE CONFIGURACION
%public         // Clase publica
%class Lexer    // Nombre de la clase
%cup            // Compatibilidad con CUP
%line           // Contar numero de lineas
%column         // Contar numero de columnas
%unicode        // Soporte para caracteres Unicode

%{
    
    // METODOS PARA CREAR SIMBOLOS

    // Crear simbolo sin valor (palabras reservadas o signos)
    private Symbol symbol(int type) {
        return new Symbol(type, yyline+1, yycolumn+1);
    }

    // Crear simbolo con valor (numeros, strings o identificadores)
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }
%}

// EXPRESIONES REGULARES PARA NUMEROS Y STRINGS (MACROS)
Entero = [0-9]+
Decimal = {Entero} \. {Entero}
Identificador = [a-zA-Z_][a-zA-Z0-9_]*
String = \"([^\"\\]|\\.)*\"
ComentarioLinea = "##".*
ComentarioMultilinea = "#*" ~"#*"
Espacio = [ \t\r\n\f]

%%

// REGLAS DE TOKENIZACION
// Cada regla tiene: PATRON { ACCION }
// Cuando el patron coincide, se ejecuta la accion y se retorna un token

// PALABRAS RESERVADAS DEL LENGUAJE
"database"      { return symbol(sym.DATABASE); }
"table"         { return symbol(sym.TABLE); }
"read"          { return symbol(sym.READ); }
"add"           { return symbol(sym.ADD); }
"update"        { return symbol(sym.UPDATE); }
"export"        { return symbol(sym.EXPORT); }
"use"           { return symbol(sym.USE); }
"clear"         { return symbol(sym.CLEAR); }
"fields"        { return symbol(sym.FIELDS); }
"filter"        { return symbol(sym.FILTER); }
"set"           { return symbol(sym.SET); }
"store"         { return symbol(sym.STORE); }
"at"            { return symbol(sym.AT); }
"true"          { return symbol(sym.BOOLEAN, true); }
"false"         { return symbol(sym.BOOLEAN, false); }

// TIPOS DE DATOS
"int"           { return symbol(sym.INT); }
"float"         { return symbol(sym.FLOAT); }
"string"        { return symbol(sym.STRING); }
"bool"          { return symbol(sym.BOOL); }
"array"         { return symbol(sym.ARRAY); }
"object"        { return symbol(sym.OBJECT); }
"null"          { return symbol(sym.NULL); }

// OPERADORES RELACIONALES
"=="            { return symbol(sym.EQ); }
"!="            { return symbol(sym.NEQ); }
">"             { return symbol(sym.GT); }
"<"             { return symbol(sym.LT); }
">="            { return symbol(sym.GTE); }
"<="            { return symbol(sym.LTE); }

// OPERADORES LOGICOS
"&&"            { return symbol(sym.AND); }     // Y logico
"||"            { return symbol(sym.OR); }      // O logico
"!"             { return symbol(sym.NOT); }     // Negacion

// SIGNOS DE AGRUPACION
"{"             { return symbol(sym.LBRACE); }
"}"             { return symbol(sym.RBRACE); }
"("             { return symbol(sym.LPAREN); }
")"             { return symbol(sym.RPAREN); }
"["             { return symbol(sym.LBRACKET); }
"]"             { return symbol(sym.RBRACKET); }
";"             { return symbol(sym.SEMICOLON); }
":"             { return symbol(sym.COLON); }
","             { return symbol(sym.COMMA); }
"."             { return symbol(sym.DOT); }
"="             { return symbol(sym.ASSIGN); }
"*"             { return symbol(sym.STAR); }

// PARA FIELDS
"*"             { return symbol(sym.STAR); }

// VALORES (numeros, strings, identificadores)
{Entero}        { return symbol(sym.ENTERO, Integer.parseInt(yytext())); }
{Decimal}       { return symbol(sym.DECIMAL, Double.parseDouble(yytext())); }
{String}        { 
                    // Eliminar las comillas al inicio y final
                    String str = yytext().substring(1, yytext().length()-1);
                    return symbol(sym.STRING_LITERAL, str); 
                 }
{Identificador} { return symbol(sym.IDENTIFICADOR, yytext()); }

// COMENTARIOS (se ignoran)
"##" [^\n]*                  { /* ignorar comentario de linea */ }
"#*" ~"*#"                   { /* ignorar comentario multilinea */ }
"#*" [^*]* ~"*#"             { /* ignorar comentario multilinea */ }

// IGNORAR ESPACIOS EN BLANCO (se ignoran)
[ \t\r\n\f]+       { /* ignorar */ }

// ERRORES LEXICOS (caracteres no reconocidos)
.                            { 
    System.err.println("Error lexico: Caracter invalido '" + yytext() + "' en linea " + (yyline+1) + ", columna " + (yycolumn+1)); 
}