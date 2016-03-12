package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

public class OneOrMany extends NumberOrMany {
    public static final char IDENTIFIER = '+';

    public OneOrMany(int maxLength) {
        super(maxLength);
    }

    public void operate(Stack<String> result) {
        super.operate(result, 1);
    }
}