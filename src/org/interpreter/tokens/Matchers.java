package org.interpreter.tokens;

public class Matchers {
    public static final TokenMatcher integer_type = new TokenMatcher(TokenType.INTEGER);
    public static final TokenMatcher float_type = new TokenMatcher(TokenType.FLOAT);
    public static final TokenMatcher boolean_type = new TokenMatcher(TokenType.BOOLEAN);
    public static final TokenMatcher void_type = new TokenMatcher(TokenType.VOID);

    public static final TokenMatcher plus_type = new TokenMatcher(TokenType.PLUS);
    public static final TokenMatcher minus_type = new TokenMatcher(TokenType.MINUS);
    public static final TokenMatcher asterisk_type = new TokenMatcher(TokenType.ASTERISK);
    public static final TokenMatcher slash_type = new TokenMatcher(TokenType.SLASH);
    public static final TokenMatcher colon_type = new TokenMatcher(TokenType.COLON);
    public static final TokenMatcher semicolon_type = new TokenMatcher(TokenType.SEMICOLON);
    public static final TokenMatcher lpar_type = new TokenMatcher(TokenType.LPAR);
    public static final TokenMatcher rpar_type = new TokenMatcher(TokenType.RPAR);

    public static final TokenMatcher identifier_type = new TokenMatcher(TokenType.IDENTIFIER);
    public static final TokenMatcher new_integer_type = new TokenMatcher(TokenType.NEW_INTEGER);
    public static final TokenMatcher new_float_type = new TokenMatcher(TokenType.NEW_FLOAT);
    public static final TokenMatcher new_string_type = new TokenMatcher(TokenType.NEW_STRING);
    public static final TokenMatcher new_boolean_type = new TokenMatcher(TokenType.NEW_BOOLEAN);

    public static final TokenMatcher quote_type = new TokenMatcher(TokenType.QUOTE);
    public static final TokenMatcher eol_type = new TokenMatcher(TokenType.EOL);
}
