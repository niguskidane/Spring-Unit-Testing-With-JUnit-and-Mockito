package io.nk.unittestingwithjunitmockito.spike;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class HamcrestMachersTest {

    @Test
    public void testExamples(){
        List<Integer> numbesr= Arrays.asList(12,15,45);

        assertThat(numbesr, hasSize(3));
        assertThat(numbesr, hasItems(12,15));
        assertThat(numbesr, everyItem(greaterThan(10)));
        assertThat(numbesr, everyItem(lessThan(100)));

        assertThat("", isEmptyString());
        assertThat("ABCD", containsString("BC"));
        assertThat("ABCD", startsWith("AB"));
        assertThat("ABCD", endsWith("CD"));
    }
}
