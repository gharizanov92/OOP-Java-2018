import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CypherTest {

    // if 5 different elements are entered -> list.size() should be 5
    // if 4 different and one duplicate elements are entered -> list.size() should be 4


    @Test
    public void testArray() {
        final ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(3);

        assertThat(arrayList, hasItems(1, 2, 3));

        //
        Scanner scanner = new Scanner(System.in);
        final Adder adder = new Adder();
        int nextInt;
        do {
            nextInt = scanner.nextInt();
            adder.addNumber(nextInt);
        } while (nextInt == 0);
    }

    @Test
    public void testGetAlphabetSize() {
        // given
        final int shiftLength = 5;
        final Cypher cypher = new Cypher(shiftLength);

        // when
        int alphabetSize = cypher.getAlphabetSize();

        // then
        assertThat("English alphabet contains 26 chars", alphabetSize, is(26));
    }

    @Test
    public void testCustomAlphabetSize() {
        // given
        final int shiftLength = 5;
        final Cypher cypher = new Cypher(shiftLength, 'A', 'C');

        // when
        int alphabetSize = cypher.getAlphabetSize();

        // then
        assertThat("English alphabet contains 26 chars", alphabetSize, is(3));
    }

    @Test
    public void testShift() {
        // given
        final int shiftLength = 3;
        final Cypher cypher = new Cypher(shiftLength);
        final char charToShift = 'A';
        final char expectedShitChar = 'D';

        // when
        final char result = cypher.shiftForward(charToShift);

        // then
        assertThat("A should be shifted to D", result, is(expectedShitChar));
    }

    @Test
    public void testShiftLowercase() {
        // given
        final int shiftLength = 3;
        final Cypher cypher = new Cypher(shiftLength);
        final char charToShift = 'a';
        final char expectedShitChar = 'd';

        // when
        final char result = cypher.shiftForward(charToShift);

        // then
        assertThat("a should be shifted to d", result, is(expectedShitChar));
    }

    @Test
    public void testShiftOverflow() {
        // given
        final int shiftLength = 1;
        final Cypher cypher = new Cypher(shiftLength);
        final char charToShift = 'Z';
        final char expectedShitChar = 'A';

        // when
        final char result = cypher.shiftForward(charToShift);

        // then
        assertThat("Z should be shifted to A", result, is(expectedShitChar));
    }

    @Test
    public void testShiftBack() {
        // given
        final int shiftLength = -1;
        final Cypher cypher = new Cypher(shiftLength);
        final char charToShift = 'A';
        final char expectedShitChar = 'Z';

        // when
        final char result = cypher.shiftForward(charToShift);

        // then
        assertThat("A should be shifted back to Z", result, is(expectedShitChar));
    }

    @Test
    public void testEncrypt() {
        // given
        final int shiftLength = 3;
        final Cypher cypher = new Cypher(shiftLength);
        final String plainText = "TOY";
        final String expectedEncryptedText = "WRB";

        // when
        final String encryptedResult = cypher.encrypt(plainText);

        // then
        assertThat("TOY should be encrypted to WRB",
                encryptedResult, is(expectedEncryptedText));
    }

    @Test
    public void testDecrypt() {
        // given
        final int shiftLength = 3;
        final Cypher cypher = new Cypher(shiftLength);
        final String encryptedText = "WRB";
        final String expectedDecryptedText = "TOY";

        // when
        final String encryptedResult = cypher.decrypt(encryptedText);

        // then
        assertThat("WRB should be encrypted to TOY",
                encryptedResult, is(expectedDecryptedText));
    }
}