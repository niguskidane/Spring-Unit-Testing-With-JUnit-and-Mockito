package io.nk.unittestingwithjunitmockito.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse="{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpace() throws JSONException {
        String expectedResponse="{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

        // true represents a Strict check
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }


    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        //even though the quantity is removed the test passed because strict value is false
        String expectedResponse="{\"id\":1,\"name\":\"Ball\",\"price\":10}";

        // true represents a Strict check
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_WithOutScapeCharacter() throws JSONException {
        //even though the quantity is removed the test passed because strict value is false
        String expectedResponse="{id:1,name:Ball,price:10}";

        // true represents a Strict check
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
