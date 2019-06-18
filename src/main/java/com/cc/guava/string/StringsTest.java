package com.cc.guava.string;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import org.junit.Test;

import java.nio.charset.Charset;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class StringsTest {

    @Test
    public void testStringsMethod() {
        assertNull(Strings.emptyToNull(""));
        assertEquals(Strings.nullToEmpty(null), "");
        assertEquals(Strings.nullToEmpty("hello"), "hello");
        assertEquals(Strings.commonPrefix("Hello", "Hit"), "H");
        assertEquals(Strings.commonPrefix("Hello", "Hit"), "");
        assertEquals(Strings.commonSuffix("Hello", "Echo"), "o");
        assertEquals(Strings.repeat("Alex", 3), "AlexAlexAlex");
        assertTrue(Strings.isNullOrEmpty(null));
        assertTrue(Strings.isNullOrEmpty(""));

        assertEquals(Strings.padStart("Alex",3,'H'), "Alex");
        assertEquals(Strings.padStart("Alex",5,'H'), "HAlex");
        assertEquals(Strings.padEnd("Alex",5,'H'), "AlexH");

    }

    @Test
    public void testCharsets() {
        Charset charset = Charset.forName("UTF-8");
        assertEquals(Charsets.UTF_8, charset);
    }

    /**
     * functor
     */
    @Test
    public void testCharMatcher() {
        assertTrue(CharMatcher.inRange('0','9').matches('5'));
        assertFalse(CharMatcher.inRange('0','9').matches('x'));

        assertEquals(CharMatcher.is('A').countIn("Alex Sharing the Google Guava to Us"), 1);
        assertEquals(CharMatcher.breakingWhitespace().collapseFrom("      hello Guava     ",'*'), "*hello*Guava*");
        assertEquals(CharMatcher.inRange('0','9').or(CharMatcher.whitespace()).removeFrom("hello 234 world"), "helloworld");
        assertEquals(CharMatcher.inRange('0','9').or(CharMatcher.whitespace()).retainFrom("hello 234 world")," 234 ");

    }

    public Integer text(){
        return 0;
    }
}