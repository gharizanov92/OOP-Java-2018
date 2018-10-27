public class Cypher {
    public final int SHIFT_LENGTH;
    public final char FIRST_LETTER_OF_ALPHABET;
    public final char LAST_LETTER_OF_ALPHABET;

    public Cypher(final int SHIFT_LENGTH) {
        this(SHIFT_LENGTH, 'A', 'Z');
    }

    public Cypher(int SHIFT_LENGTH, char FIRST_LETTER_OF_ALPHABET, char LAST_LETTER_OF_ALPHABET) {
        this.SHIFT_LENGTH = SHIFT_LENGTH;
        this.FIRST_LETTER_OF_ALPHABET = FIRST_LETTER_OF_ALPHABET;
        this.LAST_LETTER_OF_ALPHABET = LAST_LETTER_OF_ALPHABET;
    }

    public String encryptPlainText(final String plainText) {
        final char[] charArray = plainText.toCharArray();
        final char[] encrytedCharArray = new char[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            encrytedCharArray[i] = shiftForward(charArray[i]);
        }

        return new String(encrytedCharArray);
    }

    public String decryptText(final String encrypted) {
        final char[] charArray = encrypted.toCharArray();
        final char[] decryptedCharArray = new char[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            decryptedCharArray[i] = shiftBackward(charArray[i]);
        }

        return new String(decryptedCharArray);
    }

    public char shiftForward(final char originalChar) {
        return shift(originalChar, SHIFT_LENGTH);
    }

    public char shiftBackward(final char originalChar) {
        return shift(originalChar, -SHIFT_LENGTH);
    }

    public char shift(final char originalChar, int shift) {
        char firstChar = 'a';
        if (isUpperCase(originalChar)) {
            firstChar = 'A';
        }

        int alphabetSize = getAlphabetSize();
        int ASCIpos = (int) originalChar + shift;
        int delta = (ASCIpos - firstChar) % alphabetSize;

        if (delta < 0) {
            delta = alphabetSize + delta;
        }

        return (char) (firstChar + delta);
    }

    public boolean isUpperCase(final char originalChar) {
        return (int) originalChar >= 'A' && (int) originalChar <= 'Z';
    }

    public int getShiftLength() {
        return SHIFT_LENGTH;
    }

    public char getFirstLetterOfAlphabet() {
        return FIRST_LETTER_OF_ALPHABET;
    }

    public char getLastLetterOfAlphabet() {
        return LAST_LETTER_OF_ALPHABET;
    }

    public int getAlphabetSize() {
        return LAST_LETTER_OF_ALPHABET - FIRST_LETTER_OF_ALPHABET + 1;
    }
}
