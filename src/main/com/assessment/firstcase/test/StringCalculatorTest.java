package com.assessment.firstcase.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.assessment.firstcase.StringCalculator;


public class StringCalculatorTest {

    StringCalculator obj;
    
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    
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
        assertEquals(5, obj.add("5"));
    }
    
    @Test
    public void testAddDouble() {
        assertEquals(5, obj.add("2,3"));
    }
    
    @Test 
    public void testAddN() {
        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage("Please pass only blank or single value string");
        assertEquals(10, obj.add("1,2,3,4"));
    }
}
