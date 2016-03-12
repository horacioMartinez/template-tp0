package ar.fiuba.tdd.template.tp0;


public class RandomGenerator {
    private static final int MIN_ASCII = 0;
    private static final int MAX_ASCII = 255;

    public int getRandomInt(int lowerBound, int upperBound) {
        return (lowerBound + (int) (Math.random() * ((upperBound - lowerBound) + 1)));
    }

    public char getRandomChar() {
        return (char) getRandomInt(MIN_ASCII, MAX_ASCII);
    }

    public boolean getRandomBool() {
        return getRandomInt(0, 1) == 1;
    }
}
