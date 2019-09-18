package io.nk.unittestingwithjunitmockito.Business;

import io.nk.unittestingwithjunitmockito.data.SomeDataService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockTest {

    @InjectMocks
    private SomeBusinessImpl business;
    @Mock
    private SomeDataService dataServiceMock;

    //So We Don't need this
//    @Before
//    public void setUp() throws Exception {
//        business = new SomeBusinessImpl();
//        dataServiceMock = mock(SomeDataService.class);
//        business.setSomeDataService(dataServiceMock);
//    }

    @Test
    public void calculateSumUsingSomeDataServiceValidData() {
        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{1, 2, 3});
        int expectedSum = 6;
        int actualSum = business.calculateSumUsingSomeDataService();

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void calculateSumUsingSomeDataServiceWithEmpityArray() {

        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{});
        int expectedSum = 0;
        int actualSum = business.calculateSumUsingSomeDataService();

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void calculateSumUsingSomeDataServiceWithOneValue() {
        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{10});

        int expectedSum = 10;
        int actualSum = business.calculateSumUsingSomeDataService();

        assertEquals(expectedSum, actualSum);
    }

//    @After
//    public void tearDown() throws Exception {
//        business = null;
//        dataServiceMock = null;
//    }
}