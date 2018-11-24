import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CypherTest {

    @Test
    public void testFullEnglishAlphabetSize() {
        // given
        final int randomShift = getRandomInt(10);
        final char firstLetter = 'A';
        final char lastLetter = 'Z';
        final Cypher cypher = new Cypher(randomShift, firstLetter, lastLetter);

        // when
        final int alphabetSize = cypher.getAlphabetSize();

        // then
        assertThat("English alphabet must contain 26 letters", alphabetSize, is(26));
    }

    @Test
    public void testPartialFullEnglishAlphabetSize() {
        // given
        final int randomShift = getRandomInt(10);
        final char firstLetter = 'A';
        final char lastLetter = 'C';
        final Cypher cypher = new Cypher(randomShift, firstLetter, lastLetter);

        // when
        final int alphabetSize = cypher.getAlphabetSize();

        // then
        assertThat("English alphabet must contain 26 letters", alphabetSize, is(3));
    }

    @Test
    public void testSampleEncrypt() {
        // given
        final Cypher cypher = new Cypher(3);
        final String plainText = "TOY";
        final String expectedOutput = "WRB";

        // when
        final String result = cypher.encryptPlainText(plainText);

        // then
        assertThat("TOY should be encrypted to WRB", result, is(expectedOutput));
    }

    @Test
    public void testSampleDecrypt() {
        // given
        final Cypher cypher = new Cypher(3);
        final String encryptedText = "WRB";
        final String expectedPlainText = "TOY";

        // when
        final String result = cypher.decryptText(encryptedText);

        // then
        assertThat("WRB should be encrypted to TOY", result, is(expectedPlainText));
    }

    @Test
    public void testShiftAByOne() {
        // given
        final int shiftLength = 1;
        final Cypher cypher = new Cypher(shiftLength);
        final char originalChar = 'A';
        final char expectedChar = 'B';

        // when
        final char result = cypher.shiftForward(originalChar);

        // then
        assertThat("A should be shifted to B", result, is(expectedChar));
    }

    @Test
    public void testShiftZByOne() {
        // given
        final int shiftLength = 1;
        final Cypher cypher = new Cypher(shiftLength);
        final char originalChar = 'Z';
        final char expectedChar = 'A';

        // when
        final char result = cypher.shiftForward(originalChar);

        // then
        assertThat("Z should be shifted to A", result, is(expectedChar));
    }

    @Test
    public void testShiftLowercase() {
        // given
        final int shiftLength = 1;
        final Cypher cypher = new Cypher(shiftLength);
        final char originalChar = 'a';
        final char expectedChar = 'b';

        // when
        final char result = cypher.shiftForward(originalChar);

        // then
        assertThat("a should be shifted to b", result, is(expectedChar));
    }

    @Test
    public void testShiftABackByTwo() {
        // given
        final int shiftLength = -2;
        final Cypher cypher = new Cypher(shiftLength);
        final char originalChar = 'A';
        final char expectedChar = 'Y';

        // when
        final char result = cypher.shiftForward(originalChar);

        // then
        assertThat("A should be shifted to B", result, is(expectedChar));
    }

    @Test
    public void testIsUppercase() {
        // given
        final char lowerCaseChar = 'a';
        final char upperCaseChar = 'A';
        final int shiftLength = 0;
        final Cypher cypher = new Cypher(shiftLength);

        // when
        boolean lowerCase = cypher.isUpperCase(lowerCaseChar);
        boolean upperCase = cypher.isUpperCase(upperCaseChar);

        // then
        assertThat(upperCase, is(true));
        assertThat(lowerCase, is(false));
    }

    private int getRandomInt(int range) {
        return (int) (Math.random() * range);
    }
}