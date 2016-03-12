package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RegExGenerator {
    private OperatorFactory operatorFactory;

    public RegExGenerator(int maxLength) {
        operatorFactory = new OperatorFactory(maxLength);
    }

    public String generate(String regEx) {
        Stack<String> operationsResult = new Stack<String>();
        char[] inputChars = regEx.toCharArray();

        boolean ignoreNext = false;

        for (int i = 0; i < inputChars.length; i++) {
            Operator op = operatorFactory.getOperator(inputChars[i]);
            if (op != null && !ignoreNext) {
                op.operate(operationsResult);
                ignoreNext = op.ignoreNext();
            } else {
                operationsResult.push("" + inputChars[i]);
                ignoreNext = false;
            }
        }

        String res = "";
        while (!operationsResult.empty()) {
            res += (operationsResult.pop());
        }
        return new StringBuilder(res).reverse().toString();
    }

    public List<String> generate(String regEx, int numberOfResults) {
        ArrayList<String> res = new ArrayList<String>();
        for (int j = 0; j < numberOfResults; j++)
            res.add(generate(regEx));
        return res;
    }
}