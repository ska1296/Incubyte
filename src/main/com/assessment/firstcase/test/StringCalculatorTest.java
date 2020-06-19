package com.assessment.firstcase.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.assessment.firstcase.StringCalculator;


public class StringCalculatorTest {

    StringCalculator obj;
    @Before
    public void setUp() throws Exception {
        obj = new StringCalculator();
    }

    @Test
    public void testAddBlank() {
        assertEquals(0, obj.add(""));
    }
    
    @Test
    public void testAddSingle() {
        assertEquals(1, obj.add("1"));
        assertNotEquals(0, obj.add("1"));
    }
}
