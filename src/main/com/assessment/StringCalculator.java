package com.assessment;

public class StringCalculator {
    
    public int add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        int sum = 0;
        numbers = numbers.replace("\n", ",");
        if (numbers.contains(",")) {
            String [] input = numbers.split(",");
            for (String eachNum : input) {
                sum+=Integer.parseInt(eachNum.trim());
            }
        } else
            return Integer.parseInt(numbers);
        
        return sum;
    }

}