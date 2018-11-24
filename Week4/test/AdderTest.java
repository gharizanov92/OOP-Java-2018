import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AdderTest {

    @Test
    public void add() {
        // given
        int a1 = 5;
        int a2 = 10;
        int expectedResult = 15;

        // when
        int result = Adder.add(a1, a2);

        // then
        assertThat("5 + 10 should be 15", result, is(expectedResult));
    }

    @Test
    public void testWouldNotAddDuplicateNumber() {
        // given
        final Adder adder = new Adder();
        final int sameNumber = 1;
        final int randomTimes = (int) (Math.random() * 10) + 5;

        // when
        for (int i = 0; i < randomTimes; i++) {
            adder.addNumber(sameNumber);
        }

        // then
        final ArrayList<Integer> resultingList = adder.getArrayList();
        assertThat("List should contain the number",
                resultingList, hasItems(1));
        assertThat("List should contain the number",
                resultingList.size(), is(1));
    }
}