package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

public class ZeroOrMany extends Operator {
    public final static char IDENTIFIER = '*';
    private int maxLength;
    private RandomGenerator randomGenerator = new RandomGenerator();

    public ZeroOrMany(int maxLength) {
        this.maxLength = maxLength;
    }

    public void operate(Stack<String> result) {
        String lastItem = result.pop();
        int amount = randomGenerator.getRandomInt(0, maxLength);
        String res = "";
        for (int i = 0; i < amount; i++) {
            res += lastItem;
        }
        result.push(res);
    }
}
