package io.nk.unittestingwithjunitmockito.Business;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;


import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    private List mock = mock(List.class);

    @Test
    public void testSizeBasic() {
        when(mock.size()).thenReturn(3);
        assertEquals(3, mock.size());
    }

    @Test
    public void testReturnDifferentValue() {
        when(mock.size()).thenReturn(5).thenReturn(10);

        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void testReturnWithParameter() {
        when(mock.get(0)).thenReturn("Nigus");
        assertEquals("Nigus", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    public void testReturnWithGenericParameter() {
        when(mock.get(anyInt())).thenReturn("Nigus");
        assertEquals("Nigus", mock.get(0));
        assertEquals("Nigus", mock.get(1));
    }


    @Test
    public void testVerificationBasic() {
        //SUT
        Object value1=mock.get(0);
        Object value2=mock.get(1);

        //Verify
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing(){
        //SUT
        mock.add("SomeString");

        //verification
        ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing(){
        //SUT
        mock.add("SomeString1");
        mock.add("SomeString2");

        //verification
        ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());
        List<String> allValues=captor.getAllValues();

        assertEquals("SomeString1",allValues.get(0) );
        assertEquals("SomeString2",allValues.get(1) );
    }


    @Test
    public void mocking(){
        ArrayList arrayListMock=mock(ArrayList.class);

        System.out.println(arrayListMock.get(0));//null
        System.out.println(arrayListMock.size());//0
        System.out.println(arrayListMock.add("Test"));
        System.out.println(arrayListMock.add("Test"));
        System.out.println(arrayListMock.size());
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());

    }

    @Test
    public void spying(){
        ArrayList arrayListSpy=spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0));//null
        System.out.println(arrayListSpy.size());//0
        System.out.println(arrayListSpy.add("Test"));
        System.out.println(arrayListSpy.add("Test"));
        System.out.println(arrayListSpy.size());
        //the size value is set to 5 so if you call size method after this it will print only 5
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());

        System.out.println(arrayListSpy.add("Test4"));
        System.out.println(arrayListSpy.size());

        verify(arrayListSpy).add("Test4");
    }
}
