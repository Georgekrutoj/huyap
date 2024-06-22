package org.interpreter.ast;

import org.interpreter.tokens.Token;

public class Integer extends Value<java.lang.Integer> {
    public Integer(int value, Token token) {
        super(value, token);
    }
}
