package org.interpreter.tokens;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenMatcher {
    private final TokenType type;
    private final Pattern pattern;

    public static final HashMap<TokenType, String> patterns = new HashMap<>();

    static {
        patterns.put(TokenType.INTEGER, "\\d+");
        patterns.put(TokenType.FLOAT, "(?:\\d+)*\\.(?:\\d+)*");
        patterns.put(TokenType.STRING, ".+");
        patterns.put(TokenType.BOOLEAN, "(?:ПРАВДА|ЛОЖЬ)");
        patterns.put(TokenType.VOID, "ПУСТО");

        patterns.put(TokenType.PLUS, "\\+");
        patterns.put(TokenType.MINUS, "\\-");
        patterns.put(TokenType.ASTERISK, "\\*");
        patterns.put(TokenType.SLASH, "/");
        patterns.put(TokenType.COLON, ":");
        patterns.put(TokenType.SEMICOLON, ";");
        patterns.put(TokenType.LPAR, "\\(");
        patterns.put(TokenType.RPAR, "\\)");

        patterns.put(TokenType.IDENTIFIER, "(?:[А-Яа-я_]+(?:[0-9]+)*)+");
        patterns.put(TokenType.NEW_INTEGER, "ЦелЧисл");
        patterns.put(TokenType.NEW_FLOAT, "Дробь");
        patterns.put(TokenType.NEW_STRING, "Строка");
        patterns.put(TokenType.NEW_BOOLEAN, "Лог");

        patterns.put(TokenType.QUOTE, "\\\"");
        patterns.put(TokenType.EOL, "след");
    }

    public TokenMatcher(TokenType type) {
        this.type = type;
        this.pattern = Pattern.compile(TokenMatcher.patterns.get(type));
    }

    public TokenType getType() {
        return type;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public boolean match(char c) {
        Matcher matcher = this.pattern.matcher(Character.toString(c));
        return matcher.matches();
    }

    public boolean match(String text) {
        final Matcher matcher = this.pattern.matcher(text);
        return matcher.matches();
    }
}
