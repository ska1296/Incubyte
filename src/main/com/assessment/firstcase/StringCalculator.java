package com.assessment.firstcase;

public class StringCalculator {
    
    public int add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        
        if (numbers.contains(",")) {
            String [] input = numbers.split(",");
            if (input.length == 2) {
                try {
                    return Integer.parseInt(input[0])+Integer.parseInt(input[1]);
                } catch (NumberFormatException e) {
                    //throws exception at the end of the method
                }
            } else
                throw new UnsupportedOperationException("Please pass only blank or single value string");
        } else
            return Integer.parseInt(numbers);
        
        throw new UnsupportedOperationException("Please pass only blank or single value string");
    }

}
