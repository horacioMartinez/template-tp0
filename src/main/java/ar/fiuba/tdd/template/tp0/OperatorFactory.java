package ar.fiuba.tdd.template.tp0;

public class OperatorFactory {
    private int maxLength;

    public OperatorFactory(int maxLength) {
        this.maxLength = maxLength;
    }

    public Operator getOperator(char input) {

        if (input == Escape.IDENTIFIER)
            return new Escape();
        if (input == ZeroOrMany.IDENTIFIER)
            return new ZeroOrMany(maxLength);
        if (input == OneOrMany.IDENTIFIER)
            return new OneOrMany(maxLength);
        if (input == SetSelector.IDENTIFIER)
            return new SetSelector();
        if (input == AnyCharacter.IDENTIFIER)
            return new AnyCharacter();
        if (input == ZeroOrOne.IDENTIFIER)
            return new ZeroOrOne();
        return null;
    }
}
