package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

public class OneOrMany extends Operator {
    public final static char IDENTIFIER = '+';
    private int maxLength;
    private RandomGenerator randomGenerator = new RandomGenerator();

    public OneOrMany(int maxLength) {
        this.maxLength = maxLength;
    }

    public void operate(Stack<String> result) {
        String lastItem = result.pop();
        int amount = randomGenerator.getRandomInt(1, maxLength);
        String res = "";
        for (int i = 0; i < amount; i++) {
            res += lastItem;
        }
        result.push(res);
    }
}