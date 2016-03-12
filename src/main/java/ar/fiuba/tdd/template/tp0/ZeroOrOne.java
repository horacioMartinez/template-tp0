package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

public class ZeroOrOne extends Operator {
    public static final char IDENTIFIER = '?';
    private RandomGenerator randomGenerator = new RandomGenerator();

    public void operate(Stack<String> result) {
        if (randomGenerator.getRandomBool()) {
            result.pop();
        }
    }
}