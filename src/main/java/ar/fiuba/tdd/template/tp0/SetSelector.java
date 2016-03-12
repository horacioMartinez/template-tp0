package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.Stack;

public class SetSelector extends Operator {
    public final static char IDENTIFIER = ']';
    private final static char OPEN_IDENTIFIER = '[';
    private RandomGenerator randomGenerator = new RandomGenerator();

    public void operate(Stack<String> result) {
        ArrayList<String> targetItems = new ArrayList<String>();
        boolean found = false;
        while (!result.empty() && !found) {
            String item = result.pop();
            if (item.equals("" + OPEN_IDENTIFIER))
                found = true;
            else
                targetItems.add(item);
        }

        if (!found)
            throw new RuntimeException("Invalid regEx, missing [");

        result.push(targetItems.get(randomGenerator.getRandomInt(0, targetItems.size() - 1)));
    }
}
