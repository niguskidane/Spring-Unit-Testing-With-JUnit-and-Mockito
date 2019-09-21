package io.nk.unittestingwithjunitmockito.spike;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class AssertJTest {

    @Test
    public void testExamples() {
        List<Integer> numbers = Arrays.asList(12, 15, 45);

//        assertThat(numbesr, hasSize(3));
//        assertThat(numbesr, hasItems(12, 15));
//        assertThat(numbesr, everyItem(greaterThan(10)));
//        assertThat(numbesr, everyItem(lessThan(100)));

        //The equivalent code using AssertJ
        //AssertJ is more efficient

        assertThat(numbers)
                .hasSize(3)
                .contains(12, 15)
                .allMatch(x -> x > 10)
                .allMatch(x -> x < 100);

//        assertThat("", isEmptyString());

        //The equivalent code using AssertJ
        //AssertJ is more efficient
        assertThat("").isEmpty();


//        assertThat("ABCD", containsString("BC"));
//        assertThat("ABCD", startsWith("AB"));
//        assertThat("ABCD", endsWith("CD"));

        //The equivalent code using AssertJ
        //AssertJ is more efficient
        assertThat("ABCD").startsWith("AB").endsWith("CD");


    }
}
