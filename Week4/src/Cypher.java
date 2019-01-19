public class Cypher {
    private final int CYPHER_LENGTH;
    private final char FIRST_LETTER;
    private final char LAST_LETTER;

    public Cypher(int cypherLength) {
        this(cypherLength, 'A', 'Z');
    }

    public Cypher(int cypherLength, char firstLetter, char lastLetter) {
        CYPHER_LENGTH = cypherLength;
        FIRST_LETTER = firstLetter;
        LAST_LETTER = lastLetter;
    }

    public String encrypt(final String plainText) {
        final char[] textArray = plainText.toCharArray();
        final char[] resultArray = new char[textArray.length];

        for (int i = 0; i < textArray.length; i++) {
            resultArray[i] = shiftForward(textArray[i]);
        }

        return new String(resultArray);
    }

    public char shiftForward(final char c) {
        return shift(c, CYPHER_LENGTH);
    }

    public char shiftBackwards(final char c) {
        return shift(c, -CYPHER_LENGTH);
    }

    public char shift(final char c, final int len) {
        char firstLetter = 'A';

        if (isLowercase(c)) {
            firstLetter = 'a';
        }

        final int alphabetSize = getAlphabetSize();
        int delta = ((int) c + len) - firstLetter;

        if (delta < 0) {
            delta = alphabetSize + delta;
        }

        delta = delta % alphabetSize;

        return (char) (firstLetter + delta);
    }

    private boolean isLowercase(char c) {
        return (int) c >= 'a' && (int) c <= 'z';
    }

    public int getAlphabetSize() {
        return LAST_LETTER - FIRST_LETTER + 1;
    }

    public String decrypt(String encryptedText) {
        final char[] textArray = encryptedText.toCharArray();
        final char[] resultArray = new char[textArray.length];

        for (int i = 0; i < textArray.length; i++) {
            resultArray[i] = shiftBackwards(textArray[i]);
        }

        return new String(resultArray);
    }
}
