package com.cc.guava.collections;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListsTest {


    @Test
    public void testCartesianProduct(){
        List<List<String>> result = Lists.cartesianProduct(
                Lists.newArrayList("1", "2"),
                Lists.newArrayList("A", "B")
        );

        System.out.println(result);
    }


    @Test
    public void testTransform(){
        ArrayList<String> list = Lists.newArrayList("google", "guava", "java");
        List<String> result = Lists.transform(list, e -> e.toUpperCase());

        System.out.println(result);
    }

    @Test
    public void testNewArrayListWithCapacity(){
        ArrayList<String> result = Lists.newArrayListWithCapacity(10);
        result.add("x");
        result.add("y");
        result.add("z");
        System.out.println(result);
    }

    @Test
    public void testNewArrayListWithExpectedSize(){
        Lists.newArrayListWithExpectedSize(5);
    }


    @Test
    public void testReverse(){
        ArrayList<String> list = Lists.newArrayList("1", "2", "3");
        assertEquals(Joiner.on(",").join(list), "1,2,3");

        List<String> result = Lists.reverse(list);
        assertEquals(Joiner.on(",").join(result), "3,2,1");
    }

    @Test
    public void testPartition(){
        ArrayList<String> list = Lists.newArrayList("1", "2", "3", "4", "5");
        List<List<String>> result = Lists.partition(list, 2);
        System.out.println(result.get(0));
        System.out.println(result.get(1));
        System.out.println(result.get(2));
    }

}
