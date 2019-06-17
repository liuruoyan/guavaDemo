package com.cc.guava.collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class BiMapTest {


    @Test
    public void testCreateAndPut() {
        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("1", "2");
        biMap.put("1", "3");
        assertEquals(biMap.containsKey("1"), true);
        assertEquals(biMap.size(), 1);

        try {
            biMap.put("2", "3");
            fail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBiMapInverse() {
        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("one", "1");
        biMap.put("two", "2");
        biMap.put("three", "3");

        assertEquals(biMap.containsKey("one"), true);
        assertEquals(biMap.containsKey("two"), true);
        assertEquals(biMap.containsKey("three"), true);
        assertEquals(biMap.size(), 3);

        BiMap<String, String> inverseKey = biMap.inverse();
        assertEquals(inverseKey.containsKey("1"), true);
        assertEquals(inverseKey.containsKey("2"), true);
        assertEquals(inverseKey.containsKey("3"), true);
        assertEquals(inverseKey.size(), 3);

    }

    @Test
    public void testCreateAndForcePut() {
        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("1", "2");
        assertEquals(biMap.containsKey("1"), true);
        biMap.forcePut("2", "2");
        assertEquals(biMap.containsKey("1"), false);
        assertEquals(biMap.containsKey("2"), true);
    }


}
