package com.assessment.firstcase;

public class StringCalculator {
    
    public int add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        
        if (!numbers.isEmpty())
            try {
                return Integer.parseInt(numbers);
            } catch (NumberFormatException e) {
                //throws exception at the end of the method
            }
        
        throw new UnsupportedOperationException("Please pass only blank or single value string");
    }

}
