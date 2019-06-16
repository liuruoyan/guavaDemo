package com.cc.guava.util;


import org.junit.Test;

import java.util.List;

import static com.google.common.base.Preconditions.*;
import static org.junit.Assert.*;

public class PreconditionsTest {


    @Test(expected = NullPointerException.class)
    public void testCheckNotNull(){
        check(null);
    }

    private void check(List<String> list){
        checkNotNull(list);
    }

    @Test
    public void testCheckNotNullWithMsg(){
        try{
            checkWithMsg(null);
        }catch (Exception e){
            assertEquals(e.getClass(), NullPointerException.class);
            assertEquals(e.getMessage(), "list must not be null!");
        }
    }

    private void checkWithMsg(List<String> list){
        checkNotNull(list, "list must not be null!");
    }

}
