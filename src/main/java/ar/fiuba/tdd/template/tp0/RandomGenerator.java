package ar.fiuba.tdd.template.tp0;


public class RandomGenerator {
    private static final int MIN_ASCII = 0;
    private static final int MAX_ASCII = 255;
    private static final int[] INVALIDS_ASCII = {10, 13, 133};

    private boolean isValidAscii(int number) {
        if ((number < MIN_ASCII) || (number > MAX_ASCII)) {
            return false;
        }
        for (int i = 0; i < INVALIDS_ASCII.length; i++) {
            if (number == INVALIDS_ASCII[i]) {
                return false;
            }
        }
        return true;
    }

    public int getRandomInt(int lowerBound, int upperBound) {
        return (lowerBound + (int) (Math.random() * ((upperBound - lowerBound) + 1)));
    }

    public char getRandomChar() {
        int res = getRandomInt(MIN_ASCII, MAX_ASCII);
        while (!isValidAscii(res)) {
            res = getRandomInt(MIN_ASCII, MAX_ASCII);
        }
        return (char) res;
    }

    public boolean getRandomBool() {
        return getRandomInt(0, 1) == 1;
    }
}
