package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

public class Escape extends Operator {

    public static final char IDENTIFIER = '\\';

    public void operate(Stack<String> result) {
    }

    @Override
    public boolean ignoreNext() {
        return true;
    }
}
