package lab8;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WrapperTest {

    @Test
    public void testGeneratesCorrectSize() {
        // given
        final int expectedSize = (int) (Math.random() * 100);
        final int randomSeed = (int) (Math.random() * 100);
        final Wrapper wrapper = new Wrapper(expectedSize);
        final Cipherable cipherable = wrapper.makeFixedSelection();

        // when
        final Character[] secretChars = cipherable.getSecretChars(randomSeed);

        // then
        assertThat(String.format("Has %d randomly generated characters", expectedSize),
                secretChars.length, is(expectedSize));
    }
}