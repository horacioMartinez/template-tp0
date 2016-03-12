package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

public class ZeroOrOne extends Operator {
    private RandomGenerator randomGenerator = new RandomGenerator();
    public final static char IDENTIFIER = '?';

    public void operate(Stack<String> result) {
        if (randomGenerator.getRandomBool())
            result.pop();
    }
}