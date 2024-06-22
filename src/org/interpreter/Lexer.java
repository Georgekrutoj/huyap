package org.interpreter;

import org.interpreter.tokens.Token;
import org.interpreter.tokens.TokenType;

import java.util.LinkedList;

import static org.interpreter.tokens.Matchers.*;

public class Lexer {
    private final String code;
    private final int length;
    private int position;
    private LinkedList<Token> tokenList;
    private char currentChar;

    public Lexer() {
        this("", -1);
    }

    public Lexer(String code) {
        this(code, -1);
    }

    public Lexer(int position) {
        this("", position);
    }

    public Lexer(String code, int position) {
        this.code = code;
        this.length = code.length();
        this.position = position;
        this.tokenList = new LinkedList<>();
    }

    public String getCode() {
        return code;
    }

    public int getLength() {
        return length;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public LinkedList<Token> getTokenList() {
        return tokenList;
    }

    public void setTokenList(LinkedList<Token> tokenList) {
        this.tokenList = tokenList;
    }

    public char getCurrentChar() {
        return currentChar;
    }

    public void setCurrentChar(char currentChar) {
        this.currentChar = currentChar;
    }

    public LinkedList<Token> tokenize() {
        while (advance()) {
            currentChar = peek();

            if (plus_type.match(currentChar)) {
                addToken(TokenType.PLUS, "+");
            } else if (minus_type.match(currentChar)) {
                addToken(TokenType.MINUS, "-");
            } else if (asterisk_type.match(currentChar)) {
                addToken(TokenType.ASTERISK, "*");
            } else if (slash_type.match(currentChar)) {
                addToken(TokenType.SLASH, "/");
            } else if (colon_type.match(currentChar)){
                addToken(TokenType.COLON, ":");
            } else if (semicolon_type.match(currentChar)) {
                addToken(TokenType.SEMICOLON, ";");
            } else if (lpar_type.match(currentChar)) {
              addToken(TokenType.LPAR, "(");
            } else if (rpar_type.match(currentChar)) {
                addToken(TokenType.RPAR, ")");
            } else if (quote_type.match(currentChar)) {
                tokenizeString();
            } else if (integer_type.match(currentChar) || currentChar == '.') {
                tokenizeNumber();
            }
        }

        return tokenList;
    }



    private void tokenizeString() {
        StringBuilder stringToTokenize = new StringBuilder();

        next();

        while (currentChar != '"' && !isEndOfFile()) {
            while (Character.isWhitespace(currentChar)) {
                skip();
            }

            if (currentChar == '\\') {
                try {
                    switch (peek(1)) {
                        case 'н':
                            stringToTokenize.append('\n');
                        case 'в':
                            stringToTokenize.append('\r');
                        case '"':
                            stringToTokenize.append('\"');
                    }

                    for (int i = 0; i < 2; i++) {
                        next();
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    break;
                }
            } else {
                stringToTokenize.append(currentChar);
                next();
            }
        }

        addToken(TokenType.STRING, stringToTokenize.toString());
    }

    private void tokenizeNumber() {
        StringBuilder numberToTokenize = new StringBuilder();
        boolean isHasDot = false;

        while (true) {
            if (currentChar == '.') {
                if (isHasDot) throw new NumberFormatException("У числа уже есть точка: " + numberToTokenize);

                isHasDot = true;
            } else if (!integer_type.match(currentChar)) {
                break;
            }

            numberToTokenize.append(currentChar);
            next();
        }

        final String stringNumber = numberToTokenize.toString();

        if (integer_type.match(stringNumber)) {
            addToken(TokenType.INTEGER, stringNumber);
        } else if (float_type.match(stringNumber)) {
            addToken(TokenType.FLOAT, stringNumber);
        }
    }

    private void addToken(TokenType type, String value) {
        tokenList.add(new Token(type, value));
    }

    private void next() {
        advance();
        currentChar = peek();
    }

    private char peek() throws StringIndexOutOfBoundsException {
        return peek(0);
    }

    private char peek(int relativePosition) throws StringIndexOutOfBoundsException {
        return code.charAt(position + relativePosition);
    }

    private boolean advance() {
        return advance(1);
    }

    private boolean advance(int relativePosition) {
        if (!isEndOfFile()) {
            position += relativePosition;
            return true;
        }

        return false;
    }

    private boolean isEndOfFile() {
        return isEndOfFile(1);
    }

    private boolean isEndOfFile(int relativePosition) {
        return position + relativePosition >= length;
    }

    private void skip() {
        advance();
        currentChar = peek();
    }
}
