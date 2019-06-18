package com.cc.guava.range;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.NavigableMap;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class RangeTest {

    /**
     * {x|a<=x<=b}
     */
    @Test
    public void testClosedRange() {
        Range<Integer> closedRange = Range.closed(0, 9);
        System.out.println(closedRange);

        assertTrue(closedRange.contains(5));
        assertEquals(closedRange.lowerEndpoint(), Integer.valueOf(0));
        assertEquals(closedRange.upperEndpoint(), Integer.valueOf(9));


    }

    /**
     * {x|a<x<b}
     */
    @Test
    public void testOpenRange() {
        Range<Integer> openRange = Range.open(0, 9);
        System.out.println(openRange);

        assertTrue(openRange.contains(5));
        assertEquals(openRange.lowerEndpoint(), Integer.valueOf(0));
        assertEquals(openRange.upperEndpoint(), Integer.valueOf(9));
        assertFalse(openRange.contains(0));
        assertFalse(openRange.contains(9));
    }

    /**
     * {x|a<x<=b}
     */
    @Test
    public void testOpenClosedRange() {
        Range<Integer> openClosedRange = Range.openClosed(0, 9);
        System.out.println(openClosedRange);


        assertTrue(openClosedRange.contains(5));
        assertEquals(openClosedRange.lowerEndpoint(), Integer.valueOf(0));
        assertEquals(openClosedRange.upperEndpoint(), Integer.valueOf(9));
        assertFalse(openClosedRange.contains(0));
        assertTrue(openClosedRange.contains(9));
    }


    /**
     * {x|a<=x<b}
     */
    @Test
    public void testClosedOpenRange() {
        Range<Integer> closedOpen = Range.closedOpen(0, 9);
        System.out.println(closedOpen);

        assertTrue(closedOpen.contains(5));
        assertEquals(closedOpen.lowerEndpoint(), Integer.valueOf(0));
        assertEquals(closedOpen.upperEndpoint(), Integer.valueOf(9));
        assertTrue(closedOpen.contains(0));
        assertFalse(closedOpen.contains(9));
    }

    /**
     * {x|x>a}
     */
    @Test
    public void testGreaterThan() {
        Range<Integer> range = Range.greaterThan(10);

        assertFalse(range.contains(10));
        assertTrue(range.contains(Integer.MAX_VALUE));
    }

    @Test
    public void testMapRange() {
        TreeMap<String, Integer> treeMap = Maps.newTreeMap();

        treeMap.put("Scala", 1);
        treeMap.put("Guava", 2);
        treeMap.put("Java", 3);
        treeMap.put("Kafka", 4);
        System.out.println(treeMap);

        NavigableMap<String, Integer> result = Maps.subMap(treeMap, Range.openClosed("Guava", "Java"));
        System.out.println(result);
    }

    @Test
    public void testOtherMethod() {
        Range<Integer> atLeastRange = Range.atLeast(2);
        System.out.println(atLeastRange);
        assertTrue(atLeastRange.contains(2));
        System.out.println(Range.lessThan(10));
        System.out.println(Range.atMost(5));
        System.out.println(Range.all());
        System.out.println(Range.downTo(10, BoundType.CLOSED));
        System.out.println(Range.upTo(10, BoundType.CLOSED));
    }

    @Test
    public void testRangeMap() {
        RangeMap<Integer, String> gradeScale = TreeRangeMap.create();
        gradeScale.put(Range.closed(0, 60), "E");
        gradeScale.put(Range.closed(61, 70), "D");
        gradeScale.put(Range.closed(71, 80), "C");
        gradeScale.put(Range.closed(81, 90), "B");
        gradeScale.put(Range.closed(91, 100), "A");

        assertEquals(gradeScale.get(77), "C");
    }
}
