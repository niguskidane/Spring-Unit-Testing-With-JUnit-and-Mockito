package io.nk.unittestingwithjunitmockito.Business;

import io.nk.unittestingwithjunitmockito.data.SomeDataService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// The Problem with creating a Stub, it's not maintainable
//that's when we need to use Mocking than using stub
class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retriveAllData() {
        return new int[]{1, 2, 3};
    }
}

class SomeDataServiceEmptyArrayStub implements SomeDataService {

    @Override
    public int[] retriveAllData() {
        return new int[]{};
    }
}

class SomeDataServiceStubOneValue implements SomeDataService {

    @Override
    public int[] retriveAllData() {
        return new int[]{10};
    }
}

public class SomeBusinessImplStubTest {

    SomeBusinessImpl business;

    @Before
    public void setUp() throws Exception {
        business = new SomeBusinessImpl();
    }

    @Test
    public void calculateSumUsingSomeDataServiceValidData() {
        business.setSomeDataService(new SomeDataServiceStub());
        int expectedSum = 6;
        int actualSum = business.calculateSumUsingSomeDataService();

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void calculateSumUsingSomeDataServiceWithEmpityArray() {
        business.setSomeDataService(new SomeDataServiceEmptyArrayStub());
        int expectedSum = 0;
        int actualSum = business.calculateSumUsingSomeDataService();

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void calculateSumUsingSomeDataServiceWithOneValue() {
        business.setSomeDataService(new SomeDataServiceStubOneValue());
        int expectedSum = 10;
        int actualSum = business.calculateSumUsingSomeDataService();

        assertEquals(expectedSum, actualSum);
    }

    @After
    public void tearDown() throws Exception {
        business = null;
    }
}