package com.cc.guava.string;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class JoinerTest {

    private final List<String> stringList = Arrays.asList(
            "google","guava","android","java"
    );

    private final List<String> stringListWithNullValue = Arrays.asList(
            "google","guava","android","java", null
    );


    @Test
    public void testJoinOnJoin(){
        String result = Joiner.on("#").join(stringList);
        assertEquals(result,"google#guava#android#java");
    }

    @Test
    public void testJoinWithNullValue(){
        String result = Joiner.on("#").join(stringListWithNullValue);
        assertEquals(result,"google#guava#android#java");
    }

    @Test
    public void testJoinSkipNulls(){
        String result = Joiner.on("#").skipNulls().join(stringListWithNullValue);
        assertEquals(result,"google#guava#android#java");
    }

    @Test
    public void testJoinSkipUseDefault(){
        String result = Joiner.on("#").useForNull("DEFAULT").join(stringListWithNullValue);
        assertEquals(result,"google#guava#android#java#DEFAULT");
    }

    @Test
    public void testJoinOnAppend(){
        StringBuilder builder = new StringBuilder();
        StringBuilder result = Joiner.on("#").skipNulls().appendTo(builder, stringListWithNullValue);
        assertSame(builder, result);
        assertEquals(result.toString(), "google#guava#android#java");
    }


    /**
     *     JDK8 stream方式
     */
    @Test
    public void testJoinByStream(){
        String result = stringListWithNullValue.stream().filter(item -> item != null && !item.isEmpty()).collect(Collectors.joining("#"));
        assertEquals(result,"google#guava#android#java");
    }

}
