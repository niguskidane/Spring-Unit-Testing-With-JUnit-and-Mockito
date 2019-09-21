package io.nk.unittestingwithjunitmockito.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class JsonPathTest {

    @Test
    public void jsonPathExampleTest(){
        String responseFromService="[" +
                "\t{\"id\":1000, \"name\":\"Pencil\", \"quantity\":5},\n" +
                "\t{\"id\":1001, \"name\":\"Pen\", \"quantity\":15},\n" +
                "\t{\"id\":1002, \"name\":\"Eraser\", \"quantity\":10}\n" +
                "]";

        DocumentContext context= JsonPath.parse(responseFromService);
        int length=context.read("$.length()");
        assertThat(length).isEqualTo(3);
        List<Integer> ids=context.read("$..id");

        assertThat(ids).containsExactly(1000,1001,1002);
        System.out.println(ids.toString());
        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:1]").toString());
        System.out.println(context.read("$.[?(@.name=='Eraser')]").toString());
        System.out.println(context.read("$.[?(@.quantity==5)]").toString());


    }
}
