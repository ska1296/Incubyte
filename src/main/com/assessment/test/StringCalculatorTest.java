package com.assessment.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.assessment.StringCalculator;


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
        assertEquals(10, obj.add("1,2,3,4"));
        assertEquals(40, obj.add("1,2,3,4,10,20"));
        assertEquals(15, obj.add("3,5,7"));
    }
    
    @Test
    public void testAddNewLines() {
        assertEquals(10, obj.add("1\n2,3,4"));
        assertEquals(10, obj.add("1\n2,3\n4"));
    }
    
    @Test
    public void testAddInputDelimeter() {
        assertEquals(3, obj.add("//;\n1;2"));
        assertEquals(3, obj.add("//\n\n1\n2"));
        assertEquals(6, obj.add("//,\n1,2,3"));
    }
}
