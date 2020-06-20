package com.assessment.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.assessment.StringCalculator;


public class StringCalculatorTest {

    StringCalculator obj;
    private static final String NO_NEGATIVES = "negatives not allowed.";
    
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    
    @Before
    public void setUp() {
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
    
    @Test
    public void testAddNegative() {
        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage(NO_NEGATIVES);
        exceptionRule.expectMessage("-4");
        assertEquals(2, obj.add("1,2,3,-4"));
        
        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage(NO_NEGATIVES);
        exceptionRule.expectMessage("-1");
        assertEquals(-1, obj.add("-1"));
    }
    
    @Test
    public void testAddMultipleNegatives() {
        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage(NO_NEGATIVES);
        exceptionRule.expectMessage("-19, -4, -21");
        assertEquals(-38, obj.add("-19,2,3,-4,-21,1"));
    }
    
    @Test
    public void testCallAddCount() {
        assertEquals(6, obj.add("//,\n1,2,3"));
        assertEquals(10, obj.add("1,2,3,4"));
        assertEquals(15, obj.add("3,5,7"));
        assertEquals(3, obj.getCalledCount());
        assertEquals(0, obj.add(""));
        assertEquals(0, obj.add("0"));
        assertEquals(5, obj.getCalledCount());
    }
    
    @Test
    public void testAddGreaterThanThousand() {
        assertEquals(0, obj.add("1001"));
        assertEquals(1000, obj.add("1000"));
        assertEquals(2, obj.add("2,1001"));
    }
    
    @Test
    public void testAddLengthyDelimiter() {
        assertEquals(6, obj.add("//[***]\n1***2***3"));
        assertEquals(10, obj.add("//[\n\n\n\n]\n1\n\n\n\n2\n\n\n\n3\n\n\n\n4"));
    }
}
