package com.assessment.firstcase.test;

import org.junit.jupiter.api.Test;

import com.assessment.firstcase.StringCalculator;

import junit.framework.TestCase;


class StringCalculatorTest extends TestCase {
    
    private StringCalculator obj;
    
    @Override
    protected void setUp() throws Exception {
        obj = new StringCalculator();
        super.setUp();
    }
    
    @Test
    void testAddBlank() {
        assertEquals(0, obj.add(""));
    }

}
