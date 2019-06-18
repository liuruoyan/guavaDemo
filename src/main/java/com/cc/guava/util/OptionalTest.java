package com.cc.guava.util;

import com.google.common.base.Optional;
import org.junit.Test;

import static org.junit.Assert.*;

public class OptionalTest {

    @Test
    public void testNotNull(){
        Integer i = 5;
        Optional<Integer> possible = Optional.of(i);
        assertTrue(possible.isPresent());
        assertEquals(possible.get(), Integer.valueOf(5));
        assertEquals(possible.or(10), Integer.valueOf(5));
    }

    @Test(expected = NullPointerException.class)
    public void testNull(){
        Integer i = null;
        Optional<Integer> possible = Optional.of(i);
    }

    @Test
    public void testNull2(){
        Integer i = null;
        Optional<Integer> possible = Optional.fromNullable(i);

        assertFalse(possible.isPresent());
        assertEquals(possible.or(10), Integer.valueOf(10));
    }


    @Test
    public void testNull3(){
        Optional<Integer> possible = Optional.absent();

        assertFalse(possible.isPresent());
        assertEquals(possible.or(10), Integer.valueOf(10));
    }


}
