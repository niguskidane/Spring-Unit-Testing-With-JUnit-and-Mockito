package io.nk.unittestingwithjunitmockito.Business;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SomeBusinessImplTest {

    SomeBusinessImpl business;

    @Before
    public void setUp() throws Exception {
        business = new SomeBusinessImpl();
    }

    @Test
    public void calculateSumValidData() {
        int [] data={1,2,3};

        int expectedSum=6;
        int actualSum=business.calculateSum(data);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void calculateSumWithEmpityArray() {
        int [] data={};

        int expectedSum=0;
        int actualSum=business.calculateSum(data);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void calculateSumWithOneValue() {
        int [] data={10};

        int expectedSum=10;
        int actualSum=business.calculateSum(data);

        assertEquals(expectedSum, actualSum);
    }

    @After
    public void tearDown() throws Exception {
        business = null;
    }
}