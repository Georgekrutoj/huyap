package org.test;

import org.interpreter.Lexer;
import org.interpreter.tokens.Token;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer("2.0 * (1 + 3) след");

        LinkedList<Token> tokenized = lexer.tokenize();

        for (Token token : tokenized) {
            System.out.println(token);
        }
    }
}
