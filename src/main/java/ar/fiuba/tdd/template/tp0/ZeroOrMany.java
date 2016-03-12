package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

public class ZeroOrMany extends NumberOrMany {
    public static final char IDENTIFIER = '*';

    public ZeroOrMany(int maxLength) {
        super(maxLength);
    }

    public void operate(Stack<String> result) {
        super.operate(result, 0);
    }
}
