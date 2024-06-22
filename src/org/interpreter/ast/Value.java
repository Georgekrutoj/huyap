package org.interpreter.ast;

import org.interpreter.tokens.Token;

public abstract class Value<T> implements Expression<T> {
    protected final T value;
    protected final Token token;

    public Value(T value, Token token) {
        this.value = value;
        this.token = token;
    }

    @Override
    public String toString() {
        return "Value{" +
                "value=" + value +
                ", token=" + token +
                '}';
    }

    public T getValue() {
        return value;
    }

    public Token getToken() {
        return token;
    }

    public T eval() {
        return value;
    }
}
