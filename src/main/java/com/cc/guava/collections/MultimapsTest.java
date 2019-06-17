package com.cc.guava.collections;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class MultimapsTest {

    @Test
    public void testBasic() {
        LinkedListMultimap<String, String> multipleMap = LinkedListMultimap.create();
        HashMap<String, String> hashMap = Maps.newHashMap();
        hashMap.put("1", "1");
        hashMap.put("1", "2");
        assertEquals(hashMap.size(), 1);


        multipleMap.put("1", "1");
        multipleMap.put("1", "2");
        assertEquals(multipleMap.size(), 2);
        System.out.println(multipleMap.get("1"));
    }
}
