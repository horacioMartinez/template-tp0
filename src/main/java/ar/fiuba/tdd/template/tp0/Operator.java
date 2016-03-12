package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

public abstract class Operator {

    public boolean ignoreNext() {
        return false;
    }

    public abstract void operate(Stack<String> result);

}