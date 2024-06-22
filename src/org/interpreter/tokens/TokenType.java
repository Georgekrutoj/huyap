package org.interpreter.tokens;

public enum TokenType {
    INTEGER,
    FLOAT,
    STRING,
    BOOLEAN,
    VOID,

    PLUS,
    MINUS,
    ASTERISK, // *
    SLASH,
    COLON,
    SEMICOLON,
    LPAR,
    RPAR,

    IDENTIFIER,
    NEW_INTEGER,
    NEW_FLOAT,
    NEW_STRING,
    NEW_BOOLEAN,

    QUOTE, // "
    EOL
}
