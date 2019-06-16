package com.cc.guava.util;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SplitterTest {

    @Test
    public void testSplitOnSplit(){
        List<String> result = Splitter.on("#").splitToList("google#guava#android#java");

        assertNotNull(result);
        assertEquals(result.size(), 4);
        assertEquals(result.get(0),"google");
    }


    @Test
    public void testSplitOnSplit_OmitEmpty(){
        List<String> result = Splitter.on("#").omitEmptyStrings().splitToList("google#guava###");

        assertNotNull(result);
        assertEquals(result.size(), 2);
        assertEquals(result.get(0),"google");
    }


    @Test
    public void testSplitOnSplit_TrimResult(){
        List<String> result = Splitter.on("#").omitEmptyStrings().trimResults().splitToList("   google  #   guava  ###");

        assertNotNull(result);
        assertEquals(result.size(), 2);
        assertEquals(result.get(0),"google");
    }

    @Test
    public void testFixedLength(){
        List<String> result = Splitter.fixedLength(4).splitToList("aaaabbbbccccdddd");

        assertNotNull(result);
        assertEquals(result.size(), 4);
        assertEquals(result.get(0),"aaaa");
        assertEquals(result.get(3),"dddd");
    }

    @Test
    public void testLimit(){
        List<String> result = Splitter.on("#").limit(3).splitToList("google#guava#android#java");

        assertNotNull(result);
        assertEquals(result.size(), 3);
        assertEquals(result.get(0),"google");
        assertEquals(result.get(2),"android#java");
    }


    @Test
    public void testSplitOnMap(){
        Map<String, String> result = Splitter.on("#")
                .trimResults()
                .omitEmptyStrings()
                .withKeyValueSeparator("=")
                .split("name=abc # age=18# height=193");

        assertNotNull(result);
        assertEquals(result.size(), 3);
        assertEquals(result.get("name"),"abc");
        assertEquals(result.get("height"),"193");
    }
}
