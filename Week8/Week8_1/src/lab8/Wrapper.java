package lab8;

import org.foosoft.lambdas.RandomTest;

import java.util.Random;

public class Wrapper {
    private static final char FIRST_LETTER = 'A';
    private static final int ALPHABET_SIZE = 'Z' - 'A' + 1;
    private int size;

    public Wrapper(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Cipherable makeFixedSelection() {
        return new FixedRandom();
    }

    public Cipherable makeFixedRandom() {
        return new FixedSelection();
    }

    private class FixedRandom implements Cipherable {

        @Override
        public Character[] getSecretChars(int seed) {
            Character[] result = new Character[size];
            Random random = new Random(seed);

            for (int i = 0; i < size; i++) {
                result[i] = randomChar(random);
            }

            return result;
        }
    }

    private class FixedSelection implements Cipherable {

        @Override
        public Character[] getSecretChars(int seed) {
            int originalSize = size;
            size = seed;
            FixedRandom randomArray = new FixedRandom();
            randomArray.getSecretChars(seed);
            size = originalSize;

            final Character[] characters = new Character[size];

            for (int i = 0; i < size; i++) {

            }
            return characters;
        }
    }

    private Character randomChar(Random random) {
        return (char) (FIRST_LETTER + random.nextInt(ALPHABET_SIZE));
    }
}
