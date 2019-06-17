package com.cc.guava.collections;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FluentIterableTest {


    private FluentIterable<String> build(){
        ArrayList<String> list = Lists.newArrayList("google", "guava", "java", "c++");
        return FluentIterable.from(list);
    }

    @Test
    public void testFilter(){
        FluentIterable<String> fit = build();
        assertEquals(fit.size() , 4);

        FluentIterable<String> result = fit.filter(e -> e != null && e.length() > 4);
        assertEquals(result.size(), 2);
    }


    @Test
    public void testAppend(){
        FluentIterable<String> fit = build();
        assertEquals(fit.size() , 4);

        ArrayList<String> append = Lists.newArrayList("APPEND");
        FluentIterable<String> afit = fit.append(append);
        assertEquals(afit.size() , 5);
        assertEquals(afit.contains("APPEND"), true);

        FluentIterable<String> afit2 = afit.append("APPEND2");
        assertEquals(afit2.size() , 6);
        assertEquals(afit2.contains("APPEND2"), true);
        assertEquals(afit2.contains("guava"), true);
    }

    @Test
    public void testMatch(){
        FluentIterable<String> fit = build();
        assertEquals(fit.size() , 4);

        boolean result = fit.allMatch(e -> e != null && e.length() >= 4);
        assertEquals(result, false);


        boolean result2 = fit.anyMatch(e -> e != null && e.length() == 5);
        assertEquals(result2, true);

        Optional<String> optional = fit.firstMatch(e -> e != null && e.length() == 5);
        assertEquals(optional.isPresent(), true);
        assertEquals(optional.get(), "guava");
    }



    @Test
    public void testFirstLast(){
        FluentIterable<String> fit = build();
        assertEquals(fit.size() , 4);

        Optional<String> first = fit.first();

        Optional<String> last = fit.last();

    }


    @Test
    public void testLimit(){
        FluentIterable<String> fit = build();
        assertEquals(fit.size() , 4);

        FluentIterable<String> result = fit.limit(3);
        assertEquals(result.contains("c++"), false);

        FluentIterable<String> result2 = fit.limit(300);
        assertEquals(result2.contains("c++"), true);
    }


    @Test
    public void testCopyIn(){
        FluentIterable<String> fit = build();
        assertEquals(fit.size() , 4);

        ArrayList<String> list = Lists.newArrayList("Go");
        ArrayList<String> result = fit.copyInto(list);

        assertEquals(result.contains("java"), true);
        assertEquals(result.size(), 5);

    }


    @Test
    public void testCycle(){
        FluentIterable<String> fit = build();
        assertEquals(fit.size() , 4);

        FluentIterable<String> cycle = fit.cycle().limit(100);
        cycle.forEach(System.out::println);
    }


    @Test
    public void testTransForm(){
        FluentIterable<String> fit = build();
        assertEquals(fit.size() , 4);

        FluentIterable<Integer> result = fit.transform(e -> e.length());

        result.forEach(System.out::println);

    }

    @Test
    public void testTransFromAndConcat(){
        FluentIterable<Integer> fit = FluentIterable.from(Lists.newArrayList(1,2,3,4));
        assertEquals(fit.size() , 4);

        FluentIterable<Integer> result = fit.transformAndConcat(e -> compute(e));

        result.forEach(System.out::println);


    }

    private List<Integer> compute(int i){
        return Lists.newArrayList(i*1,i*2,i*3,i*4);
    }



    @Test
    public void testJoin(){
        FluentIterable<String> fit = build();
        assertEquals(fit.size() , 4);

        String result = fit.join(Joiner.on(','));
        assertEquals(result, "google,guava,java,c++");
    }

}
