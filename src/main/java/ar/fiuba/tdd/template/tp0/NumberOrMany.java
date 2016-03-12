package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

public abstract class NumberOrMany extends Operator {
    private int maxLength;
    private RandomGenerator randomGenerator = new RandomGenerator();

    public NumberOrMany(int maxLength) {
        this.maxLength = maxLength;
    }

    public void operate(Stack<String> result, int initialNumber) {
        String lastItem = result.pop();
        int amount = randomGenerator.getRandomInt(initialNumber, maxLength);
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < amount; i++) {
            buf.append(lastItem);
        }
        String res = buf.toString();
        result.push(res);
    }
}

